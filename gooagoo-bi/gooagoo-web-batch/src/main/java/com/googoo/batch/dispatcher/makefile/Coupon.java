package com.googoo.batch.dispatcher.makefile;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gooagoo.api.business.query.statistics.BrowseStatisticQueryService;
import com.gooagoo.api.business.query.statistics.CollectStatisticQueryService;
import com.gooagoo.api.business.query.statistics.ExchangeStatisticQueryService;
import com.gooagoo.api.business.query.statistics.ShareStatisticQueryService;
import com.gooagoo.api.business.query.statistics.UseStatisticQueryService;
import com.gooagoo.api.generator.query.marketing.CouponGeneratorQueryService;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.generator.marketing.CouponExample;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.vo.hightChartVo.chartVo.LineChartVo;
import com.googoo.batch.constants.BatchConsants;
import com.googoo.batch.utils.FileUtils;

//@Engine(BatchTimeCnstants.onMidnight)
public class Coupon implements Tyre
{

    private final BrowseStatisticQueryService browseStatisticService = SpringBeanUtils.getBean(BrowseStatisticQueryService.class);
    private final CollectStatisticQueryService collectStatisticService = SpringBeanUtils.getBean(CollectStatisticQueryService.class);
    private final ExchangeStatisticQueryService exchangeStatisticService = SpringBeanUtils.getBean(ExchangeStatisticQueryService.class);
    private final ShareStatisticQueryService shareStatisticService = SpringBeanUtils.getBean(ShareStatisticQueryService.class);
    private final UseStatisticQueryService useStatisticService = SpringBeanUtils.getBean(UseStatisticQueryService.class);
    private final CouponGeneratorQueryService couponGeneratorQueryService = SpringBeanUtils.getBean(CouponGeneratorQueryService.class);

