package com.gooagoo.entity.generator.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 通用字典表，包括性别、证件类型、转发器型号、信息来源、行为类型
 */

public class SysDictionary implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer sysDictionaryId;//自动编号，自增长

    private String dictionaryType;//字典类型编码，如sex

    private String dictionaryName;//字典类型名称，如性别

    private String englishName;//英文名称，如M

    private String chineseName;//中文名称，如男

    private String note;//备注

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public Integer getSysDictionaryId()
    {
        return this.sysDictionaryId;
    }

    public void setSysDictionaryId(Integer sysDictionaryId)
    {
        this.sysDictionaryId = sysDictionaryId;
    }

    public String getDictionaryType()
    {
        return this.dictionaryType;
    }

    public void setDictionaryType(String dictionaryType)
    {
        this.dictionaryType = dictionaryType;
    }

    public String getDictionaryName()
    {
        return this.dictionaryName;
    }

    public void setDictionaryName(String dictionaryName)
    {
        this.dictionaryName = dictionaryName;
    }

    public String getEnglishName()
    {
        return this.englishName;
    }

    public void setEnglishName(String englishName)
    {
        this.englishName = englishName;
    }

    public String getChineseName()
    {
        return this.chineseName;
    }

    public void setChineseName(String chineseName)
    {
        this.chineseName = chineseName;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
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
        return this.sysDictionaryId + "^" + this.dictionaryType + "^" + this.dictionaryName + "^" + this.englishName + "^" + this.chineseName + "^" + this.note + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
