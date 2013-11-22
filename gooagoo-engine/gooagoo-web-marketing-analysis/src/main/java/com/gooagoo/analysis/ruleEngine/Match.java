package com.gooagoo.analysis.ruleEngine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.TimeUtils;

public class Match
{

    private static final DateFormat df = new SimpleDateFormat("HH:mm:ss");

    /**
     * 匹配行为类型
     * @param factActionType
     * @param ruleActionType
     * @return
     */
    public static boolean doMatchActionType(String factActionType, String ruleActionType)
    {
        if (StringUtils.isBlank(ruleActionType))
        {
            return true;
        }
        if (!ruleActionType.equals(factActionType))
        {
            GooagooLog.debug("事实行为类型（" + factActionType + "）与规则行为类型（" + ruleActionType + "）不匹配");
            return false;
        }

        return true;
    }

    /**
     * 匹配日期段
     * @param factEventDate 
     * @param ruleStartDate 
     * @param ruleEndDate 
     * @return
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
    public static boolean doMatchDateScope(Date factEventDate, String ruleStartDate, String ruleEndDate) throws Exception
    {
        if (StringUtils.isNotBlank(ruleStartDate) && factEventDate.before(TimeUtils.convertStringToDate(ruleStartDate)))
        {
            GooagooLog.debug("事实发生日期（" + factEventDate.toLocaleString() + "）在规则起始日期（" + ruleStartDate + "）之前");
            return false;
        }
        if (StringUtils.isNotBlank(ruleEndDate) && factEventDate.after(TimeUtils.convertStringToDate(ruleEndDate)))
        {
            GooagooLog.debug("事实发生日期（" + factEventDate.toLocaleString() + "）在规则结束日期（" + ruleEndDate + "）之后");
            return false;
        }

        return true;
    }

    /**
     * 匹配时间段
     * @param factEventTime
     * @param ruleStartTime
     * @param ruleEndTime
     * @return
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
    public static boolean doMatchTimeScope(Date factEventTime, String ruleStartTime, String ruleEndTime) throws Exception
    {
        if (StringUtils.isNotBlank(ruleStartTime) && factEventTime.before(df.parse(ruleStartTime + ":00")))
        {
            GooagooLog.debug("事实发生时间（" + factEventTime.toLocaleString() + "）在规则起始时间（" + ruleStartTime + ":00" + "）之前");
            return false;
        }
        if (StringUtils.isNotBlank(ruleEndTime) && factEventTime.after(df.parse(ruleEndTime + ":59")))
        {
            GooagooLog.debug("事实发生时间（" + factEventTime.toLocaleString() + "）在规则结束时间（" + ruleEndTime + ":59" + "）之后");
            return false;
        }

        return true;
    }

    /**
     * 匹配星期段
     * @param factEventWeek
     * @param ruleWeekScope
     * @return
     */
    public static boolean doMatchWeekScope(Integer factEventWeek, String ruleWeekScope)
    {
        if (StringUtils.isBlank(ruleWeekScope))
        {
            return true;
        }
        String[] ruleWeekScopes = ruleWeekScope.split(",");
        for (int i = 0; i < ruleWeekScopes.length; i++)
        {
            if (Integer.parseInt(ruleWeekScopes[i]) == factEventWeek)
            {
                break;
            }
            if (i == ruleWeekScopes.length - 1)
            {
                GooagooLog.debug("事实发生星期（" + factEventWeek + "）不在规则星期（" + ruleWeekScope + "）范围内");
                return false;
            }
        }

        return true;
    }

    /**
     * 匹配会员等级
     * @param factVipGrade
     * @param ruleVipGradeStr
     * @return
     */
    public static boolean doMatchVipGrade(String factVipGrade, String ruleVipGrade)
    {
        if (StringUtils.isBlank(ruleVipGrade))
        {
            return true;
        }
        String[] ruleVipGrades = ruleVipGrade.split(",");
        for (int i = 0; i < ruleVipGrades.length; i++)
        {
            if (ruleVipGrades[i].equals(factVipGrade))
            {
                break;
            }
            if (i == ruleVipGrades.length - 1)
            {
                GooagooLog.debug("事实会员等级（" + factVipGrade + "）不在规则会员等级（" + ruleVipGrade + "）范围内");
                return false;
            }
        }

        return true;
    }

