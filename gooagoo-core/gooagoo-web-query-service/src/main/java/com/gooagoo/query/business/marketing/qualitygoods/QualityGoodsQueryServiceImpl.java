package com.gooagoo.query.business.marketing.qualitygoods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.api.business.query.marketing.qualitygoods.QualityGoodsQueryService;
import com.gooagoo.api.business.query.shop.cache.ShopCacheQueryService;
import com.gooagoo.api.business.query.statistics.MemberStatisticQueryService;
import com.gooagoo.api.generator.query.behave.FavoriteInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingQualityGoodsGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.marketing.QualityGoodsBusiness;
import com.gooagoo.entity.business.marketing.QualityGoodsForPlace;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample;
import com.gooagoo.entity.generator.marketing.MarketingQualityGoods;
import com.gooagoo.entity.generator.marketing.MarketingQualityGoodsExample;
import com.gooagoo.entity.generator.marketing.MarketingQualityGoodsExample.Criteria;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;

@Service
public class QualityGoodsQueryServiceImpl implements QualityGoodsQueryService
{

    @Autowired
    private MarketingQualityGoodsGeneratorQueryService marketingQualityGoodsGeneratorQueryService;

    @Autowired
    private GoodsBaseInfoGeneratorQueryService goodsBaseInfoGeneratorQueryService;

    @Autowired
    private MemberCardGeneratorQueryService memberCardGeneratorQueryService;

    @Autowired
    private FavoriteInfoGeneratorQueryService favoriteInfoGeneratorQueryService;

    @Autowired
    private GoodsCacheQueryService goodsCacheQueryService;

    @Autowired
    private MemberStatisticQueryService memberStatisticQueryService;

    @Autowired
    private ShopCacheQueryService shopCacheQueryService;

    @Override
    public QualityGoodsForPlace findQualityGoodsForPlace(String userId, String shopId, String keyword, Integer pageIndex, Integer pageSize) throws Exception
    {
        QualityGoodsForPlace qualityGoodsForPlace = null;
        MarketingQualityGoodsExample marketingQualityGoodsExample = new MarketingQualityGoodsExample();
        Criteria criteria = marketingQualityGoodsExample.createCriteria();
        if (StringUtils.hasText(keyword))
        {
            GoodsBaseInfoExample goodsBaseInfoExample = new GoodsBaseInfoExample();
            goodsBaseInfoExample.createCriteria().andShopIdEqualTo(shopId).andGoodsNameLike("%" + keyword + "%").andIsDelEqualTo("N");
            List<GoodsBaseInfo> goodsBaseInfoList = this.goodsBaseInfoGeneratorQueryService.selectByExample(goodsBaseInfoExample);
            if (CollectionUtils.isNotEmpty(goodsBaseInfoList))
            {
                List<String> goodsIdList = new ArrayList<String>();
                for (GoodsBaseInfo goodsBaseInfo : goodsBaseInfoList)
                {
                    goodsIdList.add(goodsBaseInfo.getGoodsId());
                }
                criteria.andGoodsIdIn(goodsIdList);
            }
        }
        criteria.andShopIdEqualTo(shopId).andIsDelEqualTo("N");

        if (pageSize != -1)
        {//当pageindex=1，pagesize=-1时，不分页
            marketingQualityGoodsExample.setPage(pageIndex, pageSize);
        }

        List<MarketingQualityGoods> marketingQualityGoodsList = this.marketingQualityGoodsGeneratorQueryService.selectByExample(marketingQualityGoodsExample);
        if (CollectionUtils.isNotEmpty(marketingQualityGoodsList))
        {
            qualityGoodsForPlace = new QualityGoodsForPlace();
            //查询商家信息
            Map<String, String> shopInfoMap = this.shopCacheQueryService.findShopInfo(shopId);
            qualityGoodsForPlace.setShopid(shopId);
            qualityGoodsForPlace.setShopName(shopInfoMap.get("shopName"));
            qualityGoodsForPlace.setLogo1(shopInfoMap.get("logo1"));
            qualityGoodsForPlace.setLogo2(shopInfoMap.get("logo2"));
            //查询商家会员卡信息
            MemberCardExample memberCardExample = new MemberCardExample();
            memberCardExample.createCriteria().andShopIdEqualTo(shopId).andCardLvlEqualTo("1").andIsDelEqualTo("N");
            List<MemberCard> memberCardList = this.memberCardGeneratorQueryService.selectByExample(memberCardExample);
            if (CollectionUtils.isNotEmpty(memberCardList))
            {
                qualityGoodsForPlace.setCardheaderurl(UrlUtils.getAttachUrlByImg("dh_top", memberCardList.get(0).getCardUrl()));//会员卡卡头url
            }
            Integer attentionnum = this.memberStatisticQueryService.countAttention(shopId, "A");
            Integer membernum = this.memberStatisticQueryService.countMember(shopId);
            //关注数量
            qualityGoodsForPlace.setAttentionnum(attentionnum.toString());
            //会员数量
            qualityGoodsForPlace.setMembernum(membernum.toString());
            //精品数量
            marketingQualityGoodsExample = new MarketingQualityGoodsExample();
            marketingQualityGoodsExample.createCriteria().andShopIdEqualTo(shopId).andIsDelEqualTo("N");
            qualityGoodsForPlace.setNum(this.marketingQualityGoodsGeneratorQueryService.countByExample(marketingQualityGoodsExample).toString());
            List<QualityGoodsBusiness> qualityGoodsBusinessList = new ArrayList<QualityGoodsBusiness>();
            for (MarketingQualityGoods marketingQualityGoods : marketingQualityGoodsList)
            {
                Map<String, String> goodsInfoMap = this.goodsCacheQueryService.findGoodsInfo(marketingQualityGoods.getGoodsId());
                if (goodsInfoMap != null && goodsInfoMap.size() > 0)
                {
                    QualityGoodsBusiness qualityGoodsBusiness = new QualityGoodsBusiness();
                    qualityGoodsBusiness.setGoodsId(marketingQualityGoods.getGoodsId());
                    qualityGoodsBusiness.setGoodsName(goodsInfoMap.get("goodsName"));
                    qualityGoodsBusiness.setGoodsImg(StringUtils.hasText(goodsInfoMap.get("goodsImg")) ? JsonUtils.json2List(goodsInfoMap.get("goodsImg")).get(0) : "");
                    qualityGoodsBusiness.setFavnums(this.getFavnums(null, marketingQualityGoods.getGoodsId()).toString());
                    if (StringUtils.hasText(userId))
                    {
                        qualityGoodsBusiness.setIsfav(this.getFavnums(userId, marketingQualityGoods.getGoodsId()) > 0 ? "Y" : "N");
                    }
                    else
                    {
                        qualityGoodsBusiness.setIsfav("N");
                    }
                    qualityGoodsBusinessList.add(qualityGoodsBusiness);
                }
            }
            qualityGoodsForPlace.setQualityGoodsBusinessList(qualityGoodsBusinessList);
        }
        return qualityGoodsForPlace;
    }

    /**
     *  获取收藏次数
     */
    private Integer getFavnums(String userId, String objectId)
    {
        FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
        com.gooagoo.entity.generator.behave.FavoriteInfoExample.Criteria criteria = favoriteInfoExample.createCriteria();
        if (StringUtils.hasText(userId))
        {
            criteria.andUserIdEqualTo(userId);
        }
        criteria.andObjectIdEqualTo(objectId).andIsDelEqualTo("N");
        return this.favoriteInfoGeneratorQueryService.countByExample(favoriteInfoExample);
    }
}
