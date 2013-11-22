package com.gooagoo.entity.generator.sys;

import java.io.Serializable;

/**
 * 推荐商品。gooagoo平台向客户推荐商品，在我的收藏中展示推荐的商品信息。
 */

public class NominateGoodsKey implements Serializable
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
