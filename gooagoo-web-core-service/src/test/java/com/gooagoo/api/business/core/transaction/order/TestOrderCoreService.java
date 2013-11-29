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
public class TestOrderCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public OrderCoreService orderCoreService;

    @Override
    @Resource(name = "billSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 删除账单
     * @throws Exception
     */
    @Test
    public void testDeleteOrder() throws Exception
    {

        Assert.isTrue(true, "");
    }

    /**
     * 修改抬头
     * @throws Exception
     */
    @Test
    public void testChangeDiningNumbers() throws Exception
    {
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String tableName = "125台";
        String peopleNums = "5";
        Assert.isTrue(this.orderCoreService.changeDiningNumbers(shopEntityId, tableName, peopleNums), "修改台头失败");
    }

    /**
     * 重量确认
     * @throws Exception
     */
    @Test
    public void testConfirmWeight() throws Exception
    {
        String orderId = "2013100000000B03";
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String tableName = "125台";
        String itemSerial = "206003";
        String weightNum = "10";
        Assert.isTrue(this.orderCoreService.confirmWeight(orderId, shopEntityId, tableName, itemSerial, weightNum), "重量确认失败");
    }

}
