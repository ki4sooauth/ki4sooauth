package com.gooagoo.query.generator.behave.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.behave.ShoppingPlanGoodsGeneratorQueryService;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoods;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoodsExample;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoodsKey;
import com.gooagoo.dao.generator.behave.ShoppingPlanGoodsMapper;

@Service
public class ShoppingPlanGoodsGeneratorQueryServiceImpl implements ShoppingPlanGoodsGeneratorQueryService
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

}
