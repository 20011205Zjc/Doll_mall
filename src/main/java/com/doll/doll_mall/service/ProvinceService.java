package com.doll.doll_mall.service;

import com.doll.doll_mall.mapper.ProvinceMapper;
import com.doll.doll_mall.pojo.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/19 9:29
 */
@Service
public class ProvinceService {
    @Autowired
    private ProvinceMapper provinceMapper;
    public List<Province> provinces(){
        return provinceMapper.province();
    }
    /**/
    public Province provinceAndCity(String code){
        return provinceMapper.getProvinceAndCity(code);
    }

    /*根据名字查询code*/
    public Province province(String name){
        return provinceMapper.province1(name);
    }
}
