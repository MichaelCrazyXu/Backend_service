package com.mason.fragrancelamp.service.impl;

import com.mason.fragrancelamp.entity.User;
import com.mason.fragrancelamp.mapper.UserMapper;
import com.mason.fragrancelamp.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        List<User> userList = userMapper.getUsers();
        return userList;
    }

    @Override
    public int addUser(User user) {
        userMapper.addUser(user);

        int uid = user.getUid();
        return uid;
    }

    @Override
    public User getUserById(int uid) {
        User user = userMapper.getUserByID(uid);
        return user;
    }

    @Override
    public int updateUser(User user) {
        int result = userMapper.updateUser(user);
        return result;
    }

    @Override
    public int deleteUserById(int uid) {
        int result = userMapper.deleteUser(uid);
        return result;
    }
}
