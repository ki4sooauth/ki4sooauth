package com.gooagoo.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gooagoo.service.CrmService;

/**
 * 3.3  会员信息查询（多个）
 *     入参：姓名、性别、出生日期、证件类型、证件号码、手机号码、联系电话、电子邮箱、邮政编码、会员级别
 *     返回：物理卡号（多个）
 */
@Service("crm03")
public class CRMA03ServiceImpl implements CrmService
{

    @Override
    public String doService(HttpServletRequest request) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

}
