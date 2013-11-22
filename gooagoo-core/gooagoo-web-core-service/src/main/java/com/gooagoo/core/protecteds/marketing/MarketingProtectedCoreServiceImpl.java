package com.gooagoo.core.protecteds.marketing;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.marketing.MarketingUserLinkGeneratorCoreService;
import com.gooagoo.api.protecteds.core.marketing.MarketingProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.marketing.rule.RuleCondition;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.MarketingUserLink;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class MarketingProtectedCoreServiceImpl implements MarketingProtectedCoreService
{

    @Autowired
    private MarketingUserLinkGeneratorCoreService marketingUserLinkGeneratorCoreService;

    @Override
    public void saveMarketingUserLinkList(List<Account> users, RuleInfo rule) throws Exception
    {
        if (users == null || users.size() == 0)
        {
            GooagooLog.debug("发布人群为空，rule=" + new Gson().toJson(rule));
            return;
        }
        for (Account userAccount : users)
        {
            if (!org.springframework.util.StringUtils.hasText(userAccount.getAccountNo()) || userAccount.getAccountType() == null)
            {
                GooagooLog.info("关联用户账户信息不正确：obj=" + new Gson().toJson(userAccount));
                continue;
            }
            MarketingUserLink marketingUserLink = new MarketingUserLink();
            marketingUserLink.setAccount(userAccount.getAccountNo());
            marketingUserLink.setAccountType(userAccount.getAccountType() + "");
            marketingUserLink.setActivityId(rule.getActivityId());
            marketingUserLink.setCreateTime(new Date());
            marketingUserLink.setId(com.gooagoo.common.utils.StringUtils.getUUID());
            marketingUserLink.setIsRead("N");
            marketingUserLink.setIsDel("N");

            String conditionJson = rule.getRuleContent();
            RuleCondition ruleCondition = new Gson().fromJson(conditionJson, RuleCondition.class);

            if ("0".equals(ruleCondition.getConditionType()) && !"N".equals(rule.getIsPublishImmediately()))
            {
                marketingUserLink.setIsPushed("Y");
                marketingUserLink.setPushTime(new Date());
            }
            else
            {
                marketingUserLink.setIsPushed("N");
            }
            marketingUserLink.setMarketingId(rule.getObjectId());
            marketingUserLink.setMarketingType(rule.getRuleType());
            marketingUserLink.setShopId(rule.getShopId());
            boolean ret = this.marketingUserLinkGeneratorCoreService.insertSelective(marketingUserLink);
            if (!ret)
            {
                GooagooLog.info("关联用户账户信息保存失败：obj=" + new Gson().toJson(marketingUserLink));
                throw new OperateFailException("关联用户账户信息保存失败");
            }
        }
    }

}
