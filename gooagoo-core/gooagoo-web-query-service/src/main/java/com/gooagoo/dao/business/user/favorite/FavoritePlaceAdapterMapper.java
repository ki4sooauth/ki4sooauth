package com.gooagoo.dao.business.user.favorite;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.business.user.MobileFavoritePlace;

public interface FavoritePlaceAdapterMapper
{
    /**
     * 按goods_sys_type_id（精品类型编号）查询收藏广场下的精品信息 
     * @param goodsSysTypeId
     * @return List<MobileFavoriteplace>
     */
    public List<MobileFavoritePlace> findMarketingQualityGoodsOfplaceById(@Param("goodsTypeId") String goodsTypeId, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 按关键字goods_name（商品名称）模糊查询收藏广场下的精品信息
     * @param goodsName
     * @return List<MobileFavoriteplace>
     */
    public List<MobileFavoritePlace> fuzzyFindMarketingQualityGoodsOfplaceByKeyWord(@Param("goodsName") String goodsName, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 按ShopTypeId(商家类别编号)查询收藏广场下的优惠信息 
     * @param shopTypeId
     * @return List<MobileFavoriteplace>
     */
    public List<MobileFavoritePlace> findCouponOfplaceById(@Param("shopId") String shopId, @Param("couponType") String couponType, @Param("shopTypeId") String shopTypeId, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 按关键字CouponName（优惠凭证名称）模糊查询收藏广场下的优惠信息 
     * @param couponName
     * @return List<MobileFavoriteplace>
     */
    public List<MobileFavoritePlace> fuzzyFindCouponOfplaceByKeyWord(@Param("shopId") String shopId, @Param("couponType") String couponType, @Param("couponName") String couponName, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 按关键字title（活动标题）模糊查询收藏广场下的活动信息
     * @param title
     * @return
     */
    public List<MobileFavoritePlace> fuzzyFindActivityOfplaceByKeyWord(@Param("title") String title, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 分页查询收藏广场下的优惠券、精品、活动信息
     * @param keyword 关键字模糊查询
     * @return
     */
    public List<MobileFavoritePlace> findMobileFavoritePlace(@Param("keyword") String keyword, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
}
