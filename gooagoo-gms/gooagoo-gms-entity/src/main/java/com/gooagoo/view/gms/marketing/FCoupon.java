package com.gooagoo.view.gms.marketing;

import java.io.Serializable;
import java.util.Date;

/**
 * 优惠凭证信息
 */
public class FCoupon implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String couponId;//优惠凭证id
    private String couponName;//优惠凭证名称
    private String shopId;//商家id
    private String shopName;//商家名称
    private Date publishStartTime;//优惠凭证发行开始日期
    private Date publishEndTime;//优惠凭证发行截止日期
    private Date useStartTime;//使用生效日期
    private Date useEndTime;//使用截止日期
    private String couponMode;//优惠凭证模式，0-平台默认模式，1-开放模式，2-第三方整合模式',
    private String couponType;//优惠券种类
    private String couponTypeCN;//优惠券种类名称
    private Double couponValue;//优惠凭证额度,代金券对应代金金额，折扣券对应折扣率
    private Integer useNum;//单张使用次数
    private Integer maxNumOwner;//同一用户最多拥有的有效优惠凭证数量
    private String couponUrl;//优惠凭证图片URL
    private String picUrl;//优惠凭证图片的链接地址
    private Integer amount;//优惠凭证最多发放的数量
    private String couponContent;//优惠凭证内容
    private String templateDataId;//模板内容id
    private String mobileVisitUrl;//手机端访问地址
    private String webVisitUrl;//网站端访问地址
    private String status;//状态（待审核，待发布，已发布）
    private String statusCN;//状态名称
    private String couponChannle;//优惠凭证发布渠道，参考通用字典表的coupon_channle
    private String couponSource;//优惠凭证来源，参考通用字典表的coupon_source
    private String couponNo;//优惠凭证号段号码页面显示

    private String note;//审核备注
    private Boolean valid;//是否有效（使用截止日期小于当期时间时无效）
    private String checkJson;//使用校验，保存校验json串，支持品类、实体店、会员等级
    private FCouponJson fCouponJson = new FCouponJson();//使用校验信息 
    private Date useEndTime_FE;//使用截止日期，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录
    private Date useStartTime_TE;//使用生效日期，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    public String getCouponNo()
    {
        return couponNo;
    }

    public void setCouponNo(String couponNo)
    {
        this.couponNo = couponNo;
    }

    public Date getUseStartTime_TE()
    {
        return this.useStartTime_TE;
    }

    public String getCouponMode()
    {
        return couponMode;
    }

    public void setCouponMode(String couponMode)
    {
        this.couponMode = couponMode;
    }

    public void setUseStartTime_TE(Date useStartTime_TE)
    {
        this.useStartTime_TE = useStartTime_TE;
    }

    public String getCouponSource()
    {
        return this.couponSource;
    }

    public void setCouponSource(String couponSource)
    {
        this.couponSource = couponSource;
    }

    public String getCouponId()
    {
        return this.couponId;
    }

    public void setCouponId(String couponId)
    {
        this.couponId = couponId;
    }

    public String getCouponChannle()
    {
        return this.couponChannle;
    }

    public String getPicUrl()
    {
        return this.picUrl;
    }

    public void setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
    }

    public void setCouponChannle(String couponChannle)
    {
        this.couponChannle = couponChannle;
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

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
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

    public String getCouponType()
    {
        return this.couponType;
    }

    public void setCouponType(String couponType)
    {
        this.couponType = couponType;
    }

    public String getCouponTypeCN()
    {
        return this.couponTypeCN;
    }

    public void setCouponTypeCN(String couponTypeCN)
    {
        this.couponTypeCN = couponTypeCN;
    }

    public Double getCouponValue()
    {
        return this.couponValue;
    }

    public void setCouponValue(Double couponValue)
    {
        this.couponValue = couponValue;
    }

    public Integer getUseNum()
    {
        return this.useNum;
    }

    public void setUseNum(Integer useNum)
    {
        this.useNum = useNum;
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

    public Integer getAmount()
    {
        return this.amount;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }

    public String getCouponContent()
    {
        return this.couponContent;
    }

    public void setCouponContent(String couponContent)
    {
        this.couponContent = couponContent;
    }

    public String getTemplateDataId()
    {
        return this.templateDataId;
    }

    public void setTemplateDataId(String templateDataId)
    {
        this.templateDataId = templateDataId;
    }

    public String getMobileVisitUrl()
    {
        return this.mobileVisitUrl;
    }

    public void setMobileVisitUrl(String mobileVisitUrl)
    {
        this.mobileVisitUrl = mobileVisitUrl;
    }

    public String getWebVisitUrl()
    {
        return this.webVisitUrl;
    }

    public void setWebVisitUrl(String webVisitUrl)
    {
        this.webVisitUrl = webVisitUrl;
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatusCN()
    {
        return this.statusCN;
    }

    public void setStatusCN(String statusCN)
    {
        this.statusCN = statusCN;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public Boolean getValid()
    {
        return this.valid;
    }

    public void setValid(Boolean valid)
    {
        this.valid = valid;
    }

    public String getCheckJson()
    {
        return this.checkJson;
    }

    public void setCheckJson(String checkJson)
    {
        this.checkJson = checkJson;
    }

    public FCouponJson getfCouponJson()
    {
        return this.fCouponJson;
    }

    public void setfCouponJson(FCouponJson fCouponJson)
    {
        this.fCouponJson = fCouponJson;
    }

    public Date getUseEndTime_FE()
    {
        return this.useEndTime_FE;
    }

    public void setUseEndTime_FE(Date useEndTime_FE)
    {
        this.useEndTime_FE = useEndTime_FE;
    }

}
