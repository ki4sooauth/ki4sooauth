package com.gooagoo.query.business.transaction.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.api.business.query.marketing.cache.CouponCacheQueryService;
import com.gooagoo.api.business.query.transaction.order.OrderQueryService;
import com.gooagoo.api.generator.query.behave.FavoriteInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.behave.UserCommentGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderCouponInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderDetailInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderPicGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsFeatureInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.CouponGeneratorQueryService;
import com.gooagoo.api.generator.query.member.IntegralDetailInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.protecteds.query.shop.ShopProtectedQueryService;
import com.gooagoo.api.protecteds.query.transaction.order.OrderProtectedQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.dao.business.bill.transaction.OrderInfoBusinessMapper;
import com.gooagoo.entity.business.marketing.IsdeletedInfo;
import com.gooagoo.entity.business.transaction.OrderDetailInShopEntity;
import com.gooagoo.entity.business.transaction.OrderDetailInfo4TableBusiness;
import com.gooagoo.entity.business.transaction.OrderDetailInfoBusiness;
import com.gooagoo.entity.business.transaction.OrderGoodsBusiness;
import com.gooagoo.entity.business.transaction.OrderInShopEntity;
import com.gooagoo.entity.business.transaction.OrderInfoBusiness;
import com.gooagoo.entity.business.transaction.OrderLinkDetailInfoBusiness;
import com.gooagoo.entity.business.transaction.PurchasedGoodsBusiness;
import com.gooagoo.entity.business.user.favorite.coupon.CouponInfoBusiness;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.behave.UserComment;
import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.OrderCouponInfoExample;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfoExample.Criteria;
import com.gooagoo.entity.generator.bill.OrderPic;
import com.gooagoo.entity.generator.bill.OrderPicExample;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfo;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfoExample;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.member.IntegralDetailInfo;
import com.gooagoo.entity.generator.member.IntegralDetailInfoExample;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.shop.ShopInfo;

@Service
public class OrderQueryServiceImpl implements OrderQueryService
{

    @Autowired
    OrderInfoBusinessMapper orderInfoBusinessMapper;

    @Autowired
    private OrderPicGeneratorQueryService orderPicGeneratorQueryService;

    @Autowired
    private IntegralDetailInfoGeneratorQueryService integralDetailInfoGeneratorQueryService;

    @Autowired
    private OrderDetailInfoGeneratorQueryService orderDetailInfoGeneratorQueryService;

    @Autowired
    private OrderCouponInfoGeneratorQueryService orderCouponInfoGeneratorQueryService;

    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    @Autowired
    private GoodsFeatureInfoGeneratorQueryService goodsFeatureInfoGeneratorQueryService;

    @Autowired
    private FavoriteInfoGeneratorQueryService favoriteInfoGeneratorQueryService;

    @Autowired
    private CouponGeneratorQueryService couponGeneratorQueryService;

    @Autowired
    private UserCommentGeneratorQueryService userCommentGeneratorQueryService;

    @Autowired
    private GoodsBaseInfoGeneratorQueryService goodsBaseInfoGeneratorQueryService;

    @Autowired
    private OrderProtectedQueryService orderProtectedQueryService;

    @Autowired
    private GoodsCacheQueryService goodsCacheQueryService;

    @Autowired
    private ShopProtectedQueryService shopProtectedQueryService;

    @Autowired
    private OrderInfoGeneratorQueryService orderInfoGeneratorQueryService;
    @Autowired
    private CouponCacheQueryService couponCacheQueryService;
    @Autowired
    private MemberOfCardGeneratorQueryService memberOfCardGeneratorQueryService;

    @Override
    public OrderDetailInfo4TableBusiness findOrderListByTable(String shopEntityId, String deskName, String roomName, Integer pageIndex, Integer pageSize) throws Exception
    {
        OrderDetailInfo4TableBusiness orderDetailInfo4TableBusiness = null;
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        Criteria criteria = orderInfoExample.createCriteria();
        criteria.andBillTypeNotEqualTo("3").andShopEntityIdEqualTo(shopEntityId).andDeskNameEqualTo(deskName).andIsDelEqualTo("N");
        if (StringUtils.hasText(roomName))
        {
            criteria.andRoomNameEqualTo(roomName);
        }
        orderInfoExample.setOrderByClause("c_time_stamp DESC");
        if (pageIndex != null && pageSize != null)
        {
            orderInfoExample.setPage(pageIndex, pageSize);
        }
        List<OrderInfo> orderInfoList = this.orderInfoGeneratorQueryService.selectByExample(orderInfoExample);
        if (CollectionUtils.isNotEmpty(orderInfoList))
        {
            orderDetailInfo4TableBusiness = this.encapsulation4OrderDetailInfo4TableBusiness(orderInfoList.get(0));
        }
        return orderDetailInfo4TableBusiness;
    }

