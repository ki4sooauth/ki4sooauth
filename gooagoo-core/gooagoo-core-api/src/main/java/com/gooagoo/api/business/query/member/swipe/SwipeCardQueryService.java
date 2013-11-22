package com.gooagoo.api.business.query.member.swipe;

import com.gooagoo.entity.business.member.CardinfoBusiness;
import com.gooagoo.entity.business.transaction.OrderBusiness;
import com.gooagoo.entity.business.user.favorite.coupon.CouponInfoBusiness;
import com.gooagoo.exception.business.card.CardAlreadyOverdueException;
import com.gooagoo.exception.business.card.CardNotBelongShopException;
import com.gooagoo.exception.business.card.CardNotBelongUserException;
import com.gooagoo.exception.business.card.CardNotExistsException;

public interface SwipeCardQueryService
{

    /**
     * mobl01 : 是否允许用户播放优惠劵音频 
     * @param couponid 优惠凭证编号
     * @param userId 用户名
     * @param shopId
     * @return
     * @throws Exception
     */
    public boolean checkCouponAudio(String favoriteId, String userId, String shopId) throws Exception;

    /**
     * mobl02 : 是否允许用户播放订单音频 
     * @param couponid 优惠凭证编号
     * @param userId 用户名
     * @param shopId
     * @return
     * @throws Exception
     */
    public boolean checkOrderAudio(String orderId, String userId, String shopId) throws Exception;

    /**
     * mobl03 : 是否允许用户播放提货凭证音频 
     * @param couponid 优惠凭证编号
     * @param userId 用户名
     * @param shopId
     * @return
     * @throws Exception
     */
    public boolean checkPickGoodsAudio(String orderId, String userId, String shopId) throws Exception;

    /**
     * mobl04 : 是否允许用户播放取发票音频 
     * @param couponid 优惠凭证编号
     * @param userId 用户名
     * @param shopId
     * @return
     * @throws Exception
     */
    public boolean checkInvoiceAudio(String orderId, String userId, String shopId) throws Exception;

    /**
     * mobl05 : 是否允许用户播放会员卡音频 
     * @param scardno 会员卡卡号
     * @param userId 用户名
     * @param shopId 商家编号
     * @return
     * @throws CardAlreadyOverdueException 会员卡过期异常
     * @throws CardNotBelongShopException 会员卡不属于指定商家异常
     * @throws CardNotBelongUserException 会员卡不属于指定用户异常
     * @throws CardNotExistsException 会员卡不存在异常
     */
    public boolean checkCardAudio(String scardno, String userId, String shopId) throws Exception;

    /**
     * gtsd01:根据优惠劵编号查询商家优惠劵信息
     * @param favoriteId 优惠凭证编号
     * @param shopentityid 实体店编号
     * @param shopId
     * @return
     * @throws Exception
     */
    public CouponInfoBusiness findCouponInfo(String favoriteId, String shopEntityId, String shopId) throws Exception;

    /**
     * gtsd02:根据订单编号查询商家的订单/账单信息
     * @param favoriteId 优惠凭证编号
     * @param shopId
     * @return
     * @throws Exception
     */
    public OrderBusiness findOrderInfo(String orderId, String shopId) throws Exception;

    /**
     * gtsd03:根据提货凭证编号查询商家订单/账单信息
     * @param favoriteId 优惠凭证编号
     * @param shopId
     * @return
     * @throws Exception
     */
    public OrderBusiness findPickGoodsInfo(String orderId, String shopId) throws Exception;

    /**
     * gtsd04:根据发票凭证查询发票申请信息
     * @param favoriteId 优惠凭证编号
     * @param shopId
     * @return
     * @throws Exception
     */
    public OrderBusiness findInvoiceInfo(String orderId, String shopId) throws Exception;

    /*****
     * 用户发起申请刷卡请求
     * gasc06、gtsc11
     * @param scardno
     * @param shopId
     */
    public CardinfoBusiness userSwipe(String scardno, String shopId) throws Exception;

}
