package com.gooagoo.api.business.core.shop.table;

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

import com.gooagoo.entity.generator.shop.ShopTableTypeManage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestTableTypeCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public TableTypeCoreService tableTypeCoreService;

    @Override
    @Resource(name = "shopSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 添加餐桌类型
     * @throws Exception
     */
    @Test
    public void testAddShopTableTypeManage() throws Exception
    {
        ShopTableTypeManage shopTableTypeManage = new ShopTableTypeManage();
        shopTableTypeManage.setMaxNums(2);
        shopTableTypeManage.setMinNums(1);
        shopTableTypeManage.setShopEntityId("000180RS58HOBN1DU4OI4UBJ11W375KC");
        shopTableTypeManage.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        shopTableTypeManage.setTableTypeCode("2");
        shopTableTypeManage.setTableTypeName("2");
        boolean isSucceed = this.tableTypeCoreService.addShopTableTypeManage(shopTableTypeManage);
        Assert.isTrue(isSucceed, "添加餐桌类型");
    }

    /**
     * 修改餐桌类型
     * @throws Exception
     */
    @Test
    public void testUpdateShopTableTypeManage() throws Exception
    {
        ShopTableTypeManage shopTableTypeManage = new ShopTableTypeManage();
        shopTableTypeManage.setTableTypeCode("00018167ORUOB5QHIIU8V4BJ444KG7E0");
        shopTableTypeManage.setTableTypeName("2");
        boolean isSucceed = this.tableTypeCoreService.updateShopTableTypeManage(shopTableTypeManage);
        Assert.isTrue(isSucceed, "修改餐桌类型");
    }

    /**
     * 删除餐桌类型
     * @throws Exception
     */
    @Test
    public void testDeleteShopTableTypeManage() throws Exception
    {
        boolean isSucceed = this.tableTypeCoreService.deleteShopTableTypeManage("00018167ORUOB5QHIIU8V4BJ444KG7E0");
        Assert.isTrue(isSucceed, "删除餐桌类型");
    }

}
