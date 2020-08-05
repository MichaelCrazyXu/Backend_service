package com.mason.fragrancelamp.service.impl;

import com.mason.fragrancelamp.entity.Role;
import com.mason.fragrancelamp.mapper.RoleMapper;
import com.mason.fragrancelamp.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleMapper roleMapper;

    @Override
    public List<Role> getRoles() {
        List<Role> roleList = roleMapper.getRoles();
        return roleList;
    }

    @Override
    public void addRole(Role role) {
        roleMapper.addRole(role);
    }

    @Override
    public int updateRole(Role role) {
        int result = roleMapper.updateRole(role);
        return result;
    }

    @Override
    public int deleteByRoleId(String role_id) {
        int result = roleMapper.deleteRole(role_id);
        return result;
    }
}
