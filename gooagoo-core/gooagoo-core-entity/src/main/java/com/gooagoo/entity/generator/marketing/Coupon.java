package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;
import java.util.Date;

/**
 * 优惠凭证
 */

public class Coupon implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String couponId;//优惠凭证编号，UUID

    private String couponName;//优惠凭证名称

    private String shopId;//商家编号

    private Date publishStartTime;//优惠凭证发行开始日期

    private Date publishEndTime;//优惠凭证发行截止日期

    private Date useStartTime;//使用生效日期

    private Date useEndTime;//使用截止日期

    private String couponMode;//优惠凭证模式，0-平台默认模式，1-开放模式，2-第三方整合模式',

    private String couponType;//优惠凭证类型，参考通用字典表的coupon_type

    private Double couponValue;//优惠凭证额度，代金券对应代金金额，折扣券对应折扣率

    private Integer amount;//优惠凭证最多发放的数量

    private Integer maxNumOwner;//同一用户最多拥有的有效优惠凭证数量

    private String couponUrl;//优惠凭证图片URL

    private String couponContent;//优惠凭证内容

    private String couponChannle;//优惠凭证发布渠道，参考通用字典表的coupon_channle

    private String couponSource;//优惠凭证来源，参考通用字典表的coupon_source

    private String checkJson;//使用校验，保存校验json串

    private String templateId;//模板编号

    private String templateData;//'模板数据，保存的是html代码',

    private String publishStatus;//状态（审核与发布），参考通用字典表的publish_status

    private String auditNote;//审核备注

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getCouponId()
    {
        return this.couponId;
    }

    public void setCouponId(String couponId)
    {
        this.couponId = couponId;
    }

    public String getCouponName()
    {
        return this.couponName;
    }

    public void setCouponName(String couponName)
    {
        this.couponName = couponName;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public Date getPublishStartTime()
    {
        return this.publishStartTime;
    }

    public void setPublishStartTime(Date publishStartTime)
    {
        this.publishStartTime = publishStartTime;
    }

    public Date getPublishEndTime()
    {
        return this.publishEndTime;
    }

    public void setPublishEndTime(Date publishEndTime)
    {
        this.publishEndTime = publishEndTime;
    }

    public Date getUseStartTime()
    {
        return this.useStartTime;
    }

    public void setUseStartTime(Date useStartTime)
    {
        this.useStartTime = useStartTime;
    }

    public Date getUseEndTime()
    {
        return this.useEndTime;
    }

    public void setUseEndTime(Date useEndTime)
    {
        this.useEndTime = useEndTime;
    }

    public String getCouponMode()
    {
        return this.couponMode;
    }

    public void setCouponMode(String couponMode)
    {
        this.couponMode = couponMode;
    }

    public String getCouponType()
    {
        return this.couponType;
    }

    public void setCouponType(String couponType)
    {
        this.couponType = couponType;
    }

    public Double getCouponValue()
    {
        return this.couponValue;
    }

    public void setCouponValue(Double couponValue)
    {
        this.couponValue = couponValue;
    }

    public Integer getAmount()
    {
        return this.amount;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }

    public Integer getMaxNumOwner()
    {
        return this.maxNumOwner;
    }

    public void setMaxNumOwner(Integer maxNumOwner)
    {
        this.maxNumOwner = maxNumOwner;
    }

    public String getCouponUrl()
    {
        return this.couponUrl;
    }

    public void setCouponUrl(String couponUrl)
    {
        this.couponUrl = couponUrl;
    }

    public String getCouponContent()
    {
        return this.couponContent;
    }

    public void setCouponContent(String couponContent)
    {
        this.couponContent = couponContent;
    }

    public String getCouponChannle()
    {
        return this.couponChannle;
    }

    public void setCouponChannle(String couponChannle)
    {
        this.couponChannle = couponChannle;
    }

    public String getCouponSource()
    {
        return this.couponSource;
    }

    public void setCouponSource(String couponSource)
    {
        this.couponSource = couponSource;
    }

    public String getCheckJson()
    {
        return this.checkJson;
    }

    public void setCheckJson(String checkJson)
    {
        this.checkJson = checkJson;
    }

    public String getTemplateId()
    {
        return this.templateId;
    }

    public void setTemplateId(String templateId)
    {
        this.templateId = templateId;
    }

    public String getTemplateData()
    {
        return this.templateData;
    }

    public void setTemplateData(String templateData)
    {
        this.templateData = templateData;
    }

    public String getPublishStatus()
    {
        return this.publishStatus;
    }

    public void setPublishStatus(String publishStatus)
    {
        this.publishStatus = publishStatus;
    }

    public String getAuditNote()
    {
        return this.auditNote;
    }

    public void setAuditNote(String auditNote)
    {
        this.auditNote = auditNote;
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
        return this.couponId + "^" + this.couponName + "^" + this.shopId + "^" + this.publishStartTime + "^" + this.publishEndTime + "^" + this.useStartTime + "^" + this.useEndTime + "^" + this.couponMode + "^" + this.couponType + "^" + this.couponValue + "^" + this.amount + "^" + this.maxNumOwner + "^" + this.couponUrl + "^" + this.couponContent + "^" + this.couponChannle + "^" + this.couponSource + "^" + this.checkJson + "^" + this.templateId + "^" + this.templateData + "^" + this.publishStatus + "^" + this.auditNote + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
