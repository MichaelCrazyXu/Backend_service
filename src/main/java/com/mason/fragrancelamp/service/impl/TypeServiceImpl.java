package com.mason.fragrancelamp.service.impl;

import com.mason.fragrancelamp.entity.PageRequest;
import com.mason.fragrancelamp.entity.Type;
import com.mason.fragrancelamp.mapper.TypeMapper;
import com.mason.fragrancelamp.service.TypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    TypeMapper typeMapper;

    @Override
    public List<Type> getTypes(@Param("pageRequest") PageRequest pageRequest) {
        List<Type> typeList = typeMapper.getTypes(pageRequest);
        return typeList;
    }

    @Override
    public int getTotalCount(PageRequest pageRequest) {
        int total = typeMapper.getTotalCount(pageRequest);
        return total;
    }

    @Override
    public int addType(Type type) {
        typeMapper.addType(type);

        int id = type.getId();

        return id;
    }

    @Override
    public int updateType(Type type) {
        int result = typeMapper.updateType(type);
        return result;
    }

    @Override
    public int deleteTypeById(int id) {
        int result = typeMapper.deleteType(id);
        return result;
    }
}
