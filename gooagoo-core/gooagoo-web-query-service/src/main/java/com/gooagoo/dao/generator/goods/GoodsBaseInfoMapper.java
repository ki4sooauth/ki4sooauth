package com.gooagoo.dao.generator.goods;

import java.util.List;

import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoKey;

public interface GoodsBaseInfoMapper
{

    public Integer countByExample(GoodsBaseInfoExample goodsBaseInfoExample);

    public List<GoodsBaseInfo> selectByExample(GoodsBaseInfoExample goodsBaseInfoExample);

    public GoodsBaseInfo selectByPrimaryKey(GoodsBaseInfoKey goodsBaseInfoKey);

}
