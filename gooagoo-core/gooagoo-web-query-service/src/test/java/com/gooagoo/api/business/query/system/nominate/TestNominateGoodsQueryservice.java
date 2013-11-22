package com.gooagoo.api.business.query.system.nominate;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.system.nominate.NominateGoodsBusiness;
import com.gooagoo.exception.common.NullException;

public class TestNominateGoodsQueryservice
{
    public NominateGoodsQueryService nominateGoodsQueryService;

    @Before
    public void testBefore()
    {
        this.nominateGoodsQueryService = ApplicationContextUtils.getBean(NominateGoodsQueryService.class);
    }

    /**
     * 获取推荐商品列表
     * @throws NullException
     */
    @Test
    public void testGetNominateGoodsBusinessList() throws Exception
    {
        NominateGoodsBusiness nominateGoodsBusiness = new NominateGoodsBusiness();
        // nominateGoodsBusiness.setStartTime(TimeUtils.convertStringToDate("2012-09-24"));
        //nominateGoodsBusiness.setEndTime(TimeUtils.convertStringToDate("2015-09-24 14:21:44"));
        nominateGoodsBusiness.setGoodsName("实战");
        //nominateGoodsBusiness.setGoodsSerial("9787505894969");
        // nominateGoodsBusiness.setItemSerial("112");
        //nominateGoodsBusiness.setIsNominate("N");
        List<NominateGoodsBusiness> nominateGoodsBusinessList = this.nominateGoodsQueryService.findNominateGoodsBusiness(nominateGoodsBusiness, 1, 100);
        Assert.assertNotNull("获取推荐商品列表失败", nominateGoodsBusinessList);
    }

    /**
     * 获取推荐商品列表总数
     * @throws NullException
     */
    @Test
    public void testGetCountNominateGoodsBusiness() throws Exception
    {
        NominateGoodsBusiness nominateGoodsBusiness = new NominateGoodsBusiness();
        /* nominateGoodsBusiness.setStartTime(TimeUtils.convertStringToDate("2013-09-24 14:20:31"));
         nominateGoodsBusiness.setEndTime(TimeUtils.convertStringToDate("2014-09-24 14:20:34"));
        
         nominateGoodsBusiness.setGoodsSerial("9787505894969");
         nominateGoodsBusiness.setItemSerial("112");*/
        //nominateGoodsBusiness.setIsNominate("Y");
        //nominateGoodsBusiness.setGoodsName("零售研究");
        int i = this.nominateGoodsQueryService.countNominateGoodsBusiness(nominateGoodsBusiness);
        Assert.assertNotNull("获取推荐商品列表总数失败", i);
    }

    /**
     * 获取推荐商品列表
     * @throws NullException
     */
    @Test
    public void testfindNominateGoods() throws Exception
    {
        NominateGoodsBusiness nominateGoodsBusiness = new NominateGoodsBusiness();
        //nominateGoodsBusiness.setStartTime(TimeUtils.convertStringToDate("2013-09-24 14:20:31"));
        //nominateGoodsBusiness.setEndTime(TimeUtils.convertStringToDate("2014-09-24 14:20:34"));

        /* nominateGoodsBusiness.setGoodsSerial("9787505894969");
         nominateGoodsBusiness.setItemSerial("112");*/
        //nominateGoodsBusiness.setGoodsName("零售研究");
        //nominateGoodsBusiness.setShopEntityName("京图书大厦");
        // nominateGoodsBusiness.setEndTime(TimeUtils.convertStringToDate("2015-09-26"));
        List<NominateGoodsBusiness> nominateGoodsBusinessList = this.nominateGoodsQueryService.findNominateGoods(nominateGoodsBusiness, 1, 100);
        Assert.assertNotNull("获取推荐商品列表失败", nominateGoodsBusinessList);
    }

    /**
     * 获取推荐商品列表总数
     * @throws NullException
     */
    @Test
    public void testGetCountNominateGoods() throws Exception
    {
        NominateGoodsBusiness nominateGoodsBusiness = new NominateGoodsBusiness();
        // nominateGoodsBusiness.setStartTime(TimeUtils.convertStringToDate("2019-09-24 14:20:31"));
        nominateGoodsBusiness.setEndTime(TimeUtils.convertStringToDate("2014-09-24 14:20:34"));
        /*
         nominateGoodsBusiness.setGoodsSerial("9787505894969");
         nominateGoodsBusiness.setItemSerial("112");*/
        //nominateGoodsBusiness.setGoodsName("零售研究");
        int i = this.nominateGoodsQueryService.countNominateGoods(nominateGoodsBusiness);
        Assert.assertNotNull("获取推荐商品列表总数失败", i);
    }
}
