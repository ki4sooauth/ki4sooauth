package com.googoo.batch.dispatcher.makefile;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.gooagoo.api.business.query.statistics.BrowseStatisticQueryService;
import com.gooagoo.api.business.query.statistics.CollectStatisticQueryService;
import com.gooagoo.api.generator.query.marketing.CryoutInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingActivityGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingEventGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.NoticeInfoGeneratorQueryService;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.generator.marketing.CryoutInfo;
import com.gooagoo.entity.generator.marketing.CryoutInfoExample;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.marketing.MarketingActivityExample;
import com.gooagoo.entity.generator.marketing.MarketingActivityExample.Criteria;
import com.gooagoo.entity.generator.marketing.MarketingEvent;
import com.gooagoo.entity.generator.marketing.MarketingEventExample;
import com.gooagoo.entity.generator.marketing.NoticeInfo;
import com.gooagoo.entity.generator.marketing.NoticeInfoExample;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.vo.hightChartVo.chartVo.LineChartVo;
import com.googoo.batch.constants.BatchConsants;
import com.googoo.batch.utils.DateUtils;
import com.googoo.batch.utils.FileUtils;

//@Engine(BatchTimeCnstants.onMidnight)
public class Activity implements Tyre
{

    private final MarketingActivityGeneratorQueryService marketingActivityGeneratorQueryService = SpringBeanUtils.getBean(MarketingActivityGeneratorQueryService.class);
    private final BrowseStatisticQueryService browseStatisticService = SpringBeanUtils.getBean(BrowseStatisticQueryService.class);
    private final CollectStatisticQueryService collectStatisticService = SpringBeanUtils.getBean(CollectStatisticQueryService.class);
    private final NoticeInfoGeneratorQueryService noticeInfoGeneratorQueryService = SpringBeanUtils.getBean(NoticeInfoGeneratorQueryService.class);
    private final CryoutInfoGeneratorQueryService cryoutInfoGeneratorQueryService = SpringBeanUtils.getBean(CryoutInfoGeneratorQueryService.class);
    private final MarketingEventGeneratorQueryService marketingEventGeneratorQueryService = SpringBeanUtils.getBean(MarketingEventGeneratorQueryService.class);

