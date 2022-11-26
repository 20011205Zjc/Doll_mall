package com.doll.doll_mall.service;

import com.doll.doll_mall.mapper.GoodsTypeMapper;
import com.doll.doll_mall.pojo.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/26 10:59
 */
@Service
public class GoodsTypeService {
    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    public List<GoodsType> goodsTypes(){
        return goodsTypeMapper.getAllGoodsType();
    }
}
