package com.doll.doll_mall.controller;

import com.doll.doll_mall.pojo.*;
import com.doll.doll_mall.service.CityService;
import com.doll.doll_mall.service.ProvinceService;
import com.doll.doll_mall.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/19 10:53
 */
@Controller
public class AreaController {
    @Autowired
    private CityService cityService;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private UserAddressService userAddressService;

    @RequestMapping("/address")
    public String address(Integer userId, Model model){
        User userAndAddress = userAddressService.getUserAndAddress(userId);
        List<Province> provinces = provinceService.provinces();
        model.addAttribute("uad",userAndAddress.getUserAddresses());
        model.addAttribute("userId",userId);
        model.addAttribute("provinces",provinces);
        model.addAttribute("userAndAddress",userAndAddress.getUserAddresses());
        return "user/address";
    }

    @RequestMapping("/getProvince")
    @ResponseBody
    public List<Province> provinces(){
        return provinceService.provinces();
    }

    @RequestMapping("/city")
    @ResponseBody
    public List<City> cities(String name){
        Province province = provinceService.province(name);
        System.out.println("cityName:"+name);
        System.out.println("dasdsa"+province);
        Province province1 = provinceService.provinceAndCity(province.getCode());
//        System.out.println("city："+province1.getCities());
        return province1.getCities();
    }
    @RequestMapping("/area")
    @ResponseBody
    public List<Area> areas(String name){
        City areas = cityService.areas(name);
        City cityAndArea = cityService.getCityAndArea(areas.getCityCode());
        return cityAndArea.getAreas();
    }

    /*添加地址*/
    @RequestMapping("/userAddress")
    public String userAddress(UserAddress userAddress,Integer userId){
        userAddressService.addUserAddress(userAddress);
        return "redirect:/address?userId="+userId;
    }

    /*删除地址*/
    @RequestMapping("/delAddress")
    public String delAddress(Integer userAreaId,Integer userId){
        userAddressService.delUserAddress(userAreaId);
        return "redirect:/address?userId="+userId;
    }
    /*修改地址*/
    @RequestMapping("/updateAddress")
    public String updateAddress(UserAddress userAddress,Integer userId){
        System.out.println("2233"+userAddress);
        userAddressService.updateAddress(userAddress);
        return "redirect:/address?userId="+userId;
    }
}
