package com.gooagoo.query.business.marketing.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.marketing.coupon.CouponQueryService;
import com.gooagoo.api.generator.query.behave.FavoriteInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.CouponGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.marketing.CouponDetail;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample.Criteria;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.exception.common.NoDataException;

/**
 * 优惠凭证管理
 */
@Service
public class CouponQueryServiceImpl implements CouponQueryService
{

    @Autowired
    private CouponGeneratorQueryService couponGeneratorQueryService;
    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;
    @Autowired
    private FavoriteInfoGeneratorQueryService favoriteInfoGeneratorQueryService;

    @Override
    public CouponDetail findCouponDetail(String couponId) throws Exception
    {
        //1、获取优惠凭证详细信息
        Coupon coupon = this.couponGeneratorQueryService.selectByPrimaryKey(couponId);
        if (coupon == null || "Y".equals(coupon.getIsDel()))
        {
            GooagooLog.info("优惠凭证详情：优惠凭证（" + couponId + "）不存在或已被删除");
            throw new NoDataException("优惠凭证（" + couponId + "）不存在或已被删除");
        }
        //2、获取商家详细信息
        ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectByPrimaryKey(coupon.getShopId());
        if (shopInfo == null || "Y".equals(shopInfo.getIsDel()))
        {
            GooagooLog.info("优惠凭证详情：商家（" + coupon.getShopId() + "）不存在或已被删除");
            throw new NoDataException("商家（" + coupon.getShopId() + "）不存在或已被删除");
        }
        //4、组装返回数据
        CouponDetail couponDetail = new CouponDetail();
        couponDetail.setCoupon(coupon);
        couponDetail.setShopInfo(shopInfo);
        couponDetail.setCouponReserveNum(this.getCouponReserveNum(couponId, coupon.getAmount()));

        return couponDetail;
    }

    /**
     * 计算优惠凭证库存量
     * @param couponId
     * @param amount
     * @return
     */
    private Integer getCouponReserveNum(String couponId, Integer amount)
    {
        //用户已经拥有数量（已用的+未用且未删除的）
        try
        {
            FavoriteInfoExample queryCondition = new FavoriteInfoExample();
            Criteria criteria = queryCondition.createCriteria();
            criteria.andObjectIdEqualTo(couponId);
            criteria.andCouponStatusEqualTo("Y");
            Integer favoriteNum1 = this.favoriteInfoGeneratorQueryService.countByExample(queryCondition);
            criteria.andCouponStatusEqualTo("N").andIsDelEqualTo("N");
            Integer favoriteNum2 = this.favoriteInfoGeneratorQueryService.countByExample(queryCondition);
            Integer reserveNum = amount - favoriteNum1 - favoriteNum2;
            if (reserveNum < 0)
            {
                return 0;
            }

            return reserveNum;
        }
        catch (Exception e)
        {
            GooagooLog.error("计算优惠凭证库存量：计算优惠凭证（" + couponId + "）库存量异常", e);
            return 0;
        }
    }

}
