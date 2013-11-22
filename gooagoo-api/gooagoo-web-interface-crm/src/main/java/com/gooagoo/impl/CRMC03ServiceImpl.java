package com.gooagoo.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gooagoo.service.CrmService;

/**
 * 3.14 提交用户网购订单接口
 *      入参：商品编号、电商账号
 *    返回：订单号
 */
@Service("crmc03")
public class CRMC03ServiceImpl implements CrmService
{

    @Override
    public String doService(HttpServletRequest request) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

}
