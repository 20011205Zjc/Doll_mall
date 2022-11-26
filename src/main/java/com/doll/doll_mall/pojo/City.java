package com.doll.doll_mall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/19 9:19
 */
/*省市区级联动 ====>>市*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class City {
    private Integer ctyId;
    private String cityCode;
    private String cityName;
    private String provincecode;
    private List<Area> areas;
}
