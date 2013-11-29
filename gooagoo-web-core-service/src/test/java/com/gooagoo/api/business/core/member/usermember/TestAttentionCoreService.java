package com.gooagoo.api.business.core.member.usermember;

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
public class TestAttentionCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public AttentionCoreService attentionCoreService;

    @Override
    @Resource(name = "userSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 关注
     * @throws Exception
     */
    @Test
    public void testAddAttention() throws Exception
    {
        String userId = "1883FRM0MEJE5800A1BAQJMC3CLLDULQ";
        String shopId = "01822MAPVKNP054085QBQVEIISWR0JGT";
        Assert.isTrue(this.attentionCoreService.addAttention(userId, shopId), "关注失败");
    }

    /**
     * 取消关注
     * @throws Exception
     */
    @Test
    public void testDeleteAttention() throws Exception
    {
        String userId = "1883FRM0MEJE5800A1BAQJMC3CLLDULQ";
        String shopId = "01822MAPVKNP054085QBQVEIISWR0JGT";
        Assert.isTrue(this.attentionCoreService.deleteAttention(userId, shopId), "取消关注失败");
    }

}
