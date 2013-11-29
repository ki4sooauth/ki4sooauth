package com.gooagoo.core.business.system.sys.version;

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

import com.gooagoo.api.business.core.system.sys.version.SysVersionManageCoreService;
import com.gooagoo.entity.generator.sys.MobileVersion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestSysVersionManageCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    SysVersionManageCoreService sysVersionManageCoreService;

    @Override
    @Resource(name = "sysSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 新增移动设备版本
     * @throws Exception
     */
    @Test
    public void testAddSysMobileVersion() throws Exception
    {
        MobileVersion mobileVersion = new MobileVersion();
        mobileVersion.setMobileType("1");
        mobileVersion.setVersion("version");
        mobileVersion.setNote("note");
        Assert.isTrue(this.sysVersionManageCoreService.addSysMobileVersion(mobileVersion), "新增移动设备版本失败");
    }
}
