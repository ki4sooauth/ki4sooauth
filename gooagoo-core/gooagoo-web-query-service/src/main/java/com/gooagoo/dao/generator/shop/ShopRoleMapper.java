package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopRole;
import com.gooagoo.entity.generator.shop.ShopRoleExample;
import com.gooagoo.entity.generator.shop.ShopRoleKey;

public interface ShopRoleMapper
{

    public Integer countByExample(ShopRoleExample shopRoleExample);

    public List<ShopRole> selectByExample(ShopRoleExample shopRoleExample);

    public ShopRole selectByPrimaryKey(ShopRoleKey shopRoleKey);

}
