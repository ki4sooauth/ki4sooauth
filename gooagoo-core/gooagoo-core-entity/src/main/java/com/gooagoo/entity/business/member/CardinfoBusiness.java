package com.gooagoo.entity.business.member;

import java.io.Serializable;

import com.gooagoo.entity.generator.member.MemberCard;

/**
 * 会员卡音频编号
 */
public class CardinfoBusiness implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 会员卡音频编号 */
    private MemberCard memberCard;

    /** 会员卡音频编号 */
    private String scardno = "";

    /** 可用积分 */
    private String jifen = "";

    /** 会员卡名称 */
    private String cardname = "";

    public MemberCard getMemberCard()
    {
        return this.memberCard;
    }

    public void setMemberCard(MemberCard memberCard)
    {
        this.memberCard = memberCard;
    }

    /**
     * 设置会员卡音频编号
     * @param scardno	会员卡音频编号
     */
    public void setScardno(String scardno)
    {
        this.scardno = scardno;
    }

    /**
     * 获取会员卡音频编号
     * @return	会员卡音频编号
     */
    public String getScardno()
    {
        return this.scardno;
    }

    /**
     * 设置可用积分
     * @param jifen	可用积分
     */
    public void setJifen(String jifen)
    {
        this.jifen = jifen;
    }

    /**
     * 获取可用积分
     * @return	可用积分
     */
    public String getJifen()
    {
        return this.jifen;
    }

    /**
     * 设置会员卡名称
     * @param cardname	会员卡名称
     */
    public void setCardname(String cardname)
    {
        this.cardname = cardname;
    }

    /**
     * 获取会员卡名称
     * @return	会员卡名称
     */
    public String getCardname()
    {
        return this.cardname;
    }
}