package com.doll.doll_mall.controller;

import com.doll.doll_mall.pojo.*;
import com.doll.doll_mall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/16 10:21
 */

@Controller
public class MerchantController {
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private GoodsSizeService goodsSizeService;

    @Autowired
    private CartService cartService;
    @Autowired
    private GoodsTypeService goodsTypeService;

    /*发送请求到注册成为商家的页面*/
    @RequestMapping("/Shop")
    public String Shop(int userId, Model model){
        model.addAttribute("userId",userId);
        List<User> userById = userService.getUserById(userId);
        model.addAttribute("user",userById);
        for (User user : userById) {
            model.addAttribute("userEmail",user.getUserEmail());
        }
        return "shop/shop";
    }

    /*提交申请*/
    @RequestMapping("/insertShop")
    public String insertShop(Shop shop){
        User user = new User(shop.getUserId(),null,null,null,null,null,null,"merchant",null,null);
        userService.updateUserByIf(user);
        shopService.insertShop(shop);
        return "redirect:/out";
    }
    /*验证商店的名字是否而用*/
    @RequestMapping("/shopName")
    @ResponseBody
    public String shopName(String shopName){
        List<Shop> shops = shopService.shops();
        for (Shop shop : shops) {
            if (Objects.equals(shop.getShopName(), shopName)){
                return "1";
            }else {
                return "2";
            }
        }
        return "null";
    }

    /*发送请求看看该用户是否是商家*/
    @RequestMapping("/sp")
    @ResponseBody
    public String Rsp(int userId){
        List<User> userById = userService.getUserById(userId);
        for (User user : userById) {
            if (Objects.equals(user.getRoles(), "merchant")){
                System.out.println("执行了1");
                return "1";
            }else {
                System.out.println("执行了2");
                return "2";
            }
        }
        return "2233";
    }

    /*携带用户的id前往商家控制台*/
    @RequestMapping("/spController")
    public String spController(int userId,Model model){
        User userAndShop = shopService.getUserAndShop(userId);
        Integer shopId = userAndShop.getShop().getShopId();
        System.out.println("商店的id"+shopId);
        List<Goods> goods = shopService.getShopAndGoods(shopId).getGoods();
        model.addAttribute("goods",goods);
        model.addAttribute("shopId",shopId);
        model.addAttribute("userAndShop",userAndShop);
        return "shop/shopController";
    }

    /*跳转到添加商品页*/
    @RequestMapping("/tj")
    public String tj(int userId,Model model,int shopId){
        model.addAttribute("userId",userId);
        model.addAttribute("shopId",shopId);
        System.out.println(shopId);
        model.addAttribute("goodsName", new Date().getTime());
        model.addAttribute("type",goodsTypeService.goodsTypes());
        return "shop/insertGoods";
    }

    /*添加商品*/
    @RequestMapping("/insertGoods")
    public String insertGoods(Goods goods, goodsSize goodsSize, HttpServletRequest request){
        HttpSession session = request.getSession();
        Object userId1 = session.getAttribute("userId");
        goodsService.insertGoods(goods);
        goodsSizeService.insertSize(goodsSize);
        return "redirect:spController?userId="+userId1;
    }

    /*ajax实现商品的名称不可重复*/
    @RequestMapping("/goodsCF")
    @ResponseBody
    public String goodsNameCf(String goodsName){
        List<Goods> allGoods = goodsService.getAllGoods();
        for (Goods allGood : allGoods) {
            if (Objects.equals(allGood.getGoodsName(), goodsName)){
                return "1";
            }
        }
        return "2";
    }

    /*删除商品*/
    @RequestMapping("/delGoods")
    public String delGoods(Integer id,Integer userId){
        cartService.delCart(id);
        goodsService.DelGoods(id);
        return "redirect:/spController?userId="+userId;
    }

}
