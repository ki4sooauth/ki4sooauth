package com.gooagoo.query.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.base.ShoppingListGoodsTypeGeneratorQueryService;
import com.gooagoo.entity.generator.base.ShoppingListGoodsType;
import com.gooagoo.entity.generator.base.ShoppingListGoodsTypeExample;
import com.gooagoo.entity.generator.base.ShoppingListGoodsTypeKey;
import com.gooagoo.dao.generator.base.ShoppingListGoodsTypeMapper;

@Service
public class ShoppingListGoodsTypeGeneratorQueryServiceImpl implements ShoppingListGoodsTypeGeneratorQueryService
{

    @Autowired
    private ShoppingListGoodsTypeMapper shoppingListGoodsTypeMapper;

    @Override
    public Integer countByExample(ShoppingListGoodsTypeExample shoppingListGoodsTypeExample) 
    {
        return this.shoppingListGoodsTypeMapper.countByExample(shoppingListGoodsTypeExample);
    }

    @Override
    public List<ShoppingListGoodsType> selectByExample(ShoppingListGoodsTypeExample shoppingListGoodsTypeExample) 
    {
        return this.shoppingListGoodsTypeMapper.selectByExample(shoppingListGoodsTypeExample);
    }

    @Override
    public ShoppingListGoodsType selectUnDelByPrimaryKey(Integer primaryKey) 
    {
        ShoppingListGoodsTypeKey shoppingListGoodsTypeKey = new ShoppingListGoodsTypeKey();
        shoppingListGoodsTypeKey.setIsDel("N");
        shoppingListGoodsTypeKey.setGoodsTypeId(primaryKey);
        return this.shoppingListGoodsTypeMapper.selectByPrimaryKey(shoppingListGoodsTypeKey);
    }

    @Override
    public ShoppingListGoodsType selectByPrimaryKey(Integer primaryKey) 
    {
        ShoppingListGoodsTypeKey shoppingListGoodsTypeKey = new ShoppingListGoodsTypeKey();
        shoppingListGoodsTypeKey.setGoodsTypeId(primaryKey);
        return this.shoppingListGoodsTypeMapper.selectByPrimaryKey(shoppingListGoodsTypeKey);
    }

}
