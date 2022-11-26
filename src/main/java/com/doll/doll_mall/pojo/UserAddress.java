package com.doll.doll_mall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/19 10:59
 */
/*用户的地址*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserAddress {
    private Integer userAreaId;
    private String province;
    private String city;
    private String area;
    private String address;
    private Integer userId;
}
