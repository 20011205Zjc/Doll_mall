package com.doll.doll_mall.controller;

import com.doll.doll_mall.pojo.Middle;
import com.doll.doll_mall.pojo.User;
import com.doll.doll_mall.pojo.UserAddress;
import com.doll.doll_mall.service.CartService;
import com.doll.doll_mall.service.GoodsService;
import com.doll.doll_mall.service.MiddleService;
import com.doll.doll_mall.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/29 16:05
 */

@Controller
public class MiddleController {
    @Autowired
    private MiddleService middleService;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserAddressService userAddressService;
    @RequestMapping("/getMiddle")
    @ResponseBody
    public String getMiddle(Integer id, HttpServletRequest request){
        HttpSession session = request.getSession();
        Object userId = session.getAttribute("userId");
        System.out.println("用户的登录id32321："+userId);
        middleService.insertMiddle(new Middle(null,id,(Integer) userId));
//        cartService.delCartById(id);
        return "1";

    }

    @RequestMapping("/delCheck")
    @ResponseBody
    public String dleCheck(HttpServletRequest request){
        System.out.println("执行了");
        HttpSession session = request.getSession();
        Object userId = session.getAttribute("userId");
        middleService.delMiddle((Integer) userId);
//        middleService.delAll();
        return "1";
    }

    @RequestMapping("/getUserAddress")
    @ResponseBody
    public List<UserAddress> addresses(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Object userId = session.getAttribute("userId");
        User userAndAddress = userAddressService.getUserAndAddress((Integer) userId);
        return userAndAddress.getUserAddresses();
    }
}
