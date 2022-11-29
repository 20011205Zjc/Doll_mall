package com.doll.doll_mall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/29 14:59
 */

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Middle {
    private Integer middleId;
    private Integer cartId;
    private Integer userId;
}
