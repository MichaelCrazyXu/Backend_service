package com.mason.fragrancelamp.controller;

import com.alibaba.fastjson.JSONObject;
import com.mason.fragrancelamp.core.Result;
import com.mason.fragrancelamp.core.ResultGenerator;
import com.mason.fragrancelamp.entity.Menu;
import com.mason.fragrancelamp.entity.PageRequest;
import com.mason.fragrancelamp.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    MenuService menuService;

    @ResponseBody
    @PostMapping(value = "/menu/create")
    public String addMenu(@RequestBody Menu menu) {

        int uid = menuService.addMenu(menu);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("uid", uid);
        Result result = ResultGenerator.genSuccessResult(jsonObject);
        return result.toString();
    }

    @ResponseBody
    @PutMapping(value = "/menu/update")
    public String updateMenu(@RequestBody Menu menu) {

        int iResult = menuService.updateMenu(menu);
        Result result = null;
        if (iResult == 1) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("菜单信息没有更新");
        }

        return result.toString();
    }

    @ResponseBody
    @DeleteMapping(value = "/menu/delete/{menuId}")
    public String deleteMenuById(@PathVariable("menuId") int menuId) {

        int iResult = menuService.deleteMenuById(menuId);
        Result result = null;
        if (iResult == 1) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("菜单信息没有删除");
        }

        return result.toString();
    }

    @ResponseBody
    @GetMapping(value = "/menus")
    public String getMenus() {
        List<Menu> menus = menuService.getMenus();

        int total = menuService.getTotalCount();

        Result result = ResultGenerator.genSuccessResult(menus, total);
        return result.toString();
    }


}
