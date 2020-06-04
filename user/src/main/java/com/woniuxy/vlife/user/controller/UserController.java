package com.woniuxy.vlife.user.controller;

import com.woniuxy.vlife.user.common.Result;
import com.woniuxy.vlife.user.entity.User;
import com.woniuxy.vlife.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login",produces = "application/json")
    public Result login(String username,String password){
        log.info("{}:{}",username,password);
        User user = userService.findByUsernameAndPassword(username, password);
        Result result = new Result();
        if(user!=null) {
            result.setSuccess(true);
            result.add("userId",user.getUserId());
        }else{
            result.setMessage("用户名或密码不正确");
        }
        return result;
    }

}
