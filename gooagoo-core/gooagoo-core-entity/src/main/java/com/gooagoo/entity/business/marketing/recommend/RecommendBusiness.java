package com.gooagoo.entity.business.marketing.recommend;

import java.io.Serializable;

public class RecommendBusiness implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopid;//店铺的id  
    private String shopname;//店铺名称  
    private String logo;//店铺的logo，正方形图 
    private String infoId;//活动，商品，优惠凭证的id
    private String infoImgUrl;//活动，商品，优惠凭证的原图图片  
    private String infotype;//信息的类型：现在有商品、活动、优惠劵  
    private String remark;//备注描述信息,暂未使用  
    private String infotitle;//信息标题，如商品的名称  
    private String infobegindate;//信息开始日期，优惠和活动的期间  ,格式：YYYY-MM-DD HH:MM:SS
    private String infoenddate;//信息结束日期   ,格式：YYYY-MM-DD HH:MM:SS
    private String price;//商品价格  
    private String isused;//优惠是否已使用  
    private String infopic;//信息的小图片  
    private String isdel;//是否删除，Y-已删除，N-未删除  
    private String ctimestamp;//

    public String getShopid()
    {
        return this.shopid;
    }

    public void setShopid(String shopid)
    {
        this.shopid = shopid;
    }

    public String getShopname()
    {
        return this.shopname;
    }

    public void setShopname(String shopname)
    {
        this.shopname = shopname;
    }

    public String getLogo()
    {
        return this.logo;
    }

    public void setLogo(String logo)
    {
        this.logo = logo;
    }

    public String getInfoId()
    {
        return this.infoId;
    }

    public void setInfoId(String infoId)
    {
        this.infoId = infoId;
    }

    public String getInfoImgUrl()
    {
        return this.infoImgUrl;
    }

    public void setInfoImgUrl(String infoImgUrl)
    {
        this.infoImgUrl = infoImgUrl;
    }

    public String getInfotype()
    {
        return this.infotype;
    }

    public void setInfotype(String infotype)
    {
        this.infotype = infotype;
    }

    public String getRemark()
    {
        return this.remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getInfotitle()
    {
        return this.infotitle;
    }

    public void setInfotitle(String infotitle)
    {
        this.infotitle = infotitle;
    }

    public String getInfobegindate()
    {
        return this.infobegindate;
    }

    public void setInfobegindate(String infobegindate)
    {
        this.infobegindate = infobegindate;
    }

    public String getInfoenddate()
    {
        return this.infoenddate;
    }

    public void setInfoenddate(String infoenddate)
    {
        this.infoenddate = infoenddate;
    }

    public String getPrice()
    {
        return this.price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getIsused()
    {
        return this.isused;
    }

    public void setIsused(String isused)
    {
        this.isused = isused;
    }

    public String getInfopic()
    {
        return this.infopic;
    }

    public void setInfopic(String infopic)
    {
        this.infopic = infopic;
    }

    public String getIsdel()
    {
        return this.isdel;
    }

    public void setIsdel(String isdel)
    {
        this.isdel = isdel;
    }

    public String getCtimestamp()
    {
        return this.ctimestamp;
    }

    public void setCtimestamp(String ctimestamp)
    {
        this.ctimestamp = ctimestamp;
    }

    @Override
    public String toString()
    {
        return "RecommendBusiness [shopid=" + this.shopid + ", shopname=" + this.shopname + ", logo=" + this.logo + ", infoId=" + this.infoId + ", infoImgUrl=" + this.infoImgUrl + ", infotype=" + this.infotype + ", remark=" + this.remark + ", infotitle=" + this.infotitle + ", infobegindate=" + this.infobegindate + ", infoenddate=" + this.infoenddate + ", price=" + this.price + ", isused=" + this.isused + ", infopic=" + this.infopic + ", isdel=" + this.isdel + ", ctimestamp=" + this.ctimestamp + "]";
    }

}
