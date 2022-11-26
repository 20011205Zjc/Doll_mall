package com.doll.doll_mall.mapper;

import com.doll.doll_mall.pojo.Province;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/19 9:23
 */
@Repository
public interface ProvinceMapper {
    /*查出所有的省*/
   List<Province> province();
   /*根据省份查出对应的市*/
    Province getProvinceAndCity(String provincecode);

    /*根据省份查询code*/
    Province province1(String name);
}
