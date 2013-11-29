package com.gooagoo.authzserver.api;

import com.gooagoo.authzserver.entity.business.OauthCodeBusiness;
import com.gooagoo.authzserver.entity.business.OpenAppInfoBusiness;
import com.gooagoo.authzserver.entity.business.OpenUserTokenRelBusiness;

/**
 * 授权核心处理
 */
public interface AuthzBusinessService
{
    /**
     * 获取应用的appKey,appSecret
     */
    public OpenAppInfoBusiness getOpenAppInfoBusiness(OpenAppInfoBusiness openAppInfoBusiness);

    /**
     * 获取临时token 
     */
    public OauthCodeBusiness getOauthCodeBusiness(OauthCodeBusiness oauthCodeBusiness);

    /**
     * 添加临时token
     */
    public void addOauthCode(OauthCodeBusiness oauthCodeBusiness);

    /**
     * 获取访问token
     */
    public OpenUserTokenRelBusiness getOpenUserTokenRelBusiness(OpenUserTokenRelBusiness openUserTokenRelBusiness);

    /**
     * 添加访问token
     */
    public void addOpenUserTokenRel(OpenUserTokenRelBusiness openUserTokenRelBusiness);
}
