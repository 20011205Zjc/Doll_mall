package com.doll.doll_mall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/19 9:16
 */
/*省市区级联动 ====>>省*/
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Province {
    private Integer id;
    private String code;
    private String name;
    private List<City> cities;
}
