package com.gooagoo.trans.api.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.transaction.invoice.InvoiceCoreService;
import com.gooagoo.api.business.core.transaction.order.ShopBillCoreService;
import com.gooagoo.api.business.core.transaction.order.ShopOrderCoreService;
import com.gooagoo.api.business.query.transaction.apply.ApplyQueryService;
import com.gooagoo.api.business.query.transaction.order.OrderQueryService;
import com.gooagoo.api.generator.query.bill.OrderInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderPicGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.transaction.BillPayApplicationBusiness;
import com.gooagoo.entity.business.transaction.OrderBusiness;
import com.gooagoo.entity.business.transaction.OrderDetailInfoBusiness;
import com.gooagoo.entity.business.transaction.OrderLinkDetailInfoBusiness;
import com.gooagoo.entity.business.transaction.OrderResult;
import com.gooagoo.entity.generator.bill.BillAddInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.entity.generator.bill.OrderPic;
import com.gooagoo.entity.generator.bill.OrderPicExample;
import com.gooagoo.entity.generator.bill.OriginalBillDetail;
import com.gooagoo.entity.generator.bill.OriginalBillInfo;
import com.gooagoo.entity.generator.bill.OriginalBillPic;
import com.gooagoo.entity.generator.bill.ShopOrderDetail;
import com.gooagoo.entity.generator.bill.ShopOrderInfo;
import com.gooagoo.entity.generator.bill.ShopOrderPic;
import com.gooagoo.exception.MessageException;
import com.gooagoo.trans.api.OrderManageTransService;
import com.gooagoo.trans.common.MessageConst;
import com.gooagoo.trans.common.OrderGoodsInfo;
import com.gooagoo.trans.common.OrderInfoJson;
import com.gooagoo.trans.entity.gtsc01.transform.BillPayRoot;
import com.gooagoo.trans.entity.gtsc01.transform.Billpay;
import com.gooagoo.trans.entity.gtsc02.transform.OrderRoot;
import com.gooagoo.trans.entity.gtsc02.transform.Orderbaseinfo;
import com.gooagoo.trans.entity.gtsc02.transform.Orderdetailinfo;
import com.gooagoo.trans.entity.gtsc03.transform.Invoiceddetail;
import com.gooagoo.trans.entity.gtsc03.transform.OpenInvoiceRoot;
import com.gooagoo.trans.entity.gtsc03.transform.Openinvoiceinfo;
import com.gooagoo.trans.entity.gtsc14.transform.FindBillAddOrSubRoot;
import com.gooagoo.trans.entity.gtsc14.transform.OrderAddOrSubbaseinfo;
import com.gooagoo.trans.entity.gtsc14.transform.OrderAddOrSubdetailinfo;
import com.google.gson.Gson;

@Service
public class OrderManageTransServiceImpl implements OrderManageTransService
{
    @Autowired
    private ApplyQueryService applyQueryService;
    @Autowired
    private ShopBillCoreService shopBillCoreService;
    @Autowired
    private ShopOrderCoreService shopOrderCoreService;
    @Autowired
    private OrderQueryService orderQueryService;
    @Autowired
    private OrderInfoGeneratorQueryService orderInfoGeneratorQueryService;
    @Autowired
    private OrderPicGeneratorQueryService orderPicGeneratorQueryService;
    @Autowired
    private InvoiceCoreService invoiceCoreService;

