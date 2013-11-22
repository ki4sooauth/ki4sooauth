package com.gooagoo.entity.business.member;

import java.io.Serializable;

import com.gooagoo.entity.generator.member.MemberBaseInfo;

public class MemberBaseInfoBusiness extends MemberBaseInfo implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String userId;//用户编号
    private String scardno;//会员卡音频编号电子卡号，卡号规则：6位LID（代表实体店）+8位唯一标识（userinfo表的usernum字段）+会员卡类型（00关注卡，10～F0电子卡，F1～FF实体卡）

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getScardno()
    {
        return this.scardno;
    }

    public void setScardno(String scardno)
    {
        this.scardno = scardno;
    }

    @Override
    public String toString()
    {
        return "MemberBaseInfoBusiness [userId=" + this.userId + ", scardno=" + this.scardno + "]";
    }

}
