package com.gooagoo.entity.business.marketing.recommend;

import java.io.Serializable;

public class RecommendShop implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopId;//商家编号

    private String shopName;//商家名称

    private String shopLogo;//商家logo

    private String color;//推荐背景色值

    private Integer attentionNum;//关注人数

    private Integer memberNum;//会员人数

    private String fullRate;//满座率：适用于餐饮行业商家

    private String attentionCardName;//关注卡名称

    private String attentionCardUrl;//关注卡图片URL

    private String memberCardName;//基础卡名称

    private String memberCardUrl;//基础卡图片URL

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopName()
    {
        return shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getShopLogo()
    {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo)
    {
        this.shopLogo = shopLogo;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public Integer getAttentionNum()
    {
        return attentionNum;
    }

    public void setAttentionNum(Integer attentionNum)
    {
        this.attentionNum = attentionNum;
    }

    public Integer getMemberNum()
    {
        return memberNum;
    }

    public void setMemberNum(Integer memberNum)
    {
        this.memberNum = memberNum;
    }

    public String getFullRate()
    {
        return fullRate;
    }

    public void setFullRate(String fullRate)
    {
        this.fullRate = fullRate;
    }

    public String getAttentionCardName()
    {
        return attentionCardName;
    }

    public void setAttentionCardName(String attentionCardName)
    {
        this.attentionCardName = attentionCardName;
    }

    public String getAttentionCardUrl()
    {
        return attentionCardUrl;
    }

    public void setAttentionCardUrl(String attentionCardUrl)
    {
        this.attentionCardUrl = attentionCardUrl;
    }

    public String getMemberCardName()
    {
        return memberCardName;
    }

    public void setMemberCardName(String memberCardName)
    {
        this.memberCardName = memberCardName;
    }

    public String getMemberCardUrl()
    {
        return memberCardUrl;
    }

    public void setMemberCardUrl(String memberCardUrl)
    {
        this.memberCardUrl = memberCardUrl;
    }

}
