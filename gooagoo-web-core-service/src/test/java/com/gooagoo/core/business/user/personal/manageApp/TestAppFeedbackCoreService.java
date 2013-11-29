package com.gooagoo.core.business.user.personal.manageApp;

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

import com.gooagoo.api.business.core.user.app.AppFeedbackCoreService;
import com.gooagoo.entity.generator.behave.UserFeedback;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestAppFeedbackCoreService extends AbstractTransactionalJUnit4SpringContextTests
{
    @Autowired
    AppFeedbackCoreService appFeedbackCoreService;

    @Override
    @Resource(name = "behaveSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    @Test
    public void testAppFeedback() throws Exception
    {
        UserFeedback userFeedback = new UserFeedback();
        boolean isSucceed = this.appFeedbackCoreService.appFeedback(userFeedback);
        Assert.isTrue(isSucceed, "手机APP产品意见反馈失败");
    }

}
