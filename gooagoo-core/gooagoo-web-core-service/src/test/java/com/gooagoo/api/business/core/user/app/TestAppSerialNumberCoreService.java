package com.gooagoo.api.business.core.user.app;

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

import com.gooagoo.entity.generator.user.ProductSerialNumber;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestAppSerialNumberCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public AppSerialNumberCoreService appSerialNumberCoreService;

    @Override
    @Resource(name = "userSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 手机APP序列号分配
     * @throws Exception
     */
    @Test
    public void testAppSerialNumber() throws Exception
    {
        ProductSerialNumber productSerialNumber = new ProductSerialNumber();
        productSerialNumber.setMacAddress("wmac");
        String gooagooid = this.appSerialNumberCoreService.appSerialNumber(productSerialNumber);
        Assert.notNull(gooagooid, "手机APP序列号分配失败");
    }
}
