package com.gooagoo.dao.generator.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.marketing.CouponGrantInfo;
import com.gooagoo.entity.generator.marketing.CouponGrantInfoExample;
import com.gooagoo.entity.generator.marketing.CouponGrantInfoKey;

public interface CouponGrantInfoMapper
{

    public Integer countByExample(CouponGrantInfoExample couponGrantInfoExample);

    public List<CouponGrantInfo> selectByExample(CouponGrantInfoExample couponGrantInfoExample);

    public CouponGrantInfo selectByPrimaryKey(CouponGrantInfoKey couponGrantInfoKey);

    public Integer deleteByExample(CouponGrantInfoExample couponGrantInfoExample);

    public Integer deleteByPrimaryKey(CouponGrantInfoKey couponGrantInfoKey);

    public Integer insertSelective(CouponGrantInfo couponGrantInfo);

    public Integer updateAllByExample(@Param("record") CouponGrantInfo couponGrantInfo, @Param("example") CouponGrantInfoExample couponGrantInfoExample);

    public Integer updateByExampleSelective(@Param("record") CouponGrantInfo couponGrantInfo, @Param("example") CouponGrantInfoExample couponGrantInfoExample);

    public Integer updateByPrimaryKeySelective(CouponGrantInfo couponGrantInfo);

}
