package com.gooagoo.query.generator.goods.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.goods.GoodsMarketingInfoGeneratorQueryService;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfoExample;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfoKey;
import com.gooagoo.dao.generator.goods.GoodsMarketingInfoMapper;

@Service
public class GoodsMarketingInfoGeneratorQueryServiceImpl implements GoodsMarketingInfoGeneratorQueryService
{

    @Autowired
    private GoodsMarketingInfoMapper goodsMarketingInfoMapper;

    @Override
    public Integer countByExample(GoodsMarketingInfoExample goodsMarketingInfoExample) 
    {
        return this.goodsMarketingInfoMapper.countByExample(goodsMarketingInfoExample);
    }

    @Override
    public List<GoodsMarketingInfo> selectByExample(GoodsMarketingInfoExample goodsMarketingInfoExample) 
    {
        return this.goodsMarketingInfoMapper.selectByExample(goodsMarketingInfoExample);
    }

    @Override
    public GoodsMarketingInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        GoodsMarketingInfoKey goodsMarketingInfoKey = new GoodsMarketingInfoKey();
        goodsMarketingInfoKey.setIsDel("N");
        goodsMarketingInfoKey.setGoodsId(primaryKey);
        return this.goodsMarketingInfoMapper.selectByPrimaryKey(goodsMarketingInfoKey);
    }

    @Override
    public GoodsMarketingInfo selectByPrimaryKey(String primaryKey) 
    {
        GoodsMarketingInfoKey goodsMarketingInfoKey = new GoodsMarketingInfoKey();
        goodsMarketingInfoKey.setGoodsId(primaryKey);
        return this.goodsMarketingInfoMapper.selectByPrimaryKey(goodsMarketingInfoKey);
    }

}
