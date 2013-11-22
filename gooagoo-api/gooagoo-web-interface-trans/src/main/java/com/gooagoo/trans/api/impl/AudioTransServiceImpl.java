package com.gooagoo.trans.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.member.swipe.SwipeCardQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.transaction.OrderBusiness;
import com.gooagoo.entity.business.user.favorite.coupon.CouponInfoBusiness;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.trans.api.AudioTransService;
import com.gooagoo.trans.entity.gtsd01.transform.Couponinfo;
import com.gooagoo.trans.entity.gtsd01.transform.FindCouponInfoByCouponidRoot;
import com.gooagoo.trans.entity.gtsd02.transform.FindOrderInfoByOrderidRoot;
import com.gooagoo.trans.entity.gtsd02.transform.Orderbaseinfo;
import com.gooagoo.trans.entity.gtsd02.transform.Orderdetailinfo;
import com.gooagoo.trans.entity.gtsd03.transform.FindOrderInfoByVoucherinfoidRoot;
import com.gooagoo.trans.entity.gtsd03.transform.Voucherorderbaseinfo;
import com.gooagoo.trans.entity.gtsd03.transform.Voucherorderorderdetailinfo;
import com.gooagoo.trans.entity.gtsd04.transform.Invoiceddetail;
import com.gooagoo.trans.entity.gtsd04.transform.OpenInvoiceRoot;
import com.gooagoo.trans.entity.gtsd04.transform.Openinvoiceinfo;
import com.google.gson.Gson;

@Service
public class AudioTransServiceImpl implements AudioTransService
{
    @Autowired
    private SwipeCardQueryService swipeCardQueryService;

    @Override
    public FindCouponInfoByCouponidRoot findCouponInfoByCouponid(String shopEntityId, String couponId, String shopId) throws Exception
    {
        GooagooLog.info("findCouponInfoByCouponid-->入参:shopEntityId=" + shopEntityId + ",couponId" + couponId + ",shopId" + shopId);
        CouponInfoBusiness info = this.swipeCardQueryService.findCouponInfo(couponId, shopEntityId, shopId);
        GooagooLog.debug("根据shopentityid=" + shopEntityId + ",couponId" + couponId + "根据优惠劵编号查询商家优惠劵信息：" + new Gson().toJson(info));
        Couponinfo couponInfo = null;
        if (null != info)
        {
            couponInfo = new Couponinfo();
            couponInfo.setCouponcontent(info.getCouponcontent());
            couponInfo.setCoupontype(info.getCoupontype());
            couponInfo.setCouponuserid(info.getCouponuserid());
            couponInfo.setCouponvalue(info.getCouponvalue());
            couponInfo.setCtimestamp(info.getCtimestamp());
            couponInfo.setOrderid(info.getOrderid());
            couponInfo.setTablename(info.getTablename());
        }
        FindCouponInfoByCouponidRoot root = new FindCouponInfoByCouponidRoot();
        root.setCouponinfo(couponInfo);
        return root;
    }

