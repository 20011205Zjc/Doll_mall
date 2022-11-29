package com.doll.doll_mall.mapper;

import com.doll.doll_mall.pojo.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/8 12:14
 */
@Repository
public interface GoodsMapper {

    /*查询所有的玩偶*/
    List<Goods> getAllGoods();

    /*根据id查询商品的信息*/
    List<Goods> getGoodsById(int id);

    /*<!--查询出商品以及商品各个尺寸的库存-->*/
    Goods getGoodsAndGoodsSize(@Param("goodsName") String goodsName);

    /*增加商品*/
    void insertGoods(Goods goods);

    /*控制查询的条数为四条根据销量*/
    List<Goods> getGoodsBySalesVolume();

    /*根据推荐*/
    List<Goods> getGoodsByRecommend();

    /*根据商品的描述1进行模糊查询*/
    List<Goods> getGoodsByLike(String goodsDescribe1);

    /*删除商品*/
    int DelGoods(Integer id);
    /*修改商品*/
    int UpdateGoods(Goods goods);

    /*根据商店的id查出这个商店下最热销的商品*/
    List<Goods> goods(Integer shopId);

    /*根据类型id查询商品*/
    List<Goods> getGoodsByTypeId(Integer typeId);


}
