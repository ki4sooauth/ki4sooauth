package com.gooagoo.query.business.goods.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.goods.query.ShopGoodsQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsFeatureInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsMarketingInfoGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.goods.ShopGoodsDetailInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfo;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfoExample;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;

@Service
public class ShopGoodsQueryServiceImpl implements ShopGoodsQueryService
{
    @Autowired
    private GoodsBaseInfoGeneratorQueryService goodsBaseInfoGeneratorQueryService;
    @Autowired
    private GoodsFeatureInfoGeneratorQueryService goodsFeatureInfoGeneratorQueryService;
    @Autowired
    private GoodsMarketingInfoGeneratorQueryService goodsMarketingInfoGeneratorQueryService;

    @Override
    public ShopGoodsDetailInfo findGoodsDetail(String goodsId) throws Exception
    {
        if (!StringUtils.hasText(goodsId))
        {
            GooagooLog.warn("查询商品详情：主键为空");
            return null;
        }
        //查询商品基本信息
        GoodsBaseInfo goodsBaseInfo = this.goodsBaseInfoGeneratorQueryService.selectByPrimaryKey(goodsId);
        if (goodsBaseInfo == null)
        {
            GooagooLog.warn("查询商品详情：商品基本信息为空,goodsId=" + goodsId);
            return null;
        }
        //查询商品特征信息
        GoodsFeatureInfoExample goodsFeatureInfoExample = new GoodsFeatureInfoExample();
        goodsFeatureInfoExample.createCriteria().andGoodsIdEqualTo(goodsId).andIsDelEqualTo("N");
        List<GoodsFeatureInfo> goodsFeatureInfoList = this.goodsFeatureInfoGeneratorQueryService.selectByExample(goodsFeatureInfoExample);

        //查询商品营销信息
        GoodsMarketingInfo goodsMarketingInfo = this.goodsMarketingInfoGeneratorQueryService.selectByPrimaryKey(goodsId);

        ShopGoodsDetailInfo goodsDetailInfo = new ShopGoodsDetailInfo();
        goodsDetailInfo.setGoodsBaseInfo(goodsBaseInfo);
        goodsDetailInfo.setGoodsFeatureInfoList(goodsFeatureInfoList);
        goodsDetailInfo.setGoodsMarketingInfo(goodsMarketingInfo);

        return goodsDetailInfo;
    }

}
