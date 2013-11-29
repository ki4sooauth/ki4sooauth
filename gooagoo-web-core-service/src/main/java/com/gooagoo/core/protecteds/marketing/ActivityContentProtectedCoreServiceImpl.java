package com.gooagoo.core.protecteds.marketing;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.core.marketing.CryoutInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.MarketingEventGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.NoticeInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.RuleInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.ShortMessageGeneratorCoreService;
import com.gooagoo.api.protecteds.core.marketing.ActivityContentProtectedCoreService;
import com.gooagoo.api.protecteds.core.marketing.MarketingProtectedCoreService;
import com.gooagoo.api.protecteds.core.publish.PublishProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.CryoutInfo;
import com.gooagoo.entity.generator.marketing.MarketingEvent;
import com.gooagoo.entity.generator.marketing.NoticeInfo;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.ShortMessage;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class ActivityContentProtectedCoreServiceImpl implements ActivityContentProtectedCoreService
{
    @Autowired
    private CryoutInfoGeneratorCoreService cryoutInfoGeneratorCoreService;
    @Autowired
    private NoticeInfoGeneratorCoreService noticeInfoGeneratorCoreService;
    @Autowired
    private ShortMessageGeneratorCoreService shortMessageGeneratorCoreService;
    @Autowired
    private MarketingEventGeneratorCoreService marketingEventGeneratorCoreService;
    @Autowired
    private RuleInfoGeneratorCoreService ruleInfoGeneratorCoreService;
    @Autowired
    private MarketingProtectedCoreService marketingProtectedCoreService;
    @Autowired
    private PublishProtectedCoreService publishProtectedCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean release(String objectId, String ruleType, List<Account> users, RuleInfo ruleInfo) throws Exception
    {
        if (!StringUtils.hasText(objectId) || !StringUtils.hasText(ruleType) || ruleInfo == null)
        {
            GooagooLog.info("发布营销内容：发布信息不全，objectId=" + objectId + ",ruleType=" + ruleType + ",ruleInfo=" + ruleInfo);
            return false;
        }
        //初始化规则中的默认信息
        this.defaultRuleInfo(ruleInfo, objectId, ruleType);
        //活动内容信息校验
        if (!this.checkMarketingContent(ruleInfo))
        {
            return false;
        }
        //保存规则用户关联信息
        this.saveMarketingUserLinkList(users, ruleInfo);
        //保存活动内容的发布规则信息
        this.saveRuleInfo(ruleInfo);
        //更新活动内容的发布状态
        this.updateMarketingContent(ruleInfo);

        return true;
    }

    /**
     * 获取RuleInfo对象
     * @param ruleInfo
     * @param marketingId
     * @param marketingType
     * @return
     * @throws GooagooException
     */
    private void defaultRuleInfo(RuleInfo ruleInfo, String objectId, String ruleType)
    {
        ruleInfo.setRuleType(ruleType);
        ruleInfo.setObjectId(objectId);
        ruleInfo.setIsActiveForever("N");
        ruleInfo.setCreateTime(new Date());
        ruleInfo.setIsDel("N");
        if (!"N".equals(ruleInfo.getIsPublishImmediately()))
        {
            ruleInfo.setActualPublishTime(new Date());
            ruleInfo.setPublishStatus("P");
        }
        else
        {
            ruleInfo.setPublishStatus("D");
        }
    }

    /**
     * 活动内容信息校验
     * @param rule
     * @param isReviewedAndRelease 是否是审核发布
     * @return
     * @throws GooagooException
     */
    private boolean checkMarketingContent(RuleInfo rule) throws Exception
    {
        String ruleType = rule.getRuleType();
        String objectId = rule.getObjectId();

        String publishStatus = "";
        String typeName = "";
        Object obj;
        if ("1".equals(ruleType))
        {
            //吆喝
            typeName = "吆喝";
            CryoutInfo cryoutInfo = this.cryoutInfoGeneratorCoreService.selectByPrimaryKey(objectId);
            if (cryoutInfo == null)
            {
                GooagooLog.info("吆喝信息不存在,rule=" + new Gson().toJson(rule));
                return false;
            }
            publishStatus = cryoutInfo.getPublishStatus();
            rule.setRuleName(cryoutInfo.getCryoutTitle());
            rule.setActivityId(cryoutInfo.getActivityId());
            obj = cryoutInfo;
        }
        else if ("2".equals(ruleType))
        {
            //通知
            typeName = "通知";
            NoticeInfo noticeInfo = this.noticeInfoGeneratorCoreService.selectByPrimaryKey(objectId);
            if (noticeInfo == null)
            {
                GooagooLog.info("通知信息不存在,rule=" + new Gson().toJson(rule));
                return false;
            }
            publishStatus = noticeInfo.getPublishStatus();
            rule.setRuleName(noticeInfo.getNoticeTitle());
            rule.setActivityId(noticeInfo.getActivityId());
            obj = noticeInfo;
        }
        else if ("4".equals(ruleType))
        {
            //短信
            typeName = "短信";
            ShortMessage shortMessage = this.shortMessageGeneratorCoreService.selectByPrimaryKey(objectId);
            if (shortMessage == null)
            {
                GooagooLog.info("短信信息不存在,rule=" + new Gson().toJson(rule));
                return false;
            }
            publishStatus = shortMessage.getPublishStatus();
            rule.setRuleName(shortMessage.getMessageTitle());
            rule.setActivityId(shortMessage.getActivityId());
            obj = shortMessage;
        }
        else if ("0".equals(ruleType) || "3".equals(ruleType) || "D".equals(ruleType) || "E".equals(ruleType) || "G".equals(ruleType))
        {
            //事件
            typeName = "事件";
            MarketingEvent marketingEvent = this.marketingEventGeneratorCoreService.selectByPrimaryKey(objectId);
            if (marketingEvent == null)
            {
                GooagooLog.warn("发布营销内容，事件信息不存在,rule=" + new Gson().toJson(rule));
                return false;
            }
            publishStatus = marketingEvent.getPublishStatus();
            rule.setRuleName(marketingEvent.getEventName());
            rule.setActivityId(marketingEvent.getActivityId());
            obj = marketingEvent;
        }
        else
        {
            GooagooLog.warn("发布营销内容：营销内容类型不正确,rule=" + new Gson().toJson(rule));
            return false;
        }
        //状态校验
        if (!"A".equals(publishStatus))
        {
            GooagooLog.warn("发布营销内容，" + typeName + "信息不是审核通过状态,marketing=" + new Gson().toJson(obj) + ",rule=" + new Gson().toJson(rule));
            return false;
        }
        return true;
    }

    /**
     * 保存规则用户关联信息
     * @param users
     * @param rule
     * @return
     * @throws GooagooException
     */
    public void saveMarketingUserLinkList(List<Account> users, RuleInfo rule) throws Exception
    {
        this.marketingProtectedCoreService.saveMarketingUserLinkList(users, rule);
    }

    /**
     * 保存活动内容的发布规则信息
     * @param rule
     * @return
     * @throws GooagooException
     */
    private void saveRuleInfo(RuleInfo rule) throws Exception
    {
        if (!this.ruleInfoGeneratorCoreService.insertSelective(rule))
        {
            GooagooLog.info("保存活动内容的发布规则信息失败：obj=" + new Gson().toJson(rule));
            throw new OperateFailException("保存活动内容的发布规则信息失败");
        }
    }

    /**
     * 更新活动内容的发布状态
     * @param rule
     * @return
     * @throws GooagooException
     */
    private void updateMarketingContent(RuleInfo rule) throws Exception
    {
        String ruleType = rule.getRuleType();
        String objectId = rule.getObjectId();
        String publisStatus = "P";
        if ("N".equals(rule.getIsPublishImmediately()))
        {
            publisStatus = "D";
        }

        boolean ret = false;
        if ("1".equals(ruleType))
        {
            //吆喝
            CryoutInfo cryoutInfo = new CryoutInfo();
            cryoutInfo.setCryoutInfoId(objectId);
            cryoutInfo.setPublishStatus(publisStatus);
            cryoutInfo.setRuleId(rule.getRuleId());
            ret = this.cryoutInfoGeneratorCoreService.updateByPrimaryKeySelective(cryoutInfo);
        }
        else if ("2".equals(ruleType))
        {
            //通知
            NoticeInfo noticeInfo = new NoticeInfo();
            noticeInfo.setNoticeInfoId(objectId);
            noticeInfo.setPublishStatus(publisStatus);
            noticeInfo.setRuleId(rule.getRuleId());
            ret = this.noticeInfoGeneratorCoreService.updateByPrimaryKeySelective(noticeInfo);
        }
        else if ("4".equals(ruleType))
        {
            //短信
            ShortMessage shortMessage = new ShortMessage();
            shortMessage.setMessageId(objectId);
            shortMessage.setPublishStatus(publisStatus);
            shortMessage.setRuleId(rule.getRuleId());
            ret = this.shortMessageGeneratorCoreService.updateByPrimaryKeySelective(shortMessage);
        }
        else if ("0".equals(ruleType) || "3".equals(ruleType) || "D".equals(ruleType) || "E".equals(ruleType) || "G".equals(ruleType))
        {
            //事件
            MarketingEvent marketingEvent = this.marketingEventGeneratorCoreService.selectByPrimaryKey(objectId);
            marketingEvent.setPublishStatus(publisStatus);
            marketingEvent.setRuleId(rule.getRuleId());
            //生成事件静态页面
            //0-购好奇、3-邮件、D-手机服务:生成静态页面
            if ("0".equals(ruleType) || "3".equals(ruleType) || "D".equals(ruleType))
            {
                if (!this.publishProtectedCoreService.generateEventOrCmsHtml(marketingEvent, ruleType))
                {
                    GooagooLog.info("生成活动静态页面失败[ruleType=" + ruleType + "、eventId=" + objectId + "]");
                    throw new OperateFailException("生成活动静态页面失败[ruleType=" + ruleType + "、eventId=" + objectId + "]");
                }
            }
            ret = this.marketingEventGeneratorCoreService.updateByPrimaryKeySelective(marketingEvent);
        }
        else
        {
            GooagooLog.warn("发布营销内容：营销内容类型不正确,rule=" + new Gson().toJson(rule));
        }
        if (!ret)
        {
            GooagooLog.info("更新活动内容的发布状态失败：obj=" + new Gson().toJson(rule));
            throw new OperateFailException("更新活动内容的发布状态失败");
        }
    }
}
