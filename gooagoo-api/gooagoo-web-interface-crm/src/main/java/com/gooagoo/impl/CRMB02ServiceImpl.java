package com.gooagoo.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gooagoo.service.CrmService;

/**
 * 3.9  品牌查询
 *      入参： 无
 *    返回：品牌编码、品牌名称、图片URL、排序、陈列位置
 */
@Service("crmb02")
public class CRMB02ServiceImpl implements CrmService
{

    @Override
    public String doService(HttpServletRequest request) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

}
