package com.gooagoo.entity.business.marketing;

import java.io.Serializable;

public class ShopDetailForPlace implements Serializable
{
    private static final long serialVersionUID = 1L;

    /**  商家编号   */
    private String shopid = "";//
    /**  商家名称   */
    private String shopName = "";//
    /**  商家正方形图片（小）   */
    private String logo1 = "";//
    /**  商家长方形图片（大）   */
    private String logo2 = "";//

    /**  会员卡卡头url   */
    private String cardheaderurl = "";

    /**  关注数量  */
    private String attentionnum = "";

    /**  会员数量  */
    private String membernum = "";

    /**  精品数量  */
    private String num = "";

    public String getLogo1()
    {
        return this.logo1;
    }

    public void setLogo1(String logo1)
    {
        this.logo1 = logo1;
    }

    public String getShopid()
    {
        return this.shopid;
    }

    public void setShopid(String shopid)
    {
        this.shopid = shopid;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getLogo2()
    {
        return this.logo2;
    }

    public void setLogo2(String logo2)
    {
        this.logo2 = logo2;
    }

    public String getCardheaderurl()
    {
        return this.cardheaderurl;
    }

    public void setCardheaderurl(String cardheaderurl)
    {
        this.cardheaderurl = cardheaderurl;
    }

    public String getAttentionnum()
    {
        return this.attentionnum;
    }

    public void setAttentionnum(String attentionnum)
    {
        this.attentionnum = attentionnum;
    }

    public String getMembernum()
    {
        return this.membernum;
    }

    public void setMembernum(String membernum)
    {
        this.membernum = membernum;
    }

    public String getNum()
    {
        return this.num;
    }

    public void setNum(String num)
    {
        this.num = num;
    }

    @Override
    public String toString()
    {
        return "ShopDetailForPlace [shopid=" + this.shopid + ", shopName=" + this.shopName + ", logo1=" + this.logo1 + ", logo2=" + this.logo2 + ", cardheaderurl=" + this.cardheaderurl + ", attentionnum=" + this.attentionnum + ", membernum=" + this.membernum + ", num=" + this.num + "]";
    }

}
