package com.doll.doll_mall.service;

import com.doll.doll_mall.mapper.GoodsSizeMapper;
import com.doll.doll_mall.pojo.goodsSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/16 16:56
 */
@Service
public class GoodsSizeService {
    @Autowired
    private GoodsSizeMapper goodsSizeMapper;

    public void insertSize(goodsSize goodsSize){
        goodsSizeMapper.insertSize(goodsSize);
    }
    /**/
    public void updateSize(goodsSize goodsSize){
        goodsSizeMapper.updateSize(goodsSize);
    }
    /*根据id查询对应的库存*/
    public goodsSize getGoodsSizeById(Integer id){
        return goodsSizeMapper.getGoodsSizeById(id);
    }

    /*根据goodsName查询对应的商品*/
    public goodsSize getGoodsSizeByGoodsName(String goodsName){
        return goodsSizeMapper.getGoodsSizeByGoodsName(goodsName);
    }
}
