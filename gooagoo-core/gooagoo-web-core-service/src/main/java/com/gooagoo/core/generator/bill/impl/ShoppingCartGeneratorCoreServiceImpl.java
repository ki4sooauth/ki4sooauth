package com.gooagoo.core.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.bill.ShoppingCartGeneratorCoreService;
import com.gooagoo.entity.generator.bill.ShoppingCart;
import com.gooagoo.entity.generator.bill.ShoppingCartExample;
import com.gooagoo.entity.generator.bill.ShoppingCartKey;
import com.gooagoo.dao.generator.bill.ShoppingCartMapper;

@Service
public class ShoppingCartGeneratorCoreServiceImpl implements ShoppingCartGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ShoppingCartExample shoppingCartExample) 
    {
        return this.shoppingCartMapper.deleteByExample(shoppingCartExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShoppingCartKey shoppingCartKey = new ShoppingCartKey();
        shoppingCartKey.setId(primaryKey);
        return this.shoppingCartMapper.deleteByPrimaryKey(shoppingCartKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShoppingCartExample shoppingCartExample) 
    {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setIsDel("Y");
        return this.shoppingCartMapper.updateByExampleSelective(shoppingCart,shoppingCartExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(primaryKey);
        shoppingCart.setIsDel("Y");
        return this.shoppingCartMapper.updateByPrimaryKeySelective(shoppingCart) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShoppingCart shoppingCart) 
    {
        return this.shoppingCartMapper.insertSelective(shoppingCart) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShoppingCart shoppingCart,ShoppingCartExample shoppingCartExample) 
    {
        return this.shoppingCartMapper.updateByExampleSelective(shoppingCart,shoppingCartExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShoppingCart shoppingCart) 
    {
        return this.shoppingCartMapper.updateByPrimaryKeySelective(shoppingCart) > 0 ? true : false;
    }

}
