package com.gooagoo.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gooagoo.service.CrmService;

/**
 * 3.6  会员积分明细查询
 *      入参：物理卡号、时间区间
 *    返回：积分变动量、积分来源、积分变动时间、变动原因
 */
@Service("crm06")
public class CRMA06ServiceImpl implements CrmService
{

    @Override
    public String doService(HttpServletRequest request) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

}
