package com.mason.fragrancelamp.service;

import com.mason.fragrancelamp.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {

    List<Role> getRoles();

    void addRole(@Param("role") Role role);

    int updateRole(Role role);

    int deleteByRoleId(@Param("role_id") String roleId);
}
