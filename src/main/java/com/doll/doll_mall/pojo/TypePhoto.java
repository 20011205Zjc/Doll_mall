package com.doll.doll_mall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/12/3 9:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TypePhoto {
    private Integer pId;
    private String typePhoto;
    private Integer typeCode;
}
