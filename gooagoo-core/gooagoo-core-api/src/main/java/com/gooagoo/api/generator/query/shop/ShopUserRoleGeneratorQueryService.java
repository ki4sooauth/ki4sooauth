package com.gooagoo.api.generator.query.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopUserRole;
import com.gooagoo.entity.generator.shop.ShopUserRoleExample;

public interface ShopUserRoleGeneratorQueryService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_user_role用于查询表中对应数据条数
     * @param shopUserRoleExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(ShopUserRoleExample shopUserRoleExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_user_role用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param shopUserRoleExample 查询条件
     * @return 
     */
    public List<ShopUserRole> selectByExample(ShopUserRoleExample shopUserRoleExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_user_role用于查询数据
     * @param shopUserRoleKey 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public ShopUserRole selectUnDelByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_user_role用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public ShopUserRole selectByPrimaryKey(String primaryKey) ;

}
