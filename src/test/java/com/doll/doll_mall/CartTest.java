package com.doll.doll_mall;

import com.doll.doll_mall.pojo.Cart;
import com.doll.doll_mall.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/23 13:28
 */
@SpringBootTest
public class CartTest {
    @Autowired
    private CartService cartService;
    @Test
    void insertCart(){
        cartService.insertCart(new Cart(null,"这是一个测试","这是一张照片","M",2,12,321,1));
    }
    @Test
    void getCartByUserId(){
        System.out.println(cartService.carts(4));
    }

    @Test
    void updateGoods(){
        cartService.updateCart(new Cart(null,"23",null,"X",999,23,8,4));
    }
}
