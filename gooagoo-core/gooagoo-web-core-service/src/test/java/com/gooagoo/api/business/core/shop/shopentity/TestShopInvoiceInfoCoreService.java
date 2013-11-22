package com.gooagoo.api.business.core.shop.shopentity;

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

import com.gooagoo.entity.generator.shop.ShopInvoiceInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestShopInvoiceInfoCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShopInvoiceInfoCoreService shopInvoiceInfoCoreService;

    @Override
    @Resource(name = "shopSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 修改发票信息
     * @throws Exception
     */
    @Test
    public void testUpateShopInvoiceInfo() throws Exception
    {
        ShopInvoiceInfo shopInvoiceInfo = new ShopInvoiceInfo();
        shopInvoiceInfo.setShopEntityId("1");
        shopInvoiceInfo.setName1("test12");
        shopInvoiceInfo.setName2("tt");
        boolean isSucceed = this.shopInvoiceInfoCoreService.upateShopInvoiceInfo(shopInvoiceInfo);
        Assert.isTrue(isSucceed, "修改发票信息");
    }

}
