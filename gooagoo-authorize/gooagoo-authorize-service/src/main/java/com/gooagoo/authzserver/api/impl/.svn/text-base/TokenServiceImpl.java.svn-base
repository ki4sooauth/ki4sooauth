package com.gooagoo.authzserver.api.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.gooagoo.api.generator.core.open.OauthCodeGeneratorCoreService;
import com.gooagoo.api.generator.core.open.OpenUserTokenRelGeneratorCoreService;
import com.gooagoo.authzserver.api.TokenService;
import com.gooagoo.authzserver.entity.request.AccessTokenRequest;
import com.gooagoo.authzserver.entity.request.RefreshTokenRequest;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.auth.AccessTokenResponse;
import com.gooagoo.entity.business.auth.RefreshTokenResponse;
import com.gooagoo.entity.generator.open.OauthCode;
import com.gooagoo.entity.generator.open.OauthCodeExample;
import com.gooagoo.entity.generator.open.OpenUserTokenRel;
import com.gooagoo.entity.generator.open.OpenUserTokenRelExample;

@Service
public class TokenServiceImpl implements TokenService
{
    @Autowired
    private OauthCodeGeneratorCoreService oauthCodeGeneratorCoreService;
    @Autowired
    private OpenUserTokenRelGeneratorCoreService openUserTokenRelGeneratorCoreService;

    @SuppressWarnings("unused")
    @Override
    public AccessTokenResponse getAccessCode(AccessTokenRequest accessTokenRequest)
    {
        OauthCodeExample oauthCodeExample = new OauthCodeExample();
        oauthCodeExample.createCriteria().andCodeEqualTo(accessTokenRequest.getCode()).andAppKeyEqualTo(accessTokenRequest.getClientId());
        List<OauthCode> oauthCodeList = this.oauthCodeGeneratorCoreService.selectByExample(oauthCodeExample);
        if (CollectionUtils.isEmpty(oauthCodeList))
        {
            AccessTokenResponse accessTokenResponse = new AccessTokenResponse();
            accessTokenResponse.setAccesstoken(UUID.getUUID());
            Date d = new Date();
            Date expiresin = new Date(d.getTime() + 2 * 24 * 60 * 60 * 1000);
            accessTokenResponse.setExpiresin(String.valueOf(expiresin.getTime()));
            if (accessTokenResponse == null)
            {
                GooagooLog.info("accessToken设置失败");
            }
            OpenUserTokenRel openUserTokenRels = new OpenUserTokenRel();
            openUserTokenRels.setAppKey(Integer.valueOf(accessTokenRequest.getClientId()));
            openUserTokenRels.setExpireTime(expiresin);
            openUserTokenRels.setTokenId(accessTokenResponse.getAccesstoken());
            if (openUserTokenRels == null)
            {
                GooagooLog.info("openUserTokenRel设置失败");
            }
            boolean result = this.openUserTokenRelGeneratorCoreService.insertSelective(openUserTokenRels);
            if (!result)
            {
                GooagooLog.info("添加临时token失败");
            }
            return accessTokenResponse;
        }
        else
        {
            for (OauthCode oauthCode : oauthCodeList)
            {
                if ((oauthCode.getExpireTime().getTime() - new Date().getTime()) >= 0)
                {
                    OpenUserTokenRelExample openUserTokenRelExample = new OpenUserTokenRelExample();
                    openUserTokenRelExample.createCriteria().andAppKeyEqualTo(accessTokenRequest.getClientId());
                    List<OpenUserTokenRel> openUserTokenRelList = this.openUserTokenRelGeneratorCoreService.selectByExample(openUserTokenRelExample);
                    if (CollectionUtils.isEmpty(openUserTokenRelList))
                    {
                        GooagooLog.info("openUserTokenRel为空");
                    }
                    for (OpenUserTokenRel openUserTokenRel : openUserTokenRelList)
                    {
                        AccessTokenResponse accessTokenResponse = new AccessTokenResponse();
                        if (openUserTokenRel.getExpireTime().getTime() - new Date().getTime() >= 0)
                        {
                            accessTokenResponse.setAccesstoken(openUserTokenRel.getTokenId());
                            accessTokenResponse.setExpiresin(String.valueOf(openUserTokenRel.getExpireTime()));
                            return accessTokenResponse;
                        }
                        accessTokenResponse.setAccesstoken(UUID.getUUID());
                        Date d = new Date();
                        Date expiresin = new Date(d.getTime() + 2 * 24 * 60 * 60 * 1000);
                        accessTokenResponse.setExpiresin(String.valueOf(expiresin.getTime()));
                        if (accessTokenResponse == null)
                        {
                            GooagooLog.info("accessToken设置失败");
                        }
                        OpenUserTokenRel openUserTokenRels = new OpenUserTokenRel();
                        openUserTokenRels.setAppKey(Integer.valueOf(accessTokenRequest.getClientId()));
                        openUserTokenRels.setExpireTime(expiresin);
                        openUserTokenRels.setTokenId(accessTokenResponse.getAccesstoken());
                        if (openUserTokenRels == null)
                        {
                            GooagooLog.info("openUserTokenRel设置失败");
                        }
                        boolean result = this.openUserTokenRelGeneratorCoreService.insertSelective(openUserTokenRels);
                        if (!result)
                        {
                            GooagooLog.info("添加临时token失败");
                        }
                        return accessTokenResponse;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public RefreshTokenResponse getRefreshCode(RefreshTokenRequest refreshTokenRequest)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public static void main(String[] args)
    {
        Date d = new Date();
        Date expiresin = new Date(d.getTime() + 10 * 60 * 1000);
        System.out.println(expiresin);
    }
}
