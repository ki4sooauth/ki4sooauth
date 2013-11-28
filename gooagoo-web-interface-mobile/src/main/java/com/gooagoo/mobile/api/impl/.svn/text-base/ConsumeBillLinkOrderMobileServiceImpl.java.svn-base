package com.gooagoo.mobile.api.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.transaction.invoice.InvoiceCoreService;
import com.gooagoo.api.business.core.transaction.order.ChangeFoodCoreService;
import com.gooagoo.api.business.core.transaction.order.OrderCoreService;
import com.gooagoo.api.business.core.transaction.order.ShopBillCoreService;
import com.gooagoo.api.business.core.transaction.order.UserOrderCoreService;
import com.gooagoo.api.business.query.goods.query.GoodsQueryService;
import com.gooagoo.api.business.query.shop.cache.ShopCacheQueryService;
import com.gooagoo.api.business.query.transaction.order.OrderQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.GB2AlphaUtil;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.goods.ShopGoodsDetailInfo;
import com.gooagoo.entity.business.transaction.OrderDetailInfo4TableBusiness;
import com.gooagoo.entity.business.transaction.OrderDetailInfoBusiness;
import com.gooagoo.entity.business.transaction.OrderLinkDetailInfoBusiness;
import com.gooagoo.entity.business.transaction.OrderResult;
import com.gooagoo.entity.generator.bill.BillAddInfo;
import com.gooagoo.entity.generator.bill.BillInvoiceLog;
import com.gooagoo.entity.generator.bill.BillPayApplication;
import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.UserOrderCoupon;
import com.gooagoo.entity.generator.bill.UserOrderDetail;
import com.gooagoo.entity.generator.bill.UserOrderInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.CommonMobileService;
import com.gooagoo.mobile.api.ConsumeBillLinkOrderMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.common.ToolsUtils;
import com.gooagoo.mobile.common.entity.GoodsInfoEntity;
import com.gooagoo.mobile.entity.mobe01.transform.BillListgRoot;
import com.gooagoo.mobile.entity.mobe01.transform.Billlistg;
import com.gooagoo.mobile.entity.mobe01.transform.Goodslistg;
import com.gooagoo.mobile.entity.mobe01.transform.Isdeleted;
import com.gooagoo.mobile.entity.mobe04.transform.Cookbook;
import com.gooagoo.mobile.entity.mobe04.transform.CookbookRoot;
import com.gooagoo.mobile.entity.mobe05.transform.SubmitOrderForm;
import com.gooagoo.mobile.entity.mobe05.transform.SubmitOrderFormRoot;
import com.gooagoo.mobile.entity.mobe07.transform.GetOrderFormRoot;
import com.gooagoo.mobile.entity.mobe07.transform.Getorderform;
import com.google.gson.Gson;

@Service
public class ConsumeBillLinkOrderMobileServiceImpl implements ConsumeBillLinkOrderMobileService
{
    @Autowired
    private OrderQueryService orderQueryService;
    @Autowired
    private InvoiceCoreService invoiceCoreService;
    @Autowired
    private UserOrderCoreService userOrderCoreService;
    @Autowired
    private ShopBillCoreService shopBillCoreService;
    @Autowired
    private ChangeFoodCoreService changeFoodCoreService;
    @Autowired
    private CommonMobileService commonMobileService;
    @Autowired
    private GoodsQueryService goodsQueryService;
    @Autowired
    private OrderCoreService orderCoreService;
    @Autowired
    private ShopCacheQueryService shopCacheQueryService;

    @Override
    public BillListgRoot getBillListOfGooagoo(String userId, String sessionId, String shopId, String cTimeStamp, String orderId, String pageType, String pageSize, String date, String ordertype, String deliverystatus, String shopTypeId) throws Exception

