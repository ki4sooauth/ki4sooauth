package com.gooagoo.dao.generator.goods;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.goods.GoodsBrand;
import com.gooagoo.entity.generator.goods.GoodsBrandExample;
import com.gooagoo.entity.generator.goods.GoodsBrandKey;

public interface GoodsBrandMapper
{

    public Integer countByExample(GoodsBrandExample goodsBrandExample);

    public List<GoodsBrand> selectByExample(GoodsBrandExample goodsBrandExample);

    public GoodsBrand selectByPrimaryKey(GoodsBrandKey goodsBrandKey);

    public Integer deleteByExample(GoodsBrandExample goodsBrandExample);

    public Integer deleteByPrimaryKey(GoodsBrandKey goodsBrandKey);

    public Integer insertSelective(GoodsBrand goodsBrand);

    public Integer updateAllByExample(@Param("record") GoodsBrand goodsBrand, @Param("example") GoodsBrandExample goodsBrandExample);

    public Integer updateByExampleSelective(@Param("record") GoodsBrand goodsBrand, @Param("example") GoodsBrandExample goodsBrandExample);

    public Integer updateByPrimaryKeySelective(GoodsBrand goodsBrand);

}
