package com.gooagoo.api.business.query.statistics;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.query.business.statistics.BrowseStatisticQueryServiceImpl;

public class TestBrowseStatisticQueryService
{

    public BrowseStatisticQueryService browseStatisticService;

    @Before
    public void testBefore()
    {
        //this.browseStatisticService = ApplicationContextUtils.getBean(BrowseStatisticQueryService.class);
    }

    /**
     * 查询商家服务工具营销信息浏览次数
     * @throws Exception
     */
    public void testToolBrowsTimes() throws Exception
    {
        Date date = TimeUtils.convertStringToDate("2013-09-10");
        BrowseStatisticQueryService b = new BrowseStatisticQueryServiceImpl();
        int times = b.toolBrowsTimes("01822R97QK2FRDT085QBV2EIISWR0JGT", "183M1GFTPVBSGU30KH62O3P83M56O017", "A", "D", date);
        System.out.println(times);
    }

    /**
     * 查询商家服务工具营销信息浏览人群
     * @throws Exception
     */
    public void testToolsBrowsPeople() throws Exception
    {
        Date date = TimeUtils.convertStringToDate("2013-09-10");
        BrowseStatisticQueryService b = new BrowseStatisticQueryServiceImpl();
        List<String> list = b.toolsBrowsPeople("01822R97QK2FRDT085QBV2EIISWR0JGT", "183M1GFTPVBSGU30KH62O3P83M56O017", "A", "D", date);
        for (String s : list)
        {
            System.out.println(s);
        }
        //Assert.assertNotNull("", "");
    }

    /**
     * 查询优惠凭证浏览次数
     * @throws Exception
     */
    public void testCouponBrowsTimes() throws Exception
    {
        Date date = TimeUtils.convertStringToDate("2013-09-17");
        int times = this.browseStatisticService.couponBrowsTimes("0182AUMT4ILBO1J0SR22DDEIISWR2K1N", "A", "D", date, null, null);
        //Assert.assertNotNull("", "");
        System.out.println(times);
    }

    /**
     * 查询优惠凭证浏览人群
     * @throws Exception
     */
    public void testCouponBrowsPeople() throws Exception
    {
        Date date = TimeUtils.convertStringToDate("2013-09-09");
        BrowseStatisticQueryService b = new BrowseStatisticQueryServiceImpl();
        List<String> list = b.couponBrowsPeople("183M1GFTPVBSGU30KH62O3P83M56O017", "A", "D", date, "2", "W");
        for (String s : list)
        {
            System.out.println(s);
        }

        //Assert.assertNotNull("", "");
    }

    /**
     * 查询活动浏览次数
     * @throws Exception
     */
    @Test
    public void testActivityBrowsTimes() throws Exception
    {
        //0182IAG56LSBDRB0U2LBVAEIISWR2647_B_A_*_*_Y2013M10D25
        Date date = new Date();
        BrowseStatisticQueryService b = new BrowseStatisticQueryServiceImpl();
        int times = b.activityBrowsTimes("187HSCKFOGSSAE00A1BAQJMEKRDA0VJC", "A", "D", date, "*", "*");
        System.out.println(times);
    }

    /**
     * 查询活动浏览人群
     * @throws Exception
     */
    @Test
    public void testActivityBrowsPoeple() throws Exception
    {
        Date date = TimeUtils.convertStringToDate("2013-10-25");
        BrowseStatisticQueryService b = new BrowseStatisticQueryServiceImpl();
        //{ "_id" : "activeId111_D09" , "N_B_N_W" : { "pnum" : 1 , "pid" : "000181J1TI7CRA589B0TC7YLRGI7C5SC"}}
        List<String> list = b.activityBrowsPoeple("0182IAG56LSBDRB0U2LBVAEIISWR2647", "A", "D", date, "*", "3");
        for (String s : list)
        {
            System.out.println(s);
        }

        //Assert.assertNotNull("", "");
    }

    /**
     * 查询商品浏览次数
     * @throws Exception
     */
    public void testGoodsBrowsTimes() throws Exception
    {
        BrowseStatisticQueryService b = new BrowseStatisticQueryServiceImpl();
        int times = b.goodsBrowsTimes("01822MAPVKNP054085QBQVEIISWR0JGT", "6907992100012", "D", "A", "*", new Date(), "3");
        System.out.println(times);
    }

    /**
     * 查询商品浏览人群
     * @throws Exception
     */
    public void testGoodsBrowsPoeple() throws Exception
    {
        Date date = TimeUtils.convertStringToDate("2013-09-10");
        BrowseStatisticQueryService b = new BrowseStatisticQueryServiceImpl();
        List<String> list = b.goodsBrowsPoeple("001", "serial1", "D", "A", "1", date, "W");
        for (String s : list)
        {
            System.out.println(s);
        }
    }

