package com.gooagoo.entity.generator.sys;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告位信息
 */

public class ShopAd implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String adCode;//广告位编码

    private String adType;//广告位类型，参考通用字典表的ad_type

    private String adName;//广告位名称

    private String adDescription;//广告位描述

    private String imgUrl;//'默认图片地址'

    private String linkUrl;//'默认链接地址'

    private String adUrl;//广告位介绍url，图片链接地址

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getAdCode()
    {
        return this.adCode;
    }

    public void setAdCode(String adCode)
    {
        this.adCode = adCode;
    }

    public String getAdType()
    {
        return this.adType;
    }

    public void setAdType(String adType)
    {
        this.adType = adType;
    }

    public String getAdName()
    {
        return this.adName;
    }

    public void setAdName(String adName)
    {
        this.adName = adName;
    }

    public String getAdDescription()
    {
        return this.adDescription;
    }

    public void setAdDescription(String adDescription)
    {
        this.adDescription = adDescription;
    }

    public String getImgUrl()
    {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getLinkUrl()
    {
        return this.linkUrl;
    }

    public void setLinkUrl(String linkUrl)
    {
        this.linkUrl = linkUrl;
    }

    public String getAdUrl()
    {
        return this.adUrl;
    }

    public void setAdUrl(String adUrl)
    {
        this.adUrl = adUrl;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.adCode + "^" + this.adType + "^" + this.adName + "^" + this.adDescription + "^" + this.imgUrl + "^" + this.linkUrl + "^" + this.adUrl + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
