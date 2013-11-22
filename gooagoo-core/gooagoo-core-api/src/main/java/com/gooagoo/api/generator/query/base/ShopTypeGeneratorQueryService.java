package com.gooagoo.api.generator.query.base;

import java.util.List;

import com.gooagoo.entity.generator.base.ShopType;
import com.gooagoo.entity.generator.base.ShopTypeExample;

public interface ShopTypeGeneratorQueryService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_type用于查询表中对应数据条数
     * @param shopTypeExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(ShopTypeExample shopTypeExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_type用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param shopTypeExample 查询条件
     * @return 
     */
    public List<ShopType> selectByExample(ShopTypeExample shopTypeExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_type用于查询数据
     * @param shopTypeKey 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public ShopType selectUnDelByPrimaryKey(Integer primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_type用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public ShopType selectByPrimaryKey(Integer primaryKey) ;

}
