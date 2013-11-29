package com.gooagoo.core.business.goods.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.goods.manage.GoodsBrandCoreService;
import com.gooagoo.api.generator.core.goods.GoodsBrandGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.goods.GoodsBrand;

@Service
public class GoodsBrandCoreServiceImpl implements GoodsBrandCoreService
{
    @Autowired
    private GoodsBrandGeneratorCoreService goodsBrandGeneratorCoreService;

    @Override
    public boolean deleteGoodsBrand(String id) throws Exception
    {
        if (!StringUtils.hasText(id))
        {
            GooagooLog.warn("删除品牌信息：主键为空");
            return false;
        }
        return this.goodsBrandGeneratorCoreService.deleteByPrimaryKey(id);
    }

    @Override
    public boolean addGoodsBrand(GoodsBrand goodsBrand) throws Exception
    {
        goodsBrand.setIsDel("N");
        return this.goodsBrandGeneratorCoreService.insertSelective(goodsBrand);
    }

    @Override
    public boolean updateGoodsBrand(GoodsBrand goodsBrand) throws Exception
    {
        return this.goodsBrandGeneratorCoreService.updateByPrimaryKeySelective(goodsBrand);
    }

}