    @Override
    public OrderLinkDetailInfoBusiness findOrderListForAll(String userId, String shopId, String shopTypeId, String orderId, String deliveryStatus, String scardno, String shopEntityId, String cTimeStamp, String billType, String date, String pageId, String pageType, Integer pageSize) throws Exception
    {
        List<OrderDetailInfoBusiness> orderDetailInfoBusinessList = null;
        String interfaceName = "";//所走接口
        IsdeletedInfo isdeletedInfo = null;//记录删除的订单信息
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        Criteria criteria = orderInfoExample.createCriteria();
        //获取删除的账单信息
        /*
        //用户获取账单信息
        if (StringUtils.hasText(scardno))
        {//走接口mobe16
            //音频卡号有值时获取该会员最后一个未结账订单
            Map<String, String> shopInfoCache = this.shopCacheQueryService.findShopInfo(scardno);
            userId = shopInfoCache.get("userId");
            criteria.andBillTypeNotEqualTo("3");
            orderInfoExample.setOrderByClause("c_time_stamp DESC");
            orderInfoExample.setPage(1, 1);
        }
        */
        if (StringUtils.hasText(scardno) && !StringUtils.hasText(userId))
        {//接口gtsc02为传userId,只有sacrdno
            MemberOfCard memberOfCard = this.memberOfCardGeneratorQueryService.selectUnDelByPrimaryKey(scardno);
            if (memberOfCard == null)
            {
                GooagooLog.warn("未查询用户会员卡信息【根据scardno=" + scardno + "未查询到未删除的会员卡信息");
                return null;
            }
            userId = memberOfCard.getUserId();
        }
        //用户根据订单编号获取账单信息
        if (StringUtils.hasText(orderId) && !StringUtils.hasText(pageType))
        {//走接口mobe16
         //音频卡号有值时获取该会员最后一个未结账订单
            interfaceName = "mobe16";
            criteria.andOrderIdEqualTo(orderId).andIsDelEqualTo("N");
            orderInfoExample.setOrderByClause("c_time_stamp DESC");
        }
        else if (StringUtils.hasText(cTimeStamp) && !StringUtils.hasText(pageType))
        {//走接口gtsc02
            interfaceName = "gtsc02";
            criteria.andCTimeStampGreaterThan(TimeUtils.convertStringToDate(cTimeStamp));
            //商家查询用户订单时只通过实体店编号和时间戳取用户订单
            if (StringUtils.hasText(shopEntityId))
            {
                criteria.andShopEntityIdEqualTo(shopEntityId);
                criteria.andBillTypeNotEqualTo("3");
                criteria.andIsDelEqualTo("N");
            }
        }
        else
        {//走接口mobe01
            interfaceName = "mobe01";
            isdeletedInfo = new IsdeletedInfo();
            if (StringUtils.hasText(cTimeStamp))
            {
                this.getDelOrderInfo(userId, billType, TimeUtils.convertStringToDate(cTimeStamp), isdeletedInfo);
            }
            if (StringUtils.hasText(shopId))
            {
                criteria.andShopIdEqualTo(shopId);
            }
            else if (StringUtils.hasText(shopTypeId))
            {//商家类型和商家编号都存在时以商家编号为准
                List<String> shopIdList = this.shopProtectedQueryService.getShopIdByShopType(shopTypeId);
                if (CollectionUtils.isEmpty(shopIdList))
                {
                    GooagooLog.warn("此商家类型下无对应的商家【shopTypeId=" + shopTypeId + "】");
                    OrderLinkDetailInfoBusiness tempOrderLinkDetailInfoBusiness = new OrderLinkDetailInfoBusiness();
                    tempOrderLinkDetailInfoBusiness.setOrderDetailInfoBusiness(null);
                    tempOrderLinkDetailInfoBusiness.setIsdeletedInfo(isdeletedInfo);
                    return tempOrderLinkDetailInfoBusiness;
                }
                criteria.andShopIdIn(shopIdList);
            }

            //用户查询“账单/订单”信息
            if (StringUtils.hasText(shopEntityId))
            {
                criteria.andShopEntityIdEqualTo(shopEntityId);
            }
            //mobe01按日期查询时，查订单时，应该按用户订单消费时间查，查账单应该按结账时间查
            if ("B".equalsIgnoreCase(billType))//账单
            {
                criteria.andBillTypeEqualTo("3");
                if ("Y".equals(deliveryStatus))//已取货
                {
                    criteria.andDeliveryStatusEqualTo("3");
                }
                else if ("N".equals(deliveryStatus))//未取货
                {
                    //提货方式:1-前台提货、2-送货上门
                    List<String> takeMethodList = new ArrayList<String>();
                    takeMethodList.add("1");
                    takeMethodList.add("2");
                    criteria.andDeliveryStatusNotEqualTo("3").andTakeMethodIn(takeMethodList);
                }
                if (StringUtils.hasText(date))
                {
                    criteria.andPaymentTimeGreaterThanOrEqualTo(TimeUtils.convertStringToDate(date + " 00:00:00"));
                    criteria.andPaymentTimeLessThanOrEqualTo(TimeUtils.convertStringToDate(date + " 23:59:59"));
                }
            }
            else if ("O".equalsIgnoreCase(billType))//订单
            {
                criteria.andBillTypeNotEqualTo("3");
                if (StringUtils.hasText(date))
                {
                    criteria.andCreateTimeGreaterThanOrEqualTo(TimeUtils.convertStringToDate(date + " 00:00:00"));
                    criteria.andCreateTimeLessThanOrEqualTo(TimeUtils.convertStringToDate(date + " 23:59:59"));
                }
            }
            criteria.andIsDelEqualTo("N");
            orderInfoExample.setOrderByClause("order_id DESC");
            if (StringUtils.hasText(pageId))
            {
                if ("P".equalsIgnoreCase(pageType))//上一页
                {//新账单
                    criteria.andOrderIdGreaterThan(pageId);
                    Integer laterOrderInfoNums = this.orderInfoGeneratorQueryService.countByExample(orderInfoExample);
                    if (laterOrderInfoNums > pageSize)
                    {
                        isdeletedInfo.setFlag("Y");
                    }
                    else
                    {
                        isdeletedInfo.setFlag("N");
                    }
                }
                else if ("N".equalsIgnoreCase(pageType))//下一页
                {//旧账单
                    criteria.andOrderIdLessThan(pageId);
                    isdeletedInfo.setFlag("N");
                }
            }

            if (pageSize != null)
            {
                orderInfoExample.setPage(1, pageSize);
            }
        }
        if (StringUtils.hasText(userId))
        {//userId不为空查询某个用户的订单信息，userId为空，查询某个实体店的用户订单
            criteria.andUserIdEqualTo(userId);
        }

        List<OrderInfo> orderInfoList = this.orderInfoGeneratorQueryService.selectByExample(orderInfoExample);
        if (CollectionUtils.isNotEmpty(orderInfoList))
        {
            orderDetailInfoBusinessList = new ArrayList<OrderDetailInfoBusiness>();
            for (OrderInfo orderInfo : orderInfoList)
            {
                OrderDetailInfoBusiness orderDetailInfoBusiness = this.encapsulation4OrderDetailInfoBusiness(orderInfo);
                orderDetailInfoBusinessList.add(orderDetailInfoBusiness);
            }
            if ("mobe01".equals(interfaceName))
            {
                isdeletedInfo.setCtimestamp(StringUtils.hasText(isdeletedInfo.getCtimestamp()) ? isdeletedInfo.getCtimestamp() : TimeUtils.convertDateToString(orderInfoList.get(0).getCTimeStamp(), TimeUtils.FORMAT1));
            }
        }

        //封装数据
        OrderLinkDetailInfoBusiness orderLinkDetailInfoBusiness = new OrderLinkDetailInfoBusiness();
        orderLinkDetailInfoBusiness.setOrderDetailInfoBusiness(orderDetailInfoBusinessList);
        orderLinkDetailInfoBusiness.setIsdeletedInfo("mobe01".equals(interfaceName) ? isdeletedInfo : null);
        return orderLinkDetailInfoBusiness;
    }

