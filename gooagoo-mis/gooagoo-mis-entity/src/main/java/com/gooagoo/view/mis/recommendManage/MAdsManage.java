package com.gooagoo.view.mis.recommendManage;

import java.sql.Time;
import java.util.Date;
import java.io.Serializable;

/**
 * 广告位管理
 */

public class MAdsManage implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String adCode;//广告位编码
    private String adType;//广告位类型，参考通用字典表的ad_type
    private String adName;//广告位名称
    private String adDescription;//广告位描述
    private String adUrl;//广告位介绍url，图片链接地址
    private String bidId;//竞拍编号，UUID
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

    public String getBidId()
    {
        return bidId;
    }

    public void setBidId(String bidId)
    {
        this.bidId = bidId;
    }

    public Double getStartingPrice()
    {
        return startingPrice;
    }

    public void setStartingPrice(Double startingPrice)
    {
        this.startingPrice = startingPrice;
    }

    public Double getIncrease()
    {
        return increase;
    }

    public void setIncrease(Double increase)
    {
        this.increase = increase;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getWinnerShooId()
    {
        return winnerShooId;
    }

    public void setWinnerShooId(String winnerShooId)
    {
        this.winnerShooId = winnerShooId;
    }

    public String getWinnerShooName()
    {
        return winnerShooName;
    }

    public void setWinnerShooName(String winnerShooName)
    {
        this.winnerShooName = winnerShooName;
    }

    public Double getBidAmount()
    {
        return bidAmount;
    }

    public void setBidAmount(Double bidAmount)
    {
        this.bidAmount = bidAmount;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Date getBidStartTime()
    {
        return bidStartTime;
    }

    public void setBidStartTime(Date bidStartTime)
    {
        this.bidStartTime = bidStartTime;
    }

    public Date getBidEndTime()
    {
        return bidEndTime;
    }

    public void setBidEndTime(Date bidEndTime)
    {
        this.bidEndTime = bidEndTime;
    }

    public Date getEffectStartDate()
    {
        return effectStartDate;
    }

    public void setEffectStartDate(Date effectStartDate)
    {
        this.effectStartDate = effectStartDate;
    }

    public Date getEffectEndDate()
    {
        return effectEndDate;
    }

    public void setEffectEndDate(Date effectEndDate)
    {
        this.effectEndDate = effectEndDate;
    }

    public Time getEffectStartTime()
    {
        return effectStartTime;
    }

    public void setEffectStartTime(Time effectStartTime)
    {
        this.effectStartTime = effectStartTime;
    }

    public Time getEffectEndTime()
    {
        return effectEndTime;
    }

    public void setEffectEndTime(Time effectEndTime)
    {
        this.effectEndTime = effectEndTime;
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

}
