package com.gooagoo.entity.business.member;

import java.io.Serializable;

import com.gooagoo.entity.generator.member.MemberOfCard;

public class MemberOfCardBusiness implements Serializable
{

    /**
     * 
     */

    private static final long serialVersionUID = 1L;
    private String scardnoQrUrl;//会员卡音频编号二维码地址
    private String scardnoUrl;//会员卡音频编号音频地址
    private String useableIntegralNumber;//可用积分
    private MemberOfCard memberOfCard;

    public String getScardnoQrUrl()
    {
        return this.scardnoQrUrl;
    }

    public void setScardnoQrUrl(String scardnoQrUrl)
    {
        this.scardnoQrUrl = scardnoQrUrl;
    }

    public String getScardnoUrl()
    {
        return this.scardnoUrl;
    }

    public void setScardnoUrl(String scardnoUrl)
    {
        this.scardnoUrl = scardnoUrl;
    }

    public String getUseableIntegralNumber()
    {
        return this.useableIntegralNumber;
    }

    public void setUseableIntegralNumber(String useableIntegralNumber)
    {
        this.useableIntegralNumber = useableIntegralNumber;
    }

    public MemberOfCard getMemberOfCard()
    {
        return this.memberOfCard;
    }

    public void setMemberOfCard(MemberOfCard memberOfCard)
    {
        this.memberOfCard = memberOfCard;
    }

    @Override
    public String toString()
    {
        return "MemberOfCardBusiness [scardnoQrUrl=" + this.scardnoQrUrl + ", scardnoUrl=" + this.scardnoUrl + ", useableIntegralNumber=" + this.useableIntegralNumber + ", memberOfCard=" + this.memberOfCard + "]";
    }

}
