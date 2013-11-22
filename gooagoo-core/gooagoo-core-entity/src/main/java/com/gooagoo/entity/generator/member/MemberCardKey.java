package com.gooagoo.entity.generator.member;

import java.io.Serializable;

/**
 * 会员卡基本表
 */

public class MemberCardKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String cardId;//会员卡编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getCardId()
    {
        return cardId;
    }

    public void setCardId(String cardId)
    {
        this.cardId = cardId;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

}
