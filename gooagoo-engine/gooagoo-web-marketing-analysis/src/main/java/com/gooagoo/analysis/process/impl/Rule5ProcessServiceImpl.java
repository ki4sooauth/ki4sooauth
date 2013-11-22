package com.gooagoo.analysis.process.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.analysis.common.utils.MarketingUtils;
import com.gooagoo.analysis.common.utils.UserSendConstants;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.MarketingNotice;
import com.gooagoo.analysis.init.ResultRule;
import com.gooagoo.analysis.process.service.ProcessCommonService;
import com.gooagoo.analysis.process.service.ProcessService;
import com.gooagoo.api.business.core.marketing.integral.IntegralCoreService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.RuleResult;
import com.gooagoo.entity.generator.member.IntegralDetailInfo;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.push.MobPushMsg;

/**
 * 积分
 */
@Service("rule5ProcessService")
public class Rule5ProcessServiceImpl implements ProcessService
{
    @Autowired
    ProcessCommonService processCommonService;
    @Autowired
    ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;
    @Autowired
    IntegralCoreService integralCoreService;

    @SuppressWarnings("unchecked")
    @Override
    public MarketingNotice<GooagooMessage<MobPushMsg>> doProcess(RuleInfo ruleInfo, Behave behave) throws Exception
    {
        RuleResult ruleResult = ResultRule.getRuleResult(ruleInfo.getRuleId());
        String content = UserSendConstants.INTEGRAL;
        GooagooMessage<MobPushMsg> gooagooMessage = MarketingUtils.getGooagooMessage(behave);
        if (this.processCommonService.processMarketingUserLink(behave, ruleInfo))
        {
            IntegralDetailInfo integralDetailInfo = new IntegralDetailInfo();
            integralDetailInfo.setIntegralId(UUID.getUUID());
            integralDetailInfo.setUserId(behave.getUserId());
            integralDetailInfo.setShopId(behave.getShopId());
            integralDetailInfo.setIntegralNumber(Integer.parseInt(ruleResult.getRuleResultValue()));
            integralDetailInfo.setIntegralSource(behave.getBehaveType());
            integralDetailInfo.setIntegralCreateTime(new Date());
            integralDetailInfo.setIsFreez("N");
            integralDetailInfo.setIsDel("N");
            integralDetailInfo.setNote(behave.getBehaveType());
            integralDetailInfo.setCreateTime(new Date());
            if (this.integralCoreService.receiveIntegral(integralDetailInfo))
            {
                MobPushMsg mobPushMsg = MarketingUtils.getMobPushMsg(behave);
                content = content.replaceAll("\\$\\{integral\\}", ruleResult.getRuleResultValue());
                mobPushMsg.setContent(content);
                gooagooMessage.setContent(mobPushMsg);
                return (MarketingNotice<GooagooMessage<MobPushMsg>>) MarketingUtils.getMarketingNotice("push", gooagooMessage);
            }
        }
        return null;
    }
}
