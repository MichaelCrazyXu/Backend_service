package com.mason.fragrancelamp.mapper;

import com.mason.fragrancelamp.entity.PageRequest;
import com.mason.fragrancelamp.entity.Device;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeviceMapper {

    @Select({"<script>",
            "select * from device_tbl ",
            "WHERE 1=1",
            "<when test='device_name!=null and device_name != \"\"'>",
            "AND device_name like CONCAT('%',#{device_name},'%') ",
            "</when>",
            "<when test='communication_type!=null and communication_type != \"\"'>",
            "AND communication_type = #{communication_type}",
            "</when>",
            "<when test='device_id!=null and device_id != \"\"'>",
            "AND device_id = #{device_id}",
            "</when>",
            "order by id ${sort} limit #{limit} offset #{limit}*(#{page} - 1)",
            "</script>"})
    List<Device> getDevices(PageRequest pageRequest);

    @Select({"<script>",
            "select count(id) from device_tbl ",
            "WHERE 1=1",
            "<when test='device_name!=null and device_name != \"\"'>",
            "AND device_name like CONCAT('%',#{device_name},'%') ",
            "</when>",
            "<when test='communication_type!=null and communication_type != \"\"'>",
            "AND communication_type = #{communication_type}",
            "</when>",
            "<when test='device_id!=null and device_id != \"\"'>",
            "AND device_id = #{device_id}",
            "</when>",
            "</script>"})
    int getTotalCount(PageRequest pageRequest);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into device_tbl(device_name," +
            "communication_type,device_id," +
            "version, status, create_time) " +
            "values (#{device_name}," +
            " #{communication_type}," +
            " #{device_id}," +
            " #{version}," +
            " #{status}," +
            " now())")
    void addDevice(Device device);

    @Update({"<script>",
            "update device_tbl",
            "<set>",
            "<if test='device_name != null'>",
            "device_name = #{device_name} ,",
            "</if>",
            "<if test='communication_type != null'>",
            "communication_type = #{communication_type} ,",
            "</if>",
            "<if test='device_id != null'>",
            "device_id = #{device_id} ,",
            "</if>",
            "<if test='version != null'>",
            "version = #{version} ,",
            "</if>",
            "<if test='status != null'>",
            "status = #{status} ,",
            "</if>",
            "</set>",
            "where id = #{id}",
            "</script>"})
    int updateDevice(Device device);

    @Delete("delete from device_tbl where id = #{id}")
    int deleteDevice(@Param("id") int id);
}
