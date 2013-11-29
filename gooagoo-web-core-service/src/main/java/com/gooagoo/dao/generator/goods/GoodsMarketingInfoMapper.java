package com.gooagoo.dao.generator.goods;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfoExample;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfoKey;

public interface GoodsMarketingInfoMapper
{

    public Integer countByExample(GoodsMarketingInfoExample goodsMarketingInfoExample);

    public List<GoodsMarketingInfo> selectByExample(GoodsMarketingInfoExample goodsMarketingInfoExample);

    public GoodsMarketingInfo selectByPrimaryKey(GoodsMarketingInfoKey goodsMarketingInfoKey);

    public Integer deleteByExample(GoodsMarketingInfoExample goodsMarketingInfoExample);

    public Integer deleteByPrimaryKey(GoodsMarketingInfoKey goodsMarketingInfoKey);

    public Integer insertSelective(GoodsMarketingInfo goodsMarketingInfo);

    public Integer updateAllByExample(@Param("record") GoodsMarketingInfo goodsMarketingInfo, @Param("example") GoodsMarketingInfoExample goodsMarketingInfoExample);

    public Integer updateByExampleSelective(@Param("record") GoodsMarketingInfo goodsMarketingInfo, @Param("example") GoodsMarketingInfoExample goodsMarketingInfoExample);

    public Integer updateByPrimaryKeySelective(GoodsMarketingInfo goodsMarketingInfo);

}
