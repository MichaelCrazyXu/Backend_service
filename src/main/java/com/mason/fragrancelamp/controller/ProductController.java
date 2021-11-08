package com.mason.fragrancelamp.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.iot.model.v20180120.CreateProductRequest;
import com.aliyuncs.iot.model.v20180120.CreateProductResponse;
import com.mason.fragrancelamp.core.Result;
import com.mason.fragrancelamp.core.ResultGenerator;
import com.mason.fragrancelamp.entity.Device;
import com.mason.fragrancelamp.entity.PageRequest;
import com.mason.fragrancelamp.entity.Product;
import com.mason.fragrancelamp.entity.Type;
import com.mason.fragrancelamp.service.DeviceService;
import com.mason.fragrancelamp.service.ProductService;
import com.mason.fragrancelamp.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService procutService;

    @Autowired
    TypeService typeService;

    @Autowired
    DeviceService deviceService;

    @ResponseBody
    @PostMapping(value = "/getProducts")
    public String getProducts(@RequestBody PageRequest pageRequest) {
        List<Product> products = procutService.getProducts(pageRequest);

        int total = procutService.getTotalCount(pageRequest);

        Result result = ResultGenerator.genSuccessResult(products, total);
        return result.toString();
    }

//    @ResponseBody
//    @PostMapping(value = "/product/create")
//    public String addProduct(@RequestBody CreateProductRequest request) {
//
//        CreateProductResponse.Data response = procutService.addProduct(request);
//
//        Result result = ResultGenerator.genSuccessResult(response);
//        return result.toString();
//    }

//    @ResponseBody
//    @PutMapping(value = "/product/update")
//    public String updateProduct(@RequestBody UpdateProductRequest request) {
//
//        procutService.updateProduct(request);
//        Result result = ResultGenerator.genSuccessResult();
//
//        return result.toString();
//    }
//
//    @ResponseBody
//    @DeleteMapping(value = "/product/delete/{productKey}")
//    public String deleteProductById(@PathVariable("productKey") String productKey) {
//
//        procutService.deleteProductByProductKey(productKey);
//
//        Result result = ResultGenerator.genSuccessResult();
//
//        return result.toString();
//    }

    @ResponseBody
    @GetMapping(value = "/getProduct/{id}")
    public String getProductById(@PathVariable("id") String id) {
        Product product = procutService.getProductById(id);

        Result result = ResultGenerator.genSuccessResult(product);
        return result.toString();
    }

    // #########################   Type   ##############################
    @ResponseBody
    @PostMapping(value = "/getTypes")
    public String getTypes(@RequestBody PageRequest pageQuery) {
        List<Type> types = typeService.getTypes(pageQuery);

        int total = typeService.getTotalCount(pageQuery);

        Result result = ResultGenerator.genSuccessResult(types, total);
        return result.toString();
    }

    @ResponseBody
    @PostMapping(value = "/type/create")
    public String addType(@RequestBody Type type) {

        int id = typeService.addType(type);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);

        PageRequest pageQuery = new PageRequest();
        int total = typeService.getTotalCount(pageQuery);

        Result result = ResultGenerator.genSuccessResult(jsonObject, total);
        return result.toString();
    }


    @ResponseBody
    @PutMapping(value = "/type/update")
    public String updateType(@RequestBody Type type) {

        int iResult = typeService.updateType(type);
        Result result = null;
        if (iResult == 1) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("类型信息没有更新");
        }

        return result.toString();
    }

    @ResponseBody
    @DeleteMapping(value = "/type/delete/{id}")
    public String deleteTypeById(@PathVariable("id") int id) {

        int iResult = typeService.deleteTypeById(id);

        Result result = null;
        if (iResult == 1) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("类型信息没有删除");
        }

        return result.toString();
    }

    // #########################   Device   ##############################
    @ResponseBody
    @PostMapping(value = "/getDevices")
    public String getDevices(@RequestBody PageRequest pageQuery) {
        List<Device> devices = deviceService.getDevices(pageQuery);

        int total = deviceService.getTotalCount(pageQuery);

        Result result = ResultGenerator.genSuccessResult(devices, total);
        return result.toString();
    }

    @ResponseBody
    @PostMapping(value = "/device/create")
    public String addDevice(@RequestBody Device device) {

        int id = deviceService.addDevice(device);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);

        PageRequest pageQuery = new PageRequest();
        int total = deviceService.getTotalCount(pageQuery);

        Result result = ResultGenerator.genSuccessResult(jsonObject, total);
        return result.toString();
    }


    @ResponseBody
    @PutMapping(value = "/device/update")
    public String updateDevice(@RequestBody Device device) {

        int iResult = deviceService.updateDevice(device);
        Result result = null;
        if (iResult == 1) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("设备信息没有更新");
        }

        return result.toString();
    }

    @ResponseBody
    @DeleteMapping(value = "/device/delete/{id}")
    public String deleteDeviceById(@PathVariable("id") int id) {

        int iResult = deviceService.deleteDeviceById(id);

        Result result = null;
        if (iResult == 1) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("设备信息没有删除");
        }

        return result.toString();
    }

//    @ResponseBody
//    @PostMapping(value = "/queryDevices")
//    public String getDevices(@RequestBody QueryDeviceRequest request) {
//
//        QueryDeviceResponse response = deviceService.queryDevice(request);
//
////        // 填充请求
////        BatchQueryDeviceDetailRequest batchDetailRequest = new BatchQueryDeviceDetailRequest();
////        List<String> deviceNames = new ArrayList<String>(); // 目标设备名列表
////        for (QueryDeviceResponse.DeviceInfo item : response.getData()) {
////            deviceNames.add(item.getDeviceName());
////        }
////
////        List<BatchQueryDeviceDetailResponse.DataItem> deviceDetailList =
////                DeviceManager.batchQueryDeviceDetail(request.getProductKey(), deviceNames);
//
//        Result result = ResultGenerator.genSuccessResult(response);
//        return result.toString();
//    }
//
//    @ResponseBody
//    @PostMapping(value = "/device/create")
//    public String addDevice(@RequestBody RegisterDeviceRequest request) {
//
//        RegisterDeviceResponse.Data data = deviceService.registerDevice(
//                request.getProductKey(),
//                request.getDeviceName());
//
//        Result result = ResultGenerator.genSuccessResult(data);
//        return result.toString();
//    }
}
