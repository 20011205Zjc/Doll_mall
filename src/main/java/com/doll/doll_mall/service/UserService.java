package com.doll.doll_mall.service;

import com.doll.doll_mall.mapper.UserMapper;
import com.doll.doll_mall.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/3 16:54
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /*查询所有的用户*/
    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }

    /*添加用户信息*/
    public void insertUser(User user){
        userMapper.insertUser(user);
    }

    /*搜索联想*/
    public List<User> getLikeUsername(String username){
        return userMapper.getLikeUsername(username);
    }

/*修改用户信息*/
    public void updateUser(User user){
        userMapper.updateUser(user);
    }

    /*删除用户信息*/
    public void delUser(int id){
        userMapper.delUser(id);
    }

    /*根据id查询用户信息*/
    public List<User> getUserById(int id){
        return userMapper.getUserById(id);

    }

    /*动态失去了实现用户修改*/
    public void updateUserByIf(User user){
        userMapper.updateUserBy(user);
    }

}