    {
        GooagooLog.info("getBillListOfGooagoo-->入参:userId=" + userId + ",sessionId=" + sessionId + ",orderId=" + orderId + ",pageType=" + pageType + ",pageSize=" + pageSize + " ,date=" + date + " ,ordertype=" + ordertype + ",shopTypeId=" + shopTypeId);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.用户获取账单信息
        if (StringUtils.hasText(ordertype))
        {
            if ("3".equals(ordertype))
            {//查账单
                ordertype = "B";
            }
            else if ("0".equals(ordertype))
            {//查订单
                ordertype = "O";
            }
            else
            {
                GooagooLog.warn("订单类型不正确,订单类型应该为：0-订单,3-账单 -【ordertype=" + ordertype + "】");
                return new BillListgRoot();
            }
        }
        OrderLinkDetailInfoBusiness orderLinkDetailInfoBusiness = this.orderQueryService.findOrderListForAll(userId, shopId, shopTypeId, orderId, deliverystatus, null, null, cTimeStamp, ordertype, date, orderId, pageType, Integer.valueOf(pageSize));
        GooagooLog.debug("用户获取到的账单信息为(商家服务器)：" + new Gson().toJson(orderLinkDetailInfoBusiness));

        List<Billlistg> billlistgList = null;
        if (orderLinkDetailInfoBusiness != null && CollectionUtils.isNotEmpty(orderLinkDetailInfoBusiness.getOrderDetailInfoBusiness()))
        {
            billlistgList = new ArrayList<Billlistg>();
            for (OrderDetailInfoBusiness temp : orderLinkDetailInfoBusiness.getOrderDetailInfoBusiness())
            {
                Billlistg billlistg = new Billlistg();
                billlistg.setBillid(temp.getOrderid());
                billlistg.setBilltype("3".equals(temp.getBilltype()) ? "3" : "0");//订单状态，0-订单，3-账单
                billlistg.setOrderid(temp.getOrderid());//setBillid  &setOrderid  都用的getOrderid

                Map<String, String> shopInfoMap = this.shopCacheQueryService.findShopInfo(temp.getShopid());
                if (shopInfoMap != null && shopInfoMap.size() > 0)
                {
                    billlistg.setShoptypeid(shopInfoMap.get("shopTypeRoot"));//餐饮业商家类型编号（根节点）
                    billlistg.setShoptypename(shopInfoMap.get("shopTypeRootName"));//餐饮业商家类型名称（根节点）
                }
                if ("餐饮".equals(billlistg.getShoptypename()))
                {//订单所属行业类型
                    billlistg.setIndustrytype("0");
                }
                else
                {
                    billlistg.setIndustrytype("1");
                }
                billlistg.setShopid(temp.getShopid());
                billlistg.setShopentityid(temp.getShopentityid());
                billlistg.setUserid(temp.getUserid());
                billlistg.setRequesttime(temp.getRequesttime());
                billlistg.setScardno(temp.getScardno());
                billlistg.setDiscountrate(temp.getDiscountrate());
                billlistg.setGoodstotalnum(temp.getGoodstotalnum());
                billlistg.setOriginalprice(temp.getOriginalprice());
                billlistg.setPayprice(temp.getPayprice());
                billlistg.setIntegralnumber(temp.getIntegralnumber());
                billlistg.setInvoicedtime(temp.getInvoicetime());
                billlistg.setDeliverystatus(temp.getDeliveryStatus());
                billlistg.setIsapplicationinvoice(temp.getInvoiceApplication());
                billlistg.setIsinvoiced(temp.getIsinvoice());
                billlistg.setIsdel(temp.getIsdel());
                billlistg.setCtimestamp(temp.getCtimestamp());
                billlistg.setBillimg(temp.getBillimg());
                billlistg.setLatestinvoicetime(temp.getInvoicelatesttime());
                billlistg.setProofcode(temp.getProofcode());
                List<Goodslistg> goodslists = null;
                if (CollectionUtils.isNotEmpty(temp.getOrderDetailInfoList()))
                {

                    goodslists = new ArrayList<Goodslistg>();
                    for (OrderDetailInfo t : temp.getOrderDetailInfoList())
                    {
                        Goodslistg goodslist = new Goodslistg();
                        goodslist.setGoodsid(t.getGoodsId());
                        //取商品主图
                        goodslist.setGoodsimg(t.getGoodsImg());
                        goodslist.setGoodsname(t.getGoodsName());
                        goodslist.setGoodsnum(t.getGoodsNum() != null ? String.valueOf(t.getGoodsNum()) : "0");
                        goodslist.setGoodsprice(t.getPrice() != null ? String.valueOf(t.getPrice()) : "0.00");
                        goodslist.setPromotionprice(t.getPrice() != null ? String.valueOf(t.getPrice()) : "0.00");//促销价格？
                        goodslist.setIntroduceurl(UrlUtils.getGoodsMobileUrl(t.getGoodsId()));
                        goodslists.add(goodslist);

                    }
                }
                billlistg.setGoodslistg(goodslists);
                billlistgList.add(billlistg);
            }
        }

        //3.组装删除数据

        Isdeleted isdeleted = null;
        if (orderLinkDetailInfoBusiness != null && orderLinkDetailInfoBusiness.getIsdeletedInfo() != null)
        {
            isdeleted = new Isdeleted();
            isdeleted.setCtimestamp(orderLinkDetailInfoBusiness.getIsdeletedInfo().getCtimestamp());
            isdeleted.setFlag(orderLinkDetailInfoBusiness.getIsdeletedInfo().getFlag());
            isdeleted.setOrderidstr(orderLinkDetailInfoBusiness.getIsdeletedInfo().getIdstr());
        }
        //4.组织返回对象 
        BillListgRoot root = new BillListgRoot();
        root.setBilllistg(billlistgList);
        root.setIsdeleted(isdeleted);
        return root;
    }

