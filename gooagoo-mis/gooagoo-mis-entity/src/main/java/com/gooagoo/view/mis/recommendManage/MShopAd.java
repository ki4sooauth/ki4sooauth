package com.gooagoo.view.mis.recommendManage;

import java.util.Date;
import java.io.Serializable;

/**
 * 广告位信息
 */

public class MShopAd implements Serializable
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
        return adCode;
    }

    public void setAdCode(String adCode)
    {
        this.adCode = adCode;
    }

    public String getAdType()
    {
        return adType;
    }

    public void setAdType(String adType)
    {
        this.adType = adType;
    }

    public String getAdName()
    {
        return adName;
    }

    public void setAdName(String adName)
    {
        this.adName = adName;
    }

    public String getAdDescription()
    {
        return adDescription;
    }

    public void setAdDescription(String adDescription)
    {
        this.adDescription = adDescription;
    }

    public String getAdUrl()
    {
        return adUrl;
    }

    public void setAdUrl(String adUrl)
    {
        this.adUrl = adUrl;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getcTimeStamp()
    {
        return cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getLinkUrl()
    {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl)
    {
        this.linkUrl = linkUrl;
    }

}
