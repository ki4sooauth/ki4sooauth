package com.gooagoo.core.business.user.personal.manageApp;

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

import com.gooagoo.api.business.core.user.app.AppSerialNumberCoreService;
import com.gooagoo.entity.generator.user.ProductSerialNumber;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestAppSerialNumberCoreService extends AbstractTransactionalJUnit4SpringContextTests
{
    @Autowired
    AppSerialNumberCoreService appSerialNumberCoreService;

    @Override
    @Resource(name = "userSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    @Test
    public void testAppSerialNumber() throws Exception
    {
        try
        {
            ProductSerialNumber productSerialNumber = new ProductSerialNumber();
            this.appSerialNumberCoreService.appSerialNumber(productSerialNumber);
        }
        catch (Exception e)
        {
            Assert.isTrue(false, "手机APP序列号分配失败" + e);
        }
    }

}
