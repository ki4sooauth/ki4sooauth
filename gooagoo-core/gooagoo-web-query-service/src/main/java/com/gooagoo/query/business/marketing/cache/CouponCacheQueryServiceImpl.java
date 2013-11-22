package com.gooagoo.query.business.marketing.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.marketing.cache.CouponCacheQueryService;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.marketing.CouponMapper;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.CouponKey;
import com.gooagoo.redis.data.RedisHashDao;

/**
 * 从缓存中查询优惠凭证相关信息
 */
@Service
public class CouponCacheQueryServiceImpl implements CouponCacheQueryService
{
    @Autowired
    CouponMapper couponService;

    @Override
    public Map<String, String> findCoupon(String couponId)
    {
        RedisHashDao redisHashDao = new RedisHashDao(RedisServerConstants.business_coupon);
        Map<String, String> result = redisHashDao.get(couponId);
        if (result == null || result.size() == 0)
        {
            CouponKey couponKey = new CouponKey();
            couponKey.setCouponId(couponId);
            couponKey.setIsDel("N");
            Coupon coupon = this.couponService.selectByPrimaryKey(couponKey);
            if (coupon != null && "P".equals(coupon.getPublishStatus()))
            {
                result = this.assembling(coupon);
                redisHashDao.set(couponId, result);
            }
        }
        return result;
    }

    private Map<String, String> assembling(Coupon coupon)
    {
        Map<String, String> result = new HashMap<String, String>();
        result.put("couponName", coupon.getCouponName());//优惠凭证名称
        result.put("shopId", coupon.getShopId());//商家编号
        result.put("publishStartTime", TimeUtils.convertDateToString(coupon.getPublishStartTime(), TimeUtils.FORMAT1));//优惠凭证发行开始日期
        result.put("publishEndTime", TimeUtils.convertDateToString(coupon.getPublishEndTime(), TimeUtils.FORMAT1));//优惠凭证发行截止日期
        result.put("useStartTime", TimeUtils.convertDateToString(coupon.getUseStartTime(), TimeUtils.FORMAT1));//使用生效日期
        result.put("useEndTime", TimeUtils.convertDateToString(coupon.getUseEndTime(), TimeUtils.FORMAT1));//使用截止日期
        result.put("couponType", coupon.getCouponType());//优惠凭证类型，参考通用字典表的coupon_type
        result.put("couponValue", coupon.getCouponValue().toString());//优惠凭证额度，代金券对应代金金额，折扣券对应折扣率
        result.put("amount", coupon.getAmount().toString());//优惠凭证最多发放的数量
        result.put("maxNumOwner", coupon.getMaxNumOwner().toString());//同一用户最多拥有的有效优惠凭证数量
        result.put("couponUrl", coupon.getCouponUrl());//优惠凭证图片URL
        result.put("couponContent", coupon.getCouponContent());//优惠凭证内容，具体信息保存在mongodb中
        result.put("couponChannle", coupon.getCouponChannle());//优惠凭证发布渠道，参考通用字典表的coupon_channle
        result.put("couponSource", coupon.getCouponSource());//优惠凭证来源，参考通用字典表的coupon_source
        result.put("checkJson", coupon.getCheckJson());//使用校验，保存校验json串，具体信息保存在mongodb中
        result.put("templateId", coupon.getTemplateId());//模板编号
        result.put("templateData", coupon.getTemplateData());//模板数据，保存的是json串，具体信息保存在mongodb中
        result.put("cTimeStamp", TimeUtils.convertDateToString(coupon.getCTimeStamp(), TimeUtils.FORMAT1));
        return result;
    }
}
