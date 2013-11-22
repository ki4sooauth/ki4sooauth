package com.gooagoo.analysis.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.analysis.common.utils.LogUtil;
import com.gooagoo.analysis.common.utils.MarketingUtils;
import com.gooagoo.analysis.common.utils.UserSendConstants;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.MarketingNotice;
import com.gooagoo.analysis.process.service.ProcessCommonService;
import com.gooagoo.analysis.process.service.ProcessService;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.push.MobPushMsg;

/**
 * 1-吆喝
 */
@Service("rule1ProcessService")
public class Rule1ProcessServiceImpl implements ProcessService
{

    @Autowired
    ProcessCommonService processCommonService;
    @Autowired
    LogUtil logUtil;

    @SuppressWarnings("unchecked")
    @Override
    public MarketingNotice<GooagooMessage<MobPushMsg>> doProcess(RuleInfo ruleInfo, Behave behave) throws Exception
    {
        GooagooMessage<MobPushMsg> gooagooMessage = MarketingUtils.getGooagooMessage(behave);
        String content = UserSendConstants.SHOPCRYOUT;
        if (this.processCommonService.processMarketingUserLink(behave, ruleInfo))
        {
            MobPushMsg mobPushMsg = MarketingUtils.getMobPushMsg(behave);
            mobPushMsg.setContent(content);
            gooagooMessage.setContent(mobPushMsg);
            return (MarketingNotice<GooagooMessage<MobPushMsg>>) MarketingUtils.getMarketingNotice("push", gooagooMessage);
        }
        return null;
    }
}
