package com.gooagoo.api.business.query.marketing.qualitygoods;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.marketing.QualityGoodsForPlace;

public class TestQualityGoodsQueryService
{

    public QualityGoodsQueryService qualityGoodsQueryService;

    @Before
    public void testBefore()
    {
        this.qualityGoodsQueryService = ApplicationContextUtils.getBean(QualityGoodsQueryService.class);
    }

    /**
     * 精品推荐(吆喝广场、收藏广场)mobc05,mobb08
     * @throws Exception
     */
    @Test
    public void testFindQualityGoodsForPlace() throws Exception
    {
        String userId = "";
        String shopId = "00017R5P8UPBLQSVN000ITEIISX8401B";
        String keyword = "";
        Integer pageIndex = 1;
        Integer pageSize = 5;
        QualityGoodsForPlace qualityGoodsForPlace = this.qualityGoodsQueryService.findQualityGoodsForPlace(userId, shopId, keyword, pageIndex, pageSize);
        Assert.assertNotNull("查询精品推荐(吆喝广场、收藏广场)失败", qualityGoodsForPlace);
    }
}
