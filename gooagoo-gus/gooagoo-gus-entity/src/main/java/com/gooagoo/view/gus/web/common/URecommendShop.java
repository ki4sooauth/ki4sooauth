package com.gooagoo.view.gus.web.common;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class URecommendShop implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopId;//商家编号

    private String shopName;//商家名称

    private Image shopLogo;//商家logo

    private String shopUrl;//商家店铺地址

    private Integer attentionNum;//关注人数

    private Integer memberNum;//会员人数

    private String fullRate;//满座率：适用于餐饮行业商家

    private String attentionCardName;//关注卡名称

    private Image attentionCardUrl;//关注卡图片URL

    private String memberCardName;//基础卡名称,

    private Image memberCardUrl;//基础卡图片URL

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

    public Image getShopLogo()
    {
        return shopLogo;
    }

    public void setShopLogo(Image shopLogo)
    {
        this.shopLogo = shopLogo;
    }

    public String getShopUrl()
    {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl)
    {
        this.shopUrl = shopUrl;
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

    public Image getAttentionCardUrl()
    {
        return attentionCardUrl;
    }

    public void setAttentionCardUrl(Image attentionCardUrl)
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

    public Image getMemberCardUrl()
    {
        return memberCardUrl;
    }

    public void setMemberCardUrl(Image memberCardUrl)
    {
        this.memberCardUrl = memberCardUrl;
    }

}
