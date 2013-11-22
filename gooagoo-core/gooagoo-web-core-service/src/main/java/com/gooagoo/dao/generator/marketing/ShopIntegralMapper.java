package com.gooagoo.dao.generator.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.marketing.ShopIntegral;
import com.gooagoo.entity.generator.marketing.ShopIntegralExample;
import com.gooagoo.entity.generator.marketing.ShopIntegralKey;

public interface ShopIntegralMapper
{

    public Integer countByExample(ShopIntegralExample shopIntegralExample);

    public List<ShopIntegral> selectByExample(ShopIntegralExample shopIntegralExample);

    public ShopIntegral selectByPrimaryKey(ShopIntegralKey shopIntegralKey);

    public Integer deleteByExample(ShopIntegralExample shopIntegralExample);

    public Integer deleteByPrimaryKey(ShopIntegralKey shopIntegralKey);

    public Integer insertSelective(ShopIntegral shopIntegral);

    public Integer updateAllByExample(@Param("record") ShopIntegral shopIntegral, @Param("example") ShopIntegralExample shopIntegralExample);

    public Integer updateByExampleSelective(@Param("record") ShopIntegral shopIntegral, @Param("example") ShopIntegralExample shopIntegralExample);

    public Integer updateByPrimaryKeySelective(ShopIntegral shopIntegral);

}
