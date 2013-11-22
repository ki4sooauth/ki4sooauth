package com.gooagoo.api.business.core.system.user.enterprise;

import com.gooagoo.entity.generator.sys.NominateShop;

/**
 *  推荐商家管理
 */
public interface RecommendMerchantCoreService

{

    /**
     * 新增推荐商家
     * @param nominateShop
     * @return
     * @throws Exception
     */
    public boolean addRecommendMerchant(NominateShop nominateShop) throws Exception;

    /**
     * 编辑推荐商家
     * @param nominateShop
     * @return
     * @throws Exception
     */
    public boolean updateRecommendMerchant(NominateShop nominateShop) throws Exception;

}