    private List<MarketingActivity> activities = null;
    private static final String[] USER_TYPE = { "A", "M", "N" };
    private static final String[] CHANNEL = { "C", "N", "M", "E", "P", "B", "*" };
    private static final String[] SOURCE = { "M", "W", "*" };
    private static final String[] DATETYPE = { "Y", "M", "D", "H", "*" };

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 Activity");
        this.makeActivityFile();
        this.makeActivityContentFile();
    }

    /**
     * 生成活动文件
     */
    private void makeActivityFile()
    {
        if (CollectionUtils.isEmpty(this.activities))
        {
            this.activities = this.findActivity();
        }
        List<Integer> brows = null;
        List<Integer> collect = null;
        for (String uType : USER_TYPE)
        {
            for (String channel : CHANNEL)
            {
                for (String source : SOURCE)
                {
                    for (String dateType : DATETYPE)
                    {
                        for (MarketingActivity marketingActivity : this.activities)
                        {
                            brows = new ArrayList<Integer>(0);
                            collect = new ArrayList<Integer>(0);
                            List<String> dateList = new ArrayList<String>(0);
                            if ("Y".equals(dateType))
                            {
                                for (int i = 0; i < 5; i++)
                                {
                                    Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_YEAR, new Date(), 0 - i);
                                    dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy"));
                                    int browsTimes = this.browseStatisticService.activityBrowsTimes(marketingActivity.getActivityId(), uType, dateType, tempDate, channel, source);
                                    brows.add(browsTimes);
                                    //int activityCollectTimes = this.collectStatisticService.activityCollectTimes(marketingActivity.getActivityId(), uType, dateType, TimeUtils.dateAdd(TimeUtils.DATATYPE_DAY, new Date(), i - BatchConsants.DAYS), channel, source);
                                    //collect.add(activityCollectTimes);
                                }
                            }
                            else if ("M".equals(dateType))
                            {
                                for (int i = 0; i < 12; i++)
                                {
                                    Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_MONTH, new Date(), 0 - i);
                                    dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM"));
                                    int browsTimes = this.browseStatisticService.activityBrowsTimes(marketingActivity.getActivityId(), uType, dateType, tempDate, channel, source);
                                    brows.add(browsTimes);
                                    //int activityCollectTimes = this.collectStatisticService.activityCollectTimes(marketingActivity.getActivityId(), uType, dateType, TimeUtils.dateAdd(TimeUtils.DATATYPE_DAY, new Date(), i - BatchConsants.DAYS), channel, source);
                                    //collect.add(activityCollectTimes);
                                }
                            }
                            else if ("D".equals(dateType))
                            {
                                for (int i = 0; i < 20; i++)
                                {
                                    Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_MONTH, new Date(), 0 - i);
                                    dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM-dd"));
                                    int browsTimes = this.browseStatisticService.activityBrowsTimes(marketingActivity.getActivityId(), uType, dateType, tempDate, channel, source);
                                    brows.add(browsTimes);
                                    //int activityCollectTimes = this.collectStatisticService.activityCollectTimes(marketingActivity.getActivityId(), uType, dateType, TimeUtils.dateAdd(TimeUtils.DATATYPE_DAY, new Date(), i - BatchConsants.DAYS), channel, source);
                                    //collect.add(activityCollectTimes);
                                }

                            }
                            else if ("H".equals(dateType))
                            {
                                for (int i = 0; i < 24; i++)
                                {
                                    Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_MONTH, new Date(), 0 - i);
                                    dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM-dd HH"));
                                    int browsTimes = this.browseStatisticService.activityBrowsTimes(marketingActivity.getActivityId(), uType, dateType, tempDate, channel, source);
                                    brows.add(browsTimes);
                                    //int activityCollectTimes = this.collectStatisticService.activityCollectTimes(marketingActivity.getActivityId(), uType, dateType, TimeUtils.dateAdd(TimeUtils.DATATYPE_DAY, new Date(), i - BatchConsants.DAYS), channel, source);
                                    //collect.add(activityCollectTimes);
                                }
                            }
                            else
                            {
                                //历史统计
                                int browsTimes = this.browseStatisticService.activityBrowsTimes(marketingActivity.getActivityId(), uType, null, null, channel, source);
                                brows.add(browsTimes);
                                int activityCollectTimes = this.collectStatisticService.activityCollectTimes(marketingActivity.getActivityId(), uType, null, null, channel, source);
                                collect.add(activityCollectTimes);
                            }

                            Map<String, List<?>> dataMap = new HashMap<String, List<?>>();
                            dataMap.put("浏览", brows);
                            dataMap.put("收藏", collect);
                            LineChartVo chartVo = new LineChartVo();
                            String chartStr = chartVo.create("活动统计", "人数", "人", dateList, dataMap);
                            //String fileName = FileUtils.getFileName(null, marketingActivity.getActivityId(), tType, source, null);
                            String fileName = FileUtils.getfileName(marketingActivity.getActivityId(), dateType, uType, channel, source);
                            FileUtils.createAndWriteFile(BatchConsants.ACTIVITY, chartStr, fileName);
                        }
                    }
                }
            }
        }
    }

    /**
     * 生成活动内容统计文件
     */
    private void makeActivityContentFile()
    {
        if (CollectionUtils.isEmpty(this.activities))
        {
            this.activities = this.findActivity();
        }
        this.makeNoticeFile();
        this.makeCryOutFile();
        this.makeEventFile();
        //this.makePhoneServiceFile();
    }

    /**
     * 生成通知文件
     */
    public void makeNoticeFile()
    {
        List<Integer> brows = null;
        for (String uType : USER_TYPE)
        {
            for (String dateType : DATETYPE)
            {
                for (String source : SOURCE)
                {
                    for (MarketingActivity marketingActivity : this.activities)
                    {
                        NoticeInfoExample noticeInfoExample = new NoticeInfoExample();
                        com.gooagoo.entity.generator.marketing.NoticeInfoExample.Criteria createCriteria = noticeInfoExample.createCriteria();
                        createCriteria.andActivityIdEqualTo(marketingActivity.getActivityId());
                        createCriteria.andIsDelEqualTo("N");
                        createCriteria.andPublishStatusEqualTo("P");
                        List<NoticeInfo> selectByExample = this.noticeInfoGeneratorQueryService.selectByExample(noticeInfoExample);
                        for (NoticeInfo noticeInfo : selectByExample)
                        {
                            brows = new ArrayList<Integer>(0);
                            List<String> dateList = new ArrayList<String>(0);
                            if ("Y".equals(dateType))
                            {
                                for (int i = 0; i < 5; i++)
                                {
                                    Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_YEAR, new Date(), 0 - i);
                                    dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy"));
                                    int browsTimes = this.browseStatisticService.noticeBrowsTimes(noticeInfo.getNoticeInfoId(), dateType, uType, source, tempDate);
                                    brows.add(browsTimes);
                                }
                            }
                            else if ("M".equals(dateType))
                            {
                                for (int i = 0; i < 12; i++)
                                {
                                    Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_MONTH, new Date(), 0 - i);
                                    dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM"));
                                    int browsTimes = this.browseStatisticService.noticeBrowsTimes(noticeInfo.getNoticeInfoId(), dateType, uType, source, tempDate);
                                    brows.add(browsTimes);
                                }
                            }
                            else if ("D".equals(dateType))
                            {
                                for (int i = 0; i < 20; i++)
                                {
                                    Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_DAY, new Date(), 0 - i);
                                    dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM-dd"));
                                    int browsTimes = this.browseStatisticService.noticeBrowsTimes(noticeInfo.getNoticeInfoId(), dateType, uType, source, tempDate);
                                    brows.add(browsTimes);
                                }
                            }
                            else if ("H".equals(dateType))
                            {
                                for (int i = 0; i < 24; i++)
                                {
                                    Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_HOUR, new Date(), 0 - i);
                                    dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM-dd HH"));
                                    int browsTimes = this.browseStatisticService.noticeBrowsTimes(noticeInfo.getNoticeInfoId(), dateType, uType, source, tempDate);
                                    brows.add(browsTimes);
                                }
                            }
                            else
                            {
                                int browsTimes = this.browseStatisticService.noticeBrowsTimes(noticeInfo.getNoticeInfoId(), null, uType, source, null);
                                brows.add(browsTimes);
                            }

                            Map<String, List<?>> dataMap = new HashMap<String, List<?>>();
                            dataMap.put("浏览", brows);
                            LineChartVo chartVo = new LineChartVo();
                            String chartStr = chartVo.create("通知内容", "人数", "人", dateList, dataMap);
                            //String fileName = FileUtils.getFileName(null, noticeInfo.getNoticeInfoId(), tType, source, "2");
                            String fileName = FileUtils.getfileName(noticeInfo.getNoticeInfoId(), dateType, uType, null, source);
                            FileUtils.createAndWriteFile(BatchConsants.ACTIVITY, chartStr, fileName);
                        }
                    }
                }
            }
        }
    }

    /**
     * 生成吆喝文件
     */
    public void makeCryOutFile()
    {
        List<Integer> brows = null;
        for (String uType : USER_TYPE)
        {
            for (String dateType : DATETYPE)
            {
                for (String source : SOURCE)
                {
                    for (MarketingActivity marketingActivity : this.activities)
                    {
                        CryoutInfoExample cryoutInfoExample = new CryoutInfoExample();
                        com.gooagoo.entity.generator.marketing.CryoutInfoExample.Criteria createCriteria = cryoutInfoExample.createCriteria();
                        createCriteria.andActivityIdEqualTo(marketingActivity.getActivityId());
                        createCriteria.andIsDelEqualTo("N");
                        createCriteria.andPublishStatusEqualTo("P");
                        List<CryoutInfo> selectByExample = this.cryoutInfoGeneratorQueryService.selectByExample(cryoutInfoExample);
                        for (CryoutInfo cryoutInfo : selectByExample)
                        {
                            brows = new ArrayList<Integer>(0);
                            List<String> dateList = new ArrayList<String>(0);
                            if ("Y".equals(dateType))
                            {
                                for (int i = 0; i < 5; i++)
                                {
                                    Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_YEAR, new Date(), 0 - i);
                                    dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy"));
                                    int browsTimes = this.browseStatisticService.cryoutBrowsTimes(cryoutInfo.getCryoutInfoId(), dateType, uType, source, tempDate);
                                    brows.add(browsTimes);
                                }
                            }
                            else if ("M".equals(dateType))
                            {
                                for (int i = 0; i < 12; i++)
                                {
                                    Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_MONTH, new Date(), 0 - i);
                                    dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM"));
                                    int browsTimes = this.browseStatisticService.cryoutBrowsTimes(cryoutInfo.getCryoutInfoId(), dateType, uType, source, tempDate);
                                    brows.add(browsTimes);
                                }
                            }
                            else if ("D".equals(dateType))
                            {
                                for (int i = 0; i < 20; i++)
                                {
                                    Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_DAY, new Date(), 0 - i);
                                    dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM-dd"));
                                    int browsTimes = this.browseStatisticService.cryoutBrowsTimes(cryoutInfo.getCryoutInfoId(), dateType, uType, source, tempDate);
                                    brows.add(browsTimes);
                                }
                            }
                            else if ("H".equals(dateType))
                            {
                                for (int i = 0; i < 24; i++)
                                {
                                    Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_HOUR, new Date(), 0 - i);
                                    dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM-dd HH"));
                                    int browsTimes = this.browseStatisticService.cryoutBrowsTimes(cryoutInfo.getCryoutInfoId(), dateType, uType, source, tempDate);
                                    brows.add(browsTimes);
                                }
                            }
                            else
                            {
                                int browsTimes = this.browseStatisticService.cryoutBrowsTimes(cryoutInfo.getCryoutInfoId(), null, uType, source, null);
                                brows.add(browsTimes);
                            }

                            Map<String, List<?>> dataMap = new HashMap<String, List<?>>();
                            dataMap.put("浏览", brows);
                            LineChartVo chartVo = new LineChartVo();
                            String chartStr = chartVo.create("吆喝内容", "人数", "人", dateList, dataMap);
                            //String fileName = FileUtils.getFileName(null, cryoutInfo.getCryoutInfoId(), tType, source, "1");
                            String fileName = FileUtils.getfileName(cryoutInfo.getCryoutInfoId(), dateType, uType, null, source);
                            FileUtils.createAndWriteFile(BatchConsants.ACTIVITY, chartStr, fileName);
                        }
                    }
                }
            }
        }
    }

    /**
     * 生成购好奇文件
     */
    public void makeEventFile()
    {
        List<Integer> brows = null;
        for (String uType : USER_TYPE)
        {
            for (String dateType : DATETYPE)
            {
                for (MarketingActivity marketingActivity : this.activities)
                {
                    MarketingEventExample marketingEventExample = new MarketingEventExample();
                    com.gooagoo.entity.generator.marketing.MarketingEventExample.Criteria createCriteria = marketingEventExample.createCriteria();
                    createCriteria.andActivityIdEqualTo(marketingActivity.getActivityId());
                    createCriteria.andIsDelEqualTo("N");
                    createCriteria.andPublishStatusEqualTo("P");
                    createCriteria.andChannelRootEqualTo("5");
                    List<MarketingEvent> selectByExample = this.marketingEventGeneratorQueryService.selectByExample(marketingEventExample);
                    for (MarketingEvent marketingEvent : selectByExample)
                    {
                        brows = new ArrayList<Integer>(0);
                        List<String> dateList = new ArrayList<String>(0);
                        if ("Y".equals(dateType))
                        {
                            for (int i = 0; i < 5; i++)
                            {
                                Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_YEAR, new Date(), 0 - i);
                                dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy"));
                                int browsTimes = this.browseStatisticService.purchaseAndcuriosityBrowsTimes(marketingEvent.getEventId(), dateType, uType, tempDate);
                                brows.add(browsTimes);
                            }
                        }
                        else if ("M".equals(dateType))
                        {
                            for (int i = 0; i < 12; i++)
                            {
                                Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_MONTH, new Date(), 0 - i);
                                dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM"));
                                int browsTimes = this.browseStatisticService.purchaseAndcuriosityBrowsTimes(marketingEvent.getEventId(), dateType, uType, tempDate);
                                brows.add(browsTimes);
                            }
                        }
                        else if ("D".equals(dateType))
                        {
                            for (int i = 0; i < 20; i++)
                            {
                                Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_DAY, new Date(), 0 - i);
                                dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM-dd"));
                                int browsTimes = this.browseStatisticService.purchaseAndcuriosityBrowsTimes(marketingEvent.getEventId(), dateType, uType, tempDate);
                                brows.add(browsTimes);
                            }
                        }
                        else if ("H".equals(dateType))
                        {
                            for (int i = 0; i < 24; i++)
                            {
                                Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_HOUR, new Date(), 0 - i);
                                dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM-dd HH"));
                                int browsTimes = this.browseStatisticService.purchaseAndcuriosityBrowsTimes(marketingEvent.getEventId(), dateType, uType, tempDate);
                                brows.add(browsTimes);
                            }
                        }
                        else
                        {
                            int browsTimes = this.browseStatisticService.purchaseAndcuriosityBrowsTimes(marketingEvent.getEventId(), null, uType, null);
                            brows.add(browsTimes);
                        }

                        Map<String, List<?>> dataMap = new HashMap<String, List<?>>();
                        dataMap.put("浏览", brows);
                        LineChartVo chartVo = new LineChartVo();
                        String chartStr = chartVo.create("购好奇内容", "人数", "人", dateList, dataMap);
                        //String fileName = FileUtils.getFileName(null, marketingEvent.getEventId(), tType, "M", "5");
                        String fileName = FileUtils.getfileName(marketingEvent.getEventId(), dateType, uType, null, null);
                        FileUtils.createAndWriteFile(BatchConsants.ACTIVITY, chartStr, fileName);
                    }
                }
            }
        }
    }

    /**
     * 手机服务
     */
    //    public void makePhoneServiceFile()
    //    {
    //        List<Integer> brows = null;
    //        for (String uType : USER_TYPE)
    //        {
    //            for (String tType : TIME_TYPE)
    //            {
    //                for (MarketingActivity marketingActivity : this.activities)
    //                {
    //                    MarketingEventExample marketingEventExample = new MarketingEventExample();
    //                    com.gooagoo.entity.generator.marketing.MarketingEventExample.Criteria createCriteria = marketingEventExample.createCriteria();
    //                    createCriteria.andActivityIdEqualTo(marketingActivity.getActivityId());
    //                    createCriteria.andIsDelEqualTo("N");
    //                    createCriteria.andPublishStatusEqualTo("P");
    //                    createCriteria.andChannelRootEqualTo("6");
    //                    List<MarketingEvent> selectByExample = this.marketingEventGeneratorQueryService.selectByExample(marketingEventExample);
    //                    for (MarketingEvent marketingEvent : selectByExample)
    //                    {
    //                        brows = new ArrayList<Integer>(0);
    //                        List<String> dateList = new ArrayList<String>(0);
    //                        for (int i = 1; i <= BatchConsants.DAYS; i++)
    //                        {
    //                            Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_DAY, new Date(), i - BatchConsants.DAYS);
    //                            dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM-dd"));
    //                            int browsTimes = this.browseStatisticService.purchaseAndcuriosityBrowsTimes(marketingEvent.getEventId(), tType, uType, tempDate);
    //                            brows.add(browsTimes);
    //                        }
    //                        Map<String, List<?>> dataMap = new HashMap<String, List<?>>();
    //                        dataMap.put("浏览", brows);
    //                        LineChartVo chartVo = new LineChartVo();
    //                        String chartStr = chartVo.create("活动内容", "人数", "人", dateList, dataMap);
    //                        String fileName = FileUtils.getFileName(null, marketingEvent.getEventId(), tType, "M", "6");
    //                        FileUtils.createAndWriteFile("activity", chartStr, fileName);
    //                    }
    //                }
    //            }
    //        }
    //    }

    /**
     * 获取活动列表
     * 
     * @return
     */
    private List<MarketingActivity> findActivity()
    {
        List<MarketingActivity> selectByExample = null;
        try
        {
            MarketingActivityExample marketingActivityExample = new MarketingActivityExample();
            Criteria createCriteria = marketingActivityExample.createCriteria();
            createCriteria.andIsDelEqualTo("N");
            createCriteria.andPublishStatusEqualTo("P");
            createCriteria.andStartTimeLessThanOrEqualTo(DateUtils.getDaysBeforeAndAfter24HourTime(-1, new Date()));
            createCriteria.andEndTimeGreaterThan(DateUtils.getDaysBeforeAndAfterZeroTime(-20, new Date()));
            selectByExample = this.marketingActivityGeneratorQueryService.selectByExample(marketingActivityExample);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return selectByExample;
    }
}
