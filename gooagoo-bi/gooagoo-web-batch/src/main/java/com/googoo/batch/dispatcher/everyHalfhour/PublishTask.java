package com.googoo.batch.dispatcher.everyHalfhour;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.gooagoo.api.business.core.marketing.rule.RuleInfoCoreService;
import com.gooagoo.api.business.core.system.SystemBusinessCoreService;
import com.gooagoo.api.generator.query.marketing.RuleInfoGeneratorQueryService;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.RuleInfoExample;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.transferBox.Engine;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.googoo.batch.constants.BatchTimeCnstants;

@Engine(BatchTimeCnstants.everyHalfhour)
public class PublishTask implements Tyre
{
    private final RuleInfoGeneratorQueryService ruleInfoQueryService = SpringBeanUtils.getBean(RuleInfoGeneratorQueryService.class);

    public static List<String> queue = new ArrayList<String>(); //任务队列

    public static synchronized boolean addQueue(String id)
    {
        if (!queue.contains(id))
        {
            queue.add(id);
            return true;
        }
        else
        {
            return false;
        }
    }

    private void removePublishEd()
    {
        for (String ruleId : queue)
        {
            RuleInfo ruleInfo = this.ruleInfoQueryService.selectByPrimaryKey(ruleId);
            if ("P".equals(ruleInfo.getPublishStatus()))
            {
                queue.remove(ruleId);
            }
        }
    }

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 PublishTask");

        this.removePublishEd();

        SystemBusinessCoreService service = SpringBeanUtils.getBean(SystemBusinessCoreService.class);
        Date sysTime = service.getCoreSysCurrentTime();
        GooagooLog.debug("数据库服务器时间:" + TimeUtils.convertDateToString(sysTime, TimeUtils.FORMAT1));
        Timer timer = new Timer();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, 1);//加时
        Date after = cal.getTime();

        RuleInfoExample ruleInfoExample = new RuleInfoExample();
        ruleInfoExample.createCriteria().andIsPublishImmediatelyEqualTo("N").andExpectPublishTimeBetween(new Date(), after).andIsDelEqualTo("N");
        List<RuleInfo> ruleInfos = this.ruleInfoQueryService.selectByExample(ruleInfoExample);
        GooagooLog.debug("RuleInfo查出 " + ruleInfos.size() + "条数据");
        for (RuleInfo rule : ruleInfos)
        {
            PublishJob publishJob = new PublishJob(rule);
            if (addQueue(rule.getRuleId()))
            {

                timer.schedule(publishJob, rule.getExpectPublishTime());
            }
        }
    }
}

class PublishJob extends TimerTask
{

    private final RuleInfo ruleInfo;

    public PublishJob(RuleInfo ruleInfo)
    {
        this.ruleInfo = ruleInfo;
    }

    @Override
    public void run()
    {
        try
        {
            GooagooLog.debug("发布，规则编号：" + ruleInfo.getRuleId());
            RuleInfoCoreService ruleInfoCoreService = SpringBeanUtils.getBean(RuleInfoCoreService.class);
            boolean result = ruleInfoCoreService.publishRuleInfo(this.ruleInfo);
            System.out.println("发布结果" + result);
        }
        catch (Exception e)
        {
            GooagooLog.error("竞拍跑批", e);
        }
    }
}
