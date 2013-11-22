package com.gooagoo.api.business.query.system.nominate;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.system.nominate.NominateShopBusiness;
import com.gooagoo.exception.common.NullException;

public class TestNominateShopQueryService
{

    public NominateShopQueryService nominateShopQueryService;

    @Before
    public void testBefore()
    {
        this.nominateShopQueryService = ApplicationContextUtils.getBean(NominateShopQueryService.class);
    }

    /**
      * 获取推荐商家列表
      * @throws NullException
      */

    @Test
    public void testGetNominateShopBusinessList() throws Exception
    {
        NominateShopBusiness nominateShopBusiness = new NominateShopBusiness();
        // nominateShopBusiness.setEndTime(TimeUtils.convertStringToDate("2013-12-19 10:52:18"));
        nominateShopBusiness.setIsNominate("N");
        //nominateShopBusiness.setShopName("1");
        List<NominateShopBusiness> nominateShopBusinessList = this.nominateShopQueryService.findNominateShopBusinessList(nominateShopBusiness, 1, 100);
        Assert.assertNotNull("获取推荐商家列表失败", nominateShopBusinessList);
    }

    /**
          * 获取推荐商家列表总数
          * @throws NullException
          */

    @Test
    public void testGetCountNominateShopBusiness() throws Exception
    {
        NominateShopBusiness nominateShopBusiness = new NominateShopBusiness();
        nominateShopBusiness.setIsNominate("N");
        int i = this.nominateShopQueryService.CountNominateShopBusiness(nominateShopBusiness);
        Assert.assertNotNull("获取推荐商家列表总数失败", i);
    }

    /**
     * 获取推荐商家列表
     * @throws NullException
     */
    @Test
    public void testGetNominateShopBusiness() throws Exception
    {
        NominateShopBusiness nominateShopBusiness = new NominateShopBusiness();
        nominateShopBusiness.setStartTime(TimeUtils.convertStringToDate("2013-08-16 17:27:44"));
        List<NominateShopBusiness> nominateShopBusinessList = this.nominateShopQueryService.findNominateShopList(nominateShopBusiness, 1, 100);
        Assert.assertNotNull("获取推荐商家列表失败", nominateShopBusinessList);
    }

    /**
     * 获取推荐商家列表总数
     * @throws NullException
     */

    @Test
    public void testGetCountNominateShop() throws Exception
    {
        NominateShopBusiness nominateShopBusiness = new NominateShopBusiness();
        nominateShopBusiness.setStartTime(TimeUtils.convertStringToDate("2017-08-16 17:27:44"));
        int i = this.nominateShopQueryService.CountNominateShop(nominateShopBusiness);
        Assert.assertNotNull("获取推荐商家列表总数失败", i);
    }

}
