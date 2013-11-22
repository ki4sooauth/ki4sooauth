package com.gooagoo.analysis.process.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.MarketingNotice;
import com.gooagoo.analysis.process.service.ProcessControlService;
import com.gooagoo.analysis.process.service.ProcessService;
import com.gooagoo.common.utils.SpringBeanUtils;
import com.gooagoo.entity.generator.marketing.RuleInfo;

/**
 * 
 * @author YL
 *
 */
@Service
public class ProcessControlServiceImpl implements ProcessControlService
{
    /**
     * 0-购好奇,1-吆喝,2-通知,3-邮件,4-短信,5-积分,6-优惠,7-会员卡,8-忠诚度,9-用户价值,A-活跃度,B-沉默度,C-流失度,D-手机服务
     * @param ruleInfoList
     * @param behaveLog
     * @return
     * @throws Exception
     */
    @Override
    public MarketingNotice<?> doProcess(List<RuleInfo> ruleInfoList, Behave behave) throws Exception
    {
        if (CollectionUtils.isEmpty(ruleInfoList))
        {
            return null;
        }
        for (RuleInfo ruleInfo : ruleInfoList)
        {
            ProcessService processService = (ProcessService) SpringBeanUtils.getBean("rule" + ruleInfo.getRuleType() + "ProcessService");
            return processService.doProcess(ruleInfo, behave);
        }
        return null;
    }
}
