package com.doll.doll_mall;

import com.doll.doll_mall.service.GoodsTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/26 11:00
 */
@SpringBootTest
public class goodsTypeTest {
    @Autowired
    private GoodsTypeService goodsTypeService;
    @Test
    void testGoodsTYpe(){
        System.out.println(goodsTypeService.goodsTypes());
    }
}
