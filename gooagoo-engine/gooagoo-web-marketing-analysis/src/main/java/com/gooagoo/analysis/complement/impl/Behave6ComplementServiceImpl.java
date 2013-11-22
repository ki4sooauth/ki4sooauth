package com.gooagoo.analysis.complement.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.analysis.complement.service.ComplementCommonService;
import com.gooagoo.analysis.complement.service.ComplementService;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.GoodsInfoRuleProperties;
import com.gooagoo.analysis.entity.RuleInput;
import com.gooagoo.analysis.init.PretreatmentRule;

/**
 * 行为类型：6-评论
 * 通用规则属性（已在上层处理）：时间段,会员等级,来源（手机app、手机网站、个人中心、位置引擎 、转发器、店员助理）
 * 差异性的规则属性：品类,品牌,商品,当天次数（暂不处理）,累计次数（暂不处理）
 * 品类：商品对应各级品类      
 * 品牌：商品对应品牌
 * 商品：商品对应自定义序列号
 * 金额：本次消费实际支付金额
 * behave.getObjectValue()值为：商品编号goodsid
 */
@Service("behave6ComplementService")
public class Behave6ComplementServiceImpl implements ComplementService
{
    @Autowired
    private ComplementCommonService complementCommonService;

    @Override
    public RuleInput doComplement(RuleInput ruleInput, Behave behave) throws Exception
    {
        Set<String> pretreatmentRule = PretreatmentRule.getPretreatmentRule(behave.getShopId(), behave.getBehaveType());
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
        // TODO 当天次数,累计次数
        return ruleInput;
    }

}