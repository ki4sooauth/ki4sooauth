package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopRole;
import com.gooagoo.entity.generator.shop.ShopRoleExample;
import com.gooagoo.entity.generator.shop.ShopRoleKey;

public interface ShopRoleMapper
{

    public Integer countByExample(ShopRoleExample shopRoleExample);

    public List<ShopRole> selectByExample(ShopRoleExample shopRoleExample);

    public ShopRole selectByPrimaryKey(ShopRoleKey shopRoleKey);

    public Integer deleteByExample(ShopRoleExample shopRoleExample);

    public Integer deleteByPrimaryKey(ShopRoleKey shopRoleKey);

    public Integer insertSelective(ShopRole shopRole);

    public Integer updateAllByExample(@Param("record") ShopRole shopRole, @Param("example") ShopRoleExample shopRoleExample);

    public Integer updateByExampleSelective(@Param("record") ShopRole shopRole, @Param("example") ShopRoleExample shopRoleExample);

    public Integer updateByPrimaryKeySelective(ShopRole shopRole);

}
