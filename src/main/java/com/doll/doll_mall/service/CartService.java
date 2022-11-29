package com.doll.doll_mall.service;

import com.doll.doll_mall.mapper.CartMapper;
import com.doll.doll_mall.pojo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/23 13:27
 */
@Service
public class CartService {
    @Autowired
    private CartMapper cartMapper;

    public void insertCart(Cart cart){
        cartMapper.insertCart(cart);
    }

    /**/
    public List<Cart> carts(Integer userId){
        return cartMapper.carts(userId);
    }

    public void updateCart(Cart cart){
        cartMapper.updateCart(cart);
    }

    /**/
    public void delCart(Integer goodsId){
        cartMapper.delCart(goodsId);
    }

    public void delBatch(String ids){
        cartMapper.deleteBatch(ids);
    }

    public void delCartById(Integer cartId){
        cartMapper.delCartById(cartId);
    }

    public void delCartByUserId(Integer userId){
        cartMapper.delCartByUserId(userId);
    }

    public Cart getCartByCartId(Integer cartId){
        return cartMapper.getCartByCartId(cartId);
    }
}
