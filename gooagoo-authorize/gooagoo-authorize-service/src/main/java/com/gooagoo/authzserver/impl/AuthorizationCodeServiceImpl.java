package com.gooagoo.authzserver.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.authzserver.api.CodeService;
import com.gooagoo.authzserver.entity.request.CodeRequest;
import com.gooagoo.authzserver.service.IAuthService;
import com.gooagoo.entity.business.auth.CodeResponse;

/**
 * 请求授权code
 */
@Service("code")
public class AuthorizationCodeServiceImpl implements IAuthService
{
    @Autowired
    private CodeService codeService;

    @Override
    public CodeResponse doIAuthIssuer(HttpServletRequest request) throws Exception
    {
        CodeRequest codeRequest = new CodeRequest();
        codeRequest.init(request);
        CodeResponse codeResponse = this.codeService.getAuthzCode(codeRequest);
        return codeResponse;
    }
}