    @Override
    public BillPayRoot getBillPayApplyInfo(String shopentityid, String ctimestamp) throws Exception
    {
        GooagooLog.info("getBillPayApplyInfo-->入参:shopentityid=" + shopentityid + ",ctimestamp=" + ctimestamp);
        //1.查询结账申请信息
        List<BillPayApplicationBusiness> billPayApplicationBusinessesList = this.applyQueryService.findApplyBill(shopentityid, ctimestamp);
        GooagooLog.debug("查询到的结账申请信息为:" + new Gson().toJson(billPayApplicationBusinessesList));

        //2.封装查询到的结账申请信息
        List<Billpay> billpayList = null;
        if (CollectionUtils.isNotEmpty(billPayApplicationBusinessesList))
        {
            billpayList = new ArrayList<Billpay>();
            for (BillPayApplicationBusiness temp : billPayApplicationBusinessesList)
            {
                Billpay billpay = new Billpay();
                billpay.setApplytime(temp.getApplytime());
                billpay.setId(temp.getOrderId());
                billpay.setDeskno(temp.getTableName());
                billpay.setRoomid(temp.getRoomName());
                billpay.setOriginalprice(temp.getOriginalPrice());
                billpay.setScardno(temp.getScardno());
                billpay.setOrderid(temp.getOrderId());
                //优惠凭证信息{[favoriteid:"",couponcontent:""]}
                billpay.setCouponinfo(temp.getCouponList() != null ? new Gson().toJson(temp.getCouponList()) : "");
                billpayList.add(billpay);
            }
        }
        //3.组装返回参数
        BillPayRoot root = new BillPayRoot();
        root.setBillpay(billpayList);
        return root;
    }

    @Override
    public OrderRoot getUserOrderInfo(String shopentityid, String scardno, String ctimestamp) throws Exception
    {
        GooagooLog.info("getUserOrderInfo-->入参:shopentityid=" + shopentityid + ",ctimestamp=" + ctimestamp + ",scardno=" + scardno);
        //1.用户获取账单信息接口（商家服务器）
        OrderLinkDetailInfoBusiness orderLinkDetailInfoBusiness = this.orderQueryService.findOrderListForAll(null, null, null, null, null, scardno, shopentityid, ctimestamp, null, null, null, null, null);

        GooagooLog.debug("商家查询到的用户订单信息为：" + new Gson().toJson(orderLinkDetailInfoBusiness));

        //2.封装返回用户订单信息
        List<Orderbaseinfo> orderbaseinfoList = null;
        if (CollectionUtils.isNotEmpty(orderLinkDetailInfoBusiness.getOrderDetailInfoBusiness()) && orderLinkDetailInfoBusiness != null)
        {
            orderbaseinfoList = new ArrayList<Orderbaseinfo>();
            for (OrderDetailInfoBusiness temp : orderLinkDetailInfoBusiness.getOrderDetailInfoBusiness())
            {
                Orderbaseinfo orderbaseinfo = new Orderbaseinfo();
                orderbaseinfo.setScardno(temp.getScardno());
                orderbaseinfo.setCtimestamp(temp.getCtimestamp());
                orderbaseinfo.setGoodstotalnum(temp.getGoodstotalnum());
                orderbaseinfo.setPayprice(temp.getPayprice());
                orderbaseinfo.setOrderid(temp.getOrderid());//账单编号
                orderbaseinfo.setCreatetime(temp.getCreatetime());
                orderbaseinfo.setTablename(temp.getTableNo());
                orderbaseinfo.setUserid(temp.getUserid());
                //订单详细信息
                List<Orderdetailinfo> orderdetailinfoList = null;
                if (CollectionUtils.isNotEmpty(temp.getOrderDetailInfoList()))
                {
                    orderdetailinfoList = new java.util.ArrayList<Orderdetailinfo>();
                    for (OrderDetailInfo orderDetailInfo : temp.getOrderDetailInfoList())
                    {
                        Orderdetailinfo orderdetailinfo = new Orderdetailinfo();
                        orderdetailinfo.setGoodsid(orderDetailInfo.getGoodsId());
                        orderdetailinfo.setItemserial(orderDetailInfo.getItemSerial());
                        orderdetailinfo.setGoodsimg(orderDetailInfo.getGoodsImg());
                        orderdetailinfo.setGoodsname(orderDetailInfo.getGoodsName());
                        orderdetailinfo.setGoodsnum(orderDetailInfo.getGoodsNum().toString());
                        orderdetailinfo.setPayprice(orderDetailInfo.getPayPrice().toString());
                        orderdetailinfo.setBilldetailid(orderDetailInfo.getOrderDetailId());
                        orderdetailinfoList.add(orderdetailinfo);
                    }

                }
                orderbaseinfo.setOrderdetailinfo(orderdetailinfoList);
                orderbaseinfoList.add(orderbaseinfo);
            }
        }

        //3.组装返回数据
        OrderRoot root = new OrderRoot();
        root.setOrderbaseinfo(orderbaseinfoList);
        return root;
    }

