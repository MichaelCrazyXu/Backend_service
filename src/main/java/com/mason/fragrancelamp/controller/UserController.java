package com.mason.fragrancelamp.controller;

import com.alibaba.fastjson.JSONObject;
import com.mason.fragrancelamp.core.Result;
import com.mason.fragrancelamp.core.ResultGenerator;
import com.mason.fragrancelamp.entity.User;
import com.mason.fragrancelamp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody User user) {

        int uid = userService.addUser(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("uid", uid);
        Result result = ResultGenerator.genSuccessResult(jsonObject);
        return result.toString();
    }

    @ResponseBody
    @PutMapping(value = "/updateUser")
    public String updateUser(@RequestBody User user) {

        int iResult = userService.updateUser(user);
        Result result = null;
        if (iResult == 1) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("用户信息没有更新");
        }

        return result.toString();
    }

    @ResponseBody
    @DeleteMapping(value = "/deleteUser/{uid}")
    public String deleteUserById(@PathVariable("uid") int uid) {

        int iResult = userService.deleteUserById(uid);
        Result result = null;
        if (iResult == 1) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("用户信息没有删除");
        }

        return result.toString();
    }

    @ResponseBody
    @GetMapping(value = "/getUser/{uid}")
    public String getUserById(@PathVariable("uid") int uid) {
        User user = userService.getUserById(uid);

        Result result = ResultGenerator.genSuccessResult(user);
        return result.toString();
    }


}
