package com.woniuxy.vlife.apigateway.filters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.woniuxy.vlife.apigateway.common.JWTHelper;
import com.woniuxy.vlife.apigateway.common.Result;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class AuthFilter extends ZuulFilter {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {

        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String requestURI = request.getRequestURI();
        boolean isLoginRequest = new AntPathMatcher().match("/login", requestURI);
        log.info("请求路径：{},拦截{}",requestURI,!isLoginRequest);
        return !isLoginRequest;
    }

    @Override
    public Object run() throws ZuulException {
        //校验
        RequestContext ctx = RequestContext.getCurrentContext();
        //得到请求头中的auth_token
        String authToken = ctx.getRequest().getHeader("auth_token");
        log.info("authToken：{}",authToken);

        try {
            Claims claims = JWTHelper.parseJWT(authToken);
            log.info("claims：{}",claims);

            ctx.setSendZuulResponse(true);
            ctx.addZuulRequestHeader("userId", claims.get("userId").toString());

        }catch (ExpiredJwtException e){
            log.error("jwtToken过期",e);
            //不对请求进行路由
            ctx.setSendZuulResponse(false);
            responseError(ctx,  "token expired");
        }catch (Exception ex){
            log.error("未知异常",ex);
            //不对请求进行路由
            ctx.setSendZuulResponse(false);
            responseError(ctx,"invalid token");
        }

        return null;
    }

    private void responseError(RequestContext ctx, String message) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMessage(message);
        try {
            ctx.setResponseBody(objectMapper.writeValueAsString(result));
            HttpServletResponse response = ctx.getResponse();
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.setContentType("application/json;charset=utf-8");

        } catch (JsonProcessingException e) {
            log.error("写入响应时失败",e);
            ctx.setResponseBody("{\"success\":false,\"message\":\"处理出错\"}");
        }

    }


}
