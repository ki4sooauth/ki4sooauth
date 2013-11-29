package com.gooagoo.api.business.core.system.user.enterprise;

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
public class TestAllotLidCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public AllotLidCoreService allotLidCoreService;

    @Override
    @Resource(name = "shopSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 分配Lid
     */
    @Test
    public void testAllotjLid()
    {
        String lidBase = "000000";
        String shopId = "01822IAKR5SKU02085QBP2EIISWR0JGT";
        String shopEntityId = "01822JF4R28QLJF07GRNH1EIISWR2K8D";
        try
        {
            Assert.isTrue(this.allotLidCoreService.allotjLid(lidBase, shopId, shopEntityId), "分配Lid失败");
        }
        catch (Exception e)
        {
            Assert.isTrue(false, e.getMessage());
        }
    }

    /**
     * 批量软删商家LID详细分配信息
     */
    @Test
    public void testBatchDeleteShopLidDetail()
    {
        String lids = "00000001";
        try
        {
            Assert.isTrue(this.allotLidCoreService.batchDeleteShopLidDetail(lids), "批量软删商家LID详细分配信息失败");
        }
        catch (Exception e)
        {
            Assert.isTrue(false, e.getMessage());
        }
    }
}
