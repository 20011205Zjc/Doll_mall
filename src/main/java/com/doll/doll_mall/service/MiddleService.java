package com.doll.doll_mall.service;

import com.doll.doll_mall.mapper.MiddleMapper;
import com.doll.doll_mall.pojo.Middle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/29 15:06
 */

@Service
public class MiddleService {
    @Autowired
    private MiddleMapper middleMapper;

    public List<Middle> middles(){
        return middleMapper.getAllMiddle();
    }

    public void insertMiddle(Middle middle){
        middleMapper.insertMiddle(middle);
    }

    public void delAll(){
        middleMapper.delAll();
    }

    public void delMiddle(Integer userId){
        middleMapper.delMiddle(userId);
    }
}
