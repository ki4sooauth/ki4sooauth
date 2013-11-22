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
 * 行为类型：8-收藏
 * 通用规则属性（已在上层处理）：时间段,会员等级,来源（手机app、手机网站、个人中心、位置引擎 、转发器、店员助理）
 * 差异性的规则属性：品类,品牌,商品,活动,当天次数（暂不处理）,累计次数（暂不处理）
 * 品类：商品对应各级品类      
 * 品牌：商品对应品牌
 * 商品：商品对应自定义序列号
 * 活动：活动编号
 * objectValue：objectType为“A”时活动编号
 */
@Service("behave8ComplementService")
public class Behave8ComplementServiceImpl implements ComplementService
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