package com.gooagoo.api.business.query.statistics;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.query.business.statistics.CollectStatisticQueryServiceImpl;

public class TestCollectStatisticQueryService
{

    public CollectStatisticQueryServiceImpl collectStatisticService;

    @Before
    public void testBefore()
    {
        //this.collectStatisticService = ApplicationContextUtils.getBean(CollectStatisticQueryServiceImpl.class);
    }

    /**
     * 
     * @throws Exception
     */
    public void testCouponCollectTimes() throws Exception
    {
        String couponId = "0182AUMT4ILBO1J0SR22DDEIISWR2K1N";
        CollectStatisticQueryServiceImpl cService = new CollectStatisticQueryServiceImpl();
        int couponCollectTimes = cService.couponCollectTimes(couponId, "A", null, null, "*", "*");
        System.out.println(couponCollectTimes);
    }

    /**
     * 
     * @throws Exception
     */
    public void testCouponCollectPeople() throws Exception
    {
        String couponId = "183M1GFTPVBSGU30KH62O3P83M56O017";
        CollectStatisticQueryServiceImpl cService = new CollectStatisticQueryServiceImpl();
        List<String> people = cService.couponCollectPeople(couponId, "A", null, null, "*", "*");
        for (String s : people)
        {
            System.out.println(s);
        }
    }

    /**
     * 
     * @throws Exception
     */
    public void testActivityCollectTimes() throws Exception
    {
        String activeId = "0182IIRCA72VPJE0584F37EIISWR2647";
        CollectStatisticQueryServiceImpl c = new CollectStatisticQueryServiceImpl();
        int times = c.activityCollectTimes("0182IIRCA72VPJE0584F37EIISWR2647", "A", "D", new Date(), "*", "*");
        System.out.println(times);
    }

    /**
     * 
     * @throws Exception
     */
    public void testActivityCollectPoeple() throws Exception
    {
        String activeId = "183JO6FN69TLH32G8PELDKNPHI5CSCUF";
        CollectStatisticQueryServiceImpl c = new CollectStatisticQueryServiceImpl();
        List<String> people = c.activityCollectPoeple(activeId, "A", "D", new Date(), "3", "W");
        for (String s : people)
        {
            System.out.println(s);
        }
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testGoodsCollectTimes() throws Exception
    {
        CollectStatisticQueryServiceImpl c = new CollectStatisticQueryServiceImpl();
        int times = c.goodsCollectTimes("01822IE57DH111M085QBPFEIISWR0JGT", "203001", "W", "A", "*", "*", new Date());
        System.out.println(times);
    }

    /**
     * 
     * @throws Exception
     */
    public void testGoodsCollectPoeple() throws Exception
    {
        CollectStatisticQueryServiceImpl c = new CollectStatisticQueryServiceImpl();
        List<String> poeple = c.goodsCollectPoeple("01822MAPVKNP054085QBQVEIISWR0JGT", "6920907809909", "D", "A", null, "W", new Date());
        for (String s : poeple)
        {
            System.out.println(s);
        }
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testCategoryCollectTimes() throws Exception
    {
        Date date = new Date();
        CollectStatisticQueryServiceImpl c = new CollectStatisticQueryServiceImpl();
        int times = c.categoryCollectTimes("01822IAKR5SKU02085QBP2EIISWR0JGT", "1", "D", "A", "2", "W", date);
        System.out.println(times);
    }

    /**
     * 查询品类收藏人群
     * @throws Exception
     */
    public void testCategoryCollectPoeple() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 
     * @throws Exception
     */
    public void testBrandCollectTimes() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 查询品类收藏人群
     * @throws Exception
     */
    public void testBrandCollectPoeple() throws Exception
    {

        Assert.assertNotNull("", "");
    }

}
