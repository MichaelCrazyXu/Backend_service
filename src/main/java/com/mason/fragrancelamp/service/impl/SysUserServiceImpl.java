package com.mason.fragrancelamp.service.impl;

import com.mason.fragrancelamp.entity.PageRequest;
import com.mason.fragrancelamp.entity.SysUser;
import com.mason.fragrancelamp.mapper.SysUserMapper;
import com.mason.fragrancelamp.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> getUsers(PageRequest pageRequest) {
        List<SysUser> userList = sysUserMapper.getSysUsers(pageRequest);
        return userList;
    }

    @Override
    public int getTotalCount(PageRequest pageRequest) {
        int total = sysUserMapper.getTotalCount(pageRequest);
        return total;
    }

    @Override
    public int addSysUser(SysUser user) {
        sysUserMapper.addSysUser(user);

        int id = user.getId();
        return id;
    }

    @Override
    public SysUser getSysUserById(int id) {
        SysUser user = sysUserMapper.getSysUserByID(id);
        return user;
    }

    @Override
    public int updateSysUser(SysUser user) {
        int result = sysUserMapper.updateSysUser(user);
        return result;
    }

    @Override
    public int deleteSysUserById(int id) {
        int result = sysUserMapper.deleteSysUser(id);
        return result;
    }
}
