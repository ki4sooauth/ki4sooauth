package com.googoo.batch.dispatcher.makefile;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gooagoo.api.business.query.statistics.BrowseStatisticQueryService;
import com.gooagoo.api.business.query.statistics.BuyStatisticQueryService;
import com.gooagoo.api.business.query.statistics.CollectStatisticQueryService;
import com.gooagoo.api.business.query.statistics.CommentsStatisticQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBrandGeneratorQueryService;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.generator.goods.GoodsBrand;
import com.gooagoo.entity.generator.goods.GoodsBrandExample;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.vo.hightChartVo.chartVo.LineChartVo;
import com.googoo.batch.constants.BatchConsants;
import com.googoo.batch.utils.FileUtils;

//@Engine(BatchTimeCnstants.onMidnight)
public class Brand implements Tyre
{

    private final BrowseStatisticQueryService browseStatisticService = SpringBeanUtils.getBean(BrowseStatisticQueryService.class);
    private final CollectStatisticQueryService collectStatisticService = SpringBeanUtils.getBean(CollectStatisticQueryService.class);
    private final BuyStatisticQueryService buyStatisticService = SpringBeanUtils.getBean(BuyStatisticQueryService.class);
    private final CommentsStatisticQueryService commentsStatisticService = SpringBeanUtils.getBean(CommentsStatisticQueryService.class);
    private final GoodsBrandGeneratorQueryService goodsBrandGeneratorQueryService = SpringBeanUtils.getBean(GoodsBrandGeneratorQueryService.class);

