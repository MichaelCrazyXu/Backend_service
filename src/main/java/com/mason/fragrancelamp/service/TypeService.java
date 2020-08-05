package com.mason.fragrancelamp.service;

import com.mason.fragrancelamp.entity.PageRequest;
import com.mason.fragrancelamp.entity.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeService {

    List<Type> getTypes(@Param("pageRequest") PageRequest pageRequest);

    int getTotalCount(@Param("pageRequest") PageRequest pageRequest);

    int addType(@Param("type") Type type);

    int updateType(Type type);

    int deleteTypeById(@Param("id") int id);
}