    @Override
    public OpenInvoiceRoot getOpenInvoiceApplyInfo(String shopentityid, String ctimestamp) throws Exception
    {
        GooagooLog.info("getOpenInvoiceApplyInfo-->入参:shopentityid=" + shopentityid + ",ctimestamp=" + ctimestamp);
        //1.开发票申请信息查询
        List<OrderBusiness> orderBusinessesList = this.applyQueryService.findApplyInvoiceList(shopentityid, ctimestamp);
        GooagooLog.debug("取出来的开发票申请信息为:" + new Gson().toJson(orderBusinessesList));
        List<Openinvoiceinfo> openinvoiceinfoList = null;
        //开发票申请信息查询结果信息非空校验
        if (CollectionUtils.isNotEmpty(orderBusinessesList))
        {
            //2.封装查询到的开发票申请信息
            openinvoiceinfoList = new ArrayList<Openinvoiceinfo>();
            for (OrderBusiness temp : orderBusinessesList)
            {
                Openinvoiceinfo openinvoiceinfo = new Openinvoiceinfo();
                openinvoiceinfo.setBillid(temp.getBillInvoiceLog().getOrderId());
                openinvoiceinfo.setCtimestamp(TimeUtils.convertDateToString(temp.getBillInvoiceLog().getCTimeStamp(), TimeUtils.FORMAT1));
                openinvoiceinfo.setDeskno(temp.getOrderInfo().getDeskName());
                openinvoiceinfo.setInvoiceditem(temp.getBillInvoiceLog().getInvoicedItem());
                openinvoiceinfo.setInvoicedprice(temp.getBillInvoiceLog().getInvoicedPrice().toString());
                openinvoiceinfo.setInvoicedrequesttime(TimeUtils.convertDateToString(temp.getBillInvoiceLog().getInvoicedRequestTime(), TimeUtils.FORMAT1));
                openinvoiceinfo.setInvoicedtime(temp.getBillInvoiceLog().getInvoicedTime() != null ? TimeUtils.convertDateToString(temp.getBillInvoiceLog().getInvoicedTime(), TimeUtils.FORMAT1) : "");
                openinvoiceinfo.setInvoicedtitle(temp.getBillInvoiceLog().getInvoicedTile());
                openinvoiceinfo.setNeedinvoiceddetail(temp.getBillInvoiceLog().getNeedInvoicedDetail());
                openinvoiceinfo.setShopid(temp.getOrderInfo().getShopId());
                openinvoiceinfo.setUserid(temp.getOrderInfo().getUserId());
                //发票明细详细信息
                if (CollectionUtils.isNotEmpty(temp.getOrderDetailInfoList()))
                {
                    List<Invoiceddetail> invoiceddetailList = new ArrayList<Invoiceddetail>();
                    for (OrderDetailInfo tempOrderDetailInfo : temp.getOrderDetailInfoList())
                    {
                        Invoiceddetail invoiceddetail = new Invoiceddetail();
                        invoiceddetail.setGoodsname(tempOrderDetailInfo.getGoodsName());
                        invoiceddetail.setGoodsnum(tempOrderDetailInfo.getGoodsNum().toString());
                        invoiceddetail.setGoodsprice(tempOrderDetailInfo.getPayPrice().toString());
                        invoiceddetail.setPayprice(tempOrderDetailInfo.getPayPrice().toString());
                        invoiceddetailList.add(invoiceddetail);
                    }
                    openinvoiceinfo.setInvoiceddetail(invoiceddetailList);
                }
                else
                {
                    openinvoiceinfo.setInvoiceddetail(null);
                }
                openinvoiceinfoList.add(openinvoiceinfo);
            }
        }
        //组装返回参数
        OpenInvoiceRoot root = new OpenInvoiceRoot();
        root.setOpeninvoiceinfo(openinvoiceinfoList);
        return root;
    }

