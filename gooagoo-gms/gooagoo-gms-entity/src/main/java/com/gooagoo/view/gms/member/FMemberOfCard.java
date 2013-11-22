package com.gooagoo.view.gms.member;

import java.io.Serializable;
import java.util.Date;

public class FMemberOfCard implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String id;//自动编号

    private String cardId;//会员卡编号

    private String userId;//会员编号

    private String shopId;//商家编号

    private String shareUserId;//分享用户id

    private Date shareExpireDate;//分享有效期限

    private String cardNo;//卡号，关注卡的时候，默认为userinfo中的user_num

    private String cardType;//会员卡类型，00表示关注信息卡，10-F0表示电子卡，F1-FF表示实体卡

    private String cardType2;//会员卡类型2，0-关注卡，1-电子卡，2-实体卡

    private String scardno;//音频卡号，lid+十六进制(8位)表示的card_no+card_type

    private String phyCardNo;//物理卡号

    private Date applyDate;//申请时间

    private Date expireDate;//过期时间

    private Date createDate;//创建时间

    private String status;//审核状态：P-审核通过，N-未处理，B-审核不通过

    private Integer jifen;//积分

    private Date cTimeStamp;//时间戳

    private Integer isDel;//是否删除，1-已删除，0-未删除

    private Date shareExpireDate_F;//分享有效期限，用于按时间查询，如果此字段有值，可查询出>此字段值的记录

    private Date shareExpireDate_T;//分享有效期限，用于按时间查询，如果此字段有值，可查询出<此字段值的记录

    private Date shareExpireDate_FE;//分享有效期限，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    private Date shareExpireDate_TE;//分享有效期限，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

    private Date applyDate_F;//申请时间，用于按时间查询，如果此字段有值，可查询出>此字段值的记录

    private Date applyDate_T;//申请时间，用于按时间查询，如果此字段有值，可查询出<此字段值的记录

    private Date applyDate_FE;//申请时间，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    private Date applyDate_TE;//申请时间，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

    private Date expireDate_F;//过期时间，用于按时间查询，如果此字段有值，可查询出>此字段值的记录

    private Date expireDate_T;//过期时间，用于按时间查询，如果此字段有值，可查询出<此字段值的记录

    private Date expireDate_FE;//过期时间，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    private Date expireDate_TE;//过期时间，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

    private Date createDate_F;//创建时间，用于按时间查询，如果此字段有值，可查询出>此字段值的记录

    private Date createDate_T;//创建时间，用于按时间查询，如果此字段有值，可查询出<此字段值的记录

    private Date createDate_FE;//创建时间，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    private Date createDate_TE;//创建时间，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

    private Date cTimeStamp_F;//时间戳，用于按时间查询，如果此字段有值，可查询出>此字段值的记录

    private Date cTimeStamp_T;//时间戳，用于按时间查询，如果此字段有值，可查询出<此字段值的记录

    private Date cTimeStamp_FE;//时间戳，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    private Date cTimeStamp_TE;//时间戳，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
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

    public String getShareUserId()
    {
        return this.shareUserId;
    }

    public void setShareUserId(String shareUserId)
    {
        this.shareUserId = shareUserId;
    }

    public Date getShareExpireDate()
    {
        return this.shareExpireDate;
    }

    public void setShareExpireDate(Date shareExpireDate)
    {
        this.shareExpireDate = shareExpireDate;
    }

    public String getCardNo()
    {
        return this.cardNo;
    }

    public void setCardNo(String cardNo)
    {
        this.cardNo = cardNo;
    }

    public String getCardType()
    {
        return this.cardType;
    }

    public String getCardType2()
    {
        return this.cardType2;
    }

    public void setCardType2(String cardType2)
    {
        this.cardType2 = cardType2;
    }

    public void setCardType(String cardType)
    {
        this.cardType = cardType;
    }

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

    public Date getApplyDate()
    {
        return this.applyDate;
    }

    public void setApplyDate(Date applyDate)
    {
        this.applyDate = applyDate;
    }

    public Date getExpireDate()
    {
        return this.expireDate;
    }

    public void setExpireDate(Date expireDate)
    {
        this.expireDate = expireDate;
    }

    public Date getCreateDate()
    {
        return this.createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Integer getJifen()
    {
        return this.jifen;
    }

    public void setJifen(Integer jifen)
    {
        this.jifen = jifen;
    }

    public Date getcTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    public Integer getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(Integer isDel)
    {
        this.isDel = isDel;
    }

    public Date getShareExpireDate_F()
    {
        return this.shareExpireDate_F;
    }

    public void setShareExpireDate_F(Date shareExpireDate_F)
    {
        this.shareExpireDate_F = shareExpireDate_F;
    }

    public Date getShareExpireDate_T()
    {
        return this.shareExpireDate_T;
    }

    public void setShareExpireDate_T(Date shareExpireDate_T)
    {
        this.shareExpireDate_T = shareExpireDate_T;
    }

    public Date getShareExpireDate_FE()
    {
        return this.shareExpireDate_FE;
    }

    public void setShareExpireDate_FE(Date shareExpireDate_FE)
    {
        this.shareExpireDate_FE = shareExpireDate_FE;
    }

    public Date getShareExpireDate_TE()
    {
        return this.shareExpireDate_TE;
    }

    public void setShareExpireDate_TE(Date shareExpireDate_TE)
    {
        this.shareExpireDate_TE = shareExpireDate_TE;
    }

    public Date getApplyDate_F()
    {
        return this.applyDate_F;
    }

    public void setApplyDate_F(Date applyDate_F)
    {
        this.applyDate_F = applyDate_F;
    }

    public Date getApplyDate_T()
    {
        return this.applyDate_T;
    }

    public void setApplyDate_T(Date applyDate_T)
    {
        this.applyDate_T = applyDate_T;
    }

    public Date getApplyDate_FE()
    {
        return this.applyDate_FE;
    }

    public void setApplyDate_FE(Date applyDate_FE)
    {
        this.applyDate_FE = applyDate_FE;
    }

    public Date getApplyDate_TE()
    {
        return this.applyDate_TE;
    }

    public void setApplyDate_TE(Date applyDate_TE)
    {
        this.applyDate_TE = applyDate_TE;
    }

    public Date getExpireDate_F()
    {
        return this.expireDate_F;
    }

    public void setExpireDate_F(Date expireDate_F)
    {
        this.expireDate_F = expireDate_F;
    }

    public Date getExpireDate_T()
    {
        return this.expireDate_T;
    }

    public void setExpireDate_T(Date expireDate_T)
    {
        this.expireDate_T = expireDate_T;
    }

    public Date getExpireDate_FE()
    {
        return this.expireDate_FE;
    }

    public void setExpireDate_FE(Date expireDate_FE)
    {
        this.expireDate_FE = expireDate_FE;
    }

    public Date getExpireDate_TE()
    {
        return this.expireDate_TE;
    }

    public void setExpireDate_TE(Date expireDate_TE)
    {
        this.expireDate_TE = expireDate_TE;
    }

    public Date getCreateDate_F()
    {
        return this.createDate_F;
    }

    public void setCreateDate_F(Date createDate_F)
    {
        this.createDate_F = createDate_F;
    }

    public Date getCreateDate_T()
    {
        return this.createDate_T;
    }

    public void setCreateDate_T(Date createDate_T)
    {
        this.createDate_T = createDate_T;
    }

    public Date getCreateDate_FE()
    {
        return this.createDate_FE;
    }

    public void setCreateDate_FE(Date createDate_FE)
    {
        this.createDate_FE = createDate_FE;
    }

    public Date getCreateDate_TE()
    {
        return this.createDate_TE;
    }

    public void setCreateDate_TE(Date createDate_TE)
    {
        this.createDate_TE = createDate_TE;
    }

    public Date getcTimeStamp_F()
    {
        return this.cTimeStamp_F;
    }

    public void setcTimeStamp_F(Date cTimeStamp_F)
    {
        this.cTimeStamp_F = cTimeStamp_F;
    }

    public Date getcTimeStamp_T()
    {
        return this.cTimeStamp_T;
    }

    public void setcTimeStamp_T(Date cTimeStamp_T)
    {
        this.cTimeStamp_T = cTimeStamp_T;
    }

    public Date getcTimeStamp_FE()
    {
        return this.cTimeStamp_FE;
    }

    public void setcTimeStamp_FE(Date cTimeStamp_FE)
    {
        this.cTimeStamp_FE = cTimeStamp_FE;
    }

    public Date getcTimeStamp_TE()
    {
        return this.cTimeStamp_TE;
    }

    public void setcTimeStamp_TE(Date cTimeStamp_TE)
    {
        this.cTimeStamp_TE = cTimeStamp_TE;
    }

}
