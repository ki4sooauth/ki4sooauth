package com.gooagoo.dao.generator.base;

import java.util.List;

import com.gooagoo.entity.generator.base.ShoppingListGoodsType;
import com.gooagoo.entity.generator.base.ShoppingListGoodsTypeExample;
import com.gooagoo.entity.generator.base.ShoppingListGoodsTypeKey;

public interface ShoppingListGoodsTypeMapper
{

    public Integer countByExample(ShoppingListGoodsTypeExample shoppingListGoodsTypeExample);

    public List<ShoppingListGoodsType> selectByExample(ShoppingListGoodsTypeExample shoppingListGoodsTypeExample);

    public ShoppingListGoodsType selectByPrimaryKey(ShoppingListGoodsTypeKey shoppingListGoodsTypeKey);

}
