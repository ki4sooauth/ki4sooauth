package com.gooagoo.dao.generator.base;

import java.util.List;

import com.gooagoo.entity.generator.base.ShopType;
import com.gooagoo.entity.generator.base.ShopTypeExample;
import com.gooagoo.entity.generator.base.ShopTypeKey;

public interface ShopTypeMapper
{

    public Integer countByExample(ShopTypeExample shopTypeExample);

    public List<ShopType> selectByExample(ShopTypeExample shopTypeExample);

    public ShopType selectByPrimaryKey(ShopTypeKey shopTypeKey);

}
