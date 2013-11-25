package com.gooagoo.api.generator.query.base;

import java.util.List;

import com.gooagoo.entity.generator.base.ShopToolInfo;
import com.gooagoo.entity.generator.base.ShopToolInfoExample;

public interface ShopToolInfoGeneratorQueryService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_tool_info用于查询表中对应数据条数
     * @param shopToolInfoExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(ShopToolInfoExample shopToolInfoExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_tool_info用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param shopToolInfoExample 查询条件
     * @return 
     */
    public List<ShopToolInfo> selectByExample(ShopToolInfoExample shopToolInfoExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_tool_info用于查询数据
     * @param shopToolInfoKey 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public ShopToolInfo selectUnDelByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_tool_info用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public ShopToolInfo selectByPrimaryKey(String primaryKey) ;

}