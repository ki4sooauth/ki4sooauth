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

import com.gooagoo.entity.business.transaction.OrderResult;
import com.gooagoo.entity.generator.bill.BillPayApplication;
import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.OriginalBillDetail;
import com.gooagoo.entity.generator.bill.OriginalBillInfo;
import com.gooagoo.entity.generator.bill.OriginalBillPic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestShopBillCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShopBillCoreService shopBillCoreService;

    @Override
    @Resource(name = "billSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 4.3.1. 结账申请
     * @throws Exception
     */
    @Test
    public void testApplyBill() throws Exception
    {
        /*
        String tableName = "107台";
        String scardno = "1000000000000300";
        BillPayApplication billPayApplication = new BillPayApplication();
        billPayApplication.setShopId("01822IE57DH111M085QBPFEIISWR0JGT");
        billPayApplication.setShopEntityId("01822K7105HMGOM07GRNH4EIISWR2K8D");
        billPayApplication.setOrderId("100000000000a803");
        List<OrderCouponInfo> orderCouponInfoList = null;
        Assert.isTrue(this.shopBillCoreService.applyBill(tableName, scardno, billPayApplication, orderCouponInfoList), "结账申请失败");
        */
        String tableName = null;
        String scardno = "1000000000000300";
        BillPayApplication billPayApplication = new BillPayApplication();
        billPayApplication.setShopId("01822IE57DH111M085QBPFEIISWR0JGT");
        billPayApplication.setShopEntityId("01822K7105HMGOM07GRNH4EIISWR2K8D");
        billPayApplication.setOrderId("100000000000a803");
        List<OrderCouponInfo> orderCouponInfoList = null;
        Assert.isTrue(this.shopBillCoreService.applyBill(tableName, scardno, billPayApplication, orderCouponInfoList), "结账申请失败");
    }

    /**
     * gtsc05
     * @throws Exception
     */
    @Test
    public void testAddShopBill() throws Exception
    {
        OriginalBillInfo originalBillInfo = new OriginalBillInfo();
        originalBillInfo.setMac("00-50-55-CC-00-88");
        originalBillInfo.setShopId("01822IE57DH111M085QBPFEIISWR0JGT");
        originalBillInfo.setShopEntityId("01822K7105HMGOM07GRNH4EIISWR2K8D");
        originalBillInfo.setScardNo("2200010000001AF2");
        originalBillInfo.setGoodsTotalNum(1);
        originalBillInfo.setOriginalPrice(32.00);
        originalBillInfo.setDiscountRate(0.9);
        originalBillInfo.setPayPrice(28.80);
        originalBillInfo.setRoomName("101");
        originalBillInfo.setDeskName("101");
        List<OriginalBillDetail> originalBillDetailList = new ArrayList<OriginalBillDetail>();
        OriginalBillDetail originalBillDetail = new OriginalBillDetail();
        originalBillDetail.setShopId("01822IE57DH111M085QBPFEIISWR0JGT");
        originalBillDetail.setShopEntityId("01822K7105HMGOM07GRNH4EIISWR2K8D");
        originalBillDetail.setGoodsId("0182AKCDB1UI9J80NCQU2AEIISWR2HCH");
        originalBillDetail.setGoodsName("鸡尾香肠");
        originalBillDetail.setGoodsPrice(32.00);
        originalBillDetail.setPayPrice(28.80);
        originalBillDetail.setGoodsNum(1);
        originalBillDetailList.add(originalBillDetail);
        OriginalBillPic originalBillPic = new OriginalBillPic();
        originalBillPic.setPicUrl("http://img.gooagoo.com/goods/0182AKCDB1UI9J80NCQU2AEIISWR2HCH.jpg");
        OrderResult orderResult = this.shopBillCoreService.addShopBill(originalBillInfo, originalBillDetailList, originalBillPic);
        Assert.notNull(orderResult, "上传商家订单失败");
    }
}
