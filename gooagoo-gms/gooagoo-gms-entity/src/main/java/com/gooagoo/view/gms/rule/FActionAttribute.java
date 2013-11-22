package com.gooagoo.view.gms.rule;

import java.io.Serializable;

public class FActionAttribute implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String actionType;//行为类型

    private String dateStart;//日期段Start

    private String dateEnd;//日期段End

    private String timeStart;//时间段Start

    private String timeEnd;//时间段End

    private String weekScope;//星期：多个星期Id,多个用英文半角逗号隔开

    private String vipGrade;//会员等级：卡类型ID，多个用英文半角逗号隔开

    private String vipGradeName;//会员等级：卡名称，多个用英文半角逗号隔开

    private String actionSource;//来源（手机/网站）

    private Integer timeMin;//当天次数min

    private Integer timeMax;//当天次数max

    private Integer totalTimeMin;//累计次数min

    private Integer totalTimeMax;//累计次数max

    private Integer durationMin;//时长min（以分钟为单位）

    private Integer durationMax;//时长max（以分钟为单位）

    private String position;//区域：位置ID，多个用英文半角逗号隔开

    private String relation;//品牌、品类、商品属性设置的枚举值之间为的关系（Y-与，N－或）

    private String marketingGoodsBrand;//品牌：品牌ID，多个用英文半角逗号隔开

    private String marketingGoodsCategory;//品类：品类ID，多个用英文半角逗号隔开

    private String marketingGoods;//商品：商品ID，多个用英文半角逗号隔开

    private String marketingActivity;//活动：活动ID，多个用英文半角逗号隔开

    private String marketingEvent;//营销内容（通知、吆喝、短信、事件）：营销内容ID，多个用英文半角逗号隔开

    private String marketingCoupon;//优惠凭证：优惠凭证ID，多个用英文半角逗号隔开

    private String serverTools;//服务工具：服务工具ID，多个用英文半角逗号隔开

    private String cmsContent;//CMS内容（栏目与文章），多个用英文半角逗号隔开

    private String positionName;//位置名称，多个用英文半角逗号隔开

    private String marketingGoodsBrandName;//品牌名称，多个用英文半角逗号隔开

    private String marketingGoodsCategoryName;//品类：品类名称，多个用英文半角逗号隔开

    private String marketingGoodsName;//商品名称，多个用英文半角逗号隔开

    private String marketingActivityName;//活动名称，多个用英文半角逗号隔开

    private String marketingEventName;//营销内容（通知、吆喝、短信、事件）：营销内容名称，多个用英文半角逗号隔开

    private String marketingCouponName;//优惠凭证：优惠凭证名称，多个用英文半角逗号隔开

    private String serverToolsName;//服务工具名称，多个用英文半角逗号隔开

    private String cmsContentName;//CMS内容标题（栏目与文章），多个用英文半角逗号隔开

    private Double consumeMoneyMax;//消费金额 max

    private Double consumeMoneyMin;//消费金额 min

    public String getActionType()
    {
        return this.actionType;
    }

    public void setActionType(String actionType)
    {
        this.actionType = actionType;
    }

    public String getDateStart()
    {
        return this.dateStart;
    }

    public void setDateStart(String dateStart)
    {
        this.dateStart = dateStart;
    }

    public String getDateEnd()
    {
        return this.dateEnd;
    }

    public void setDateEnd(String dateEnd)
    {
        this.dateEnd = dateEnd;
    }

    public String getTimeStart()
    {
        return this.timeStart;
    }

    public void setTimeStart(String timeStart)
    {
        this.timeStart = timeStart;
    }

    public String getTimeEnd()
    {
        return this.timeEnd;
    }

    public void setTimeEnd(String timeEnd)
    {
        this.timeEnd = timeEnd;
    }

    public String getWeekScope()
    {
        return this.weekScope;
    }

    public void setWeekScope(String weekScope)
    {
        this.weekScope = weekScope;
    }

    public String getVipGrade()
    {
        return this.vipGrade;
    }

    public void setVipGrade(String vipGrade)
    {
        this.vipGrade = vipGrade;
    }

    public String getVipGradeName()
    {
        return this.vipGradeName;
    }

    public void setVipGradeName(String vipGradeName)
    {
        this.vipGradeName = vipGradeName;
    }

    public String getActionSource()
    {
        return this.actionSource;
    }

    public void setActionSource(String actionSource)
    {
        this.actionSource = actionSource;
    }

    public Integer getTimeMin()
    {
        return this.timeMin;
    }

    public void setTimeMin(Integer timeMin)
    {
        this.timeMin = timeMin;
    }

    public Integer getTimeMax()
    {
        return this.timeMax;
    }

    public void setTimeMax(Integer timeMax)
    {
        this.timeMax = timeMax;
    }

    public Integer getTotalTimeMin()
    {
        return this.totalTimeMin;
    }

    public void setTotalTimeMin(Integer totalTimeMin)
    {
        this.totalTimeMin = totalTimeMin;
    }

    public Integer getTotalTimeMax()
    {
        return this.totalTimeMax;
    }

    public void setTotalTimeMax(Integer totalTimeMax)
    {
        this.totalTimeMax = totalTimeMax;
    }

    public Integer getDurationMin()
    {
        return this.durationMin;
    }

    public void setDurationMin(Integer durationMin)
    {
        this.durationMin = durationMin;
    }

    public Integer getDurationMax()
    {
        return this.durationMax;
    }

    public void setDurationMax(Integer durationMax)
    {
        this.durationMax = durationMax;
    }

    public String getPosition()
    {
        return this.position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getRelation()
    {
        return this.relation;
    }

    public void setRelation(String relation)
    {
        this.relation = relation;
    }

    public String getMarketingGoodsBrand()
    {
        return this.marketingGoodsBrand;
    }

    public void setMarketingGoodsBrand(String marketingGoodsBrand)
    {
        this.marketingGoodsBrand = marketingGoodsBrand;
    }

    public String getMarketingGoodsCategory()
    {
        return this.marketingGoodsCategory;
    }

    public void setMarketingGoodsCategory(String marketingGoodsCategory)
    {
        this.marketingGoodsCategory = marketingGoodsCategory;
    }

    public String getMarketingGoods()
    {
        return this.marketingGoods;
    }

    public void setMarketingGoods(String marketingGoods)
    {
        this.marketingGoods = marketingGoods;
    }

    public String getMarketingActivity()
    {
        return this.marketingActivity;
    }

    public void setMarketingActivity(String marketingActivity)
    {
        this.marketingActivity = marketingActivity;
    }

    public String getMarketingEvent()
    {
        return this.marketingEvent;
    }

    public void setMarketingEvent(String marketingEvent)
    {
        this.marketingEvent = marketingEvent;
    }

    public String getMarketingCoupon()
    {
        return this.marketingCoupon;
    }

    public void setMarketingCoupon(String marketingCoupon)
    {
        this.marketingCoupon = marketingCoupon;
    }

    public String getServerTools()
    {
        return this.serverTools;
    }

    public void setServerTools(String serverTools)
    {
        this.serverTools = serverTools;
    }

    public String getCmsContent()
    {
        return this.cmsContent;
    }

    public void setCmsContent(String cmsContent)
    {
        this.cmsContent = cmsContent;
    }

    public String getPositionName()
    {
        return this.positionName;
    }

    public void setPositionName(String positionName)
    {
        this.positionName = positionName;
    }

    public String getMarketingGoodsBrandName()
    {
        return this.marketingGoodsBrandName;
    }

    public void setMarketingGoodsBrandName(String marketingGoodsBrandName)
    {
        this.marketingGoodsBrandName = marketingGoodsBrandName;
    }

    public String getMarketingGoodsCategoryName()
    {
        return this.marketingGoodsCategoryName;
    }

    public void setMarketingGoodsCategoryName(String marketingGoodsCategoryName)
    {
        this.marketingGoodsCategoryName = marketingGoodsCategoryName;
    }

    public String getMarketingGoodsName()
    {
        return this.marketingGoodsName;
    }

    public void setMarketingGoodsName(String marketingGoodsName)
    {
        this.marketingGoodsName = marketingGoodsName;
    }

    public String getMarketingActivityName()
    {
        return this.marketingActivityName;
    }

    public void setMarketingActivityName(String marketingActivityName)
    {
        this.marketingActivityName = marketingActivityName;
    }

    public String getMarketingEventName()
    {
        return this.marketingEventName;
    }

    public void setMarketingEventName(String marketingEventName)
    {
        this.marketingEventName = marketingEventName;
    }

    public String getMarketingCouponName()
    {
        return this.marketingCouponName;
    }

    public void setMarketingCouponName(String marketingCouponName)
    {
        this.marketingCouponName = marketingCouponName;
    }

    public String getServerToolsName()
    {
        return this.serverToolsName;
    }

    public void setServerToolsName(String serverToolsName)
    {
        this.serverToolsName = serverToolsName;
    }

    public String getCmsContentName()
    {
        return this.cmsContentName;
    }

    public void setCmsContentName(String cmsContentName)
    {
        this.cmsContentName = cmsContentName;
    }

    public Double getConsumeMoneyMax()
    {
        return this.consumeMoneyMax;
    }

    public void setConsumeMoneyMax(Double consumeMoneyMax)
    {
        this.consumeMoneyMax = consumeMoneyMax;
    }

    public Double getConsumeMoneyMin()
    {
        return this.consumeMoneyMin;
    }

    public void setConsumeMoneyMin(Double consumeMoneyMin)
    {
        this.consumeMoneyMin = consumeMoneyMin;
    }

}
