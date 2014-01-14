package com.gooagoo.authzserver.api;

import com.gooagoo.authzserver.entity.request.AccessTokenRequest;
import com.gooagoo.authzserver.entity.request.RefreshTokenRequest;
import com.gooagoo.entity.business.auth.AccessTokenResponse;
import com.gooagoo.entity.business.auth.RefreshTokenResponse;

public interface TokenService
{
    /**
     * 得到访问code
     */
    public AccessTokenResponse getAccessCode(AccessTokenRequest accessTokenRequest);

    /**
     * 得到刷新code
     */
    public RefreshTokenResponse getRefreshCode(RefreshTokenRequest refreshTokenRequest);
}
