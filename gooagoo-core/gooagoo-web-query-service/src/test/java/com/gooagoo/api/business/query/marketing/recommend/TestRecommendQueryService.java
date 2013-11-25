package com.gooagoo.api.business.query.marketing.recommend;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.marketing.recommend.RecommendBusiness;
import com.gooagoo.entity.business.system.nominate.NominateShopBusiness;

public class TestRecommendQueryService
{

    public RecommendQueryService recommendQueryService;

    @Before
    public void testBefore()
    {
        this.recommendQueryService = ApplicationContextUtils.getBean(RecommendQueryService.class);
    }

    /**
     * 推荐商品列表（分页查推荐有效期内的商品）
     * @throws Exception
     */
    @Test
    public void testRecommendGoods() throws Exception
    {
        String userId = null;
        Integer pageIndex = 1;
        Integer pageSize = 1;
        List<RecommendBusiness> recommendBusinessList = this.recommendQueryService.recommendGoods(userId, pageIndex, pageSize);
        Assert.assertTrue("查询推荐商品列表失败", CollectionUtils.isNotEmpty(recommendBusinessList));
    }

    /**
     * 推荐优惠凭证列表（分页）
     * @throws Exception
     */
    @Test
    public void testRecommendCoupon() throws Exception
    {
        String userId = null;
        Integer pageIndex = 1;
        Integer pageSize = 1;
        List<RecommendBusiness> recommendBusinessList = this.recommendQueryService.recommendCoupon(userId, pageIndex, pageSize);
        Assert.assertTrue("查询推荐优惠凭证列表失败", CollectionUtils.isNotEmpty(recommendBusinessList));
    }

    /**
     * 推荐活动列表（分页）
     * @throws Exception
     */
    @Test
    public void testRecommendActivity() throws Exception
    {
        String userId = null;
        Integer pageIndex = 1;
        Integer pageSize = 1;
        List<RecommendBusiness> recommendBusinessList = this.recommendQueryService.recommendActivity(userId, pageIndex, pageSize);
        Assert.assertTrue("查询推荐优惠凭证列表失败", CollectionUtils.isNotEmpty(recommendBusinessList));
    }

    /**
     * 推荐商家列表（分页）
     * @throws Exception
     */
    @Test
    public void testRecommendShop() throws Exception
    {
        String userId = "01822RBQ22JSDMA085QBV8EIISWR0JGT";
        Integer pageIndex = 1;
<<<<<<< .mine
        Integer pageSize = 100;
        String shopId = null;
        List<NominateShopBusiness> list = this.recommendQueryService.nominateShopBusinessList(shopId, userId, pageIndex, pageSize);
=======
        Integer pageSize = 4;
        List<RecommendShop> list = this.recommendQueryService.recommendShop(userId, pageIndex, pageSize);
>>>>>>> .r17861
        Assert.assertTrue("查询推荐商家列表失败", CollectionUtils.isNotEmpty(list));

    }
}