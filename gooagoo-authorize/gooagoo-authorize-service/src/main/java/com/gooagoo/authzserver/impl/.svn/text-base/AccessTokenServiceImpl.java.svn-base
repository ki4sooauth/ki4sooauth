package com.gooagoo.authzserver.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.authzserver.api.TokenService;
import com.gooagoo.authzserver.entity.request.AccessTokenRequest;
import com.gooagoo.authzserver.service.IAuthService;
import com.gooagoo.entity.business.auth.AccessTokenResponse;

/**
 * 请求访问token
 */
@Service("authorization_code")
public class AccessTokenServiceImpl implements IAuthService
{
    @Autowired
    private TokenService tokenService;

    @Override
    public AccessTokenResponse doIAuthIssuer(HttpServletRequest request) throws Exception
    {
        AccessTokenRequest accessTokenRequest = new AccessTokenRequest();
        accessTokenRequest.init(request);
        AccessTokenResponse accessTokenResponse = this.tokenService.getAccessCode(accessTokenRequest);
        return accessTokenResponse;

    }
}
