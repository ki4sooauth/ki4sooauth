package com.gooagoo.api.business.core.shop.shopinfo;

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
public class TestShopInfoCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShopInfoCoreService shopInfoCoreService;

    @Override
    @Resource(name = "shopSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 修改商家信息
     * @throws Exception
     */
    @Test
    public void testUpdateShopInfo() throws Exception
    {
        String token = "000181T9K60TQBVK300006EIISWR1G9C";
        boolean isSucceed = this.shopInfoCoreService.updateShopInfo("00017Q3EG198TUUV50000HFYOBYEH00F", "test1212", token);
        Assert.isTrue(isSucceed, "修改商家信息");
    }

    /**
     * 修改头像(logo)
     * @throws Exception
     */
    @Test
    public void testUpdateShopLogo() throws Exception
    {
        String token = "000181T9K60TQBVK300006EIISWR1G9C";
        boolean isSucceed = this.shopInfoCoreService.updateShopLogo("00017Q3EG198TUUV50000HFYOBYEH00F", "http://html.gooagoo.com/gms/goods/images/default_goods.png", token);
        Assert.isTrue(isSucceed, "修改头像(logo)");
    }

    /**
     * 修改头像(head)
     * @throws Exception
     */
    @Test
    public void testUpdateShopHead() throws Exception
    {
        String token = "000181T9K60TQBVK300006EIISWR1G9C";
        boolean isSucceed = this.shopInfoCoreService.updateShopHead("00017Q3EG198TUUV50000HFYOBYEH00F", "http://html.gooagoo.com/gms/goods/images/default_goods.png", token);
        Assert.isTrue(isSucceed, "修改头像(head)");
    }

    /**
     * 正常营业
     * @throws Exception
     */
    @Test
    public void testNormalBusiness() throws Exception
    {

        Assert.isTrue(true, "");
    }

}
