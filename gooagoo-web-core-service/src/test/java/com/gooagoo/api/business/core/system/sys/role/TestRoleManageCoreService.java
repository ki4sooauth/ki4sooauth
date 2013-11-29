package com.gooagoo.api.business.core.system.sys.role;

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
public class TestRoleManageCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public RoleManageCoreService roleManageCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 新增角色
     * @throws Exception
     */
    @Test
    public void testAddRole() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 编辑角色
     * @throws Exception
     */
    @Test
    public void testUpdateRole() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 删除角色
     * @throws Exception
     */
    @Test
    public void testDelRole() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 给管理员分配角色
     * @throws Exception
     */
    @Test
    public void testAssignRoles() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 给角色分配权限
     * @throws Exception
     */
    @Test
    public void testAssignPermissions() throws Exception
    {

       Assert.isTrue(true, "");
    }

}
