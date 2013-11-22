package com.gooagoo.analysis.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RuleInput implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopId;//商家ID

    private String actionType;//行为类型：0-消费，1-到店，2-到达区域，3-关注，4-申请会员卡，5-申请物理卡转换，6-评论，7-留言，8-收藏，9-浏览，A-使用服务，B-分享

    private Date eventDate;//行为发生日期（yyyy-MM-dd）

    private Date eventTime;//行为发生时间（HH:mm:ss）

    private Integer eventWeek;//行为发生星期（星期一为1，依次类推）

    private String vipGrade;//会员等级：卡类型ID

    private String actionSource;//行为来源：M-手机，W-网站

    private Integer time;//当天次数

    private Integer totalTime;//累计次数

    private String position;//区域：位置ID

    private long duration;//当前时长（以分钟为单位）

    private List<String> marketingGoodsCategory;//品类：品类ID，多个用英文半角逗号隔开

    private List<String> marketingGoodsBrand;//品牌：品牌ID，多个用英文半角逗号隔开

    private List<String> marketingGoods;//商品：商品ID，多个用英文半角逗号隔开

    private String marketingActivity;//活动：活动ID

    private String marketingEvent;//事件：事件ID

    private String marketingCoupon;//优惠凭证：优惠凭证ID

    private String serverTools;//服务工具：服务工具ID

    private String cmsContent;//cms栏目和内容id

    private Double consumeMoney;//消费金额

    private String isVirtualShop;//是否为虚拟商家店面（Y-是，N－否）

    public String getCmsContent()
    {
        return this.cmsContent;
    }

    public void setCmsContent(String cmsContent)
    {
        this.cmsContent = cmsContent;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getActionType()
    {
        return this.actionType;
    }

    public void setActionType(String actionType)
    {
        this.actionType = actionType;
    }

    public Date getEventDate()
    {
        return this.eventDate;
    }

    public void setEventDate(Date eventDate)
    {
        this.eventDate = eventDate;
    }

    public Date getEventTime()
    {
        return this.eventTime;
    }

    public void setEventTime(Date eventTime)
    {
        this.eventTime = eventTime;
    }

    public Integer getEventWeek()
    {
        return this.eventWeek;
    }

    public void setEventWeek(Integer eventWeek)
    {
        this.eventWeek = eventWeek;
    }

    public String getVipGrade()
    {
        return this.vipGrade;
    }

    public void setVipGrade(String vipGrade)
    {
        this.vipGrade = vipGrade;
    }

    public String getActionSource()
    {
        return this.actionSource;
    }

    public void setActionSource(String actionSource)
    {
        this.actionSource = actionSource;
    }

    public Integer getTime()
    {
        return this.time;
    }

    public void setTime(Integer time)
    {
        this.time = time;
    }

    public Integer getTotalTime()
    {
        return this.totalTime;
    }

    public void setTotalTime(Integer totalTime)
    {
        this.totalTime = totalTime;
    }

    public String getPosition()
    {
        return this.position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public long getDuration()
    {
        return this.duration;
    }

    public void setDuration(long duration)
    {
        this.duration = duration;
    }

    public List<String> getMarketingGoodsCategory()
    {
        return this.marketingGoodsCategory;
    }

    public void setMarketingGoodsCategory(List<String> marketingGoodsCategory)
    {
        this.marketingGoodsCategory = marketingGoodsCategory;
    }

    public List<String> getMarketingGoodsBrand()
    {
        return this.marketingGoodsBrand;
    }

    public void setMarketingGoodsBrand(List<String> marketingGoodsBrand)
    {
        this.marketingGoodsBrand = marketingGoodsBrand;
    }

    public List<String> getMarketingGoods()
    {
        return this.marketingGoods;
    }

    public void setMarketingGoods(List<String> marketingGoods)
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

    public Double getConsumeMoney()
    {
        return this.consumeMoney;
    }

    public void setConsumeMoney(Double consumeMoney)
    {
        this.consumeMoney = consumeMoney;
    }

    public String getIsVirtualShop()
    {
        return this.isVirtualShop;
    }

    public void setIsVirtualShop(String isVirtualShop)
    {
        this.isVirtualShop = isVirtualShop;
    }

}
