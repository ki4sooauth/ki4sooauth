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

import com.gooagoo.entity.generator.shop.ShopEntityLink;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestShopEntityLinkCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShopEntityLinkCoreService shopEntityLinkCoreService;

    @Override
    @Resource(name = "shopSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 修改实体店联系方式
     * @throws Exception
     */
    @Test
    public void testUpdateShopEntityLink() throws Exception
    {
        ShopEntityLink shopEntityLink = new ShopEntityLink();
        shopEntityLink.setShopEntityId("1");
        shopEntityLink.setAddress("test");
        shopEntityLink.setArea("1");
        shopEntityLink.setCity("1");
        shopEntityLink.setMobile("1");
        shopEntityLink.setPhone("1");
        shopEntityLink.setPostCode("1");
        shopEntityLink.setProvince("1");
        boolean isSucceed = this.shopEntityLinkCoreService.updateShopEntityLink(shopEntityLink);
        Assert.isTrue(isSucceed, "修改实体店联系方式");
    }

}
