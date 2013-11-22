package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopGpsInfo;
import com.gooagoo.entity.generator.shop.ShopGpsInfoExample;
import com.gooagoo.entity.generator.shop.ShopGpsInfoKey;

public interface ShopGpsInfoMapper
{

    public Integer countByExample(ShopGpsInfoExample shopGpsInfoExample);

    public List<ShopGpsInfo> selectByExample(ShopGpsInfoExample shopGpsInfoExample);

    public ShopGpsInfo selectByPrimaryKey(ShopGpsInfoKey shopGpsInfoKey);

}
