package com.mason.fragrancelamp.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {

    private Integer uid;
    private String name;
    private String email;
    private String password;
    private String area;
    private Date birthday;
    private String qq;
    private String wechat;
}
