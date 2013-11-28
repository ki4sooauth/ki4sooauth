package com.gooagoo.authzserver.entity.code;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 临时token
 */
public class AuthorizationBusiness implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 查询结果编码，true-成功，false-失败  */
    private String result;

    /** 查询失败描述  */
    private String msg;

    /** 提示信息编号  */
    private String msgcode;
    /** 临时token */
    private String authorizationcode;
    /** 客户端回调地址  */
    private String redirecturi;

    public String getResult()
    {
        return this.result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public String getMsg()
    {
        return this.msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public String getMsgcode()
    {
        return this.msgcode;
    }

    public void setMsgcode(String msgcode)
    {
        this.msgcode = msgcode;
    }

    public String getAuthorizationcode()
    {
        return this.authorizationcode;
    }

    public void setAuthorizationcode(String authorizationcode)
    {
        this.authorizationcode = authorizationcode;
    }

    public String getRedirecturi()
    {
        return this.redirecturi;
    }

    public void setRedirecturi(String redirecturi)
    {
        this.redirecturi = redirecturi;
    }

    @Override
    public String toString()
    {
        return "AuthorizationBusiness [result=" + this.result + ", msg=" + this.msg + ", msgcode=" + this.msgcode + ", authorizationcode=" + this.authorizationcode + ", redirecturi=" + this.redirecturi + "]";
    }

    /**
     * 转换成json
     */
    public String toJson()
    {
        Gson json = new Gson();
        return json.toJson(this);
    }
}
