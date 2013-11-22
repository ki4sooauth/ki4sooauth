package com.gooagoo.api.generator.core.goods;

import java.util.List;

import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfoExample;

public interface GoodsMarketingInfoGeneratorCoreService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_marketing_info用于查询表中对应数据条数
     * @param goodsMarketingInfoExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(GoodsMarketingInfoExample goodsMarketingInfoExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_marketing_info用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param goodsMarketingInfoExample 查询条件
     * @return 
     */
    public List<GoodsMarketingInfo> selectByExample(GoodsMarketingInfoExample goodsMarketingInfoExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_marketing_info用于查询数据
     * @param goodsMarketingInfoKey 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public GoodsMarketingInfo selectUnDelByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_marketing_info用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public GoodsMarketingInfo selectByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_marketing_info用于删除操作（本系统数据库删除操作非物理删除，请慎用）
     * @param goodsMarketingInfoExample 删除条件
     * @return true-物理删除数据成功 false-物理删除数据失败
     */
    public boolean physicalDeleteByExample(GoodsMarketingInfoExample goodsMarketingInfoExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_marketing_info用于删除操作（本系统数据库删除操作非物理删除，请慎用）
     * @param primaryKey 删除条件
     * @return true-物理删除数据成功 false-物理删除数据失败
     */
    public boolean physicalDeleteByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_marketing_info用于逻辑删除数据（修改is_del值为Y)
     * @param goodsMarketingInfoExample 删除条件
     * @return true-逻辑删除数据成功 false-逻辑删除数据失败
     */
    public boolean deleteByExample(GoodsMarketingInfoExample goodsMarketingInfoExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_marketing_info用于逻辑删除数据（修改is_del值为Y)
     * @param primaryKey 删除条件 主键
     * @return true-逻辑删除成功 false-逻辑删除失败
     */
    public boolean deleteByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_marketing_info用于往表中添加数据
     * @param goodsMarketingInfo 插入数据
     * @return true-添加数据成功 false-添加数据失败
     */
    public boolean insertSelective(GoodsMarketingInfo goodsMarketingInfo) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_marketing_info用于更新数据，其中 create_time不提供修改功能， c_time_stamp自动设置为当前数据库时间
     * @param goodsMarketingInfo 更新数据
     * @param goodsMarketingInfoExample 更新条件
     * @return true-更新数据成功 false-更新数据失败
     */
    public boolean updateByExampleSelective(GoodsMarketingInfo goodsMarketingInfo,GoodsMarketingInfoExample goodsMarketingInfoExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表goods_marketing_info用于更新数据，其中 create_time不提供修改功能， c_time_stamp自动设置为当前数据库时间
     * @param goodsMarketingInfo 更新条件
     * @return true-更新数据成功 false-更新数据失败
     */
    public boolean updateByPrimaryKeySelective(GoodsMarketingInfo goodsMarketingInfo) ;

}
