package com.doll.doll_mall.controller;

import com.doll.doll_mall.pojo.Goods;
import com.doll.doll_mall.pojo.GoodsType;
import com.doll.doll_mall.pojo.Shop;
import com.doll.doll_mall.pojo.goodsSize;
import com.doll.doll_mall.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/7 19:42
 */
@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private GoodsSizeService goodsSizeService;
    @Autowired
    private GoodsTypeService goodsTypeService;

    @Autowired
    private CartService cartService;

    /*返回所有的商品信息*/

    @RequestMapping("/getAllGoods")
    public String getAllGoods(Model model,Integer pageNum){
        /*获取商品的分页信息*/
        PageInfo<Goods> page = goodsService.getAllGoodsPage(pageNum);
        List<GoodsType> goodsTypes = goodsTypeService.goodsTypes();
        model.addAttribute("goodsTypes",goodsTypes);
        //将分页数据共享到请求域中
        model.addAttribute("page",page);
        return "goods/Goods";
    }

    /*到商品的详情页*/
    @RequestMapping("/goods")
    public String getGoods(String getGoodsName,Model model,Integer shopId,Object userId){
        model.addAttribute("userId",userId);
        Shop shopAndGoods = shopService.getShopAndGoods(shopId);
        model.addAttribute("shopId",shopId);
        List<Goods> goods = goodsService.goods(shopId);
        model.addAttribute("goods",goods);
        String shopName = shopAndGoods.getShopName();
        model.addAttribute("shopName",shopName);
        Goods goodsAndGoodsSize = goodsService.getGoodsAndGoodsSize(getGoodsName);
        model.addAttribute("goodsAndGoodsSize",goodsAndGoodsSize);
        return "goods/goodsParticular";
    }

    /*查询对应尺码的数量*/
    @RequestMapping("/size")
    @ResponseBody
    public Integer s(String size,String goodsId){
        Goods goodsAndGoodsSize = goodsService.getGoodsAndGoodsSize(goodsId);

        if (Objects.equals(size, "S")){
            return goodsAndGoodsSize.getGoodsSize().getGoodsS();
        }else if (Objects.equals(size, "M")){
            return goodsAndGoodsSize.getGoodsSize().getGoodsM();
        }else if (Objects.equals(size, "X")){
            return goodsAndGoodsSize.getGoodsSize().getGoodsX();
        }
        return null;
    }

    /*ajax搜索联想根据商品的描述1*/
    @RequestMapping("/likeGetGoods")
    @ResponseBody
    public List<Goods> getGoodsByLike(String goodsDescribe1){
        return goodsService.getGoodsByLike(goodsDescribe1);
    }
    /*将查询到的商品返回*/
    @RequestMapping("/getGoodsLikeByGoodsDescribe1")
    public String  getGoodsLikeByGoodsDescribe1(String goodsDescribe1,Model model,Integer pageNum){
        List<GoodsType> goodsTypes = goodsTypeService.goodsTypes();
        model.addAttribute("goodsTypes",goodsTypes);
        PageInfo<Goods> page = goodsService.getGoodsByLikePage(pageNum, goodsDescribe1);
        model.addAttribute("search",goodsDescribe1);
        model.addAttribute("page",page);
        model.addAttribute("goodsDescribe1",goodsDescribe1);
        return "goods/SearchGoods";
    }

    /*跳转到修改商品*/
    @RequestMapping("/updateGoods")
    public String UpdateGoods(Goods goods,Model model,Integer userId,Integer goodsId,String goodsName){
        List<Goods> goodsById = goodsService.getGoodsById(goodsId);
        Goods goodsAndGoodsSize = goodsService.getGoodsAndGoodsSize(goodsName);
        List<GoodsType> goodsTypes = goodsTypeService.goodsTypes();
        model.addAttribute("type",goodsTypes);
        model.addAttribute("M",goodsAndGoodsSize.getGoodsSize().getGoodsM());
        model.addAttribute("S",goodsAndGoodsSize.getGoodsSize().getGoodsS());
        model.addAttribute("X",goodsAndGoodsSize.getGoodsSize().getGoodsX());
        model.addAttribute("sizeId",goodsAndGoodsSize.getGoodsSize().getGoodsSizeId());
        System.out.println("尺寸的ID："+goodsAndGoodsSize.getGoodsSize().getGoodsSizeId());
        model.addAttribute("goodsId",goodsId);
        model.addAttribute("goods",goodsById);
        model.addAttribute("userId",userId);
//        model.addAttribute("sizeId",goods.getGoodsSize().getGoodsSizeId());
//        model.addAttribute("goodsName",UUID.randomUUID());
        return "goods/updateGoods";
    }

    /*修改商品*/
    @RequestMapping("/upGoods")
    public String UpGoods(Goods goods, goodsSize goodsSize, HttpServletRequest request,String goodsName,Integer goodsSizeId){
        System.out.println(goodsName);
        HttpSession session = request.getSession();
        Object userId = session.getAttribute("userId");
        goodsService.UpdateGoods(goods);
        goodsSize.setGoodsName(goodsName);
        goodsSizeService.updateSize(goodsSize);
        System.out.println("修改后的尺寸:"+goodsSize);
        return "redirect:/spController?userId="+userId;
    }

    /*根据商品类型查询商品*/
    @RequestMapping("/type")
    public String getGoodsByTypeId(Integer typeId,Model model){
        GoodsType typeById = goodsTypeService.getTypeById(typeId);
        List<Goods> goodsByShopId = goodsService.getGoodsByShopId(typeId);
        List<GoodsType> goodsTypes = goodsTypeService.goodsTypes();
        model.addAttribute("goodsTypes",goodsTypes);
        model.addAttribute("type",goodsByShopId);
        model.addAttribute("type2",typeById.getTypeName());
        return "/goods/goodsType";
    }

    /*发送订单请求*/
    @RequestMapping("/checkOut")
    public void checkOut(Integer goodsId,String size,Integer count,Integer cartId){
        /*根据商品的ID查询商品的name*/

        List<Goods> goodsById = goodsService.getGoodsById(goodsId);

        for (Goods goods : goodsById) {
            goodsSize goodsSizeByGoodsName = goodsSizeService.getGoodsSizeByGoodsName(goods.getGoodsName());
            Integer goodsSizeId = goodsSizeByGoodsName.getGoodsSizeId();
            System.out.println("商品的尺寸ID2233："+goodsSizeId);
            /*提交订单后在增加商品的销量*/
            goodsSize goodsSizeById = goodsSizeService.getGoodsSizeById(goodsSizeId);
            goodsService.UpdateGoods(new Goods(goodsId,null,null,null,null,null,null,goods.getGoodsPrice(),null,null,null,null,null,null,goods.getSalesVolume()+count,goods.getTypeId(),goods.getShopId(),null));
            if (Objects.equals(size, "S")){
                /*根据商品ID修改商品的库存数量*/
                goodsSizeService.updateSize(new goodsSize(goodsSizeId,goodsSizeById.getGoodsS()-count,null,null,null));
            }
            /**/
            if (Objects.equals(size, "M")){
                /*根据商品ID修改商品的库存数量*/
                goodsSizeService.updateSize(new goodsSize(goodsSizeId,null,goodsSizeById.getGoodsM()-count,null,null));
            }
            /**/
            if (Objects.equals(size, "X")){
                /*根据商品ID修改商品的库存数量*/
                goodsSizeService.updateSize(new goodsSize(goodsSizeId,null,null,goodsSizeById.getGoodsX()-count,null));
            }

        }
        /*结算完成后删除购物车中的信息*/
        cartService.delCartById(cartId);

//        return "success";
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

}
