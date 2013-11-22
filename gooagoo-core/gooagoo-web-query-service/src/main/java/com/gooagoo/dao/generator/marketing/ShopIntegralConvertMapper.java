package com.gooagoo.dao.generator.marketing;

import java.util.List;

import com.gooagoo.entity.generator.marketing.ShopIntegralConvert;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvertExample;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvertKey;

public interface ShopIntegralConvertMapper
{

    public Integer countByExample(ShopIntegralConvertExample shopIntegralConvertExample);

    public List<ShopIntegralConvert> selectByExample(ShopIntegralConvertExample shopIntegralConvertExample);

    public ShopIntegralConvert selectByPrimaryKey(ShopIntegralConvertKey shopIntegralConvertKey);

}
