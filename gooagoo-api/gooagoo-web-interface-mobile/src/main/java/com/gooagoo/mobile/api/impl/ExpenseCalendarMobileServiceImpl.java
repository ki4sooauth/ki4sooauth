package com.gooagoo.mobile.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.transaction.order.OrderQueryService;
import com.gooagoo.api.business.query.user.favorite.calendar.CalendarQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.transaction.PurchasedGoodsBusiness;
import com.gooagoo.entity.business.user.favorite.calendar.ConsumelistBusiness;
import com.gooagoo.mobile.api.CommonMobileService;
import com.gooagoo.mobile.api.ExpenseCalendarMobileService;
import com.gooagoo.mobile.entity.mobk01.transform.Consumelists;
import com.gooagoo.mobile.entity.mobk01.transform.GetConsumeRecordByDateRoot;
import com.gooagoo.mobile.entity.mobk02.transform.Daylist;
import com.gooagoo.mobile.entity.mobk02.transform.GetConsumeRecordByMonthRoot;
import com.gooagoo.mobile.entity.mobk03.transform.BoughtGoodsRoot;
import com.gooagoo.mobile.entity.mobk03.transform.BoughtGoodslist;
import com.google.gson.Gson;

@Service
public class ExpenseCalendarMobileServiceImpl implements ExpenseCalendarMobileService
{
    @Autowired
    private CommonMobileService commonMobileService;
    @Autowired
    private CalendarQueryService calendarQueryService;
    @Autowired
    private OrderQueryService orderQueryService;

    @Override
    public GetConsumeRecordByDateRoot getConsumeRecordByDate(String userId, String sessionId, String date) throws Exception
    {
        GooagooLog.debug("getConsumeRecordByDate-->入参信息为:【userId=" + userId + " ,sessionId=" + sessionId + " ,date" + date);

        //1.校验用户是否登录
        this.commonMobileService.checkLoginStatus(userId, sessionId);

        //2.查询用户当天的消费记录信息(当日订单、账单、活动、购物清单 数目)
        ConsumelistBusiness consumelistBusiness = this.calendarQueryService.findCalendarByDate(userId, date);

        GooagooLog.debug("查询到用户当天的消费记录信息(当日订单、账单、活动、购物清单 数目)为:【" + new Gson().toJson(consumelistBusiness) + "】");

        //3.封装数据
        Consumelists tempConsumelists = new Consumelists();
        tempConsumelists.setOrdernum(consumelistBusiness.getOrdernum().toString());
        tempConsumelists.setBillnum(consumelistBusiness.getBillnum().toString());
        tempConsumelists.setActivitynum(consumelistBusiness.getActivitynum().toString());
        tempConsumelists.setShopinglistnum(consumelistBusiness.getShopinglistnum().toString());

        GetConsumeRecordByDateRoot root = new GetConsumeRecordByDateRoot();
        root.setConsumelists(tempConsumelists);

        return root;
    }

    @Override
    public GetConsumeRecordByMonthRoot getConsumeRecordByMonth(String userId, String sessionId, String date) throws Exception
    {
        GooagooLog.debug("getConsumeRecordByMonth-->入参信息为:【userId=" + userId + " ,sessionId=" + sessionId + " ,date" + date);

        //1.校验用户是否登录
        this.commonMobileService.checkLoginStatus(userId, sessionId);

        //2.查询当前日期有订单，账单，购物清单消费记录三者之一的消费日
        List<String> days = this.calendarQueryService.findCalendarByMonth(userId, date);

        GooagooLog.debug("查询到当前日期有订单，账单，购物清单消费记录三者之一的消费日信息为为:【" + new Gson().toJson(days) + "】");
        List<Daylist> daylist = null;
        if (CollectionUtils.isNotEmpty(days))
        {

            //3.封装数据
            daylist = new ArrayList<Daylist>();
            for (String day : days)
            {
                Daylist tempDay = new Daylist();
                tempDay.setDay(day);
                daylist.add(tempDay);
            }
        }

        GetConsumeRecordByMonthRoot root = new GetConsumeRecordByMonthRoot();
        root.setDaylist(daylist);
        return root;
    }

    @Override
    public BoughtGoodsRoot getBoughtGoodsInfo(String userId, String sessionId, String shopType, String shopEntityId, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.debug("getBoughtGoodsInfo-->入参信息为:【userId=" + userId + " ,sessionId=" + sessionId + " ,shopType=" + shopType + " ,shopEntityId=" + shopEntityId + " ,pageIndex=" + pageIndex + " ,pageSize" + pageSize);

        //1.校验用户是否登录
        this.commonMobileService.checkLoginStatus(userId, sessionId);

        //2.查询已购商品信息
        List<PurchasedGoodsBusiness> purchasedGoodsBusinessList = this.orderQueryService.findBoughtGoods(userId, null, shopType, shopEntityId, null, null, null, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));

        GooagooLog.debug("查询到已购买商品信息为:【" + new Gson().toJson(purchasedGoodsBusinessList) + "】");
        List<BoughtGoodslist> boughtGoodslist = null;
        if (CollectionUtils.isNotEmpty(purchasedGoodsBusinessList))
        {
            //3.封装数据
            boughtGoodslist = new ArrayList<BoughtGoodslist>();
            for (PurchasedGoodsBusiness purchasedGoodsBusiness : purchasedGoodsBusinessList)
            {
                BoughtGoodslist tempBoughtGoods = new BoughtGoodslist();
                tempBoughtGoods.setGoodsid(purchasedGoodsBusiness.getGoodsId());
                tempBoughtGoods.setGoodsname(purchasedGoodsBusiness.getGoodsName());
                tempBoughtGoods.setPrice(purchasedGoodsBusiness.getPayPrice());
                tempBoughtGoods.setGoodsimg(StringUtils.hasText(purchasedGoodsBusiness.getGoodsImg()) ? JsonUtils.json2List(purchasedGoodsBusiness.getGoodsImg()).get(0) : "");
                tempBoughtGoods.setShopname(purchasedGoodsBusiness.getShopName());
                tempBoughtGoods.setShopentityid(purchasedGoodsBusiness.getShopEntityId());
                tempBoughtGoods.setIntroduceurl(UrlUtils.getGoodsMobileUrl(purchasedGoodsBusiness.getGoodsId()));
                boughtGoodslist.add(tempBoughtGoods);
            }
        }

        BoughtGoodsRoot root = new BoughtGoodsRoot();
        root.setBoughtGoodslist(boughtGoodslist);
        return root;
    }
}
