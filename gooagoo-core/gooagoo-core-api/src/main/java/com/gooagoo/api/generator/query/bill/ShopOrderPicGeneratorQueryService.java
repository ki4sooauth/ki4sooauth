package com.gooagoo.api.generator.query.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.ShopOrderPic;
import com.gooagoo.entity.generator.bill.ShopOrderPicExample;

public interface ShopOrderPicGeneratorQueryService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_order_pic用于查询表中对应数据条数
     * @param shopOrderPicExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(ShopOrderPicExample shopOrderPicExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_order_pic用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param shopOrderPicExample 查询条件
     * @return 
     */
    public List<ShopOrderPic> selectByExample(ShopOrderPicExample shopOrderPicExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_order_pic用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public ShopOrderPic selectByPrimaryKey(String primaryKey) ;

}