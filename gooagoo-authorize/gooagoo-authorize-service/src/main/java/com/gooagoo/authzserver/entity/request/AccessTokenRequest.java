package com.gooagoo.authzserver.entity.request;

import java.io.Serializable;

import com.gooagoo.authzserver.entity.AbstractBasicObject;
import com.gooagoo.authzserver.exception.RequestValidationUtils;
import com.gooagoo.authzserver.exception.ValidationException;

/**
 * 访问token
 */
public class AccessTokenRequest extends AbstractBasicObject implements Serializable
{
    private static final long serialVersionUID = 1L;

    /**
     * 客户端id
     */
    private String clientId;
    /**
     * 客户端密钥
     */
    private String clientSecret;
    /**
     * 授权类型，此值固定为“authorization_code”
     */
    private String grantType;
    /**
     * 访问code
     */
    private String code;

    public String getClientId()
    {
        return this.clientId;
    }

    public void setClientId(String clientId)
    {
        this.clientId = clientId;
    }

    public String getClientSecret()
    {
        return this.clientSecret;
    }

    public void setClientSecret(String clientSecret)
    {
        this.clientSecret = clientSecret;
    }

    public String getGrantType()
    {
        return this.grantType;
    }

    public void setGrantType(String grantType)
    {
        this.grantType = grantType;
    }

    public String getCode()
    {
        return this.code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    @Override
    public void check() throws ValidationException
    {
        RequestValidationUtils.checkIsEmpty(this.clientId, "clientId");
        RequestValidationUtils.checkIsEmpty(this.clientSecret, "clientSecret");
        RequestValidationUtils.checkIsEmpty(this.grantType, "grantType");
        RequestValidationUtils.checkIsEmpty(this.code, "code");
    }

    @Override
    public String toString()
    {
        return "AccessTokenRequest [clientId=" + this.clientId + ", clientSecret=" + this.clientSecret + ", grantType=" + this.grantType + ", code=" + this.code + "]";
    }

}
