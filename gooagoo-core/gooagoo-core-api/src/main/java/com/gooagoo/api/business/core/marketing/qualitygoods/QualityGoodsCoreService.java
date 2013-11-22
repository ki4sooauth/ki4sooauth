package com.gooagoo.api.business.core.marketing.qualitygoods;

import com.gooagoo.entity.generator.marketing.MarketingQualityGoods;

/**
 * 精品推荐
*/
public interface QualityGoodsCoreService
{

    /**
     * 添加精品
     * @param marketingQualityGoods
     * @return
     * @throws Exception
     */
    public boolean addQualityGood(MarketingQualityGoods marketingQualityGoods) throws Exception;

    /**
     * 编辑精品
     * @param marketingQualityGoods
     * @return
     * @throws Exception
     */
    public boolean updateQualityGood(MarketingQualityGoods marketingQualityGoods) throws Exception;

    /**
     * 删除精品
     * @param id
     * @return
     * @throws Exception
     */
    public boolean deleteQualityGood(String id) throws Exception;

}
