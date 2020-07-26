package com.mason.fragrancelamp.service;

import com.mason.fragrancelamp.entity.PageRequest;
import com.mason.fragrancelamp.entity.SysUser;
import com.mason.fragrancelamp.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserService {

    List<SysUser> getUsers(@Param("pageRequest") PageRequest pageRequest);

    int getTotalCount(@Param("pageRequest") PageRequest pageRequest);

    int addSysUser(@Param("sysUser") SysUser sysUser);

    SysUser getSysUserById(@Param("uid") int uid);

    int updateSysUser(SysUser user);

    int deleteSysUserById(@Param("uid") int uid);
}
