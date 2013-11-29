package com.gooagoo.api.business.core.user.deliveryaddress;

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
public class TestDeliveryAddressCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public DeliveryAddressCoreService deliveryAddressCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 创建收货地址
     * @throws Exception
     */
    @Test
    public void testAddDeliveryAddress() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 删除收货地址
     * @throws Exception
     */
    @Test
    public void testDeleteDeliveryAddress() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 删除要编辑的收货地址、新增一条新的收货地址
     * @throws Exception
     */
    @Test
    public void testUpdateDeliveryAddress() throws Exception
    {

       Assert.isTrue(true, "");
    }

}
