package com.gooagoo.common.cache;

import java.util.ArrayList;
import java.util.List;

import com.gooagoo.entity.generator.goods.GoodsBaseInfo;

/**
 * 发布缓存
 */
public class PublishCache
{

    private static List<GoodsBaseInfo> succeedGoodsList = new ArrayList<GoodsBaseInfo>();//发布成功商品
    private static List<GoodsBaseInfo> failedGoodsList = new ArrayList<GoodsBaseInfo>();//发布失败商品

    public static List<GoodsBaseInfo> getSucceedGoodsList()
    {
        return succeedGoodsList;
    }

    public static void addSucceedGoodsList(GoodsBaseInfo goodsBaseInfo)
    {
        PublishCache.succeedGoodsList.add(goodsBaseInfo);
    }

    public static List<GoodsBaseInfo> getFailedGoodsList()
    {
        return failedGoodsList;
    }

    public static void addFailedGoodsList(GoodsBaseInfo goodsBaseInfo)
    {
        PublishCache.failedGoodsList.add(goodsBaseInfo);
    }

}
