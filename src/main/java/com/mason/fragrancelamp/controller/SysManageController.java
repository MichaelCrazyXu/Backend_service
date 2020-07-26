package com.mason.fragrancelamp.controller;

import com.alibaba.fastjson.JSONObject;
import com.mason.fragrancelamp.core.Result;
import com.mason.fragrancelamp.core.ResultGenerator;
import com.mason.fragrancelamp.entity.PageRequest;
import com.mason.fragrancelamp.entity.SysUser;
import com.mason.fragrancelamp.service.SysUserService;
import com.sun.istack.internal.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SysManageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysManageController.class);

    @Autowired
    SysUserService sysUserService;

    @ResponseBody
    @PostMapping(value = "/sysuser/create")
    public String addUser(@RequestBody SysUser user) {

        int id = sysUserService.addSysUser(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        Result result = ResultGenerator.genSuccessResult(jsonObject);
        return result.toString();
    }

    @ResponseBody
    @PutMapping(value = "/sysuser/update")
    public String updateUser(@RequestBody SysUser user) {

        int iResult = sysUserService.updateSysUser(user);
        Result result = null;
        if (iResult == 1) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("用户信息没有更新");
        }

        return result.toString();
    }

    @ResponseBody
    @DeleteMapping(value = "/sysuser/delete/{id}")
    public String deleteUserById(@PathVariable("id") int id) {

        int iResult = sysUserService.deleteSysUserById(id);
        Result result = null;
        if (iResult == 1) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("用户信息没有删除");
        }

        return result.toString();
    }

    @ResponseBody
    @GetMapping(value = "/getSysUser/{uid}")
    public String getUserById(@PathVariable("id") int id) {
        SysUser user = sysUserService.getSysUserById(id);

        Result result = ResultGenerator.genSuccessResult(user);
        return result.toString();
    }

    @ResponseBody
    @PostMapping(value = "/getSysUsers")
    public String getUsers(@RequestBody PageRequest pageQuery) {

        List<SysUser> user = sysUserService.getUsers(pageQuery);

        int total = sysUserService.getTotalCount(pageQuery);

        Result result = ResultGenerator.genSuccessResult(user, total);
        return result.toString();
    }

}