    @Override
    public String getBill(String shopentityid, String mac) throws Exception
    {
        GooagooLog.info("getBill-->入参:mac=" + mac + ",shopentityid=" + shopentityid);
        //1.查询账单信息
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        orderInfoExample.createCriteria().andShopEntityIdEqualTo(shopentityid).andMacEqualTo(mac).andIsDelEqualTo("N").andBillTypeEqualTo("3");
        orderInfoExample.setOrderByClause("c_time_stamp desc");
        List<OrderInfo> orderInfoList = this.orderInfoGeneratorQueryService.selectByExample(orderInfoExample);
        //2.拿取最近一条账单信息
        String orderId = orderInfoList.get(0).getOrderId();
        OrderPicExample orderPicExample = new OrderPicExample();
        orderPicExample.createCriteria().andOrderIdEqualTo(orderId).andPicTypeEqualTo("1").andIsDelEqualTo("N");
        orderPicExample.setOrderByClause("create_time desc");
        List<OrderPic> orderPicList = this.orderPicGeneratorQueryService.selectByExample(orderPicExample);

        String picurl = null;
        if (CollectionUtils.isNotEmpty(orderPicList))
        {
            //3.拿到账单图片
            picurl = orderPicList.get(0).getPicUrl();
        }

        return picurl;
    }

    @Override
    public String uploadShopBill(String mac, String data, String shopId, String shopEntityId) throws Exception
    {
        GooagooLog.info("uploadShopBill-->入参:mac=" + mac + ",data=" + data + ",shopId=" + shopId + ",shopEntityId" + shopEntityId);
        //1.从商家账单json串中取出订单信息
        Gson json = new Gson();
        OrderInfoJson orderInfoJson = json.fromJson(data, OrderInfoJson.class);
        GooagooLog.debug("取出来的商家账单信息为:" + new Gson().toJson(orderInfoJson));

        //2.封装原始商家账单信息
        OriginalBillInfo originalBillInfo = new OriginalBillInfo();
        originalBillInfo.setMac(mac);
        originalBillInfo.setShopId(shopId);
        originalBillInfo.setShopEntityId(shopEntityId);
        originalBillInfo.setThirdOrderId(orderInfoJson.getBillNo());
        originalBillInfo.setScardNo(orderInfoJson.getScardno());
        originalBillInfo.setOriginalPrice(orderInfoJson.getOriginalPrice());
        originalBillInfo.setPayPrice(orderInfoJson.getPayPrice());
        originalBillInfo.setDeskName(orderInfoJson.getDeskNo());
        originalBillInfo.setDiscountRate(orderInfoJson.getDiscountRate());
        originalBillInfo.setPayPrice(orderInfoJson.getPayPrice());
        originalBillInfo.setGoodsTotalNum(orderInfoJson.getTotalNum());
        if (StringUtils.hasText(orderInfoJson.getRequest_start_time()))
        {
            originalBillInfo.setRequestTime(TimeUtils.convertStringToDate(orderInfoJson.getRequest_start_time()));
        }
        else
        {
            originalBillInfo.setRequestTime(new Date());
        }

        GooagooLog.debug("封装的原始商家账单信息为:" + new Gson().toJson(originalBillInfo));

        //3.封装原始商家账单明细信息
        List<OriginalBillDetail> originalBillDetailList = new ArrayList<OriginalBillDetail>();
        for (OrderGoodsInfo tempOrderGoodsInfo : orderInfoJson.getList())
        {
            OriginalBillDetail originalBillDetail = new OriginalBillDetail();
            originalBillDetail.setShopId(shopId);
            originalBillDetail.setShopEntityId(shopEntityId);
            originalBillDetail.setGoodsName(tempOrderGoodsInfo.getGoodsName());
            originalBillDetail.setGoodsPrice(tempOrderGoodsInfo.getGoodsPrice());
            originalBillDetail.setPayPrice(tempOrderGoodsInfo.getGoodsPrice());
            originalBillDetail.setGoodsNum(tempOrderGoodsInfo.getGoodsTotalNum());
            originalBillDetail.setTotalPrice(tempOrderGoodsInfo.getGoodsTotalPrice());
            originalBillDetail.setGoodsItemSerial(tempOrderGoodsInfo.getGoodsItemSerial());
            originalBillDetailList.add(originalBillDetail);
        }

        GooagooLog.debug("封装的原始商家账单明细信息为:" + new Gson().toJson(originalBillDetailList));

        //4.封装原始商家账单图片信息
        OriginalBillPic originalBillPic = new OriginalBillPic();
        originalBillPic.setPicUrl(orderInfoJson.getBillImg());

        GooagooLog.debug("封装的原始商家账单图片信息:" + new Gson().toJson(originalBillDetailList));

        //5.提交商家账单
        OrderResult orderResult = this.shopBillCoreService.addShopBill(originalBillInfo, originalBillDetailList, originalBillPic);
        if (orderResult != null && !StringUtils.hasText(orderResult.getOrderId()))
        {
            throw new MessageException(MessageConst.TRANS_BILL_UPLOAD_SHOP_BILL_DATA_FAIL);
        }
        return orderResult.getOrderId();
    }

