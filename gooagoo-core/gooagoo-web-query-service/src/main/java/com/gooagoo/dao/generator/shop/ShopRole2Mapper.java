package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopRole2;
import com.gooagoo.entity.generator.shop.ShopRole2Example;
import com.gooagoo.entity.generator.shop.ShopRole2Key;

public interface ShopRole2Mapper
{

    public Integer countByExample(ShopRole2Example shopRole2Example);

    public List<ShopRole2> selectByExample(ShopRole2Example shopRole2Example);

    public ShopRole2 selectByPrimaryKey(ShopRole2Key shopRole2Key);

}
