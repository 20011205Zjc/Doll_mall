package com.doll.doll_mall.service;

import com.doll.doll_mall.mapper.ShopMapper;
import com.doll.doll_mall.pojo.Shop;
import com.doll.doll_mall.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/16 11:07
 */
@Service
public class ShopService {
    @Autowired
    private ShopMapper shopMapper;

    /*添加商家信息*/
    public void insertShop(Shop shop){
        shopMapper.insertShop(shop);
    }

    /**/
    public User getUserAndShop(int userId){
        return shopMapper.getUserAndShop(userId);
    }

    /**/
    public Shop getShopAndGoods(Integer shopId){
        return shopMapper.getShopAndGoodsByShopId(shopId);
    }
    /*查询所有的商店信息*/
    public List<Shop> shops(){
        return shopMapper.shops();
    }
}
