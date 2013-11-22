package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopEmailactiveCode;
import com.gooagoo.entity.generator.shop.ShopEmailactiveCodeExample;
import com.gooagoo.entity.generator.shop.ShopEmailactiveCodeKey;

public interface ShopEmailactiveCodeMapper
{

    public Integer countByExample(ShopEmailactiveCodeExample shopEmailactiveCodeExample);

    public List<ShopEmailactiveCode> selectByExample(ShopEmailactiveCodeExample shopEmailactiveCodeExample);

    public ShopEmailactiveCode selectByPrimaryKey(ShopEmailactiveCodeKey shopEmailactiveCodeKey);

}
