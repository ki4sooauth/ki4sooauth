package com.gooagoo.dao.generator.goods;

import java.util.List;

import com.gooagoo.entity.generator.goods.GoodsBrand;
import com.gooagoo.entity.generator.goods.GoodsBrandExample;
import com.gooagoo.entity.generator.goods.GoodsBrandKey;

public interface GoodsBrandMapper
{

    public Integer countByExample(GoodsBrandExample goodsBrandExample);

    public List<GoodsBrand> selectByExample(GoodsBrandExample goodsBrandExample);

    public GoodsBrand selectByPrimaryKey(GoodsBrandKey goodsBrandKey);

}
