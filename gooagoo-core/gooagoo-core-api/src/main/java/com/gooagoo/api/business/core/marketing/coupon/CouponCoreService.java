package com.gooagoo.api.business.core.marketing.coupon;

import java.util.List;
import java.util.Map;

import com.gooagoo.entity.generator.marketing.Coupon;

/**
 * 优惠凭证管理
 */
public interface CouponCoreService
{

    /**
     *     6.1.5. 删除优惠凭证
     * @param couponId
     * @return true/false
     * @throws Exception
     */
    public boolean deleteCoupon(String couponId) throws Exception;

    /**
     *  6.1.6. 添加优惠凭证
     * @param Coupon
     * @return true/false
     * @throws Exception
     */
    public boolean addCoupon(Coupon coupon, List<String> couponNoList) throws Exception;

    /**
     *  修改优惠凭证
     * @param Coupon
     * @return true/false
     * @throws Exception
     */
    public boolean updateCoupon(Coupon coupon, List<String> couponNoList) throws Exception;

    /**
     *     6.4.3. 审核优惠凭证
     * @param cryoutId
     * @param status 审核状态(Y-通过，N-不通过)
     * @param note 审核备注
     * @return
     * @throws Exception
     */
    public boolean reviewedCoupon(String couponId, String status, String note) throws Exception;

    /**
     *     6.4.4. 发布优惠凭证
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean publishCoupon(String couponId) throws Exception;

    /**
     * gtsc08:商家确认优惠凭证是否可用
     * @param orderid
     * @param agreeyList 优惠凭证{[favoriteid:"",agreetype:"Y-同意，N-不同意"]}
     * @return
     * @throws Exception
     */
    public boolean confirmCoupon(String orderid, List<Map<String, String>> agreeyList) throws Exception;

}
