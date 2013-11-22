package com.gooagoo.api.business.query.statistics;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestShopEntityPeopleStatisticsQueryService
{

    public ShopEntityPeopleStatisticsQueryService shopEntityPeopleStatisticsService;

    @Before
    public void testBefore()
    {
        this.shopEntityPeopleStatisticsService = ApplicationContextUtils.getBean(ShopEntityPeopleStatisticsQueryService.class);
    }

    /**
     * 查询指定实体店店内人数(当前时刻)
     * @throws Exception
     */
    @Test
    public void testFindEntityPeopleNum() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 查询指定实体店店内 群(当前时刻)
     * @throws Exception
     */
    @Test
    public void testFindEntityPeople() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 查询实体店指定区域内人数(当前时刻)
     * @throws Exception
     */
    @Test
    public void testFindEntityAreaPeopleNum() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 查询实体店指定区域内人群(当前时刻)
     * @throws Exception
     */
    @Test
    public void testFindEntityAreaPeople() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 查询到达实体店人数
     * @throws Exception
     */
    @Test
    public void testFindArriveEntityPeopleNum() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 查询到达实体店次数
     * @throws Exception
     */
    @Test
    public void testFindArriveEntityTimes() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 查询到达实体店人群
     * @throws Exception
     */
    @Test
    public void testFindArriveEntityPeople() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 查询到达指定区域人数
     * @throws Exception
     */
    @Test
    public void testFindArriveEntityAreaPeopleNum() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 查询到达指定区域次数
     * @throws Exception
     */
    @Test
    public void testFindArriveEntityAreaTimes() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 查询到达指定区域人群
     * @throws Exception
     */
    @Test
    public void testFindArriveEntityAreaPeople() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
