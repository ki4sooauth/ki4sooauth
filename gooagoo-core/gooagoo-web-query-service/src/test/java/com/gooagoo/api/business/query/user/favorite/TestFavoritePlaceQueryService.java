package com.gooagoo.api.business.query.user.favorite;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.marketing.FirstMenu;
import com.gooagoo.entity.business.user.FavoritePlace;

public class TestFavoritePlaceQueryService
{

    public FavoritePlaceQueryService favoritePlaceQueryService;

    @Before
    public void testBefore()
    {
        this.favoritePlaceQueryService = ApplicationContextUtils.getBean(FavoritePlaceQueryService.class);
    }

    /**
     * 收藏广场列表侧边栏
     * @throws Exception
     */
    @Test
    public void testFindFavoritePlaceLeftMenu() throws Exception
    {
        List<FirstMenu> favoritePlaceLeftMenuList = this.favoritePlaceQueryService.findFavoritePlaceLeftMenu();
        Assert.assertTrue("查询收藏广场列表侧边栏失败", CollectionUtils.isNotEmpty(favoritePlaceLeftMenuList));
    }

    /**
     * 收藏广场列表查询
     * @throws Exception
     */
    @Test
    public void testFindFavoritePlace() throws Exception
    {
        String userid = "01822RBQ22JSDMA085QBV8EIISWR0JGT";
        String shopid = null;//00017Q3EG198TUUV50000HFYOBYEH00F
        String objType = null;//D
        String keyword = "兰";
        String typecode = null;//C,G,A
        Integer pageIndex = 1;
        Integer pageSize = 2;
        List<FavoritePlace> favoritePlaceList = this.favoritePlaceQueryService.findFavoritePlace(userid, shopid, objType, keyword, typecode, pageIndex, pageSize);
        Assert.assertTrue("查询收藏广场列表失败", CollectionUtils.isNotEmpty(favoritePlaceList));
    }
}
