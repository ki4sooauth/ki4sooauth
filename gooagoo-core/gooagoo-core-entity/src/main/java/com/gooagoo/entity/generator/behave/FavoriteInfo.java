package com.gooagoo.entity.generator.behave;

import java.io.Serializable;
import java.util.Date;

/**
 * 收藏信息
 */

public class FavoriteInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String favoriteId;//'收藏编号，UUID，对于优惠凭证，只有16位，前14位表示优惠凭证音频编号，后2位固定为01，表示刷优惠凭证',

    private String userId;//用户编号

    private String shopId;//商家编号

    private String infoTitle;//收藏标题，为优惠券、商品、活动的名称

    private String infoType;//收藏类型，参考通用字典表的favorite_type

    private String infoUrl;//收藏地址，为优惠券、商品、活动的地址

    private String objectId;//收藏的商品、活动的id，如果收藏的是优惠凭证，则是优惠凭证编号

    private String source;//信息来源，参考通用字典表的info_source

    private String couponStatus;//优惠凭证状态，参考通用字典表的coupon_status

    private Date useTime;//优惠凭证使用时间

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getFavoriteId()
    {
        return this.favoriteId;
    }

    public void setFavoriteId(String favoriteId)
    {
        this.favoriteId = favoriteId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getInfoTitle()
    {
        return this.infoTitle;
    }

    public void setInfoTitle(String infoTitle)
    {
        this.infoTitle = infoTitle;
    }

    public String getInfoType()
    {
        return this.infoType;
    }

    public void setInfoType(String infoType)
    {
        this.infoType = infoType;
    }

    public String getInfoUrl()
    {
        return this.infoUrl;
    }

    public void setInfoUrl(String infoUrl)
    {
        this.infoUrl = infoUrl;
    }

    public String getObjectId()
    {
        return this.objectId;
    }

    public void setObjectId(String objectId)
    {
        this.objectId = objectId;
    }

    public String getSource()
    {
        return this.source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getCouponStatus()
    {
        return this.couponStatus;
    }

    public void setCouponStatus(String couponStatus)
    {
        this.couponStatus = couponStatus;
    }

    public Date getUseTime()
    {
        return this.useTime;
    }

    public void setUseTime(Date useTime)
    {
        this.useTime = useTime;
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
        return this.favoriteId + "^" + this.userId + "^" + this.shopId + "^" + this.infoTitle + "^" + this.infoType + "^" + this.infoUrl + "^" + this.objectId + "^" + this.source + "^" + this.couponStatus + "^" + this.useTime + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