    /**
     * 查询品类浏览次数
     * @throws Exception
     */
    @Test
    public void testCategoryBrowsTimes() throws Exception
    {
        Date date = new Date();
        BrowseStatisticQueryService b = new BrowseStatisticQueryServiceImpl();
        int times = b.categoryBrowsTimes("01822IAKR5SKU02085QBP2EIISWR0JGT", "1", "D", "A", "2", date, "W");
        System.out.println(times);
    }

    /**
     * 查询品类浏览人群
     * @throws Exception
     */
    @Test
    public void testCategoryBrowsPoeple() throws Exception
    {
        Date date = new Date();
        BrowseStatisticQueryService b = new BrowseStatisticQueryServiceImpl();
        List<String> list = b.categoryBrowsPoeple("01822IAKR5SKU02085QBP2EIISWR0JGT", "1", "D", "A", "2", date, "W");
        for (String s : list)
        {
            System.out.println(s);
        }
    }

    /**
     * 查询品牌浏览次数
     * @throws Exception
     */
    public void testBrandBrowsTimes() throws Exception
    {
        Date date = TimeUtils.convertStringToDate("2013-09-10");
        BrowseStatisticQueryService b = new BrowseStatisticQueryServiceImpl();
        int times = b.brandBrowsTimes("001", "Brand1", "D", "A", "1", date, "W");
        System.out.println(times);
    }

    /**
     * 查询品牌浏览人群
     * @throws Exception
     */
    public void testBrandBrowsPoeple() throws Exception
    {
        Date date = TimeUtils.convertStringToDate("2013-09-10");
        BrowseStatisticQueryService b = new BrowseStatisticQueryServiceImpl();
        List<String> list = b.brandBrowsPoeple("001", "Brand1", "D", "A", "1", date, "W");
        for (String s : list)
        {
            System.out.println(s);
        }
    }

    /**
     * 查询吆喝浏览次数
     * @throws Exception
     */
    @Test
    public void testCryoutBrowsTimes() throws Exception
    {
        BrowseStatisticQueryService b = new BrowseStatisticQueryServiceImpl();
        int time = b.cryoutBrowsTimes("187UATEEGPC57000A1BAQJMEC3HS6DCH", "D", "A", "*", new Date());
        System.out.println(time);

    }

    /**
     * 查询吆喝浏览人群
     * @throws Exception
     */
    public void testCryoutBrowsPeople() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 查询通知浏览次数
     * @throws Exception
     */

    public void testNoticeBrowsTimes() throws Exception
    {
        BrowseStatisticQueryService b = new BrowseStatisticQueryServiceImpl();
        int times = b.noticeBrowsTimes("184J2MI8HVG1T02K0IJBFOR5R35OGL7M", "D", "A", "*", new Date());
        System.out.println(times);
    }

    /**
     * 查询通知浏览人群
     * @throws Exception
     */
    public void testNoticeBrowsPeople() throws Exception
    {
        Date date = TimeUtils.convertStringToDate("2013-09-10");
        BrowseStatisticQueryService b = new BrowseStatisticQueryServiceImpl();
        List<String> list = b.noticeBrowsPeople("183M1GFTPVBSGU30KH62O3P83M56O017", "D", "A", "W", date);
        for (String s : list)
        {
            System.out.println(s);
        }
    }

    /**
     * 查询购好奇浏览次数
     * @throws Exception
     */
    public void testPurchaseAndcuriosityBrowsTimes() throws Exception
    {
        Date date = TimeUtils.convertStringToDate("2013-09-05");
        BrowseStatisticQueryService b = new BrowseStatisticQueryServiceImpl();
        int times = b.purchaseAndcuriosityBrowsTimes("183M1GFTPVBSGU30KH62O3P83M56O017", "D", "A", date);
        System.out.println(times);
    }

    /**
     * 查询购好奇浏览人群
     * @throws Exception
     */
    public void testPurchaseAndcuriosityBrowsPeople() throws Exception
    {
        Date date = TimeUtils.convertStringToDate("2013-09-05");
        BrowseStatisticQueryService b = new BrowseStatisticQueryServiceImpl();
        List<String> list = b.purchaseAndcuriosityBrowsPeople("183M1GFTPVBSGU30KH62O3P83M56O017", "D", "A", date);
        for (String s : list)
        {
            System.out.println(s);
        }
    }

}
