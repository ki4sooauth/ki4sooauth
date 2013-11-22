package com.gooagoo.dao.generator.marketing;

import java.util.List;

import com.gooagoo.entity.generator.marketing.ShopIntegral;
import com.gooagoo.entity.generator.marketing.ShopIntegralExample;
import com.gooagoo.entity.generator.marketing.ShopIntegralKey;

public interface ShopIntegralMapper
{

    public Integer countByExample(ShopIntegralExample shopIntegralExample);

    public List<ShopIntegral> selectByExample(ShopIntegralExample shopIntegralExample);

    public ShopIntegral selectByPrimaryKey(ShopIntegralKey shopIntegralKey);

}
