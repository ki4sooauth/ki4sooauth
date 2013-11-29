package com.gooagoo.api.business.core.transaction.order;

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
public class TestChangeTableCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ChangeTableCoreService changeTableCoreService;

    @Override
    @Resource(name = "billSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 餐桌换台管理
     * @throws Exception
     */
    @Test
    public void testExchangeTable() throws Exception
    {
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String tableNameFrom = "101台";
        String tableNameTo = "102台";
        Assert.isTrue(this.changeTableCoreService.exchangeTable(shopEntityId, tableNameFrom, tableNameTo), "换台失败");
    }

    /**
     * 餐桌并台管理
     * @throws Exception
     */
    @Test
    public void testMergeTable() throws Exception
    {
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String tableNameFrom = "108台";
        String tableNameTo = "107台";
        Assert.isTrue(this.changeTableCoreService.mergeTable(shopEntityId, tableNameFrom, tableNameTo), "并台失败");
    }
}
