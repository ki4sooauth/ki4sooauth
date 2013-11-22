package com.gooagoo.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gooagoo.service.CrmService;

/**
 * 3.13    查询线上订单
 *      入参：时间段（起始时间-结束时间）
 *    返回：订单编号、订单状态、电商账号、商品编号、商品单价、订单总价、实际支付价格、折扣、下订单时间、支付时间、订单图片
 */
@Service("crmc02")
public class CRMC02ServiceImpl implements CrmService
{

    @Override
    public String doService(HttpServletRequest request) throws Exception
    {
        // TODO Auto-generated method stub

        return null;
    }

}
