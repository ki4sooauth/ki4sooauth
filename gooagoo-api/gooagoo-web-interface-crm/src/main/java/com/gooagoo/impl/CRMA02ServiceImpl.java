package com.gooagoo.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gooagoo.service.CrmService;

/**
 * 3.2 会员信息查询（单个）
 *   入参：物理卡号
 *     返回：姓名、性别、出生日期、证件类型、证件号码、手机号码、联系电话、电子邮箱、邮政编码、通讯地址、会员级别
 */
@Service("crm02")
public class CRMA02ServiceImpl implements CrmService
{

    @Override
    public String doService(HttpServletRequest request) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

}
