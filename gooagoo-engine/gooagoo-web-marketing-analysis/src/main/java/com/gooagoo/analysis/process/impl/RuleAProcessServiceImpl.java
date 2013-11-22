package com.gooagoo.analysis.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.MarketingNotice;
import com.gooagoo.analysis.process.service.ProcessCommonService;
import com.gooagoo.analysis.process.service.ProcessService;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.push.MobPushMsg;

/**
 * 活跃度
 */
@Service("ruleAProcessService")
public class RuleAProcessServiceImpl implements ProcessService
{

    @Autowired
    ProcessCommonService processCommonService;

    @Override
    public MarketingNotice<GooagooMessage<MobPushMsg>> doProcess(RuleInfo ruleInfo, Behave behave) throws Exception
    {
        return null;
    }

}
