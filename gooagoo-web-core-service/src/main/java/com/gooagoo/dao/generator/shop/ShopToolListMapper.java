package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopToolList;
import com.gooagoo.entity.generator.shop.ShopToolListExample;
import com.gooagoo.entity.generator.shop.ShopToolListKey;

public interface ShopToolListMapper
{

    public Integer countByExample(ShopToolListExample shopToolListExample);

    public List<ShopToolList> selectByExample(ShopToolListExample shopToolListExample);

    public ShopToolList selectByPrimaryKey(ShopToolListKey shopToolListKey);

    public Integer deleteByExample(ShopToolListExample shopToolListExample);

    public Integer deleteByPrimaryKey(ShopToolListKey shopToolListKey);

    public Integer insertSelective(ShopToolList shopToolList);

    public Integer updateAllByExample(@Param("record") ShopToolList shopToolList, @Param("example") ShopToolListExample shopToolListExample);

    public Integer updateByExampleSelective(@Param("record") ShopToolList shopToolList, @Param("example") ShopToolListExample shopToolListExample);

    public Integer updateByPrimaryKeySelective(ShopToolList shopToolList);

}
