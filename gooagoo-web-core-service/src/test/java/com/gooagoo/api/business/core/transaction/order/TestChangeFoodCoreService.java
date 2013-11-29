package com.gooagoo.api.business.core.transaction.order;

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

import com.gooagoo.entity.generator.bill.BillAddInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestChangeFoodCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ChangeFoodCoreService changeFoodCoreService;

    @Override
    @Resource(name = "billSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 4.3.13. 用户申请加菜
     * @throws Exception
     */
    @Test
    public void testApplyAddFood() throws Exception
    {
        String tableName = "104";
        List<BillAddInfo> billAddInfoList = new ArrayList<BillAddInfo>();
        BillAddInfo billAddInfo = new BillAddInfo();
        billAddInfo.setGoodsId("0182AK9G7EC8UOM0NCQU29EIISWR2HCH");
        billAddInfo.setGoodsNum(1);
        billAddInfo.setUserId("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        billAddInfoList.add(billAddInfo);
        Assert.isTrue(this.changeFoodCoreService.applyAddFood(tableName, billAddInfoList), "加菜失败");
    }

    /**
     * 4.3.14. 店员帮用户申请退菜
     * @throws Exception
     */
    @Test
    public void testApplyMinusFood() throws Exception
    {

        Assert.isTrue(true, "");
    }

    /**
     * 加菜
     * @throws Exception
     */
    @Test
    public void testAddFood() throws Exception
    {

        Assert.isTrue(true, "");
    }

    /**
     * 退菜
     * @throws Exception
     */
    @Test
    public void testMinusFood() throws Exception
    {

        Assert.isTrue(true, "");
    }

}
