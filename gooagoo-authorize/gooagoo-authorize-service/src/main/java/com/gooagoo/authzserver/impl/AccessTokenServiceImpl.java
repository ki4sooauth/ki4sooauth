package com.gooagoo.authzserver.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.authzserver.OAuthParam;
import com.gooagoo.authzserver.api.ApplyBusinessService;
import com.gooagoo.authzserver.api.CodeGeneratorService;
import com.gooagoo.authzserver.entity.InterfaceUtils;
import com.gooagoo.authzserver.entity.IssuerTransData;
import com.gooagoo.authzserver.entity.token.AccessTokenBusiness;
import com.gooagoo.authzserver.service.IAuthIssuerService;
import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.common.NullException;

/**
 * 请求访问token
 */
@Service("authorization_code")
public class AccessTokenServiceImpl implements IAuthIssuerService
{

    @Autowired
    private CodeGeneratorService codeGeneratorService;
    @Autowired
    private ApplyBusinessService applyBusinessService;

    @Override
    public String doIAuthIssuer(HttpServletRequest request) throws Exception
    {
        AccessTokenBusiness accessTokenBusiness = new AccessTokenBusiness();
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String clientId = parameter.getString(OAuthParam.OAUTH_CLIENT_ID);
            String clientSecret = parameter.getString(OAuthParam.OAUTH_CLIENT_SECRET);
            String redirectUri = parameter.getString(OAuthParam.OAUTH_REDIRECT_URI);
            String grantType = parameter.getString(OAuthParam.OAUTH_GRANT_TYPE);
            String code = parameter.getString(OAuthParam.OAUTH_CODE);
            if (!StringUtils.isBlank(clientId))
            {
                if (this.applyBusinessService.getApplyBusiness(clientId) == null)
                {
                    throw new NullException("clientId不能为空");
                }
            }
            if (!StringUtils.isBlank(clientSecret))
            {
                if (this.applyBusinessService.getApplyBusiness(clientSecret) == null)
                {
                    throw new NullException("clientSecret不能为空");
                }
            }
            if (StringUtils.isBlank(redirectUri))
            {
                throw new NullException("redirectUri不能为空");
            }
            if (!StringUtils.isBlank(grantType))
            {
                if (grantType != OAuthParam.OAUTH_AUTHORIZATION_CODE)
                {
                    throw new NullException("grantType不能为空");
                }
            }
            if (!StringUtils.isBlank(code))
            {
                if (code != OAuthParam.OAUTH_CODE)
                {
                    throw new NullException("code不能为空");
                }
            }
            accessTokenBusiness.setAccesstoken(this.codeGeneratorService.generateValue());
            accessTokenBusiness.setRedirecturi(redirectUri);
            accessTokenBusiness.setExpiresin("1234567");

        }
        catch (NullException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            accessTokenBusiness.setMsg(err);
            accessTokenBusiness.setMsgcode(e.getMessage());
        }
        IssuerTransData IssuerTransData = new IssuerTransData();
        IssuerTransData.setResultJson(accessTokenBusiness.toJson());
        return accessTokenBusiness.toJson();
    }
}
