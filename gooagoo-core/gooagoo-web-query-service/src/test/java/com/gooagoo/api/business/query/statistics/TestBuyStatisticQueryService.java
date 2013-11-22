package com.gooagoo.api.business.query.statistics;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.goods.GoodsSalesRanking;
import com.gooagoo.query.business.statistics.BuyStatisticQueryServiceImpl;

public class TestBuyStatisticQueryService
{

    public BuyStatisticQueryService buyStatisticService;

    @Before
    public void testBefore()
    {
        //buyStatisticService = new BuyStatisticQueryServiceImpl();
        this.buyStatisticService = ApplicationContextUtils.getBean(BuyStatisticQueryService.class);
    }

    /**
     * 查询商品购买次数
     * @throws Exception
     */
    @Test
    public void testGoodsBuyTimes() throws Exception
    {
        BuyStatisticQueryService b = new BuyStatisticQueryServiceImpl();
        int times = b.goodsBuyTimes("01822R97QK2FRDT085QBV2EIISWR0JGT", "6925875201144", "D", "A", new Date());
        System.out.println(times);
    }

    /**
     * 查询商品购买人群
     * @throws Exception
     */
    @Test
    public void testGoodsBuyPeople() throws Exception
    {
        BuyStatisticQueryService b = new BuyStatisticQueryServiceImpl();
        List<String> list = b.goodsBuyPeople("01822R97QK2FRDT085QBV2EIISWR0JGT", "6925875201144", "D", "A", new Date());
        for (String s : list)
        {
            System.out.println(s);
        }
    }

    /**
     * 查询品类购买次数
     * @throws Exception
     */
    @Test
    public void testCategoryBuyTimes() throws Exception
    {
        BuyStatisticQueryService b = new BuyStatisticQueryServiceImpl();
        int times = b.categoryBuyTimes("01822R97QK2FRDT085QBV2EIISWR0JGT", "6925875201144", "D", "A", new Date());
        System.out.println(times);
    }

    /**
     * 查询品类购买人群
     * @throws Exception
     */
    @Test
    public void testCategoryBuyPeople() throws Exception
    {
        BuyStatisticQueryService b = new BuyStatisticQueryServiceImpl();
        List<String> list = b.categoryBuyPeople("01822R97QK2FRDT085QBV2EIISWR0JGT", "6925875201144", "D", "A", new Date());
        for (String s : list)
        {
            System.out.println(s);
        }
    }

    /**
     * 查询品牌购买次数
     * @throws Exception
     */
    @Test
    public void testBrandBuyTimes() throws Exception
    {
        BuyStatisticQueryService b = new BuyStatisticQueryServiceImpl();
        int times = b.brandBuyTimes("01822R97QK2FRDT085QBV2EIISWR0JGT", "6925875201144", "D", "A", new Date());
        System.out.println(times);
    }

    /**
     * 查询品牌购买人群
     * @throws Exception
     */
    @Test
    public void testBrandBuyPeople() throws Exception
    {
        BuyStatisticQueryService b = new BuyStatisticQueryServiceImpl();
        List<String> list = b.brandBuyPeople("01822R97QK2FRDT085QBV2EIISWR0JGT", "6925875201144", "D", "A", new Date());
        for (String s : list)
        {
            System.out.println(s);
        }
    }

    /**
     * 区域销量排行
     * @throws Exception
     */
    @Test
    public void testSalesRanking() throws Exception
    {

        //Assert.assertNotNull("", "");
    }

    /**
     * 用户消费次数
     * @throws Exception
     */
    @Test
    public void testConsumptionNum() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    @Test
    public void testCategorySalesRanking()
    {
        List<GoodsSalesRanking> list = buyStatisticService.categorySalesRanking("01822U05K8R6KB007GRNHKEIISWR2K8D");
        for (GoodsSalesRanking goodsSalesRanking : list)
        {
            System.out.println(goodsSalesRanking.getGoodsName());
        }
        System.out.println(list.size());
    }

    @Test
    public void testAreaSalesRanking()
    {
        List<GoodsSalesRanking> list = buyStatisticService.areaSalesRanking("01822U05K8R6KB007GRNHKEIISWR2K8D");
        for (GoodsSalesRanking goodsSalesRanking : list)
        {
            System.out.println(goodsSalesRanking.getGoodsName());
        }
        System.out.println(list.size());
    }

}
