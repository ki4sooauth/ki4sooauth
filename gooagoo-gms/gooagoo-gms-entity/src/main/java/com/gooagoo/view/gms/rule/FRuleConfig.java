package com.gooagoo.view.gms.rule;

import java.io.Serializable;
import java.util.Date;

/**
 * 规则配置信息 
 * @author Administrator
 *
 */
public class FRuleConfig implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;//规则配置编号，UUID

    private String shopId;//商家编号

    private String behaveType;//'行为类型，参考通用字典表的behave_type',

    private String isShowDateScope;//是否显示日期段：Y-是，N-否

    private String isShowWeekScope;//是否显示星期段：Y-是，N-否

    private String isShowTimeScope;//是否显示时间段：Y-是，N-否

    private String isShowVipGrade;//是否显示会员等级：Y-是，N-否

    private String isShowActionSource;//是否显示行为来源：Y-是，N-否

    private String isShowTime;//是否显示当天次数：Y-是，N-否

    private String isShowTotalTime;//是否显示累计次数：Y-是，N-否

    private String isShowMarketingGoodsCategory;//是否显示品类：Y-是，N-否

    private String isShowMarketingGoodsBrand;//是否显示品牌：Y-是，N-否

    private String isShowMarketingGoods;//是否显示商品：Y-是，N-否

    private String isShowMarketingAction;//是否显示活动：Y-是，N-否

    private String isShowMarketingCoupon;//是否显示优惠凭证：Y-是，N-否

    private String isShowMarketingEvent;//是否营销内容：Y-是，N-否

    private String isShowServerTools;//是否显示服务工具：Y-是，N-否

    private String isShowPosition;//是否显示区域：Y-是，N-否

    private String isShowDuration;//是否显示时长：Y-是，N-否

    private String isShowConsumeMoney;//是否显示消费金额：Y-是，N-否

    private String isShowVb;//是否显示CMS栏目与文章：Y-是，N-否

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getBehaveType()
    {
        return this.behaveType;
    }

    public void setBehaveType(String behaveType)
    {
        this.behaveType = behaveType;
    }

    public String getIsShowDateScope()
    {
        return this.isShowDateScope;
    }

    public void setIsShowDateScope(String isShowDateScope)
    {
        this.isShowDateScope = isShowDateScope;
    }

    public String getIsShowWeekScope()
    {
        return this.isShowWeekScope;
    }

    public void setIsShowWeekScope(String isShowWeekScope)
    {
        this.isShowWeekScope = isShowWeekScope;
    }

    public String getIsShowTimeScope()
    {
        return this.isShowTimeScope;
    }

    public void setIsShowTimeScope(String isShowTimeScope)
    {
        this.isShowTimeScope = isShowTimeScope;
    }

    public String getIsShowVipGrade()
    {
        return this.isShowVipGrade;
    }

    public void setIsShowVipGrade(String isShowVipGrade)
    {
        this.isShowVipGrade = isShowVipGrade;
    }

    public String getIsShowActionSource()
    {
        return this.isShowActionSource;
    }

    public void setIsShowActionSource(String isShowActionSource)
    {
        this.isShowActionSource = isShowActionSource;
    }

    public String getIsShowTime()
    {
        return this.isShowTime;
    }

    public void setIsShowTime(String isShowTime)
    {
        this.isShowTime = isShowTime;
    }

    public String getIsShowTotalTime()
    {
        return this.isShowTotalTime;
    }

    public void setIsShowTotalTime(String isShowTotalTime)
    {
        this.isShowTotalTime = isShowTotalTime;
    }

    public String getIsShowMarketingGoodsCategory()
    {
        return this.isShowMarketingGoodsCategory;
    }

    public void setIsShowMarketingGoodsCategory(String isShowMarketingGoodsCategory)
    {
        this.isShowMarketingGoodsCategory = isShowMarketingGoodsCategory;
    }

    public String getIsShowMarketingGoodsBrand()
    {
        return this.isShowMarketingGoodsBrand;
    }

    public void setIsShowMarketingGoodsBrand(String isShowMarketingGoodsBrand)
    {
        this.isShowMarketingGoodsBrand = isShowMarketingGoodsBrand;
    }

    public String getIsShowMarketingGoods()
    {
        return this.isShowMarketingGoods;
    }

    public void setIsShowMarketingGoods(String isShowMarketingGoods)
    {
        this.isShowMarketingGoods = isShowMarketingGoods;
    }

    public String getIsShowMarketingAction()
    {
        return this.isShowMarketingAction;
    }

    public void setIsShowMarketingAction(String isShowMarketingAction)
    {
        this.isShowMarketingAction = isShowMarketingAction;
    }

    public String getIsShowMarketingCoupon()
    {
        return this.isShowMarketingCoupon;
    }

    public void setIsShowMarketingCoupon(String isShowMarketingCoupon)
    {
        this.isShowMarketingCoupon = isShowMarketingCoupon;
    }

    public String getIsShowMarketingEvent()
    {
        return this.isShowMarketingEvent;
    }

    public void setIsShowMarketingEvent(String isShowMarketingEvent)
    {
        this.isShowMarketingEvent = isShowMarketingEvent;
    }

    public String getIsShowServerTools()
    {
        return this.isShowServerTools;
    }

    public void setIsShowServerTools(String isShowServerTools)
    {
        this.isShowServerTools = isShowServerTools;
    }

    public String getIsShowPosition()
    {
        return this.isShowPosition;
    }

    public void setIsShowPosition(String isShowPosition)
    {
        this.isShowPosition = isShowPosition;
    }

    public String getIsShowDuration()
    {
        return this.isShowDuration;
    }

    public void setIsShowDuration(String isShowDuration)
    {
        this.isShowDuration = isShowDuration;
    }

    public String getIsShowConsumeMoney()
    {
        return this.isShowConsumeMoney;
    }

    public void setIsShowConsumeMoney(String isShowConsumeMoney)
    {
        this.isShowConsumeMoney = isShowConsumeMoney;
    }

    public String getIsShowVb()
    {
        return this.isShowVb;
    }

    public void setIsShowVb(String isShowVb)
    {
        this.isShowVb = isShowVb;
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

    public Date getcTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

}
