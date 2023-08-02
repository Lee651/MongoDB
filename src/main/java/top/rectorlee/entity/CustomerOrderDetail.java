package top.rectorlee.entity;

import lombok.*;

/**
 * @description:
 * @author: Lee
 * @date: 2023-08-02 12:52:22
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerOrderDetail {
    private String name;

    private Integer age;

    private String gender;

    private Integer price;

    private Integer orderId;

    private String description;
}
