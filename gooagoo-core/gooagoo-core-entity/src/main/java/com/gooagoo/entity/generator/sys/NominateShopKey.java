package com.gooagoo.entity.generator.sys;

import java.io.Serializable;

/**
 * 推荐商家。gooagoo平台帮助商家发展会员，在卡包的热点区域展示商家的信息。
 */

public class NominateShopKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

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
