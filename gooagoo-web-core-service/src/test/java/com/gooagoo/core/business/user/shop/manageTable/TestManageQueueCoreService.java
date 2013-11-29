package com.gooagoo.core.business.user.shop.manageTable;

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

import com.gooagoo.api.business.core.shop.queue.ShopQueueCoreService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestManageQueueCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    ShopQueueCoreService shopQueueCoreService;

    @Override
    @Resource(name = "behaveSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    @Test
    public void testDeleteQueueNo() throws Exception
    {
        boolean isSucceed = this.shopQueueCoreService.deleteQueueNo("00017R07MTBFPI81N0000NBJ43J9P00K", "1");
        Assert.isTrue(isSucceed, "销号失败");
    }
}
