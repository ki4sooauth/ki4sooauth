package com.gooagoo.trans.api.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.goods.cache.GoodsCacheCoreService;
import com.gooagoo.api.business.query.transaction.order.OrderQueryService;
import com.gooagoo.api.business.query.transaction.order.ServeFoodQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.user.favorite.coupon.CouponInfoBusiness;
import com.gooagoo.exception.MessageException;
import com.gooagoo.trans.api.ServeDishOperateTransService;
import com.gooagoo.trans.common.MessageConst;
import com.gooagoo.trans.entity.gtsc15.transform.OrderGoodsRoot;
import com.gooagoo.trans.entity.gtsc15.transform.Orderinfolist;
import com.gooagoo.trans.entity.gtsc16.transform.Horderinfolist;
import com.gooagoo.trans.entity.gtsc16.transform.HurryOrderRoot;
import com.gooagoo.trans.entity.gtsc17.transform.SlowOrderRoot;
import com.gooagoo.trans.entity.gtsc17.transform.Sorderinfolist;
import com.gooagoo.trans.entity.gtsc18.transform.WeightConfirmRoot;
import com.gooagoo.trans.entity.gtsc18.transform.Weightconfirmlist;
import com.gooagoo.trans.entity.gtsc27.transform.HookupRoot;
import com.gooagoo.trans.entity.gtsc27.transform.Hookuplist;
import com.gooagoo.trans.entity.gtsc29.transform.Couponinfolist;
import com.gooagoo.trans.entity.gtsc29.transform.FindCouponInfoRoot;
import com.google.gson.Gson;

@Service
public class ServeDishOperateTransServiceImpl implements ServeDishOperateTransService
{
    @Autowired
    private ServeFoodQueryService serveFoodQueryService;
    @Autowired
    private OrderQueryService orderQueryService;
    @Autowired
    private GoodsCacheCoreService goodsCacheCoreService;

    @Override
    public OrderGoodsRoot getOrderDishInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception
    {
        GooagooLog.info("getOrderDishInfo-->入参为:【shopEntityId=" + shopEntityId + " ,cTimeStamp=" + cTimeStamp + " ,mac=" + mac);

        //查询用户起菜请求信息为
        List<Map<String, String>> findOrderDish = this.serveFoodQueryService.findOrderDish(mac, shopEntityId, cTimeStamp);

        GooagooLog.debug("查询用户起菜请求信息为：" + new Gson().toJson(findOrderDish));
        List<Orderinfolist> orderinfolist = null;
        if (CollectionUtils.isNotEmpty(findOrderDish))
        {

            orderinfolist = new ArrayList<Orderinfolist>();

            for (Map<String, String> map : findOrderDish)
            {
                Orderinfolist infolist = new Orderinfolist();
                infolist.setCtimestamp(map.get("orderid"));
                infolist.setCtimestamp(map.get("ctimestamp"));
                infolist.setTablename(map.get("tablename"));
                infolist.setItemserial(map.get("itemserial"));
                infolist.setGoodsnum(map.get("goodsnum"));
                orderinfolist.add(infolist);
            }
        }
        OrderGoodsRoot root = new OrderGoodsRoot();
        root.setOrderinfolist(orderinfolist);
        return root;
    }

    @Override
    public HurryOrderRoot getHurryDishInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception
    {
        GooagooLog.info("getHurryDishInfo-->入参为:【shopEntityId=" + shopEntityId + " ,cTimeStamp=" + cTimeStamp + " ,mac=" + mac);
        //商家查询用户催菜请求
        List<Map<String, String>> findHurryDish = this.serveFoodQueryService.findHurryDish(mac, shopEntityId, cTimeStamp);
        GooagooLog.debug("查询用户催菜请求信息为：" + new Gson().toJson(findHurryDish));
        List<Horderinfolist> horderinfolist = null;
        if (CollectionUtils.isNotEmpty(findHurryDish))
        {

            horderinfolist = new ArrayList<Horderinfolist>();
            for (Map<String, String> map : findHurryDish)
            {
                Horderinfolist infolist = new Horderinfolist();
                infolist.setCtimestamp(map.get("ctimestamp"));
                infolist.setOrderid(map.get("orderid"));
                infolist.setType(map.get("type"));
                infolist.setTablename(map.get("tablename"));
                infolist.setItemserial(map.get("itemserial"));
                horderinfolist.add(infolist);
            }
        }
        HurryOrderRoot root = new HurryOrderRoot();
        root.setHorderinfolist(horderinfolist);
        return root;
    }

    @Override
    public SlowOrderRoot getSlowDishInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception
    {
        GooagooLog.info("getSlowDishInfo-->入参为:【shopEntityId=" + shopEntityId + " ,cTimeStamp=" + cTimeStamp + " ,mac=" + mac);
        //商家查询用户缓菜请求
        List<Map<String, String>> findSlowDish = this.serveFoodQueryService.findSlowDish(mac, shopEntityId, cTimeStamp);
        GooagooLog.debug("查询用户缓菜请求信息为：" + new Gson().toJson(findSlowDish));
        List<Sorderinfolist> sorderinfolist = null;
        if (CollectionUtils.isNotEmpty(findSlowDish))
        {

            sorderinfolist = new ArrayList<Sorderinfolist>();
            for (Map<String, String> map : findSlowDish)
            {
                Sorderinfolist inoflist = new Sorderinfolist();
                inoflist.setCtimestamp(map.get("ctimestamp"));
                inoflist.setOrderid(map.get("orderid"));
                inoflist.setTablename(map.get("tablename"));
                inoflist.setItemserial(map.get("itemserial"));
                inoflist.setGoodsnum(map.get("goodsnum"));
                sorderinfolist.add(inoflist);
            }
        }
        SlowOrderRoot root = new SlowOrderRoot();
        root.setSorderinfolist(sorderinfolist);
        return root;
    }

