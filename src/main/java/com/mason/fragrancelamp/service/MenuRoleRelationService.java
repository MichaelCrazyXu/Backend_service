package com.mason.fragrancelamp.service;

import com.mason.fragrancelamp.entity.MenuRoleRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuRoleRelationService {

    List<MenuRoleRelation> getMenuRoleRelations();

    int getTotalCount();

    int addMenuRoleRelation(@Param("menuRoleRelation") MenuRoleRelation menuRoleRelation);

    int deleteMenuRoleRelation(@Param("role_id") int role_id);

}
