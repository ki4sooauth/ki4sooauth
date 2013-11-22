package com.gooagoo.view.gms.member;

import java.io.Serializable;
import java.util.Date;

/**
 * 积分升级信息
 */
public class FCardUpInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;//自动编号,UUID

    private String userId;//用户编号

    private String shopId;//商家ID

    private String cardId;//当前会员卡编码

    private String cardName;//当前会员卡名称

    private String upCardId;//积分升级可获得的会员卡编码

    private String upCardName;//积分升级可获得的会员卡名称

    private Integer needIntegral;//会员卡升级所需积分

    private String phyNo;//物理卡号

    private String phyName;//物理卡名称

    private String name;//姓名

    private String sex;//性别，参考通用字典表的sex

    private Date birthday;//出生日期

    private String idType;//证件类型，参考通用字典表的idtype

    private String idNo;//证件号码

    private String mobile;//手机号码

    private String telephone;//联系电话

    private String email;//电子邮箱

    private String postcode;//邮政编码

    private String status;//审核状态，参考通用字典表的application_status

    private String auditNote;//审核备注

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Integer historyTotalIntegral;//历史总积分，用于会员卡的升级

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getCardId()
    {
        return this.cardId;
    }

    public void setCardId(String cardId)
    {
        this.cardId = cardId;
    }

    public String getCardName()
    {
        return this.cardName;
    }

    public void setCardName(String cardName)
    {
        this.cardName = cardName;
    }

    public String getUpCardId()
    {
        return this.upCardId;
    }

    public void setUpCardId(String upCardId)
    {
        this.upCardId = upCardId;
    }

    public String getUpCardName()
    {
        return this.upCardName;
    }

    public void setUpCardName(String upCardName)
    {
        this.upCardName = upCardName;
    }

    public Integer getNeedIntegral()
    {
        return this.needIntegral;
    }

    public void setNeedIntegral(Integer needIntegral)
    {
        this.needIntegral = needIntegral;
    }

    public String getPhyNo()
    {
        return this.phyNo;
    }

    public void setPhyNo(String phyNo)
    {
        this.phyNo = phyNo;
    }

    public String getPhyName()
    {
        return this.phyName;
    }

    public void setPhyName(String phyName)
    {
        this.phyName = phyName;
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

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Integer getHistoryTotalIntegral()
    {
        return this.historyTotalIntegral;
    }

    public void setHistoryTotalIntegral(Integer historyTotalIntegral)
    {
        this.historyTotalIntegral = historyTotalIntegral;
    }

}
