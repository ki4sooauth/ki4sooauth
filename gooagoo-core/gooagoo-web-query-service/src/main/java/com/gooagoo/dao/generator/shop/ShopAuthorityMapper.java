package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopAuthority;
import com.gooagoo.entity.generator.shop.ShopAuthorityExample;
import com.gooagoo.entity.generator.shop.ShopAuthorityKey;

public interface ShopAuthorityMapper
{

    public Integer countByExample(ShopAuthorityExample shopAuthorityExample);

    public List<ShopAuthority> selectByExample(ShopAuthorityExample shopAuthorityExample);

    public ShopAuthority selectByPrimaryKey(ShopAuthorityKey shopAuthorityKey);

}
