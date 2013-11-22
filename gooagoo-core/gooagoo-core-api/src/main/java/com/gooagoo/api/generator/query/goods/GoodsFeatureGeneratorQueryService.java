package com.gooagoo.api.generator.query.goods;

import java.util.List;

import com.gooagoo.entity.generator.goods.GoodsFeature;
import com.gooagoo.entity.generator.goods.GoodsFeatureExample;

public interface GoodsFeatureGeneratorQueryService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_feature用于查询表中对应数据条数
     * @param goodsFeatureExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(GoodsFeatureExample goodsFeatureExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_feature用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param goodsFeatureExample 查询条件
     * @return 
     */
    public List<GoodsFeature> selectByExample(GoodsFeatureExample goodsFeatureExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_feature用于查询数据
     * @param goodsFeatureKey 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public GoodsFeature selectUnDelByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_feature用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public GoodsFeature selectByPrimaryKey(String primaryKey) ;

}
