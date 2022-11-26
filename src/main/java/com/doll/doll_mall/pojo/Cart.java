package com.doll.doll_mall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/23 12:18
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cart {
    private Integer cartId;
    private String goodsDescribe1;
    private String goodsPhoto1;
    private String goodsSize;
    private Integer goodsCount;
    private double totalPrice;
    private Integer goodsId;
    private Integer userId;
}
