package com.gooagoo.api.business.core.shop.user;

import java.util.ArrayList;
import java.util.Date;
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

import com.gooagoo.entity.generator.shop.ShopUserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestShopUserCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShopUserCoreService shopUserCoreService;

    @Override
    @Resource(name = "shopSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 添加店员
     * @throws Exception
     */
    @Test
    public void testAddShopUserInfo() throws Exception
    {
        ShopUserInfo shopUserInfo = new ShopUserInfo();
        shopUserInfo.setBirthday(new Date());
        shopUserInfo.setBrand("");
        shopUserInfo.setIdNo("1");
        shopUserInfo.setIdType("1");
        shopUserInfo.setIsShopAccount("Y");
        shopUserInfo.setName("1");
        shopUserInfo.setPassword("1");
        shopUserInfo.setSex("M");
        shopUserInfo.setShopEntityId("");
        shopUserInfo.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        shopUserInfo.setStatus("U");
        shopUserInfo.setUserId("1@1.11");
        boolean isSucceed = this.shopUserCoreService.addShopUserInfo(shopUserInfo);
        Assert.isTrue(isSucceed, "添加店员");
    }

    /**
     * 修改店员
     * @throws Exception
     */
    @Test
    public void testUpdateShopUserInfo() throws Exception
    {
        ShopUserInfo shopUserInfo = new ShopUserInfo();
        shopUserInfo.setIdNo("1111");
        shopUserInfo.setUserId("SFAS@sdf.com");
        boolean isSucceed = this.shopUserCoreService.updateShopUserInfo(shopUserInfo);
        Assert.isTrue(isSucceed, "修改店员");
    }

    /**
     * 删除店员
     * @throws Exception
     */
    @Test
    public void testDeleteShopUserInfo() throws Exception
    {
        boolean isSucceed = this.shopUserCoreService.deleteShopUserInfo("SFAS@sdf.com");
        Assert.isTrue(isSucceed, "删除店员");
    }

    /**
     * 店员绑定角色
     * @throws Exception
     */
    @Test
    public void testBindRoles() throws Exception
    {
        List<String> roleIdList = new ArrayList<String>();
        roleIdList.add("00017");
        roleIdList.add("000181B78CLTEBLGMARUE3BJ444KG5GS");
        boolean isSucceed = this.shopUserCoreService.bindRoles("SFAS@sdf.com", roleIdList);
        Assert.isTrue(isSucceed, "店员绑定角色");
    }

}
