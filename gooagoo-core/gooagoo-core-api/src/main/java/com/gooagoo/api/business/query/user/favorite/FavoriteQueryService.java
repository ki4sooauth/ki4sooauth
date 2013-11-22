package com.gooagoo.api.business.query.user.favorite;

import java.util.List;

import com.gooagoo.entity.business.user.FavoriteInfoDetail;
import com.gooagoo.entity.business.user.FavoriteLinkInfoBusiness;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;

/**
 * 收藏
 */
public interface FavoriteQueryService
{

    /**
     * 查询会员收藏信息
     * 当shopId或者shopEntityId有值时查询本店（本商家）收藏
     * @param userId 用户编号
     * @param shopId 商家编号
     * @param shopEntityId 实体店编号
     * @param cTimeStamp 最大时间戳
     * @param favoriteType 收藏类型
     * @param pageId (收藏编号)
     * @param pageType 分页类型(N:下一页,P:上一页)
     * @param pageIndex 页码(手机分页需传null)
     * @param pageSize 页面大小
     * @return List<FavoriteInfoBusiness>
     * @throws Exception
     */
    public FavoriteLinkInfoBusiness findMemberFavorite(String userId, String shopId, String shopEntityId, String cTimeStamp, String favoriteType, String pageId, String pageType, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * 用户收藏列表（商品，活动，优惠券）分页
     * @param favoriteInfoExample
     * @return
     * @throws Exception
     */
    public List<FavoriteInfoDetail> findFavoriteList(FavoriteInfoExample favoriteInfoExample) throws Exception;

    /**
     * 用户收藏次数
     * @param favoriteInfoExample
     * @return
     * @throws Exception
     */

    public int findFavoriteListCount(FavoriteInfoExample favoriteInfoExample) throws Exception;

    /**
    * 判断用户是否收藏
    * @param userId
    * @param objectId
    * @return
    * @throws Exception
    */
    public boolean isFavorite(String userId, String objectId) throws Exception;

    /**
     * 接口 mobb12 : 查询用户可用优惠券数量
     * @param userId 用户编号
     * @param shopid 商家编号
     * @return
     * @throws Exception
     */
    public Integer GetUserUserableCouponNums(String userId, String shopId) throws Exception;

}
