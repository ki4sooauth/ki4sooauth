package com.gooagoo.view.gms.tools;

import java.io.Serializable;

import com.gooagoo.view.gms.member.FMemberCard;

/**
 *
 * 服务工具权限信息
 *
 */
public class FToolAuth implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String cardId; // 会员卡的Id
    private String cardName;// 会员卡的名称
    private boolean flag; // 是否具体使用该服务的权限 true表是有，false表示无

    public FToolAuth()
    {
        super();
    }

    public FToolAuth(FMemberCard cardLvl)
    {
        super();
        this.cardId = cardLvl.getCardId();
        this.cardName = cardLvl.getCardName();
    }

    public FToolAuth(FMemberCard cardLvl, boolean flag)
    {
        this(cardLvl);
        this.flag = flag;
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

    public boolean isFlag()
    {
        return this.flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

}
