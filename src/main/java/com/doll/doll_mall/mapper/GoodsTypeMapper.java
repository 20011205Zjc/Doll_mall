package com.doll.doll_mall.mapper;

import com.doll.doll_mall.pojo.GoodsType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/26 10:56
 */
@Repository
public interface GoodsTypeMapper {
    /*查询所有的类型*/
    List<GoodsType> getAllGoodsType();
}
