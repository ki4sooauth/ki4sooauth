package com.gooagoo.dao.generator.goods;

import java.util.List;

import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfoExample;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfoKey;

public interface GoodsMarketingInfoMapper
{

    public Integer countByExample(GoodsMarketingInfoExample goodsMarketingInfoExample);

    public List<GoodsMarketingInfo> selectByExample(GoodsMarketingInfoExample goodsMarketingInfoExample);

    public GoodsMarketingInfo selectByPrimaryKey(GoodsMarketingInfoKey goodsMarketingInfoKey);

}
