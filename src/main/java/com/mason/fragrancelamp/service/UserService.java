package com.mason.fragrancelamp.service;

import com.mason.fragrancelamp.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    int addUser(@Param("user") User user);

    User getUserById(@Param("uid") int uid);

    int updateUser(User user);

    int deleteUserById(@Param("uid") int uid);
}
