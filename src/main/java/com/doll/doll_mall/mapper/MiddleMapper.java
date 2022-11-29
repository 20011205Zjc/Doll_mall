package com.doll.doll_mall.mapper;

import com.doll.doll_mall.pojo.Middle;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/29 15:00
 */

@Repository
public interface MiddleMapper {
    /*查询表中的所有信息*/
    List<Middle> getAllMiddle();
    /*删除表中的所有信息*/
    int delAll();
    /*根据id删除信息*/
    int delMiddleById();
    /*添加信息*/
    int insertMiddle(Middle middle);

    /*根据用户id删除信息*/
    int delMiddle(Integer userId);
}