    private static final String[] SOURCE = { "M", "W", "*" };
    private static final String[] USER_TYPE = { "A", "M", "N" };
    private static final String[] CHANNEL = { "C", "N", "M", "E", "P", "B", "*" };
    private static final String[] DATETYPE = { "Y", "M", "D", "H", "*" };

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 Brand");
        this.makeBrandFile();
    }

    private void makeBrandFile()
    {
        List<Integer> brows = null;
        List<Integer> collect = null;
        List<Integer> consume = null;
        List<Integer> comments = null;
        int index = 0, pageSize = 500;
        while (true)
        {
            GoodsBrandExample goodsBrandExample = new GoodsBrandExample();
            goodsBrandExample.setPage(index, pageSize);
            List<GoodsBrand> selectByExample = this.goodsBrandGeneratorQueryService.selectByExample(goodsBrandExample);
            for (String uType : USER_TYPE)
            {
                for (String tType : DATETYPE)
                {
                    for (String channel : CHANNEL)
                    {
                        for (String s : SOURCE)
                        {
                            for (GoodsBrand brand : selectByExample)
                            {
                                brows = new ArrayList<Integer>(0);
                                collect = new ArrayList<Integer>(0);
                                consume = new ArrayList<Integer>(0);
                                comments = new ArrayList<Integer>(0);
                                List<String> dateList = new ArrayList<String>(0);
                                if ("Y".equals(tType))
                                {
                                    for (int i = 0; i < 5; i++)
                                    {
                                        Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_YEAR, new Date(), 0 - i);
                                        dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy"));
                                        int browsTimes = this.browseStatisticService.brandBrowsTimes(brand.getShopId(), brand.getBrandId(), tType, uType, channel, tempDate, s);
                                        brows.add(browsTimes);
                                        int collectTimes = this.collectStatisticService.brandCollectTimes(brand.getShopId(), brand.getBrandId(), tType, uType, channel, s, tempDate);
                                        collect.add(collectTimes);
                                        int buyTimes = this.buyStatisticService.brandBuyTimes(brand.getShopId(), brand.getBrandId(), tType, uType, tempDate);
                                        consume.add(buyTimes);
                                        int commentsTimes = this.commentsStatisticService.brandCommentTimes(brand.getShopId(), brand.getBrandId(), tType, uType, tempDate, s);
                                        comments.add(commentsTimes);
                                    }
                                }
                                else if ("M".equals(tType))
                                {
                                    for (int i = 0; i < 12; i++)
                                    {
                                        Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_MONTH, new Date(), 0 - i);
                                        dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM"));
                                        int browsTimes = this.browseStatisticService.brandBrowsTimes(brand.getShopId(), brand.getBrandId(), tType, uType, channel, tempDate, s);
                                        brows.add(browsTimes);
                                        int collectTimes = this.collectStatisticService.brandCollectTimes(brand.getShopId(), brand.getBrandId(), tType, uType, channel, s, tempDate);
                                        collect.add(collectTimes);
                                        int buyTimes = this.buyStatisticService.brandBuyTimes(brand.getShopId(), brand.getBrandId(), tType, uType, tempDate);
                                        consume.add(buyTimes);
                                        int commentsTimes = this.commentsStatisticService.brandCommentTimes(brand.getShopId(), brand.getBrandId(), tType, uType, tempDate, s);
                                        comments.add(commentsTimes);
                                    }
                                }
                                else if ("D".equals(tType))
                                {
                                    for (int i = 0; i < 20; i++)
                                    {
                                        Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_DAY, new Date(), 0 - i);
                                        dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM-dd"));
                                        int browsTimes = this.browseStatisticService.brandBrowsTimes(brand.getShopId(), brand.getBrandId(), tType, uType, channel, tempDate, s);
                                        brows.add(browsTimes);
                                        int collectTimes = this.collectStatisticService.brandCollectTimes(brand.getShopId(), brand.getBrandId(), tType, uType, channel, s, tempDate);
                                        collect.add(collectTimes);
                                        int buyTimes = this.buyStatisticService.brandBuyTimes(brand.getShopId(), brand.getBrandId(), tType, uType, tempDate);
                                        consume.add(buyTimes);
                                        int commentsTimes = this.commentsStatisticService.brandCommentTimes(brand.getShopId(), brand.getBrandId(), tType, uType, tempDate, s);
                                        comments.add(commentsTimes);
                                    }
                                }
                                else if ("H".equals(tType))
                                {
                                    for (int i = 0; i < 24; i++)
                                    {
                                        Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_HOUR, new Date(), 0 - i);
                                        dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM-dd HH"));
                                        int browsTimes = this.browseStatisticService.brandBrowsTimes(brand.getShopId(), brand.getBrandId(), tType, uType, channel, tempDate, s);
                                        brows.add(browsTimes);
                                        int collectTimes = this.collectStatisticService.brandCollectTimes(brand.getShopId(), brand.getBrandId(), tType, uType, channel, s, tempDate);
                                        collect.add(collectTimes);
                                        int buyTimes = this.buyStatisticService.brandBuyTimes(brand.getShopId(), brand.getBrandId(), tType, uType, tempDate);
                                        consume.add(buyTimes);
                                        int commentsTimes = this.commentsStatisticService.brandCommentTimes(brand.getShopId(), brand.getBrandId(), tType, uType, tempDate, s);
                                        comments.add(commentsTimes);
                                    }
                                }
                                else
                                {
                                    int browsTimes = this.browseStatisticService.brandBrowsTimes(brand.getShopId(), brand.getBrandId(), null, uType, channel, null, s);
                                    brows.add(browsTimes);
                                    int collectTimes = this.collectStatisticService.brandCollectTimes(brand.getShopId(), brand.getBrandId(), null, uType, channel, s, null);
                                    collect.add(collectTimes);
                                    int buyTimes = this.buyStatisticService.brandBuyTimes(brand.getShopId(), brand.getBrandId(), null, uType, null);
                                    consume.add(buyTimes);
                                    int commentsTimes = this.commentsStatisticService.brandCommentTimes(brand.getShopId(), brand.getBrandId(), null, uType, null, s);
                                    comments.add(commentsTimes);
                                }

                                Map<String, List<?>> dataMap = new HashMap<String, List<?>>();
                                dataMap.put("浏览", brows);
                                dataMap.put("收藏", collect);
                                dataMap.put("消费", consume);
                                dataMap.put("评论", comments);
                                LineChartVo chartVo = new LineChartVo();
                                String chartStr = chartVo.create("品牌统计", "人次", "次", dateList, dataMap);
                                //String fileName = FileUtils.getFileName(null, brand.getBrandId(), tType, s, null);
                                String fileName = FileUtils.getfileName(brand.getBrandId(), tType, uType, channel, s);
                                FileUtils.createAndWriteFile(BatchConsants.BRAND, chartStr, fileName);
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
