package com.gooagoo.entity.business.transaction;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.entity.generator.bill.BillAddInfo;
import com.gooagoo.entity.generator.bill.BillInvoiceLog;
import com.gooagoo.entity.generator.bill.BillPayApplication;
import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderPic;

/**
 * 订单信息
 * @author YL
 *
 */
public class OrderBusiness implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String orderInfoUpdateType;//订单信息更新类型1-新建2-增量更新
    private String orderDetailInfoUpdateType;//订单商品详细信息更新类型1-新建2-增量更新3-全量更新
    private String orderCouponInfoUpdateType;//订单优惠凭证详情更新类型1-新建2-增量更新
    private String billInvoiceLogUpdateType;//发票更新类型1-新建2-增量更新
    private String billAddInfoUpdateType;//用户提交的加菜减菜申请（仅针对餐饮）更新类型1-新建2-增量更新
    private OrderInfo orderInfo;//订单信息
    private List<OrderDetailInfo> orderDetailInfoList;//订单商品详细信息
    private List<OrderCouponInfo> orderCouponInfoList;//订单优惠凭证详情
    private List<OrderPic> orderPicList;//订单图片详情
    private BillInvoiceLog billInvoiceLog;//开发票申请信息
    private BillPayApplication billPayApplication;//结账申请（只针对餐饮）
    private List<BillAddInfo> billAddInfoList;//用户提交的加菜减菜申请（仅针对餐饮）

    public String getOrderInfoUpdateType()
    {
        return this.orderInfoUpdateType;
    }

    public void setOrderInfoUpdateType(String orderInfoUpdateType)
    {
        this.orderInfoUpdateType = orderInfoUpdateType;
    }

    public String getOrderDetailInfoUpdateType()
    {
        return this.orderDetailInfoUpdateType;
    }

    public void setOrderDetailInfoUpdateType(String orderDetailInfoUpdateType)
    {
        this.orderDetailInfoUpdateType = orderDetailInfoUpdateType;
    }

    public String getOrderCouponInfoUpdateType()
    {
        return this.orderCouponInfoUpdateType;
    }

    public void setOrderCouponInfoUpdateType(String orderCouponInfoUpdateType)
    {
        this.orderCouponInfoUpdateType = orderCouponInfoUpdateType;
    }

    public String getBillInvoiceLogUpdateType()
    {
        return this.billInvoiceLogUpdateType;
    }

    public void setBillInvoiceLogUpdateType(String billInvoiceLogUpdateType)
    {
        this.billInvoiceLogUpdateType = billInvoiceLogUpdateType;
    }

    public String getBillAddInfoUpdateType()
    {
        return this.billAddInfoUpdateType;
    }

    public void setBillAddInfoUpdateType(String billAddInfoUpdateType)
    {
        this.billAddInfoUpdateType = billAddInfoUpdateType;
    }

    public OrderInfo getOrderInfo()
    {
        return this.orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo)
    {
        this.orderInfo = orderInfo;
    }

    public List<OrderDetailInfo> getOrderDetailInfoList()
    {
        return this.orderDetailInfoList;
    }

    public void setOrderDetailInfoList(List<OrderDetailInfo> orderDetailInfoList)
    {
        this.orderDetailInfoList = orderDetailInfoList;
    }

    public List<OrderCouponInfo> getOrderCouponInfoList()
    {
        return this.orderCouponInfoList;
    }

    public void setOrderCouponInfoList(List<OrderCouponInfo> orderCouponInfoList)
    {
        this.orderCouponInfoList = orderCouponInfoList;
    }

    public List<OrderPic> getOrderPicList()
    {
        return this.orderPicList;
    }

    public void setOrderPicList(List<OrderPic> orderPicList)
    {
        this.orderPicList = orderPicList;
    }

    public BillInvoiceLog getBillInvoiceLog()
    {
        return this.billInvoiceLog;
    }

    public void setBillInvoiceLog(BillInvoiceLog billInvoiceLog)
    {
        this.billInvoiceLog = billInvoiceLog;
    }

    public BillPayApplication getBillPayApplication()
    {
        return this.billPayApplication;
    }

    public void setBillPayApplication(BillPayApplication billPayApplication)
    {
        this.billPayApplication = billPayApplication;
    }

    public List<BillAddInfo> getBillAddInfoList()
    {
        return this.billAddInfoList;
    }

    public void setBillAddInfoList(List<BillAddInfo> billAddInfoList)
    {
        this.billAddInfoList = billAddInfoList;
    }

}
