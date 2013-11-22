package com.gooagoo.core.business.goods.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.goods.manage.GoodsFeatureCoreService;
import com.gooagoo.api.generator.core.goods.GoodsFeatureGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.goods.GoodsFeature;

@Service
public class GoodsFeatureCoreServiceImpl implements GoodsFeatureCoreService
{
    @Autowired
    private GoodsFeatureGeneratorCoreService goodsFeatureGeneratorCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean deleteGoodsFeature(String id) throws Exception
    {
        if (!StringUtils.hasText(id))
        {
            GooagooLog.warn("删除商品特征项：主键为空");
            return false;
        }
        return this.goodsFeatureGeneratorCoreService.deleteByPrimaryKey(id);
    }

    @Override
    public boolean addGoodsFeature(GoodsFeature goodsFeature) throws Exception
    {
        goodsFeature.setIsDel("N");
        return this.goodsFeatureGeneratorCoreService.insertSelective(goodsFeature);
    }

    @Override
    public boolean updateGoodsFeature(GoodsFeature goodsFeature) throws Exception
    {
        return this.goodsFeatureGeneratorCoreService.updateByPrimaryKeySelective(goodsFeature);
    }

}
