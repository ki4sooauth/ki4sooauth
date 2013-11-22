package com.gooagoo.query.business.member.swipe;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.member.swipe.SwipeCardQueryService;
import com.gooagoo.api.generator.query.behave.FavoriteInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.BillInvoiceLogGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderCouponInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderDetailInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.CouponGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.CouponGrantInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.IntegralInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.business.member.CardinfoBusiness;
import com.gooagoo.entity.business.transaction.OrderBusiness;
import com.gooagoo.entity.business.user.favorite.coupon.CouponInfoBusiness;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.bill.BillInvoiceLog;
import com.gooagoo.entity.generator.bill.BillInvoiceLogExample;
import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.OrderCouponInfoExample;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.CouponGrantInfo;
import com.gooagoo.entity.generator.marketing.CouponGrantInfoExample;
import com.gooagoo.entity.generator.member.IntegralInfo;
import com.gooagoo.entity.generator.member.IntegralInfoExample;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.exception.business.card.CardAlreadyOverdueException;
import com.gooagoo.exception.business.card.CardNotBelongShopException;
import com.gooagoo.exception.business.card.CardNotBelongUserException;
import com.gooagoo.exception.business.card.CardNotExistsException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.redis.data.RedisStringDao;

@Service
public class SwipeCardQueryServiceImpl implements SwipeCardQueryService
{

    @Autowired
    private FavoriteInfoGeneratorQueryService favoriteInfoGeneratorQueryService;
    @Autowired
    private OrderInfoGeneratorQueryService orderInfoGeneratorQueryService;
    @Autowired
    private OrderDetailInfoGeneratorQueryService orderDetailInfoGeneratorQueryService;
    @Autowired
    private BillInvoiceLogGeneratorQueryService billInvoiceLogGeneratorQueryService;
    @Autowired
    private CouponGrantInfoGeneratorQueryService couponGrantInfoGeneratorQueryService;
    @Autowired
    private CouponGeneratorQueryService couponGeneratorQueryService;
    @Autowired
    private OrderCouponInfoGeneratorQueryService orderCouponInfoGeneratorQueryService;
    @Autowired
    private MemberOfCardGeneratorQueryService memberOfCardGeneratorQueryService;
    @Autowired
    private MemberCardGeneratorQueryService memberCardGeneratorQueryService;
    @Autowired
    private IntegralInfoGeneratorQueryService integralInfoGeneratorQueryService;

