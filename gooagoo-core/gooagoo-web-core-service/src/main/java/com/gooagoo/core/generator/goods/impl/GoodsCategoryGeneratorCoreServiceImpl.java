package com.gooagoo.core.generator.goods.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.core.goods.GoodsCategoryGeneratorCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.goods.GoodsCategoryMapper;
import com.gooagoo.entity.generator.goods.GoodsCategory;
import com.gooagoo.entity.generator.goods.GoodsCategoryExample;
import com.gooagoo.entity.generator.goods.GoodsCategoryKey;
import com.gooagoo.redis.data.RedisDatabase;

@Service
public class GoodsCategoryGeneratorCoreServiceImpl implements GoodsCategoryGeneratorCoreService
{

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public Integer countByExample(GoodsCategoryExample goodsCategoryExample)
    {
        return this.goodsCategoryMapper.countByExample(goodsCategoryExample);
    }

    @Override
    public List<GoodsCategory> selectByExample(GoodsCategoryExample goodsCategoryExample)
    {
        return this.goodsCategoryMapper.selectByExample(goodsCategoryExample);
    }

    @Override
    public GoodsCategory selectUnDelByPrimaryKey(String primaryKey)
    {
        GoodsCategoryKey goodsCategoryKey = new GoodsCategoryKey();
        goodsCategoryKey.setIsDel("N");
        goodsCategoryKey.setId(primaryKey);
        return this.goodsCategoryMapper.selectByPrimaryKey(goodsCategoryKey);
    }

    @Override
    public GoodsCategory selectByPrimaryKey(String primaryKey)
    {
        GoodsCategoryKey goodsCategoryKey = new GoodsCategoryKey();
        goodsCategoryKey.setId(primaryKey);
        return this.goodsCategoryMapper.selectByPrimaryKey(goodsCategoryKey);
    }

    @Override
    public boolean physicalDeleteByExample(GoodsCategoryExample goodsCategoryExample)
    {
        List<GoodsCategory> list = this.goodsCategoryMapper.selectByExample(goodsCategoryExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.goodsCategoryMapper.deleteByExample(goodsCategoryExample) != list.size())
        {
            return false;
        }
        for (GoodsCategory item : list)
        {
            this.clearRedis(item.getShopEntityId(), item.getCategoryId());
        }
        return true;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey)
    {
        GoodsCategoryKey goodsCategoryKey = new GoodsCategoryKey();
        goodsCategoryKey.setId(primaryKey);
        GoodsCategory goodsCategory = this.goodsCategoryMapper.selectByPrimaryKey(goodsCategoryKey);
        if (goodsCategory == null)
        {
            return false;
        }
        if (this.goodsCategoryMapper.deleteByPrimaryKey(goodsCategoryKey) != 1)
        {
            return false;
        }
        this.clearRedis(goodsCategory.getShopEntityId(), goodsCategory.getCategoryId());
        return true;
    }

    @Override
    public boolean deleteByExample(GoodsCategoryExample goodsCategoryExample)
    {
        List<GoodsCategory> list = this.goodsCategoryMapper.selectByExample(goodsCategoryExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.setIsDel("Y");
        if (this.goodsCategoryMapper.updateByExampleSelective(goodsCategory, goodsCategoryExample) != list.size())
        {
            return false;
        }
        for (GoodsCategory item : list)
        {
            this.clearRedis(item.getShopEntityId(), item.getCategoryId());
        }
        return true;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey)
    {
        GoodsCategoryKey goodsCategoryKey = new GoodsCategoryKey();
        goodsCategoryKey.setId(primaryKey);
        goodsCategoryKey.setIsDel("N");
        GoodsCategory goodsCategory = this.goodsCategoryMapper.selectByPrimaryKey(goodsCategoryKey);
        if (goodsCategory == null)
        {
            return false;
        }
        goodsCategory.setIsDel("Y");
        if (this.goodsCategoryMapper.updateByPrimaryKeySelective(goodsCategory) != 1)
        {
            return false;
        }
        this.clearRedis(goodsCategory.getShopEntityId(), goodsCategory.getCategoryId());
        return true;
    }

    @Override
    public boolean insertSelective(GoodsCategory goodsCategory)
    {
        return this.goodsCategoryMapper.insertSelective(goodsCategory) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(GoodsCategory goodsCategory, GoodsCategoryExample goodsCategoryExample)
    {
        List<GoodsCategory> list = this.goodsCategoryMapper.selectByExample(goodsCategoryExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.goodsCategoryMapper.updateByExampleSelective(goodsCategory, goodsCategoryExample) != list.size())
        {
            return false;
        }
        for (GoodsCategory item : list)
        {
            this.clearRedis(item.getShopEntityId(), item.getCategoryId());
        }
        return true;
    }

    @Override
    public boolean updateByPrimaryKeySelective(GoodsCategory goodsCategory)
    {
        if (this.goodsCategoryMapper.updateByPrimaryKeySelective(goodsCategory) != 1)
        {
            return false;
        }
        this.clearRedis(goodsCategory.getShopEntityId(), goodsCategory.getCategoryId());
        return true;
    }

    /**
     * 清空品类redis缓存
     * @param shopEntityId 实体店编号
     * @param categoryId 品类编号
     */
    private void clearRedis(String shopEntityId, String categoryId)
    {
        if (StringUtils.hasText(shopEntityId) && StringUtils.hasText(categoryId))
        {
            RedisDatabase base = new RedisDatabase(RedisServerConstants.business_category);
            base.del(shopEntityId + "_" + categoryId);
        }
    }

}
