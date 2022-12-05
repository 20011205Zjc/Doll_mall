package com.doll.doll_mall;

import com.doll.doll_mall.pojo.goodsSize;
import com.doll.doll_mall.service.GoodsService;
import com.doll.doll_mall.service.GoodsSizeService;
import com.doll.doll_mall.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/16 16:57
 */

@SpringBootTest
public class goodsSizeTest {
    @Autowired
    private GoodsSizeService goodsSizeService;
    @Autowired
    private GoodsService goodsService;

/*    @Test
    void testInsertSize(){
        goodsSize goodsSize = new goodsSize(null,"44","10","1",2);
        goodsSizeService.insertSize(goodsSize);
    }*/

    @Test
    void MD5(){
        String md5 = MD5Util.getMD5("123456");
        System.out.println(md5);
    }

    @Test
    void testS(){
        System.out.println(goodsService.goods(8));
    }

    @Test
    void testSize(){
        goodsSizeService.updateSize(new goodsSize(70,0,999,250,"1669875276189"));
    }
    @Test
    void test3(){
        System.out.println(goodsSizeService.getGoodsSizeById(67));
    }
    @Test
    void test4(){
        System.out.println(goodsSizeService.getGoodsSizeByGoodsName("1669875100586"));
    }
}
