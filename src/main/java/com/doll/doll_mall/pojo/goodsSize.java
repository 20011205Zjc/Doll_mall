package com.doll.doll_mall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/15 9:37
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class goodsSize {
    private Integer goodsSizeId;
    private Integer goodsS;
    private Integer goodsM;
    private Integer goodsX;
    private String goodsName;
}
