package top.rectorlee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.rectorlee.entity.CustomerOrderDetail;
import top.rectorlee.entity.Order;
import top.rectorlee.server.MongoDBService;

import java.util.List;

/**
 * @description: Knife4j文档地址: http://localhost:9999/doc.html  Swagger文档地址: http://localhost:9999/swagger-ui/index.html
 * @author: Lee
 * @date: 2023-08-02 12:15:22
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/mongodb")
@Tag(name = "MongoDBController", description = "MongoDB接口")
public class MongoDBController {
    @Autowired
    private MongoDBService mongoDBService;

    @Operation(summary = "订单列表接口")
    @RequestMapping("/orders")
    public List<Order> getOrders() {
        return mongoDBService.getOrders();
    }

    @Operation(summary = "用户订单详情")
    @RequestMapping("/detail")
    public List<CustomerOrderDetail> getCustomerOrderDetail() {
        return mongoDBService.getCustomerOrderDetail();
    }
}
