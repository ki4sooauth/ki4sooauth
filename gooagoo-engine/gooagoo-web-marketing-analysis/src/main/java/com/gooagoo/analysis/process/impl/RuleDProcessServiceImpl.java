package com.gooagoo.analysis.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.analysis.common.utils.MarketingUtils;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.MarketingNotice;
import com.gooagoo.analysis.process.service.ProcessCommonService;
import com.gooagoo.analysis.process.service.ProcessService;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.push.MobPushMsg;

/**
 * 手机服务
 */
@Service("ruleDProcessService")
public class RuleDProcessServiceImpl implements ProcessService
{
    @Autowired
    ProcessCommonService processCommonService;

    @SuppressWarnings("unchecked")
    @Override
    public MarketingNotice<GooagooMessage<MobPushMsg>> doProcess(RuleInfo ruleInfo, Behave behave) throws Exception
    {
        GooagooMessage<MobPushMsg> gooagooMessage = MarketingUtils.getGooagooMessage(behave);
        if (this.processCommonService.processMarketingUserLink(behave, ruleInfo))
        {
            MobPushMsg mobPushMsg = MarketingUtils.getMobPushMsg(behave);
            mobPushMsg.setContent(UrlUtils.getEventUrl(ruleInfo.getObjectId()));
            gooagooMessage.setContent(mobPushMsg);
            return (MarketingNotice<GooagooMessage<MobPushMsg>>) MarketingUtils.getMarketingNotice("http", gooagooMessage);
        }
        return null;
    }

}