    /**
     * 查询删除的账单订单数据
     */
    private void getDelOrderInfo(String userId, String orderType, Date cTimeStamp, IsdeletedInfo isdeletedInfo)
    {
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        Criteria criteria = orderInfoExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andCTimeStampGreaterThan(cTimeStamp);
        if ("B".equalsIgnoreCase(orderType))//账单
        {
            criteria.andBillTypeEqualTo("3");
        }
        else if ("O".equalsIgnoreCase(orderType))//订单
        {
            criteria.andBillTypeNotEqualTo("3");
        }
        criteria.andIsDelEqualTo("Y");
        orderInfoExample.setOrderByClause("c_time_stamp DESC");
        List<OrderInfo> orderInfoList = this.orderInfoGeneratorQueryService.selectByExample(orderInfoExample);
        if (CollectionUtils.isNotEmpty(orderInfoList))
        {
            String delStr = "";
            for (OrderInfo orderInfo : orderInfoList)
            {
                if ("".equals(delStr))
                {
                    delStr = orderInfo.getOrderId();
                }
                else
                {
                    delStr = delStr + "," + orderInfo.getOrderId();
                }
            }
            isdeletedInfo.setIdstr(delStr);
            isdeletedInfo.setCtimestamp(TimeUtils.convertDateToString(orderInfoList.get(0).getCTimeStamp(), TimeUtils.FORMAT1));
        }
    }

    @Override
    public Integer countOrderList(String userId, String shopId, Date begin, Date end, String goodsName) throws Exception
    {
        return this.orderInfoBusinessMapper.countOrderInfoList(userId, shopId, begin, end, goodsName);
    }

