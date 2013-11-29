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

import com.gooagoo.entity.business.transaction.OrderResult;
import com.gooagoo.entity.generator.bill.UserOrderCoupon;
import com.gooagoo.entity.generator.bill.UserOrderDetail;
import com.gooagoo.entity.generator.bill.UserOrderInfo;
import com.gooagoo.entity.generator.user.ConsigneeInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestUserOrderCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public UserOrderCoreService userOrderCoreService;

    @Override
    @Resource(name = "billSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 用户提交订单(零售)
     * @throws Exception
     */
    @Test
    public void testAddUserOrder() throws Exception
    {
        ConsigneeInfo consigneeInfo = new ConsigneeInfo();
        UserOrderInfo userOrderInfo = new UserOrderInfo();
        userOrderInfo.setShopId("01822IE57DH111M085QBPFEIISWR0JGT");//沃尔玛超市
        userOrderInfo.setShopEntityId("01822K7105HMGOM07GRNH4EIISWR2K8D");//沃尔玛购物广场望京店
        userOrderInfo.setUserId(null);
        userOrderInfo.setDeskName("202台");
        userOrderInfo.setIsSaCommit("Y");//是否店员助理提交，Y-是
        List<UserOrderDetail> userOrderDetailList = new ArrayList<UserOrderDetail>();
        UserOrderDetail userOrderDetail = new UserOrderDetail();
        userOrderDetail.setGoodsId("0182ASRA04DCRP20SR22C4EIISWR2K1N");//脉动
        userOrderDetail.setGoodsNum(1);
        userOrderDetailList.add(userOrderDetail);
        UserOrderDetail userOrderDetail2 = new UserOrderDetail();
        userOrderDetail2.setGoodsId("0182AJRFGDH68600NCQU25EIISWR2HCH");//脉动
        userOrderDetail2.setGoodsNum(1);
        userOrderDetailList.add(userOrderDetail2);
        List<UserOrderCoupon> userOrderCouponList = new ArrayList<UserOrderCoupon>();
        Map<String, String> parmMap = new HashMap<String, String>();
        OrderResult orderResult = this.userOrderCoreService.addUserOrder(userOrderInfo, userOrderDetailList, userOrderCouponList, null, parmMap);
        Assert.notNull(orderResult, "提交用户订单失败");
    }

    /**
     * 绑定桌号、订单号、用户id
     * @throws Exception
     */
    @Test
    public void testBindTable() throws Exception
    {

        Assert.isTrue(true, "");
    }

}
