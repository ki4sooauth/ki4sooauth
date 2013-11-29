package com.gooagoo.api.business.core.system;

import java.util.Date;

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
public class TestSystemBusinessCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public SystemBusinessCoreService systemBusinessCoreService;

    @Override
    @Resource(name = "sysSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 获取Core系统当前时间
     */
    @Test
    public void testGetCoreSysCurrentTime()
    {
        Date currentTime = this.systemBusinessCoreService.getCoreSysCurrentTime();
        Assert.notNull(currentTime, "获取Core系统当前时间失败");
    }

}
