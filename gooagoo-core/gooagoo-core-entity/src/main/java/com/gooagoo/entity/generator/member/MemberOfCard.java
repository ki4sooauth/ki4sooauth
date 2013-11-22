package com.gooagoo.entity.generator.member;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员卡与用户关联表
 */

public class MemberOfCard implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String scardno;//会员卡音频编号电子卡号，卡号规则：6位LID（代表实体店）+8位唯一标识（userinfo表的usernum字段）+会员卡类型（00关注卡，10～F0电子卡，F1～FF实体卡）

    private String phyCardNo;//物理卡号，分两种情况：1、商家在使用gooagoo系统之前已经有会员，此时物理卡号和电子卡号是不一样的，电子卡号由gooagoo系统生成，而物理卡号沿用商家原有的卡号，以建立一一对应的关系；2、商家在使用gooagoo系统之前没有会员，此时物理卡号和电子卡号是一样的，都由gooagoo系统生成。

    private String cardId;//会员卡编号

    private String userId;//用户编号

    private String shopId;//商家编号

    private String cardType2;//会员卡类型2，0-关注卡，1-电子卡，2-实体卡

    private Date expireDate;//过期时间

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getScardno()
    {
        return this.scardno;
    }

    public void setScardno(String scardno)
    {
        this.scardno = scardno;
    }

    public String getPhyCardNo()
    {
        return this.phyCardNo;
    }

    public void setPhyCardNo(String phyCardNo)
    {
        this.phyCardNo = phyCardNo;
    }

    public String getCardId()
    {
        return this.cardId;
    }

    public void setCardId(String cardId)
    {
        this.cardId = cardId;
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

    public String getCardType2()
    {
        return this.cardType2;
    }

    public void setCardType2(String cardType2)
    {
        this.cardType2 = cardType2;
    }

    public Date getExpireDate()
    {
        return this.expireDate;
    }

    public void setExpireDate(Date expireDate)
    {
        this.expireDate = expireDate;
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
        return this.scardno + "^" + this.phyCardNo + "^" + this.cardId + "^" + this.userId + "^" + this.shopId + "^" + this.cardType2 + "^" + this.expireDate + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
