package com.gooagoo.api.business.core.system.sys.user;

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
public class TestSysUserManageCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public SysUserManageCoreService sysUserManageCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 新增系统管理员
     * @throws Exception
     */
    @Test
    public void testAddSysUser() throws Exception
    {

        Assert.isTrue(true, "");
    }

    /**
     * 编辑系统管理员信息
     * @throws Exception
     */
    @Test
    public void testUpdateSysUser() throws Exception
    {

        Assert.isTrue(true, "");
    }

    /**
     * 删除系统管理员
     * @throws Exception
     */
    @Test
    public void testDelSysUser() throws Exception
    {

        Assert.isTrue(true, "");
    }

}
