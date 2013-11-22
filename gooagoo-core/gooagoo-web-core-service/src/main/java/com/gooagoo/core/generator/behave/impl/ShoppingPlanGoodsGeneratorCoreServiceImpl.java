package com.gooagoo.core.generator.behave.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.behave.ShoppingPlanGoodsGeneratorCoreService;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoods;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoodsExample;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoodsKey;
import com.gooagoo.dao.generator.behave.ShoppingPlanGoodsMapper;

@Service
public class ShoppingPlanGoodsGeneratorCoreServiceImpl implements ShoppingPlanGoodsGeneratorCoreService
{

    @Autowired
    private ShoppingPlanGoodsMapper shoppingPlanGoodsMapper;

    @Override
    public Integer countByExample(ShoppingPlanGoodsExample shoppingPlanGoodsExample) 
    {
        return this.shoppingPlanGoodsMapper.countByExample(shoppingPlanGoodsExample);
    }

    @Override
    public List<ShoppingPlanGoods> selectByExample(ShoppingPlanGoodsExample shoppingPlanGoodsExample) 
    {
        return this.shoppingPlanGoodsMapper.selectByExample(shoppingPlanGoodsExample);
    }

    @Override
    public ShoppingPlanGoods selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShoppingPlanGoodsKey shoppingPlanGoodsKey = new ShoppingPlanGoodsKey();
        shoppingPlanGoodsKey.setIsDel("N");
        shoppingPlanGoodsKey.setShoppingGoodsId(primaryKey);
        return this.shoppingPlanGoodsMapper.selectByPrimaryKey(shoppingPlanGoodsKey);
    }

    @Override
    public ShoppingPlanGoods selectByPrimaryKey(String primaryKey) 
    {
        ShoppingPlanGoodsKey shoppingPlanGoodsKey = new ShoppingPlanGoodsKey();
        shoppingPlanGoodsKey.setShoppingGoodsId(primaryKey);
        return this.shoppingPlanGoodsMapper.selectByPrimaryKey(shoppingPlanGoodsKey);
    }

    @Override
    public boolean physicalDeleteByExample(ShoppingPlanGoodsExample shoppingPlanGoodsExample) 
    {
        return this.shoppingPlanGoodsMapper.deleteByExample(shoppingPlanGoodsExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShoppingPlanGoodsKey shoppingPlanGoodsKey = new ShoppingPlanGoodsKey();
        shoppingPlanGoodsKey.setShoppingGoodsId(primaryKey);
        return this.shoppingPlanGoodsMapper.deleteByPrimaryKey(shoppingPlanGoodsKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShoppingPlanGoodsExample shoppingPlanGoodsExample) 
    {
        ShoppingPlanGoods shoppingPlanGoods = new ShoppingPlanGoods();
        shoppingPlanGoods.setIsDel("Y");
        return this.shoppingPlanGoodsMapper.updateByExampleSelective(shoppingPlanGoods,shoppingPlanGoodsExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShoppingPlanGoods shoppingPlanGoods = new ShoppingPlanGoods();
        shoppingPlanGoods.setShoppingGoodsId(primaryKey);
        shoppingPlanGoods.setIsDel("Y");
        return this.shoppingPlanGoodsMapper.updateByPrimaryKeySelective(shoppingPlanGoods) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShoppingPlanGoods shoppingPlanGoods) 
    {
        return this.shoppingPlanGoodsMapper.insertSelective(shoppingPlanGoods) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShoppingPlanGoods shoppingPlanGoods,ShoppingPlanGoodsExample shoppingPlanGoodsExample) 
    {
        return this.shoppingPlanGoodsMapper.updateByExampleSelective(shoppingPlanGoods,shoppingPlanGoodsExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShoppingPlanGoods shoppingPlanGoods) 
    {
        return this.shoppingPlanGoodsMapper.updateByPrimaryKeySelective(shoppingPlanGoods) > 0 ? true : false;
    }

}
