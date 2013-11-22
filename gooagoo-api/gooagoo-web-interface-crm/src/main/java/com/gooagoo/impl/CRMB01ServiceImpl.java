package com.gooagoo.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gooagoo.service.CrmService;

/**
 * 3.8 品类查询
 *      入参： 无
 *    返回：品类编码、品类名称、父品类编码、图片URL、排序、陈列位置
 */
@Service("crmb01")
public class CRMB01ServiceImpl implements CrmService
{

    @Override
    public String doService(HttpServletRequest request) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

}
