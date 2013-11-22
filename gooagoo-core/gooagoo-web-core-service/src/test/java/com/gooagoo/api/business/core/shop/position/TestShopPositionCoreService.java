package com.gooagoo.api.business.core.shop.position;

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

import com.gooagoo.entity.generator.shop.ShopPosition;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestShopPositionCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShopPositionCoreService shopPositionCoreService;

    @Override
    @Resource(name = "shopSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 添加位置
     * @throws Exception
     */
    @Test
    public void testAddShopPosition() throws Exception
    {
        ShopPosition shopPosition = new ShopPosition();
        shopPosition.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        shopPosition.setShopEntityId("1");
        shopPosition.setPositionName("22");
        shopPosition.setPositionId("2");
        shopPosition.setParentPositionId("1");
        shopPosition.setDescription("test");
        boolean isSucceed = this.shopPositionCoreService.addShopPosition(shopPosition);
        Assert.isTrue(isSucceed, "添加位置");
    }

    /**
     * 修改位置
     * @throws Exception
     */
    @Test
    public void testUpdateShopPosition() throws Exception
    {
        ShopPosition shopPosition = new ShopPosition();
        shopPosition.setPositionName("22");
        shopPosition.setPositionId("1");
        shopPosition.setDescription("test12");
        boolean isSucceed = this.shopPositionCoreService.updateShopPosition(shopPosition);
        Assert.isTrue(isSucceed, "修改位置");
    }

    /**
     * 删除位置
     * @throws Exception
     */
    @Test
    public void testDeleteShopPosition() throws Exception
    {
        boolean isSucceed = this.shopPositionCoreService.deleteShopPosition("1");
        Assert.isTrue(isSucceed, "删除位置");
    }

}
