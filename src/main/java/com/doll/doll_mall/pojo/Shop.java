package com.doll.doll_mall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/16 10:47
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Shop {
    private Integer shopId;
    private String shopName;
    private String shopPhoto;
    private String shopDescribe;
    private Integer collectContent;
    private String state;
    private Integer userId;
    private List<Goods> goods;
}
