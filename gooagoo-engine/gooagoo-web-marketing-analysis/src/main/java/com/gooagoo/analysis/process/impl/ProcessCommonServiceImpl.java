package com.gooagoo.analysis.process.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.analysis.common.utils.MarketingUtils;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.process.service.ProcessCommonService;
import com.gooagoo.api.business.core.marketing.user.MarketingUserLinkCoreService;
import com.gooagoo.api.generator.query.marketing.MarketingUserLinkGeneratorQueryService;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.marketing.rule.RuleCondition;
import com.gooagoo.entity.generator.marketing.MarketingUserLink;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkExample;
import com.gooagoo.entity.generator.marketing.RuleInfo;

@Service
public class ProcessCommonServiceImpl implements ProcessCommonService
{
    @Autowired
    MarketingUserLinkGeneratorQueryService marketingUserLinkGeneratorQueryService;
    @Autowired
    MarketingUserLinkCoreService marketingUserLinkCoreService;

    /**
     * 根据历史条件判断处理方式:0-历史人群(营销引擎不用处理)，1-即时人群，2-历史人群+即时人群
     * @param behaveLog
     * @param ruleInfo
     * @param activityId
     * @return
     */
    @Override
    public boolean processMarketingUserLink(Behave behave, RuleInfo ruleInfo)
    {
        RuleCondition ruleCondition = JsonUtils.toObj(ruleInfo.getRuleContent(), RuleCondition.class);
        if ("0".equals(ruleCondition.getConditionType()))//0-历史人群(营销引擎不用处理)
        {
            return false;
        }
        MarketingUserLinkExample marketingUserLinkExample = new MarketingUserLinkExample();
        marketingUserLinkExample.createCriteria().andMarketingIdEqualTo(ruleInfo.getObjectId());
        marketingUserLinkExample.setOrderByClause("push_time desc");
        List<MarketingUserLink> marketingUserLinkList = this.marketingUserLinkGeneratorQueryService.selectByExample(marketingUserLinkExample);
        if ("1".equals(ruleCondition.getConditionType()))//1-即时人群
        {//新建“营销与用户关联表”数据
            if (MarketingUtils.checkNumberOfTimes(ruleCondition.getConditionType(), ruleInfo.getRuleActiveType(), marketingUserLinkList))
            {
                return this.addMarketingUserLink(behave, ruleInfo);
            }
        }
        if ("2".equals(ruleCondition.getConditionType()))//2-历史人群+即时人群
        {//更新“营销与用户关联表”的数据；将推送状态变为已推送
            if (MarketingUtils.checkNumberOfTimes(ruleCondition.getConditionType(), ruleInfo.getRuleActiveType(), marketingUserLinkList))
            {
                return this.updateMarketingUserLink(marketingUserLinkList.get(0));
            }
        }
        return false;
    }

    /**
     * 创建营销内容与用户关联
     * @param behaveLog
     * @param ruleInfo
     * @return
     */
    private boolean addMarketingUserLink(Behave behave, RuleInfo ruleInfo)
    {
        MarketingUserLink marketingUserLink = new MarketingUserLink();
        marketingUserLink.setMarketingType(ruleInfo.getRuleType());
        marketingUserLink.setMarketingId(ruleInfo.getObjectId());
        marketingUserLink.setShopId(behave.getShopId());
        marketingUserLink.setAccountType("0");
        marketingUserLink.setAccount(behave.getUserId());
        marketingUserLink.setActivityId(ruleInfo.getActivityId());
        marketingUserLink.setIsPushed("Y");
        marketingUserLink.setPushTime(new Date());
        marketingUserLink.setIsRead("N");
        marketingUserLink.setIsDel("N");
        marketingUserLink.setId(UUID.getUUID());
        return this.marketingUserLinkCoreService.insertSelective(marketingUserLink);
    }

    /**
     * 更新营销内容与用户关联
     * @param behaveLog
     * @param ruleInfo
     * @return
     */
    private boolean updateMarketingUserLink(MarketingUserLink marketingUserLink)
    {
        marketingUserLink.setIsPushed("Y");
        marketingUserLink.setPushTime(new Date());
        return this.marketingUserLinkCoreService.updateByPrimaryKeySelective(marketingUserLink);
    }
}
