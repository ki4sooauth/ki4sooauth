package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopRoleAuthority;
import com.gooagoo.entity.generator.shop.ShopRoleAuthorityExample;
import com.gooagoo.entity.generator.shop.ShopRoleAuthorityKey;

public interface ShopRoleAuthorityMapper
{

    public Integer countByExample(ShopRoleAuthorityExample shopRoleAuthorityExample);

    public List<ShopRoleAuthority> selectByExample(ShopRoleAuthorityExample shopRoleAuthorityExample);

    public ShopRoleAuthority selectByPrimaryKey(ShopRoleAuthorityKey shopRoleAuthorityKey);

    public Integer deleteByExample(ShopRoleAuthorityExample shopRoleAuthorityExample);

    public Integer deleteByPrimaryKey(ShopRoleAuthorityKey shopRoleAuthorityKey);

    public Integer insertSelective(ShopRoleAuthority shopRoleAuthority);

    public Integer updateAllByExample(@Param("record") ShopRoleAuthority shopRoleAuthority, @Param("example") ShopRoleAuthorityExample shopRoleAuthorityExample);

    public Integer updateByExampleSelective(@Param("record") ShopRoleAuthority shopRoleAuthority, @Param("example") ShopRoleAuthorityExample shopRoleAuthorityExample);

    public Integer updateByPrimaryKeySelective(ShopRoleAuthority shopRoleAuthority);

}