    @Override
    public FindOrderInfoByOrderidRoot findOrderInfoByOrderid(String orderId, String shopId) throws Exception
    {
        GooagooLog.info("findOrderInfoByOrderid-->入参:orderId=" + orderId + ",shopId" + shopId);
        OrderBusiness info = this.swipeCardQueryService.findOrderInfo(orderId, shopId);
        GooagooLog.debug("根据orderId=" + orderId + "接口GTSD02:根据订单编号查询商家的订单/账单信息：" + new Gson().toJson(info));
        Orderbaseinfo orderbaseinfo = null;
        if (null != info)
        {
            orderbaseinfo = new Orderbaseinfo();
            orderbaseinfo.setScardno(info.getOrderInfo().getScardNo());
            orderbaseinfo.setCtimestamp(TimeUtils.convertDateToString(info.getOrderInfo().getCTimeStamp(), TimeUtils.FORMAT1));
            orderbaseinfo.setGoodstotalnum(info.getOrderInfo().getGoodsTotalNum().toString());
            orderbaseinfo.setPayprice(info.getOrderInfo().getPayPrice() != null ? info.getOrderInfo().getPayPrice().toString() : "0.0");
            orderbaseinfo.setOrderid(info.getOrderInfo().getOrderId());
            orderbaseinfo.setCreatetime(TimeUtils.convertDateToString(info.getOrderInfo().getCreateTime(), TimeUtils.FORMAT1));
            orderbaseinfo.setTablename(info.getOrderInfo().getDeskName());//桌号
            orderbaseinfo.setGuestsnumber(info.getOrderInfo().getDiningNumbers() != null ? info.getOrderInfo().getDiningNumbers().toString() : "0");//客户数
            orderbaseinfo.setUserid(info.getOrderInfo().getUserId());
            if (CollectionUtils.isNotEmpty(info.getOrderDetailInfoList()))
            {
                List<Orderdetailinfo> list = new ArrayList<Orderdetailinfo>();
                Orderdetailinfo orderdetailinfo = null;
                for (OrderDetailInfo t : info.getOrderDetailInfoList())
                {
                    orderdetailinfo = new Orderdetailinfo();
                    orderdetailinfo.setBilldetailid(t.getOrderDetailId());//详单单号 
                    orderdetailinfo.setGoodsid(t.getGoodsId());
                    orderdetailinfo.setGoodsimg(t.getGoodsImg());
                    orderdetailinfo.setItemserial(t.getItemSerial());
                    orderdetailinfo.setGoodsname(t.getGoodsName());
                    orderdetailinfo.setGoodsnum(t.getGoodsNum() != null ? String.valueOf(t.getGoodsNum()) : "0");
                    orderdetailinfo.setPayprice(t.getPayPrice() != null ? t.getPayPrice().toString() : "0.00");
                    //                    orderdetailinfo.setCookingmethods(t.getAvoidItem());//做法是什么？
                    //                    orderdetailinfo.setWaitcallmark(t.)//等待标记
                    list.add(orderdetailinfo);
                }
                orderbaseinfo.setOrderdetailinfo(list);
            }
        }
        FindOrderInfoByOrderidRoot root = new FindOrderInfoByOrderidRoot();
        root.setOrderbaseinfo(orderbaseinfo);
        return root;
    }

    @Override
    public FindOrderInfoByVoucherinfoidRoot findOrderInfoByVoucherinfoid(String orderId, String shopId) throws Exception
    {
        GooagooLog.info("findOrderInfoByVoucherinfoid-->入参:orderId=" + orderId + ",shopId" + shopId);
        OrderBusiness info = this.swipeCardQueryService.findPickGoodsInfo(orderId, shopId);
        GooagooLog.debug("根据orderId=" + orderId + "接口GTSD03:根据提货凭证编号查询商家订单/账单信息：" + new Gson().toJson(info));

        Voucherorderbaseinfo orderbaseinfo = null;
        if (null != info)
        {
            orderbaseinfo = new Voucherorderbaseinfo();
            orderbaseinfo.setScardno(info.getOrderInfo().getScardNo());
            orderbaseinfo.setCtimestamp(TimeUtils.convertDateToString(info.getOrderInfo().getCTimeStamp(), TimeUtils.FORMAT1));
            orderbaseinfo.setGoodstotalnum(info.getOrderInfo().getGoodsTotalNum().toString());
            orderbaseinfo.setPayprice(info.getOrderInfo().getPayPrice() != null ? info.getOrderInfo().getPayPrice().toString() : "0.0");
            orderbaseinfo.setOrderid(info.getOrderInfo().getOrderId());
            orderbaseinfo.setCreatetime(TimeUtils.convertDateToString(info.getOrderInfo().getCreateTime(), TimeUtils.FORMAT1));
            orderbaseinfo.setTablename(info.getOrderInfo().getDeskName());//桌号
            orderbaseinfo.setGuestsnumber(info.getOrderInfo().getDiningNumbers() != null ? info.getOrderInfo().getDiningNumbers().toString() : "0");//客户数
            orderbaseinfo.setUserid(info.getOrderInfo().getUserId());
            if (CollectionUtils.isNotEmpty(info.getOrderDetailInfoList()))
            {
                List<Voucherorderorderdetailinfo> list = new ArrayList<Voucherorderorderdetailinfo>();
                Voucherorderorderdetailinfo orderdetailinfo = null;
                for (OrderDetailInfo t : info.getOrderDetailInfoList())
                {
                    orderdetailinfo = new Voucherorderorderdetailinfo();
                    orderdetailinfo.setBilldetailid(t.getOrderDetailId());//详单单号 
                    orderdetailinfo.setGoodsid(t.getGoodsId());
                    orderdetailinfo.setGoodsimg(t.getGoodsImg());
                    orderdetailinfo.setItemserial(t.getItemSerial());
                    orderdetailinfo.setGoodsname(t.getGoodsName());
                    orderdetailinfo.setGoodsnum(t.getGoodsNum() != null ? String.valueOf(t.getGoodsNum()) : "0");
                    orderdetailinfo.setPayprice(t.getPayPrice() != null ? String.valueOf(t.getPayPrice()) : "0.00");
                    //                    orderdetailinfo.setCookingmethods(t.getAvoidItem());//做法是什么？
                    //                    orderdetailinfo.setWaitcallmark(t.)//等待标记?
                    list.add(orderdetailinfo);
                }
                orderbaseinfo.setVoucherorderorderdetailinfo(list);
            }
        }
        FindOrderInfoByVoucherinfoidRoot root = new FindOrderInfoByVoucherinfoidRoot();
        root.setVoucherorderbaseinfo(orderbaseinfo);
        return root;
    }

