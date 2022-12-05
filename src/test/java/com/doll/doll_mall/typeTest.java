package com.doll.doll_mall;

import com.doll.doll_mall.service.TypePhotoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/12/3 10:03
 */

@SpringBootTest
public class typeTest {
    @Autowired
    TypePhotoService typePhotoService;
    @Test
    public void TestType1(){
        System.out.println(typePhotoService.typePhotos());
    }

    @Test
    void test2(){
        System.out.println();
    }
}
