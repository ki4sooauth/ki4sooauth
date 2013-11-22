package com.gooagoo.entity.generator.sys;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * 广告位管理
 */

public class AdsManage implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String bidId;//竞拍编号，UUID

    private String adCode;//广告位编码

    private Double startingPrice;//起拍价

    private Double increase;//涨幅

    private String state;//'0-空闲，1-发布，2-已拍，3-已提交资料，4-已审核，5-已收款，6-已卖出',

    private String winnerShooId;//得标商家编号

    private String winnerShooName;//得标商家名称

    private Double bidAmount;//得标金额

    private String id;//商家竞价自动编号

    private Date bidStartTime;//竞价起始时间

    private Date bidEndTime;//竞价结束时间

    private Date effectStartDate;//生效起始日期

    private Date effectEndDate;//生效结束日期

    private Time effectStartTime;//'生效起始时间',

    private Time effectEndTime;//'生效结束时间',

    private String imgUrl;//图片地址

    private String linkUrl;//链接地址

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getBidId()
    {
        return this.bidId;
    }

    public void setBidId(String bidId)
    {
        this.bidId = bidId;
    }

    public String getAdCode()
    {
        return this.adCode;
    }

    public void setAdCode(String adCode)
    {
        this.adCode = adCode;
    }

    public Double getStartingPrice()
    {
        return this.startingPrice;
    }

    public void setStartingPrice(Double startingPrice)
    {
        this.startingPrice = startingPrice;
    }

    public Double getIncrease()
    {
        return this.increase;
    }

    public void setIncrease(Double increase)
    {
        this.increase = increase;
    }

    public String getState()
    {
        return this.state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getWinnerShooId()
    {
        return this.winnerShooId;
    }

    public void setWinnerShooId(String winnerShooId)
    {
        this.winnerShooId = winnerShooId;
    }

    public String getWinnerShooName()
    {
        return this.winnerShooName;
    }

    public void setWinnerShooName(String winnerShooName)
    {
        this.winnerShooName = winnerShooName;
    }

    public Double getBidAmount()
    {
        return this.bidAmount;
    }

    public void setBidAmount(Double bidAmount)
    {
        this.bidAmount = bidAmount;
    }

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Date getBidStartTime()
    {
        return this.bidStartTime;
    }

    public void setBidStartTime(Date bidStartTime)
    {
        this.bidStartTime = bidStartTime;
    }

    public Date getBidEndTime()
    {
        return this.bidEndTime;
    }

    public void setBidEndTime(Date bidEndTime)
    {
        this.bidEndTime = bidEndTime;
    }

    public Date getEffectStartDate()
    {
        return this.effectStartDate;
    }

    public void setEffectStartDate(Date effectStartDate)
    {
        this.effectStartDate = effectStartDate;
    }

    public Date getEffectEndDate()
    {
        return this.effectEndDate;
    }

    public void setEffectEndDate(Date effectEndDate)
    {
        this.effectEndDate = effectEndDate;
    }

    public Time getEffectStartTime()
    {
        return this.effectStartTime;
    }

    public void setEffectStartTime(Time effectStartTime)
    {
        this.effectStartTime = effectStartTime;
    }

    public Time getEffectEndTime()
    {
        return this.effectEndTime;
    }

    public void setEffectEndTime(Time effectEndTime)
    {
        this.effectEndTime = effectEndTime;
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
        return this.bidId + "^" + this.adCode + "^" + this.startingPrice + "^" + this.increase + "^" + this.state + "^" + this.winnerShooId + "^" + this.winnerShooName + "^" + this.bidAmount + "^" + this.id + "^" + this.bidStartTime + "^" + this.bidEndTime + "^" + this.effectStartDate + "^" + this.effectEndDate + "^" + this.effectStartTime + "^" + this.effectEndTime + "^" + this.imgUrl + "^" + this.linkUrl + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
