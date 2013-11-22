package com.gooagoo.core.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.base.ShoppingListGoodsTypeGeneratorCoreService;
import com.gooagoo.entity.generator.base.ShoppingListGoodsType;
import com.gooagoo.entity.generator.base.ShoppingListGoodsTypeExample;
import com.gooagoo.entity.generator.base.ShoppingListGoodsTypeKey;
import com.gooagoo.dao.generator.base.ShoppingListGoodsTypeMapper;

@Service
public class ShoppingListGoodsTypeGeneratorCoreServiceImpl implements ShoppingListGoodsTypeGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ShoppingListGoodsTypeExample shoppingListGoodsTypeExample) 
    {
        return this.shoppingListGoodsTypeMapper.deleteByExample(shoppingListGoodsTypeExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(Integer primaryKey) 
    {
        ShoppingListGoodsTypeKey shoppingListGoodsTypeKey = new ShoppingListGoodsTypeKey();
        shoppingListGoodsTypeKey.setGoodsTypeId(primaryKey);
        return this.shoppingListGoodsTypeMapper.deleteByPrimaryKey(shoppingListGoodsTypeKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShoppingListGoodsTypeExample shoppingListGoodsTypeExample) 
    {
        ShoppingListGoodsType shoppingListGoodsType = new ShoppingListGoodsType();
        shoppingListGoodsType.setIsDel("Y");
        return this.shoppingListGoodsTypeMapper.updateByExampleSelective(shoppingListGoodsType,shoppingListGoodsTypeExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(Integer primaryKey) 
    {
        ShoppingListGoodsType shoppingListGoodsType = new ShoppingListGoodsType();
        shoppingListGoodsType.setGoodsTypeId(primaryKey);
        shoppingListGoodsType.setIsDel("Y");
        return this.shoppingListGoodsTypeMapper.updateByPrimaryKeySelective(shoppingListGoodsType) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShoppingListGoodsType shoppingListGoodsType) 
    {
        return this.shoppingListGoodsTypeMapper.insertSelective(shoppingListGoodsType) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShoppingListGoodsType shoppingListGoodsType,ShoppingListGoodsTypeExample shoppingListGoodsTypeExample) 
    {
        return this.shoppingListGoodsTypeMapper.updateByExampleSelective(shoppingListGoodsType,shoppingListGoodsTypeExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShoppingListGoodsType shoppingListGoodsType) 
    {
        return this.shoppingListGoodsTypeMapper.updateByPrimaryKeySelective(shoppingListGoodsType) > 0 ? true : false;
    }

}
