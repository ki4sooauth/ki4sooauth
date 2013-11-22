package com.gooagoo.dao.generator.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.ShoppingCart;
import com.gooagoo.entity.generator.bill.ShoppingCartExample;
import com.gooagoo.entity.generator.bill.ShoppingCartKey;

public interface ShoppingCartMapper
{

    public Integer countByExample(ShoppingCartExample shoppingCartExample);

    public List<ShoppingCart> selectByExample(ShoppingCartExample shoppingCartExample);

    public ShoppingCart selectByPrimaryKey(ShoppingCartKey shoppingCartKey);

}
