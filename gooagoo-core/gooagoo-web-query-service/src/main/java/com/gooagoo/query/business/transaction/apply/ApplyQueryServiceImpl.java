package com.gooagoo.query.business.transaction.apply;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.marketing.cache.CouponCacheQueryService;
import com.gooagoo.api.business.query.transaction.apply.ApplyQueryService;
import com.gooagoo.api.generator.query.behave.FavoriteInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.BillAddInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.BillInvoiceLogGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.BillPayApplicationGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderCouponInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderInfoGeneratorQueryService;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.transaction.BillPayApplicationBusiness;
import com.gooagoo.entity.business.transaction.OrderBusiness;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.bill.BillAddInfo;
import com.gooagoo.entity.generator.bill.BillAddInfoExample;
import com.gooagoo.entity.generator.bill.BillInvoiceLog;
import com.gooagoo.entity.generator.bill.BillInvoiceLogExample;
import com.gooagoo.entity.generator.bill.BillPayApplication;
import com.gooagoo.entity.generator.bill.BillPayApplicationExample;
import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.OrderCouponInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfo;

@Service
public class ApplyQueryServiceImpl implements ApplyQueryService
{

    @Autowired
    BillPayApplicationGeneratorQueryService billPayApplicationGeneratorQueryService;

    @Autowired
    OrderInfoGeneratorQueryService orderInfoGeneratorQueryService;

    @Autowired
    OrderCouponInfoGeneratorQueryService orderCouponInfoGeneratorQueryService;

    @Autowired
    BillInvoiceLogGeneratorQueryService billInvoiceLogGeneratorQueryService;

    @Autowired
    BillAddInfoGeneratorQueryService billAddInfoGeneratorQueryService;

    @Autowired
    FavoriteInfoGeneratorQueryService favoriteInfoGeneratorQueryService;

    @Autowired
    CouponCacheQueryService couponCacheQueryService;

    @Override
    public List<BillPayApplicationBusiness> findApplyBill(String shopEntityId, String cTimeStamp) throws Exception
    {
        List<BillPayApplicationBusiness> billPayApplicationBusinessList = null;
        BillPayApplicationExample billPayApplicationExample = new BillPayApplicationExample();
        billPayApplicationExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andCTimeStampGreaterThan(TimeUtils.convertStringToDate(cTimeStamp)).andIsDealEqualTo("N").andIsDelEqualTo("N");
        //结账申请
        List<BillPayApplication> billPayApplicationList = this.billPayApplicationGeneratorQueryService.selectByExample(billPayApplicationExample);
        if (CollectionUtils.isNotEmpty(billPayApplicationList))
        {
            billPayApplicationBusinessList = new ArrayList<BillPayApplicationBusiness>();
            for (BillPayApplication billPayApplication : billPayApplicationList)
            {
                BillPayApplicationBusiness billPayApplicationBusiness = new BillPayApplicationBusiness();
                billPayApplicationBusiness.setOrderId(billPayApplication.getOrderId());
                billPayApplicationBusiness.setApplytime(TimeUtils.convertDateToString(billPayApplication.getApplyTime(), TimeUtils.FORMAT1));
                billPayApplicationBusiness.setOriginalPrice(billPayApplication.getDealTime() != null ? TimeUtils.convertDateToString(billPayApplication.getDealTime(), TimeUtils.FORMAT1) : null);
                //订单信息
                OrderInfo orderInfo = this.orderInfoGeneratorQueryService.selectUnDelByPrimaryKey(billPayApplication.getOrderId());
                if (orderInfo != null)
                {
                    billPayApplicationBusiness.setScardno(orderInfo.getScardNo());
                    billPayApplicationBusiness.setTableName(orderInfo.getDeskName());
                    billPayApplicationBusiness.setRoomName(orderInfo.getRoomName());
                    billPayApplicationBusiness.setThirdOrderId(orderInfo.getThirdOrderId());
                }
                OrderCouponInfoExample orderCouponInfoExample = new OrderCouponInfoExample();
                orderCouponInfoExample.createCriteria().andOrderIdEqualTo(billPayApplication.getOrderId()).andIsDelEqualTo("N");
                //优惠凭证
                List<OrderCouponInfo> orderCouponInfoList = this.orderCouponInfoGeneratorQueryService.selectByExample(orderCouponInfoExample);
                List<Map<String, String>> couponList = null;
                if (CollectionUtils.isNotEmpty(orderCouponInfoList))
                {
                    couponList = new ArrayList<Map<String, String>>();
                    for (OrderCouponInfo orderCouponInfo : orderCouponInfoList)
                    {
                        Map<String, String> coupon = new HashMap<String, String>();
                        coupon.put("favoriteid", orderCouponInfo.getCouponUserId());
                        FavoriteInfo favoriteInfo = this.favoriteInfoGeneratorQueryService.selectUnDelByPrimaryKey(orderCouponInfo.getCouponUserId());
                        if (favoriteInfo != null)
                        {
                            Map<String, String> couponMap = this.couponCacheQueryService.findCoupon(favoriteInfo.getObjectId());
                            String couponContent = couponMap.get("couponContent");
                            if (StringUtils.hasText(couponContent))
                            {
                                coupon.put("couponcontent", couponContent);
                            }
                        }
                        couponList.add(coupon);
                    }
                }
                billPayApplicationBusiness.setCouponList(couponList);
                billPayApplicationBusinessList.add(billPayApplicationBusiness);
            }
        }
        return billPayApplicationBusinessList;
    }

