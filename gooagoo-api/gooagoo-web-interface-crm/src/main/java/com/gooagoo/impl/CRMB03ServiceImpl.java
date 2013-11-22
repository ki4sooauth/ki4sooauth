package com.gooagoo.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gooagoo.service.CrmService;

/**
 * 3.10  商品列表查询
 *      入参：商品名称、品类编码、品牌编码 
 *    返回：商品编码、商品名称、商品价格、品类编码、品类名称、品牌编码、品牌名称
 */
@Service("crmb03")
public class CRMB03ServiceImpl implements CrmService
{

    @Override
    public String doService(HttpServletRequest request) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

}
