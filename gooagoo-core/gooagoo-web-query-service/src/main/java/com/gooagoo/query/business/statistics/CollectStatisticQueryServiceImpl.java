package com.gooagoo.query.business.statistics;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.statistics.CollectStatisticQueryService;
import com.gooagoo.query.business.statistics.common.ActivityCommonOperate;
import com.gooagoo.query.business.statistics.common.CouponCommonOperate;
import com.gooagoo.query.business.statistics.common.GoodsCommonOperate;

@Service
public class CollectStatisticQueryServiceImpl implements CollectStatisticQueryService
{
    @Override
    public int couponCollectTimes(String couponId, String userType, String dateType, Date dateTime, String channel, String source)
    {
        return CouponCommonOperate.getTimes(couponId, "F", userType, dateType, dateTime, channel, source);
    }

    @Override
    public List<String> couponCollectPeople(String couponId, String userType, String dateType, Date dateTime, String channel, String source)
    {
        return CouponCommonOperate.getPeople(couponId, "F", userType, dateType, dateTime, channel, source);
    }

    @Override
    public int activityCollectTimes(String activityId, String userType, String dateType, Date dateTime, String channel, String source)
    {
        return ActivityCommonOperate.getTimes(activityId, "F", userType, dateType, dateTime, channel, source);
    }

    @Override
    public List<String> activityCollectPoeple(String activityId, String userType, String dateType, Date dateTime, String channel, String source)
    {
        return ActivityCommonOperate.getPoeple(activityId, "F", userType, dateType, dateTime, channel, source);
    }

    @Override
    public int goodsCollectTimes(String shopId, String goodsSerialNo, String dateType, String userType, String channel, String source, Date dateTime)
    {
        return GoodsCommonOperate.goodsSerialTimes(shopId + "_" + goodsSerialNo, "F", dateType, userType, channel, source, dateTime);
    }

    @Override
    public List<String> goodsCollectPoeple(String shopId, String goodsSerialNo, String dateType, String userType, String channel, String source, Date dateTime)
    {
        return GoodsCommonOperate.goodsSerialPoeple(shopId + "_" + goodsSerialNo, "F", dateType, userType, channel, source, dateTime);
    }

    @Override
    public int categoryCollectTimes(String shopId, String categorySerialNo, String dateType, String userType, String channel, String source, Date dateTime)
    {
        return GoodsCommonOperate.goodsCategoryTimes(shopId + "_" + categorySerialNo, "F", dateType, userType, channel, source, dateTime);
    }

    @Override
    public List<String> categoryCollectPoeple(String shopId, String categorySerialNo, String dateType, String userType, String channel, String source, Date dateTime)
    {
        return GoodsCommonOperate.goodsCategoryPoeple(shopId + "_" + categorySerialNo, "F", dateType, userType, channel, source, dateTime);
    }

    @Override
    public int brandCollectTimes(String shopId, String brandId, String dateType, String userType, String channel, String source, Date dateTime)
    {
        return GoodsCommonOperate.goodsBrandTimes(shopId + "_" + brandId, "F", dateType, userType, channel, source, dateTime);
    }

    @Override
    public List<String> brandCollectPoeple(String shopId, String brandId, String dateType, String userType, String channel, String source, Date dateTime)
    {
        return GoodsCommonOperate.goodsBrandPoeple(shopId + "_" + brandId, "F", dateType, userType, channel, source, dateTime);
    }

}
