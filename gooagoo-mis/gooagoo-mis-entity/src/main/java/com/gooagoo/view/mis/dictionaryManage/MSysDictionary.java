package com.gooagoo.view.mis.dictionaryManage;

import java.io.Serializable;
import java.util.Date;

/**
 * 通用字典表
 * @author Administrator
 *
 */
public class MSysDictionary implements Serializable
{

    private static final long serialVersionUID = 1L;
    private Integer sysDictionaryId;//自动编号，自增长
    private String dictionaryType;//字典类型，如sex
    private String dictionaryName;//字典类型名称，如性别
    private String englishName;//英文名称，如M
    private String chineseName;//中文名称，如男
    private String note;//备注
    private String isDel;//是否删除，Y-已删除，N-未删除
    private Date createTime;//创建时间
    private Date cTimeStamp;//最后一次修改时间

    public Integer getSysDictionaryId()
    {
        return sysDictionaryId;
    }

    public void setSysDictionaryId(Integer sysDictionaryId)
    {
        this.sysDictionaryId = sysDictionaryId;
    }

    public String getDictionaryType()
    {
        return dictionaryType;
    }

    public void setDictionaryType(String dictionaryType)
    {
        this.dictionaryType = dictionaryType;
    }

    public String getEnglishName()
    {
        return englishName;
    }

    public void setEnglishName(String englishName)
    {
        this.englishName = englishName;
    }

    public String getChineseName()
    {
        return chineseName;
    }

    public void setChineseName(String chineseName)
    {
        this.chineseName = chineseName;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getcTimeStamp()
    {
        return cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    public String getDictionaryName()
    {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName)
    {
        this.dictionaryName = dictionaryName;
    }

}
