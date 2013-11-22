package com.gooagoo.analysis.init;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.marketing.RuleResult;
import com.gooagoo.exception.GooagooException;

/**
 * 规则结果
 * @author YL
 *
 */
public class ResultRule
{
    //Map<ruleId, RuleResult>
    protected static Map<String, RuleResult> ruleResultMap = null;

    /**
     * 根据ruleId获取规则结果
     * @param ruleId
     * @return
     * @throws GooagooException
     */
    public static RuleResult getRuleResult(String ruleId) throws GooagooException
    {
        if (ruleResultMap == null)
        {
            GooagooLog.warn("规则结果为空");
            throw new GooagooException("规则结果为空");
        }
        if (ruleResultMap.get(ruleId) == null)
        {
            GooagooLog.warn("此规则无规则结果，ruleId：" + ruleId);
            throw new GooagooException("此规则无规则结果，ruleId：" + ruleId);
        }
        return ruleResultMap.get(ruleId);
    }

    /**
     * 为ruleResultMap赋值
     * @param ruleResultList
     */
    public static void setRuleResult(List<RuleResult> ruleResultList)
    {
        Map<String, RuleResult> ruleResultMapTemp = new HashMap<String, RuleResult>();
        for (RuleResult ruleResult : ruleResultList)
        {
            ruleResultMapTemp.put(ruleResult.getRuleId(), ruleResult);
        }
        ruleResultMap = ruleResultMapTemp;
    }
}
