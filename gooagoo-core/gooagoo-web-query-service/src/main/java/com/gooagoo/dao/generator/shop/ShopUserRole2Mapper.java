package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopUserRole2;
import com.gooagoo.entity.generator.shop.ShopUserRole2Example;
import com.gooagoo.entity.generator.shop.ShopUserRole2Key;

public interface ShopUserRole2Mapper
{

    public Integer countByExample(ShopUserRole2Example shopUserRole2Example);

    public List<ShopUserRole2> selectByExample(ShopUserRole2Example shopUserRole2Example);

    public ShopUserRole2 selectByPrimaryKey(ShopUserRole2Key shopUserRole2Key);

}
