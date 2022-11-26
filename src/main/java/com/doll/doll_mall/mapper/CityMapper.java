package com.doll.doll_mall.mapper;

import com.doll.doll_mall.pojo.City;
import org.springframework.stereotype.Repository;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/19 10:18
 */
@Repository
public interface CityMapper {
    /*根据市的code查询下面的区*/
    City getCityAndArea(String areaCode);

    /*查询市的code*/
    City city(String name);


}
