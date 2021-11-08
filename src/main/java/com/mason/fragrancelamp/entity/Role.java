package com.mason.fragrancelamp.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Role {

    private String role_id;
    private String role_name;
    private String role_description;
    private Date create_time;
    private String checkedKeys;
    private List<MenuRoleRelation> menuRoleRelations;
}
