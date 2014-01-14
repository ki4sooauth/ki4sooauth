package com.gooagoo.authzserver.api;

import com.gooagoo.authzserver.entity.request.CodeRequest;
import com.gooagoo.entity.business.auth.CodeResponse;

public interface CodeService
{
    /**
     * 得到临时token
     */
    public CodeResponse getAuthzCode(CodeRequest codeRequest);
}
