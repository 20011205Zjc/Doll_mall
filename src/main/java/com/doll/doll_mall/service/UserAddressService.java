package com.doll.doll_mall.service;

import com.doll.doll_mall.mapper.UserAddressMapper;
import com.doll.doll_mall.pojo.User;
import com.doll.doll_mall.pojo.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/19 11:05
 */
@Service
public class UserAddressService {
    @Autowired
    private UserAddressMapper userAddressMapper;
    public void addUserAddress(UserAddress userAddress){
        userAddressMapper.addUserAddress(userAddress);
    }

    public User getUserAndAddress(Integer userId){
        return userAddressMapper.getUserAndAddress(userId);
    }

    /*根据id删除用户地址*/
    public void delUserAddress(Integer userAreaId){
        userAddressMapper.delUserAddress(userAreaId);
    }

    /*修改地址*/
    public void updateAddress(UserAddress userAddress){
        userAddressMapper.UpdateAddress(userAddress);
    }
}
