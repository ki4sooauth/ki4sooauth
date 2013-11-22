package com.gooagoo.core.business.system.resource.recommend;

import org.springframework.beans.factory.annotation.Autowired;

import com.gooagoo.api.business.core.system.resource.recommend.RecommendProductsCoreService;
import com.gooagoo.api.generator.core.sys.NominateGoodsGeneratorCoreService;
import com.gooagoo.entity.generator.sys.NominateGoods;

public class RecommendProductsCoreServiceImpl implements RecommendProductsCoreService

{

    @Autowired
    private NominateGoodsGeneratorCoreService nominateGoodsGeneratorCoreService;

    @Override
    public boolean addRecommendProducts(NominateGoods nominateGoods) throws Exception
    {
        nominateGoods.setIsDel("N");
        return this.nominateGoodsGeneratorCoreService.insertSelective(nominateGoods);
    }

    @Override
    public boolean delRecommendProducts(String id) throws Exception
    {
        NominateGoods nominateGoods = new NominateGoods();
        nominateGoods.setId(id);
        nominateGoods.setIsDel("Y");
        return this.nominateGoodsGeneratorCoreService.updateByPrimaryKeySelective(nominateGoods);
    }

    @Override
    public boolean updateRecommendProducts(NominateGoods nominateGoods) throws Exception
    {
        return this.nominateGoodsGeneratorCoreService.updateByPrimaryKeySelective(nominateGoods);
    }

}
