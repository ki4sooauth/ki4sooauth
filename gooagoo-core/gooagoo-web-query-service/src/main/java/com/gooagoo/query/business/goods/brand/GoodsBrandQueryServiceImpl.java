package com.gooagoo.query.business.goods.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.goods.brand.GoodsBrandQueryService;
import com.gooagoo.dao.business.goods.brand.BrandBusinessMapper;
import com.gooagoo.entity.generator.goods.GoodsBrand;

@Service
public class GoodsBrandQueryServiceImpl implements GoodsBrandQueryService
{

    @Autowired
    private BrandBusinessMapper brandBusinessMapper;

    @Override
    public List<GoodsBrand> findDistinctGoodsBrandList(String shopId, String shopEntityId) throws Exception
    {
        if (!StringUtils.hasText(shopId))
        {
            shopId = null;
        }
        if (!StringUtils.hasText(shopEntityId))
        {
            shopEntityId = null;
        }
        return this.brandBusinessMapper.findDistinctGoodsBrandList(shopId, shopEntityId);
    }

    @Override
    public List<GoodsBrand> findDistinctGoodsBrand(String shopId, String shopEntityId, String brandId, String brandName, Integer pageIndex, Integer pageSize)
    {

        if (!StringUtils.hasText(shopId))
        {
            return null;
        }
        return this.brandBusinessMapper.findDistinctGoodsBrand(shopId, shopEntityId, brandId, brandName, pageIndex, pageSize);
    }

    @Override
    public int countDistinctGoodsBrand(String shopId, String shopEntityId, String brandId, String brandName)
    {
        if (!StringUtils.hasText(shopId))
        {
            return 0;
        }
        return this.brandBusinessMapper.countDistinctGoodsBrand(shopId, shopEntityId, brandId, brandName);
    }
}
