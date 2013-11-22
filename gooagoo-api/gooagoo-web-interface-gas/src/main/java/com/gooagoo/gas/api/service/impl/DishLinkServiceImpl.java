package com.gooagoo.gas.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.goods.query.GoodsQueryService;
import com.gooagoo.api.generator.query.goods.GoodsCategoryGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.goods.GoodsDetail;
import com.gooagoo.entity.generator.goods.GoodsCategory;
import com.gooagoo.entity.generator.goods.GoodsCategoryExample;
import com.gooagoo.gas.api.service.DishLinkService;
import com.gooagoo.gas.entity.gask01.transform.Foodinfolist;
import com.gooagoo.gas.entity.gask01.transform.GetFoodByIdRoot;
import com.gooagoo.gas.entity.gask02.transform.Foodkinds;
import com.gooagoo.gas.entity.gask02.transform.GetDishCategoryRoot;
import com.gooagoo.gas.entity.gask03.transform.Foodinfolists;
import com.gooagoo.gas.entity.gask03.transform.GetCategoryByDeskNoRoot;
import com.google.gson.Gson;

@Service
public class DishLinkServiceImpl implements DishLinkService
{
    @Autowired
    private GoodsQueryService goodsQueryService;
    @Autowired
    private GoodsCategoryGeneratorQueryService goodsCategoryGeneratorQueryService;

    @Override
    public GetFoodByIdRoot queryFoodsInfoByIdOrName(String shopEntityId, String foodName, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("queryFoodsInfoByIdOrName-->入参:shopEntityId=" + shopEntityId + ",foodName=" + foodName + ",pageIndex=" + pageIndex + ",pageSize=" + pageSize);

        //1、根据自定义序列号、实体店编号、商家编号查询商品详情
        List<GoodsDetail> goodsDetailList = this.goodsQueryService.findGoods(null, shopEntityId, foodName, foodName, null, null, null, Integer.valueOf(pageIndex), Integer.valueOf(pageSize), "1");
        //2、组装菜品信息
        List<Foodinfolist> foodinfolist = null;
        if (CollectionUtils.isNotEmpty(goodsDetailList))
        {
            foodinfolist = new ArrayList<Foodinfolist>();
            for (GoodsDetail tempGoodsDetail : goodsDetailList)
            {
                Foodinfolist foodinfo = new Foodinfolist();
                foodinfo.setFoodid(tempGoodsDetail.getGoodsBaseInfo().getGoodsId());
                foodinfo.setFoodkind(tempGoodsDetail.getGoodsCategoryLeafName());
                foodinfo.setFoodtype(tempGoodsDetail.getGoodsCategoryLeaf());
                foodinfo.setFoodname(tempGoodsDetail.getGoodsBaseInfo().getGoodsName());
                foodinfo.setFoodprice(tempGoodsDetail.getGoodsBaseInfo().getPrice().toString());
                foodinfo.setOnedimensioncode(tempGoodsDetail.getGoodsBaseInfo().getItemSerial());
                foodinfo.setFoodhot(tempGoodsDetail.getGoodsHot());
                //            foodinfo.setInventory(inventory)//缺少库存
                foodinfolist.add(foodinfo);
            }
        }
        //3、组装返回数据
        GetFoodByIdRoot root = new GetFoodByIdRoot();
        root.setFoodinfolist(foodinfolist);

        return root;

    }

    @Override
    public GetDishCategoryRoot queryRootFoodCategory(String shopEntityId, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("queryRootFoodCategory-->入参:shopEntityId=" + shopEntityId + ",pageIndex=" + pageIndex + ",pageSize=" + pageSize);

        //1.获取菜品各根节点品类别信息
        GoodsCategoryExample goodsCategoryExample = new GoodsCategoryExample();
        goodsCategoryExample.createCriteria().andParentCategoryIdEqualTo("-1").andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N");
        goodsCategoryExample.setPage(Integer.valueOf(pageIndex), Integer.valueOf(pageSize));
        List<GoodsCategory> goodsCategoryList = this.goodsCategoryGeneratorQueryService.selectByExample(goodsCategoryExample);

        GooagooLog.debug("获取到的菜品各根节点品类别信息" + new Gson().toJson(goodsCategoryList));

        //2.封装菜品各根节点品类别信息
        List<Foodkinds> foodkindsList = null;
        if (CollectionUtils.isNotEmpty(goodsCategoryList))
        {
            foodkindsList = new ArrayList<Foodkinds>();
            for (GoodsCategory temp : goodsCategoryList)
            {
                Foodkinds foodkinds = new Foodkinds();
                foodkinds.setFoodkindid(temp.getCategoryId());
                foodkinds.setFoodkindname(temp.getCategoryName());
                foodkinds.setUrl(temp.getPicUrl());
                foodkindsList.add(foodkinds);
            }
        }
        //3.组装返回数据
        GetDishCategoryRoot root = new GetDishCategoryRoot();
        root.setFoodkinds(foodkindsList);
        return root;
    }

    @Override
    public GetCategoryByDeskNoRoot queryFoodsInfoByCategory(String shopEntityId, String categoryId, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("queryFoodsInfoByCategory-->入参:shopEntityId=" + shopEntityId + ",categoryId=" + categoryId + ",pageIndex=" + pageIndex + ",pageSize=" + pageSize);
        //1.店员按菜品类别编号查询菜品信息(1-按人气降序)    参数：shopEntityId, itemSerial, goodsName, category
        List<GoodsDetail> findGoodsList = this.goodsQueryService.findGoods(null, shopEntityId, null, null, categoryId, null, null, Integer.valueOf(pageIndex), Integer.valueOf(pageSize), "1");

        GooagooLog.debug("员按菜品类别编号查询菜品信息" + new Gson().toJson(findGoodsList));

        //2.组装查询到的菜品信息
        List<Foodinfolists> foodinfolists = null;

        if (CollectionUtils.isNotEmpty(findGoodsList))
        {
            foodinfolists = new ArrayList<Foodinfolists>();
            for (GoodsDetail temp : findGoodsList)
            {

                Foodinfolists foodinfo = new Foodinfolists();

                foodinfo.setFoodid(temp.getGoodsBaseInfo().getGoodsId());
                foodinfo.setFoodkind(temp.getGoodsBaseInfo().getGoodsCategoryLeaf());
                foodinfo.setFoottype(temp.getGoodsBaseInfo().getPrice().toString());
                foodinfo.setFoodname(temp.getGoodsBaseInfo().getGoodsName());
                foodinfo.setFoodprice(temp.getGoodsBaseInfo().getPrice().toString());
                foodinfo.setFoodhot(temp.getGoodsHot());
                //            foodinfo.setInventory(inventory)
                foodinfolists.add(foodinfo);
            }
        }
        //3.组装返回数据
        GetCategoryByDeskNoRoot root = new GetCategoryByDeskNoRoot();
        root.setFoodinfolists(foodinfolists);
        return root;
    }
}
