package com.gooagoo.core.business.member.crm;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.member.crm.CrmMemberCoreService;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.member.MemberBaseInfo;

@Service
public class CrmMemberCoreServiceImpl implements CrmMemberCoreService
{

    @Override
    public String getPhyNoFromShop(MemberBaseInfo memberBaseInfo) throws Exception
    {
        //等CRM系统开发再完善、临时写死
        return UUID.getUUID();
    }

}
