package com.gooagoo.igus.calendar.serviceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.generator.query.behave.UserShoppingPlanGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingActivityGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.generator.behave.UserShoppingPlan;
import com.gooagoo.entity.generator.behave.UserShoppingPlanExample;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.marketing.MarketingActivityExample;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopInfoExample;
import com.gooagoo.igus.calendar.service.ICalendarService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.calendar.UActivity;
import com.gooagoo.view.gus.web.calendar.UBill;
import com.gooagoo.view.gus.web.calendar.UShoppinglist;

@Service("iCalendarService")
public class ICalendarServiceImpl implements ICalendarService
{

    @Autowired
    private MarketingActivityGeneratorQueryService marketingActivityGeneratorQueryService;

    @Autowired
    private UserShoppingPlanGeneratorQueryService userShoppingPlanGeneratorQueryService;

    @Autowired
    private OrderInfoGeneratorQueryService orderInfoGeneratorQueryService;

    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.CALENDAR_GETACTIVELIST)
    public TransData<Object> getActiveList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            Calendar calendar = Calendar.getInstance();
            Integer year = ServletRequestUtils.getIntParameter(request, "year", calendar.get(Calendar.YEAR));
            Integer month = ServletRequestUtils.getIntParameter(request, "month", calendar.get(Calendar.MONTH) + 1);
            int days = calendar.getActualMaximum(Calendar.DATE); //当月一天多少天
            Date startTime = TimeUtils.convertStringToDate(year + "-" + month + "-" + "01 00:00:00");
            Date endTime = TimeUtils.convertStringToDate(year + "-" + month + "-" + days + " 23:59:59");
            MarketingActivityExample marketingActivityExample = new MarketingActivityExample();
            marketingActivityExample.createCriteria().andStartTimeLessThanOrEqualTo(endTime).andEndTimeGreaterThanOrEqualTo(startTime).andIsDelEqualTo("N").andPublishStatusEqualTo("P");
            List<MarketingActivity> marketingActivityList = this.marketingActivityGeneratorQueryService.selectByExample(marketingActivityExample);
            if (CollectionUtils.isEmpty(marketingActivityList))
            {
                GooagooLog.info("获取活动信息的列表：按时间查询的活动为空");
                return new TransData<Object>(true, MessageConst.CALENDAR_ICALENDAR_GETACTIVELIST_NOTEXIST, null);
            }
            List<UActivity> uactivitieList = new ArrayList<UActivity>();
            Map<String, Boolean> map = new HashMap<String, Boolean>();
            for (MarketingActivity marketingActivity : marketingActivityList)
            {
                try
                {
                    UActivity uactivity = new UActivity();
                    uactivity.setTitle(marketingActivity.getActivityName());
                    uactivity.setEndDate(TimeUtils.convertDateToString(marketingActivity.getEndTime(), "yyyy.MM.dd"));
                    uactivity.setStartDate(TimeUtils.convertDateToString(marketingActivity.getStartTime(), "yyyy.MM.dd"));
                    uactivity.setUrl(UrlUtils.getActiveUrl(marketingActivity.getActivityId()));
                    Boolean flag = map.get(marketingActivity.getShopId());
                    if (flag == null)
                    {
                        ShopInfoExample shopInfoExample = new ShopInfoExample();
                        shopInfoExample.createCriteria().andShopIdEqualTo(marketingActivity.getShopId()).andIsDelEqualTo("N").andShopStatusEqualTo("U");
                        List<ShopInfo> shopInfoList = this.shopInfoGeneratorQueryService.selectByExample(shopInfoExample);
                        if (CollectionUtils.isEmpty(shopInfoList))
                        {
                            map.put(marketingActivity.getShopId(), false);
                            continue;
                        }
                        else
                        {
                            map.put(marketingActivity.getShopId(), true);
                        }
                    }
                    else if (!flag)
                    {
                        continue;
                    }
                    uactivitieList.add(uactivity);
                }
                catch (Exception e)
                {
                    GooagooLog.error("获取活动信息的列表：组装单个活动信息列表异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uactivitieList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取活动信息的列表：获取活动信息的列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.CALENDAR_GETSHOPPINGLISTLIST)
    public TransData<Object> getShoppinglistList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Calendar calendar = Calendar.getInstance();
            Integer year = ServletRequestUtils.getIntParameter(request, "year", calendar.get(Calendar.YEAR));
            Integer month = ServletRequestUtils.getIntParameter(request, "month", calendar.get(Calendar.MONTH) + 1);
            int days = calendar.getActualMaximum(Calendar.DATE); //当月一天多少天
            Date startTime = TimeUtils.convertStringToDate(year + "-" + month + "-" + "01 00:00:00");
            Date endTime = TimeUtils.convertStringToDate(year + "-" + month + "-" + days + " 23:59:59");
            UserShoppingPlanExample userShoppingPlanExample = new UserShoppingPlanExample();
            userShoppingPlanExample.createCriteria().andIsDelEqualTo("N").andPreShoppingTimeBetween(startTime, endTime).andUserIdEqualTo(userId);
            List<UserShoppingPlan> userShoppingPlanList = this.userShoppingPlanGeneratorQueryService.selectByExample(userShoppingPlanExample);
            if (CollectionUtils.isEmpty(userShoppingPlanList))
            {
                GooagooLog.info("获取购物清单列表：按时间查询的购物清单为空");
                return new TransData<Object>(true, MessageConst.CALENDAR_ICALENDAR_GETSHOPPINGLISTLIST_NOTEXIST, null);
            }
            List<UShoppinglist> ushoppinglistList = new ArrayList<UShoppinglist>();
            for (UserShoppingPlan userShoppingPlan : userShoppingPlanList)
            {
                try
                {
                    UShoppinglist ushoppinglist = new UShoppinglist();
                    ushoppinglist.setShoppingListId(userShoppingPlan.getShoppingListId());
                    ushoppinglist.setTitle(userShoppingPlan.getTitle());
                    ushoppinglist.setPreShoppingTime(TimeUtils.convertDateToString(userShoppingPlan.getPreShoppingTime(), "yyyy-MM-dd"));
                    ushoppinglistList.add(ushoppinglist);
                }
                catch (Exception e)
                {
                    GooagooLog.error("获取购物清单列表:组装单个购物清单信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ushoppinglistList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取购物清单列表:获取购物清单列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;

    }

    @Override
    @MessageAnnotation(InterGusConstants.CALENDAR_GETBILLLIST)
    public TransData<Object> getBillList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            Calendar calendar = Calendar.getInstance();
            Integer year = ServletRequestUtils.getIntParameter(request, "year", calendar.get(Calendar.YEAR));
            Integer month = ServletRequestUtils.getIntParameter(request, "month", calendar.get(Calendar.MONTH) + 1);
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            int days = calendar.getActualMaximum(Calendar.DATE); //当月一天多少天
            Date startTime = TimeUtils.convertStringToDate(year + "-" + month + "-" + "01 00:00:00");
            Date endTime = TimeUtils.convertStringToDate(year + "-" + month + "-" + days + " 23:59:59");
            OrderInfoExample orderInfoExample = new OrderInfoExample();
            orderInfoExample.createCriteria().andUserIdEqualTo(userId).andRequestTimeBetween(startTime, endTime).andIsDelEqualTo("N").andBillTypeEqualTo("3");
            List<OrderInfo> orderInfoList = this.orderInfoGeneratorQueryService.selectByExample(orderInfoExample);
            if (CollectionUtils.isEmpty(orderInfoList))
            {
                GooagooLog.info("获取账单信息列表：按时间查询的账单为空");
                return new TransData<Object>(true, MessageConst.CALENDAR_ICALENDAR_GETBILLLIST_NOTEXIST, null);
            }
            List<UBill> ubilllist = new ArrayList<UBill>();
            Map<String, String> map = new HashMap<String, String>();
            for (OrderInfo orderInfo : orderInfoList)
            {
                try
                {
                    UBill ubill = new UBill();
                    ubill.setBillId(orderInfo.getOrderId());
                    if (orderInfo.getPayPrice() != null && orderInfo.getPayPrice() > 0)
                    {
                        ubill.setPayPrice(FormatDataUtils.formatGoodsPrice(orderInfo.getPayPrice()));
                    }
                    else
                    {
                        ubill.setPayPrice("0.00");
                    }
                    ubill.setRequestTime(TimeUtils.convertDateToString(orderInfo.getRequestTime(), "yyyy-MM-dd"));
                    String shopName = map.get(orderInfo.getShopId());//根据key获取值
                    if (shopName != null)
                    {
                        ubill.setShopName(shopName);
                    }
                    else
                    {
                        ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectByPrimaryKey(orderInfo.getShopId());
                        if (shopInfo == null)
                        {
                            continue;
                        }
                        ubill.setShopName(shopInfo.getShopName());
                        map.put(shopInfo.getShopId(), shopInfo.getShopName());
                    }
                    ubilllist.add(ubill);
                }
                catch (Exception e)
                {
                    GooagooLog.error("获取账单信息列表：组装当个账单信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ubilllist);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取账单信息列表：获取账单信息列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;
    }

}
