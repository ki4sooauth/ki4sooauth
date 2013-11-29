package com.gooagoo.api.business.core.shop.queue;

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
public class TestShopQueueCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShopQueueCoreService shopQueueCoreService;

    @Override
    @Resource(name = "behaveSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 现场销号
     * @throws Exception
     */
    @Test
    public void testDeleteQueueNo() throws Exception
    {
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String queteNo = "2";
        Assert.isTrue(this.shopQueueCoreService.deleteQueueNo(shopEntityId, queteNo), "现场销号失败");
    }
}
