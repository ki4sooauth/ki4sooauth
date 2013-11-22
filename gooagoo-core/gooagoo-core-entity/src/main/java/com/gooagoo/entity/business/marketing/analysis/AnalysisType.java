package com.gooagoo.entity.business.marketing.analysis;

import java.io.Serializable;

public class AnalysisType implements Serializable
{
	private static final long serialVersionUID = 1L;
	/**
     * 是否商家自定义
     * true:商家自定义
     * false:非商家自定义
     */
    private boolean isCustom;
    private String typeCode;
    private String typeName;

    public String getTypeCode()
    {
        return this.typeCode;
    }

    public void setTypeCode(String typeCode)
    {
        this.typeCode = typeCode;
    }

    public String getTypeName()
    {
        return this.typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }

    public boolean isCustom()
    {
        return this.isCustom;
    }

    public void setCustom(boolean isCustom)
    {
        this.isCustom = isCustom;
    }
}
