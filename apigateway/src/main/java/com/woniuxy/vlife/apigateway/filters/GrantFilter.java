package com.woniuxy.vlife.apigateway.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.woniuxy.vlife.apigateway.common.JWTHelper;
import com.woniuxy.vlife.apigateway.common.Result;
import io.jsonwebtoken.JwtBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class GrantFilter extends ZuulFilter {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 2;
    }

    @Override
    public boolean shouldFilter() {

        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String requestURI = request.getRequestURI();
        boolean isLoginRequest = new AntPathMatcher().match("/login", requestURI);

        return isLoginRequest;
    }

    @Override
    public Object run() throws ZuulException {
        //是否登录成功，成功则添加jwt
        RequestContext currentContext = RequestContext.getCurrentContext();
        InputStream responseDataStream = currentContext.getResponseDataStream();
        try {
            String resultString = StreamUtils.copyToString(responseDataStream, StandardCharsets.UTF_8);
            Result result = objectMapper.readValue(resultString, Result.class);
            log.info("登录处理结果：{}",result);

            if(result.isSuccess()){
                //生成jwt
                Object userId = result.get("userId");
                Map<String,Object> jwtClaims = new HashMap<>();
                jwtClaims.put("userId",userId);
                Date expireDate = DateUtils.addDays(new Date(), 7);
                String jwt = JWTHelper.createJWT(expireDate, jwtClaims);
                log.info("jwt生成：{}",jwt);

                //将jwt放入结果中写出到响应的body中
                result.add("auth_token",jwt);
                String resultJson = objectMapper.writeValueAsString(result);
                currentContext.setResponseBody(resultJson);
                currentContext.addZuulResponseHeader("auth_token", jwt);
                log.info("发送给用户：{}",resultJson);

            }else{
                log.info("登录处理失败");


                currentContext.setResponseBody(resultString);
                currentContext.getResponse().setContentType("application/json;charset=utf-8");

            }


        } catch (IOException e) {
            log.error("授权失败",e);
        }

        return null;
    }
}
