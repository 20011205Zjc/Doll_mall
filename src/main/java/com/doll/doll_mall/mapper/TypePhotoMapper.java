package com.doll.doll_mall.mapper;

import com.doll.doll_mall.pojo.TypePhoto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/12/3 10:00
 */

@Repository
public interface TypePhotoMapper {
    /*查询所有的类型图片*/
    List<TypePhoto> getAllPhoto();
}
