package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.entity.generator.shop.ShopPositionExample;
import com.gooagoo.entity.generator.shop.ShopPositionKey;

public interface ShopPositionMapper
{

    public Integer countByExample(ShopPositionExample shopPositionExample);

    public List<ShopPosition> selectByExample(ShopPositionExample shopPositionExample);

    public ShopPosition selectByPrimaryKey(ShopPositionKey shopPositionKey);

}
