package com.gooagoo.analysis.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.util.StringUtils;

import com.gooagoo.analysis.entity.FActionAttribute;
import com.gooagoo.analysis.entity.FRuleCondition;
import com.gooagoo.analysis.entity.RuleMatch;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.exception.GooagooException;

/**
 * 规则匹配时使用的规则
 * @author YL
 *
 */
public class MatchRule
{
    //Map<shopId, Map<actionType,List<RuleMatch>>>
    protected static Map<String, Map<String, List<RuleMatch>>> matchRuleMap = null;

    /**
     * 根据shopId、actionType获取规则
     * @param shopId 商家编号
     * @param actionType 行为类型
     * @return List<RuleMatch>
     * @throws GooagooException
     */
    public static List<RuleMatch> getMatchRule(String shopId, String actionType) throws GooagooException
    {
        if (matchRuleMap == null)
        {
            GooagooLog.warn("预处理规则为空");
            throw new GooagooException("预处理规则为空");
        }
        if (matchRuleMap.get(shopId) == null)
        {
            GooagooLog.warn("此商家无规则，shopid：" + shopId);
            throw new GooagooException("此商家无规则，shopid：" + shopId);
        }
        if (matchRuleMap.get(shopId).get(actionType) == null)
        {
            GooagooLog.warn("此商家无此类型规则，shopid：" + shopId + ",actionType:" + actionType);
            throw new GooagooException("此商家无此类型规则，shopid：" + shopId + ",actionType:" + actionType);
        }
        return matchRuleMap.get(shopId).get(actionType);
    }

    public static void setMatchRule(List<RuleInfo> ruleInfoList)
    {
        //Map<shopId, Map<actionType,List<RuleMatch>>>
        Map<String, Map<String, List<RuleMatch>>> rule_shopId_actionType = new HashMap<String, Map<String, List<RuleMatch>>>();
        //Map<shopId, List<RuleInfo>>
        Map<String, List<RuleInfo>> Rule_shopid = new HashMap<String, List<RuleInfo>>();
        for (RuleInfo ruleInfo : ruleInfoList)
        {
            if (!StringUtils.hasText(ruleInfo.getRuleContent()))
            {
                continue;
            }
            List<RuleInfo> ruleInfoTemp = Rule_shopid.get(ruleInfo.getShopId());
            if (ruleInfoTemp == null)
            {
                ruleInfoTemp = new ArrayList<RuleInfo>();
                ruleInfoTemp.add(ruleInfo);
                Rule_shopid.put(ruleInfo.getShopId(), ruleInfoTemp);
            }
            else
            {
                ruleInfoTemp.add(ruleInfo);
                Rule_shopid.put(ruleInfo.getShopId(), ruleInfoTemp);
            }
        }
        for (Entry<String, List<RuleInfo>> entry : Rule_shopid.entrySet())
        {
            //一个商家的所有规则
            List<RuleInfo> shopRuleInfoList = entry.getValue();//商家规则列表
            Map<String, List<RuleMatch>> rule_ruleMatchMap = new HashMap<String, List<RuleMatch>>();
            for (RuleInfo ruleInfo : shopRuleInfoList)
            {
                //一个商家的一个规则
                FActionAttribute fActionAttribute = getFActionAttribute(ruleInfo);
                if (fActionAttribute == null)
                {
                    continue;
                }
                List<RuleMatch> RuleMatchTemp = rule_ruleMatchMap.get(fActionAttribute.getActionType());
                if (RuleMatchTemp == null)
                {
                    RuleMatchTemp = new ArrayList<RuleMatch>();
                    RuleMatchTemp.add(getRuleMatch(ruleInfo));
                    rule_ruleMatchMap.put(fActionAttribute.getActionType(), RuleMatchTemp);
                }
                else
                {
                    RuleMatchTemp.add(getRuleMatch(ruleInfo));
                    rule_ruleMatchMap.put(fActionAttribute.getActionType(), RuleMatchTemp);
                }
            }
            rule_shopId_actionType.put(entry.getKey(), rule_ruleMatchMap);
        }
        matchRuleMap = rule_shopId_actionType;
    }

    /**
     * 获取实时条件信息
     * @param ruleInfo 规则发布信息
     * @return FActionAttribute
     */
    private static FActionAttribute getFActionAttribute(RuleInfo ruleInfo)
    {
        FRuleCondition fRuleCondition = JsonUtils.toObj(ruleInfo.getRuleContent(), FRuleCondition.class);
        FActionAttribute fActionAttribute = fRuleCondition.getActionAttribute();
        return fActionAttribute;
    }

    /**
     * 缓存ruleMatch信息
     * @param ruleInfo 规则发布信息
     * @return RuleMatch
     */
    private static RuleMatch getRuleMatch(RuleInfo ruleInfo)
    {
        RuleMatch ruleMatch = new RuleMatch();
        ruleMatch.setActionAttribute(getFActionAttribute(ruleInfo));
        ruleMatch.setRuleInfo(ruleInfo);
        return ruleMatch;
    }
}
