package com.doll.doll_mall.mapper;

import com.doll.doll_mall.pojo.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/23 13:24
 */
@Repository
public interface CartMapper {
    /*添加购物车信息*/
    int insertCart(Cart cart);
    /*根据用户的id查询购物车中的信息*/
    List<Cart> carts(Integer userId);

    /*修改购物车中的商品*/
    int updateCart(Cart cart);

    /*根据商品的名字删除*/
    int delCart(Integer goodsId);

    /*根据购物车的id删除信息*/
    int delCartById(Integer cartId);

    /*批量删除*/
    int deleteBatch(String ids);

    /*根据用户的id删除购物车*/
    int delCartByUserId(Integer userId);

    /*根据购物车id查询商品*/
    Cart getCartByCartId(Integer cartId);

}
