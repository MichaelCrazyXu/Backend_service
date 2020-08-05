package com.mason.fragrancelamp.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Type {

    private int id;
    private String type_name;
    private String type_description;
    private String type_authentication;
    private byte[] image;
    private Date create_time;
}
