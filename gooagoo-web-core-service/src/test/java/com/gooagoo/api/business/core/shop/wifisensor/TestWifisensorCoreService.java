package com.gooagoo.api.business.core.shop.wifisensor;

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

import com.gooagoo.entity.generator.shop.DeviceWifisensor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestWifisensorCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public WifisensorCoreService wifisensorCoreService;

    @Override
    @Resource(name = "shopSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 新增wifisensor设备
     * @throws Exception
     */
    @Test
    public void testAddWifisensor() throws Exception
    {

        Assert.isTrue(true, "");
    }

    /**
     * 编辑wifisensor设备
     * @throws Exception
     */
    @Test
    public void testUpdateWifisensor() throws Exception
    {
        DeviceWifisensor wifiinfo = new DeviceWifisensor();
        wifiinfo.setDeviceWifisensorId("00017RAHC38EHF4RQ00006BJ43P37001");
        wifiinfo.setStatus("2");
        boolean isSucceed = this.wifisensorCoreService.updateWifisensor(wifiinfo);
        Assert.isTrue(isSucceed, "编辑wifisensor设备");
    }

    /**
     * 删除wifisensor设备
     * @throws Exception
     */
    @Test
    public void testDeleteWifisensor() throws Exception
    {

        Assert.isTrue(true, "");
    }

}