    /**
     * 匹配行为来源
     * @param factActionSource
     * @param ruleActionSource
     * @return
     */
    public static boolean doMatchActionSource(String factActionSource, String ruleActionSource)
    {
        if (StringUtils.isBlank(ruleActionSource))
        {
            return true;
        }
        String[] ruleActionSources = ruleActionSource.split(",");
        for (int i = 0; i < ruleActionSources.length; i++)
        {
            if (ruleActionSources[i].equals(factActionSource))
            {
                break;
            }
            if (i == ruleActionSources.length - 1)
            {
                GooagooLog.debug("事实行为来源（" + factActionSource + "）不在规则行为来源（" + ruleActionSource + "）范围内");
                return false;
            }
        }

        return true;
    }

    /**
     * 匹配当天次数
     * @param factTime
     * @param ruleTimeMin
     * @param ruleTimeMax
     * @return
     */
    public static boolean doMatchTime(Integer factTime, Integer ruleTimeMin, Integer ruleTimeMax)
    {
        if (ruleTimeMin != null && factTime.intValue() < ruleTimeMin.intValue())
        {
            GooagooLog.debug("事实当天次数（" + factTime.intValue() + "）未达到规则当天次数（" + ruleTimeMin.intValue() + "）");
            return false;
        }
        if (ruleTimeMax != null && factTime.intValue() > ruleTimeMax.intValue())
        {
            GooagooLog.debug("事实当天次数（" + factTime.intValue() + "）已超过规则当天次数（" + ruleTimeMax.intValue() + "）");
            return false;
        }

        return true;
    }

    /**
     * 匹配累计次数
     * @param factTotalTime
     * @param ruleTotalTimeMin
     * @param ruleTotalTimeMax
     * @return
     */
    public static boolean doMatchTotalTime(Integer factTotalTime, Integer ruleTotalTimeMin, Integer ruleTotalTimeMax)
    {
        if (ruleTotalTimeMin != null && factTotalTime.intValue() < ruleTotalTimeMin.intValue())
        {
            GooagooLog.debug("事实次数（" + factTotalTime.intValue() + "）未达到规则累计次数（" + ruleTotalTimeMin.intValue() + "）范围内");
            return false;
        }
        if (ruleTotalTimeMax != null && factTotalTime.intValue() > ruleTotalTimeMax.intValue())
        {
            GooagooLog.debug("事实次数（" + factTotalTime.intValue() + "）已超过规则累计次数（" + ruleTotalTimeMax.intValue() + "）范围内");
            return false;
        }

        return true;
    }

    /**
     * 匹配区域
     * @param factPosition
     * @param rulePosition
     * @return
     */
    public static boolean doMatchPosition(String factPosition, String rulePosition)
    {
        if (StringUtils.isBlank(rulePosition))
        {
            return true;
        }
        String[] rulePositions = rulePosition.split(",");
        for (int i = 0; i < rulePositions.length; i++)
        {
            if (rulePositions[i].equals(factPosition))
            {
                break;
            }
            if (i == rulePositions.length - 1)
            {
                GooagooLog.debug("事实区域（" + factPosition + "）不在规则区域（" + rulePosition + "）范围内");
                return false;
            }
        }

        return true;
    }

    /**
     * 匹配时长
     * @param factDuration
     * @param ruleDurationMin
     * @param ruleDurationMax
     * @return
     */
    public static boolean doMatchDuration(Long factDuration, Integer ruleDurationMin, Integer ruleDurationMax)
    {
        if (ruleDurationMin != null && factDuration < ruleDurationMin.longValue())
        {
            GooagooLog.debug("事实时长（" + factDuration.intValue() + "）未达到规则时长（" + ruleDurationMin.intValue() + "）范围内");
            return false;
        }
        if (ruleDurationMax != null && factDuration > ruleDurationMax.longValue())
        {
            GooagooLog.debug("事实时长（" + factDuration.intValue() + "）已超过规则时长（" + ruleDurationMax.intValue() + "）范围内");
            return false;
        }

        return true;
    }

    /**
     * 匹配品类
     * @param factMarketingGoodsCategory
     * @param ruleMarketingGoodsCategory
     * @param ruleRelation
     * @return
     */
    public static boolean doMatchMarketingGoodsCategory(List<String> factMarketingGoodsCategory, String ruleMarketingGoodsCategory, String ruleRelation)
    {
        return doMatchMarketingData(factMarketingGoodsCategory, ruleMarketingGoodsCategory, ruleRelation);
    }

