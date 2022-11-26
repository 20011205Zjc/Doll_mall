package com.doll.doll_mall.controller;

import com.doll.doll_mall.pojo.User;
import com.doll.doll_mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/3 16:21
 */

@Controller
public class testController {

    @Autowired
    private UserService userService;

    @RequestMapping("/all")
    @ResponseBody
    public List<User> test2(){
        List<User> allUser = userService.getAllUser();
        return allUser;
    }

    @RequestMapping("/50")
    public String te(){
        return "user/login";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/json")
    @ResponseBody
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @RequestMapping("/lx")
    @ResponseBody
    public List<User> getUserByName(String userName){
        System.out.println("搜索联想的值："+ userName);
        return userService.getLikeUsername(userName);
    }


}
