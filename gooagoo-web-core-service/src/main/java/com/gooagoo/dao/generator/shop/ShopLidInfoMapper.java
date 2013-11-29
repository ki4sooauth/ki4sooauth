package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopLidInfo;
import com.gooagoo.entity.generator.shop.ShopLidInfoExample;
import com.gooagoo.entity.generator.shop.ShopLidInfoKey;

public interface ShopLidInfoMapper
{

    public Integer countByExample(ShopLidInfoExample shopLidInfoExample);

    public List<ShopLidInfo> selectByExample(ShopLidInfoExample shopLidInfoExample);

    public ShopLidInfo selectByPrimaryKey(ShopLidInfoKey shopLidInfoKey);

    public Integer deleteByExample(ShopLidInfoExample shopLidInfoExample);

    public Integer deleteByPrimaryKey(ShopLidInfoKey shopLidInfoKey);

    public Integer insertSelective(ShopLidInfo shopLidInfo);

    public Integer updateAllByExample(@Param("record") ShopLidInfo shopLidInfo, @Param("example") ShopLidInfoExample shopLidInfoExample);

    public Integer updateByExampleSelective(@Param("record") ShopLidInfo shopLidInfo, @Param("example") ShopLidInfoExample shopLidInfoExample);

    public Integer updateByPrimaryKeySelective(ShopLidInfo shopLidInfo);

}
