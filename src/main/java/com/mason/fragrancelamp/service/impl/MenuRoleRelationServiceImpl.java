package com.mason.fragrancelamp.service.impl;

import com.mason.fragrancelamp.entity.MenuRoleRelation;
import com.mason.fragrancelamp.mapper.MenuRoleRalationMapper;
import com.mason.fragrancelamp.service.MenuRoleRelationService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuRoleRelationServiceImpl implements MenuRoleRelationService {

    @Resource
    MenuRoleRalationMapper menuRoleRalationMapper;

    @Override
    public List<MenuRoleRelation> getMenuRoleRelations(String role_id) {
        List<MenuRoleRelation> menuRoleRelations = menuRoleRalationMapper.getMenuRoleRelations(role_id);
        return menuRoleRelations;
    }

    @Override
    public int getTotalCount() {
        int total = menuRoleRalationMapper.getTotalCount();
        return total;
    }

    @Override
    public int addMenuRoleRelation(@Param("menuRoleRelation") MenuRoleRelation menuRoleRelation) {
        menuRoleRalationMapper.addMenuRoleRelation(menuRoleRelation);

        int id = menuRoleRelation.getMenu_id();

        return id;
    }

    @Override
    public int deleteMenuRoleRelation(@Param("role_id") String role_id) {
        int result = menuRoleRalationMapper.deleteMenuRoleRelation(role_id);
        return result;
    }

}
