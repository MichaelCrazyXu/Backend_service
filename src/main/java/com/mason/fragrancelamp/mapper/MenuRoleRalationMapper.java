package com.mason.fragrancelamp.mapper;

import com.mason.fragrancelamp.entity.Menu;
import com.mason.fragrancelamp.entity.MenuRoleRelation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MenuRoleRalationMapper {

    @Select({"<script>",
            "select * from menu_role_relation_tbl" ,
            "WHERE 1=1",
            "<when test='role_id!=null and role_id != \"\"'>",
            "AND role_id = #{role_id}",
            "</when>",
            " order by role_id",
            "</script>"})
    List<MenuRoleRelation> getMenuRoleRelations(@Param("role_id") String role_id);

    @Select({"<script>",
            "select count(menu_id) from menu_role_relation_tbl ",
            "WHERE 1=1",
            "</script>"})
    int getTotalCount();

    @Insert("insert into menu_role_relation_tbl(menu_id, role_id)" +
            "values (#{menu_id},#{role_id})")
    void addMenuRoleRelation(MenuRoleRelation menuRoleRelation);

    @Delete("delete from menu_role_relation_tbl where role_id = #{role_id}")
    int deleteMenuRoleRelation(@Param("role_id") String role_id);
}
