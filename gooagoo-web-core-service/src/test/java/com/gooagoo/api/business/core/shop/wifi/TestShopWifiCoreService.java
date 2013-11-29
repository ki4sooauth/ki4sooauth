package com.gooagoo.api.business.core.shop.wifi;

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

import com.gooagoo.entity.generator.shop.ShopWifiinfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestShopWifiCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShopWifiCoreService shopWifiCoreService;

    @Override
    @Resource(name = "shopSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 添加wifi
     * @throws Exception
     */
    @Test
    public void testAddShopWifiinfo() throws Exception
    {

        Assert.isTrue(true, "");
    }

    /**
     * 修改wifi
     * @throws Exception
     */
    @Test
    public void testUpdateShopWifiinfo() throws Exception
    {
        ShopWifiinfo shopWifiinfo = new ShopWifiinfo();
        shopWifiinfo.setWifiInfoId("0001816N0P2KJP88A7KPDVBJ11W376F4");
        shopWifiinfo.setWifiSsid("test");
        boolean isSucceed = this.shopWifiCoreService.updateShopWifiinfo(shopWifiinfo);
        Assert.isTrue(isSucceed, "修改wifi");
    }

    /**
     * 删除wifi
     * @throws Exception
     */
    @Test
    public void testDeleteShopWifiinfo() throws Exception
    {

        Assert.isTrue(true, "");
    }

}
