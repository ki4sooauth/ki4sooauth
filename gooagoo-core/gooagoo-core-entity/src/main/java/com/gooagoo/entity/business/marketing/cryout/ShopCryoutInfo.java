package com.gooagoo.entity.business.marketing.cryout;

import java.io.Serializable;

/**
 *  一级菜单 
 */
public class ShopCryoutInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 推送时间+营销内容与用户关联表主键  */
    private String pageId;

    /** 吆喝的id  */
    private String cryoutid = "";

    /** 营销内容与用户关联表主键  */
    private String cryoutUserId = "";

    /** 用户id  */
    private String userid = "";

    /** 商家的id  */
    private String shopid = "";

    /** 商家名称  */
    private String shopname = "";

    /** 商家的logo  */
    private String logo = "";

    /** 商家地址  */
    private String address = "";

    /** 吆喝的内容（有特殊格式的规定）  */
    private String cryouttextmobile = "";

    /** 吆喝内容类型  */
    private String marketinglinktype;

    /** 吆喝内容类型编号  */
    private String marketinglinkid;

    /** 吆喝标题  */
    private String cryouttitle;

    /** 吆喝内容（网站）  */
    private String cryouttextweb;

    /** 极小的缩略图  */
    private String thumbnailpic = "";

    /** 大点的图  */
    private String bmiddlepic = "";

    /** 原始图片（最大的）  */
    private String originalpic = "";

    /** 信息来源：L-现场，R-远程  */
    private String source = "";

    /** 吆喝推送时间  */
    private String pushTime = "";

    /** 是否允许关注：Y-允许，N-不允许   */
    private String allowat = "";

    /** 是否已经关注或者是会员：0-关注卡，1-电子卡，2-实体卡，N-未关注或会员  */
    private String relation = "";

    public String getPageId()
    {
        return this.pageId;
    }

    public void setPageId(String pageId)
    {
        this.pageId = pageId;
    }

    public String getCryoutid()
    {
        return this.cryoutid;
    }

    public void setCryoutid(String cryoutid)
    {
        this.cryoutid = cryoutid;
    }

    public String getCryoutUserId()
    {
        return this.cryoutUserId;
    }

    public void setCryoutUserId(String cryoutUserId)
    {
        this.cryoutUserId = cryoutUserId;
    }

    public String getUserid()
    {
        return this.userid;
    }

    public void setUserid(String userid)
    {
        this.userid = userid;
    }

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

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCryouttextmobile()
    {
        return this.cryouttextmobile;
    }

    public void setCryouttextmobile(String cryouttextmobile)
    {
        this.cryouttextmobile = cryouttextmobile;
    }

    public String getMarketinglinktype()
    {
        return this.marketinglinktype;
    }

    public void setMarketinglinktype(String marketinglinktype)
    {
        this.marketinglinktype = marketinglinktype;
    }

    public String getMarketinglinkid()
    {
        return this.marketinglinkid;
    }

    public void setMarketinglinkid(String marketinglinkid)
    {
        this.marketinglinkid = marketinglinkid;
    }

    public String getCryouttitle()
    {
        return this.cryouttitle;
    }

    public void setCryouttitle(String cryouttitle)
    {
        this.cryouttitle = cryouttitle;
    }

    public String getCryouttextweb()
    {
        return this.cryouttextweb;
    }

    public void setCryouttextweb(String cryouttextweb)
    {
        this.cryouttextweb = cryouttextweb;
    }

    public String getThumbnailpic()
    {
        return this.thumbnailpic;
    }

    public void setThumbnailpic(String thumbnailpic)
    {
        this.thumbnailpic = thumbnailpic;
    }

    public String getBmiddlepic()
    {
        return this.bmiddlepic;
    }

    public void setBmiddlepic(String bmiddlepic)
    {
        this.bmiddlepic = bmiddlepic;
    }

    public String getOriginalpic()
    {
        return this.originalpic;
    }

    public void setOriginalpic(String originalpic)
    {
        this.originalpic = originalpic;
    }

    public String getSource()
    {
        return this.source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getPushTime()
    {
        return this.pushTime;
    }

    public void setPushTime(String pushTime)
    {
        this.pushTime = pushTime;
    }

    public String getAllowat()
    {
        return this.allowat;
    }

    public void setAllowat(String allowat)
    {
        this.allowat = allowat;
    }

    public String getRelation()
    {
        return this.relation;
    }

    public void setRelation(String relation)
    {
        this.relation = relation;
    }

    @Override
    public String toString()
    {
        return "ShopCryoutInfo [pageId=" + this.pageId + ", cryoutid=" + this.cryoutid + ", cryoutUserId=" + this.cryoutUserId + ", userid=" + this.userid + ", shopid=" + this.shopid + ", shopname=" + this.shopname + ", logo=" + this.logo + ", address=" + this.address + ", cryouttextmobile=" + this.cryouttextmobile + ", marketinglinktype=" + this.marketinglinktype + ", marketinglinkid=" + this.marketinglinkid + ", cryouttitle=" + this.cryouttitle + ", cryouttextweb=" + this.cryouttextweb + ", thumbnailpic=" + this.thumbnailpic + ", bmiddlepic=" + this.bmiddlepic + ", originalpic=" + this.originalpic + ", source=" + this.source + ", pushTime=" + this.pushTime + ", allowat=" + this.allowat + ", relation=" + this.relation + "]";
    }

}