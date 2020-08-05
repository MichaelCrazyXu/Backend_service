package com.mason.fragrancelamp.mapper;

import com.mason.fragrancelamp.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("select * from role_tbl order by role_id")
    List<Role> getRoles();

    @Insert("insert into role_tbl(role_id,role_name,role_description,create_time)" +
            "values (#{role_id},#{role_name},#{role_description}, now())")
    void addRole(Role role);

    @Update({"<script>",
            "update role_tbl",
            "<set>",
            "<if test='role_name != null'>",
            "role_name = #{role_name} ,",
            "</if>",
            "<if test='role_description != null'>",
            "role_description = #{role_description} ,",
            "</if>",
            "</set>",
            "where role_id = #{role_id}",
            "</script>"})
    int updateRole(Role role);

    @Delete("delete from role_tbl where role_id = #{role_id}")
    int deleteRole(@Param("role_id") String role_id);
}