    @Override
    public List<OrderInfoBusiness> findOrderList(String userId, String shopId, Date begin, Date end, String goodsName, Integer pageIndex, Integer pageSize, String orderBy) throws Exception
    {
        if (pageIndex != null)
        {
            pageIndex = (pageIndex - 1) * pageSize;
        }
        //1、获取满足条件的账单
        List<OrderInfoBusiness> result = this.orderInfoBusinessMapper.findOrderInfoList(userId, shopId, begin, end, goodsName, pageIndex, pageSize, orderBy);
        if (CollectionUtils.isEmpty(result))
        {
            return null;
        }
        //2、获取商家信息、优惠凭证图片，组装用户账单信息
        List<OrderInfoBusiness> orderInfoBusinessList = new ArrayList<OrderInfoBusiness>();
        Map<String, ShopInfo> shopInfoMap = new HashMap<String, ShopInfo>();
        Map<String, Coupon> couponMap = new HashMap<String, Coupon>();
        for (OrderInfoBusiness orderInfoBusiness : result)
        {
            //2.1、获取商家信息
            ShopInfo shopInfo = this.getOrderShopInfo(shopInfoMap, orderInfoBusiness.getShopId());
            if (shopInfo == null)
            {
                continue;
            }
            //2.2、获取优惠凭证图片
            List<String> couponImgList = this.getOrderCouponImg(couponMap, orderInfoBusiness.getOrderId());
            //2.3、组装用户账单信息
            orderInfoBusiness.setShopName(shopInfo.getShopName());
            orderInfoBusiness.setLogo1(shopInfo.getLogo1());
            orderInfoBusiness.setCouponImgList(couponImgList);
            orderInfoBusinessList.add(orderInfoBusiness);
        }

        return orderInfoBusinessList;
    }

    @Override
    public List<OrderGoodsBusiness> findOrderDetail(String orderId) throws Exception
    {
        //1、校验订单编号
        if (org.apache.commons.lang.StringUtils.isBlank(orderId))
        {
            GooagooLog.info("电子账单商品列表 ：订单编号（" + orderId + "）为空");
            return null;
        }
        //2、获取订单详细信息
        OrderDetailInfoExample queryCondition = new OrderDetailInfoExample();
        queryCondition.createCriteria().andOrderIdEqualTo(orderId);
        List<OrderDetailInfo> orderDetailInfoList = this.orderDetailInfoGeneratorQueryService.selectByExample(queryCondition);
        if (CollectionUtils.isEmpty(orderDetailInfoList))
        {
            return null;
        }
        //3、组装返回数据
        List<OrderGoodsBusiness> orderGoodsBusinessList = new ArrayList<OrderGoodsBusiness>();
        for (OrderDetailInfo orderDetailInfo : orderDetailInfoList)
        {
            //3.1、获取评论信息
            UserComment userComment = null;
            if (org.apache.commons.lang.StringUtils.isNotBlank(orderDetailInfo.getCommentId()))
            {
                userComment = this.userCommentGeneratorQueryService.selectByPrimaryKey(orderDetailInfo.getCommentId());
                if (userComment == null || "Y".equals(userComment.getIsDel()))
                {
                    userComment = null;
                }
            }
            //3.2、获取商品信息
            GoodsBaseInfo goodsBaseInfo = this.goodsBaseInfoGeneratorQueryService.selectByPrimaryKey(orderDetailInfo.getGoodsId());
            if (goodsBaseInfo == null || "Y".equals(goodsBaseInfo.getIsDel()))
            {
                goodsBaseInfo = null;
            }
            //3.3、组装返回数据
            OrderGoodsBusiness orderGoodsBusiness = new OrderGoodsBusiness();
            orderGoodsBusiness.setBillDetailId(orderDetailInfo.getOrderDetailId());
            orderGoodsBusiness.setGoodsId(orderDetailInfo.getGoodsId());
            orderGoodsBusiness.setShopId(orderDetailInfo.getShopId());
            orderGoodsBusiness.setGoodsName(orderDetailInfo.getGoodsName());
            orderGoodsBusiness.setGoodsImg(orderDetailInfo.getGoodsImg());
            orderGoodsBusiness.setPayPrice(orderDetailInfo.getPayPrice());
            orderGoodsBusiness.setSave(orderDetailInfo.getPrice() - orderDetailInfo.getPayPrice());
            orderGoodsBusiness.setBillId(orderDetailInfo.getOrderId());
            orderGoodsBusiness.setPic(orderDetailInfo.getGoodsImg());
            if (goodsBaseInfo != null)
            {
                orderGoodsBusiness.setPriceChange(goodsBaseInfo.getPrice() - orderDetailInfo.getPrice());
            }
            orderGoodsBusiness.setGoodsNum(orderDetailInfo.getGoodsNum());
            if (userComment != null)
            {
                orderGoodsBusiness.setCommentId(userComment.getCommentId());
                orderGoodsBusiness.setCommentLevel(userComment.getCommentLevel());
                orderGoodsBusiness.setContent(userComment.getContent());
            }
            orderGoodsBusinessList.add(orderGoodsBusiness);
        }

        return orderGoodsBusinessList;
    }