    @Override
    public WeightConfirmRoot getDishWeightConfirmInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception
    {
        GooagooLog.info("查询重量确认信息(getDishWeightConfirmInfo)-->入参为:【shopEntityId=" + shopEntityId + ",cTimeStamp=" + cTimeStamp + ",mac=" + mac + " 】");
        //查询重量确认信息
        List<Map<String, String>> findConfirmWeight = this.orderQueryService.findConfirmWeight(mac, shopEntityId, cTimeStamp);
        GooagooLog.debug("查询重量确认信息为：" + new Gson().toJson(findConfirmWeight));
        List<Weightconfirmlist> weightconfirmlist = null;
        if (CollectionUtils.isNotEmpty(findConfirmWeight))
        {
            weightconfirmlist = new ArrayList<Weightconfirmlist>();
            for (Map<String, String> map : findConfirmWeight)
            {
                Weightconfirmlist Weightconfirm = new Weightconfirmlist();
                Weightconfirm.setCtimestamp(map.get("ctimestamp"));
                Weightconfirm.setOrderid(map.get("orderid"));
                Weightconfirm.setTablename(map.get("tablename"));
                Weightconfirm.setItemserial(map.get("itemserial"));
                Weightconfirm.setWeightnum(map.get("weightnum"));
                weightconfirmlist.add(Weightconfirm);
            }
        }
        WeightConfirmRoot root = new WeightConfirmRoot();
        root.setWeightconfirmlist(weightconfirmlist);
        return root;
    }

    @Override
    public boolean getEstimateListInfo(String shopEntityId, String itemSerialList) throws Exception
    {
        GooagooLog.info("平台查询博立协议的沽清列表(getEstimateListInfo)-->入参为:【shopEntityId=" + shopEntityId + ",itemSerialList=" + itemSerialList + " 】");
        boolean flag = this.goodsCacheCoreService.addExhaustedGoods(shopEntityId, itemSerialList);
        if (!flag)
        {
            throw new MessageException(MessageConst.TRANS_BILL_UPLOAD_THIRDSHOP_ESTIMATELIST_FAIL);
        }
        return true;
    }

    @Override
    public HookupRoot getHookupInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception
    {
        GooagooLog.info("平台查询博立协议的沽清列表(getHookupInfo)-->入参为:【shopEntityId=" + shopEntityId + ",cTimeStamp=" + cTimeStamp + ",mac=" + mac + " 】");
        //查询博立协议的沽清列表
        List<Map<String, String>> findServe = this.serveFoodQueryService.findServe(mac, shopEntityId, cTimeStamp);
        GooagooLog.debug("平台查询博立协议的沽清列表：" + new Gson().toJson(findServe));
        List<Hookuplist> hookuplist = null;
        if (CollectionUtils.isNotEmpty(findServe))
        {

            hookuplist = new ArrayList<Hookuplist>();
            for (Map<String, String> map : findServe)
            {
                Hookuplist hookup = new Hookuplist();
                hookup.setCtimestamp(map.get("ctimestamp"));
                hookup.setTablename(map.get("tablename"));
                hookup.setOrderid(map.get("orderid"));
                hookup.setItemseriallis(map.get("itemseriallis"));
                hookuplist.add(hookup);
            }
        }
        HookupRoot root = new HookupRoot();
        root.setHookuplist(hookuplist);
        return root;
    }

    @Override
    public FindCouponInfoRoot findCouponInfo(String shopEntityId, String cTimeStamp) throws Exception
    {
        GooagooLog.info("findCouponInfo-->入参为:【shopEntityId=" + shopEntityId + " ,cTimeStamp=" + cTimeStamp);
        //查询优惠凭证信息
        List<CouponInfoBusiness> findCouponInfo = this.orderQueryService.findCouponInfo(shopEntityId, cTimeStamp);
        GooagooLog.debug("查询优惠凭证信息：" + new Gson().toJson(findCouponInfo));
        List<Couponinfolist> couponinfolist = null;
        if (CollectionUtils.isNotEmpty(findCouponInfo))
        {

            couponinfolist = new ArrayList<Couponinfolist>();
            for (CouponInfoBusiness temp : findCouponInfo)
            {
                Couponinfolist infolist = new Couponinfolist();
                infolist.setTablename(temp.getTablename());
                infolist.setOrderid(temp.getOrderid());
                infolist.setCouponuserid(temp.getCouponuserid());
                infolist.setCouponcontent(temp.getCouponcontent());
                infolist.setCoupontype(temp.getCoupontype());
                infolist.setCouponvalue(temp.getCouponvalue());
                infolist.setCtimestamp(temp.getCtimestamp());
                couponinfolist.add(infolist);
            }
        }
        FindCouponInfoRoot root = new FindCouponInfoRoot();
        root.setCouponinfolist(couponinfolist);
        return root;
    }
}
