package com.gooagoo.authzserver.entity.token;

import com.google.gson.Gson;

/**
 * 访问token
 */
public class AccessTokenBusiness
{
    private static final long serialVersionUID = 1L;
    /** 查询结果编码，true-成功，false-失败  */
    private String result;
    /** 查询失败描述  */
    private String msg;
    /** 提示信息编号  */
    private String msgcode;
    /** 访问token  */
    private String accesstoken;
    /** 客户端回调地址   */
    private String redirecturi;
    /** 访问token有效期 */
    private String expiresin;

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

    public String getAccesstoken()
    {
        return this.accesstoken;
    }

    public void setAccesstoken(String accesstoken)
    {
        this.accesstoken = accesstoken;
    }

    public String getRedirecturi()
    {
        return this.redirecturi;
    }

    public void setRedirecturi(String redirecturi)
    {
        this.redirecturi = redirecturi;
    }

    public String getExpiresin()
    {
        return this.expiresin;
    }

    public void setExpiresin(String expiresin)
    {
        this.expiresin = expiresin;
    }

    @Override
    public String toString()
    {
        return "AccessTokenBusiness [result=" + this.result + ", msg=" + this.msg + ", msgcode=" + this.msgcode + ", accesstoken=" + this.accesstoken + ", redirecturi=" + this.redirecturi + ", expiresin=" + this.expiresin + "]";
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
