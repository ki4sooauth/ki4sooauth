package com.gooagoo.analysis.complement.impl;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.analysis.complement.service.ComplementService;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.RuleInput;
import com.gooagoo.analysis.init.PretreatmentRule;

/**
 * H-使用优惠凭证[时间段,会员等级,来源（手机/网站）,当天次数,累计次数,金额]
 */
@Service("behaveHComplementService")
public class BehaveHComplementServiceImpl implements ComplementService
{
    @Override
    public RuleInput doComplement(RuleInput ruleInput, Behave behave) throws Exception
    {
        Set<String> pretreatmentRule = PretreatmentRule.getPretreatmentRule(behave.getShopId(), behave.getBehaveType());
        if (StringUtils.hasText(behave.getObjectType()))
        {
            if ("C".equals(behave.getObjectType()))//优惠凭证
            {
                if (!pretreatmentRule.contains("marketingCoupon"))
                {
                    return ruleInput;
                }
                ruleInput.setMarketingCoupon(behave.getObjectValue());
            }
        }
        // TODO 当天次数,累计次数
        return ruleInput;
    }

}