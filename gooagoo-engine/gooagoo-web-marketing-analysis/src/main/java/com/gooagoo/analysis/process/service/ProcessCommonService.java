package com.gooagoo.analysis.process.service;

import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.entity.generator.marketing.RuleInfo;

public interface ProcessCommonService
{

    /**
     * 根据历史条件判断处理方式:0-历史人群(营销引擎不用处理)，1-即时人群，2-历史人群+即时人群
     * @param behaveLog
     * @param ruleInfo
     * @param activityId
     * @return
     */
    boolean processMarketingUserLink(Behave behave, RuleInfo ruleInfo);

}