    @Override
    public List<OrderInShopEntity> findOrderListInShopEntity(String shopEntityId, String userId, Integer pageIndex, Integer pageSize) throws Exception
    {
        List<OrderInShopEntity> orderInShopEntityList = null;
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        orderInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andUserIdEqualTo(userId).andIsDelEqualTo("N");
        if (pageIndex != null && pageSize != null)
        {
            orderInfoExample.setPage(pageIndex, pageSize);
        }
        List<OrderInfo> orderInfoList = this.orderInfoGeneratorQueryService.selectByExample(orderInfoExample);
        if (CollectionUtils.isNotEmpty(orderInfoList))
        {
            orderInShopEntityList = new ArrayList<OrderInShopEntity>();
            for (OrderInfo orderInfo : orderInfoList)
            {
                OrderInShopEntity orderInShopEntity = new OrderInShopEntity();
                orderInShopEntity.setUserid(userId);
                orderInShopEntity.setOrderId(orderInfo.getOrderId());
                orderInShopEntity.setPayprice(orderInfo.getPayPrice() != null ? orderInfo.getPayPrice().toString() : "0.00");
                if (orderInfo.getRequestTime() != null)
                {
                    orderInShopEntity.setRequesttime(TimeUtils.convertDateToString(orderInfo.getRequestTime(), TimeUtils.FORMAT1));
                }
                orderInShopEntityList.add(orderInShopEntity);
            }
        }
        return orderInShopEntityList;
    }

    /**
     * 封装用户账单信息
     * @param orderInfo 订单信息
     * @return
     */
    private OrderDetailInfoBusiness encapsulation4OrderDetailInfoBusiness(OrderInfo orderInfo)
    {
        OrderDetailInfoBusiness orderDetailInfoBusiness = new OrderDetailInfoBusiness();
        orderDetailInfoBusiness.setOrderid(orderInfo.getOrderId());
        orderDetailInfoBusiness.setBilltype(orderInfo.getBillType());
        orderDetailInfoBusiness.setThirdorderid(orderInfo.getThirdOrderId());
        orderDetailInfoBusiness.setShopid(orderInfo.getShopId());
        orderDetailInfoBusiness.setShopentityid(orderInfo.getShopEntityId());
        orderDetailInfoBusiness.setTableNo(orderInfo.getDeskName());
        orderDetailInfoBusiness.setUserid(orderInfo.getUserId());
        if ("3".equals(orderInfo.getDeliveryStatus()))//取货状态（Y，N）
        {
            orderDetailInfoBusiness.setDeliveryStatus("Y");
        }
        else
        {
            orderDetailInfoBusiness.setDeliveryStatus("N");
        }
        if (orderInfo.getInvoiceApplicationTime() == null)//提交开发票申请（Y，N）
        {
            orderDetailInfoBusiness.setInvoiceApplication("N");
        }
        else
        {
            orderDetailInfoBusiness.setInvoiceApplication("Y");
        }
        //        orderDetailInfoBusiness.setRequesttime(orderInfo.getRequestTime() != null ? TimeUtils.convertDateToString(orderInfo.getRequestTime(), TimeUtils.FORMAT1) : "");
        Date requestTime = null;
        if ("3".equals(orderInfo.getBillType()))
        {
            requestTime = orderInfo.getPaymentTime();
        }
        else
        {
            requestTime = orderInfo.getCreateTime();
        }
        orderDetailInfoBusiness.setRequesttime(requestTime != null ? TimeUtils.convertDateToString(requestTime, TimeUtils.FORMAT1) : "");
        orderDetailInfoBusiness.setScardno(orderInfo.getScardNo());
        orderDetailInfoBusiness.setDiscountrate(orderInfo.getDiscountRate() != null ? orderInfo.getDiscountRate().toString() : "0.00");
        orderDetailInfoBusiness.setGoodstotalnum(orderInfo.getGoodsTotalNum() != null ? orderInfo.getGoodsTotalNum().toString() : "0");
        orderDetailInfoBusiness.setOriginalprice(orderInfo.getOriginalPrice() != null ? orderInfo.getOriginalPrice().toString() : "0.00");
        orderDetailInfoBusiness.setPayprice(orderInfo.getPayPrice() != null ? orderInfo.getPayPrice().toString() : "0.00");
        //本次积分
        IntegralDetailInfoExample integralDetailInfoExample = new IntegralDetailInfoExample();
        integralDetailInfoExample.createCriteria().andNoteEqualTo(orderInfo.getOrderId()).andIsDelEqualTo("N");
        List<IntegralDetailInfo> integralDetailInfoList = this.integralDetailInfoGeneratorQueryService.selectByExample(integralDetailInfoExample);
        Integer integralnumber = 0;
        if (CollectionUtils.isNotEmpty(integralDetailInfoList))
        {
            for (IntegralDetailInfo integralDetailInfo : integralDetailInfoList)
            {
                if (integralDetailInfo.getIntegralNumber() != null)
                {
                    integralnumber += integralDetailInfo.getIntegralNumber();
                }
            }
        }
        orderDetailInfoBusiness.setIntegralnumber(integralnumber.toString());
        orderDetailInfoBusiness.setIsinvoice(orderInfo.getIsInvoice());
        orderDetailInfoBusiness.setInvoicetime(orderInfo.getInvoiceTime() != null ? TimeUtils.convertDateToString(orderInfo.getInvoiceTime(), TimeUtils.FORMAT1) : "");
        orderDetailInfoBusiness.setIsdel(orderInfo.getIsDel());
        orderDetailInfoBusiness.setCreatetime(TimeUtils.convertDateToString(orderInfo.getCreateTime(), TimeUtils.FORMAT1));
        orderDetailInfoBusiness.setCtimestamp(TimeUtils.convertDateToString(orderInfo.getCTimeStamp(), TimeUtils.FORMAT1));
        //TODO为拍乐付临时增加"1".equals(orderInfo.getBillType())（拍乐付上传订单类型是1，图片类型是1）
        if ("3".equals(orderInfo.getBillType()) || "1".equals(orderInfo.getBillType()))//如果是账单取最新账单图片
        {
            OrderPicExample orderPicExample = new OrderPicExample();
            orderPicExample.createCriteria().andOrderIdEqualTo(orderInfo.getOrderId()).andPicTypeEqualTo("1").andIsDelEqualTo("N");
            List<OrderPic> orderPicList = this.orderPicGeneratorQueryService.selectByExample(orderPicExample);
            if (CollectionUtils.isNotEmpty(orderPicList))
            {
                orderDetailInfoBusiness.setBillimg(orderPicList.get(0).getPicUrl());
            }
        }
        orderDetailInfoBusiness.setInvoicelatesttime(orderInfo.getInvoiceLatestTime() != null ? TimeUtils.convertDateToString(orderInfo.getInvoiceLatestTime(), TimeUtils.FORMAT1) : null);
        orderDetailInfoBusiness.setProofcode(UrlUtils.getBarUrl(orderInfo.getOrderId()));
        OrderDetailInfoExample orderDetailInfoExample = new OrderDetailInfoExample();
        orderDetailInfoExample.createCriteria().andOrderIdEqualTo(orderInfo.getOrderId());
        List<OrderDetailInfo> orderDetailInfoList = this.orderDetailInfoGeneratorQueryService.selectByExample(orderDetailInfoExample);
        if (CollectionUtils.isNotEmpty(orderDetailInfoList))
        {
            orderDetailInfoBusiness.setOrderDetailInfoList(orderDetailInfoList);
        }
        else
        {
            orderDetailInfoBusiness.setOrderDetailInfoList(null);
        }
        return orderDetailInfoBusiness;
    }

