package com.doll.doll_mall.mapper;

import com.doll.doll_mall.pojo.goodsSize;
import org.springframework.stereotype.Repository;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/16 16:51
 */
@Repository
public interface GoodsSizeMapper {

    /*增加商品的尺寸*/
    void insertSize(goodsSize goodsSize);
    /*修改商品的尺寸*/
    void updateSize(goodsSize goodsSize);
    /*根据id查询对应尺寸的数量*/
    goodsSize getGoodsSizeById(Integer id);
    /*根据goodsName查询对应的库存*/
    goodsSize getGoodsSizeByGoodsName(String goodsName);

}