    @Override
    public boolean checkCouponAudio(String favoriteId, String userId, String shopId) throws Exception
    {
        FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
        favoriteInfoExample.createCriteria().andShopIdEqualTo(shopId).andFavoriteIdEqualTo(favoriteId).andUserIdEqualTo(userId).andIsDelEqualTo("N");
        List<FavoriteInfo> favoriteInfoList = this.favoriteInfoGeneratorQueryService.selectByExample(favoriteInfoExample);
        if (CollectionUtils.isNotEmpty(favoriteInfoList))
        {
            RedisStringDao strDao = new RedisStringDao(RedisServerConstants.business_swiping);
            strDao.set(favoriteId + "_" + shopId, 10, favoriteId);//测试暂时不设置有效时间
            //            strDao.set(favoriteId + "_" + shopId, favoriteId);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkOrderAudio(String orderId, String userId, String shopId) throws Exception
    {
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        orderInfoExample.createCriteria().andShopIdEqualTo(shopId).andOrderIdEqualTo(orderId).andUserIdEqualTo(userId).andIsDelEqualTo("N");
        List<OrderInfo> orderInfoList = this.orderInfoGeneratorQueryService.selectByExample(orderInfoExample);
        if (CollectionUtils.isNotEmpty(orderInfoList))
        {
            RedisStringDao strDao = new RedisStringDao(RedisServerConstants.business_swiping);
            strDao.set(orderId + "_" + shopId, 10, orderId);//测试暂时不设置有效时间
            //            strDao.set(orderId + "_" + shopId, orderId);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPickGoodsAudio(String orderId, String userId, String shopId) throws Exception
    {
        String newOrderId = orderId.substring(0, orderId.length() - 2) + "03";
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        orderInfoExample.createCriteria().andShopIdEqualTo(shopId).andOrderIdEqualTo(newOrderId).andUserIdEqualTo(userId).andBillTypeEqualTo("3").andIsDelEqualTo("N");
        List<OrderInfo> orderInfoList = this.orderInfoGeneratorQueryService.selectByExample(orderInfoExample);
        if (CollectionUtils.isNotEmpty(orderInfoList))
        {
            RedisStringDao strDao = new RedisStringDao(RedisServerConstants.business_swiping);
            strDao.set(orderId + "_" + shopId, 10, orderId);//测试暂时不设置有效时间
            //            strDao.set(orderId + "_" + shopId, orderId);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkInvoiceAudio(String orderId, String userId, String shopId) throws Exception
    {
        String newOrderId = orderId.substring(0, orderId.length() - 2) + "03";
        BillInvoiceLogExample billInvoiceLogExample = new BillInvoiceLogExample();
        billInvoiceLogExample.createCriteria().andShopIdEqualTo(shopId).andOrderIdEqualTo(newOrderId).andUserIdEqualTo(userId).andIsDelEqualTo("N");
        List<BillInvoiceLog> billInvoiceLogList = this.billInvoiceLogGeneratorQueryService.selectByExample(billInvoiceLogExample);
        if (CollectionUtils.isNotEmpty(billInvoiceLogList))
        {
            RedisStringDao strDao = new RedisStringDao(RedisServerConstants.business_swiping);
            strDao.set(orderId + "_" + shopId, 10, orderId);//测试暂时不设置有效时间
            //            strDao.set(orderId + "_" + shopId, orderId);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkCardAudio(String scardno, String userId, String shopId) throws Exception
    {
        MemberOfCard memberOfCard = this.memberOfCardGeneratorQueryService.selectUnDelByPrimaryKey(scardno);
        //会员卡是否存在
        if (memberOfCard == null)
        {
            GooagooLog.warn("[scardno=" + scardno + "]会员卡不存在");
            throw new CardNotExistsException("[scardno=" + scardno + "]会员卡不存在");
        }
        //有效期
        if (memberOfCard.getExpireDate() != null && new Date().after(memberOfCard.getExpireDate()))
        {
            GooagooLog.warn("[scardno=" + scardno + "]会员卡于" + memberOfCard.getExpireDate() + "已过期");
            throw new CardAlreadyOverdueException("[scardno=" + scardno + "]会员卡于" + memberOfCard.getExpireDate() + "已过期");
        }
        //是否是指定用户卡
        if (!userId.equals(memberOfCard.getUserId()))
        {
            GooagooLog.warn("[scardno=" + scardno + "]会员卡会员卡不属于[" + userId + "]用户");
            throw new CardNotBelongUserException("[scardno=" + scardno + "]会员卡会员卡不属于[userId=" + userId + "]用户");
        }
        //是否是本商家卡
        if (!shopId.equals(memberOfCard.getShopId()))
        {
            GooagooLog.warn("[scardno=" + scardno + "]会员卡会员卡不属于[" + shopId + "]商家");
            throw new CardNotBelongShopException("[scardno=" + scardno + "]会员卡会员卡不属于[shopid=" + shopId + "]商家");
        }
        RedisStringDao strDao = new RedisStringDao(RedisServerConstants.business_swiping);
        strDao.set(scardno + "_" + shopId, 10, scardno);//测试暂不舍得有效时间
        //        strDao.set(scardno + "_" + shopId, scardno);
        return true;
    }

    @Override
    public CouponInfoBusiness findCouponInfo(String favoriteId, String shopEntityId, String shopId) throws Exception
    {
        CouponInfoBusiness couponInfoBusiness = null;
        RedisStringDao strDao = new RedisStringDao(RedisServerConstants.business_swiping);
        String oldFavoriteId = strDao.get(favoriteId + "_" + shopId);
        if (StringUtils.isBlank(oldFavoriteId))
        {
            throw new NullException("redis获取优惠券信息为空[key=" + favoriteId + "]");
        }

        FavoriteInfo favoriteInfo = this.favoriteInfoGeneratorQueryService.selectUnDelByPrimaryKey(favoriteId);
        if (favoriteInfo != null)
        {
            Coupon coupon = this.couponGeneratorQueryService.selectUnDelByPrimaryKey(favoriteInfo.getObjectId());
            if (coupon != null)
            {
                couponInfoBusiness = new CouponInfoBusiness();
                couponInfoBusiness.setCouponcontent(coupon.getCouponContent());
                couponInfoBusiness.setCoupontype(coupon.getCouponType());
                if (coupon.getCouponValue() != null)
                {
                    DecimalFormat df = new DecimalFormat("0.00");
                    couponInfoBusiness.setCouponvalue(df.format(coupon.getCouponValue()));
                }
                couponInfoBusiness.setCtimestamp(coupon.getCTimeStamp() != null ? TimeUtils.convertDateToString(coupon.getCTimeStamp(), TimeUtils.FORMAT1) : "");
                //查询优惠凭证发放号段对应表
                CouponGrantInfoExample couponGrantInfoExample = new CouponGrantInfoExample();
                couponGrantInfoExample.createCriteria().andCouponIdEqualTo(coupon.getCouponId()).andIsDelEqualTo("N");
                List<CouponGrantInfo> couponGrantInfoList = this.couponGrantInfoGeneratorQueryService.selectByExample(couponGrantInfoExample);
                if (CollectionUtils.isNotEmpty(couponGrantInfoList))
                {
                    CouponGrantInfo couponGrantInfo = couponGrantInfoList.get(0);
                    couponInfoBusiness.setCouponuserid(couponGrantInfo.getCouponNo());//号段号码
                }
                //查询订单信息
                OrderCouponInfoExample orderCouponInfoExample = new OrderCouponInfoExample();
                orderCouponInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andCouponUserIdEqualTo(favoriteId).andIsDelEqualTo("N");
                orderCouponInfoExample.setOrderByClause("c_time_stamp DESC");
                List<OrderCouponInfo> orderCouponInfoList = this.orderCouponInfoGeneratorQueryService.selectByExample(orderCouponInfoExample);
                String orderId = CollectionUtils.isNotEmpty(orderCouponInfoList) ? orderCouponInfoList.get(0).getOrderId() : null;
                if (StringUtils.isNotBlank(orderId))
                {
                    couponInfoBusiness.setOrderid(orderId);
                    OrderInfo orderInfo = this.orderInfoGeneratorQueryService.selectUnDelByPrimaryKey(orderId);
                    couponInfoBusiness.setTablename(orderInfo != null ? orderInfo.getDeskName() : null);
                }
            }

        }
        return couponInfoBusiness;
    }

    @Override
    public OrderBusiness findOrderInfo(String orderId, String shopId) throws Exception
    {
        OrderBusiness orderBusiness = null;
        RedisStringDao strDao = new RedisStringDao(RedisServerConstants.business_swiping);
        String oldFavoriteId = strDao.get(orderId + "_" + shopId);
        if (StringUtils.isBlank(oldFavoriteId))
        {
            throw new NullException("redis获取订单编号为空[key=" + orderId + "]");
        }
        OrderInfo orderInfo = this.orderInfoGeneratorQueryService.selectUnDelByPrimaryKey(orderId);
        if (orderInfo != null)
        {
            orderBusiness = new OrderBusiness();
            orderBusiness.setOrderInfo(orderInfo);//封装订单信息
            OrderDetailInfoExample orderDetailInfoExample = new OrderDetailInfoExample();
            orderDetailInfoExample.createCriteria().andOrderIdEqualTo(orderId);
            List<OrderDetailInfo> orderDetailInfoList = this.orderDetailInfoGeneratorQueryService.selectByExample(orderDetailInfoExample);
            orderBusiness.setOrderDetailInfoList(CollectionUtils.isNotEmpty(orderDetailInfoList) ? orderDetailInfoList : null);//封装订单商品详细信息
        }
        return orderBusiness;
    }

    @Override
    public OrderBusiness findPickGoodsInfo(String orderId, String shopId) throws Exception
    {

        RedisStringDao strDao = new RedisStringDao(RedisServerConstants.business_swiping);
        String oldFavoriteId = strDao.get(orderId + "_" + shopId);
        if (StringUtils.isBlank(oldFavoriteId))
        {
            throw new NullException("redis获取提货凭证编号为空[key=" + orderId + "]");
        }
        orderId = orderId.substring(0, orderId.length() - 2) + "03";
        OrderInfo orderInfo = this.orderInfoGeneratorQueryService.selectUnDelByPrimaryKey(orderId);
        OrderBusiness orderBusiness = null;
        if (orderInfo != null)
        {
            orderBusiness = new OrderBusiness();
            orderBusiness.setOrderInfo(orderInfo);//封装订单信息
            OrderDetailInfoExample orderDetailInfoExample = new OrderDetailInfoExample();
            orderDetailInfoExample.createCriteria().andOrderIdEqualTo(orderId);
            List<OrderDetailInfo> orderDetailInfoList = this.orderDetailInfoGeneratorQueryService.selectByExample(orderDetailInfoExample);
            orderBusiness.setOrderDetailInfoList(CollectionUtils.isNotEmpty(orderDetailInfoList) ? orderDetailInfoList : null);//封装订单商品详细信息
        }
        return orderBusiness;
    }

    @Override
    public OrderBusiness findInvoiceInfo(String orderId, String shopId) throws Exception
    {
        OrderBusiness orderBusiness = null;
        RedisStringDao strDao = new RedisStringDao(RedisServerConstants.business_swiping);
        String oldFavoriteId = strDao.get(orderId + "_" + shopId);
        if (StringUtils.isBlank(oldFavoriteId))
        {
            throw new NullException("redis获取发票凭证编号为空[key=" + orderId + "]");
        }
        orderId = orderId.substring(0, orderId.length() - 2) + "03";
        OrderInfo orderInfo = this.orderInfoGeneratorQueryService.selectUnDelByPrimaryKey(orderId);
        if (orderInfo != null)
        {
            orderBusiness = new OrderBusiness();
            orderBusiness.setOrderInfo(orderInfo);//封装订单信息
            BillInvoiceLog billInvoiceLog = this.billInvoiceLogGeneratorQueryService.selectUnDelByPrimaryKey(orderId);
            orderBusiness.setBillInvoiceLog(billInvoiceLog);//封装开发票申请信息
            OrderDetailInfoExample orderDetailInfoExample = new OrderDetailInfoExample();
            orderDetailInfoExample.createCriteria().andOrderIdEqualTo(orderId);
            List<OrderDetailInfo> orderDetailInfoList = this.orderDetailInfoGeneratorQueryService.selectByExample(orderDetailInfoExample);
            orderBusiness.setOrderDetailInfoList(orderDetailInfoList);//封装订单商品详细信息
        }
        return orderBusiness;
    }

    @Override
    public CardinfoBusiness userSwipe(String scardno, String shopId) throws Exception
    {
        CardinfoBusiness cardinfoBusiness = null;
        RedisStringDao strDao = new RedisStringDao(RedisServerConstants.business_swiping);
        String oldScardno = strDao.get(scardno + "_" + shopId);
        if (StringUtils.isBlank(oldScardno))
        {
            throw new NullException("redis获取会员卡卡号为空[key=" + scardno + "]");
        }
        MemberOfCard memberOfCard = this.memberOfCardGeneratorQueryService.selectUnDelByPrimaryKey(scardno);
        if (memberOfCard != null)
        {
            cardinfoBusiness = new CardinfoBusiness();
            cardinfoBusiness.setScardno(scardno);
            MemberCard memberCard = this.memberCardGeneratorQueryService.selectUnDelByPrimaryKey(memberOfCard.getCardId());
            if (memberCard != null)
            {
                cardinfoBusiness.setMemberCard(memberCard);
                cardinfoBusiness.setCardname(memberCard.getCardName());
                IntegralInfoExample integralInfoExample = new IntegralInfoExample();
                List<IntegralInfo> integralInfoList = this.integralInfoGeneratorQueryService.selectByExample(integralInfoExample);
                if (CollectionUtils.isNotEmpty(integralInfoList))
                {
                    Integer jifen = integralInfoList.get(0).getUseableIntegralNumber();
                    cardinfoBusiness.setJifen(jifen != null ? jifen.toString() : "0");
                }
            }
        }
        return cardinfoBusiness;
    }

}
