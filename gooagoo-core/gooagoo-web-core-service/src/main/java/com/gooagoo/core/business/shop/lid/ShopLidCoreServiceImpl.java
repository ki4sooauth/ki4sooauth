package com.gooagoo.core.business.shop.lid;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.shop.lid.ShopLidCoreService;
import com.gooagoo.api.generator.core.shop.ShopLidDetailGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopLidInfoGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopLidDetail;
import com.gooagoo.entity.generator.shop.ShopLidInfoExample;

@Service
public class ShopLidCoreServiceImpl implements ShopLidCoreService
{
    @Autowired
    private ShopLidDetailGeneratorCoreService shopLidDetailGeneratorCoreService;
    @Autowired
    private ShopLidInfoGeneratorCoreService shopLidInfoGeneratorCoreService;

    @Override
    public boolean updateShopLidDetail(ShopLidDetail shopLidDetail) throws Exception
    {
        return this.shopLidDetailGeneratorCoreService.updateByPrimaryKeySelective(shopLidDetail);
    }

    @Override
    public boolean batchDeleteShopLidInfo(String lidBases) throws Exception
    {
        if (!StringUtils.hasText(lidBases))
        {
            return false;
        }
        List<String> lidBaseList = Arrays.asList(lidBases.split(","));
        ShopLidInfoExample shopLidInfoExample = new ShopLidInfoExample();
        shopLidInfoExample.createCriteria().andLidBaseIn(lidBaseList);
        return this.shopLidInfoGeneratorCoreService.deleteByExample(shopLidInfoExample);
    }
}
