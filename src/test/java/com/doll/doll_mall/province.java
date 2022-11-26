package com.doll.doll_mall;

import com.doll.doll_mall.pojo.UserAddress;
import com.doll.doll_mall.service.CityService;
import com.doll.doll_mall.service.ProvinceService;
import com.doll.doll_mall.service.UserAddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/19 9:31
 */
@SpringBootTest
public class province {
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private CityService cityService;
    @Test
    void testProvice(){
        System.out.println(provinceService.provinces());
    }

    @Test
    void testProAndCity(){
        System.out.println(provinceService.provinceAndCity("220000"));
    }
    @Test
    void testCityAndArea(){
        System.out.println(cityService.getCityAndArea("131000"));
    }

    @Test
    void testAddUserAddress(){
        userAddressService.addUserAddress(new UserAddress(null,"云南省","昆明市","安宁市","xxxx",1));
    }
    @Test
    void testCode(){
        System.out.println(provinceService.province("云南省"));
    }

    @Test
    void testCodeName(){
        System.out.println(cityService.areas("天津市"));
    }

    @Test
    void testDel(){
        userAddressService.delUserAddress(7);
    }

    @Test
    void testUpdate(){
        userAddressService.updateAddress(new UserAddress(12,"云南",null,"","2233",4));
    }
}
