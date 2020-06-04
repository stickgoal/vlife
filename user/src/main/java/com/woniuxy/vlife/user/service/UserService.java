package com.woniuxy.vlife.user.service;

import com.woniuxy.vlife.user.entity.User;

public interface UserService {

    User findByUsernameAndPassword(String username,String password);

}
