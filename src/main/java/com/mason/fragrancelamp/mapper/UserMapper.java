package com.mason.fragrancelamp.mapper;

import com.mason.fragrancelamp.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user_tbl")
    List<User> getUsers();

    @Options(useGeneratedKeys = true, keyProperty = "uid")
    @Insert("insert into user_tbl(name,email,password,area,birthday,qq,wechat) " +
            "values (#{name},#{email},#{password},#{area},#{birthday},#{qq},#{wechat})")
    void addUser(User user);

    @Select("select * from user_tbl where uid = #{uid}")
    User getUserByID(@Param("uid") int uid);

    @Update({"<script>",
            "update user_tbl",
            "<set>",
            "<if test='name != null'>",
            "name = #{name} ,",
            "</if>",
            "<if test='email != null'>",
            "email = #{email} ,",
            "</if>",
            "<if test='password != null'>",
            "password = #{password} ,",
            "</if>",
            "<if test='area != null'>",
            "area = #{area} ,",
            "</if>",
            "<if test='birthday != null'>",
            "birthday = #{birthday} ,",
            "</if>",
            "<if test='qq != null'>",
            "qq = #{qq} ,",
            "</if>",
            "<if test='wechat != null'>",
            "wechat = #{wechat} ,",
            "</if>",
            "</set>",
            "where uid = #{uid}",
            "</script>"})
    int updateUser(User user);

    @Delete("delete from user_tbl where uid = #{uid}")
    int deleteUser(@Param("uid") int uid);
}