    @Override
    public boolean applyOpenInvoice(String userId, String sessionId, String orderId, String invoicetype, String invoicedtile, String invoiceditem) throws Exception
    {
        GooagooLog.info("applyOpenInvoice-->入参:userId=" + userId + ",sessionId=" + sessionId + ",orderId=" + orderId + ",invoicetype=" + invoicetype + ",invoicedtile=" + invoicedtile + ",invoiceditem=" + invoiceditem);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.组织提交发票申请入参
        BillInvoiceLog billInvoiceLog = new BillInvoiceLog();
        billInvoiceLog.setUserId(userId);
        billInvoiceLog.setOrderId(orderId);
        billInvoiceLog.setInvoicedType(invoicetype);
        billInvoiceLog.setInvoicedTile(invoicedtile);
        billInvoiceLog.setInvoicedItem(invoiceditem);
        //3.提交发票申请
        boolean bool = this.invoiceCoreService.AddInvoice(billInvoiceLog);
        if (!bool)
        {
            throw new MessageException(MessageConst.MOBILE_BILL_SUBMIT_OPEN_INVOICE_APPLY_FAIL);
        }

        return bool;
    }

    @Override
    public CookbookRoot getCookbook(String userId, String sessionId, String shopId, String shopEntityId, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("getCookbook-->入参:userId=" + userId + ",sessionId=" + sessionId + ",shopEntityId=" + shopEntityId + ",pageIndex=" + pageIndex + ",pageSize=" + pageSize);
        List<Cookbook> cookbookList = null;
        //0.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //1.查询菜谱信息
        List<ShopGoodsDetailInfo> shopGoodsDetailInfoList = this.goodsQueryService.getGoodsMenu(userId, shopEntityId, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));

