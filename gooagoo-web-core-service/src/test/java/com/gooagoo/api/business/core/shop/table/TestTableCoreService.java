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

import com.gooagoo.entity.generator.shop.ShopTableInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestTableCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public TableCoreService tableCoreService;

    @Override
    @Resource(name = "shopSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testAddTable() throws Exception
    {
        ShopTableInfo shopTableInfo = new ShopTableInfo();
        shopTableInfo.setId("1");
        shopTableInfo.setMac("00:27:13:f7:c2:1d");
        shopTableInfo.setRemark("1");
        shopTableInfo.setRoomName("1");
        shopTableInfo.setShopEntityId("1");
        shopTableInfo.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        shopTableInfo.setStatus("1");
        shopTableInfo.setTableName("1");
        shopTableInfo.setTableTypeCode("00018167ORUOB5QHIIU8V4BJ444KG7E0");
        boolean isSucceed = this.tableCoreService.addTable(shopTableInfo);
        Assert.isTrue(isSucceed, "添加餐厅桌号");
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testUpdateTable() throws Exception
    {
        ShopTableInfo shopTableInfo = new ShopTableInfo();
        shopTableInfo.setId("0001816GRO1U02MJ05A19JBJ444KG8E0");
        shopTableInfo.setRoomName("2");
        boolean isSucceed = this.tableCoreService.updateTable(shopTableInfo);
        Assert.isTrue(isSucceed, "修改餐厅桌号");
    }

    /**
     * 删除餐厅桌号信
     * @throws Exception
     */
    @Test
    public void testDeleteTable() throws Exception
    {
        boolean isSucceed = this.tableCoreService.deleteTable("0001816GRO1U02MJ05A19JBJ444KG8E0");
        Assert.isTrue(isSucceed, "删除餐厅桌号");
    }

}
