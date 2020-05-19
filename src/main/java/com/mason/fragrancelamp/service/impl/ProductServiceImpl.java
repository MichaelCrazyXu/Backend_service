package com.mason.fragrancelamp.service.impl;

import com.mason.fragrancelamp.entity.Product;
import com.mason.fragrancelamp.entity.User;
import com.mason.fragrancelamp.mapper.ProductMapper;
import com.mason.fragrancelamp.mapper.UserMapper;
import com.mason.fragrancelamp.service.ProductService;
import com.mason.fragrancelamp.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;

    @Override
    public List<Product> getProducts() {
        List<Product> productList = productMapper.getProducts();
        return productList;
    }

    @Override
    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }

    @Override
    public Product getProductById(String pid) {
        Product product = productMapper.getProductByID(pid);
        return product;
    }

    @Override
    public int updateProduct(Product product) {
        int result = productMapper.updateProduct(product);
        return result;
    }

    @Override
    public int deleteProductById(String pid) {
        int result = productMapper.deleteProduct(pid);
        return result;
    }
}
