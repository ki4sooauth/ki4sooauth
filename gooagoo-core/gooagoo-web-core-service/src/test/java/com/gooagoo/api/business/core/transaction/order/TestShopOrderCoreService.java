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

import com.gooagoo.entity.generator.bill.ShopOrderDetail;
import com.gooagoo.entity.generator.bill.ShopOrderInfo;
import com.gooagoo.entity.generator.bill.ShopOrderPic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class TestShopOrderCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShopOrderCoreService shopOrderCoreService;

    @Override
    @Resource(name = "billSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 商家订单数据上传
     * @throws Exception
     */
    @Test
    public void testAddShopOrder() throws Exception
    {
        ShopOrderInfo shopOrderInfo = new ShopOrderInfo();
        shopOrderInfo.setShopId("01822IE57DH111M085QBPFEIISWR0JGT");
        shopOrderInfo.setShopEntityId("01822K7105HMGOM07GRNH4EIISWR2K8D");
        shopOrderInfo.setMac("40:2c:f4:a8:38:b0");
        shopOrderInfo.setScardNo("1000000000000300");
        shopOrderInfo.setOriginalPrice(328.0);
        shopOrderInfo.setDiscountRate(1.1);
        shopOrderInfo.setPayPrice(328.0);
        shopOrderInfo.setThirdOrderId("61232450");
        shopOrderInfo.setDeskName("138台");
        //3.组装入参shopOrderDetailList（商家订单明细信息）
        List<ShopOrderDetail> shopOrderDetailList = new ArrayList<ShopOrderDetail>();
        ShopOrderDetail tempShopOrderDetail = new ShopOrderDetail();
        tempShopOrderDetail.setGoodsName("兰特伯爵拼盘总汇");
        tempShopOrderDetail.setGoodsPrice(328.0);
        tempShopOrderDetail.setPayPrice(328.0);
        tempShopOrderDetail.setGoodsNum(1);
        shopOrderDetailList.add(tempShopOrderDetail);

        ShopOrderPic shopOrderPic = new ShopOrderPic();
        shopOrderPic.setPicUrl("http://img.gooagoo.com/1.jpg");
        Assert.isTrue(this.shopOrderCoreService.addShopOrder(shopOrderInfo, shopOrderDetailList, shopOrderPic), "上传商家订单失败");
    }
}
