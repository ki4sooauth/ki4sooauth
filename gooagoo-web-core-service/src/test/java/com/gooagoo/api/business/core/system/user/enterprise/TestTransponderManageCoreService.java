package com.gooagoo.api.business.core.system.user.enterprise;

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
public class TestTransponderManageCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public TransponderManageCoreService transponderManageCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 新增转发器
     * @throws Exception
     */
    @Test
    public void testAddTransponder() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 编辑转发器
     * @throws Exception
     */
    @Test
    public void testUpdateTransponder() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 删除转发器
     * @throws Exception
     */
    @Test
    public void testDelTransponder() throws Exception
    {

       Assert.isTrue(true, "");
    }

}
