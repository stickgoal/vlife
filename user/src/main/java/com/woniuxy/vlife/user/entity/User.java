package com.woniuxy.vlife.user.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vlife_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String username;

    private String password;

    private String avatar;

}
