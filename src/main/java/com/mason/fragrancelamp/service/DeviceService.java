package com.mason.fragrancelamp.service;

import com.mason.fragrancelamp.entity.PageRequest;
import com.mason.fragrancelamp.entity.Device;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceService {

    List<Device> getDevices(@Param("pageRequest") PageRequest pageRequest);

    int getTotalCount(@Param("pageRequest") PageRequest pageRequest);

    int addDevice(@Param("device") Device device);

    int updateDevice(Device device);

    int deleteDeviceById(@Param("id") int id);
}
