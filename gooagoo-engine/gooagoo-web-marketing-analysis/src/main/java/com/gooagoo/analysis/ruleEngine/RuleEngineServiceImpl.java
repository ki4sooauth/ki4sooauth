package com.gooagoo.analysis.ruleEngine;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.gooagoo.analysis.entity.FActionAttribute;
import com.gooagoo.analysis.entity.RuleInput;
import com.gooagoo.analysis.entity.RuleMatch;
import com.gooagoo.analysis.init.MatchRule;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.exception.GooagooException;

@Service
public class RuleEngineServiceImpl implements RuleEngineService
{

    @Override
    public List<RuleInfo> matchingRule(RuleInput ruleInput) throws Exception
    {
        GooagooLog.debug("规则匹配：事实数据【" + JsonUtils.toJson(ruleInput) + "】");
        List<RuleMatch> ruleMatchList = MatchRule.getMatchRule(ruleInput.getShopId(), ruleInput.getActionType());
        if (CollectionUtils.isEmpty(ruleMatchList))
        {
            GooagooLog.debug("规则匹配：商家（" + ruleInput.getShopId() + "）没有营销规则");
            throw new GooagooException("规则匹配：商家（" + ruleInput.getShopId() + "）没有营销规则");
        }
        List<RuleInfo> ruleOutputList = new ArrayList<RuleInfo>();
        for (RuleMatch ruleMatch : ruleMatchList)
        {
            this.doMatchRuleInfoAndGetRuleResult(ruleOutputList, ruleInput, ruleMatch);
        }
        GooagooLog.debug("规则匹配：匹配结果【" + JsonUtils.toJson(ruleOutputList) + "】");
        return ruleOutputList;
    }

    /**
     * 根据事实匹配规则条件，返回匹配条件的规则结果
     * @param ruleOutputList
     * @param ruleInput
     * @param ruleMatch
     * @return
     * @throws Exception
     */
    private void doMatchRuleInfoAndGetRuleResult(List<RuleInfo> ruleOutputList, RuleInput ruleInput, RuleMatch ruleMatch) throws Exception
    {
        //1、匹配规则
        FActionAttribute fActionAttribute = ruleMatch.getActionAttribute();
        GooagooLog.debug("规则匹配：事实数据【" + JsonUtils.toJson(ruleInput) + "】匹配规则数据【" + JsonUtils.toJson(fActionAttribute) + "】开始......");
        //1.2、匹配日期段
        if (!Match.doMatchDateScope(ruleInput.getEventDate(), fActionAttribute.getDateStart(), fActionAttribute.getDateEnd()))
        {
            return;
        }
        //1.3、匹配时间段
        if (!Match.doMatchTimeScope(ruleInput.getEventTime(), fActionAttribute.getTimeStart(), fActionAttribute.getTimeEnd()))
        {
            return;
        }
        //1.4、匹配星期段
        if (!Match.doMatchWeekScope(ruleInput.getEventWeek(), fActionAttribute.getWeekScope()))
        {
            return;
        }
        //1.5、匹配会员等级
        if (!Match.doMatchVipGrade(ruleInput.getVipGrade(), fActionAttribute.getVipGrade()))
        {
            return;
        }
        //1.6、匹配行为来源
        if (!Match.doMatchActionSource(ruleInput.getActionSource(), fActionAttribute.getActionSource()))
        {
            return;
        }
        //1.7、匹配当天次数
        if (!Match.doMatchTime(ruleInput.getTime(), fActionAttribute.getTimeMin(), fActionAttribute.getTimeMax()))
        {
            return;
        }
        //1.8、匹配累计次数
        if (!Match.doMatchTotalTime(ruleInput.getTotalTime(), fActionAttribute.getTotalTimeMin(), fActionAttribute.getTotalTimeMax()))
        {
            return;
        }
        //1.9、匹配区域
        if (!Match.doMatchPosition(ruleInput.getPosition(), fActionAttribute.getPosition()))
        {
            return;
        }
        //1.10、匹配时长
        if (!Match.doMatchDuration(ruleInput.getDuration(), fActionAttribute.getDurationMin(), fActionAttribute.getDurationMax()))
        {
            return;
        }
        //1.11、匹配品类
        if (!Match.doMatchMarketingGoodsCategory(ruleInput.getMarketingGoodsCategory(), fActionAttribute.getMarketingGoodsCategory(), fActionAttribute.getRelation()))
        {
            return;
        }
        //1.12、匹配品牌
        if (!Match.doMatchMarketingGoodsBrand(ruleInput.getMarketingGoodsBrand(), fActionAttribute.getMarketingGoodsBrand(), fActionAttribute.getRelation()))
        {
            return;
        }
        //1.13、匹配商品
        if (!Match.doMatchMarketingGoods(ruleInput.getMarketingGoods(), fActionAttribute.getMarketingGoods(), fActionAttribute.getRelation()))
        {
            return;
        }
        //1.14、匹配金额
        if (!Match.doMatchConsumeMoney(ruleInput.getConsumeMoney(), fActionAttribute.getConsumeMoneyMin(), fActionAttribute.getConsumeMoneyMax()))
        {
            return;
        }
        //1.15、匹配活动
        if (!Match.doMatchMarketingActivity(ruleInput.getMarketingActivity(), fActionAttribute.getMarketingActivity()))
        {
            return;
        }
        //1.16、匹配优惠凭证
        if (!Match.doMatchMarketingCoupon(ruleInput.getMarketingCoupon(), fActionAttribute.getMarketingCoupon()))
        {
            return;
        }
        //1.17、匹配事件
        if (!Match.doMatchMarketingEvent(ruleInput.getMarketingEvent(), fActionAttribute.getMarketingEvent()))
        {
            return;
        }
        //1.18、匹配服务工具
        if (!Match.doMatchServerTools(ruleInput.getServerTools(), fActionAttribute.getServerTools()))
        {
            return;
        }
        GooagooLog.debug("规则匹配：事实数据【" + JsonUtils.toJson(ruleInput) + "】匹配规则数据【" + JsonUtils.toJson(fActionAttribute) + "】结果【" + JsonUtils.toJson(ruleMatch.getRuleInfo()) + "】");
        GooagooLog.debug("规则匹配：事实数据【" + JsonUtils.toJson(ruleInput) + "】匹配规则数据【" + JsonUtils.toJson(fActionAttribute) + "】结束......");

        //2、组装规则结果
        ruleOutputList.add(ruleMatch.getRuleInfo());
    }

}
