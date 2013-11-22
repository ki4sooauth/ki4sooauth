package com.gooagoo.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gooagoo.service.CrmService;

/**
 * 3.5  会员积分变动
 *      入参：物理卡号、积分变动量、变动原因
 *    返回：成功/失败
 */
@Service("crm05")
public class CRMA05ServiceImpl implements CrmService
{

    @Override
    public String doService(HttpServletRequest request) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

}
