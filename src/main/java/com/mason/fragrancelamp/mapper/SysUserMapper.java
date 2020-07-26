package com.mason.fragrancelamp.mapper;

import com.mason.fragrancelamp.entity.PageRequest;
import com.mason.fragrancelamp.entity.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysUserMapper {

    @Select({"<script>",
            "select * from sysuser_tbl ",
            "WHERE 1=1",
            "<when test='name!=null and name != \"\"'>",
            "AND name like CONCAT('%',#{name},'%') ",
            "</when>",
            "<when test='role!=null and role != \"\"'>",
            "AND role = #{role}",
            "</when>",
            "<when test='department!=null and department != \"\"'>",
            "AND department = #{department}",
            "</when>",
            "order by id ${sort} limit #{limit} offset #{limit}*(#{page} - 1)",
            "</script>"})
    List<SysUser> getSysUsers(PageRequest pageRequest);

    @Select({"<script>",
            "select count(id) from sysuser_tbl ",
            "WHERE 1=1",
            "<when test='name!=null and name != \"\"'>",
            "AND name like CONCAT('%',#{name},'%') ",
            "</when>",
            "<when test='role!=null and role != \"\"'>",
            "AND role = #{role}",
            "</when>",
            "<when test='department!=null and department != \"\"'>",
            "AND department = #{department}",
            "</when>",
            "</script>"})
    int getTotalCount(PageRequest pageRequest);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into sysuser_tbl(uid,name,role,tel,department" +
            ") " +
            "values (#{uid},#{name},#{role},#{tel},#{department}" +
            ")")
    void addSysUser(SysUser user);

    @Select("select * from sysuser_tbl where uid = #{uid}")
    SysUser getSysUserByID(@Param("uid") int uid);

    @Update({"<script>",
            "update sysuser_tbl",
            "<set>",
            "<if test='name != null'>",
            "name = #{name} ,",
            "</if>",
            "<if test='role != null'>",
            "role = #{role} ,",
            "</if>",
            "<if test='tel != null'>",
            "tel = #{tel} ,",
            "</if>",
            "<if test='department != null'>",
            "department = #{department} ,",
            "</if>",
            "<if test='email != null'>",
            "email = #{email} ,",
            "</if>",
            "<if test='uid != null'>",
            "uid = #{uid} ,",
            "</if>",
//            "<if test='password != null'>",
//            "password = #{password} ,",
//            "</if>",
//            "<if test='area != null'>",
//            "area = #{area} ,",
//            "</if>",
//            "<if test='birthday != null'>",
//            "birthday = #{birthday} ,",
//            "</if>",
            "<if test='qq != null'>",
            "qq = #{qq} ,",
            "</if>",
            "<if test='wechat != null'>",
            "wechat = #{wechat} ,",
            "</if>",
            "</set>",
            "where id = #{id}",
            "</script>"})
    int updateSysUser(SysUser user);

    @Delete("delete from sysuser_tbl where id = #{id}")
    int deleteSysUser(@Param("id") int id);
}
