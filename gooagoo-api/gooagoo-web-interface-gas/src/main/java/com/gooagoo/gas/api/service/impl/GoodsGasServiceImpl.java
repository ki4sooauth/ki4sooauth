package com.gooagoo.gas.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.goods.query.GoodsQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.goods.GoodsCategoryBusiness;
import com.gooagoo.entity.business.goods.GoodsDetail;
import com.gooagoo.entity.generator.goods.GoodsCategory;
import com.gooagoo.gas.api.service.GoodsGasService;
import com.gooagoo.gas.entity.gasd01.transform.CategoryRoot;
import com.gooagoo.gas.entity.gasd01.transform.Categoryinfo;
import com.gooagoo.gas.entity.gasd01.transform.Categorysub;
import com.gooagoo.gas.entity.gasd02.transform.Goodsinfo;
import com.gooagoo.gas.entity.gasd02.transform.QueryGoodsListRoot;
import com.google.gson.Gson;

@Service
public class GoodsGasServiceImpl implements GoodsGasService
{
    @Autowired
    private GoodsQueryService goodsQueryService;

    @Override
    public CategoryRoot queryGoodsCategoryInfo(String shopEntityId, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("queryGoodsCategoryInfo入参为：shopEntityId" + shopEntityId + ",pageIndex=" + pageIndex + ",pageSize" + pageSize);
        //1.查询实体店中的品类信息
        List<GoodsCategoryBusiness> goodsCategoryBusinessList = this.goodsQueryService.findGoodsCategory(null, shopEntityId, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));
        GooagooLog.debug("查询到品类信息为:" + new Gson().toJson(goodsCategoryBusinessList));
        //2.封装查询到的品类信息并返回
        List<Categoryinfo> categoryinfoList = null;
        if (CollectionUtils.isNotEmpty(goodsCategoryBusinessList))
        {
            categoryinfoList = new ArrayList<Categoryinfo>();

            for (GoodsCategoryBusiness tempParentGoodsCategory : goodsCategoryBusinessList)
            {
                Categoryinfo tempCategoryinfo = new Categoryinfo();
                //封装父品类节点数据
                tempCategoryinfo.setCategoryid(tempParentGoodsCategory.getParentGoodsCategory().getCategoryId());
                tempCategoryinfo.setCategoryname(tempParentGoodsCategory.getParentGoodsCategory().getCategoryName());
                tempCategoryinfo.setCategoryurl(tempParentGoodsCategory.getParentGoodsCategory().getPicUrl());
                //封装子品类节点数据
                List<Categorysub> categorysubList = null;
                if (CollectionUtils.isNotEmpty(tempParentGoodsCategory.getChildGoodsCategoryList()))
                {
                    categorysubList = new ArrayList<Categorysub>();
                    for (GoodsCategory tempChildGoodsCategory : tempParentGoodsCategory.getChildGoodsCategoryList())
                    {
                        Categorysub tempCategorysub = new Categorysub();
                        tempCategorysub.setCategorysubid(tempChildGoodsCategory.getCategoryId());
                        tempCategorysub.setCategorysubname(tempChildGoodsCategory.getCategoryName());
                        tempCategorysub.setCategorysuburl(tempChildGoodsCategory.getPicUrl());
                        categorysubList.add(tempCategorysub);
                    }
                }

                tempCategoryinfo.setCategorysub(categorysubList);
                categoryinfoList.add(tempCategoryinfo);
            }
        }
        //3.封装数据并返回
        CategoryRoot root = new CategoryRoot();
        root.setCategoryinfo(categoryinfoList);

        return root;
    }

    @Override
    public QueryGoodsListRoot queryGoodsInfoBySort(String shopId, String shopEntityId, String categoryId, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("queryGoodsCategoryInfo入参为：shopEntityId" + shopEntityId + ",pageIndex=" + pageIndex + ",pageSize" + pageSize);
        //1.根据品类编号人气降序查询商品信息
        //(shopEntityId, categoryId, Integer.valueOf(pageIndex), Integer.valueOf(pageSize), "1")
        List<GoodsDetail> goodsDetailList = this.goodsQueryService.findGoods(shopId, shopEntityId, null, null, categoryId, null, null, Integer.valueOf(pageIndex), Integer.valueOf(pageSize), "1");
        GooagooLog.info("根据shopEntityId=" + shopEntityId + ",categoryId=" + categoryId + ",pageIndex" + pageIndex + ",pageSize=" + pageSize + "并按人气降序查询的商品信息为：" + new Gson().toJson(goodsDetailList));

        List<Goodsinfo> goodsinfoList = null;
        if (CollectionUtils.isNotEmpty(goodsDetailList))
        {
            //2.封装查询到的商品信息
            goodsinfoList = new ArrayList<Goodsinfo>();
            for (GoodsDetail tempGoodsDetail : goodsDetailList)
            {
                Goodsinfo tempGoodsinfo = new Goodsinfo();
                tempGoodsinfo.setGoodsid(tempGoodsDetail.getGoodsBaseInfo().getGoodsId());
                tempGoodsinfo.setGoodsname(tempGoodsDetail.getGoodsBaseInfo().getGoodsName());
                tempGoodsinfo.setGoodsbrand(tempGoodsDetail.getGoodsBrandName());
                tempGoodsinfo.setGoodscategoryleaf(tempGoodsDetail.getGoodsCategoryLeafName());
                tempGoodsinfo.setGoodsprice(tempGoodsDetail.getGoodsBaseInfo().getPrice().toString());
                tempGoodsinfo.setGoodsimg(tempGoodsDetail.getGoodsImg());
                goodsinfoList.add(tempGoodsinfo);
            }
        }
        //3.封装数据并返回
        QueryGoodsListRoot root = new QueryGoodsListRoot();
        root.setGoodsinfo(goodsinfoList);

        return root;
    }
}
