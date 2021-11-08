package com.mason.fragrancelamp.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.utils.StringUtils;
import com.mason.fragrancelamp.core.Result;
import com.mason.fragrancelamp.core.ResultGenerator;
import com.mason.fragrancelamp.entity.*;
import com.mason.fragrancelamp.service.MenuRoleRelationService;
import com.mason.fragrancelamp.service.MenuService;
import com.mason.fragrancelamp.service.RoleService;
import com.mason.fragrancelamp.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SysManageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysManageController.class);

    @Autowired
    SysUserService sysUserService;

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    @Autowired
    MenuRoleRelationService menuRoleRelationService;

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

    @ResponseBody
    @PostMapping(value = "/role/create")
    public String addRole(@RequestBody Role role) {

        roleService.addRole(role);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("role_id", role.getRole_id());
        Result result = ResultGenerator.genSuccessResult(jsonObject);
        return result.toString();
    }

    @ResponseBody
    @GetMapping(value = "/roles")
    public String getRoles() {

        List<Role> roleList = roleService.getRoles();

        roleList.forEach(item -> {

            List<MenuRoleRelation> menuRoleRelationList =
                    menuRoleRelationService.getMenuRoleRelations(item.getRole_id());

            item.setMenuRoleRelations(menuRoleRelationList);
        });

        Result result = ResultGenerator.genSuccessResult(roleList);
        return result.toString();
    }

    @ResponseBody
    @DeleteMapping(value = "/role/delete/{role_id}")
    public String deleteRoleByRoleId(@PathVariable("role_id") String role_id) {

        int iResult = roleService.deleteByRoleId(role_id);
        Result result = null;
        if (iResult == 1) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("角色没有删除");
        }

        return result.toString();
    }

    @ResponseBody
    @PutMapping(value = "/role/update")
    public String updateRole(@RequestBody Role role) {

        int iResult = roleService.updateRole(role);
        Result result = null;
        if (iResult == 1) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("角色信息没有更新");
        }

        String checkedKeys = role.getCheckedKeys();
        int length = 0;
        String[] arrayKeys = null;
        if (!StringUtils.isEmpty(checkedKeys)) {
            length = checkedKeys.split(",").length;
            arrayKeys = new String[length];
            arrayKeys = checkedKeys.split(",");
        }

        if (!StringUtils.isEmpty(checkedKeys)) {
            arrayKeys = checkedKeys.split(",");
        }

        //先删除
        menuRoleRelationService.deleteMenuRoleRelation(role.getRole_id());

        //检索出Menu，根据Menu_id增加menu 和Role匹配关系
        List<Menu> menus = menuService.getMenus();

        if (arrayKeys != null ) {

            for(String x : arrayKeys) {
                Optional<Menu> menu = menus.stream().
                        filter(u -> x.equals(String.valueOf(u.getMenu_id()))).findFirst();

                MenuRoleRelation menuRoleRelation = new MenuRoleRelation();
                menuRoleRelation.setRole_id(role.getRole_id());
                menuRoleRelation.setMenu_id(menu.get().getMenu_id());
                menuRoleRelationService.addMenuRoleRelation(menuRoleRelation);

                System.out.println(x);

            };
        }






        return result.toString();
    }
}
