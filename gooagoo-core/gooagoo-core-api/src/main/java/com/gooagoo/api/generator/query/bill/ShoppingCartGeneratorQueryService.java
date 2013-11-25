package com.gooagoo.api.generator.query.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.ShoppingCart;
import com.gooagoo.entity.generator.bill.ShoppingCartExample;

public interface ShoppingCartGeneratorQueryService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shopping_cart用于查询表中对应数据条数
     * @param shoppingCartExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(ShoppingCartExample shoppingCartExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shopping_cart用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param shoppingCartExample 查询条件
     * @return 
     */
    public List<ShoppingCart> selectByExample(ShoppingCartExample shoppingCartExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shopping_cart用于查询数据
     * @param shoppingCartKey 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public ShoppingCart selectUnDelByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shopping_cart用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public ShoppingCart selectByPrimaryKey(String primaryKey) ;

}