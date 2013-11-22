package com.gooagoo.entity.generator.sys;

import java.io.Serializable;

/**
 * 区域性小平台
 */

public class PlatformRegionKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String platformId;//小平台编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getPlatformId()
    {
        return platformId;
    }

    public void setPlatformId(String platformId)
    {
        this.platformId = platformId;
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