    private OrderDetailInfo4TableBusiness encapsulation4OrderDetailInfo4TableBusiness(OrderInfo orderInfo)
    {
        OrderDetailInfo4TableBusiness orderDetailInfo4TableBusiness = new OrderDetailInfo4TableBusiness();
        orderDetailInfo4TableBusiness.setOrderid(orderInfo.getOrderId());
        orderDetailInfo4TableBusiness.setShopid(orderInfo.getShopId());
        orderDetailInfo4TableBusiness.setUserid(orderInfo.getUserId());
        orderDetailInfo4TableBusiness.setScardno(orderInfo.getScardNo());
        orderDetailInfo4TableBusiness.setDiscountrate(orderInfo.getDiscountRate() != null ? orderInfo.getDiscountRate().toString() : "0.00");
        orderDetailInfo4TableBusiness.setGoodstotalnum(orderInfo.getGoodsTotalNum() != null ? orderInfo.getGoodsTotalNum().toString() : "0");
        orderDetailInfo4TableBusiness.setOriginalprice(orderInfo.getOriginalPrice() != null ? orderInfo.getOriginalPrice().toString() : "0.00");
        orderDetailInfo4TableBusiness.setPayprice(orderInfo.getPayPrice() != null ? orderInfo.getPayPrice().toString() : "0.00");
        ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectUnDelByPrimaryKey(orderInfo.getShopId());
        if (shopInfo != null)
        {
            orderDetailInfo4TableBusiness.setShopname(shopInfo.getShopName());
            orderDetailInfo4TableBusiness.setLogo(shopInfo.getLogo1());//正方形logo
        }
        String billimg = this.orderProtectedQueryService.getShopAuthorities(orderInfo.getOrderId(), orderInfo.getBillType());
        orderDetailInfo4TableBusiness.setBillimg(billimg);
        orderDetailInfo4TableBusiness.setDeskname(orderInfo.getDeskName());
        orderDetailInfo4TableBusiness.setRoomname(orderInfo.getRoomName());
        OrderDetailInfoExample orderDetailInfoExample = new OrderDetailInfoExample();
        orderDetailInfoExample.createCriteria().andOrderIdEqualTo(orderInfo.getOrderId());
        List<OrderDetailInfo> orderDetailInfoList = this.orderDetailInfoGeneratorQueryService.selectByExample(orderDetailInfoExample);
        if (CollectionUtils.isNotEmpty(orderDetailInfoList))
        {
            orderDetailInfo4TableBusiness.setOrderDetailInfoList(orderDetailInfoList);
        }
        else
        {
            orderDetailInfo4TableBusiness.setOrderDetailInfoList(null);
        }
        return orderDetailInfo4TableBusiness;
    }

    /**
     * 获取用户账单商家信息
     * @param shopInfoMap
     * @param shopId
     * @return
     */
    private ShopInfo getOrderShopInfo(Map<String, ShopInfo> shopInfoMap, String shopId)
    {
        ShopInfo shopInfo = shopInfoMap.get(shopId);
        if (shopInfo == null)
        {
            shopInfo = this.shopInfoGeneratorQueryService.selectByPrimaryKey(shopId);
            if (shopInfo == null)
            {
                return null;
            }
            shopInfoMap.put(shopId, shopInfo);
        }

        return shopInfo;
    }

