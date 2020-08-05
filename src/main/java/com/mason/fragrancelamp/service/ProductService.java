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
    QueryProductListResponse.Data getProducts(@Param("request") QueryProductListRequest request);

    int getTotalCount(@Param("pageRequest") PageRequest pageRequest);

    /**
     * 创建产品
     *
     * @param request   创建产品request
     * @return 产品创建信息
     */
    public CreateProductResponse.Data addProduct(CreateProductRequest request);

    Product getProductById(@Param("id") String id);

    /**
     * 修改产品
     *
     * @param request   修改产品request
     */
    void updateProduct(UpdateProductRequest request);

    /**
     * 删除产品
     *
     * @param productKey 产品PK 必需
     */
    void deleteProductByProductKey(@Param("productKey") String productKey);
}
