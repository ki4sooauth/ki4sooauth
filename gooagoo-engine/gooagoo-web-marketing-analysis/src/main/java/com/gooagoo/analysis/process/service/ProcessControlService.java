package com.gooagoo.analysis.process.service;

import java.util.List;

import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.MarketingNotice;
import com.gooagoo.entity.generator.marketing.RuleInfo;

/**
 * 
 * @author YL
 *
 */
public interface ProcessControlService
{
    /**
     * 0-购好奇,1-吆喝,2-通知,3-邮件,4-短信,5-积分,6-优惠,7-会员卡,8-忠诚度,9-用户价值,A-活跃度,B-沉默度,C-流失度,D-手机服务,E-手机虚拟商家,F-网站虚拟商家,G-自定义服务工具
     * @param ruleInfoList
     * @param behaveLog
     * @return
     * @throws Exception
     */
    public MarketingNotice<?> doProcess(List<RuleInfo> ruleInfoList, Behave behave) throws Exception;

}
