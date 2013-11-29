package com.gooagoo.authzserver.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.authzserver.OAuthParam;
import com.gooagoo.authzserver.api.AuthzBusinessService;
import com.gooagoo.authzserver.api.CodeGeneratorService;
import com.gooagoo.authzserver.entity.InterfaceUtils;
import com.gooagoo.authzserver.entity.IssuerTransData;
import com.gooagoo.authzserver.entity.business.OpenAppInfoBusiness;
import com.gooagoo.authzserver.entity.code.AuthorizationBusiness;
import com.gooagoo.authzserver.service.IAuthIssuerService;
import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.common.NullException;

/**
 * 请求授权code
 */
@Service("code")
public class AuthorizationCodeServiceImpl implements IAuthIssuerService
{
    @Autowired
    private CodeGeneratorService codeGeneratorService;
    @Autowired
    private AuthzBusinessService applyBusinessService;

    @Override
    public String doIAuthIssuer(HttpServletRequest request) throws Exception
    {
        AuthorizationBusiness authorizationBusiness = new AuthorizationBusiness();
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String clientId = parameter.getString(OAuthParam.OAUTH_CLIENT_ID);
            String redirectUri = parameter.getString(OAuthParam.OAUTH_REDIRECT_URI);
            String responseType = parameter.getString(OAuthParam.OAUTH_RESPONSE_TYPE);
            String scope = parameter.getString(OAuthParam.OAUTH_SCOPE);
            OpenAppInfoBusiness openAppInfoBusiness = new OpenAppInfoBusiness();
            openAppInfoBusiness.setAppKey(clientId);
            if (openAppInfoBusiness != null)
            {
                if (this.applyBusinessService.getOpenAppInfoBusiness(openAppInfoBusiness) == null)
                {
                    throw new NullException("openAppInfoBusiness不能为空");
                }
            }
            if (StringUtils.isBlank(redirectUri))
            {
                throw new NullException("redirectUri不能为空");
            }
            if (!StringUtils.isBlank(responseType))
            {
                if (responseType != OAuthParam.OAUTH_CODE)
                {
                    throw new NullException("responseType不能为空");
                }
            }
            authorizationBusiness.setAuthorizationcode(this.codeGeneratorService.generateValue());
            authorizationBusiness.setRedirecturi(redirectUri);
        }
        catch (NullException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            authorizationBusiness.setMsg(err);
            authorizationBusiness.setMsgcode(e.getMessage());
        }
        IssuerTransData IssuerTransData = new IssuerTransData();
        IssuerTransData.setResultJson(authorizationBusiness.toJson());
        return authorizationBusiness.toJson();
    }
}
