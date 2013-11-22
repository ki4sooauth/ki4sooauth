package com.gooagoo.api.business.query.statistics;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.query.business.statistics.ShopPeopleStatisticsQueryServiceImpl;

public class TestShopPeopleStatisticsQueryService
{

    public ShopPeopleStatisticsQueryService shopPeopleStatisticsService;

    @Before
    public void testBefore()
    {
        shopPeopleStatisticsService = new ShopPeopleStatisticsQueryServiceImpl();
    }

    /**
     * 查询商家所有实体店店内人数(当前时刻)
     * @throws Exception
     */
    public void testFindAllEntityPeopleNum() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 查询商家所有实体店店内人群(当前时刻)
     * @throws Exception
     */
    public void testFindAllEntityPeople() throws Exception
    {
        ShopPeopleStatisticsQueryServiceImpl people = new ShopPeopleStatisticsQueryServiceImpl();
        List<String> list = people.findAllEntityPeople("018231S8B6FQB9102VLL2EEIISWR2TKG", "M");
        System.out.println(list);
    }

    /**
     * 查询到达商家人数
     * @throws Exception
     */
    public void testFindArriveShopPeopleNum() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 查询到达商家次数
     * @throws Exception
     */
    public void testFindArriveShopTimes() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 查询到达商家人群
     * @throws Exception
     */
    public void testFindArriveShopPeople() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 查询商家新增用户人数
     * @throws Exception
     */
    @Test
    public void testFindShopAddPeopleNum() throws Exception
    {
        int num = this.shopPeopleStatisticsService.findShopAddPeopleNum("01822IAKR5SKU02085QBP2EIISWR0JGT", "A", new Date(0), new Date());
        System.out.println(num);
    }

    /**
     * 查询商家新增用户人群
     * @throws Exception
     */
    public void testFindShopAddPeople() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 查询商家用户人数
     * @throws Exception
     */
    public void testFindShopUserNum() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 查询商家用户人群
     * @throws Exception
     */
    public void testFindShopPeople() throws Exception
    {

        Assert.assertNotNull("", "");
    }

}
