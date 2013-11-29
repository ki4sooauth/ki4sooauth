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

import com.gooagoo.entity.generator.shop.ShopGpsInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestShopGpsInfoCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShopGpsInfoCoreService shopGpsInfoCoreService;

    @Override
    @Resource(name = "shopSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 修改gps信息
     * @throws Exception
     */
    @Test
    public void testUpdateShopGpsInfo() throws Exception
    {
        ShopGpsInfo shopGpsInfo = new ShopGpsInfo();
        shopGpsInfo.setShopEntityId("1");
        shopGpsInfo.setNote("test");
        shopGpsInfo.setShopGpsBaidux("1");
        shopGpsInfo.setShopGpsBaiduy("1");
        shopGpsInfo.setShopGpsGooglex("1");
        shopGpsInfo.setShopGpsGoogley("1");
        shopGpsInfo.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        boolean isSucceed = this.shopGpsInfoCoreService.updateShopGpsInfo(shopGpsInfo);
        Assert.isTrue(isSucceed, "修改gps信息");
    }

}
