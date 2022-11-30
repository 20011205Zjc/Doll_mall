package com.doll.doll_mall.controller;

import com.doll.doll_mall.pojo.*;
import com.doll.doll_mall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private UserService userService;

    @Autowired
    private MiddleService middleService;

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
                return "redirect:/goods?getGoodsName="+goodsName+"&shopId="+shopId;
            }
        }

        cartService.insertCart(cart);
        return "redirect:/goods?getGoodsName="+goodsName+"&shopId="+shopId;
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
        System.out.println("执行了："+id);
        cartService.delCartById(id);
        return "redirect:/goCart";
    }

    /*清空购物车*/
    @RequestMapping("/delAll")
    public String delAll(Integer id){
        System.out.println("执行了："+id);
        cartService.delCartByUserId(id);
        return "redirect:/goCart";
    }

    /*跳转到确认订单页面*/
    @RequestMapping("/checkout")
    public String checkout(HttpServletRequest request,Model model,Cart cart,Integer code){
        /*用户信息返回*/
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        List<User> userById = userService.getUserById(userId);
        for (User user : userById) {
            model.addAttribute("userName",user.getUserName());
            model.addAttribute("userEmail",user.getUserEmail());
            model.addAttribute("userAddress",user.getUserAddresses());
        }

        /*判断要返回的商品*/
        try {
            if (code == 1){
                model.addAttribute("carts",cart);
                System.out.println("执行了"+code+"||"+cart);
                return "user/checkout";
            }
        }catch (Exception e){
            System.out.println("没有code");
        }

        List<Middle> middles = middleService.middles();
        ArrayList<Cart> carts = new ArrayList<>();
        for (Middle middle : middles) {
            Integer cartId = middle.getCartId();
            System.out.println("购物车的id："+cartId);
            carts.add(cartService.getCartByCartId(cartId));
            System.out.println("中间表的："+carts);
        }
        model.addAttribute("carts",carts);
        System.out.println("自定义的list集合"+carts);
        return "user/checkout";

    }

}