    /**
     * 获取用户账单优惠凭证图片
     * @param couponMap
     * @param orderId
     * @return
     */
    private List<String> getOrderCouponImg(Map<String, Coupon> couponMap, String orderId)
    {
        OrderCouponInfoExample queryCondition = new OrderCouponInfoExample();
        queryCondition.createCriteria().andOrderIdEqualTo(orderId).andStatusEqualTo("2").andIsDealEqualTo("Y").andIsDelEqualTo("N");
        List<OrderCouponInfo> orderCouponInfoList = this.orderCouponInfoGeneratorQueryService.selectByExample(queryCondition);
        if (CollectionUtils.isEmpty(orderCouponInfoList))
        {
            return null;
        }
        List<String> couponImgList = new ArrayList<String>();
        for (OrderCouponInfo orderCouponInfo : orderCouponInfoList)
        {
            Coupon coupon = couponMap.get(orderCouponInfo.getCouponUserId());
            if (coupon == null)
            {
                FavoriteInfo favoriteInfo = this.favoriteInfoGeneratorQueryService.selectByPrimaryKey(orderCouponInfo.getCouponUserId());
                if (favoriteInfo != null)
                {
                    coupon = this.couponGeneratorQueryService.selectByPrimaryKey(favoriteInfo.getObjectId());
                    if (coupon != null)
                    {
                        couponMap.put(orderCouponInfo.getCouponUserId(), coupon);
                        couponImgList.add(coupon.getCouponUrl());
                    }
                }
            }
            else
            {
                couponImgList.add(coupon.getCouponUrl());
            }
        }
        if (couponImgList.size() == 0)
        {
            return null;
        }

        return couponImgList;
    }

    @Override
    public List<OrderDetailInShopEntity> findOrderDetailInShopEntity(String orderId, Integer pageIndex, Integer pageSize) throws Exception
    {
        List<OrderDetailInShopEntity> orderDetailInShopEntityList = null;
        OrderDetailInfoExample orderDetailInfoExample = new OrderDetailInfoExample();
        orderDetailInfoExample.createCriteria().andOrderIdEqualTo(orderId);
        if (pageIndex != null && pageSize != null)
        {
            orderDetailInfoExample.setPage(pageIndex, pageSize);
        }
        List<OrderDetailInfo> orderDetailInfoList = this.orderDetailInfoGeneratorQueryService.selectByExample(orderDetailInfoExample);
        if (CollectionUtils.isNotEmpty(orderDetailInfoList))
        {
            orderDetailInShopEntityList = new ArrayList<OrderDetailInShopEntity>();
            for (OrderDetailInfo orderDetailInfo : orderDetailInfoList)
            {
                OrderDetailInShopEntity orderDetailInShopEntity = new OrderDetailInShopEntity();

                orderDetailInShopEntity.setOrderDetailInfo(orderDetailInfo);//订单商品详细信息
                GoodsFeatureInfoExample goodsFeatureInfoExample = new GoodsFeatureInfoExample();
                goodsFeatureInfoExample.createCriteria().andGoodsIdEqualTo(orderDetailInfo.getGoodsId()).andShopIdEqualTo(orderDetailInfo.getShopId()).andIsDelEqualTo("N");
                List<GoodsFeatureInfo> goodsFeatureInfoList = this.goodsFeatureInfoGeneratorQueryService.selectByExample(goodsFeatureInfoExample);
                if (CollectionUtils.isNotEmpty(goodsFeatureInfoList))
                {
                    orderDetailInShopEntity.setGoodsFeatureInfoList(goodsFeatureInfoList);//商品特征信息
                }
                //以下从redis获取
                Map<String, String> goodsInfoMap = this.goodsCacheQueryService.findGoodsInfo(orderDetailInfo.getGoodsId());
                Map<String, String> goodsCategoryRootMap = this.goodsCacheQueryService.findGoodsCategory(orderDetailInfo.getShopEntityId(), orderDetailInfo.getGoodsCategoryRoot());
                Map<String, String> goodsCategoryLeafMap = this.goodsCacheQueryService.findGoodsCategory(orderDetailInfo.getShopEntityId(), orderDetailInfo.getGoodsCategoryLeaf());
                if (goodsCategoryRootMap != null && goodsCategoryRootMap.size() > 0)
                {
                    orderDetailInShopEntity.setGoodsCategoryRootName(goodsCategoryRootMap.get("goodsCategoryRoot"));//品类名称（根节点）
                }
                if (goodsCategoryLeafMap != null && goodsCategoryLeafMap.size() > 0)
                {
                    orderDetailInShopEntity.setGoodsCategoryLeafName(goodsCategoryLeafMap.get("goodsCategoryLeaf"));//品类名称（叶节点）
                }
                if (goodsInfoMap != null && goodsInfoMap.size() > 0)
                {
                    orderDetailInShopEntity.setGoodsBrandName(goodsInfoMap.get("brandName"));//品牌名称
                }
                orderDetailInShopEntityList.add(orderDetailInShopEntity);
            }
        }
        return orderDetailInShopEntityList;
    }

