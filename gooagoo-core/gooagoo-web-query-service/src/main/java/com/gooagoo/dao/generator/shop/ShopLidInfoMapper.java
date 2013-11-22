package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopLidInfo;
import com.gooagoo.entity.generator.shop.ShopLidInfoExample;
import com.gooagoo.entity.generator.shop.ShopLidInfoKey;

public interface ShopLidInfoMapper
{

    public Integer countByExample(ShopLidInfoExample shopLidInfoExample);

    public List<ShopLidInfo> selectByExample(ShopLidInfoExample shopLidInfoExample);

    public ShopLidInfo selectByPrimaryKey(ShopLidInfoKey shopLidInfoKey);

}
