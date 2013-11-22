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
 * 9-浏览[时间段,会员等级,来源（手机/网站）,当天次数,累计次数,品类,品牌,商品,活动,事件,优惠凭证,虚拟商家店面]
 */
@Service("behave9ComplementService")
public class Behave9ComplementServiceImpl implements ComplementService
{
    @Autowired
    private ComplementCommonService complementCommonService;

    @Override
    public RuleInput doComplement(RuleInput ruleInput, Behave behave) throws Exception
    {
        Set<String> pretreatmentRule = PretreatmentRule.getPretreatmentRule(behave.getShopId(), behave.getBehaveType());
        if (StringUtils.hasText(behave.getObjectType()))
        {
            if ("A".equals(behave.getObjectType()))//活动
            {
                if (!pretreatmentRule.contains("marketingActivity"))
                {
                    return ruleInput;
                }
                ruleInput.setMarketingActivity(behave.getObjectValue());
            }
            if ("C".equals(behave.getObjectType()))//优惠凭证
            {
                if (!pretreatmentRule.contains("marketingCoupon"))
                {
                    return ruleInput;
                }
                ruleInput.setMarketingCoupon(behave.getObjectValue());
            }
            if ("Y".equals(behave.getObjectType()) || "N".equals(behave.getObjectType()) || "Q".equals(behave.getObjectType()) || "M".equals(behave.getObjectType()) || "S".equals(behave.getObjectType()))
            {
                if (!pretreatmentRule.contains("marketingEvent"))
                {
                    return ruleInput;
                }
                ruleInput.setMarketingEvent(behave.getObjectValue());//营销内容
            }
            if ("0".equals(behave.getObjectType()))//cms栏目
            {
                if (!pretreatmentRule.contains("cmsContent"))
                {
                    return ruleInput;
                }
                ruleInput.setCmsContent(behave.getObjectValue());
            }
            if ("G".equals(behave.getObjectType()))//商品
            {
                if (!pretreatmentRule.contains("marketingGoods") && !pretreatmentRule.contains("marketingGoodsCategory") && !pretreatmentRule.contains("marketingGoodsBrand"))
                {
                    return ruleInput;
                }
                String type = "";
                if (pretreatmentRule.contains("marketingGoods"))
                {
                    type = "1";
                }
                if (pretreatmentRule.contains("marketingGoodsCategory"))
                {
                    type = type + "2";
                }
                if (pretreatmentRule.contains("marketingGoodsBrand"))
                {
                    type = type + "3";
                }
                List<String> goodsIdList = new ArrayList<String>();
                goodsIdList.add(behave.getObjectValue());
                GoodsInfoRuleProperties GoodsInfoRuleProperties = this.complementCommonService.getGoodsInfoRuleProperties(goodsIdList, type);
                //  品类
                ruleInput.setMarketingGoodsCategory(GoodsInfoRuleProperties.getCategoryIdList());
                //  品牌
                ruleInput.setMarketingGoodsBrand(GoodsInfoRuleProperties.getBrandIdList());
                //  商品
                ruleInput.setMarketingGoods(GoodsInfoRuleProperties.getItemSerialList());
            }
        }
        // TODO 当天次数,累计次数
        return ruleInput;
    }

}