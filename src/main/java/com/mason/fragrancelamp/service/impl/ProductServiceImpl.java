package com.mason.fragrancelamp.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.AcsResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.RpcAcsRequest;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.iot.model.v20180120.*;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.mason.fragrancelamp.entity.PageRequest;
import com.mason.fragrancelamp.entity.Product;
import com.mason.fragrancelamp.entity.User;
import com.mason.fragrancelamp.mapper.ProductMapper;
import com.mason.fragrancelamp.mapper.UserMapper;
import com.mason.fragrancelamp.sdk.openapi.ProductManager;
import com.mason.fragrancelamp.service.ProductService;
import com.mason.fragrancelamp.service.UserService;
import com.mason.fragrancelamp.util.LogUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;

    @Override
    public QueryProductListResponse.Data getProducts(@Param("request") QueryProductListRequest request) {
        //List<Product> productList = productMapper.getProducts(pageRequest);

        QueryProductListResponse response = null;

        try {
            response = (QueryProductListResponse) ProductManager.getClient().getAcsResponse(request);

            if (response.getSuccess() != null && response.getSuccess()) {
                LogUtil.print("查询产品详细信息");
                LogUtil.print(JSON.toJSONString(response));
            } else {
                LogUtil.print("查询产品失败");
                LogUtil.error(JSON.toJSONString(response));
            }
            return response.getData();

        } catch (ClientException e) {
            e.printStackTrace();
            LogUtil.error("查询产品失败！" + JSON.toJSONString(response.getData()));
        }
        return null;
    }

    @Override
    public int getTotalCount(PageRequest pageRequest) {
        int total = productMapper.getTotalCount(pageRequest);
        return total;
    }

    @Override
    public CreateProductResponse.Data addProduct(CreateProductRequest request) {
//        productMapper.addProduct(product);
//        int id = product.getId();
//        return id;

        CreateProductResponse response = null;

        try {
            response = ProductManager.getClient().getAcsResponse(request);

            if (response.getSuccess() != null && response.getSuccess()) {
                LogUtil.print("创建产品成功");
                LogUtil.print(JSON.toJSONString(response));
            } else {
                LogUtil.print("创建产品失败");
                LogUtil.error(JSON.toJSONString(response));
            }

            return response.getData();

        } catch (ClientException e) {
            e.printStackTrace();
            LogUtil.error("创建产品失败！" + JSON.toJSONString(response));
        }
        return null;
    }

    @Override
    public Product getProductById(String pid) {
        Product product = productMapper.getProductByID(pid);
        return product;
    }

    @Override
    public void updateProduct(UpdateProductRequest request) {

        UpdateProductResponse updateProductResponse = null;
        try {
            updateProductResponse = ProductManager.getClient().getAcsResponse(request);

            if (updateProductResponse.getSuccess() != null && updateProductResponse.getSuccess()) {
                LogUtil.print("修改产品");
                LogUtil.print(JSON.toJSONString(updateProductResponse));
            } else {
                LogUtil.print("修改产品失败");
                LogUtil.error(JSON.toJSONString(updateProductResponse));
            }

        } catch (ClientException e) {
            e.printStackTrace();
            LogUtil.error("修改产品失败！" + JSON.toJSONString(updateProductResponse));
        }

    }

    @Override
    public void deleteProductByProductKey(String productKey) {
        DeleteProductResponse response = null;

        DeleteProductRequest request = new DeleteProductRequest();
        request.setProductKey(productKey);

        try {
            response = ProductManager.getClient().getAcsResponse(request);

            if (response.getSuccess() != null && response.getSuccess()) {
                LogUtil.print("删除产品");
                LogUtil.print(JSON.toJSONString(response));
            } else {
                LogUtil.print("删除产品失败");
                LogUtil.error(JSON.toJSONString(response));
            }

        } catch (ClientException e) {
            e.printStackTrace();
            LogUtil.error("删除产品失败！");
        }
    }


}
