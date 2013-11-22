package com.gooagoo.query.business.statistics;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.statistics.CommentsStatisticQueryService;
import com.gooagoo.query.business.statistics.common.GoodsCommonOperate;

@Service
public class CommentsStatisticQueryServiceImpl implements CommentsStatisticQueryService
{
    @Override
    public String getGoodsGrade(String goodsId)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int goodsCommentTimes(String shopId, String goodsSerialNo, String dateType, String userType, Date dateTime, String source)
    {
        return GoodsCommonOperate.goodsSerialTimes(shopId + "_" + goodsSerialNo, "C", dateType, userType, null, source, dateTime);
    }

    @Override
    public List<String> goodsCommentPeople(String shopId, String goodsSerialNo, String dateType, String userType, Date dateTime, String source)
    {
        return GoodsCommonOperate.goodsSerialPoeple(shopId + "_" + goodsSerialNo, "C", dateType, userType, null, source, dateTime);
    }

    @Override
    public int categoryCommentTimes(String shopId, String categoryId, String dateType, String userType, Date dateTime, String source)
    {
        return GoodsCommonOperate.goodsCategoryTimes(shopId + "_" + categoryId, "C", dateType, userType, null, source, dateTime);
    }

    @Override
    public List<String> categoryCommentPeople(String shopId, String categoryId, String dateType, String userType, Date dateTime, String source)
    {
        return GoodsCommonOperate.goodsCategoryPoeple(shopId + "_" + categoryId, "C", dateType, userType, null, source, dateTime);
    }

    @Override
    public int brandCommentTimes(String shopId, String brandId, String dateType, String userType, Date dateTime, String source)
    {
        return GoodsCommonOperate.goodsBrandTimes(shopId + "_" + brandId, "C", dateType, userType, null, source, dateTime);
    }

    @Override
    public List<String> brandCommentPeople(String shopId, String brandId, String dateType, String userType, Date dateTime, String source)
    {
        return GoodsCommonOperate.goodsBrandPoeple(shopId + "_" + brandId, "C", dateType, userType, null, source, dateTime);
    }

}
