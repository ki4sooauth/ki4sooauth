package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopRole2;
import com.gooagoo.entity.generator.shop.ShopRole2Example;
import com.gooagoo.entity.generator.shop.ShopRole2Key;

public interface ShopRole2Mapper
{

    public Integer countByExample(ShopRole2Example shopRole2Example);

    public List<ShopRole2> selectByExample(ShopRole2Example shopRole2Example);

    public ShopRole2 selectByPrimaryKey(ShopRole2Key shopRole2Key);

    public Integer deleteByExample(ShopRole2Example shopRole2Example);

    public Integer deleteByPrimaryKey(ShopRole2Key shopRole2Key);

    public Integer insertSelective(ShopRole2 shopRole2);

    public Integer updateAllByExample(@Param("record") ShopRole2 shopRole2, @Param("example") ShopRole2Example shopRole2Example);

    public Integer updateByExampleSelective(@Param("record") ShopRole2 shopRole2, @Param("example") ShopRole2Example shopRole2Example);

    public Integer updateByPrimaryKeySelective(ShopRole2 shopRole2);

}
