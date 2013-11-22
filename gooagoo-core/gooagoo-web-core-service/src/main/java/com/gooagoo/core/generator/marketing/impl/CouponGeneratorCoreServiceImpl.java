package com.gooagoo.core.generator.marketing.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.core.marketing.CouponGeneratorCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.marketing.CouponMapper;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.CouponExample;
import com.gooagoo.entity.generator.marketing.CouponKey;
import com.gooagoo.redis.data.RedisDatabase;

@Service
public class CouponGeneratorCoreServiceImpl implements CouponGeneratorCoreService
{

    @Autowired
    private CouponMapper couponMapper;

    @Override
    public Integer countByExample(CouponExample couponExample)
    {
        return this.couponMapper.countByExample(couponExample);
    }

    @Override
    public List<Coupon> selectByExample(CouponExample couponExample)
    {
        return this.couponMapper.selectByExample(couponExample);
    }

    @Override
    public Coupon selectUnDelByPrimaryKey(String primaryKey)
    {
        CouponKey couponKey = new CouponKey();
        couponKey.setIsDel("N");
        couponKey.setCouponId(primaryKey);
        return this.couponMapper.selectByPrimaryKey(couponKey);
    }

    @Override
    public Coupon selectByPrimaryKey(String primaryKey)
    {
        CouponKey couponKey = new CouponKey();
        couponKey.setCouponId(primaryKey);
        return this.couponMapper.selectByPrimaryKey(couponKey);
    }

    @Override
    public boolean physicalDeleteByExample(CouponExample couponExample)
    {
        List<Coupon> list = this.couponMapper.selectByExample(couponExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.couponMapper.deleteByExample(couponExample) != list.size())
        {
            return false;
        }
        for (Coupon item : list)
        {
            this.clearRedis(item.getCouponId());
        }
        return true;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey)
    {
        CouponKey couponKey = new CouponKey();
        couponKey.setCouponId(primaryKey);
        if (this.couponMapper.deleteByPrimaryKey(couponKey) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean deleteByExample(CouponExample couponExample)
    {
        List<Coupon> list = this.couponMapper.selectByExample(couponExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        Coupon coupon = new Coupon();
        coupon.setIsDel("Y");
        if (this.couponMapper.updateByExampleSelective(coupon, couponExample) != list.size())
        {
            return false;
        }
        for (Coupon item : list)
        {
            this.clearRedis(item.getCouponId());
        }
        return true;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey)
    {
        Coupon coupon = new Coupon();
        coupon.setCouponId(primaryKey);
        coupon.setIsDel("Y");
        if (this.couponMapper.updateByPrimaryKeySelective(coupon) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean insertSelective(Coupon coupon)
    {
        return this.couponMapper.insertSelective(coupon) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(Coupon coupon, CouponExample couponExample)
    {
        List<Coupon> list = this.couponMapper.selectByExample(couponExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.couponMapper.updateByExampleSelective(coupon, couponExample) != list.size())
        {
            return false;
        }
        for (Coupon item : list)
        {
            this.clearRedis(item.getCouponId());
        }
        return true;
    }

    @Override
    public boolean updateByPrimaryKeySelective(Coupon coupon)
    {
        if (this.couponMapper.updateByPrimaryKeySelective(coupon) != 1)
        {
            return false;
        }
        this.clearRedis(coupon.getCouponId());
        return true;
    }

    /**
     * 清空品类redis缓存
     * @param couponId 优惠凭证编号
     */
    private void clearRedis(String couponId)
    {
        if (StringUtils.hasText(couponId))
        {
            RedisDatabase base = new RedisDatabase(RedisServerConstants.business_coupon);
            base.del(couponId);
        }
    }

}
