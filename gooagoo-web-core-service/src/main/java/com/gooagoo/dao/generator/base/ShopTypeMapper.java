package com.gooagoo.dao.generator.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.base.ShopType;
import com.gooagoo.entity.generator.base.ShopTypeExample;
import com.gooagoo.entity.generator.base.ShopTypeKey;

public interface ShopTypeMapper
{

    public Integer countByExample(ShopTypeExample shopTypeExample);

    public List<ShopType> selectByExample(ShopTypeExample shopTypeExample);

    public ShopType selectByPrimaryKey(ShopTypeKey shopTypeKey);

    public Integer deleteByExample(ShopTypeExample shopTypeExample);

    public Integer deleteByPrimaryKey(ShopTypeKey shopTypeKey);

    public Integer insertSelective(ShopType shopType);

    public Integer updateAllByExample(@Param("record") ShopType shopType, @Param("example") ShopTypeExample shopTypeExample);

    public Integer updateByExampleSelective(@Param("record") ShopType shopType, @Param("example") ShopTypeExample shopTypeExample);

    public Integer updateByPrimaryKeySelective(ShopType shopType);

}
