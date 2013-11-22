package com.gooagoo.entity.generator.member;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员卡基本表
 */

public class MemberCard implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String cardId;//会员卡编号

    private String cardName;//会员卡名称

    private String shopId;//商家编号

    private String cardType;//会员卡类型，00表示关注卡，10-F0表示电子卡号和实体卡号相同，F1-FF表示电子卡号和实体卡号不同

    private String cardType2;//会员卡类型2，0-关注卡，1-电子卡，2-实体卡

    private String cardLvl;//会员卡级别，0-关注卡，1-基础卡，2-高级卡。关注卡到店自动发放，基础卡需要会员申请，高级卡从基础卡自动升级而来。特批功能可把用户的卡设置成任意类型的卡。

    private String needApproval;//是否需要审批，Y-需要审批，N-不需要审批。关注卡不需要审批，基础卡和高级卡可设定此属性。如果基础卡设定为Y（需要审批），则用户申请之后需要等待商家审批通过，否则直接发放给用户。如果高级卡设定为Y（需要审批），用户积分满足此卡条件之后，需要等待商家审批通过，否则直接自动升级发放给用户。

    private Integer needJifen;//升级所需积分

    private String cardUrl;//会员卡图片URL

    private String description;//会员权限说明

    private Integer useLimited;//使用期限，以天为单位，关注卡默认为9999

    private String publishStatus;//状态（审核与发布），参考通用字典表的publish_status

    private String auditNote;//审核备注

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

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

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getCardType()
    {
        return this.cardType;
    }

    public void setCardType(String cardType)
    {
        this.cardType = cardType;
    }

    public String getCardType2()
    {
        return this.cardType2;
    }

    public void setCardType2(String cardType2)
    {
        this.cardType2 = cardType2;
    }

    public String getCardLvl()
    {
        return this.cardLvl;
    }

    public void setCardLvl(String cardLvl)
    {
        this.cardLvl = cardLvl;
    }

    public String getNeedApproval()
    {
        return this.needApproval;
    }

    public void setNeedApproval(String needApproval)
    {
        this.needApproval = needApproval;
    }

    public Integer getNeedJifen()
    {
        return this.needJifen;
    }

    public void setNeedJifen(Integer needJifen)
    {
        this.needJifen = needJifen;
    }

    public String getCardUrl()
    {
        return this.cardUrl;
    }

    public void setCardUrl(String cardUrl)
    {
        this.cardUrl = cardUrl;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getUseLimited()
    {
        return this.useLimited;
    }

    public void setUseLimited(Integer useLimited)
    {
        this.useLimited = useLimited;
    }

    public String getPublishStatus()
    {
        return this.publishStatus;
    }

    public void setPublishStatus(String publishStatus)
    {
        this.publishStatus = publishStatus;
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
        return this.cardId + "^" + this.cardName + "^" + this.shopId + "^" + this.cardType + "^" + this.cardType2 + "^" + this.cardLvl + "^" + this.needApproval + "^" + this.needJifen + "^" + this.cardUrl + "^" + this.description + "^" + this.useLimited + "^" + this.publishStatus + "^" + this.auditNote + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
