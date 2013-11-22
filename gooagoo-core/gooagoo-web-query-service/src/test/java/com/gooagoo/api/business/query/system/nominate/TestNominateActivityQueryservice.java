package com.gooagoo.api.business.query.system.nominate;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.system.nominate.NominateActivityBusiness;
import com.gooagoo.exception.common.NullException;

public class TestNominateActivityQueryservice
{
    public NominateActivityQueryService nominateActivityQueryService;

    @Before
    public void testBefore()
    {
        this.nominateActivityQueryService = ApplicationContextUtils.getBean(NominateActivityQueryService.class);
    }

    /**
     * 获取推荐活动列表
     * @throws NullException
     */
    @Test
    public void testGetNominateActivityBusinessList() throws Exception
    {
        NominateActivityBusiness nominateActivityBusiness = new NominateActivityBusiness();
        //nominateActivityBusiness.setStartTime(TimeUtils.convertStringToDate("2012-09-24"));
        //nominateActivityBusiness.setEndTime(TimeUtils.convertStringToDate("2015-09-24"));
        nominateActivityBusiness.setShopName("超市");
        //nominateActivityBusiness.setActivityName("1");
        //nominateActivityBusiness.setTitle("赠100");
        nominateActivityBusiness.setActivityStartTime(TimeUtils.convertStringToDate("2013-09-24 14:22:22"));
        nominateActivityBusiness.setActivityEndTime(TimeUtils.convertStringToDate("2014-09-24 14:22:24"));
        nominateActivityBusiness.setIsNominate("Y");

        List<NominateActivityBusiness> nominateActivityBusinessList = this.nominateActivityQueryService.findNominateActivityBusiness(nominateActivityBusiness, 1, 100);
        Assert.assertNotNull("获取推荐活动列表失败", nominateActivityBusinessList);
    }

    /**
     * 获取推荐活动列表总数
     * @throws NullException
     */
    @Test
    public void testGetCountNominateActivityBusiness() throws Exception
    {
        NominateActivityBusiness nominateActivityBusiness = new NominateActivityBusiness();
        /* nominateActivityBusiness.setStartTime(TimeUtils.convertStringToDate("2013-09-24 14:22:01"));
         nominateActivityBusiness.setEndTime(TimeUtils.convertStringToDate("2014-09-24 14:22:03"));
         nominateActivityBusiness.setShopName("新华书店");
         nominateActivityBusiness.setActivityName("满300赠100");
         nominateActivityBusiness.setTitle("满300赠100");
         nominateActivityBusiness.setActivityStartTime(TimeUtils.convertStringToDate("2013-08-19 00:00:00"));*/
        /*nominateActivityBusiness.setActivityEndTime(TimeUtils.convertStringToDate("2014-08-19"));
        nominateActivityBusiness.setIsNominate("N");*/
        //nominateActivityBusiness.setShopName("新华店");
        nominateActivityBusiness.setActivityEndTime(TimeUtils.convertStringToDate("2014-08-19"));
        int i = this.nominateActivityQueryService.countNominateActivityBusiness(nominateActivityBusiness);
        Assert.assertNotNull("获取推荐活动列表总数失败", i);
    }

    /**
     * 获取推荐活动列表
     * @throws NullException
     */
    @Test
    public void testGetNominateActivityList() throws Exception
    {
        NominateActivityBusiness nominateActivityBusiness = new NominateActivityBusiness();
        //nominateActivityBusiness.setStartTime(TimeUtils.convertStringToDate("2012-09-24"));
        //nominateActivityBusiness.setEndTime(TimeUtils.convertStringToDate("2013-11-08 12:54:04"));
        /*nominateActivityBusiness.setShopName("新华书店");
        nominateActivityBusiness.setActivityName("满300赠100");
        nominateActivityBusiness.setTitle("满300赠100");*/
        nominateActivityBusiness.setStartTime(TimeUtils.convertStringToDate("2013-09-24 14:22:22"));
        nominateActivityBusiness.setEndTime(TimeUtils.convertStringToDate("2014-09-24 14:22:24"));
        nominateActivityBusiness.setShopName("超市");

        //nominateActivityBusiness.setActivityName("1");
        //nominateActivityBusiness.setEndTime(TimeUtils.convertStringToDate("2013-12-06 17:44:08"));
        List<NominateActivityBusiness> nominateActivityBusinessList = this.nominateActivityQueryService.findNominateActivity(nominateActivityBusiness, 1, 100);
        Assert.assertNotNull("获取推荐活动列表失败", nominateActivityBusinessList);
    }

    /**
     * 获取推荐活动列表总数
     * @throws NullException
     */
    @Test
    public void testGetCountNominateActivity() throws Exception
    {
        NominateActivityBusiness nominateActivityBusiness = new NominateActivityBusiness();
        /* nominateActivityBusiness.setStartTime(TimeUtils.convertStringToDate("2013-09-24 14:22:01"));
         nominateActivityBusiness.setEndTime(TimeUtils.convertStringToDate("2014-09-24 14:22:03"));
         nominateActivityBusiness.setShopName("新华书店");
         nominateActivityBusiness.setActivityName("满300赠100");
         nominateActivityBusiness.setTitle("满300赠100");
         nominateActivityBusiness.setActivityStartTime(TimeUtils.convertStringToDate("2013-08-19 00:00:00"));*/
        /*nominateActivityBusiness.setActivityEndTime(TimeUtils.convertStringToDate("2014-08-19"));
        nominateActivityBusiness.setIsNominate("N");*/
        //nominateActivityBusiness.setShopName("新华店");
        //nominateActivityBusiness.setStartTime(TimeUtils.convertStringToDate("2019-09-24 14:22:01"));
        nominateActivityBusiness.setEndTime(TimeUtils.convertStringToDate("2014-09-24 14:22:03"));
        int i = this.nominateActivityQueryService.countNominateActivity(nominateActivityBusiness);
        Assert.assertNotNull("获取推荐活动列表总数失败", i);
    }

}
