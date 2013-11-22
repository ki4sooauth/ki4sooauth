package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.entity.generator.shop.ShopPositionExample;
import com.gooagoo.entity.generator.shop.ShopPositionKey;

public interface ShopPositionMapper
{

    public Integer countByExample(ShopPositionExample shopPositionExample);

    public List<ShopPosition> selectByExample(ShopPositionExample shopPositionExample);

    public ShopPosition selectByPrimaryKey(ShopPositionKey shopPositionKey);

    public Integer deleteByExample(ShopPositionExample shopPositionExample);

    public Integer deleteByPrimaryKey(ShopPositionKey shopPositionKey);

    public Integer insertSelective(ShopPosition shopPosition);

    public Integer updateAllByExample(@Param("record") ShopPosition shopPosition, @Param("example") ShopPositionExample shopPositionExample);

    public Integer updateByExampleSelective(@Param("record") ShopPosition shopPosition, @Param("example") ShopPositionExample shopPositionExample);

    public Integer updateByPrimaryKeySelective(ShopPosition shopPosition);

}
