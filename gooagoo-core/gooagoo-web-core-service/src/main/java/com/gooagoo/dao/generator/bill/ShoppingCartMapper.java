package com.gooagoo.dao.generator.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.bill.ShoppingCart;
import com.gooagoo.entity.generator.bill.ShoppingCartExample;
import com.gooagoo.entity.generator.bill.ShoppingCartKey;

public interface ShoppingCartMapper
{

    public Integer countByExample(ShoppingCartExample shoppingCartExample);

    public List<ShoppingCart> selectByExample(ShoppingCartExample shoppingCartExample);

    public ShoppingCart selectByPrimaryKey(ShoppingCartKey shoppingCartKey);

    public Integer deleteByExample(ShoppingCartExample shoppingCartExample);

    public Integer deleteByPrimaryKey(ShoppingCartKey shoppingCartKey);

    public Integer insertSelective(ShoppingCart shoppingCart);

    public Integer updateAllByExample(@Param("record") ShoppingCart shoppingCart, @Param("example") ShoppingCartExample shoppingCartExample);

    public Integer updateByExampleSelective(@Param("record") ShoppingCart shoppingCart, @Param("example") ShoppingCartExample shoppingCartExample);

    public Integer updateByPrimaryKeySelective(ShoppingCart shoppingCart);

}
