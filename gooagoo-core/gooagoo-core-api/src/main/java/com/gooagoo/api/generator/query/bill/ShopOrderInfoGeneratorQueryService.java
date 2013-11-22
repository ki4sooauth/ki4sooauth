package com.gooagoo.api.generator.query.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.ShopOrderInfo;
import com.gooagoo.entity.generator.bill.ShopOrderInfoExample;

public interface ShopOrderInfoGeneratorQueryService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_order_info用于查询表中对应数据条数
     * @param shopOrderInfoExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(ShopOrderInfoExample shopOrderInfoExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_order_info用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param shopOrderInfoExample 查询条件
     * @return 
     */
    public List<ShopOrderInfo> selectByExample(ShopOrderInfoExample shopOrderInfoExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_order_info用于查询数据
     * @param shopOrderInfoKey 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public ShopOrderInfo selectUnDelByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_order_info用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public ShopOrderInfo selectByPrimaryKey(String primaryKey) ;

}
