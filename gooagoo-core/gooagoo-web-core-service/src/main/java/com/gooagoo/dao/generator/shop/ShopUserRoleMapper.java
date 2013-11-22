package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopUserRole;
import com.gooagoo.entity.generator.shop.ShopUserRoleExample;
import com.gooagoo.entity.generator.shop.ShopUserRoleKey;

public interface ShopUserRoleMapper
{

    public Integer countByExample(ShopUserRoleExample shopUserRoleExample);

    public List<ShopUserRole> selectByExample(ShopUserRoleExample shopUserRoleExample);

    public ShopUserRole selectByPrimaryKey(ShopUserRoleKey shopUserRoleKey);

    public Integer deleteByExample(ShopUserRoleExample shopUserRoleExample);

    public Integer deleteByPrimaryKey(ShopUserRoleKey shopUserRoleKey);

    public Integer insertSelective(ShopUserRole shopUserRole);

    public Integer updateAllByExample(@Param("record") ShopUserRole shopUserRole, @Param("example") ShopUserRoleExample shopUserRoleExample);

    public Integer updateByExampleSelective(@Param("record") ShopUserRole shopUserRole, @Param("example") ShopUserRoleExample shopUserRoleExample);

    public Integer updateByPrimaryKeySelective(ShopUserRole shopUserRole);

}
