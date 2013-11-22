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
import com.gooagoo.api.generator.query.goods.GoodsCategoryGeneratorQueryService;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.generator.goods.GoodsCategory;
import com.gooagoo.entity.generator.goods.GoodsCategoryExample;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.vo.hightChartVo.chartVo.LineChartVo;
import com.googoo.batch.constants.BatchConsants;
import com.googoo.batch.utils.FileUtils;

//@Engine(BatchTimeCnstants.onMidnight)
public class Category implements Tyre
{

    private final BrowseStatisticQueryService browseStatisticService = SpringBeanUtils.getBean(BrowseStatisticQueryService.class);
    private final CollectStatisticQueryService collectStatisticService = SpringBeanUtils.getBean(CollectStatisticQueryService.class);
    private final BuyStatisticQueryService buyStatisticService = SpringBeanUtils.getBean(BuyStatisticQueryService.class);
    private final CommentsStatisticQueryService commentsStatisticService = SpringBeanUtils.getBean(CommentsStatisticQueryService.class);
    private final GoodsCategoryGeneratorQueryService goodsCategoryGeneratorQueryService = SpringBeanUtils.getBean(GoodsCategoryGeneratorQueryService.class);

    private static final String[] SOURCE = { "M", "W", "*" };
    private static final String[] USER_TYPE = { "A", "M", "N" };
    private static final String[] CHANNEL = { "C", "N", "M", "E", "P", "B", "*" };
    private static final String[] DATETYPE = { "Y", "M", "D", "H", "*" };

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 Category");
        this.makeCategoryFile();
    }

    private void makeCategoryFile()
    {
        List<Integer> brows = null;
        List<Integer> collect = null;
        List<Integer> consume = null;
        List<Integer> comments = null;
        int index = 0, pageSize = 500;
        while (true)
        {
            GoodsCategoryExample goodsCategoryExample = new GoodsCategoryExample();
            goodsCategoryExample.setPage(index, pageSize);
            List<GoodsCategory> selectByExample = this.goodsCategoryGeneratorQueryService.selectByExample(goodsCategoryExample);
            for (String uType : USER_TYPE)
            {
                for (String tType : DATETYPE)
                {
                    for (String channel : CHANNEL)
                    {
                        for (String s : SOURCE)
                        {
                            for (GoodsCategory category : selectByExample)
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
                                        int browsTimes = this.browseStatisticService.categoryBrowsTimes(category.getShopEntityId(), category.getCategoryId(), tType, uType, channel, tempDate, s);
                                        brows.add(browsTimes);
                                        int collectTimes = this.collectStatisticService.categoryCollectTimes(category.getShopEntityId(), category.getCategoryId(), tType, uType, channel, s, tempDate);
                                        collect.add(collectTimes);
                                        int buyTimes = this.buyStatisticService.categoryBuyTimes(category.getShopEntityId(), category.getCategoryId(), tType, uType, tempDate);
                                        consume.add(buyTimes);
                                        int commentsTimes = this.commentsStatisticService.categoryCommentTimes(category.getShopEntityId(), category.getCategoryId(), tType, uType, tempDate, s);
                                        comments.add(commentsTimes);
                                    }
                                }
                                else if ("M".equals(tType))
                                {
                                    for (int i = 0; i < 12; i++)
                                    {
                                        Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_MONTH, new Date(), 0 - i);
                                        dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM"));
                                        int browsTimes = this.browseStatisticService.categoryBrowsTimes(category.getShopEntityId(), category.getCategoryId(), tType, uType, channel, tempDate, s);
                                        brows.add(browsTimes);
                                        int collectTimes = this.collectStatisticService.categoryCollectTimes(category.getShopEntityId(), category.getCategoryId(), tType, uType, channel, s, tempDate);
                                        collect.add(collectTimes);
                                        int buyTimes = this.buyStatisticService.categoryBuyTimes(category.getShopEntityId(), category.getCategoryId(), tType, uType, tempDate);
                                        consume.add(buyTimes);
                                        int commentsTimes = this.commentsStatisticService.categoryCommentTimes(category.getShopEntityId(), category.getCategoryId(), tType, uType, tempDate, s);
                                        comments.add(commentsTimes);
                                    }
                                }
                                else if ("D".equals(tType))
                                {
                                    for (int i = 0; i < 20; i++)
                                    {
                                        Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_DAY, new Date(), 0 - i);
                                        dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM-dd"));
                                        int browsTimes = this.browseStatisticService.categoryBrowsTimes(category.getShopEntityId(), category.getCategoryId(), tType, uType, channel, tempDate, s);
                                        brows.add(browsTimes);
                                        int collectTimes = this.collectStatisticService.categoryCollectTimes(category.getShopEntityId(), category.getCategoryId(), tType, uType, channel, s, tempDate);
                                        collect.add(collectTimes);
                                        int buyTimes = this.buyStatisticService.categoryBuyTimes(category.getShopEntityId(), category.getCategoryId(), tType, uType, tempDate);
                                        consume.add(buyTimes);
                                        int commentsTimes = this.commentsStatisticService.categoryCommentTimes(category.getShopEntityId(), category.getCategoryId(), tType, uType, tempDate, s);
                                        comments.add(commentsTimes);
                                    }
                                }
                                else if ("H".equals(tType))
                                {
                                    for (int i = 0; i < 24; i++)
                                    {
                                        Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_HOUR, new Date(), 0 - i);
                                        dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM-dd HH"));
                                        int browsTimes = this.browseStatisticService.categoryBrowsTimes(category.getShopEntityId(), category.getCategoryId(), tType, uType, channel, tempDate, s);
                                        brows.add(browsTimes);
                                        int collectTimes = this.collectStatisticService.categoryCollectTimes(category.getShopEntityId(), category.getCategoryId(), tType, uType, channel, s, tempDate);
                                        collect.add(collectTimes);
                                        int buyTimes = this.buyStatisticService.categoryBuyTimes(category.getShopEntityId(), category.getCategoryId(), tType, uType, tempDate);
                                        consume.add(buyTimes);
                                        int commentsTimes = this.commentsStatisticService.categoryCommentTimes(category.getShopEntityId(), category.getCategoryId(), tType, uType, tempDate, s);
                                        comments.add(commentsTimes);
                                    }
                                }
                                else
                                {
                                    int browsTimes = this.browseStatisticService.categoryBrowsTimes(category.getShopEntityId(), category.getCategoryId(), null, uType, channel, null, s);
                                    brows.add(browsTimes);
                                    int collectTimes = this.collectStatisticService.categoryCollectTimes(category.getShopEntityId(), category.getCategoryId(), null, uType, channel, s, null);
                                    collect.add(collectTimes);
                                    int buyTimes = this.buyStatisticService.categoryBuyTimes(category.getShopEntityId(), category.getCategoryId(), null, uType, null);
                                    consume.add(buyTimes);
                                    int commentsTimes = this.commentsStatisticService.categoryCommentTimes(category.getShopEntityId(), category.getCategoryId(), null, uType, null, s);
                                    comments.add(commentsTimes);
                                }

                                Map<String, List<?>> dataMap = new HashMap<String, List<?>>();
                                dataMap.put("浏览", brows);
                                dataMap.put("收藏", collect);
                                dataMap.put("消费", consume);
                                dataMap.put("评论", comments);
                                LineChartVo chartVo = new LineChartVo();
                                String chartStr = chartVo.create("品类", "人次", "次", dateList, dataMap);
                                //String fileName = FileUtils.getFileName(null, category.getCategoryId(), tType, s, null);
                                String fileName = FileUtils.getfileName(category.getCategoryId(), tType, uType, channel, s);
                                FileUtils.createAndWriteFile(BatchConsants.CATEGORY, chartStr, fileName);
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
