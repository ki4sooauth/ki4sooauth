package com.gooagoo.core.business.system.user.enterprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.system.user.enterprise.RecommendMerchantCoreService;
import com.gooagoo.api.generator.core.sys.NominateShopGeneratorCoreService;
import com.gooagoo.entity.generator.sys.NominateShop;

@Service
public class RecommendMerchantCoreServiceImpl implements RecommendMerchantCoreService

{

    @Autowired
    private NominateShopGeneratorCoreService nominateShopGeneratorCoreService;

    @Override
    public boolean addRecommendMerchant(NominateShop nominateShop) throws Exception
    {
        nominateShop.setIsDel("N");
        return this.nominateShopGeneratorCoreService.insertSelective(nominateShop);
    }

    @Override
    public boolean updateRecommendMerchant(NominateShop nominateShop) throws Exception
    {
        return this.nominateShopGeneratorCoreService.updateByPrimaryKeySelective(nominateShop);
    }
}
