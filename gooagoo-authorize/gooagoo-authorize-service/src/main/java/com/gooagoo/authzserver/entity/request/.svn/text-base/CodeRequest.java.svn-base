package com.gooagoo.authzserver.entity.request;

import java.io.Serializable;

import com.gooagoo.authzserver.entity.AbstractBasicObject;
import com.gooagoo.authzserver.exception.RequestValidationUtils;
import com.gooagoo.authzserver.exception.ValidationException;

/**
 * 访问code
 */
public class CodeRequest extends AbstractBasicObject implements Serializable
{
    private static final long serialVersionUID = 1L;
    /**
     * 客户端id
     */
    private String clientId;
    /**
     * 授权类型，此值固定为“code” 
     */
    private String responseType;
    /**
     * 可进行授权的列表
     */
    private String scope;

    public String getClientId()
    {
        return this.clientId;
    }

    public void setClientId(String clientId)
    {
        this.clientId = clientId;
    }

    public String getResponseType()
    {
        return this.responseType;
    }

    public void setResponseType(String responseType)
    {
        this.responseType = responseType;
    }

    public String getScope()
    {
        return this.scope;
    }

    public void setScope(String scope)
    {
        this.scope = scope;
    }

    @Override
    public void check() throws ValidationException
    {
        RequestValidationUtils.checkIsEmpty(this.clientId, "clientId");
        RequestValidationUtils.checkIsEmpty(this.responseType, "responseType");
    }

    @Override
    public String toString()
    {
        return "CodeRequest [clientId=" + this.clientId + ", responseType=" + this.responseType + ", scope=" + this.scope + "]";
    }

}
