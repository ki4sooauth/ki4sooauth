package com.gooagoo.entity.generator.user;

import java.io.Serializable;

/**
 * 描述购阿购平台用户帐号与第三方平台用户帐号的绑定关系。一个购阿购平台用户帐号可以绑定多个第三方平台用户帐号。
 */

public class UserAccountBindKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，唯一，通过UUID产生

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

}