    @Override
    public List<PurchasedGoodsBusiness> findBoughtGoods(String userId, String shopId, String shopType, String shopEntityId, String goodsName, String begin, String end, Integer pageIndex, Integer pageSize) throws Exception
    {
        if (pageIndex == 1 && pageSize == -1)
        {//pageIndex=1且pagesize=-1时，不分页
            pageIndex = null;
            pageSize = null;
        }
        else if (pageIndex != null)
        {
            pageIndex = (pageIndex - 1) * pageSize;
        }
        List<String> shopIdList = null;
        if (StringUtils.hasText(shopType))
        {
            //获取当前商家类型及子类型的商家编号信息
            shopIdList = this.shopProtectedQueryService.getShopIdByShopType(shopType);
            if (CollectionUtils.isEmpty(shopIdList))
            {
                shopIdList = null;
            }
        }
        Date beginDate = null;
        Date endDate = null;
        if (StringUtils.hasText(begin))
        {
            beginDate = TimeUtils.convertStringToDate(begin);
        }
        if (StringUtils.hasText(end))
        {
            endDate = TimeUtils.convertStringToDate(end);
        }
        return this.orderInfoBusinessMapper.findBoughtGoodsList(userId, shopId, shopEntityId, shopIdList, beginDate, endDate, goodsName, pageIndex, pageSize);
    }

    @Override
    public List<Map<String, String>> findConfirmWeight(String mac, String shopEntityId, String ctimestamp) throws Exception
    {
        return this.shopProtectedQueryService.findByType(mac, shopEntityId, ctimestamp, "3");
    }

    @Override
    public List<Map<String, String>> findDiningNumbers(String mac, String shopentityid, String cTimeStamp) throws Exception
    {
        return this.shopProtectedQueryService.findByType(mac, shopentityid, cTimeStamp, "10");
    }

    @Override
    public List<CouponInfoBusiness> findCouponInfo(String shopEntityId, String cTimeStamp) throws Exception
    {
        OrderCouponInfoExample orderCouponInfoExample = new OrderCouponInfoExample();
        orderCouponInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andStatusEqualTo("1").andCTimeStampGreaterThan(TimeUtils.convertStringToDate(cTimeStamp)).andIsDelEqualTo("N");

        //1.查询订单优惠券信息
        List<OrderCouponInfo> orderCouponInfoList = this.orderCouponInfoGeneratorQueryService.selectByExample(orderCouponInfoExample);
        if (CollectionUtils.isEmpty(orderCouponInfoList))
        {
            GooagooLog.info("为查询到【shopEntityId=" + shopEntityId + ",cTimeStamp >" + cTimeStamp + "】的订单优惠券信息");
            return null;
        }

        //2.查询订单信息
        String orderId = "";//用来减少查询库的次数，相同的orderId只查询一次
        OrderInfo orderInfo = new OrderInfo();//用来减少创建此对象的次数
        List<CouponInfoBusiness> couponInfoBusinessList = new ArrayList<CouponInfoBusiness>();
        for (OrderCouponInfo orderCouponInfo : orderCouponInfoList)
        {
            if (!orderId.equals(orderCouponInfo.getOrderId()))
            {//订单编号不同的，会再次查询订单信息
                orderId = orderCouponInfo.getOrderId();
                orderInfo = this.orderInfoGeneratorQueryService.selectUnDelByPrimaryKey(orderCouponInfo.getOrderId());
            }

            if (orderInfo == null)
            {//表示没有查询到订单信息
                continue;
            }

            //3.查询优惠券编号
            FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
            favoriteInfoExample.createCriteria().andFavoriteIdEqualTo(orderCouponInfo.getCouponUserId()).andCouponStatusNotEqualTo("2").andIsDelEqualTo("N");
            List<FavoriteInfo> favoriteInfoList = this.favoriteInfoGeneratorQueryService.selectByExample(favoriteInfoExample);
            if (CollectionUtils.isEmpty(favoriteInfoList))
            {//订单中的优惠券信息不存在或已删除，或已经使用，没必要再查询出来
                continue;
            }
            FavoriteInfo favoriateInfo = favoriteInfoList.get(0);

            //4.在缓存中查询优惠券基本信息
            Map<String, String> couponMap = this.couponCacheQueryService.findCoupon(favoriateInfo.getObjectId());

            //5.封装订单优惠券相关信息
            CouponInfoBusiness tempCouponInfoBusiness = new CouponInfoBusiness();
            tempCouponInfoBusiness.setOrderid(orderId);
            tempCouponInfoBusiness.setTablename(orderInfo.getDeskName());
            tempCouponInfoBusiness.setCouponuserid(orderCouponInfo.getCouponUserId());
            tempCouponInfoBusiness.setCoupontype(couponMap.get("couponType"));
            tempCouponInfoBusiness.setCouponvalue(couponMap.get("couponValue"));
            tempCouponInfoBusiness.setCouponcontent(couponMap.get("couponContent"));
            tempCouponInfoBusiness.setCtimestamp(couponMap.get("cTimeStamp"));
            couponInfoBusinessList.add(tempCouponInfoBusiness);
        }

        return couponInfoBusinessList;
    }
}
