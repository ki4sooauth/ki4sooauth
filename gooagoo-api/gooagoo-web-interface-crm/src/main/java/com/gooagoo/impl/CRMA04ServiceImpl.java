package com.gooagoo.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gooagoo.service.CrmService;

/**
 * 3.4  会员级别变动
 *      此接口对应购阿购平台的会员卡升级、特批。
 *    入参：物理卡号、原级别、变动后级别、变动原因
 *    返回：成功/失败
 */
@Service("crm04")
public class CRMA04ServiceImpl implements CrmService
{

    @Override
    public String doService(HttpServletRequest request) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

}
