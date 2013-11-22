package com.gooagoo.entity.generator.sys;

import java.io.Serializable;

/**
 * cms内容信息
 */

public class CmsContentKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String cmsContentId;//cms内容编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getCmsContentId()
    {
        return cmsContentId;
    }

    public void setCmsContentId(String cmsContentId)
    {
        this.cmsContentId = cmsContentId;
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
