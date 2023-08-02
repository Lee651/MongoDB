package top.rectorlee.server;

import top.rectorlee.entity.CustomerOrderDetail;
import top.rectorlee.entity.Order;

import java.util.List;

public interface MongoDBService {
    List<Order> getOrders();

    List<CustomerOrderDetail> getCustomerOrderDetail();
}
