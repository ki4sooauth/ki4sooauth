package com.gooagoo.entity.business.member;

import java.io.Serializable;

/**
 * 会员特征信息
 */
public class MemberFeatureBusiness implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 类型编号，例如color，同一商家唯一，由商家录入 */
    private String typecode = "";

    /** 类型名称，例如颜色，同一商家唯一，由商家录入 */
    private String typename = "";

    /** 枚举值，保存的是json串，例如["黄色","蓝色","白色"] */
    private java.util.List<String> enumvalue = new java.util.ArrayList<String>();

    /** 特征数值（用户当前的数值），如蓝色  */
    private String featurevalue = "";

    /**
     * 设置类型编号，例如color，同一商家唯一，由商家录入
     * @param typecode	类型编号，例如color，同一商家唯一，由商家录入
     */
    public void setTypecode(String typecode)
    {
        this.typecode = typecode;
    }

    /**
     * 获取类型编号，例如color，同一商家唯一，由商家录入
     * @return	类型编号，例如color，同一商家唯一，由商家录入
     */
    public String getTypecode()
    {
        return this.typecode;
    }

    /**
     * 设置类型名称，例如颜色，同一商家唯一，由商家录入
     * @param typename	类型名称，例如颜色，同一商家唯一，由商家录入
     */
    public void setTypename(String typename)
    {
        this.typename = typename;
    }

    /**
     * 获取类型名称，例如颜色，同一商家唯一，由商家录入
     * @return	类型名称，例如颜色，同一商家唯一，由商家录入
     */
    public String getTypename()
    {
        return this.typename;
    }

    /**
     * 设置枚举值，保存的是json串，例如["黄色","蓝色","白色"]
     * @param enumvalue	枚举值，保存的是json串，例如["黄色","蓝色","白色"]
     */
    public void setEnumvalue(java.util.List<String> enumvalue)
    {
        this.enumvalue = enumvalue;
    }

    /**
     * 获取枚举值，保存的是json串，例如["黄色","蓝色","白色"]
     * @return	枚举值，保存的是json串，例如["黄色","蓝色","白色"]
     */
    public java.util.List<String> getEnumvalue()
    {
        return this.enumvalue;
    }

    /**
     * 设置特征数值（用户当前的数值），如蓝色 
     * @param featurevalue	特征数值（用户当前的数值），如蓝色 
     */
    public void setFeaturevalue(String featurevalue)
    {
        this.featurevalue = featurevalue;
    }

    /**
     * 获取特征数值（用户当前的数值），如蓝色 
     * @return	特征数值（用户当前的数值），如蓝色 
     */
    public String getFeaturevalue()
    {
        return this.featurevalue;
    }
}