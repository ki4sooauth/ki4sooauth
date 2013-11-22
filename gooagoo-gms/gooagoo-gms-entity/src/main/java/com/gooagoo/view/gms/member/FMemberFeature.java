package com.gooagoo.view.gms.member;

import java.io.Serializable;
import java.util.List;

public class FMemberFeature implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID
    private String shopId;//商家编号
    private String typeCode;//类型编号，例如color，同一商家唯一，由商家录入
    private String typeName;//类型名称，例如颜色，同一商家唯一，由商家录入
    private String enumValue;//枚举值，保存的是json串，例如["黄色","蓝色","白色"]
    private String selectValue;
    private List<String> valuelist;

    public List<String> getValuelist()
    {
        return this.valuelist;
    }

    public void setValuelist(List<String> valuelist)
    {
        this.valuelist = valuelist;
    }

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

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

    public String getEnumValue()
    {
        return this.enumValue;
    }

    public void setEnumValue(String enumValue)
    {
        this.enumValue = enumValue;
    }

    public String getSelectValue()
    {
        return this.selectValue;
    }

    public void setSelectValue(String selectValue)
    {
        this.selectValue = selectValue;
    }
}
