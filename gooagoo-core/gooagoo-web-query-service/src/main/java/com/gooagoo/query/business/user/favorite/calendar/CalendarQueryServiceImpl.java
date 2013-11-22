package com.gooagoo.query.business.user.favorite.calendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.user.favorite.calendar.CalendarQueryService;
import com.gooagoo.api.generator.query.behave.UserShoppingPlanGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingActivityGeneratorQueryService;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.user.favorite.calendar.ConsumelistBusiness;
import com.gooagoo.entity.generator.behave.UserShoppingPlanExample;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfoExample.Criteria;
import com.gooagoo.entity.generator.marketing.MarketingActivityExample;

@Service
public class CalendarQueryServiceImpl implements CalendarQueryService
{
    @Autowired
    private OrderInfoGeneratorQueryService orderInfoGeneratorQueryService;
    @Autowired
    private UserShoppingPlanGeneratorQueryService userShoppingPlanGeneratorQueryService;
    @Autowired
    private MarketingActivityGeneratorQueryService marketingActivityGeneratorQueryService;

    @Override
    public ConsumelistBusiness findCalendarByDate(String userId, String date) throws Exception
    {
        //1.日期处理，转换成一天内时间范围
        Date startDate = TimeUtils.convertStringToDate(date + " 00:00:00");
        Date endDate = TimeUtils.convertStringToDate(date + " 23:59:59");

        //2.查询当日订单数目(按订单消费时间，即订单创建时间)
        //订单类型，bill_type:1-远程提交，0-用户提交，1-商家处理，2-申请结账，3-已结账
        OrderInfoExample orderInfoExample1 = new OrderInfoExample();
        Criteria queryOrderInfo1 = orderInfoExample1.createCriteria();
        queryOrderInfo1.andUserIdEqualTo(userId).andCreateTimeBetween(startDate, endDate).andBillTypeNotEqualTo("3").andIsDelEqualTo("N");
        Integer ordernum = this.orderInfoGeneratorQueryService.countByExample(orderInfoExample1);

        //3.查询当日账单数目(按账单消费时间，即订单结账时间)
        OrderInfoExample orderInfoExample2 = new OrderInfoExample();
        Criteria queryOrderInfo2 = orderInfoExample2.createCriteria();
        queryOrderInfo2.andUserIdEqualTo(userId).andPaymentTimeBetween(startDate, endDate).andBillTypeEqualTo("3");
        Integer billnum = this.orderInfoGeneratorQueryService.countByExample(orderInfoExample2);

        //3.查询当日活动数目
        MarketingActivityExample marketingActivityExample = new MarketingActivityExample();
        marketingActivityExample.createCriteria().andStartTimeLessThanOrEqualTo(startDate).andEndTimeGreaterThanOrEqualTo(endDate).andIsDelEqualTo("N");
        Integer activitynum = this.marketingActivityGeneratorQueryService.countByExample(marketingActivityExample);

        //4.查询购物清单 数目
        UserShoppingPlanExample userShoppingPlanExample = new UserShoppingPlanExample();
        userShoppingPlanExample.createCriteria().andUserIdEqualTo(userId).andPreShoppingTimeBetween(startDate, endDate).andIsDelEqualTo("N");
        Integer shopinglistnum = this.userShoppingPlanGeneratorQueryService.countByExample(userShoppingPlanExample);

        //5.组装数据
        ConsumelistBusiness consumelistBusiness = new ConsumelistBusiness();
        consumelistBusiness.setOrdernum(ordernum);
        consumelistBusiness.setBillnum(billnum);
        consumelistBusiness.setActivitynum(activitynum);
        consumelistBusiness.setShopinglistnum(shopinglistnum);

        return consumelistBusiness;
    }

    @Override
    public List<String> findCalendarByMonth(String userId, String date) throws Exception
    {
        //获得当前日期所在月份的天数
        Integer dayNums = TimeUtils.getCountOfMonth(TimeUtils.convertStringToDate(date + "-01 00:00:00"));

        //当天是否有订单，账单，购物清单三者之一的消费日
        List<String> days = new ArrayList<String>();
        for (Integer day = 1; day <= dayNums; day++)
        {
            ConsumelistBusiness consumelistBusiness = this.findCalendarByDate(userId, date + "-" + day.toString());
            //判断当天是否有订单，账单，购物清单
            if (consumelistBusiness.getOrdernum() > 0 || consumelistBusiness.getBillnum() > 0 || consumelistBusiness.getShopinglistnum() > 0)
            {
                days.add(day.toString());
            }
        }

        return days;
    }
}
