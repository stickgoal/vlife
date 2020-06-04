package com.woniuxy.vlife.user.repo;

import com.woniuxy.vlife.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUsernameAndPassword(String username,String password);

}
