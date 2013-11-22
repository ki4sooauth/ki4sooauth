package com.gooagoo.entity.generator.member;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员卡申请
 */

public class MemberApply implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String applicationId;//申请编号，UUID

    private String shopId;//商家编号

    private String userId;//用户编号

    private Date applyTime;//申请日期

    private String name;//姓名

    private String sex;//性别，参考通用字典表的sex

    private Date birthday;//出生日期

    private String idType;//证件类型，参考通用字典表的idtype

    private String idNo;//证件号码

    private String mobile;//手机号码

    private String telephone;//联系电话

    private String email;//电子邮箱

    private String postcode;//邮政编码

    private String address;//通讯地址

    private String status;//申请状态，参考通用字典表的application_status

    private String auditNote;//审核备注

    private String source;//信息来源，参考通用字典表的source

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getApplicationId()
    {
        return this.applicationId;
    }

    public void setApplicationId(String applicationId)
    {
        this.applicationId = applicationId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public Date getApplyTime()
    {
        return this.applyTime;
    }

    public void setApplyTime(Date applyTime)
    {
        this.applyTime = applyTime;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSex()
    {
        return this.sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public Date getBirthday()
    {
        return this.birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public String getIdType()
    {
        return this.idType;
    }

    public void setIdType(String idType)
    {
        this.idType = idType;
    }

    public String getIdNo()
    {
        return this.idNo;
    }

    public void setIdNo(String idNo)
    {
        this.idNo = idNo;
    }

    public String getMobile()
    {
        return this.mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getTelephone()
    {
        return this.telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPostcode()
    {
        return this.postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getAuditNote()
    {
        return this.auditNote;
    }

    public void setAuditNote(String auditNote)
    {
        this.auditNote = auditNote;
    }

    public String getSource()
    {
        return this.source;
    }

    public void setSource(String source)
    {
        this.source = source;
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
        return this.applicationId + "^" + this.shopId + "^" + this.userId + "^" + this.applyTime + "^" + this.name + "^" + this.sex + "^" + this.birthday + "^" + this.idType + "^" + this.idNo + "^" + this.mobile + "^" + this.telephone + "^" + this.email + "^" + this.postcode + "^" + this.address + "^" + this.status + "^" + this.auditNote + "^" + this.source + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
