package com.gooagoo.dao.generator.marketing;

import java.util.List;

import com.gooagoo.entity.generator.marketing.CouponGrantInfo;
import com.gooagoo.entity.generator.marketing.CouponGrantInfoExample;
import com.gooagoo.entity.generator.marketing.CouponGrantInfoKey;

public interface CouponGrantInfoMapper
{

    public Integer countByExample(CouponGrantInfoExample couponGrantInfoExample);

    public List<CouponGrantInfo> selectByExample(CouponGrantInfoExample couponGrantInfoExample);

    public CouponGrantInfo selectByPrimaryKey(CouponGrantInfoKey couponGrantInfoKey);

}
