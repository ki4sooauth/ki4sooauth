package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopInfoExample;
import com.gooagoo.entity.generator.shop.ShopInfoKey;

public interface ShopInfoMapper
{

    public Integer countByExample(ShopInfoExample shopInfoExample);

    public List<ShopInfo> selectByExample(ShopInfoExample shopInfoExample);

    public ShopInfo selectByPrimaryKey(ShopInfoKey shopInfoKey);

}
