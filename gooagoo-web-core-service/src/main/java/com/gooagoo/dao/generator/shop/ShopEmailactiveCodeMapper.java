package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopEmailactiveCode;
import com.gooagoo.entity.generator.shop.ShopEmailactiveCodeExample;
import com.gooagoo.entity.generator.shop.ShopEmailactiveCodeKey;

public interface ShopEmailactiveCodeMapper
{

    public Integer countByExample(ShopEmailactiveCodeExample shopEmailactiveCodeExample);

    public List<ShopEmailactiveCode> selectByExample(ShopEmailactiveCodeExample shopEmailactiveCodeExample);

    public ShopEmailactiveCode selectByPrimaryKey(ShopEmailactiveCodeKey shopEmailactiveCodeKey);

    public Integer deleteByExample(ShopEmailactiveCodeExample shopEmailactiveCodeExample);

    public Integer deleteByPrimaryKey(ShopEmailactiveCodeKey shopEmailactiveCodeKey);

    public Integer insertSelective(ShopEmailactiveCode shopEmailactiveCode);

    public Integer updateAllByExample(@Param("record") ShopEmailactiveCode shopEmailactiveCode, @Param("example") ShopEmailactiveCodeExample shopEmailactiveCodeExample);

    public Integer updateByExampleSelective(@Param("record") ShopEmailactiveCode shopEmailactiveCode, @Param("example") ShopEmailactiveCodeExample shopEmailactiveCodeExample);

    public Integer updateByPrimaryKeySelective(ShopEmailactiveCode shopEmailactiveCode);

}
