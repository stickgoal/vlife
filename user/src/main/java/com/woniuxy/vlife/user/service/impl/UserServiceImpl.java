package com.woniuxy.vlife.user.service.impl;

import com.woniuxy.vlife.user.entity.User;
import com.woniuxy.vlife.user.repo.UserRepo;
import com.woniuxy.vlife.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepo.findByUsernameAndPassword(username,password);
    }
}