    private static final String[] SOURCE = { "M", "W", "*" };
    private static final String[] USER_TYPE = { "A", "M", "N" };
    private static final String[] CHANNEL = { "C", "N", "M", "E", "P", "B", "*" };
    private static final String[] DATETYPE = { "Y", "M", "D", "H", "*" };

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 Coupon");
        this.makeCouponFile();
    }

    private void makeCouponFile()
    {
        List<Integer> brows = null;
        List<Integer> collect = null;
        List<Integer> exchange = null;
        List<Integer> share = null;
        List<Integer> use = null;
        int index = 0, pageSize = 500;
        while (true)
        {
            CouponExample couponExample = new CouponExample();
            couponExample.setPage(index, pageSize);
            List<com.gooagoo.entity.generator.marketing.Coupon> selectByExample = this.couponGeneratorQueryService.selectByExample(couponExample);
            for (String uType : USER_TYPE)
            {
                for (String tType : DATETYPE)
                {
                    for (String channel : CHANNEL)
                    {
                        for (String s : SOURCE)
                        {
                            for (com.gooagoo.entity.generator.marketing.Coupon coupon : selectByExample)
                            {
                                brows = new ArrayList<Integer>(0);
                                collect = new ArrayList<Integer>(0);
                                exchange = new ArrayList<Integer>(0);
                                share = new ArrayList<Integer>(0);
                                use = new ArrayList<Integer>(0);
                                List<String> dateList = new ArrayList<String>(0);
                                if ("Y".equals(tType))
                                {
                                    for (int i = 0; i < 5; i++)
                                    {
                                        Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_YEAR, new Date(), 0 - i);
                                        dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy"));
                                        int browsTimes = this.browseStatisticService.couponBrowsTimes(coupon.getCouponId(), uType, tType, tempDate, channel, s);
                                        brows.add(browsTimes);
                                        int collectTimes = this.collectStatisticService.couponCollectTimes(coupon.getCouponId(), uType, tType, tempDate, channel, s);
                                        collect.add(collectTimes);
                                        int exchangeTimes = this.exchangeStatisticService.couponExchangeTimes(coupon.getCouponId(), uType, tType, tempDate);
                                        exchange.add(exchangeTimes);
                                        int couponUseTimes = this.useStatisticService.couponUseTimes(coupon.getCouponId(), uType, tType, tempDate);
                                        use.add(couponUseTimes);
                                        int couponShareTimes = this.shareStatisticService.couponShareTimes(coupon.getCouponId(), uType, tType, tempDate);
                                        share.add(couponShareTimes);
                                    }
                                }
                                else if ("M".equals(tType))
                                {
                                    for (int i = 0; i < 12; i++)
                                    {
                                        Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_MONTH, new Date(), 0 - i);
                                        dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM"));
                                        int browsTimes = this.browseStatisticService.couponBrowsTimes(coupon.getCouponId(), uType, tType, tempDate, channel, s);
                                        brows.add(browsTimes);
                                        int collectTimes = this.collectStatisticService.couponCollectTimes(coupon.getCouponId(), uType, tType, tempDate, channel, s);
                                        collect.add(collectTimes);
                                        int exchangeTimes = this.exchangeStatisticService.couponExchangeTimes(coupon.getCouponId(), uType, tType, tempDate);
                                        exchange.add(exchangeTimes);
                                        int couponUseTimes = this.useStatisticService.couponUseTimes(coupon.getCouponId(), uType, tType, tempDate);
                                        use.add(couponUseTimes);
                                        int couponShareTimes = this.shareStatisticService.couponShareTimes(coupon.getCouponId(), uType, tType, tempDate);
                                        share.add(couponShareTimes);
                                    }
                                }
                                else if ("D".equals(tType))
                                {
                                    for (int i = 0; i < 20; i++)
                                    {
                                        Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_DAY, new Date(), 0 - i);
                                        dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM-dd"));
                                        int browsTimes = this.browseStatisticService.couponBrowsTimes(coupon.getCouponId(), uType, tType, tempDate, channel, s);
                                        brows.add(browsTimes);
                                        int collectTimes = this.collectStatisticService.couponCollectTimes(coupon.getCouponId(), uType, tType, tempDate, channel, s);
                                        collect.add(collectTimes);
                                        int exchangeTimes = this.exchangeStatisticService.couponExchangeTimes(coupon.getCouponId(), uType, tType, tempDate);
                                        exchange.add(exchangeTimes);
                                        int couponUseTimes = this.useStatisticService.couponUseTimes(coupon.getCouponId(), uType, tType, tempDate);
                                        use.add(couponUseTimes);
                                        int couponShareTimes = this.shareStatisticService.couponShareTimes(coupon.getCouponId(), uType, tType, tempDate);
                                        share.add(couponShareTimes);
                                    }
                                }
                                else if ("H".equals(tType))
                                {
                                    for (int i = 0; i < 24; i++)
                                    {
                                        Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_HOUR, new Date(), 0 - i);
                                        dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM-dd HH"));
                                        int browsTimes = this.browseStatisticService.couponBrowsTimes(coupon.getCouponId(), uType, tType, tempDate, channel, s);
                                        brows.add(browsTimes);
                                        int collectTimes = this.collectStatisticService.couponCollectTimes(coupon.getCouponId(), uType, tType, tempDate, channel, s);
                                        collect.add(collectTimes);
                                        int exchangeTimes = this.exchangeStatisticService.couponExchangeTimes(coupon.getCouponId(), uType, tType, tempDate);
                                        exchange.add(exchangeTimes);
                                        int couponUseTimes = this.useStatisticService.couponUseTimes(coupon.getCouponId(), uType, tType, tempDate);
                                        use.add(couponUseTimes);
                                        int couponShareTimes = this.shareStatisticService.couponShareTimes(coupon.getCouponId(), uType, tType, tempDate);
                                        share.add(couponShareTimes);
                                    }
                                }
                                else
                                {
                                    int browsTimes = this.browseStatisticService.couponBrowsTimes(coupon.getCouponId(), uType, null, null, channel, s);
                                    brows.add(browsTimes);
                                    int collectTimes = this.collectStatisticService.couponCollectTimes(coupon.getCouponId(), uType, null, null, channel, s);
                                    collect.add(collectTimes);
                                    int exchangeTimes = this.exchangeStatisticService.couponExchangeTimes(coupon.getCouponId(), uType, null, null);
                                    exchange.add(exchangeTimes);
                                    int couponUseTimes = this.useStatisticService.couponUseTimes(coupon.getCouponId(), uType, null, null);
                                    use.add(couponUseTimes);
                                    int couponShareTimes = this.shareStatisticService.couponShareTimes(coupon.getCouponId(), uType, null, null);
                                    share.add(couponShareTimes);
                                }

                                Map<String, List<?>> dataMap = new HashMap<String, List<?>>();
                                dataMap.put("浏览", brows);
                                dataMap.put("收藏", collect);
                                dataMap.put("兑换", exchange);
                                dataMap.put("使用", use);
                                dataMap.put("分享", share);
                                LineChartVo chartVo = new LineChartVo();
                                String chartStr = chartVo.create("优惠凭证统计", "人次", "次", dateList, dataMap);
                                //String fileName = FileUtils.getFileName(null, coupon.getCouponId(), tType, s, null);
                                String fileName = FileUtils.getfileName(coupon.getCouponId(), tType, uType, channel, s);
                                FileUtils.createAndWriteFile(BatchConsants.COUPON, chartStr, fileName);
                            }
                        }
                    }
                }
            }
            index++;
            if (selectByExample.size() < pageSize)
            {
                break;
            }
        }
    }
}
