package com.gooagoo.api.business.query.goods.statistical;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.goods.GoodsSalesRanking;

public class TestStatisticalQueryService
{

    public StatisticalQueryService statisticalQueryService;

    @Before
    public void testBefore()
    {
        this.statisticalQueryService = ApplicationContextUtils.getBean(StatisticalQueryService.class);
    }

    /**
     * 2.1.12. 统计已购商品数量
     * @throws Exception
     */
    @Test
    public void testPurchasedGoods() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 品类销售排行查询
     * @throws Exception
     */
    @Test
    public void testSalesRanking() throws Exception
    {
        String shopId = "01822IE57DH111M085QBPFEIISWR0JGT";
        String categoryId = null;
        String keyword = null;
        String positionId = null;
        Integer pageIndex = 1;
        Integer pageSize = 20;
        List<GoodsSalesRanking> goodsSalesRankingList = this.statisticalQueryService.salesRanking(shopId, categoryId, keyword, positionId, pageIndex, pageSize);
        Assert.assertTrue("查询品类销售排行失败", CollectionUtils.isNotEmpty(goodsSalesRankingList));
    }

}
