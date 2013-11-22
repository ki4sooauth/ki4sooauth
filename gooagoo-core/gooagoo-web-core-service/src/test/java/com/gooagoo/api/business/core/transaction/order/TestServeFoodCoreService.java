package com.gooagoo.api.business.core.transaction.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class TestServeFoodCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ServeFoodCoreService serveFoodCoreService;

    @Override
    @Resource(name = "billSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 店员标记订单已上情况
     * @throws Exception
     */
    @Test
    public void testServe() throws Exception
    {
        String orderId = "100000000000B703";
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String tableName = "110台";
        List<Map<String, String>> goodsInfo = new ArrayList<Map<String, String>>();
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("itemserial", "203003");
        map1.put("goodsnum", "1");
        goodsInfo.add(map1);
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("itemserial", "203005");
        map2.put("goodsnum", "1");
        goodsInfo.add(map2);
        Assert.isTrue(this.serveFoodCoreService.serve(orderId, shopEntityId, tableName, goodsInfo), "店员标记订单已上情况失败");
    }

    /**
     * gasl08:店员帮助用户起菜
     * @throws Exception
     */
    @Test
    public void testOrderDish() throws Exception
    {
        String orderId = "2013100000000B03";
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String tableName = "125台";
        String itemSerial = "203004";
        String goodsNum = "1";
        Assert.isTrue(this.serveFoodCoreService.orderDish(orderId, shopEntityId, tableName, itemSerial, goodsNum), "店员标记订单已上情况失败");
    }

    /**
     * gasl09:店员帮助用户催菜
     * @throws Exception
     */
    @Test
    public void testHurryDish() throws Exception
    {
        String orderId = "2013100000000B03";
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String tableName = "125台";
        String itemSerial = null;
        String goodsKind = null;
        Assert.isTrue(this.serveFoodCoreService.hurryDish(orderId, shopEntityId, tableName, itemSerial, goodsKind), "店员标记订单已上情况失败");
    }

    /**
     * gasl10:店员帮助用户缓菜
     * @throws Exception
     */
    @Test
    public void testSlowDish() throws Exception
    {
        String orderId = "2013100000000B03";
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String tableName = "125台";
        String itemSerial = null;
        String goodsNum = null;
        Assert.isTrue(this.serveFoodCoreService.slowDish(orderId, shopEntityId, tableName, itemSerial, goodsNum), "店员标记订单已上情况失败");
    }
}
