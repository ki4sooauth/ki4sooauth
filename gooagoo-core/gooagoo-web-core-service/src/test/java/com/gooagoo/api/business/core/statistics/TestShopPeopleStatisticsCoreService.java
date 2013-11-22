package com.gooagoo.api.business.core.statistics;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestShopPeopleStatisticsCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShopPeopleStatisticsCoreService shopPeopleStatisticsCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 查询商家所有实体店店内人数(当前时刻)
     * @throws Exception
     */
    @Test
    public void testFindAllEntityPeopleNum() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询商家所有实体店店内人群(当前时刻)
     * @throws Exception
     */
    @Test
    public void testFindAllEntityPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询到达商家人数
     * @throws Exception
     */
    @Test
    public void testFindArriveShopPeopleNum() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询到达商家次数
     * @throws Exception
     */
    @Test
    public void testFindArriveShopTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询到达商家人群
     * @throws Exception
     */
    @Test
    public void testFindArriveShopPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询商家新增用户人数
     * @throws Exception
     */
    @Test
    public void testFindShopAddPeopleNum() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询商家新增用户人群
     * @throws Exception
     */
    @Test
    public void testFindShopAddPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询商家用户人数
     * @throws Exception
     */
    @Test
    public void testFindShopUserNum() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询商家用户人群
     * @throws Exception
     */
    @Test
    public void testFindShopPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

}
