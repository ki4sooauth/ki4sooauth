package com.gooagoo.authzserver.api.impl;

import org.springframework.stereotype.Service;

import com.gooagoo.authzserver.api.AuthzBusinessService;
import com.gooagoo.authzserver.entity.business.OauthCodeBusiness;
import com.gooagoo.authzserver.entity.business.OpenAppInfoBusiness;
import com.gooagoo.authzserver.entity.business.OpenUserTokenRelBusiness;

@Service
public class AuthzBusinessServiceImpl implements AuthzBusinessService
{

    @Override
    public OpenAppInfoBusiness getOpenAppInfoBusiness(OpenAppInfoBusiness applyBusiness)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public OauthCodeBusiness getOauthCodeBusiness(OauthCodeBusiness oauthCodeBusiness)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addOauthCode(OauthCodeBusiness oauthCodeBusiness)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public OpenUserTokenRelBusiness getOpenUserTokenRelBusiness(OpenUserTokenRelBusiness openUserTokenRelBusiness)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addOpenUserTokenRel(OpenUserTokenRelBusiness openUserTokenRelBusiness)
    {
        // TODO Auto-generated method stub

    }

}
