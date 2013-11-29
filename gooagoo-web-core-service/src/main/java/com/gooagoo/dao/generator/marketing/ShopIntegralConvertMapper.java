package com.gooagoo.dao.generator.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.marketing.ShopIntegralConvert;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvertExample;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvertKey;

public interface ShopIntegralConvertMapper
{

    public Integer countByExample(ShopIntegralConvertExample shopIntegralConvertExample);

    public List<ShopIntegralConvert> selectByExample(ShopIntegralConvertExample shopIntegralConvertExample);

    public ShopIntegralConvert selectByPrimaryKey(ShopIntegralConvertKey shopIntegralConvertKey);

    public Integer deleteByExample(ShopIntegralConvertExample shopIntegralConvertExample);

    public Integer deleteByPrimaryKey(ShopIntegralConvertKey shopIntegralConvertKey);

    public Integer insertSelective(ShopIntegralConvert shopIntegralConvert);

    public Integer updateAllByExample(@Param("record") ShopIntegralConvert shopIntegralConvert, @Param("example") ShopIntegralConvertExample shopIntegralConvertExample);

    public Integer updateByExampleSelective(@Param("record") ShopIntegralConvert shopIntegralConvert, @Param("example") ShopIntegralConvertExample shopIntegralConvertExample);

    public Integer updateByPrimaryKeySelective(ShopIntegralConvert shopIntegralConvert);

}
