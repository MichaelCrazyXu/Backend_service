package com.mason.fragrancelamp.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Role {

    private String role_id;
    private String role_name;
    private String role_description;
    private Date create_time;
}
