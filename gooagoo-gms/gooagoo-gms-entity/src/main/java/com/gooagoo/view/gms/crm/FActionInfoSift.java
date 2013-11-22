package com.gooagoo.view.gms.crm;

import java.io.Serializable;
import java.util.Date;

/**
 *  crm中  筛选条件的行为属性信息 
 *
 */
public class FActionInfoSift implements Serializable
{
    private static final long serialVersionUID = 1L;
    /**
     * 行为类别：
     * 到店        01
     * 到达区域  02
     * 关注  03
     * 申请会员卡  04
     * 物理卡转换  05
     * 评论  06
     * 留言  07
     * 收藏行为  08
     * 使用优惠凭证  09
     * 浏览商家店面  11
     * 浏览行为  12
     * 使用服务工具 13
     * 消费  14
     */
    private String actionType;
    private Date startDate;//时间段 开始时间
    private Date endDate;//时间段 结束时间
    private Date memberGrade;//会员等级
    private Integer actionCount;//次数
    private String actionTimeLength;//时长
    private String area;//区域
    private String fromResoure;//来源（手机/网站）
    private String goodsCategory;//品类（支持多个）
    private String goodsBrand;//品牌（支持多个）
    private String goodsId;//商品（支持多个）
    private String couponId;//优惠凭证（支持多个）
    private String toolsId;//服务工具（支持多个）
    private String money;//金额
    private String activityId;//活动（支持多个）
    private String eventId;//事件（支持多个）

    public String getActionType()
    {
        return this.actionType;
    }

    public void setActionType(String actionType)
    {
        this.actionType = actionType;
    }

    public Date getStartDate()
    {
        return this.startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getEndDate()
    {
        return this.endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public Date getMemberGrade()
    {
        return this.memberGrade;
    }

    public void setMemberGrade(Date memberGrade)
    {
        this.memberGrade = memberGrade;
    }

    public Integer getActionCount()
    {
        return this.actionCount;
    }

    public void setActionCount(Integer actionCount)
    {
        this.actionCount = actionCount;
    }

    public String getActionTimeLength()
    {
        return this.actionTimeLength;
    }

    public void setActionTimeLength(String actionTimeLength)
    {
        this.actionTimeLength = actionTimeLength;
    }

    public String getArea()
    {
        return this.area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public String getFromResoure()
    {
        return this.fromResoure;
    }

    public void setFromResoure(String fromResoure)
    {
        this.fromResoure = fromResoure;
    }

    public String getGoodsCategory()
    {
        return this.goodsCategory;
    }

    public void setGoodsCategory(String goodsCategory)
    {
        this.goodsCategory = goodsCategory;
    }

    public String getGoodsBrand()
    {
        return this.goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand)
    {
        this.goodsBrand = goodsBrand;
    }

    public String getGoodsId()
    {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getCouponId()
    {
        return this.couponId;
    }

    public void setCouponId(String couponId)
    {
        this.couponId = couponId;
    }

    public String getToolsId()
    {
        return this.toolsId;
    }

    public void setToolsId(String toolsId)
    {
        this.toolsId = toolsId;
    }

    public String getMoney()
    {
        return this.money;
    }

    public void setMoney(String money)
    {
        this.money = money;
    }

    public String getActivityId()
    {
        return this.activityId;
    }

    public void setActivityId(String activityId)
    {
        this.activityId = activityId;
    }

    public String getEventId()
    {
        return this.eventId;
    }

    public void setEventId(String eventId)
    {
        this.eventId = eventId;
    }
}
