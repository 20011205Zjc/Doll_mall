package com.doll.doll_mall;

import com.doll.doll_mall.pojo.Goods;
import com.doll.doll_mall.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/9 11:51
 */

@SpringBootTest
public class goodsTest {
    @Autowired
    private GoodsService goodsService;

    @Test
    void testAllGoods(){
        List<Goods> allGoods = goodsService.getAllGoods();
        System.out.println(allGoods);
    }

    @Test
    void testGetGoodsById(){
        List<Goods> goodsById = goodsService.getGoodsById(1);
        System.out.println(goodsById);
    }

/*    @Test
    void test(){
        Goods goods = goodsService.getGoodsAndGoodsSize(1);
        System.out.println(goods);
    }*/

    @Test
    void testinsertGoods(){
        goodsService.insertGoods(new Goods(null,"图七","123","123","123","123","123",2233,"123","123","123","123123","123","123",10,1,1,null));
    }

    @Test
    void getGoodsBySalesVolume(){
        System.out.println(goodsService.getGoodsBySalesVolume());
    }

    @Test
    void getGoodsByLike(){
        System.out.println(goodsService.getGoodsByLike("史迪奇"));
    }

    @Test
    void delGoods(){
        goodsService.DelGoods(3);
    }
    @Test
    void updateGoods(){
        goodsService.UpdateGoods(new Goods(22,"223333",null,"",null,"",null,2,null,"","",null,"",null,2,2,2,null));
    }

    @Test
    void test(){
        System.out.println(goodsService.getGoodsByShopId(2));
    }
}
