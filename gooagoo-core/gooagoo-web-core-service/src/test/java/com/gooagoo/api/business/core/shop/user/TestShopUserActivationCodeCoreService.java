package com.gooagoo.api.business.core.shop.user;

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
public class TestShopUserActivationCodeCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShopUserActivationCodeCoreService shopUserActivationCodeCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 获取邮件激活码
     * @throws Exception
     */
    @Test
    public void testGetActivationCode() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 校验邮箱激活码
     * @throws Exception
     */
    @Test
    public void testCheckActivationCode() throws Exception
    {

       Assert.isTrue(true, "");
    }

}
