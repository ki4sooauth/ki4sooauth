package com.gooagoo.api.business.core.shop.table;

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
public class TestTableStatusCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public TableStatusCoreService tableStatusCoreService;

    @Override
    @Resource(name = "billSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 餐桌开台管理
     * @throws Exception
     */
    @Test
    public void testOpenTable() throws Exception
    {
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String tableName = "101台";
        String peopleNums = "4";
        Assert.isTrue(this.tableStatusCoreService.openTable(shopEntityId, tableName, peopleNums), "开台失败");
    }

    /**
     * 餐桌清台管理
     * @throws Exception
     */
    @Test
    public void testClearTable() throws Exception
    {
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String tableName = "101台";
        Assert.isTrue(this.tableStatusCoreService.clearTable(shopEntityId, tableName), "清台失败");
    }
}
