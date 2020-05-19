package com.mason.fragrancelamp.service;

import com.mason.fragrancelamp.entity.Product;
import com.mason.fragrancelamp.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    void addProduct(@Param("product") Product product);

    Product getProductById(@Param("pid") String pid);

    int updateProduct(Product product);

    int deleteProductById(@Param("pid") String pid);
}
