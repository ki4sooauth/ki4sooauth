package com.gooagoo.analysis.complement.impl;

import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.analysis.common.utils.MarketingUtils;
import com.gooagoo.analysis.complement.service.ComplementCommonService;
import com.gooagoo.analysis.complement.service.ComplementControlService;
import com.gooagoo.analysis.complement.service.ComplementService;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.RuleInput;
import com.gooagoo.analysis.init.PretreatmentRule;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.SpringBeanUtils;
import com.gooagoo.exception.GooagooException;

@Service
public class ComplementControlServiceImpl implements ComplementControlService
{

    @Autowired
    private ComplementCommonService complementCommonService;

    /**
    *
    * @param behave(0-消费,1-到店,2-到达区域,3-关注,4-申请会员卡,5-申请物理卡转换,6-评论,7-留言,8-收藏,9-浏览,A-使用服务,B-分享,D-下订单,E-申请结帐)
    * @return(时间段,会员等级,来源（手机/网站）,当天次数,累计次数,品类,品牌,商品,金额,区域,时长,服务类型,活动,事件,优惠凭证,虚拟商家店面)
    * @throws Exception
    */
    @Override
    public RuleInput doComplement(Behave behave) throws Exception
    {
        RuleInput ruleInput = new RuleInput();
        Set<String> pretreatmentRule = PretreatmentRule.getPretreatmentRule(behave.getShopId(), behave.getBehaveType());
        if (CollectionUtils.isEmpty(pretreatmentRule))
        {
            GooagooLog.warn("此商家预处理规则参数不存在，shopid：" + behave.getShopId() + ",actionType:" + behave.getBehaveType());
            throw new GooagooException("此商家预处理规则参数不存在，shopid：" + behave.getShopId() + ",actionType:" + behave.getBehaveType());
        }
        /**
         * 封装通用的规则属性RuleInput
         */
        ruleInput.setShopId(behave.getShopId());//商家编号
        ruleInput.setActionType(behave.getBehaveType());//行为类型
        if (pretreatmentRule.contains("eventDate") && behave.getBehaveTime() != null)//时间段-日期
        {
            ruleInput.setEventDate(MarketingUtils.getEventDateRuleProperties(behave.getBehaveTime()));
        }
        if (pretreatmentRule.contains("eventTime") && behave.getBehaveTime() != null)//时间段-时间
        {
            ruleInput.setEventTime(MarketingUtils.getEventTimeRuleProperties(behave.getBehaveTime()));
        }
        if (pretreatmentRule.contains("eventWeek") && behave.getBehaveTime() != null)//时间段-周
        {
            ruleInput.setEventWeek(MarketingUtils.getEventWeekRuleProperties(behave.getBehaveTime()));
        }
        if (pretreatmentRule.contains("vipGrade"))//会员等级
        {
            String vipGrade = this.complementCommonService.getMemberLevelRuleProperties(behave.getUserId(), behave.getShopId(), behave.getScardno());
            ruleInput.setVipGrade(vipGrade);
        }
        if (pretreatmentRule.contains("actionSource"))//行为来源：M-手机，W-网站
        {
            ruleInput.setActionSource(behave.getSource());
        }
        if (pretreatmentRule.contains("duration"))//当前时长（以秒为单位）
        {
            ruleInput.setDuration(behave.getDuration());
        }
        if (pretreatmentRule.contains("position"))//行为发生区域编号
        {
            ruleInput.setPosition(behave.getPositionId());
        }
        /**
         * 封装差异性的规则属性RuleInput
         */
        ComplementService complementService = (ComplementService) SpringBeanUtils.getBean("behave" + behave.getBehaveType() + "ComplementService");
        return complementService.doComplement(ruleInput, behave);
    }
}
