package com.mason.fragrancelamp.controller;

import com.mason.fragrancelamp.core.Result;
import com.mason.fragrancelamp.core.ResultGenerator;
import com.mason.fragrancelamp.entity.Product;
import com.mason.fragrancelamp.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService procutService;

    @ResponseBody
    @PostMapping(value = "/addProduct")
    public String addProduct(@RequestBody Product product) {

        procutService.addProduct(product);
        Result result = ResultGenerator.genSuccessResult();
        return result.toString();
    }

    @ResponseBody
    @PutMapping(value = "/updateProduct")
    public String updateProduct(@RequestBody Product product) {

        int iResult = procutService.updateProduct(product);
        Result result = null;
        if (iResult == 1) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("产品信息没有更新");
        }

        return result.toString();
    }

    @ResponseBody
    @DeleteMapping(value = "/deleteProduct/{pid}")
    public String deleteProductById(@PathVariable("pid") String pid) {

        int iResult = procutService.deleteProductById(pid);
        Result result = null;
        if (iResult == 1) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("产品信息没有删除");
        }

        return result.toString();
    }

    @ResponseBody
    @GetMapping(value = "/getProduct/{pid}")
    public String getProductById(@PathVariable("pid") String pid) {
        Product product = procutService.getProductById(pid);

        Result result = ResultGenerator.genSuccessResult(product);
        return result.toString();
    }


}
