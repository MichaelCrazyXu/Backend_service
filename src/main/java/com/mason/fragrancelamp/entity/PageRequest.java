package com.mason.fragrancelamp.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRequest {

    //符合条件的总页数
    private int totalPages;

    //每页数量
    private int limit;

    //当前页码
    private int page;

    private String name;
    private String role;
    private String department;
    private String sort;
    private String product_name;
    private String product_type_id;

    private String type_name;
    private String device_name;
    private String communication_type;
    private String device_id;
}
