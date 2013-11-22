package com.gooagoo.api.business.query.marketing.recommend;

import java.util.List;

import com.gooagoo.entity.business.marketing.recommend.RecommendBusiness;
import com.gooagoo.entity.business.marketing.recommend.RecommendShop;

/**
 * 推荐商品
 * @author Administrator
 *
 */
public interface RecommendQueryService
{
    /**
     * 推荐商品列表（分页查推荐有效期内的商品）
     * @param userId
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<RecommendBusiness> recommendGoods(String userId, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * 推荐优惠凭证列表（分页）
     * @param userId
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<RecommendBusiness> recommendCoupon(String userId, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * 推荐活动列表（分页）
     * @param userId
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<RecommendBusiness> recommendActivity(String userId, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * 接口 moba05 : 推荐商家列表（分页）
     * @param userId
     * @param keyword
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<RecommendShop> recommendShop(String userId, Integer pageIndex, Integer pageSize) throws Exception;

}
