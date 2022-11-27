package com.doll.doll_mall.controller;

import com.doll.doll_mall.pojo.Cart;
import com.doll.doll_mall.pojo.Goods;
import com.doll.doll_mall.service.CartService;
import com.doll.doll_mall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/23 12:17
 */

@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/addCart")
    public String addCart(Cart cart,Integer shopId,String goodsName,HttpServletRequest request){
        System.out.println("商店id："+shopId);
        HttpSession session = request.getSession();
        System.out.println("用户的id："+session.getAttribute("userId"));
        cart.setUserId((Integer) session.getAttribute("userId"));

        /*如果加入购物车的商品id和尺寸一样则只改变数量和价格*/
        List<Cart> carts = cartService.carts((Integer) session.getAttribute("userId"));
        System.out.println("hhhhhhh"+goodsName);
        for (Cart cart1 : carts) {
            Goods goodsAndGoodsSize = goodsService.getGoodsAndGoodsSize(goodsName);
            if (Objects.equals(cart1.getGoodsId(), cart.getGoodsId()) && Objects.equals(cart1.getGoodsSize(), cart.getGoodsSize())){
                Integer count = cart1.getGoodsCount()+cart.getGoodsCount();
                if (Objects.equals(cart1.getGoodsSize(), "M")){
                    Integer goodsM = goodsAndGoodsSize.getGoodsSize().getGoodsM();
                    if (count >= goodsM){
                        count = goodsM;
                    }
                }

                if (Objects.equals(cart1.getGoodsSize(), "S")){
                    Integer goodsS = goodsAndGoodsSize.getGoodsSize().getGoodsS();
                    if (count >= goodsS){
                        count = goodsS;
                    }
                }

                if (Objects.equals(cart1.getGoodsSize(), "X")){
                    Integer goodsX = goodsAndGoodsSize.getGoodsSize().getGoodsX();
                    if (count >= goodsX){
                        count = goodsX;
                    }
                }


                double countPrice = cart1.getTotalPrice()+cart.getTotalPrice();
                cartService.updateCart(new Cart(cart1.getCartId(),null,null,null,count,countPrice,null,null));
//                return "redirect:/";
                return "redirect:/goods?getGoodsName="+goodsName+"&shopId="+shopId;
            }
        }

        cartService.insertCart(cart);
        return "redirect:/goods?getGoodsName="+goodsName+"&shopId="+shopId;
//        return "redirect:/";
    }

    @RequestMapping("/goCart")
    public String goCart(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        List<Cart> Carts = cartService.carts((Integer) session.getAttribute("userId"));
        Integer userId = (Integer) session.getAttribute("userId");
        model.addAttribute("userId",userId);
        model.addAttribute("Carts",Carts);
        return "user/userCart";
    }

    /*批量删除*/

    /*根据id删除购物车信息*/
    @RequestMapping("/delCartById")
    public String delCartById(Integer id){
        cartService.delCartByUserId(id);
        return "redirect:/goCart";
    }

}
