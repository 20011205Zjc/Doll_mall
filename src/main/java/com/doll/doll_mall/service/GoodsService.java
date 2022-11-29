package com.doll.doll_mall.service;

import com.doll.doll_mall.mapper.GoodsMapper;
import com.doll.doll_mall.pojo.Goods;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/9 11:52
 */

@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    public List<Goods> getAllGoods(){
        return goodsMapper.getAllGoods();
    }

    /*根据id查询商品信息*/
    public List<Goods> getGoodsById(int id){
        return goodsMapper.getGoodsById(id);
    }

    public Goods getGoodsAndGoodsSize(String getGoodsName){
        return goodsMapper.getGoodsAndGoodsSize(getGoodsName);
    }

    public void insertGoods(Goods goods){
        goodsMapper.insertGoods(goods);
    }

    public List<Goods> getGoodsBySalesVolume(){
        return goodsMapper.getGoodsBySalesVolume();
    }

    public List<Goods> getGoodsByRecommend(){
        return goodsMapper.getGoodsByRecommend();
    }

    /*获取员工 的分页信息*/
    public PageInfo<Goods> getAllGoodsPage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum,10);
        //查询所有的员工信息
        List<Goods> list = goodsMapper.getAllGoods();
        //获取分页相关数据
        return new PageInfo<>(list,5);
    }

    /*工具商品的描述1进行模糊查询并进行分页*/
    public List<Goods> getGoodsByLike(String goodsDescribe1){
        return goodsMapper.getGoodsByLike(goodsDescribe1);
    }
    /*查询的商品进行分页*/
    public PageInfo<Goods> getGoodsByLikePage(Integer pageNum,String goodsDescribe1){
        PageHelper.startPage(pageNum,20);
        List<Goods> list = goodsMapper.getGoodsByLike(goodsDescribe1);
        return new PageInfo<>(list,5);
    }

    /*删除商品*/
    public void DelGoods(Integer id){
        goodsMapper.DelGoods(id);
    }

    /*修改商品*/
    public void UpdateGoods(Goods goods){
        goodsMapper.UpdateGoods(goods);
    }

    /*查出本店热销*/
    public List<Goods> goods(Integer shopId){
        return goodsMapper.goods(shopId);
    }

    /*根据类型id查询所有的商品*/
    public List<Goods> getGoodsByShopId(Integer id){
        return goodsMapper.getGoodsByTypeId(id);
    }

}
