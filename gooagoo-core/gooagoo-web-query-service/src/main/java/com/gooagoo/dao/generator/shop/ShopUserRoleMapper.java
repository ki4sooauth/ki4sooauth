package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopUserRole;
import com.gooagoo.entity.generator.shop.ShopUserRoleExample;
import com.gooagoo.entity.generator.shop.ShopUserRoleKey;

public interface ShopUserRoleMapper
{

    public Integer countByExample(ShopUserRoleExample shopUserRoleExample);

    public List<ShopUserRole> selectByExample(ShopUserRoleExample shopUserRoleExample);

    public ShopUserRole selectByPrimaryKey(ShopUserRoleKey shopUserRoleKey);

}
