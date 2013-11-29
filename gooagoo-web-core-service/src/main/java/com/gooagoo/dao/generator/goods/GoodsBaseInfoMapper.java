package com.gooagoo.dao.generator.goods;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoKey;

public interface GoodsBaseInfoMapper
{

    public Integer countByExample(GoodsBaseInfoExample goodsBaseInfoExample);

    public List<GoodsBaseInfo> selectByExample(GoodsBaseInfoExample goodsBaseInfoExample);

    public GoodsBaseInfo selectByPrimaryKey(GoodsBaseInfoKey goodsBaseInfoKey);

    public Integer deleteByExample(GoodsBaseInfoExample goodsBaseInfoExample);

    public Integer deleteByPrimaryKey(GoodsBaseInfoKey goodsBaseInfoKey);

    public Integer insertSelective(GoodsBaseInfo goodsBaseInfo);

    public Integer updateAllByExample(@Param("record") GoodsBaseInfo goodsBaseInfo, @Param("example") GoodsBaseInfoExample goodsBaseInfoExample);

    public Integer updateByExampleSelective(@Param("record") GoodsBaseInfo goodsBaseInfo, @Param("example") GoodsBaseInfoExample goodsBaseInfoExample);

    public Integer updateByPrimaryKeySelective(GoodsBaseInfo goodsBaseInfo);

}