    /**
     * 匹配品牌
     * @param factMarketingGoodsBrand
     * @param ruleMarketingGoodsBrand
     * @param ruleRelation
     * @return
     */
    public static boolean doMatchMarketingGoodsBrand(List<String> factMarketingGoodsBrand, String ruleMarketingGoodsBrand, String ruleRelation)
    {
        return doMatchMarketingData(factMarketingGoodsBrand, ruleMarketingGoodsBrand, ruleRelation);
    }

    /**
     * 匹配商品
     * @param factMarketingGoods
     * @param ruleMarketingGoods
     * @param ruleRelation
     * @return
     */
    public static boolean doMatchMarketingGoods(List<String> factMarketingGoods, String ruleMarketingGoods, String ruleRelation)
    {
        return doMatchMarketingData(factMarketingGoods, ruleMarketingGoods, ruleRelation);
    }

    /**
     * 匹配金额
     * @param factConsumeMoney
     * @param ruleConsumeMoneyMin
     * @param ruleConsumeMoneyMax
     * @return
     */
    public static boolean doMatchConsumeMoney(Double factConsumeMoney, Double ruleConsumeMoneyMin, Double ruleConsumeMoneyMax)
    {
        if (ruleConsumeMoneyMin != null && factConsumeMoney.doubleValue() < ruleConsumeMoneyMin.doubleValue())
        {
            GooagooLog.debug("事实金额（" + factConsumeMoney.doubleValue() + "）未达到规则金额（" + ruleConsumeMoneyMin.doubleValue() + "）范围内");
            return false;
        }
        if (ruleConsumeMoneyMax != null && factConsumeMoney.doubleValue() > ruleConsumeMoneyMax.doubleValue())
        {
            GooagooLog.debug("事实金额（" + factConsumeMoney.doubleValue() + "）已超过规则金额（" + ruleConsumeMoneyMax.doubleValue() + "）范围内");
            return false;
        }

        return true;
    }

    /**
     * 匹配活动
     * @param factMarketingActivity
     * @param ruleMarketingActivity
     * @return
     */
    public static boolean doMatchMarketingActivity(String factMarketingActivity, String ruleMarketingActivity)
    {
        if (StringUtils.isBlank(ruleMarketingActivity))
        {
            return true;
        }
        String[] ruleMarketingActivitys = ruleMarketingActivity.split(",");
        for (int i = 0; i < ruleMarketingActivitys.length; i++)
        {
            if (ruleMarketingActivitys[i].equals(factMarketingActivity))
            {
                break;
            }
            if (i == ruleMarketingActivitys.length - 1)
            {
                GooagooLog.debug("事实活动（" + factMarketingActivity + "）不在规则活动（" + ruleMarketingActivity + "）范围内");
                return false;
            }
        }

        return true;
    }

    /**
     * 匹配优惠凭证
     * @param factMarketingCoupon
     * @param ruleMarketingCoupon
     * @return
     */
    public static boolean doMatchMarketingCoupon(String factMarketingCoupon, String ruleMarketingCoupon)
    {
        if (StringUtils.isBlank(ruleMarketingCoupon))
        {
            return true;
        }
        String[] ruleMarketingCoupons = ruleMarketingCoupon.split(",");
        for (int i = 0; i < ruleMarketingCoupons.length; i++)
        {
            if (ruleMarketingCoupons[i].equals(factMarketingCoupon))
            {
                break;
            }
            if (i == ruleMarketingCoupons.length - 1)
            {
                GooagooLog.debug("事实优惠凭证（" + factMarketingCoupon + "）不在规则优惠凭证（" + ruleMarketingCoupon + "）范围内");
                return false;
            }
        }

        return true;
    }

