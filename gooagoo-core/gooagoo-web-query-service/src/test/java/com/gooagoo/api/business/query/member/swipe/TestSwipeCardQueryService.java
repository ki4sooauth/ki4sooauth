package com.gooagoo.api.business.query.member.swipe;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.member.CardinfoBusiness;
import com.gooagoo.entity.business.transaction.OrderBusiness;
import com.gooagoo.entity.business.user.favorite.coupon.CouponInfoBusiness;

public class TestSwipeCardQueryService
{

    @Autowired
    public SwipeCardQueryService swipeCardQueryService;

    @Before
    public void testBefore()
    {
        this.swipeCardQueryService = ApplicationContextUtils.getBean(SwipeCardQueryService.class);
    }

    /**
     * mobl01 : 是否允许用户播放优惠劵音频 
     */
    @Test
    public void testCheckCouponAudio() throws Exception
    {
        String favoriteId = "00017RA5OK4KSUMP20009LEIISX84023";
        String userId = "00017QDVT76FDE9C400007EIISX8Q0T6";
        String shopId = "01822IE57DH111M085QBPFEIISWR0JGT";
        Assert.isTrue(this.swipeCardQueryService.checkCouponAudio(favoriteId, userId, shopId), "验证是否允许用户播放优惠劵音频失败");
    }

    /**
     * mobl02 : 是否允许用户播放订单音频 
     */
    @Test
    public void testCheckOrderAudio() throws Exception
    {
        String orderId = "2000000000000003";
        String userId = "01822RBQ22JSDMA085QBV8EIISWR0JGT";
        String shopId = "01822IE57DH111M085QBPFEIISWR0JGT";
        Assert.isTrue(this.swipeCardQueryService.checkOrderAudio(orderId, userId, shopId), "是否允许用户播放订单音频失败");
    }

    /**
     * mobl03 : 是否允许用户播放提货凭证音频 
     */
    @Test
    public void testCheckPickGoodsAudio() throws Exception
    {
        String orderId = "2000000000000004";
        String userId = "01822RBQ22JSDMA085QBV8EIISWR0JGT";
        String shopId = "01822IE57DH111M085QBPFEIISWR0JGT";
        Assert.isTrue(this.swipeCardQueryService.checkPickGoodsAudio(orderId, userId, shopId), "是否允许用户播放提货凭证音频失败");
    }

    /**
     * mobl04 : 是否允许用户播放取发票音频 
     */
    @Test
    public void testCheckInvoiceAudio() throws Exception
    {
        String orderId = "2000000000000005";
        String userId = "01822RBQ22JSDMA085QBV8EIISWR0JGT";
        String shopId = "01822IE57DH111M085QBPFEIISWR0JGT";
        Assert.isTrue(this.swipeCardQueryService.checkInvoiceAudio(orderId, userId, shopId), "是否允许用户播放取发票音频失败");
    }

    /**
     * mobl05 : 是否允许用户播放会员卡音频 
     */
    @Test
    public void testCheckCardAudio() throws Exception
    {
        String scardno = "1002000000000300";
        String userId = "01822RBQ22JSDMA085QBV8EIISWR0JGT";
        String shopId = "01822IAKR5SKU02085QBP2EIISWR0JGT";
        Assert.isTrue(this.swipeCardQueryService.checkCardAudio(scardno, userId, shopId), "是否允许用户播放会员卡音频失败");
    }

    /**
     * gtsd01:根据优惠劵编号查询商家优惠劵信息
     */
    @Test
    public void testFindCouponInfo() throws Exception
    {
        String favoriteId = "00017RA5OK4KSUMP20009LEIISX84023";
        String shopEntityId = "xxxxxxxxx";
        String shopId = "01822IE57DH111M085QBPFEIISWR0JGT";
        CouponInfoBusiness couponInfoBusiness = this.swipeCardQueryService.findCouponInfo(favoriteId, shopEntityId, shopId);
        Assert.notNull(couponInfoBusiness, "根据优惠劵编号查询商家优惠劵信息失败");
    }

    /**
     * gtsd02:根据订单编号查询商家的订单/账单信息
     */
    @Test
    public void testFindOrderInfo() throws Exception
    {
        String orderId = "2000000000000003";
        String shopId = "01822IE57DH111M085QBPFEIISWR0JGT";
        OrderBusiness orderBusiness = this.swipeCardQueryService.findOrderInfo(orderId, shopId);
        Assert.notNull(orderBusiness, "根据订单编号查询商家的订单/账单信息失败");
    }

    /**
     * gtsd03:根据提货凭证编号查询商家订单/账单信息
     */
    @Test
    public void testFindPickGoodsInfo() throws Exception
    {
        String orderId = "2000000000000004";
        String shopId = "01822IE57DH111M085QBPFEIISWR0JGT";
        OrderBusiness orderBusiness = this.swipeCardQueryService.findPickGoodsInfo(orderId, shopId);
        Assert.notNull(orderBusiness, "根据提货凭证编号查询商家订单/账单信息失败");
    }

    /**
     * gtsd04:根据发票凭证查询发票申请信息
     */
    @Test
    public void testFindInvoiceInfo() throws Exception
    {
        String orderId = "2000000000000005";
        String shopId = "01822IE57DH111M085QBPFEIISWR0JGT";
        OrderBusiness orderBusiness = this.swipeCardQueryService.findInvoiceInfo(orderId, shopId);
        Assert.notNull(orderBusiness, "根据发票凭证查询发票申请信息失败");
    }

    /**
     * 用户通过店员助理刷卡
     * @throws Exception
     */
    @Test
    public void testUserSwipe() throws Exception
    {
        String scardno = "1002000000000300";
        String shopId = "01822IE57DH111M085QBPFEIISWR0JGT";
        CardinfoBusiness cardinfoBusiness = this.swipeCardQueryService.userSwipe(scardno, shopId);
        Assert.notNull(cardinfoBusiness, "用户通过店员助理刷卡失败");
    }

}
