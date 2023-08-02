package top.rectorlee.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @description:
 * @author: Lee
 * @date: 2023-08-02 12:36:28
 * @version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {
    @Id
    private String id;

    private Integer goodsId;

    private Integer price;

    private String goodsName;

    private String description;
}
