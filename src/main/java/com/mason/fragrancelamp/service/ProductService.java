package com.mason.fragrancelamp.service;

import com.aliyuncs.RpcAcsRequest;
import com.aliyuncs.iot.model.v20180120.*;
import com.mason.fragrancelamp.entity.PageRequest;
import com.mason.fragrancelamp.entity.Product;
import com.mason.fragrancelamp.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {

    /**
     * 查询产品列表
     *
     * @param request      产品request(   指定从返回结果中的第几页开始显示  非必需)
     */
    List<Product> getProducts(@Param("pageRequest") PageRequest pageRequest);

    int getTotalCount(@Param("pageRequest") PageRequest pageRequest);


    Product getProductById(@Param("id") String id);

}
