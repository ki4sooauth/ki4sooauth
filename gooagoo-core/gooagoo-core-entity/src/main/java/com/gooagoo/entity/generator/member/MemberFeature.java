package com.gooagoo.entity.generator.member;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员特征字典表
 */

public class MemberFeature implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String shopId;//商家编号

    private String typeCode;//类型编号，例如color，同一商家唯一，由商家录入

    private String typeName;//类型名称，例如颜色，同一商家唯一，由商家录入

    private String enumValue;//枚举值，保存的是json串，例如["黄色","蓝色","白色"]

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
        return this.id + "^" + this.shopId + "^" + this.typeCode + "^" + this.typeName + "^" + this.enumValue + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
