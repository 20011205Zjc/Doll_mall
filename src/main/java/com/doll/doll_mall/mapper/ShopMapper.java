package com.doll.doll_mall.mapper;

import com.doll.doll_mall.pojo.Shop;
import com.doll.doll_mall.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/16 10:50
 */
@Repository
public interface ShopMapper {
    /*添加商家*/
    void insertShop(Shop shop);

    /*根据用户查询用户的商店*/
    User getUserAndShop(int userId);

    /*根据商店的id查询该商店下所有的商品*/
    Shop getShopAndGoodsByShopId(Integer shopId);
    /*查询所有的商店*/
    List<Shop> shops();
}
