package com.gooagoo.api.business.query.statistics;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.query.business.statistics.ConsumeStatisticQueryServiceImpl;
import com.gooagoo.query.business.statistics.common.utils.StatisticsDataUtil;

public class TestConsumeStatisticQueryService
{

    public ConsumeStatisticQueryService consumeStatisticService;

    @Before
    public void testBefore()
    {
    }

    /**
     * 查询消费次数
     * @throws Exception
     */
    @Test
    public void testConsumeTimes() throws Exception
    {
        ConsumeStatisticQueryService c = new ConsumeStatisticQueryServiceImpl();
        //        Date date = TimeUtils.convertStringToDate("2013-09-10");
        int times = c.consumeTimes("185EVK63KPRTKH00A1BAQJMCA2H349CC", "", "A", new Date());
        System.out.println(times);

        String value = StatisticsDataUtil.jointKeyForRedis("185EVK63KPRTKH00A1BAQJMCA2H349CC", null, "M", null, null, "", new Date());
        System.out.println(value);
    }

    /**
     * 查询消费人群
     * @throws Exception
     */
    @Test
    public void testConsumePeople() throws Exception
    {
        ConsumeStatisticQueryService c = new ConsumeStatisticQueryServiceImpl();
        Date date = TimeUtils.convertStringToDate("2013-09-10");
        List<String> list = c.consumePeople("01822IAKR5SKU02085QBP2EIISWR0JGT", "D", "A", date);
        for (String s : list)
        {
            System.out.println(s);
        }
    }

    /**
     * 查询消费金额
     * @throws Exception
     */
    @Test
    public void testConsumeAmount() throws Exception
    {
        ConsumeStatisticQueryService c = new ConsumeStatisticQueryServiceImpl();
        Date date = TimeUtils.convertStringToDate("2013-09-10");
        double amount = c.consumeAmount("01822IAKR5SKU02085QBP2EIISWR0JGT", "D", "A", date);
        System.out.println(amount);
    }

    /**
     * 查询消费金额人群
     * @throws Exception
     */
    @Test
    public void testConsumeAmountPeople() throws Exception
    {
        ConsumeStatisticQueryService c = new ConsumeStatisticQueryServiceImpl();
        Date date = TimeUtils.convertStringToDate("2013-09-10");
        List<String> list = c.consumeAmountPeople("01822IAKR5SKU02085QBP2EIISWR0JGT", "D", "A", date);
        for (String s : list)
        {
            System.out.println(s);
        }
    }

}
