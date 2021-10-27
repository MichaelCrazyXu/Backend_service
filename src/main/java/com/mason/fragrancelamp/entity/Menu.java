package com.mason.fragrancelamp.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Product {

    private int id;
    private String product_key;
    private String product_name;
    private String product_type_id;
    private String description;
    private Date create_time;

}
