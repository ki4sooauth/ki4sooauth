package com.gooagoo.api.business.core.shop.lid;

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

import com.gooagoo.entity.generator.shop.ShopLidDetail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestShopLidCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShopLidCoreService shopLidCoreService;

    @Override
    @Resource(name = "shopSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 修改lid详细
     * @throws Exception
     */
    @Test
    public void testUpdateShopLidDetail() throws Exception
    {
        ShopLidDetail shopLidDetail = new ShopLidDetail();
        shopLidDetail.setLid("11111111");
        shopLidDetail.setStatus("Y");
        boolean isSucceed = this.shopLidCoreService.updateShopLidDetail(shopLidDetail);
        Assert.isTrue(isSucceed, "修改lid详细");
    }

}
