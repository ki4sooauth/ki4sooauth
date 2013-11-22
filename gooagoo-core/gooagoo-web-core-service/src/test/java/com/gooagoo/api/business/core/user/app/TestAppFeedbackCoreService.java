package com.gooagoo.api.business.core.user.app;

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

import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.behave.UserFeedback;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestAppFeedbackCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public AppFeedbackCoreService appFeedbackCoreService;

    @Override
    @Resource(name = "behaveSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 手机APP产品意见反馈
     * @throws Exception
     */
    @Test
    public void testAppFeedback() throws Exception
    {
        UserFeedback userFeedback = new UserFeedback();
        userFeedback.setFeedbackId(UUID.getUUID());
        userFeedback.setUserId("00017OB2G5MV2NQP900007bj43p32018");
        userFeedback.setGooagooId("00017OC10Q9MDLFQU00006bj33332012");
        userFeedback.setIpAddress("127.0.0.1");
        userFeedback.setMacAddress("wmac");
        userFeedback.setHostName("IVGGDQBZ8JJH2ZU");
        userFeedback.setPhone("1234567");
        userFeedback.setContent("内容");
        Assert.isTrue(this.appFeedbackCoreService.appFeedback(userFeedback), "手机APP产品意见反馈失败");
    }
}
