package com.gooagoo.api.business.core.user.queue;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

import com.gooagoo.entity.business.user.QueueBusiness;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestQueueCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public QueueCoreService queueCoreService;

    @Override
    @Resource(name = "memberSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * gasj02,mobe13
     * @throws Exception
     */
    @Test
    public void testArranging() throws Exception
    {
        String shopId = "01822RBQ22JSDMA085QBV8EIISWR0JGT";
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String scardno = null;
        String userId = null;
        String tableTypeCode = "018235LQ8VO5BMH02VLL2TEIISWR2TKG";
        String persianNums = "16";
        QueueBusiness queueBusiness = this.queueCoreService.arranging(shopId, shopEntityId, scardno, userId, tableTypeCode, persianNums);
        Assert.notNull(queueBusiness, "排号失败");
        Assert.isTrue(Integer.valueOf(queueBusiness.getQueueNo()) > 0, "获取排队信息出错");
    }

    /**
     * 刷新排号
     * @throws Exception
     */
    @Test
    public void testRefreshArranging() throws Exception
    {
        String userId = "0182COB2TOJ41SG10ME47DEIISWR0HMP";
        String shopEntityId = null;
        List<QueueBusiness> queueBusinessList = this.queueCoreService.refreshArranging(userId, shopEntityId);
        Assert.isTrue(CollectionUtils.isNotEmpty(queueBusinessList), "刷新排号失败");
    }

}
