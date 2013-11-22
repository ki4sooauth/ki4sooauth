package com.gooagoo.entity.generator.member;

import java.io.Serializable;

/**
 * 会员卡与用户关联表
 */

public class MemberOfCardKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String scardno;//会员卡音频编号电子卡号，卡号规则：6位LID（代表实体店）+8位唯一标识（userinfo表的usernum字段）+会员卡类型（00关注卡，10～F0电子卡，F1～FF实体卡）

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getScardno()
    {
        return scardno;
    }

    public void setScardno(String scardno)
    {
        this.scardno = scardno;
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
