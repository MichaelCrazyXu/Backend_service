package com.mason.fragrancelamp.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuRoleRelation {

    private int menuId;
    private int pid;
    private String name;
    private String url;
    private String sort;
    private String type;

}