    /**
     * 匹配事件
     * @param factMarketingEvent
     * @param ruleMarketingEvent
     * @return
     */
    public static boolean doMatchMarketingEvent(String factMarketingEvent, String ruleMarketingEvent)
    {
        if (StringUtils.isBlank(ruleMarketingEvent))
        {
            return true;
        }
        String[] ruleMarketingEvents = ruleMarketingEvent.split(",");
        for (int i = 0; i < ruleMarketingEvents.length; i++)
        {
            if (ruleMarketingEvents[i].equals(factMarketingEvent))
            {
                break;
            }
            if (i == ruleMarketingEvents.length - 1)
            {
                GooagooLog.debug("事实事件（" + factMarketingEvent + "）不在规则事件（" + ruleMarketingEvent + "）范围内");
                return false;
            }
        }

        return true;
    }

    /**
     * 匹配服务工具
     * @param factServerTool
     * @param ruleServerTool
     * @return
     */
    public static boolean doMatchServerTools(String factServerTool, String ruleServerTool)
    {
        if (StringUtils.isBlank(ruleServerTool))
        {
            return true;
        }
        String[] ruleServerTools = ruleServerTool.split(",");
        for (int i = 0; i < ruleServerTools.length; i++)
        {
            if (ruleServerTools[i].equals(factServerTool))
            {
                break;
            }
            if (i == ruleServerTools.length - 1)
            {
                GooagooLog.info("事实服务工具（" + factServerTool + "）不在规则服务工具（" + ruleServerTool + "）范围内");
                return false;
            }
        }

        return true;
    }

    /**
     * 匹配是否浏览虚拟商家店面
     * @param factIsVirtualShop
     * @param ruleIsVirtualShop
     * @return
     */
    public static boolean doMatchIsVirtualShop(String factIsVirtualShop, String ruleIsVirtualShop)
    {
        if (StringUtils.isBlank(ruleIsVirtualShop))
        {
            return true;
        }
        if (!ruleIsVirtualShop.equals(factIsVirtualShop))
        {
            GooagooLog.info("事实是否浏览虚拟商家店面（" + factIsVirtualShop + "）不匹配规则是否浏览虚拟商家店面（" + ruleIsVirtualShop + "）");
            return false;
        }

        return true;
    }

    /**
     * 匹配营销数据，包括品牌、品类、商品
     * @param factData
     * @param ruleDate
     * @param ruleRelation
     * @return
     */
    private static boolean doMatchMarketingData(List<String> factDataList, String ruleDate, String ruleRelation)
    {
        if (StringUtils.isBlank(ruleDate))
        {
            return true;
        }
        if (CollectionUtils.isEmpty(factDataList))
        {
            return false;
        }
        String[] ruleDatas = ruleDate.split(",");//规则营销数据ID集合
        if ("N".equals(ruleRelation))
        {
            for (int i = 0; i < factDataList.size(); i++)
            {
                for (int j = 0; j < ruleDatas.length; j++)
                {
                    if (factDataList.get(i).equals(ruleDatas[j]))
                    {
                        return true;
                    }
                }
                if (i == factDataList.size() - 1)
                {
                    GooagooLog.debug("事实营销数据（" + factDataList + "）不匹配规则营销数据（" + ruleDate + "）");
                    return false;
                }
            }

        }
        else if ("Y".equals(ruleRelation))
        {
            //事实中未匹配的商品个数不足规则中的商品个数，终止匹配
            if (factDataList.size() < ruleDatas.length)
            {
                GooagooLog.debug("事实营销数据（" + JsonUtils.toJson(factDataList) + "）不匹配规则营销数据（" + ruleDate + "）");
                return false;
            }
            for (int i = 0; i < factDataList.size(); i++)
            {
                //事实中未匹配的商品个数不足规则中的商品个数，终止匹配
                if (factDataList.size() - i < ruleDatas.length)
                {
                    GooagooLog.debug("事实营销数据（" + JsonUtils.toJson(factDataList) + "）不匹配规则营销数据（" + ruleDate + "）");
                    return false;
                }
                for (int j = 0; j < ruleDatas.length; j++)
                {
                    if (factDataList.get(i).equals(ruleDatas[j]))
                    {
                        //剔除规则中匹配到的商品
                        String[] temp = ruleDatas;
                        ruleDatas = new String[temp.length - 1];
                        for (int k = 0; k < ruleDatas.length; k++)
                        {
                            ruleDatas[k] = k < j ? temp[k] : temp[k + 1];
                        }
                    }
                }
                if (ruleDatas.length == 0)
                {
                    break;
                }
            }
        }
        else
        {
            return false;
        }

        return true;
    }

}
