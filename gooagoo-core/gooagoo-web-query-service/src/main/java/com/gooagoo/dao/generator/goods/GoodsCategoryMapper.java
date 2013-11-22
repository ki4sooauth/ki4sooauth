package com.gooagoo.dao.generator.goods;

import java.util.List;

import com.gooagoo.entity.generator.goods.GoodsCategory;
import com.gooagoo.entity.generator.goods.GoodsCategoryExample;
import com.gooagoo.entity.generator.goods.GoodsCategoryKey;

public interface GoodsCategoryMapper
{

    public Integer countByExample(GoodsCategoryExample goodsCategoryExample);

    public List<GoodsCategory> selectByExample(GoodsCategoryExample goodsCategoryExample);

    public GoodsCategory selectByPrimaryKey(GoodsCategoryKey goodsCategoryKey);

}
