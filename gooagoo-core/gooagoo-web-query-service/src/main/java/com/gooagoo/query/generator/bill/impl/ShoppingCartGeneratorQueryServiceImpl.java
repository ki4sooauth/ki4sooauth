package com.gooagoo.query.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.ShoppingCartGeneratorQueryService;
import com.gooagoo.entity.generator.bill.ShoppingCart;
import com.gooagoo.entity.generator.bill.ShoppingCartExample;
import com.gooagoo.entity.generator.bill.ShoppingCartKey;
import com.gooagoo.dao.generator.bill.ShoppingCartMapper;

@Service
public class ShoppingCartGeneratorQueryServiceImpl implements ShoppingCartGeneratorQueryService
{

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public Integer countByExample(ShoppingCartExample shoppingCartExample) 
    {
        return this.shoppingCartMapper.countByExample(shoppingCartExample);
    }

    @Override
    public List<ShoppingCart> selectByExample(ShoppingCartExample shoppingCartExample) 
    {
        return this.shoppingCartMapper.selectByExample(shoppingCartExample);
    }

    @Override
    public ShoppingCart selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShoppingCartKey shoppingCartKey = new ShoppingCartKey();
        shoppingCartKey.setIsDel("N");
        shoppingCartKey.setId(primaryKey);
        return this.shoppingCartMapper.selectByPrimaryKey(shoppingCartKey);
    }

    @Override
    public ShoppingCart selectByPrimaryKey(String primaryKey) 
    {
        ShoppingCartKey shoppingCartKey = new ShoppingCartKey();
        shoppingCartKey.setId(primaryKey);
        return this.shoppingCartMapper.selectByPrimaryKey(shoppingCartKey);
    }

}
