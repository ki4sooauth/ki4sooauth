package com.gooagoo.dao.generator.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.base.ShoppingListGoodsType;
import com.gooagoo.entity.generator.base.ShoppingListGoodsTypeExample;
import com.gooagoo.entity.generator.base.ShoppingListGoodsTypeKey;

public interface ShoppingListGoodsTypeMapper
{

    public Integer countByExample(ShoppingListGoodsTypeExample shoppingListGoodsTypeExample);

    public List<ShoppingListGoodsType> selectByExample(ShoppingListGoodsTypeExample shoppingListGoodsTypeExample);

    public ShoppingListGoodsType selectByPrimaryKey(ShoppingListGoodsTypeKey shoppingListGoodsTypeKey);

    public Integer deleteByExample(ShoppingListGoodsTypeExample shoppingListGoodsTypeExample);

    public Integer deleteByPrimaryKey(ShoppingListGoodsTypeKey shoppingListGoodsTypeKey);

    public Integer insertSelective(ShoppingListGoodsType shoppingListGoodsType);

    public Integer updateAllByExample(@Param("record") ShoppingListGoodsType shoppingListGoodsType, @Param("example") ShoppingListGoodsTypeExample shoppingListGoodsTypeExample);

    public Integer updateByExampleSelective(@Param("record") ShoppingListGoodsType shoppingListGoodsType, @Param("example") ShoppingListGoodsTypeExample shoppingListGoodsTypeExample);

    public Integer updateByPrimaryKeySelective(ShoppingListGoodsType shoppingListGoodsType);

}
