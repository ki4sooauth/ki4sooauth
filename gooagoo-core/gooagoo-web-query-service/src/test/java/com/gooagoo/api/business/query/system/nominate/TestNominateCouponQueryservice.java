package com.gooagoo.api.business.query.system.nominate;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.system.nominate.NominateCouponBusiness;
import com.gooagoo.exception.common.NullException;

public class TestNominateCouponQueryservice
{
    public NominateCouponQueryService nominateCouponQueryService;

    @Before
    public void testBefore()
    {
        this.nominateCouponQueryService = ApplicationContextUtils.getBean(NominateCouponQueryService.class);
    }

    /**
     * 获取推荐优惠凭证列表
     * @throws NullException
     */
    @Test
    public void testGetNominateCouponBusinessList() throws Exception
    {
        NominateCouponBusiness nominateCouponBusiness = new NominateCouponBusiness();
        //nominateCouponBusiness.setStartTime(TimeUtils.convertStringToDate("2012-09-24"));
        //  nominateCouponBusiness.setEndTime(TimeUtils.convertStringToDate("2015-09-24"));
        //nominateCouponBusiness.setShopName("华书店");
        //nominateCouponBusiness.setCouponName("100（收藏广场）");
        // nominateCouponBusiness.setPublishStartTime(TimeUtils.convertStringToDate("2012-08-12"));
        // nominateCouponBusiness.setPublishEndTime(TimeUtils.convertStringToDate("2015-12-19"));
        //nominateCouponBusiness.setUseStartTime(TimeUtils.convertStringToDate("2013-10-25"));
        //nominateCouponBusiness.setUseEndTime(TimeUtils.convertStringToDate("2015-11-09"));
        //nominateCouponBusiness.setCouponType("D");
        //nominateCouponBusiness.setIsNominate("Y");
        //nominateCouponBusiness.setShopName("书店");
        // nominateCouponBusiness.setCouponName("满300赠100（收藏广场）");
        List<NominateCouponBusiness> nominateCouponBusinessList = this.nominateCouponQueryService.findNominateCouponBusiness(nominateCouponBusiness, 1, 100);
        Assert.assertNotNull("获取推荐优惠凭证列表失败", nominateCouponBusinessList);
    }

    /**
     * 获取推荐优惠凭证列表总数
     * @throws NullException
     */
    @Test
    public void testGetCountNominateCouponBusiness() throws Exception
    {
        NominateCouponBusiness nominateCouponBusiness = new NominateCouponBusiness();
        /*        nominateCouponBusiness.setStartTime(TimeUtils.convertStringToDate("2013-09-24 14:23:16"));
                nominateCouponBusiness.setEndTime(TimeUtils.convertStringToDate("2014-09-24 14:23:17"));
                nominateCouponBusiness.setShopName("新华书店");
                nominateCouponBusiness.setCouponName("满300赠100（收藏广场）");
                nominateCouponBusiness.setPublishStartTime(TimeUtils.convertStringToDate("2013-08-12 00:00:00"));
                nominateCouponBusiness.setPublishEndTime(TimeUtils.convertStringToDate("2014-12-19 23:59:59"));
                nominateCouponBusiness.setUseStartTime(TimeUtils.convertStringToDate("2013-08-13 00:00:00"));
                nominateCouponBusiness.setUseEndTime(TimeUtils.convertStringToDate("2014-11-19 23:59:59"));*/
        // nominateCouponBusiness.setIsNominate("Y");
        //nominateCouponBusiness.setCouponType("D");
        int i = this.nominateCouponQueryService.countNominateCouponBusiness(nominateCouponBusiness);
        Assert.assertNotNull("获取推荐优惠凭证列表总数失败", i);
    }

    /**
     * 获取推荐优惠凭证列表
     * @throws NullException
     */
    @Test
    public void testGetNominateCouponList() throws Exception
    {
        NominateCouponBusiness nominateCouponBusiness = new NominateCouponBusiness();
        //nominateCouponBusiness.setStartTime(TimeUtils.convertStringToDate("2012-09-24"));
        //  nominateCouponBusiness.setEndTime(TimeUtils.convertStringToDate("2014-09-24 "));
        /*  nominateCouponBusiness.setShopName("新华书店");
          nominateCouponBusiness.setCouponName("满300赠100（收藏广场）");*/
        // nominateCouponBusiness.setPublishStartTime(TimeUtils.convertStringToDate("2012-08-12"));
        // nominateCouponBusiness.setPublishEndTime(TimeUtils.convertStringToDate("2015-12-19"));
        //nominateCouponBusiness.setUseStartTime(TimeUtils.convertStringToDate("2013-10-25"));
        //nominateCouponBusiness.setUseEndTime(TimeUtils.convertStringToDate("2015-11-09"));
        //nominateCouponBusiness.setCouponType("D");
        nominateCouponBusiness.setShopName("书店");
        nominateCouponBusiness.setEndTime(TimeUtils.convertStringToDate("2014-09-24"));
        List<NominateCouponBusiness> nominateCouponBusinessList = this.nominateCouponQueryService.findNominateCoupon(nominateCouponBusiness, 1, 100);
        Assert.assertNotNull("获取推荐优惠凭证列表失败", nominateCouponBusinessList);
    }

    /**
     * 获取推荐优惠凭证列表总数
     * @throws NullException
     */
    @Test
    public void testGetCountNominateCoupon() throws Exception
    {
        NominateCouponBusiness nominateCouponBusiness = new NominateCouponBusiness();
        /*        nominateCouponBusiness.setStartTime(TimeUtils.convertStringToDate("2013-09-24 14:23:16"));
                nominateCouponBusiness.setEndTime(TimeUtils.convertStringToDate("2014-09-24 14:23:17"));
                nominateCouponBusiness.setShopName("新华书店");
                nominateCouponBusiness.setCouponName("满300赠100（收藏广场）");
                nominateCouponBusiness.setPublishStartTime(TimeUtils.convertStringToDate("2013-08-12 00:00:00"));
                nominateCouponBusiness.setPublishEndTime(TimeUtils.convertStringToDate("2014-12-19 23:59:59"));
                nominateCouponBusiness.setUseStartTime(TimeUtils.convertStringToDate("2013-08-13 00:00:00"));
                nominateCouponBusiness.setUseEndTime(TimeUtils.convertStringToDate("2014-11-19 23:59:59"));*/
        //nominateCouponBusiness.setCouponType("D");
        //nominateCouponBusiness.setStartTime(TimeUtils.convertStringToDate("2018-09-24 14:23:16"));
        nominateCouponBusiness.setEndTime(TimeUtils.convertStringToDate("2014-09-24 14:23:17"));
        int i = this.nominateCouponQueryService.countNominateCoupon(nominateCouponBusiness);
        Assert.assertNotNull("获取推荐优惠凭证列表总数失败", i);
    }
}
