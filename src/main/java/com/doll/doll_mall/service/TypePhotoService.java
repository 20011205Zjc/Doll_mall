package com.doll.doll_mall.service;

import com.doll.doll_mall.mapper.TypePhotoMapper;
import com.doll.doll_mall.pojo.TypePhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/12/3 10:02
 */

@Service
public class TypePhotoService {
    @Autowired
    private TypePhotoMapper typePhotoMapper;

    public List<TypePhoto> typePhotos(){
        return typePhotoMapper.getAllPhoto();
    }
}
