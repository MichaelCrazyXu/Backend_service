package com.mason.fragrancelamp.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SysUser {

    private int id;
    private String uid;
    private String name;
    private String role;
    private String tel;
    private String department;
    private String email;
    private String password;
    private String qq;
    private String wechat;
}
