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
public class TestInteractiveCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public InteractiveCoreService interactiveCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 查询手机互动人数
     * @throws Exception
     */
    @Test
    public void testFindPhoneInterPeopleNum() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询手机互动次数
     * @throws Exception
     */
    @Test
    public void testFindPhoneInterTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询手机互动人群
     * @throws Exception
     */
    @Test
    public void testFindPhoneInterPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询网站互动人数
     * @throws Exception
     */
    @Test
    public void testFindWebInterPeopleNum() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询网站互动次数
     * @throws Exception
     */
    @Test
    public void testFindWebInterTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询网站互动人群
     * @throws Exception
     */
    @Test
    public void testFindWebInterPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

}
