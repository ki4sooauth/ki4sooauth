package com.gooagoo.core.business.marketing.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.marketing.activity.ActivityCoreService;
import com.gooagoo.api.generator.core.marketing.CryoutInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.MarketingActivityGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.MarketingEventGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.NoticeInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.RuleInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.ShortMessageGeneratorCoreService;
import com.gooagoo.api.protecteds.core.publish.PublishProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.marketing.CryoutInfoExample;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.marketing.MarketingEventExample;
import com.gooagoo.entity.generator.marketing.NoticeInfoExample;
import com.gooagoo.entity.generator.marketing.RuleInfoExample;
import com.gooagoo.entity.generator.marketing.ShortMessageExample;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class ActivityCoreServiceImpl implements ActivityCoreService
{
    @Autowired
    private MarketingActivityGeneratorCoreService marketingActivityGeneratorCoreService;
    @Autowired
    private RuleInfoGeneratorCoreService ruleInfoGeneratorCoreService;
    @Autowired
    private CryoutInfoGeneratorCoreService cryoutInfoGeneratorCoreService;
    @Autowired
    private NoticeInfoGeneratorCoreService noticeInfoGeneratorCoreService;
    @Autowired
    private ShortMessageGeneratorCoreService shortMessageGeneratorCoreService;
    @Autowired
    private MarketingEventGeneratorCoreService marketingEventGeneratorCoreService;
    @Autowired
    private PublishProtectedCoreService publishProtectedCoreService;

    @Override
    public boolean addActivity(MarketingActivity marketingActivity) throws Exception
    {
        marketingActivity.setIsDel("N");
        marketingActivity.setPublishStatus("W");
        boolean res = this.marketingActivityGeneratorCoreService.insertSelective(marketingActivity);
        return res;
    }

    @Override
    public boolean updateActivity(MarketingActivity marketingActivity) throws GooagooException
    {
        marketingActivity.setPublishStatus("W");
        boolean res = this.marketingActivityGeneratorCoreService.updateByPrimaryKeySelective(marketingActivity);
        return res;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean deleteActivity(String activityId) throws GooagooException
    {
        if (!StringUtils.hasText(activityId))
        {
            GooagooLog.warn("删除活动：活动Id为空，activityId=" + activityId);
            return false;
        }
        //删除活动基本信息
        boolean res = this.marketingActivityGeneratorCoreService.deleteByPrimaryKey(activityId);
        if (!res)
        {
            GooagooLog.warn("删除活动基本信息失败：id=" + activityId);
            return false;
        }
        //删除活动规则
        RuleInfoExample ruleInfoExample = new RuleInfoExample();
        ruleInfoExample.createCriteria().andIsDelEqualTo("N").andActivityIdEqualTo(activityId);
        Integer count = this.ruleInfoGeneratorCoreService.countByExample(ruleInfoExample);
        if (count > 0)
        {
            res = this.ruleInfoGeneratorCoreService.deleteByExample(ruleInfoExample);
            if (!res)
            {
                GooagooLog.warn("删除活动时删除规则信息失败：id=" + activityId + ",obj=" + new Gson().toJson(ruleInfoExample));
                throw new OperateFailException("删除活动规则失败");
            }
        }
        //删除活动内容
        //删除活动内容-吆喝
        CryoutInfoExample cryoutInfoExample = new CryoutInfoExample();
        cryoutInfoExample.createCriteria().andIsDelEqualTo("N").andActivityIdEqualTo(activityId);
        count = this.cryoutInfoGeneratorCoreService.countByExample(cryoutInfoExample);
        if (count > 0)
        {
            res = this.cryoutInfoGeneratorCoreService.deleteByExample(cryoutInfoExample);
            if (!res)
            {
                GooagooLog.warn("删除活动时删除活动内容-吆喝信息失败：id=" + activityId + ",obj=" + new Gson().toJson(cryoutInfoExample));
                throw new OperateFailException("删除活动内容失败");
            }
        }
        //删除活动内容-通知
        NoticeInfoExample noticeInfoExample = new NoticeInfoExample();
        noticeInfoExample.createCriteria().andIsDelEqualTo("N").andActivityIdEqualTo(activityId);
        count = this.noticeInfoGeneratorCoreService.countByExample(noticeInfoExample);
        if (count > 0)
        {
            res = this.noticeInfoGeneratorCoreService.deleteByExample(noticeInfoExample);
            if (!res)
            {
                GooagooLog.warn("删除活动时删除活动内容-通知信息失败：id=" + activityId + ",obj=" + new Gson().toJson(noticeInfoExample));
                throw new OperateFailException("删除活动内容失败");
            }
        }
        //删除活动内容-短信
        ShortMessageExample shortMessageExample = new ShortMessageExample();
        shortMessageExample.createCriteria().andIsDelEqualTo("N").andActivityIdEqualTo(activityId);
        count = this.shortMessageGeneratorCoreService.countByExample(shortMessageExample);
        if (count > 0)
        {
            res = this.shortMessageGeneratorCoreService.deleteByExample(shortMessageExample);
            if (!res)
            {
                GooagooLog.warn("删除活动时删除活动内容-短信信息失败：id=" + activityId + ",obj=" + new Gson().toJson(shortMessageExample));
                throw new OperateFailException("删除活动内容失败");
            }
        }
        //删除活动内容-事件
        MarketingEventExample marketingEventExample = new MarketingEventExample();
        marketingEventExample.createCriteria().andIsDelEqualTo("N").andActivityIdEqualTo(activityId);
        count = this.marketingEventGeneratorCoreService.countByExample(marketingEventExample);
        if (count > 0)
        {
            res = this.marketingEventGeneratorCoreService.deleteByExample(marketingEventExample);
            if (!res)
            {
                GooagooLog.warn("删除活动时删除活动内容-事件信息失败：id=" + activityId + ",obj=" + new Gson().toJson(marketingEventExample));
                throw new OperateFailException("删除活动内容失败");
            }
        }
        return true;
    }

    @Override
    public boolean reviewedActivity(String activityId, String status, String note) throws GooagooException
    {
        MarketingActivity activity = this.marketingActivityGeneratorCoreService.selectByPrimaryKey(activityId);
        if (activity == null)
        {
            GooagooLog.warn("审核活动：活动不存在，activityId=" + activityId);
            return false;
        }
        if (!"W".equals(activity.getPublishStatus()))
        {
            GooagooLog.warn("审核活动：活动状态不是待审核，activityId=" + activityId + ",publishStatus=" + activity.getPublishStatus());
            return false;
        }
        MarketingActivity act = new MarketingActivity();
        act.setActivityId(activityId);
        act.setAuditNote(note);
        if ("Y".equals(status))
        {
            act.setPublishStatus("A");
        }
        else
        {
            act.setPublishStatus("B");
        }
        return this.marketingActivityGeneratorCoreService.updateByPrimaryKeySelective(act);
    }

    @Override
    public boolean publishActivity(String activityId) throws Exception
    {
        MarketingActivity marketingActivity = this.marketingActivityGeneratorCoreService.selectByPrimaryKey(activityId);
        if (marketingActivity == null)
        {
            GooagooLog.warn("审核活动：活动不存在，activityId=" + activityId);
            return false;
        }
        if (!"A".equals(marketingActivity.getPublishStatus()))
        {
            GooagooLog.warn("审核活动：活动状态不是待审核，activityId=" + activityId + ",publishStatus=" + marketingActivity.getPublishStatus());
            return false;
        }
        if (!this.publishProtectedCoreService.generateHtml(marketingActivity))
        {
            GooagooLog.info("生成静态页面失败[activityId=" + activityId + "]");
            return false;
        }
        marketingActivity.setPublishStatus("P");
        return this.marketingActivityGeneratorCoreService.updateByPrimaryKeySelective(marketingActivity);
    }
}
