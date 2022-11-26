package com.doll.doll_mall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/3 16:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userAge;
    private String userGender;
    private String userEmail;
    private String headPhoto;
    private String roles;
    private Shop shop;
    private List<UserAddress> userAddresses;
}
