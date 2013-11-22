package com.gooagoo.api.business.core.member.crm;

import com.gooagoo.entity.generator.member.MemberBaseInfo;

public interface CrmMemberCoreService
{
    /**
     * 从商家获取会员物理卡号
     * @param MemberBaseInfo
     * @return phyNo
     * @throws Exception
     */
    public String getPhyNoFromShop(MemberBaseInfo memberBaseInfo) throws Exception;
}
