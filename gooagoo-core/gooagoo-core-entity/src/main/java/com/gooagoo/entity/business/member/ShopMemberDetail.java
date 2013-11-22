package com.gooagoo.entity.business.member;

import java.io.Serializable;

import com.gooagoo.entity.generator.member.IntegralInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberOfCard;

/**
 * 商家会员信息类（包括会员基本信息、积分信息、会员卡基本信息、会员卡和用户关联信息）
 *
 */
public class ShopMemberDetail implements Serializable
{
    private static final long serialVersionUID = 1L;

    public MemberCard memberCard;
    public IntegralInfo integralInfo;
    public MemberBaseInfo memberBaseInfo;
    public MemberOfCard memberOfCard;

    public MemberCard getMemberCard()
    {
        return this.memberCard;
    }

    public void setMemberCard(MemberCard memberCard)
    {
        this.memberCard = memberCard;
    }

    public IntegralInfo getIntegralInfo()
    {
        return this.integralInfo;
    }

    public void setIntegralInfo(IntegralInfo integralInfo)
    {
        this.integralInfo = integralInfo;
    }

    public MemberBaseInfo getMemberBaseInfo()
    {
        return this.memberBaseInfo;
    }

    public void setMemberBaseInfo(MemberBaseInfo memberBaseInfo)
    {
        this.memberBaseInfo = memberBaseInfo;
    }

    public MemberOfCard getMemberOfCard()
    {
        return this.memberOfCard;
    }

    public void setMemberOfCard(MemberOfCard memberOfCard)
    {
        this.memberOfCard = memberOfCard;
    }

}
