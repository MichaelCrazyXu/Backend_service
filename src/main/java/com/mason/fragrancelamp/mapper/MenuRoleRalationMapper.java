package com.mason.fragrancelamp.mapper;

import com.mason.fragrancelamp.entity.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MenuMapper {

    @Select("select * from menu_tbl order by menu_id")
    List<Menu> getMenus();

    @Select({"<script>",
            "select count(menu_id) from menu_tbl ",
            "WHERE 1=1",
            "</script>"})
    int getTotalCount();

    @Insert("insert into menu_tbl(pid,name,url,sort,type,path)" +
            "values (#{pid},#{name},#{url},#{sort},#{type},#{path})")
    void addMenu(Menu menu);

    @Update({"<script>",
            "update menu_tbl",
            "<set>",
            "<if test='name != null'>",
            "name = #{name} ,",
            "</if>",
            "<if test='url != null'>",
            "url = #{url} ,",
            "</if>",
            "<if test='sort != null'>",
            "sort = #{sort} ,",
            "</if>",
            "<if test='type != null'>",
            "type = #{type} ,",
            "</if>",
            "<if test='path != null'>",
            "path = #{path} ,",
            "</if>",
            "</set>",
            "where menu_id = #{menu_id}",
            "</script>"})
    int updateMenu(Menu menu);

    @Delete("delete from menu_tbl where menu_id = #{menu_id}")
    int deleteMenu(@Param("menu_id") int menu_id);
}
