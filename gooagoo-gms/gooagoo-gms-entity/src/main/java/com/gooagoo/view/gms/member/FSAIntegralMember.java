package com.gooagoo.view.gms.member;

import java.io.Serializable;
import java.util.Date;

public class FSAIntegralMember implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String shopId;//商家ID

    private String userId;//用户id

    private String name;//姓名

    private String sex;//性别，参考通用字典表的sex

    private Date birthday;//出生日期

    private String idType;//证件类型，参考通用字典表的idtype

    private String idNo;//证件号码

    private String mobile;//手机号码

    private String telephone;//联系电话

    private String email;//电子邮箱

    private String phyNo;//物理卡号

    private String cardId;//会员卡编号

    private String cardName;//会员卡名称

    private String cardType;//会员卡类型，00表示关注卡，10-F0表示电子卡号和实体卡号相同，F1-FF表示电子卡号和实体卡号不同

    private String integralId;//积分编号，UUID

    private Integer historyTotalIntegral;//历史总积分，用于会员卡的升级

    private Integer useableIntegralNumber;//可用积分，用于兑换商品或优惠凭证

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

    public String getPhyNo()
    {
        return this.phyNo;
    }

    public void setPhyNo(String phyNo)
    {
        this.phyNo = phyNo;
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

    public String getCardType()
    {
        return this.cardType;
    }

    public void setCardType(String cardType)
    {
        this.cardType = cardType;
    }

    public String getIntegralId()
    {
        return this.integralId;
    }

    public void setIntegralId(String integralId)
    {
        this.integralId = integralId;
    }

    public Integer getHistoryTotalIntegral()
    {
        return this.historyTotalIntegral;
    }

    public void setHistoryTotalIntegral(Integer historyTotalIntegral)
    {
        this.historyTotalIntegral = historyTotalIntegral;
    }

    public Integer getUseableIntegralNumber()
    {
        return this.useableIntegralNumber;
    }

    public void setUseableIntegralNumber(Integer useableIntegralNumber)
    {
        this.useableIntegralNumber = useableIntegralNumber;
    }

}
