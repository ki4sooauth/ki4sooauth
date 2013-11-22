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
public class TestShopEntityPeopleStatisticsCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShopEntityPeopleStatisticsCoreService shopEntityPeopleStatisticsCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 查询指定实体店店内人数(当前时刻)
     * @throws Exception
     */
    @Test
    public void testFindEntityPeopleNum() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询指定实体店店内 群(当前时刻)
     * @throws Exception
     */
    @Test
    public void testFindEntityPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询实体店指定区域内人数(当前时刻)
     * @throws Exception
     */
    @Test
    public void testFindEntityAreaPeopleNum() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询实体店指定区域内人群(当前时刻)
     * @throws Exception
     */
    @Test
    public void testFindEntityAreaPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询到达实体店人数
     * @throws Exception
     */
    @Test
    public void testFindArriveEntityPeopleNum() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询到达实体店次数
     * @throws Exception
     */
    @Test
    public void testFindArriveEntityTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询到达实体店人群
     * @throws Exception
     */
    @Test
    public void testFindArriveEntityPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询到达指定区域人数
     * @throws Exception
     */
    @Test
    public void testFindArriveEntityAreaPeopleNum() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询到达指定区域次数
     * @throws Exception
     */
    @Test
    public void testFindArriveEntityAreaTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询到达指定区域人群
     * @throws Exception
     */
    @Test
    public void testFindArriveEntityAreaPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

}
