package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopUserRole2;
import com.gooagoo.entity.generator.shop.ShopUserRole2Example;
import com.gooagoo.entity.generator.shop.ShopUserRole2Key;

public interface ShopUserRole2Mapper
{

    public Integer countByExample(ShopUserRole2Example shopUserRole2Example);

    public List<ShopUserRole2> selectByExample(ShopUserRole2Example shopUserRole2Example);

    public ShopUserRole2 selectByPrimaryKey(ShopUserRole2Key shopUserRole2Key);

    public Integer deleteByExample(ShopUserRole2Example shopUserRole2Example);

    public Integer deleteByPrimaryKey(ShopUserRole2Key shopUserRole2Key);

    public Integer insertSelective(ShopUserRole2 shopUserRole2);

    public Integer updateAllByExample(@Param("record") ShopUserRole2 shopUserRole2, @Param("example") ShopUserRole2Example shopUserRole2Example);

    public Integer updateByExampleSelective(@Param("record") ShopUserRole2 shopUserRole2, @Param("example") ShopUserRole2Example shopUserRole2Example);

    public Integer updateByPrimaryKeySelective(ShopUserRole2 shopUserRole2);

}
