package com.doll.doll_mall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/19 9:21
 */
/*省市区级联动 ====>>区*/
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
public class Area{
    private Integer AreaId;
    private String AreaCode;
    private String AreaName;
    private String citycode;
}
