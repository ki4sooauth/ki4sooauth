package com.gooagoo.mobile.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.member.swipe.SwipeCardQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.AudioMobileService;
import com.gooagoo.mobile.common.MessageConst;

@Service
public class AudioMobileServiceImpl implements AudioMobileService
{
    @Autowired
    private SwipeCardQueryService swipeCardQueryService;

    @Override
    public void approvePlayCouponSound(String couponId, String userId, String shopId) throws Exception
    {
        if (!this.swipeCardQueryService.checkCouponAudio(couponId, userId, shopId))
        {
            GooagooLog.warn("非本人优惠凭证编号【couponId=" + couponId + ",userId=" + userId + ",shopId=" + shopId + "查询不到对应收藏优惠券信息】");
            throw new MessageException(MessageConst.MOBILE_AUDIO_INFO_ERROR);
        }
    }

    @Override
    public void approvePlayOrderSound(String orderId, String userId, String shopId) throws Exception
    {
        if (!this.swipeCardQueryService.checkOrderAudio(orderId, userId, shopId))
        {
            GooagooLog.warn("非本人订单编号【orderId=" + orderId + ",userId=" + userId + ",shopId=" + shopId + "查询不到对应订单信息】");
            throw new MessageException(MessageConst.MOBILE_AUDIO_INFO_ERROR);
        }

    }

    @Override
    public void approvePlayVoucherSoundRoot(String voucherId, String userId, String shopId) throws Exception
    {
        if (!this.swipeCardQueryService.checkPickGoodsAudio(voucherId, userId, shopId))
        {
            GooagooLog.warn("非本人订单编号【voucherId=" + voucherId + ",userId=" + userId + ",shopId=" + shopId + "查询不到对应账单信息】");
            throw new MessageException(MessageConst.MOBILE_AUDIO_INFO_ERROR);
        }

    }

    @Override
    public void approvePlayInvoiceSound(String orderId, String userId, String shopId) throws Exception
    {
        if (!this.swipeCardQueryService.checkInvoiceAudio(orderId, userId, shopId))
        {
            GooagooLog.warn("非本人订单编号【orderId=" + orderId + ",userId=" + userId + ",shopId=" + shopId + "查询不到对应发票信息】");
            throw new MessageException(MessageConst.MOBILE_AUDIO_INFO_ERROR);
        }

    }

    @Override
    public void approvePlayScardNoSound(String scardno, String userId, String shopId) throws Exception
    {
        if (!this.swipeCardQueryService.checkCardAudio(scardno, userId, shopId))
        {
            GooagooLog.warn("非本人会员卡编号【scardno=" + scardno + ",userId=" + userId + "查询不到对应会员卡信息】");
            throw new MessageException(MessageConst.MOBILE_AUDIO_INFO_ERROR);
        }

    }

}
