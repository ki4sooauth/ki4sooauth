package com.gooagoo.api.generator.query.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopRoleAuthority2;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority2Example;

public interface ShopRoleAuthority2GeneratorQueryService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_role_authority2用于查询表中对应数据条数
     * @param shopRoleAuthority2Example 查询条件
     * @return 数据条数
     */
    public Integer countByExample(ShopRoleAuthority2Example shopRoleAuthority2Example) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_role_authority2用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param shopRoleAuthority2Example 查询条件
     * @return 
     */
    public List<ShopRoleAuthority2> selectByExample(ShopRoleAuthority2Example shopRoleAuthority2Example) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_role_authority2用于查询数据
     * @param shopRoleAuthority2Key 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public ShopRoleAuthority2 selectUnDelByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_role_authority2用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public ShopRoleAuthority2 selectByPrimaryKey(String primaryKey) ;

}
