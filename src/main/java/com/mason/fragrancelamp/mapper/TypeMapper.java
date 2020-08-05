package com.mason.fragrancelamp.mapper;

import com.mason.fragrancelamp.entity.PageRequest;
import com.mason.fragrancelamp.entity.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TypeMapper {

    @Select({"<script>",
            "select * from type_tbl ",
            "WHERE 1=1",
            "<when test='type_name!=null and type_name != \"\"'>",
            "AND type_name like CONCAT('%',#{type_name},'%') ",
            "</when>",
            "order by id ${sort} limit #{limit} offset #{limit}*(#{page} - 1)",
            "</script>"})
    List<Type> getTypes(PageRequest pageRequest);

    @Select({"<script>",
            "select count(id) from type_tbl ",
            "WHERE 1=1",
            "<when test='type_name!=null and type_name != \"\"'>",
            "AND type_name like CONCAT('%',#{type_name},'%') ",
            "</when>",
            "</script>"})
    int getTotalCount(PageRequest pageRequest);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into type_tbl(type_name," +
            "type_description,type_authentication,image,create_time) " +
            "values (#{type_name}," +
            " #{type_description}," +
            " #{type_authentication}," +
            " #{image}," +
            " now())")
    void addType(Type type);

    @Update({"<script>",
            "update type_tbl",
            "<set>",
            "<if test='type_name != null'>",
            "type_name = #{type_name} ,",
            "</if>",
            "<if test='type_description != null'>",
            "type_description = #{type_description} ,",
            "</if>",
            "<if test='type_authentication != null'>",
            "type_authentication = #{type_authentication} ,",
            "</if>",
            "<if test='image != null'>",
            "image = #{image} ,",
            "</if>",
            "</set>",
            "where id = #{id}",
            "</script>"})
    int updateType(Type type);

    @Delete("delete from type_tbl where id = #{id}")
    int deleteType(@Param("id") int id);
}
