package com.gooagoo.current.sub.behave;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.bi.entity.bill.Bill;
import com.gooagoo.current.utils.SendMessageUtil;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisSortedSetDao;

public class UseCouponTest
{
    SendMessageUtil sendMessageUtil = new SendMessageUtil();
    UseCoupon coupon = new UseCoupon();

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void test()
    {
        GooagooMessage<Bill> message = new GooagooMessage<Bill>();

        Bill bill = new Bill();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setShopId("shop001");
        orderInfo.setUserId("user003");
        bill.setOrderInfo(orderInfo);
        List<String> coupons = new ArrayList<String>();
        coupons.add("coupon1");
        coupons.add("coupon2");
        bill.setCoupons(coupons);

        message.setContent(bill);//消息内容
        this.coupon.message(bill);
    }

    @After
    public void after()
    {
        //this.sendMessageUtil.close();
    }

    @Test
    public void watch()
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_coupon);

        RedisDatabase base = new RedisDatabase(RedisServerConstants.statistics_coupon);
        Set<String> keys = base.keys("*");
        for (String key : keys)
        {
            System.out.println("key  : " + key);
            System.out.println("value: " + dao.get(key, 0, -1));
            System.out.println("-----------------------------");
        }
    }
}
