package com.doll.doll_mall.mapper;

import com.doll.doll_mall.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/3 16:50
 */

@Repository
public interface UserMapper {
    /*
    * 查询所有的用户信息
    * */
    List<User> getAllUser();

    /*
    * 增加用户信息
    * */
    void insertUser(User user);

    /*搜索联想*/
    List<User> getLikeUsername(String username);

    /*
    * 修改用户信息
    * */
    int updateUser(User user);

    /*删除用户信息*/
    int delUser(int id);

    /*根据id查询用户信息*/
    List<User> getUserById(int id);

    /*动态sql实现用户的修改*/
    int updateUserBy(User user);
}
