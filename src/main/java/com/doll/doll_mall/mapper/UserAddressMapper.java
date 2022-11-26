package com.doll.doll_mall.mapper;

import com.doll.doll_mall.pojo.User;
import com.doll.doll_mall.pojo.UserAddress;
import org.springframework.stereotype.Repository;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/19 11:02
 */
@Repository
public interface UserAddressMapper {
    /*添加地址*/
    int addUserAddress(UserAddress userAddress);
    /*根据用户的id查询地址*/
    User getUserAndAddress(Integer userId);
    /*删除地址*/
    int delUserAddress(Integer userAreaId);

    /*修改地址*/
    int UpdateAddress(UserAddress userAddress);
}
