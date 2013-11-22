package com.gooagoo.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gooagoo.service.CrmService;

/**
 * 3.11  查询商品详情
 *      入参：商品编号
 *    返回：名称、价格、图片地址、品类编码、品类名称、品牌编码、品牌名称、库存、陈列位置、商品特征信息
 */
@Service("crmb04")
public class CRMB04ServiceImpl implements CrmService
{

    @Override
    public String doService(HttpServletRequest request) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

}
