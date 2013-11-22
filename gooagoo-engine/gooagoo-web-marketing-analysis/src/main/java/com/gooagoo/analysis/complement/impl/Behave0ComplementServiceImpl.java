package com.gooagoo.analysis.complement.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.analysis.complement.service.ComplementCommonService;
import com.gooagoo.analysis.complement.service.ComplementService;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.GoodsInfoRuleProperties;
import com.gooagoo.analysis.entity.RuleInput;
import com.gooagoo.analysis.init.PretreatmentRule;
import com.gooagoo.api.generator.query.bill.OrderDetailInfoGeneratorQueryService;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;

/**
 * 行为类型：0-消费
 * 通用规则属性（已在上层处理）：时间段,会员等级,来源（手机app、手机网站、个人中心、位置引擎 、转发器、店员助理）
 * 差异性的规则属性：品类,品牌,商品,金额、当天次数（暂不处理）,累计次数（暂不处理）
 * 品类：商品对应各级品类      
 * 品牌：商品对应品牌
 * 商品：商品对应自定义序列号
 * 金额：本次消费实际支付金额
 * behave.getObjectValue()：订单编号orderid
 */
@Service("behave0ComplementService")
public class Behave0ComplementServiceImpl implements ComplementService
{
    @Autowired
    private ComplementCommonService complementCommonService;

    @Autowired
    private OrderDetailInfoGeneratorQueryService orderDetailInfoGeneratorQueryService;

    @Override
    public RuleInput doComplement(RuleInput ruleInput, Behave behave) throws Exception
    {
        Set<String> pretreatmentRule = PretreatmentRule.getPretreatmentRule(behave.getShopId(), behave.getBehaveType());
        if (!pretreatmentRule.contains("marketingGoods") && !pretreatmentRule.contains("marketingGoodsCategory") && !pretreatmentRule.contains("marketingGoodsBrand") && !pretreatmentRule.contains("consumeMoney"))
        {
            return ruleInput;
        }
        OrderDetailInfoExample orderDetailInfoExample = new OrderDetailInfoExample();
        orderDetailInfoExample.createCriteria().andOrderIdEqualTo(behave.getObjectValue());
        List<OrderDetailInfo> OrderDetailInfoList = this.orderDetailInfoGeneratorQueryService.selectByExample(orderDetailInfoExample);
        if (CollectionUtils.isEmpty(OrderDetailInfoList))
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
        double totalPrice = 0.00;
        List<String> goodsIdList = new ArrayList<String>();
        for (OrderDetailInfo orderDetailInfo : OrderDetailInfoList)
        {
            goodsIdList.add(orderDetailInfo.getGoodsId());
            totalPrice = totalPrice + orderDetailInfo.getTotalPrice();
        }
        GoodsInfoRuleProperties GoodsInfoRuleProperties = this.complementCommonService.getGoodsInfoRuleProperties(goodsIdList, type);
        //  品类
        ruleInput.setMarketingGoodsCategory(GoodsInfoRuleProperties.getCategoryIdList());
        //  品牌
        ruleInput.setMarketingGoodsBrand(GoodsInfoRuleProperties.getBrandIdList());
        //  商品
        ruleInput.setMarketingGoods(GoodsInfoRuleProperties.getItemSerialList());
        //  金额
        ruleInput.setConsumeMoney(totalPrice);
        // TODO 当天次数,累计次数
        return ruleInput;
    }
}
