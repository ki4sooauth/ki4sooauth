package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopToolList;
import com.gooagoo.entity.generator.shop.ShopToolListExample;
import com.gooagoo.entity.generator.shop.ShopToolListKey;

public interface ShopToolListMapper
{

    public Integer countByExample(ShopToolListExample shopToolListExample);

    public List<ShopToolList> selectByExample(ShopToolListExample shopToolListExample);

    public ShopToolList selectByPrimaryKey(ShopToolListKey shopToolListKey);

}
