package top.rectorlee.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;
import top.rectorlee.entity.CustomerOrderDetail;
import top.rectorlee.entity.Order;
import top.rectorlee.server.MongoDBService;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Lee
 * @date: 2023-08-02 12:41:46
 * @version: 1.0
 */
@Service
public class MongoDBServiceImpl implements MongoDBService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Order> getOrders() {
        return mongoTemplate.findAll(Order.class, "orders");
    }

    @Override
    public List<CustomerOrderDetail> getCustomerOrderDetail() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.lookup("orders", "orderId", "id", "info"),
                Aggregation.unwind("$info"),
                Aggregation.project("name", "age", "gender", "goodsName", "$info.price", "$info.description", "orderId"),
                Aggregation.sort(Sort.Direction.DESC, "price"),
                Aggregation.limit(2),
                Aggregation.skip(1)
        );

        AggregationResults<CustomerOrderDetail> customers = mongoTemplate.aggregate(aggregation, "customers", CustomerOrderDetail.class);

        List<CustomerOrderDetail> list = new ArrayList<>();
        for (CustomerOrderDetail detail : customers) {
            CustomerOrderDetail customerOrderDetail = CustomerOrderDetail.builder()
                    .age(detail.getAge())
                    .orderId(detail.getOrderId())
                    .price(detail.getPrice())
                    .description(detail.getDescription())
                    .gender(detail.getGender())
                    .name(detail.getName())
                    .build();

            list.add(customerOrderDetail);
        }
        return list;
    }
}
