package com.gooagoo.core.business.marketing.qualitygoods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.marketing.qualitygoods.QualityGoodsCoreService;
import com.gooagoo.api.generator.core.marketing.MarketingQualityGoodsGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.marketing.MarketingQualityGoods;

/**
 * 精品推荐
*/
@Service
public class QualityGoodsCoreServiceImpl implements QualityGoodsCoreService
{
    @Autowired
    private MarketingQualityGoodsGeneratorCoreService marketingQualityGoodsGeneratorCoreService;

    @Override
    public boolean addQualityGood(MarketingQualityGoods marketingQualityGoods) throws Exception
    {
        marketingQualityGoods.setIsDel("N");
        return this.marketingQualityGoodsGeneratorCoreService.insertSelective(marketingQualityGoods);
    }

    @Override
    public boolean updateQualityGood(MarketingQualityGoods marketingQualityGoods) throws Exception
    {
        return this.marketingQualityGoodsGeneratorCoreService.updateByPrimaryKeySelective(marketingQualityGoods);
    }

    @Override
    public boolean deleteQualityGood(String marketingQualityGoodsId) throws Exception
    {
        if (!StringUtils.hasText(marketingQualityGoodsId))
        {
            GooagooLog.warn("删除精品推荐：精品推荐Id为空");
            return false;
        }
        return this.marketingQualityGoodsGeneratorCoreService.deleteByPrimaryKey(marketingQualityGoodsId);
    }

}
