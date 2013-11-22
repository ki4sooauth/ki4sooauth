package com.gooagoo.view.gus;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

/**
 * 商家
 * @author SPZ
 *
 */
public class UShop implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopId;//商家编号

    private String shopName;//商家名称

    private Image shopLogo;//商家logo

    private String shopLink;//商家链接

    private Integer attentionNum;//关注人数

    private Integer memberNum;//会员人数

    private String fullRate;//满座率：适用于餐饮行业商家

    private String attentionCardName;//关注卡名称

    private Image attentionCardImage;//关注卡图片

    private String memberCardName;//基础卡名称,

    private Image memberCardImage;//基础卡图片

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

    public String getShopLink()
    {
        return shopLink;
    }

    public void setShopLink(String shopLink)
    {
        this.shopLink = shopLink;
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

    public Image getAttentionCardImage()
    {
        return attentionCardImage;
    }

    public void setAttentionCardImage(Image attentionCardImage)
    {
        this.attentionCardImage = attentionCardImage;
    }

    public String getMemberCardName()
    {
        return memberCardName;
    }

    public void setMemberCardName(String memberCardName)
    {
        this.memberCardName = memberCardName;
    }

    public Image getMemberCardImage()
    {
        return memberCardImage;
    }

    public void setMemberCardImage(Image memberCardImage)
    {
        this.memberCardImage = memberCardImage;
    }

    @Override
    public String toString()
    {
        return "UShop [shopId=" + shopId + ", shopName=" + shopName + ", shopLogo=" + shopLogo + ", shopLink=" + shopLink + ", attentionNum=" + attentionNum + ", memberNum=" + memberNum + ", fullRate=" + fullRate + ", attentionCardName=" + attentionCardName + ", attentionCardImage=" + attentionCardImage + ", memberCardName=" + memberCardName + ", memberCardImage=" + memberCardImage + "]";
    }

}
