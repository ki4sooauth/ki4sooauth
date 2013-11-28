package com.gooagoo.mobile.api;

/**
 * 音频相关服务接口
 */
public interface AudioMobileService
{
    /**
     * MOBL01:是否允许用户播放优惠劵音频
     * @param couponId
     * @param userId
     * @param shopId
     * @throws Exception
     */
    public void approvePlayCouponSound(String couponId, String userId, String shopId) throws Exception;

    /**
     * MOBL02:是否允许用户播放订单音频
     * @param orderId
     * @param userId
     * @param shopId
     * @throws Exception
     */
    public void approvePlayOrderSound(String orderId, String userId, String shopId) throws Exception;

    /**
     * MOBL03:是否允许用户播放提货凭证音频
     * @param voucherId
     * @param userId
     * @param shopId
     * @throws Exception
     */
    public void approvePlayVoucherSoundRoot(String voucherId, String userId, String shopId) throws Exception;

    /**
     * MOBL04:是否允许用户播放取发票音频
     * @param orderId
     * @param userId
     * @param shopId
     * @throws Exception
     */
    public void approvePlayInvoiceSound(String orderId, String userId, String shopId) throws Exception;

    /**
     * MOBL05:是否允许用户播放会员卡音频
     * @param scardno
     * @param userId
     * @param shopId
     * @throws Exception
     */
    public void approvePlayScardNoSound(String scardno, String userId, String shopId) throws Exception;

}
