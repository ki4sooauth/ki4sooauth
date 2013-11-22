package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfoExample;
import com.gooagoo.entity.generator.shop.ShopEntityInfoKey;

public interface ShopEntityInfoMapper
{

    public Integer countByExample(ShopEntityInfoExample shopEntityInfoExample);

    public List<ShopEntityInfo> selectByExample(ShopEntityInfoExample shopEntityInfoExample);

    public ShopEntityInfo selectByPrimaryKey(ShopEntityInfoKey shopEntityInfoKey);

}