    @Override
    public boolean uploadShopOrder(String mac, String data, String shopId, String shopEntityId) throws Exception
    {
        GooagooLog.info("uploadShopOrder-->入参:mac=" + mac + ",data=" + data + ",shopId=" + shopId + ",shopEntityId" + shopEntityId);
        //1.从商家订单json串中取出订单信息
        Gson gson = new Gson();
        OrderInfoJson orderInfoJson = gson.fromJson(data, OrderInfoJson.class);
        GooagooLog.debug("取出来的商家订单信息为:" + gson.toJson(gson));

        //2.组装入参shopOrderInfo（商家订单信息）
        ShopOrderInfo shopOrderInfo = new ShopOrderInfo();
        shopOrderInfo.setMac(mac);
        shopOrderInfo.setShopId(orderInfoJson.getShopId());
        shopOrderInfo.setShopEntityId(shopEntityId);
        shopOrderInfo.setThirdOrderId(orderInfoJson.getBillNo());
        shopOrderInfo.setDeskName(orderInfoJson.getDeskNo());
        shopOrderInfo.setScardNo(orderInfoJson.getScardno());
        shopOrderInfo.setOriginalPrice(orderInfoJson.getOriginalPrice());
        shopOrderInfo.setDiscountRate(orderInfoJson.getDiscountRate());
        shopOrderInfo.setPayPrice(orderInfoJson.getPayPrice());
        //3.组装入参shopOrderDetailList（商家订单明细信息）
        List<ShopOrderDetail> shopOrderDetailList = new ArrayList<ShopOrderDetail>();
        for (OrderGoodsInfo tempOrderGoodsInfo : orderInfoJson.getList())
        {
            ShopOrderDetail tempShopOrderDetail = new ShopOrderDetail();
            tempShopOrderDetail.setShopId(shopId);
            tempShopOrderDetail.setShopEntityId(shopEntityId);
            tempShopOrderDetail.setGoodsName(tempOrderGoodsInfo.getGoodsName());
            tempShopOrderDetail.setGoodsPrice(tempOrderGoodsInfo.getGoodsPrice());
            tempShopOrderDetail.setGoodsNum(tempOrderGoodsInfo.getGoodsTotalNum());
            tempShopOrderDetail.setTotalPrice(tempOrderGoodsInfo.getGoodsTotalPrice());
            tempShopOrderDetail.setGoodsItemSerial(tempOrderGoodsInfo.getGoodsItemSerial());
            shopOrderDetailList.add(tempShopOrderDetail);
        }
        //4.组装入参shopOrderPic（商家订单图片信息）
        ShopOrderPic shopOrderPic = new ShopOrderPic();
        shopOrderPic.setPicUrl(orderInfoJson.getBillImg());

        //5.提交商家订单
        boolean result = this.shopOrderCoreService.addShopOrder(shopOrderInfo, shopOrderDetailList, shopOrderPic);
        if (!result)
        {
            throw new MessageException(MessageConst.TRANS_BILL_UPLOAD_SHOP_ORDER_DATA_FAIL);
        }
        return result;
    }

