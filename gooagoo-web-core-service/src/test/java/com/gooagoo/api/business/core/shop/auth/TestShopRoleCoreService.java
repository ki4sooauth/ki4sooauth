package com.gooagoo.api.business.core.shop.auth;

import java.util.ArrayList;
import java.util.List;

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

import com.gooagoo.entity.generator.shop.ShopRole;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestShopRoleCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShopRoleCoreService shopRoleCoreService;

    @Override
    @Resource(name = "shopSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 添加角色
     * @throws Exception
     */
    @Test
    public void testAddShopRole() throws Exception
    {
        ShopRole shopRole = new ShopRole();
        shopRole.setRoleId("1");
        shopRole.setRoleName("test");
        shopRole.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        boolean isSucceed = this.shopRoleCoreService.addShopRole(shopRole);
        Assert.isTrue(isSucceed, "添加角色");
    }

    /**
     * 修改角色
     * @throws Exception
     */
    @Test
    public void testUpdateShopRole() throws Exception
    {
        ShopRole shopRole = new ShopRole();
        shopRole.setRoleId("00017");
        shopRole.setRoleName("test");
        boolean isSucceed = this.shopRoleCoreService.updateShopRole(shopRole);
        Assert.isTrue(isSucceed, "修改角色");
    }

    /**
     * 删除角色
     * @throws Exception
     */
    @Test
    public void testDeleteShopRole() throws Exception
    {
        boolean isSucceed = this.shopRoleCoreService.deleteShopRole("00017");
        Assert.isTrue(isSucceed, "删除角色");
    }

    /**
     * 角色绑定权限
     * @throws Exception
     */
    @Test
    public void testBindAuths() throws Exception
    {
        String roleId = "00017";
        List<String> authIdList = new ArrayList<String>();
        authIdList.add("1");
        boolean isSucceed = this.shopRoleCoreService.bindAuths(roleId, authIdList);
        Assert.isTrue(isSucceed, "角色绑定权限");
    }

}
