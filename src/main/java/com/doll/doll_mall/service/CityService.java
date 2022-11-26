package com.doll.doll_mall.service;

import com.doll.doll_mall.mapper.CityMapper;
import com.doll.doll_mall.pojo.Area;
import com.doll.doll_mall.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/19 10:46
 */
@Service
public class CityService {
    @Autowired
    private CityMapper cityMapper;
    public City getCityAndArea(String code){
        return cityMapper.getCityAndArea(code);
    }

    public City areas(String name){
        return cityMapper.city(name);
    }
}
