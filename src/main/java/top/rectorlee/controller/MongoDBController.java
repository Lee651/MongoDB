package top.rectorlee.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.rectorlee.entity.CustomerOrderDetail;
import top.rectorlee.entity.Order;
import top.rectorlee.server.MongoDBService;

import java.util.List;

/**
 * @description:
 * @author: Lee
 * @date: 2023-08-02 12:15:22
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/mongodb")
public class MongoDBController {
    @Autowired
    private MongoDBService mongoDBService;

    /**
     * 获取订单列表
     */
    @RequestMapping("/orders")
    public List<Order> getOrders() {
        return mongoDBService.getOrders();
    }

    /**
     * 获取每个用户下的所有订单详情(用户文档与定单文档关联查询)
     */
    @RequestMapping("/detail")
    public List<CustomerOrderDetail> getCustomerOrderDetail() {
        return mongoDBService.getCustomerOrderDetail();
    }
}
