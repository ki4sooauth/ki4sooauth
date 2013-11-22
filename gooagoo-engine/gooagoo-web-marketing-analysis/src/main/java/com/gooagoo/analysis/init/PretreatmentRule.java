package com.gooagoo.analysis.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.util.StringUtils;

import com.gooagoo.analysis.entity.FActionAttribute;
import com.gooagoo.analysis.entity.FRuleCondition;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.exception.GooagooException;

/**
 * 预处理规则
 * @author YL
 *
 */
public class PretreatmentRule
{
    //Map<shopId, Map<actionType,Set<ruleSet>>>
    protected static Map<String, Map<String, Set<String>>> pretreatmentRuleMap = null;

    /**
     * 根据shopId、actionType获取预处理规则
     * @param shopId
     * @param actionType
     * @return
     * @throws GooagooException 
     */
    public static Set<String> getPretreatmentRule(String shopId, String actionType) throws GooagooException
    {
        if (pretreatmentRuleMap == null)
        {
            GooagooLog.warn("预处理规则为空");
            throw new GooagooException("预处理规则为空");
        }
        if (pretreatmentRuleMap.get(shopId) == null)
        {
            GooagooLog.warn("此商家无预处理规则，shopid：" + shopId);
            throw new GooagooException("此商家无预处理规则，shopid：" + shopId);
        }
        if (pretreatmentRuleMap.get(shopId).get(actionType) == null)
        {
            GooagooLog.warn("此商家无此类型预处理规则，shopid：" + shopId + ",actionType:" + actionType);
            throw new GooagooException("此商家无此类型预处理规则，shopid：" + shopId + ",actionType:" + actionType);
        }
        return pretreatmentRuleMap.get(shopId).get(actionType);
    }

    public static void setPretreatmentRule(List<RuleInfo> ruleInfoList)
    {
        //Map<shopId, Map<actionType,Set<ruleSet>>>
        Map<String, Map<String, Set<String>>> shopRule = new HashMap<String, Map<String, Set<String>>>();
        //Map<shopId, List<RuleInfo>>>
        Map<String, List<RuleInfo>> actionTypeRule = new HashMap<String, List<RuleInfo>>();
        for (RuleInfo ruleInfo : ruleInfoList)
        {
            List<RuleInfo> ruleInfoTemp = actionTypeRule.get(ruleInfo.getShopId());
            if (ruleInfoTemp == null)
            {
                ruleInfoTemp = new ArrayList<RuleInfo>();
                ruleInfoTemp.add(ruleInfo);
                actionTypeRule.put(ruleInfo.getShopId(), ruleInfoTemp);
            }
            else
            {
                ruleInfoTemp.add(ruleInfo);
                actionTypeRule.put(ruleInfo.getShopId(), ruleInfoTemp);
            }
        }
        for (Entry<String, List<RuleInfo>> entry : actionTypeRule.entrySet())
        {
            List<RuleInfo> shopRuleInfoList = entry.getValue();
            Map<String, Set<String>> actionTypeRuleTempMap = new HashMap<String, Set<String>>();
            for (RuleInfo ruleInfo : shopRuleInfoList)
            {
                FRuleCondition fRuleCondition = JsonUtils.toObj(ruleInfo.getRuleContent(), FRuleCondition.class);
                FActionAttribute fActionAttribute = fRuleCondition.getActionAttribute();
                if (fActionAttribute == null)
                {
                    continue;
                }
                Set<String> actionTypeRuleTempSet = actionTypeRuleTempMap.get(fActionAttribute.getActionType());
                if (actionTypeRuleTempSet == null)
                {
                    actionTypeRuleTempSet = getActionTypeRule(fActionAttribute, new HashSet<String>());
                    actionTypeRuleTempMap.put(fActionAttribute.getActionType(), actionTypeRuleTempSet);
                }
                else
                {
                    actionTypeRuleTempSet = getActionTypeRule(fActionAttribute, actionTypeRuleTempSet);
                    actionTypeRuleTempMap.put(fActionAttribute.getActionType(), actionTypeRuleTempSet);
                }
            }
            shopRule.put(entry.getKey(), actionTypeRuleTempMap);
        }
        pretreatmentRuleMap = shopRule;
    }

    private static Set<String> getActionTypeRule(FActionAttribute fActionAttribute, Set<String> actionTypeRuleSet)
    {
        if (StringUtils.hasText(fActionAttribute.getDateStart()) || StringUtils.hasText(fActionAttribute.getDateEnd()))
        {
            actionTypeRuleSet.add("eventDate");
        }
        if (StringUtils.hasText(fActionAttribute.getTimeStart()) || StringUtils.hasText(fActionAttribute.getTimeEnd()))
        {
            actionTypeRuleSet.add("eventTime");
        }
        if (StringUtils.hasText(fActionAttribute.getWeekScope()))
        {
            actionTypeRuleSet.add("eventWeek");
        }
        if (StringUtils.hasText(fActionAttribute.getVipGrade()))
        {
            actionTypeRuleSet.add("vipGrade");
        }
        if (StringUtils.hasText(fActionAttribute.getActionSource()))
        {
            actionTypeRuleSet.add("actionSource");
        }
        if (fActionAttribute.getTimeMin() != null || fActionAttribute.getTimeMax() != null)
        {
            actionTypeRuleSet.add("time");
        }
        if (fActionAttribute.getTotalTimeMin() != null || fActionAttribute.getTotalTimeMax() != null)
        {
            actionTypeRuleSet.add("totalTime");
        }
        if (fActionAttribute.getDurationMin() != null || fActionAttribute.getDurationMax() != null)
        {
            actionTypeRuleSet.add("duration");
        }
        if (StringUtils.hasText(fActionAttribute.getPosition()))
        {
            actionTypeRuleSet.add("position");
        }
        if (StringUtils.hasText(fActionAttribute.getMarketingGoodsBrand()))
        {
            actionTypeRuleSet.add("marketingGoodsBrand");
        }
        if (StringUtils.hasText(fActionAttribute.getMarketingGoodsCategory()))
        {
            actionTypeRuleSet.add("marketingGoodsCategory");
        }
        if (StringUtils.hasText(fActionAttribute.getMarketingGoods()))
        {
            actionTypeRuleSet.add("marketingGoods");
        }
        if (StringUtils.hasText(fActionAttribute.getMarketingActivity()))
        {
            actionTypeRuleSet.add("marketingActivity");
        }
        if (StringUtils.hasText(fActionAttribute.getMarketingEvent()))
        {
            actionTypeRuleSet.add("marketingEvent");
        }
        if (StringUtils.hasText(fActionAttribute.getMarketingCoupon()))
        {
            actionTypeRuleSet.add("marketingCoupon");
        }
        if (StringUtils.hasText(fActionAttribute.getCmsContent()))
        {

            actionTypeRuleSet.add("cmsContent");
        }
        if (StringUtils.hasText(fActionAttribute.getServerTools()))
        {
            actionTypeRuleSet.add("serverTools");
        }
        if (fActionAttribute.getConsumeMoneyMax() != null || fActionAttribute.getConsumeMoneyMin() != null)
        {
            actionTypeRuleSet.add("consumeMoney");
        }
        return actionTypeRuleSet;
    }

}
