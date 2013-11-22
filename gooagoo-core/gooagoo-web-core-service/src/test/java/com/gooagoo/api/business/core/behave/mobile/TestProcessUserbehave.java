package com.gooagoo.api.business.core.behave.mobile;

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
public class TestProcessUserbehave extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ProcessUserbehave processUserbehave;

    @Override
    @Resource(name = "marketingSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 记录用户使用手机行为
     * @throws Exception
     */
    @Test
    public void testFindGoodsInfo() throws Exception
    {
        String behavior = "05|1857EUF55J8N4L00A1BAQJMECL15G1KF|20131014093040,20131014093042";
        Assert.isTrue(this.processUserbehave.processUserMobileBehave(behavior), "记录用户使用手机行为失败");
    }

}