    @Override
    public List<OrderBusiness> findAddApplyInfo(String shopEntityId, String ctimestamp, String typeDeal) throws Exception
    {
        List<OrderBusiness> orderBusinessList = null;
        Set<String> orderIdSet = new HashSet<String>();
        BillAddInfoExample billAddInfoExample = new BillAddInfoExample();
        if (StringUtils.hasText(typeDeal))
        {//只查询加减菜申请信息中的一种
            billAddInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andTypeDealEqualTo(typeDeal).andCreateTimeGreaterThan(TimeUtils.convertStringToDate(ctimestamp)).andIsDealEqualTo("N").andIsDelEqualTo("N");
        }
        else
        {//查询所有加减菜申请信息
            billAddInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andCreateTimeGreaterThan(TimeUtils.convertStringToDate(ctimestamp)).andIsDealEqualTo("N").andIsDelEqualTo("N");
        }

        List<BillAddInfo> billAddInfoList = this.billAddInfoGeneratorQueryService.selectByExample(billAddInfoExample);
        if (CollectionUtils.isNotEmpty(billAddInfoList))
        {
            orderBusinessList = new ArrayList<OrderBusiness>();
            for (BillAddInfo billAddInfo : billAddInfoList)
            {
                orderIdSet.add(billAddInfo.getOrderId());
            }
            for (String orderId : orderIdSet)
            {
                OrderInfo orderInfo = this.orderInfoGeneratorQueryService.selectUnDelByPrimaryKey(orderId);
                OrderBusiness orderBusiness = new OrderBusiness();
                orderBusiness.setOrderInfo(orderInfo);//订单信息
                billAddInfoExample = new BillAddInfoExample();
                billAddInfoExample.createCriteria().andOrderIdEqualTo(orderId).andCTimeStampGreaterThan(TimeUtils.convertStringToDate(ctimestamp)).andIsDelEqualTo("N");
                billAddInfoList = this.billAddInfoGeneratorQueryService.selectByExample(billAddInfoExample);
                orderBusiness.setBillAddInfoList(billAddInfoList);
                orderBusinessList.add(orderBusiness);
            }
        }
        return orderBusinessList;
    }

    @Override
    public List<OrderBusiness> findApplyInvoiceList(String shopEntityId, String ctimestamp) throws Exception
    {
        List<OrderBusiness> orderBusinessList = null;
        //发票信息
        BillInvoiceLogExample billInvoiceLogExample = new BillInvoiceLogExample();
        billInvoiceLogExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andCTimeStampGreaterThan(TimeUtils.convertStringToDate(ctimestamp)).andIsDelEqualTo("N");
        List<BillInvoiceLog> billInvoiceLogList = this.billInvoiceLogGeneratorQueryService.selectByExample(billInvoiceLogExample);
        if (CollectionUtils.isNotEmpty(billInvoiceLogList))
        {
            orderBusinessList = new ArrayList<OrderBusiness>();
            for (BillInvoiceLog billInvoiceLog : billInvoiceLogList)
            {
                OrderBusiness orderBusiness = new OrderBusiness();
                orderBusiness.setBillInvoiceLog(billInvoiceLog);
                //订单信息
                OrderInfo orderInfo = this.orderInfoGeneratorQueryService.selectUnDelByPrimaryKey(billInvoiceLog.getOrderId());
                if (orderInfo != null)
                {
                    orderBusiness.setOrderInfo(orderInfo);
                }
                else
                {
                    orderBusiness.setOrderInfo(null);
                }
                orderBusiness.setOrderDetailInfoList(null);
                orderBusiness.setOrderCouponInfoList(null);
                orderBusiness.setOrderPicList(null);
                orderBusinessList.add(orderBusiness);
            }
        }
        return orderBusinessList;
    }

}
