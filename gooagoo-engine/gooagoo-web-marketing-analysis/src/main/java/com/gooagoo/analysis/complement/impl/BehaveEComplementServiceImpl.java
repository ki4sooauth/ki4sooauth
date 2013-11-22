package com.gooagoo.analysis.complement.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.analysis.complement.service.ComplementService;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.RuleInput;
import com.gooagoo.analysis.init.PretreatmentRule;
import com.gooagoo.api.generator.query.bill.OrderDetailInfoGeneratorQueryService;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;

/**
 * E-申请结帐[时间段,会员等级,来源（手机/网站）,当天次数,累计次数,金额]
 */
@Service("behaveEComplementService")
public class BehaveEComplementServiceImpl implements ComplementService
{
    @Autowired
    private OrderDetailInfoGeneratorQueryService orderDetailInfoGeneratorQueryService;

    @Override
    public RuleInput doComplement(RuleInput ruleInput, Behave behave) throws Exception
    {
        Set<String> pretreatmentRule = PretreatmentRule.getPretreatmentRule(behave.getShopId(), behave.getBehaveType());
        if (!pretreatmentRule.contains("consumeMoney"))
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
        double totalPrice = 0.00;
        for (OrderDetailInfo orderDetailInfo : OrderDetailInfoList)
        {
            totalPrice = totalPrice + orderDetailInfo.getTotalPrice();
        }
        //  金额
        ruleInput.setConsumeMoney(totalPrice);
        // TODO 当天次数,累计次数
        return ruleInput;
    }

}