package com.gooagoo.api.generator.core.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.NominateCoupon;
import com.gooagoo.entity.generator.sys.NominateCouponExample;

public interface NominateCouponGeneratorCoreService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表nominate_coupon用于查询表中对应数据条数
     * @param nominateCouponExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(NominateCouponExample nominateCouponExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表nominate_coupon用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param nominateCouponExample 查询条件
     * @return 
     */
    public List<NominateCoupon> selectByExample(NominateCouponExample nominateCouponExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表nominate_coupon用于查询数据
     * @param nominateCouponKey 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public NominateCoupon selectUnDelByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表nominate_coupon用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public NominateCoupon selectByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表nominate_coupon用于删除操作（本系统数据库删除操作非物理删除，请慎用）
     * @param nominateCouponExample 删除条件
     * @return true-物理删除数据成功 false-物理删除数据失败
     */
    public boolean physicalDeleteByExample(NominateCouponExample nominateCouponExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表nominate_coupon用于删除操作（本系统数据库删除操作非物理删除，请慎用）
     * @param primaryKey 删除条件
     * @return true-物理删除数据成功 false-物理删除数据失败
     */
    public boolean physicalDeleteByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表nominate_coupon用于逻辑删除数据（修改is_del值为Y)
     * @param nominateCouponExample 删除条件
     * @return true-逻辑删除数据成功 false-逻辑删除数据失败
     */
    public boolean deleteByExample(NominateCouponExample nominateCouponExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表nominate_coupon用于逻辑删除数据（修改is_del值为Y)
     * @param primaryKey 删除条件 主键
     * @return true-逻辑删除成功 false-逻辑删除失败
     */
    public boolean deleteByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表nominate_coupon用于往表中添加数据
     * @param nominateCoupon 插入数据
     * @return true-添加数据成功 false-添加数据失败
     */
    public boolean insertSelective(NominateCoupon nominateCoupon) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表nominate_coupon用于更新数据，其中 create_time不提供修改功能， c_time_stamp自动设置为当前数据库时间
     * @param nominateCoupon 更新数据
     * @param nominateCouponExample 更新条件
     * @return true-更新数据成功 false-更新数据失败
     */
    public boolean updateByExampleSelective(NominateCoupon nominateCoupon,NominateCouponExample nominateCouponExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表nominate_coupon用于更新数据，其中 create_time不提供修改功能， c_time_stamp自动设置为当前数据库时间
     * @param nominateCoupon 更新条件
     * @return true-更新数据成功 false-更新数据失败
     */
    public boolean updateByPrimaryKeySelective(NominateCoupon nominateCoupon) ;

}
