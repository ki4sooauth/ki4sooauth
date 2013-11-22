package com.gooagoo.api.business.core.system.resource.recommend;

import com.gooagoo.entity.generator.sys.NominateGoods;

/**
 *  推荐商品管理
 */
public interface RecommendProductsCoreService

{

    /**
     * 新增推荐商品
     * @param nominateGoods
     * @return
     * @throws Exception
     */
    public boolean addRecommendProducts(NominateGoods nominateGoods) throws Exception;

    /**
     * 删除推荐商品
     * @param id
     * @return
     * @throws Exception
     */
    public boolean delRecommendProducts(String id) throws Exception;

    /**
     * 编辑推荐商品
     * @param nominateGoods
     * @return
     * @throws Exception
     */
    public boolean updateRecommendProducts(NominateGoods nominateGoods) throws Exception;

}
