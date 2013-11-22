package com.gooagoo.entity.generator.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述购阿购平台用户帐号与第三方平台用户帐号的绑定关系。一个购阿购平台用户帐号可以绑定多个第三方平台用户帐号。
 */

public class UserAccountBind implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，唯一，通过UUID产生

    private String userId;//用户编号

    private String thirdAccountType;//第三方帐号类型（区分是微博还是QQ等）

    private String thirdAccount;//第三方帐号

    private String authorizeId;//授权编号

    private Date authorizeExpireTime;//授权过期时间

    private String note;//备注

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getThirdAccountType()
    {
        return this.thirdAccountType;
    }

    public void setThirdAccountType(String thirdAccountType)
    {
        this.thirdAccountType = thirdAccountType;
    }

    public String getThirdAccount()
    {
        return this.thirdAccount;
    }

    public void setThirdAccount(String thirdAccount)
    {
        this.thirdAccount = thirdAccount;
    }

    public String getAuthorizeId()
    {
        return this.authorizeId;
    }

    public void setAuthorizeId(String authorizeId)
    {
        this.authorizeId = authorizeId;
    }

    public Date getAuthorizeExpireTime()
    {
        return this.authorizeExpireTime;
    }

    public void setAuthorizeExpireTime(Date authorizeExpireTime)
    {
        this.authorizeExpireTime = authorizeExpireTime;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.id + "^" + this.userId + "^" + this.thirdAccountType + "^" + this.thirdAccount + "^" + this.authorizeId + "^" + this.authorizeExpireTime + "^" + this.note + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
