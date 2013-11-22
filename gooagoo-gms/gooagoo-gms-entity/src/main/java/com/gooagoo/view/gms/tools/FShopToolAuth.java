package com.gooagoo.view.gms.tools;

import java.io.Serializable;

/**
 * 商家的服务工具权限分配信息
 */
public class FShopToolAuth implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID
    private String authority;//权限设置，对应会员卡类别，以逗号分隔，如为空，则表示所有会员都可使用

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getAuthority()
    {
        return this.authority;
    }

    public void setAuthority(String authority)
    {
        this.authority = authority;
    }
}
