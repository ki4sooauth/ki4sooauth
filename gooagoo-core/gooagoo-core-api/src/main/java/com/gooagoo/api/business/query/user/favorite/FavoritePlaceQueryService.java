package com.gooagoo.api.business.query.user.favorite;

import java.util.List;

import com.gooagoo.entity.business.marketing.FirstMenu;
import com.gooagoo.entity.business.user.FavoritePlace;

/**
 * 收藏广场
 */
public interface FavoritePlaceQueryService
{

    /**
     * 收藏广场列表侧边栏
     * @return List<Firstmenu>
     */
    public List<FirstMenu> findFavoritePlaceLeftMenu() throws Exception;

    /**
     * 收藏广场列表查询
     * @param userid
     * @param shopid
     * @param objType 对象类型（如优惠券类型 C-代金券，D-折扣券）
     * @param keyword
     * @param typecode
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<FavoritePlace> findFavoritePlace(String userid, String shopid, String objType, String keyword, String typecode, Integer pageIndex, Integer pageSize) throws Exception;
}
