package com.gooagoo.analysis.complement.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.analysis.complement.service.ComplementCommonService;
import com.gooagoo.analysis.complement.service.ComplementService;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.GoodsInfoRuleProperties;
import com.gooagoo.analysis.entity.RuleInput;
import com.gooagoo.analysis.init.PretreatmentRule;

/**
 * A-使用服务[时间段,会员等级,当天次数,累计次数,商品,服务类型]
 */
@Service("behaveAComplementService")
public class BehaveAComplementServiceImpl implements ComplementService
{
    @Autowired
    private ComplementCommonService complementCommonService;

    @Override
    public RuleInput doComplement(RuleInput ruleInput, Behave behave) throws Exception
    {
        Set<String> pretreatmentRule = PretreatmentRule.getPretreatmentRule(behave.getShopId(), behave.getBehaveType());
        if (pretreatmentRule.contains("serverTools") && StringUtils.hasText(behave.getObjectValue()))//服务工具编号
        {
            ruleInput.setServerTools(behave.getObjectValue());
        }
        if (!pretreatmentRule.contains("marketingGoods") || !StringUtils.hasText(behave.getDetail()))
        {
            return ruleInput;
        }
        List<String> goodsIdList = new ArrayList<String>();
        goodsIdList.add(behave.getDetail());//behave.getDetail()存放goodsid
        GoodsInfoRuleProperties GoodsInfoRuleProperties = this.complementCommonService.getGoodsInfoRuleProperties(goodsIdList, "1");
        //  商品
        ruleInput.setMarketingGoods(GoodsInfoRuleProperties.getItemSerialList());
        // TODO 当天次数,累计次数、服务类型
        return ruleInput;
    }

}