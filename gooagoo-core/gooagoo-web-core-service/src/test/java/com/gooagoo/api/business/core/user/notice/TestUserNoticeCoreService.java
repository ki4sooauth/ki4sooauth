package com.gooagoo.api.business.core.user.notice;

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
public class TestUserNoticeCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public UserNoticeCoreService userNoticeCoreService;

    @Override
    @Resource(name = "marketingSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 删除用户关联通知
     * @throws Exception
     */
    @Test
    public void testDeleteNotice() throws Exception
    {
        String ids = "A8BE41E7F18742F3B39F7B16C4CEF732,000181HESLNLPQQFM0VLG9BJ43J9P3RG";
        Assert.isTrue(this.userNoticeCoreService.deleteNotice(ids), "删除用户关联通知失败");
    }
}
