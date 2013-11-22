package com.gooagoo.api.business.query.user.favorite;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.user.FavoriteInfoDetail;
import com.gooagoo.entity.business.user.FavoriteLinkInfoBusiness;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;

public class TestFavoriteQueryService
{

    public FavoriteQueryService favoriteQueryService;

    @Before
    public void testBefore()
    {
        this.favoriteQueryService = ApplicationContextUtils.getBean(FavoriteQueryService.class);
    }

    /**
     * 查询会员收藏信息
     * @throws Exception
     */
    @Test
    public void testFindMemberFavorite() throws Exception
    {
        String userId = "01822RBQ22JSDMA085QBV8EIISWR0JGT";
        String shopId = "01822MAPVKNP054085QBQVEIISWR0JGT";
        String cTimeStamp = "2013-10-16 11:09:44";
        String favoriteType = null;
        String pageId = "0";
        String pageType = "P";
        Integer pageIndex = null;
        Integer pageSize = 2;
        FavoriteLinkInfoBusiness favoriteLinkInfoBusiness = this.favoriteQueryService.findMemberFavorite(userId, shopId, null, cTimeStamp, favoriteType, pageId, pageType, pageIndex, pageSize);
        Assert.assertTrue("查询会员收藏信息失败", CollectionUtils.isNotEmpty(favoriteLinkInfoBusiness.getFavoriteInfoBusinessList()));
    }

    /**
     * 用户收藏列表（商品，活动，优惠券）分页
     * @throws Exception
     */
    @Test
    public void testFindFavoriteList() throws Exception
    {
        FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
        List<FavoriteInfoDetail> favoriteInfoDetailList = this.favoriteQueryService.findFavoriteList(favoriteInfoExample);
        Assert.assertTrue("查询用户收藏列表（商品，活动，优惠券）是被", CollectionUtils.isNotEmpty(favoriteInfoDetailList));
    }

    /**
     * 判断用户是否收藏
     * @throws Exception
     */
    @Test
    public void testIsFavorite() throws Exception
    {

        Assert.assertNotNull("", "");
    }

}
