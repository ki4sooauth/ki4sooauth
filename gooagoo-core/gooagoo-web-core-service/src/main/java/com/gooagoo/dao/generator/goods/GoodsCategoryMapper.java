package com.gooagoo.dao.generator.goods;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.goods.GoodsCategory;
import com.gooagoo.entity.generator.goods.GoodsCategoryExample;
import com.gooagoo.entity.generator.goods.GoodsCategoryKey;

public interface GoodsCategoryMapper
{

    public Integer countByExample(GoodsCategoryExample goodsCategoryExample);

    public List<GoodsCategory> selectByExample(GoodsCategoryExample goodsCategoryExample);

    public GoodsCategory selectByPrimaryKey(GoodsCategoryKey goodsCategoryKey);

    public Integer deleteByExample(GoodsCategoryExample goodsCategoryExample);

    public Integer deleteByPrimaryKey(GoodsCategoryKey goodsCategoryKey);

    public Integer insertSelective(GoodsCategory goodsCategory);

    public Integer updateAllByExample(@Param("record") GoodsCategory goodsCategory, @Param("example") GoodsCategoryExample goodsCategoryExample);

    public Integer updateByExampleSelective(@Param("record") GoodsCategory goodsCategory, @Param("example") GoodsCategoryExample goodsCategoryExample);

    public Integer updateByPrimaryKeySelective(GoodsCategory goodsCategory);

}
