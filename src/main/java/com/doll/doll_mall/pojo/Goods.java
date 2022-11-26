package com.doll.doll_mall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/8 12:14
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private Integer goodsId;
    private String goodsName;
    private String goodsDescribe1;
    private String goodsDescribe2;
    private String goodsDescribe3;
    private String goodsDescribe4;
    private String goodsDescribe5;
    private double goodsPrice;
    private String goodsPhoto1;
    private String goodsPhoto2;
    private String goodsPhoto3;
    private String goodsPhoto4;
    private String goodsPhoto5;
    private String recommend;
    private int salesVolume;
    private int typeId;
    private int shopId;
    private goodsSize goodsSize;
}
