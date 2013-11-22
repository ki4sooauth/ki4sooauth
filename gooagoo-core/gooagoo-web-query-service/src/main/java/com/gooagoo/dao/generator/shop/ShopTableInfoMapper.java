package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopTableInfo;
import com.gooagoo.entity.generator.shop.ShopTableInfoExample;
import com.gooagoo.entity.generator.shop.ShopTableInfoKey;

public interface ShopTableInfoMapper
{

    public Integer countByExample(ShopTableInfoExample shopTableInfoExample);

    public List<ShopTableInfo> selectByExample(ShopTableInfoExample shopTableInfoExample);

    public ShopTableInfo selectByPrimaryKey(ShopTableInfoKey shopTableInfoKey);

}
