package com.gooagoo.api.generator.query.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.ShopAd;
import com.gooagoo.entity.generator.sys.ShopAdExample;

public interface ShopAdGeneratorQueryService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_ad用于查询表中对应数据条数
     * @param shopAdExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(ShopAdExample shopAdExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_ad用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param shopAdExample 查询条件
     * @return 
     */
    public List<ShopAd> selectByExample(ShopAdExample shopAdExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_ad用于查询数据
     * @param shopAdKey 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public ShopAd selectUnDelByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表shop_ad用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public ShopAd selectByPrimaryKey(String primaryKey) ;

}
