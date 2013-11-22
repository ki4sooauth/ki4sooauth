package com.gooagoo.api.business.query.statistics;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.query.business.statistics.ExchangeStatisticQueryServiceImpl;

public class TestExchangeStatisticQueryService
{

    public ExchangeStatisticQueryService exchangeStatisticService;

    @Before
    public void testBefore()
    {
    }

    /**
     * 查询优惠凭证兑换次数
     * @throws Exception
     */
    @Test
    public void testCouponExchangeTimes() throws Exception
    {
        Date date = TimeUtils.convertStringToDate("2013-10-30");
        ExchangeStatisticQueryService e = new ExchangeStatisticQueryServiceImpl();
        int times = e.couponExchangeTimes("0182A30R0LHP8DK02VLL3UEIISWR2TKG", "A", "D", date);
        System.out.println(times);
    }

    /**
     * 查询优惠凭证兑换人群
     * @throws Exception
     */
    @Test
    public void testCouponExchangePeople() throws Exception
    {
        ExchangeStatisticQueryService e = new ExchangeStatisticQueryServiceImpl();
        List<String> list = e.couponExchangePeople("183M1GFTPVBSGU30KH62O3P83M56O017", "A", "D", new Date());
        for (String s : list)
        {
            System.out.println(s);
        }
    }

}
