package com.gooagoo.view.gms.member;

import java.io.Serializable;

/**
 * 会员等级
 * @author Administrator
 *
 */
public class FCardLvl implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String cardId;//会员卡编号

    private String cardName;//会员卡名称

    private String cardType;//会员卡类型，00表示关注卡，10-F0表示电子卡号和实体卡号相同，F1-FF表示电子卡号和实体卡号不同

    private Integer needJifen; //生级所需积分

    private String cardLvl;//会员卡级别，0-关注卡，1-基础卡，2-高级卡。关注卡到店自动发放，基础卡需要会员申请，高级卡从基础卡自动升级而来。特批功能可把用户的卡设置成任意类型的卡。

    private String needApproval;//是否需要审批

    private String description;//会员权限说明

    public Integer getNeedJifen()
    {
        return this.needJifen;
    }

    public void setNeedJifen(Integer needJifen)
    {
        this.needJifen = needJifen;
    }

    public String getNeedApproval()
    {
        return this.needApproval;
    }

    public void setNeedApproval(String needApproval)
    {
        this.needApproval = needApproval;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    public String getCardLvl()
    {
        return this.cardLvl;
    }

    public void setCardLvl(String cardLvl)
    {
        this.cardLvl = cardLvl;
    }

    @Override
    public String toString()
    {
        return this.cardId + "^" + this.cardName + "^" + this.cardType + "^" + this.cardLvl;
    }
}