    @Override
    public FindBillAddOrSubRoot getBillAddOrSub(String shopId, String shopentityid, String cTimeStamp) throws Exception
    {
        GooagooLog.info("getBillAddOrSub-->入参:shopId=" + shopId + ",shopentityid=" + shopentityid + ",cTimeStamp=" + cTimeStamp);
        //1.加减菜订单信息查询
        List<OrderBusiness> orderBusinessList = this.applyQueryService.findAddApplyInfo(shopentityid, cTimeStamp, null);

        GooagooLog.debug("根据shopId=" + shopId + ",shopentityid=" + shopentityid + ",cTimeStamp>" + cTimeStamp + "查询到的订单信息为:" + new Gson().toJson(orderBusinessList));
        List<OrderAddOrSubbaseinfo> orderAddOrSubbaseinfoList = null;
        if (CollectionUtils.isNotEmpty(orderBusinessList))
        {
            //2.封装加减菜订单信息
            orderAddOrSubbaseinfoList = new ArrayList<OrderAddOrSubbaseinfo>();
            for (OrderBusiness tempOrderBusiness : orderBusinessList)
            {
                OrderAddOrSubbaseinfo orderAddOrSubbaseinfo = new OrderAddOrSubbaseinfo();
                //封装加减菜信息
                List<OrderAddOrSubdetailinfo> orderAddOrSubdetailinfoList = new ArrayList<OrderAddOrSubdetailinfo>();
                if (CollectionUtils.isNotEmpty(tempOrderBusiness.getBillAddInfoList()))
                {
                    orderAddOrSubbaseinfo.setDeskno(tempOrderBusiness.getOrderInfo() != null ? tempOrderBusiness.getOrderInfo().getDeskName() : "");//桌号

                    //加减菜信息
                    for (BillAddInfo tempBillAddInfo : tempOrderBusiness.getBillAddInfoList())
                    {
                        OrderAddOrSubdetailinfo orderAddOrSubdetailinfo = new OrderAddOrSubdetailinfo();
                        orderAddOrSubdetailinfo.setOrderdetailid(tempBillAddInfo.getOrderDetailId());
                        orderAddOrSubdetailinfo.setOrderid(tempBillAddInfo.getOrderId());
                        orderAddOrSubdetailinfo.setCreatetime(TimeUtils.convertDateToString(tempBillAddInfo.getCreateTime(), TimeUtils.FORMAT1));
                        orderAddOrSubdetailinfo.setGoodsid(tempBillAddInfo.getGoodsId());
                        orderAddOrSubdetailinfo.setGoodsimg(tempBillAddInfo.getGoodsImg());
                        orderAddOrSubdetailinfo.setGoodsname(tempBillAddInfo.getGoodsName());
                        orderAddOrSubdetailinfo.setGoodsnum(tempBillAddInfo.getGoodsNum().toString());
                        orderAddOrSubdetailinfo.setGoodsprice(tempBillAddInfo.getPrice().toString());
                        orderAddOrSubdetailinfo.setItemserial(tempBillAddInfo.getItemSerial());
                        orderAddOrSubdetailinfo.setTypedeal(tempBillAddInfo.getTypeDeal());
                        orderAddOrSubdetailinfoList.add(orderAddOrSubdetailinfo);
                    }
                    orderAddOrSubbaseinfo.setOrderAddOrSubdetailinfo(orderAddOrSubdetailinfoList);
                    orderAddOrSubbaseinfoList.add(orderAddOrSubbaseinfo);
                }
            }
        }
        //3.组装返回参数
        FindBillAddOrSubRoot root = new FindBillAddOrSubRoot();
        root.setOrderAddOrSubbaseinfo(orderAddOrSubbaseinfoList);
        return root;
    }

    @Override
    public boolean confirmOpenInvoice(String shopEntityId, String orderId) throws Exception
    {
        GooagooLog.info("confirmOpenInvoice-->入参为:【shopEntityId=" + shopEntityId + " ,orderId=" + orderId);

        boolean flag = this.invoiceCoreService.confirmOpenInvoice(shopEntityId, orderId);
        if (!flag)
        {
            throw new MessageException(MessageConst.TRANS_BILL_OPEN_INVOICE_CONFIRM_FAIL);
        }

        return true;
    }
}
