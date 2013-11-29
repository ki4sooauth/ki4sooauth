package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfoExample;
import com.gooagoo.entity.generator.shop.ShopEntityInfoKey;

public interface ShopEntityInfoMapper
{

    public Integer countByExample(ShopEntityInfoExample shopEntityInfoExample);

    public List<ShopEntityInfo> selectByExample(ShopEntityInfoExample shopEntityInfoExample);

    public ShopEntityInfo selectByPrimaryKey(ShopEntityInfoKey shopEntityInfoKey);

    public Integer deleteByExample(ShopEntityInfoExample shopEntityInfoExample);

    public Integer deleteByPrimaryKey(ShopEntityInfoKey shopEntityInfoKey);

    public Integer insertSelective(ShopEntityInfo shopEntityInfo);

    public Integer updateAllByExample(@Param("record") ShopEntityInfo shopEntityInfo, @Param("example") ShopEntityInfoExample shopEntityInfoExample);

    public Integer updateByExampleSelective(@Param("record") ShopEntityInfo shopEntityInfo, @Param("example") ShopEntityInfoExample shopEntityInfoExample);

    public Integer updateByPrimaryKeySelective(ShopEntityInfo shopEntityInfo);

}