        if (CollectionUtils.isNotEmpty(shopGoodsDetailInfoList))
        {
            //2.封装查询到的菜谱信息
            cookbookList = new ArrayList<Cookbook>();
            for (ShopGoodsDetailInfo tempShopGoodsDetailInfo : shopGoodsDetailInfoList)
            {
                Cookbook tempCookbook = new Cookbook();
                GoodsBaseInfo goodsBaseInfo = tempShopGoodsDetailInfo.getGoodsBaseInfo();
                tempCookbook.setGoodsid(goodsBaseInfo.getGoodsId());
                tempCookbook.setShopid(goodsBaseInfo.getShopId());
                tempCookbook.setGoodsname(goodsBaseInfo.getGoodsName());
                tempCookbook.setPrice(goodsBaseInfo.getPrice().toString());
                //取主图
                tempCookbook.setGoodsnamefirst(GB2AlphaUtil.FirstStr2Alpha(goodsBaseInfo.getGoodsName()));//商品名称首字母
                tempCookbook.setOnedimensioncode(goodsBaseInfo.getItemSerial());
                tempCookbook.setGoodscategoryleafname(tempShopGoodsDetailInfo.getGoodsCategoryLeafName());
                tempCookbook.setGoodsimg(StringUtils.hasText(tempShopGoodsDetailInfo.getGoodsMarketingInfo().getGoodsImg()) ? JsonUtils.json2List(tempShopGoodsDetailInfo.getGoodsMarketingInfo().getGoodsImg()).get(0) : null);
                tempCookbook.setGoodsconten(tempShopGoodsDetailInfo.getGoodsMarketingInfo().getGoodsContent());
                tempCookbook.setGoodsscore(tempShopGoodsDetailInfo.getGoodsscore());
                tempCookbook.setSalesw(tempShopGoodsDetailInfo.getSalesw());
                tempCookbook.setSalesd(tempShopGoodsDetailInfo.getSalesd());
                tempCookbook.setIsfavorite(tempShopGoodsDetailInfo.getIsFav());//是否收藏节点没有
                tempCookbook.setIntroduceurl(UrlUtils.getGoodsMobileUrl(tempShopGoodsDetailInfo.getGoodsBaseInfo().getGoodsId()));
                cookbookList.add(tempCookbook);
            }
        }

