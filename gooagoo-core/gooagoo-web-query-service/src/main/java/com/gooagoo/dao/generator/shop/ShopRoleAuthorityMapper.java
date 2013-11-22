package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopRoleAuthority;
import com.gooagoo.entity.generator.shop.ShopRoleAuthorityExample;
import com.gooagoo.entity.generator.shop.ShopRoleAuthorityKey;

public interface ShopRoleAuthorityMapper
{

    public Integer countByExample(ShopRoleAuthorityExample shopRoleAuthorityExample);

    public List<ShopRoleAuthority> selectByExample(ShopRoleAuthorityExample shopRoleAuthorityExample);

    public ShopRoleAuthority selectByPrimaryKey(ShopRoleAuthorityKey shopRoleAuthorityKey);

}