    @Override
    public OpenInvoiceRoot findInvoiceInfo(String orderId, String shopId) throws Exception
    {
        GooagooLog.info("findInvoiceInfo-->入参:orderId=" + orderId + ",shopId" + shopId);
        OrderBusiness info = this.swipeCardQueryService.findInvoiceInfo(orderId, shopId);
        GooagooLog.debug("根据orderId=" + orderId + "接口GTSD04:根据发票凭证查询发票申请信息：" + new Gson().toJson(info));
        Openinvoiceinfo openinvoiceinfo = null;
        if (null != info)
        {
            openinvoiceinfo = new Openinvoiceinfo();
            openinvoiceinfo.setBillid(info.getOrderInfo().getOrderId());
            openinvoiceinfo.setCtimestamp(TimeUtils.convertDateToString(info.getBillInvoiceLog().getCTimeStamp(), TimeUtils.FORMAT1));
            openinvoiceinfo.setInvoiceditem(info.getBillInvoiceLog().getInvoicedItem());
            openinvoiceinfo.setInvoicedprice(info.getBillInvoiceLog().getInvoicedPrice().toString());
            openinvoiceinfo.setInvoicedtitle(info.getBillInvoiceLog().getInvoicedTile());
            openinvoiceinfo.setInvoicedrequesttime(TimeUtils.convertDateToString(info.getBillInvoiceLog().getInvoicedRequestTime(), TimeUtils.FORMAT1));
            openinvoiceinfo.setShopid(info.getBillInvoiceLog().getShopId());
            openinvoiceinfo.setUserid(info.getBillInvoiceLog().getUserId());
            openinvoiceinfo.setDeskno(info.getOrderInfo().getDeskName());//桌号
            openinvoiceinfo.setInvoicedtime(info.getBillInvoiceLog().getInvoicedTime() != null ? TimeUtils.convertDateToString(info.getBillInvoiceLog().getInvoicedTime(), TimeUtils.FORMAT1) : null);
            openinvoiceinfo.setNeedinvoiceddetail(info.getBillInvoiceLog().getNeedInvoicedDetail());
            List<Invoiceddetail> list = null;
            if (CollectionUtils.isNotEmpty(info.getOrderDetailInfoList()))
            {
                list = new ArrayList<Invoiceddetail>();
                for (OrderDetailInfo t : info.getOrderDetailInfoList())
                {
                    Invoiceddetail invoiceddetail = new Invoiceddetail();
                    invoiceddetail.setGoodsname(t.getGoodsName());
                    invoiceddetail.setGoodsnum(t.getGoodsNum().toString());
                    invoiceddetail.setGoodsprice(t.getPrice().toString());//商品单价
                    invoiceddetail.setPayprice(t.getPayPrice().toString());
                    list.add(invoiceddetail);
                }
            }
            openinvoiceinfo.setInvoiceddetail(list);
        }
        OpenInvoiceRoot root = new OpenInvoiceRoot();
        root.setOpeninvoiceinfo(openinvoiceinfo);
        return root;
    }

}