        CookbookRoot root = new CookbookRoot();
        root.setCookbook(cookbookList);
        return root;
    }

    @Override
    public SubmitOrderFormRoot submitOrder(String userId, String sessionId, String type, HttpServletRequest request, String shopId, String shopEntityId, String tableno2d, String goodsidlist) throws Exception
    {
        GooagooLog.info("submitOrder-->入参:userId=" + userId + ",sessionId=" + sessionId + " ,type=" + type + ",request=" + request + ",shopEntityId=" + shopEntityId + ",shopId=" + shopId + ",tableno2d=" + tableno2d + ",goodsidlist=" + goodsidlist);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.根据桌号二维码取实体店编号、桌号、房间名
        List<String> tableInfo = null;
        if (StringUtils.hasText(tableno2d))
        {
            tableInfo = ToolsUtils.getTableInfo(tableno2d);
        }
        //2.1.取和封装订单中的优惠券信息
        Parameter parameter = InterfaceUtils.collectParameter(request);

        String couponid = parameter.getString("couponid");
        String takeMethod = parameter.getString("takemethod");//提货方式,0-直接拿走、1-前台提货、2-送货上门
        String goodsSource = parameter.getString("goodssource");//0-表示来源购物车,其它表示不是来自购物车，当商品来自购物车，提交订单后，需把购物车中的商品清理掉
        List<UserOrderCoupon> userOrderCouponList = new ArrayList<UserOrderCoupon>();
        if (StringUtils.hasText(couponid))
        {
            String[] strings = couponid.split(",");
            for (String string : strings)
            {
                UserOrderCoupon userOrderCoupon = new UserOrderCoupon();
                userOrderCoupon.setCouponUserId(string);
            }

        }
        //3.组织手机订单入参
        UserOrderInfo userOrderInfo = new UserOrderInfo();
        userOrderInfo.setUserId(userId);
        userOrderInfo.setShopId(shopId);
        userOrderInfo.setIsSaCommit("N");//非店员助理提交
        userOrderInfo.setTakeMethod(takeMethod);//提货方式
        userOrderInfo.setShopEntityId(shopEntityId);
        userOrderInfo.setDeskName(CollectionUtils.isNotEmpty(tableInfo) ? tableInfo.get(3) : null);
        userOrderInfo.setRoomName(CollectionUtils.isNotEmpty(tableInfo) ? tableInfo.get(4) : null);
        List<GoodsInfoEntity> goodsInfo = ToolsUtils.getGoodsInfo(goodsidlist);
        List<UserOrderDetail> userOrderDetailList = new ArrayList<UserOrderDetail>();
        for (GoodsInfoEntity temp : goodsInfo)
        {
            UserOrderDetail tempUserOrderDetail = new UserOrderDetail();
            tempUserOrderDetail.setShopId(shopId);
            tempUserOrderDetail.setShopEntityId(shopEntityId);
            tempUserOrderDetail.setUserId(userId);
            tempUserOrderDetail.setGoodsId(temp.getGoodsId());
            tempUserOrderDetail.setGoodsNum(Integer.valueOf(temp.getGoodsnum()));
            userOrderDetailList.add(tempUserOrderDetail);
        }
        //存放订单类型
        Map<String, String> parmMap = new HashMap<String, String>();
        parmMap.put("type", type);
        parmMap.put("goodssource", goodsSource);//订单商品来源
        //4.手机提交订单
        OrderResult orderResult = this.userOrderCoreService.addUserOrder(userOrderInfo, userOrderDetailList, userOrderCouponList, null, parmMap);
        GooagooLog.debug("手机用户提交订单返回信息:" + new Gson().toJson(orderResult));
        if (!StringUtils.hasText(orderResult.getOrderId()))
        {
            throw new MessageException(MessageConst.MOBILE_BILL_SUBMIT_ORDER_FAIL);
        }
        SubmitOrderFormRoot root = new SubmitOrderFormRoot();
        SubmitOrderForm submitOrderForm = new SubmitOrderForm();
        submitOrderForm.setOrderid(orderResult.getOrderId());
        root.setSubmitOrderForm(submitOrderForm);
        return root;
    }

    @Override
    public boolean payBillApply(String userId, String sessionId, String tableno2d, String orderId, String shopId, String couponId) throws Exception
    {
        GooagooLog.info("payBillApply-->入参:userId=" + userId + ",sessionId=" + sessionId + ",orderId=" + orderId + ",tableno2d=" + tableno2d + ",couponId=" + couponId);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.根据桌号二维码取实体店编号、桌号、房间名
        List<String> tableInfo = ToolsUtils.getTableInfo(tableno2d);
        String shopEntityId = tableInfo.get(2);

        GooagooLog.debug("根据餐桌二维码获取到的餐桌信息为:" + new Gson().toJson(tableInfo));

        //3.封装结账申请信息
        BillPayApplication billPayApplication = new BillPayApplication();
        billPayApplication.setUserId(userId);
        billPayApplication.setOrderId(orderId);
        billPayApplication.setShopId(shopId);
        billPayApplication.setShopEntityId(shopEntityId);

        GooagooLog.debug("封装的结账申请信息为:" + new Gson().toJson(billPayApplication));

        //4.封装优惠券信息
        List<OrderCouponInfo> orderCouponInfoList = null;
        if (StringUtils.hasText(couponId))
        {//有优惠券
            String couponIds[] = couponId.split(",");
            orderCouponInfoList = new ArrayList<OrderCouponInfo>();
            for (int i = 0; i < couponIds.length; i++)
            {
                OrderCouponInfo tempOrderCouponInfo = new OrderCouponInfo();
                tempOrderCouponInfo.setOrderId(orderId);
                tempOrderCouponInfo.setShopId(shopId);
                tempOrderCouponInfo.setShopEntityId(shopEntityId);
            }
        }
        GooagooLog.debug("封装的优惠券信息为:" + new Gson().toJson(orderCouponInfoList));

        //5.提交结账申请
        boolean applyBill = this.shopBillCoreService.applyBill(tableInfo.get(3), null, billPayApplication, orderCouponInfoList);

        if (!applyBill)
        {
            throw new MessageException(MessageConst.MOBILE_BILL_SUBMIT_PAY_BILL_FAIL);
        }
        return applyBill;
    }

    @Override
    public GetOrderFormRoot getOrderByTableNo(String userId, String sessionId, String tableno2d) throws Exception
    {
        GooagooLog.info("getOrderByTableNo-->入参:userId=" + userId + ",sessionId=" + sessionId + ",tableno2d=" + tableno2d);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.根据桌号二维码取实体店编号、桌号、房间名
        List<String> tableInfo = ToolsUtils.getTableInfo(tableno2d);
        //3.根据桌号获取订单信息
        OrderDetailInfo4TableBusiness info = this.orderQueryService.findOrderListByTable(tableInfo.get(2), tableInfo.get(3), tableInfo.get(4), null, null);

        GooagooLog.debug("根据桌号获取订单信息" + new Gson().toJson(info));
        Getorderform getorderform = null;
        if (info != null)
        {
            getorderform = new Getorderform();
            getorderform.setBillid(info.getOrderid());
            getorderform.setShopid(info.getShopid());
            getorderform.setUserid(info.getUserid());
            getorderform.setScardno(info.getScardno());
            getorderform.setDiscountrate(info.getDiscountrate());
            getorderform.setGoodstotalnum(info.getGoodstotalnum());
            getorderform.setOriginalprice(info.getOriginalprice());
            getorderform.setPayprice(info.getPayprice());
            getorderform.setShopname(info.getShopname());
            getorderform.setLogo(info.getLogo());
            getorderform.setBillimg(info.getBillimg());
            getorderform.setReserve2(info.getDeskname());
            getorderform.setReserve1(info.getRoomname());
            List<com.gooagoo.mobile.entity.mobe07.transform.Goodslist> goodslists = null;
            if (CollectionUtils.isNotEmpty(info.getOrderDetailInfoList()))
            {
                goodslists = new ArrayList<com.gooagoo.mobile.entity.mobe07.transform.Goodslist>();
                for (OrderDetailInfo temp : info.getOrderDetailInfoList())
                {
                    com.gooagoo.mobile.entity.mobe07.transform.Goodslist goodslist = new com.gooagoo.mobile.entity.mobe07.transform.Goodslist();
                    goodslist.setGoodsid(temp.getGoodsId());
                    goodslist.setGoodsimg(temp.getGoodsImg());
                    goodslist.setGoodsname(temp.getGoodsName());
                    goodslist.setGoodsnum(temp.getGoodsNum().toString());
                    goodslist.setGoodsprice(temp.getPrice().toString());
                    goodslist.setPromotionprice(temp.getPayPrice().toString());
                    goodslist.setIntroduceurl(UrlUtils.getGoodsMobileUrl(temp.getGoodsId()));
                    goodslists.add(goodslist);
                }
            }
            getorderform.setGoodslist(goodslists);
        }

        //4.封装桌号获取到的订单信息
        GetOrderFormRoot root = new GetOrderFormRoot();
        root.setGetorderform(getorderform);
        return root;
    }

    @Override
    public boolean billAddApply(String userId, String sessionId, String mac, String shopId, String goodsInfo, String tableNo2d) throws Exception
    {
        GooagooLog.info("billAddApply-->入参:userId=" + userId + ",sessionId=" + sessionId + ",shopId=" + shopId + ",mac=" + mac + ",goodsInfo=" + goodsInfo + ",tableNo2d=" + tableNo2d);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.准备入参
        List<GoodsInfoEntity> goodsInfoList = ToolsUtils.getGoodsInfo(goodsInfo);
        GooagooLog.debug("商品列表信息为：" + new Gson().toJson(goodsInfo));
        List<String> tableInfo = ToolsUtils.getTableInfo(tableNo2d);
        GooagooLog.debug("桌号信息为：" + new Gson().toJson(tableInfo));
        //3.组织入参
        List<BillAddInfo> billAddInfoList = new ArrayList<BillAddInfo>();
        for (GoodsInfoEntity goodsInfoEntity : goodsInfoList)
        {
            BillAddInfo addInfo = new BillAddInfo();
            addInfo.setUserId(userId);
            addInfo.setShopId(shopId);
            addInfo.setGoodsId(goodsInfoEntity.getGoodsId());
            addInfo.setGoodsNum(Integer.valueOf(goodsInfoEntity.getGoodsnum()));
            addInfo.setShopEntityId(tableInfo.get(2));
            billAddInfoList.add(addInfo);
        }

        //4.用户申请加菜        
        boolean bool = this.changeFoodCoreService.applyAddFood(tableInfo.get(3), billAddInfoList);
        return bool;
    }

    @Override
    public void DelUserBill(String userId, String sessionId, String orderinfo) throws Exception
    {
        //1.判断用户是否登录
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.删除用户账单
        if (!this.orderCoreService.deleteOrder(orderinfo))
        {
            throw new MessageException(MessageConst.MOBILE_CARDTOP_DEL_BILL_FAIL);
        }
    }
}
