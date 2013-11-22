package com.gooagoo.api.generator.query.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.NominateGoods;
import com.gooagoo.entity.generator.sys.NominateGoodsExample;

public interface NominateGoodsGeneratorQueryService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表nominate_goods用于查询表中对应数据条数
     * @param nominateGoodsExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(NominateGoodsExample nominateGoodsExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表nominate_goods用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param nominateGoodsExample 查询条件
     * @return 
     */
    public List<NominateGoods> selectByExample(NominateGoodsExample nominateGoodsExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表nominate_goods用于查询数据
     * @param nominateGoodsKey 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public NominateGoods selectUnDelByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表nominate_goods用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public NominateGoods selectByPrimaryKey(String primaryKey) ;

}
