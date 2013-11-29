package com.gooagoo.api.business.core.shop.shopentity;

import java.util.Date;

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

import com.gooagoo.entity.generator.shop.ShopEntityInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestShopentityCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShopentityCoreService shopentityCoreService;

    @Override
    @Resource(name = "shopSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 新增实体店
     * @throws Exception
     */
    @Test
    public void testAddShopEntityInfo() throws Exception
    {
        ShopEntityInfo shopEntityInfo = new ShopEntityInfo();
        shopEntityInfo.setShopEntityId("12");
        shopEntityInfo.setShopEntityName("test12");
        shopEntityInfo.setBusinessLicense("1");
        shopEntityInfo.setBusnissAlotedEndTime(new Date());
        shopEntityInfo.setBusnissAlotedStartTime(new Date());
        shopEntityInfo.setCloseTime("2014-12-12");
        shopEntityInfo.setCorporate("1");
        shopEntityInfo.setEnterpriseName("test");
        shopEntityInfo.setIntroduction("1");
        shopEntityInfo.setInvoiceExpire(1);
        shopEntityInfo.setIsGeneral("Y");
        shopEntityInfo.setOpenTime("8:00");
        shopEntityInfo.setPromptinfo("1");
        shopEntityInfo.setRegisteredCapital("1");
        shopEntityInfo.setRegisteredCity("1");
        shopEntityInfo.setRegisteredNumber("1");
        shopEntityInfo.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        shopEntityInfo.setShopRoadGuide("1");
        boolean isSucceed = this.shopentityCoreService.addShopEntityInfo(shopEntityInfo);
        Assert.isTrue(isSucceed, "新增实体店");
    }

    /**
     * 编辑实体店
     * @throws Exception
     */
    @Test
    public void testUpdateShopEntityInfo() throws Exception
    {
        ShopEntityInfo shopEntityInfo = new ShopEntityInfo();
        shopEntityInfo.setShopEntityId("11");
        shopEntityInfo.setShopEntityName("test");
        boolean isSucceed = this.shopentityCoreService.updateShopEntityInfo(shopEntityInfo);
        Assert.isTrue(isSucceed, "编辑实体店");
    }

    /**
     * 删除实体店
     * @throws Exception
     */
    @Test
    public void testDeleteShopEntityInfo() throws Exception
    {
        boolean isSucceed = this.shopentityCoreService.deleteShopEntityInfo("11");
        Assert.isTrue(isSucceed, "删除实体店");
    }

}
