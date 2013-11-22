package com.gooagoo.api.generator.query.goods;

import java.util.List;

import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample;

public interface GoodsBaseInfoGeneratorQueryService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_base_info用于查询表中对应数据条数
     * @param goodsBaseInfoExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(GoodsBaseInfoExample goodsBaseInfoExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_base_info用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param goodsBaseInfoExample 查询条件
     * @return 
     */
    public List<GoodsBaseInfo> selectByExample(GoodsBaseInfoExample goodsBaseInfoExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_base_info用于查询数据
     * @param goodsBaseInfoKey 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public GoodsBaseInfo selectUnDelByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_base_info用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public GoodsBaseInfo selectByPrimaryKey(String primaryKey) ;

}
