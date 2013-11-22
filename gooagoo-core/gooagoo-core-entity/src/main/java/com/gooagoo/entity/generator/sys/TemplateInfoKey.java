package com.gooagoo.entity.generator.sys;

import java.io.Serializable;

/**
 * 后台用户维护的模板基础信息
 */

public class TemplateInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String templateId;//模板编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getTemplateId()
    {
        return templateId;
    }

    public void setTemplateId(String templateId)
    {
        this.templateId = templateId;
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
