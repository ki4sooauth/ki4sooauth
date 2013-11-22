package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopAuthority;
import com.gooagoo.entity.generator.shop.ShopAuthorityExample;
import com.gooagoo.entity.generator.shop.ShopAuthorityKey;

public interface ShopAuthorityMapper
{

    public Integer countByExample(ShopAuthorityExample shopAuthorityExample);

    public List<ShopAuthority> selectByExample(ShopAuthorityExample shopAuthorityExample);

    public ShopAuthority selectByPrimaryKey(ShopAuthorityKey shopAuthorityKey);

    public Integer deleteByExample(ShopAuthorityExample shopAuthorityExample);

    public Integer deleteByPrimaryKey(ShopAuthorityKey shopAuthorityKey);

    public Integer insertSelective(ShopAuthority shopAuthority);

    public Integer updateAllByExample(@Param("record") ShopAuthority shopAuthority, @Param("example") ShopAuthorityExample shopAuthorityExample);

    public Integer updateByExampleSelective(@Param("record") ShopAuthority shopAuthority, @Param("example") ShopAuthorityExample shopAuthorityExample);

    public Integer updateByPrimaryKeySelective(ShopAuthority shopAuthority);

}
