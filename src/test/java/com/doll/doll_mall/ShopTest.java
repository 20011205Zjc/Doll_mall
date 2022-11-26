package com.doll.doll_mall;

import com.doll.doll_mall.pojo.Shop;
import com.doll.doll_mall.pojo.User;
import com.doll.doll_mall.service.ShopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/16 11:10
 */

@SpringBootTest
public class ShopTest {
    @Autowired
    private ShopService shopService;
/*    @Test
    void testInsert(){
        Shop shop = new Shop(null,"我的商店","2233","这是员工商店",23,null,1);
        shopService.insertShop(shop);
    }*/

    @Test
    void getUserAdShop(){
        User userAndShop = shopService.getUserAndShop(2);
        System.out.println(userAndShop);
    }

    @Test
    void test(){
        Shop shopAndGoods = shopService.getShopAndGoods(8);
        System.out.println(shopAndGoods);
    }

    @Test
    void test1(){
        System.out.println(UUID.randomUUID());
    }

    @Test
    void tes(){
        System.out.println(new Date().getTime());
    }

    @Test
    void testShops(){
        System.out.println(shopService.shops());
    }
}
