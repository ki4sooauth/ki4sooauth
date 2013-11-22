package com.gooagoo.query.business.goods.category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.goods.category.GoodsCategoryQueryService;
import com.gooagoo.api.generator.query.goods.GoodsCategoryGeneratorQueryService;
import com.gooagoo.dao.business.goods.category.CategoryBusinessMapper;
import com.gooagoo.entity.generator.goods.GoodsCategory;
import com.gooagoo.entity.generator.goods.GoodsCategoryExample;

/**
 * 商品品类
 */
@Service
public class GoodsCategoryQueryServiceImpl implements GoodsCategoryQueryService
{
    @Autowired
    private GoodsCategoryGeneratorQueryService goodsCategoryGeneratorQueryService;
    @Autowired
    private CategoryBusinessMapper categoryBusinessMapper;

    @Override
    public List<GoodsCategory> findDistinctGoodsCategoryList(String shopId, String shopEntityId) throws Exception
    {
        if (!StringUtils.hasText(shopId))
        {
            shopId = null;
        }
        if (!StringUtils.hasText(shopEntityId))
        {
            shopEntityId = null;
        }
        return this.categoryBusinessMapper.findDistinctGoodsCategoryList(shopId, shopEntityId);
    }

    @Override
    public List<GoodsCategory> findGoodsCategoryListByLeaf(String shopEntityId, String goodsCategoryRoot, String goodsCategoryLeaf)
    {
        List<GoodsCategory> result = new ArrayList<GoodsCategory>();
        String category = goodsCategoryLeaf;

        while (true)
        {
            GoodsCategoryExample goodsCategoryExample = new GoodsCategoryExample();
            goodsCategoryExample.createCriteria().andIsDelEqualTo("N").andShopEntityIdEqualTo(shopEntityId).andCategoryIdEqualTo(category);
            List<GoodsCategory> categories = this.goodsCategoryGeneratorQueryService.selectByExample(goodsCategoryExample);
            if (categories != null && categories.size() != 0)
            {
                GoodsCategory goodsCategory = categories.get(0);
                result.add(goodsCategory);
                category = goodsCategory.getParentCategoryId();
                if (goodsCategory.getCategoryId().equals(goodsCategoryRoot) || goodsCategory.getParentCategoryId().equals("-1"))
                {
                    break;
                }
            }
            else
            {
                break;
            }
        }

        return result;
    }

    @Override
    public List<GoodsCategory> findDistinctGoodsCategory(String shopId, String shopEntityId, String categoryId, String categoryName, Integer pageIndex, Integer pageSize)
    {
        if (!StringUtils.hasText(shopId))
        {
            return null;
        }
        return this.categoryBusinessMapper.findDistinctGoodsCategory(shopId, shopEntityId, categoryId, categoryName, pageIndex, pageSize);
    }

    @Override
    public int findDistinctGoodsCategoryCount(String shopId, String shopEntityId, String categoryId, String categoryName)
    {
        if (!StringUtils.hasText(shopId))
        {
            return 0;
        }
        return this.categoryBusinessMapper.countDistinctGoodsCategory(shopId, shopEntityId, categoryId, categoryName);
    }
}
