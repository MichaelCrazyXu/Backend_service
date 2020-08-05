package com.mason.fragrancelamp.service.impl;

import com.mason.fragrancelamp.entity.PageRequest;
import com.mason.fragrancelamp.entity.Device;
import com.mason.fragrancelamp.mapper.DeviceMapper;
import com.mason.fragrancelamp.service.DeviceService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Resource
    DeviceMapper deviceMapper;

    @Override
    public List<Device> getDevices(@Param("pageRequest") PageRequest pageRequest) {
        List<Device> deviceList = deviceMapper.getDevices(pageRequest);
        return deviceList;
    }

    @Override
    public int getTotalCount(PageRequest pageRequest) {
        int total = deviceMapper.getTotalCount(pageRequest);
        return total;
    }

    @Override
    public int addDevice(Device device) {
        deviceMapper.addDevice(device);

        int id = device.getId();

        return id;
    }

    @Override
    public int updateDevice(Device device) {
        int result = deviceMapper.updateDevice(device);
        return result;
    }

    @Override
    public int deleteDeviceById(int id) {
        int result = deviceMapper.deleteDevice(id);
        return result;
    }
}
