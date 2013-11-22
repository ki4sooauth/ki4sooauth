package com.gooagoo.query.business.marketing.recommend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.api.business.query.marketing.cache.CouponCacheQueryService;
import com.gooagoo.api.business.query.marketing.recommend.RecommendQueryService;
import com.gooagoo.api.business.query.member.cache.MemberCacheQueryService;
import com.gooagoo.api.business.query.shop.cache.ShopCacheQueryService;
import com.gooagoo.api.business.query.statistics.MemberStatisticQueryService;
import com.gooagoo.api.business.query.statistics.TableStatisticQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingActivityGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.NominateActivityGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.NominateCouponGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.NominateGoodsGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.NominateShopGeneratorQueryService;
import com.gooagoo.api.protecteds.query.shop.ShopProtectedQueryService;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.dao.business.sys.nominate.NominateShopAdapterMapper;
import com.gooagoo.entity.business.marketing.recommend.RecommendBusiness;
import com.gooagoo.entity.business.marketing.recommend.RecommendShop;
import com.gooagoo.entity.business.system.nominate.NominateShopBusiness;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.entity.generator.sys.NominateActivity;
import com.gooagoo.entity.generator.sys.NominateActivityExample;
import com.gooagoo.entity.generator.sys.NominateCoupon;
import com.gooagoo.entity.generator.sys.NominateCouponExample;
import com.gooagoo.entity.generator.sys.NominateGoods;
import com.gooagoo.entity.generator.sys.NominateGoodsExample;

@Service
public class RecommendQueryServiceImpl implements RecommendQueryService
{

    @Autowired
    private NominateGoodsGeneratorQueryService nominateGoodsGeneratorQueryService;
    @Autowired
    private NominateCouponGeneratorQueryService nominateCouponGeneratorQueryService;
    @Autowired
    private NominateActivityGeneratorQueryService nominateActivityGeneratorQueryService;
    @Autowired
    private NominateShopGeneratorQueryService nominateShopGeneratorQueryService;
    @Autowired
    private MemberCacheQueryService memberCacheQueryService;
    @Autowired
    private MemberStatisticQueryService memberStatisticQueryService;
    @Autowired
    private ShopProtectedQueryService shopProtectedQueryService;
    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;
    @Autowired
    private TableStatisticQueryService tableStatisticQueryService;
    @Autowired
    private MemberCardGeneratorQueryService memberCardGeneratorQueryService;
    @Autowired
    private ShopCacheQueryService shopCacheQueryService;
    @Autowired
    private GoodsCacheQueryService goodsCacheQueryService;
    @Autowired
    private CouponCacheQueryService couponCacheQueryService;
    @Autowired
    private MarketingActivityGeneratorQueryService marketingActivityGeneratorQueryService;
    @Autowired
    private NominateShopAdapterMapper nominateShopAdapterMapper;

    @Override
    public List<RecommendBusiness> recommendGoods(String userId, Integer pageIndex, Integer pageSize) throws Exception
    {
        Date currentTime = new Date();
        NominateGoodsExample queryCondition = new NominateGoodsExample();
        queryCondition.createCriteria().andStartTimeLessThanOrEqualTo(currentTime).andEndTimeGreaterThanOrEqualTo(currentTime).andIsDelEqualTo("N");

        if (pageIndex != null && pageSize != null)
        {
            queryCondition.setPage(pageIndex, pageSize);
        }
        queryCondition.setOrderByClause("c_time_stamp DESC");
        List<NominateGoods> nominateGoodsList = this.nominateGoodsGeneratorQueryService.selectByExample(queryCondition);
        List<RecommendBusiness> recommendBusinessList = null;
        if (!CollectionUtils.isEmpty(nominateGoodsList))
        {//有推荐商品信息
            recommendBusinessList = new ArrayList<RecommendBusiness>();
            for (NominateGoods nominateGoods : nominateGoodsList)
            {
                //商家基本信息,从缓存中取
                Map<String, String> shopMap = this.shopCacheQueryService.findShopInfo(nominateGoods.getShopId());
                //商品基本信息,从缓存中取
                Map<String, String> goodsMap = this.goodsCacheQueryService.findGoodsInfo(nominateGoods.getGoodsId());
                if (goodsMap == null)
                {
                    continue;
                }
                RecommendBusiness recommendBusiness = new RecommendBusiness();
                recommendBusiness.setShopid(nominateGoods.getShopId());
                recommendBusiness.setShopname(shopMap.get("shopName"));
                recommendBusiness.setLogo(shopMap.get("logo1"));
                recommendBusiness.setInfoId(nominateGoods.getGoodsId());
                recommendBusiness.setInfotype("G");
                recommendBusiness.setRemark("");//备注，暂时没有该字段
                recommendBusiness.setInfoImgUrl(StringUtils.isNotBlank(goodsMap.get("goodsImg")) ? JsonUtils.json2List(goodsMap.get("goodsImg")).get(0) : "");
                recommendBusiness.setInfotitle(goodsMap.get("goodsName"));
                recommendBusiness.setPrice(goodsMap.get("price"));
                if (goodsMap.get("goodsImg") != null)
                {//取出商品图片主图,并转换成商品小图片url
                    recommendBusiness.setInfopic(UrlUtils.getAttachUrlByImg("s", JsonUtils.json2List(goodsMap.get("goodsImg")).get(0)));
                }
                recommendBusiness.setIsdel(nominateGoods.getIsDel());
                recommendBusiness.setCtimestamp(TimeUtils.convertDateToString(nominateGoods.getCTimeStamp(), TimeUtils.FORMAT1));
                recommendBusinessList.add(recommendBusiness);
            }
        }
        return recommendBusinessList;
    }

    @Override
    public List<RecommendBusiness> recommendCoupon(String userId, Integer pageIndex, Integer pageSize) throws Exception
    {
        Date currentTime = new Date();
        NominateCouponExample queryCondition = new NominateCouponExample();
        queryCondition.createCriteria().andStartTimeLessThanOrEqualTo(currentTime).andEndTimeGreaterThanOrEqualTo(currentTime);
        if (pageIndex != null && pageSize != null)
        {
            queryCondition.setPage(pageIndex, pageSize);
        }
        queryCondition.setOrderByClause("c_time_stamp DESC");
        List<NominateCoupon> nominateCouponList = this.nominateCouponGeneratorQueryService.selectByExample(queryCondition);
        List<RecommendBusiness> recommendBusinessList = null;
        if (!CollectionUtils.isEmpty(nominateCouponList))
        {//有推荐优惠券
            recommendBusinessList = new ArrayList<RecommendBusiness>();
            for (NominateCoupon nominateCoupon : nominateCouponList)
            {
                //商家基本信息,从缓存中取
                Map<String, String> shopMap = this.shopCacheQueryService.findShopInfo(nominateCoupon.getShopId());
                //优惠券基本信息,从缓存中取
                Map<String, String> couponMap = this.couponCacheQueryService.findCoupon(nominateCoupon.getCouponId());
                RecommendBusiness recommendBusiness = new RecommendBusiness();
                recommendBusiness.setShopid(nominateCoupon.getShopId());
                recommendBusiness.setShopname(shopMap.get("shopName"));
                recommendBusiness.setLogo(shopMap.get("logo1"));
                recommendBusiness.setInfoImgUrl(couponMap.get("couponUrl"));
                recommendBusiness.setInfoId(nominateCoupon.getCouponId());
                recommendBusiness.setInfotype("C");
                recommendBusiness.setRemark("");//备注，暂时没有该字段
                recommendBusiness.setInfotitle(couponMap.get("couponName"));
                recommendBusiness.setInfobegindate(couponMap.get("useStartTime"));
                recommendBusiness.setInfoenddate(couponMap.get("useEndTime"));
                //生成优惠券小图片
                if (couponMap.get("couponUrl") != null)
                {
                    recommendBusiness.setInfopic(UrlUtils.getAttachUrlByImg("s", couponMap.get("couponUrl")));
                }

                recommendBusiness.setIsdel(nominateCoupon.getIsDel());
                recommendBusiness.setCtimestamp(TimeUtils.convertDateToString(nominateCoupon.getCTimeStamp(), TimeUtils.FORMAT1));
                recommendBusinessList.add(recommendBusiness);
            }
        }
        return recommendBusinessList;
    }

    @Override
    public List<RecommendBusiness> recommendActivity(String userId, Integer pageIndex, Integer pageSize) throws Exception
    {
        Date currentTime = new Date();
        NominateActivityExample queryCondition = new NominateActivityExample();
        queryCondition.createCriteria().andStartTimeLessThanOrEqualTo(currentTime).andEndTimeGreaterThanOrEqualTo(currentTime).andIsDelEqualTo("N");
        if (pageIndex != null && pageSize != null)
        {
            queryCondition.setPage(pageIndex, pageSize);
        }
        queryCondition.setOrderByClause("c_time_stamp DESC");
        List<NominateActivity> nominateActivityList = this.nominateActivityGeneratorQueryService.selectByExample(queryCondition);
        List<RecommendBusiness> recommendBusinessList = null;
        if (!CollectionUtils.isEmpty(nominateActivityList))
        {//有推荐优惠券
            recommendBusinessList = new ArrayList<RecommendBusiness>();
            for (NominateActivity nominateActivity : nominateActivityList)
            {

                //商家基本信息,从缓存中取
                Map<String, String> shopMap = this.shopCacheQueryService.findShopInfo(nominateActivity.getShopId());
                //查询优惠券基本信息
                MarketingActivity marketingActivity = this.marketingActivityGeneratorQueryService.selectByPrimaryKey(nominateActivity.getActivityId());

                RecommendBusiness recommendBusiness = new RecommendBusiness();
                recommendBusiness.setShopid(nominateActivity.getShopId());
                recommendBusiness.setShopname(shopMap.get("shopName"));
                recommendBusiness.setLogo(shopMap.get("logo1"));
                recommendBusiness.setInfoImgUrl(marketingActivity.getImgUrl());
                recommendBusiness.setInfoId(nominateActivity.getActivityId());
                recommendBusiness.setInfotype("A");
                recommendBusiness.setRemark("");//备注，暂时没有该字段
                recommendBusiness.setInfotitle(marketingActivity.getTitle());
                recommendBusiness.setInfobegindate(TimeUtils.convertDateToString(marketingActivity.getStartTime(), TimeUtils.FORMAT1));
                recommendBusiness.setInfoenddate(TimeUtils.convertDateToString(marketingActivity.getEndTime(), TimeUtils.FORMAT1));
                //生成活动小图片
                if (marketingActivity.getImgUrl() != null)
                {
                    recommendBusiness.setInfopic(UrlUtils.getAttachUrlByImg("s", marketingActivity.getImgUrl()));
                }

                recommendBusiness.setIsdel(nominateActivity.getIsDel());
                recommendBusiness.setCtimestamp(TimeUtils.convertDateToString(nominateActivity.getCTimeStamp(), TimeUtils.FORMAT1));
                recommendBusinessList.add(recommendBusiness);
            }
        }
        return recommendBusinessList;
    }

    @Override
    public List<RecommendShop> recommendShop(String userId, Integer pageIndex, Integer pageSize) throws Exception
    {

        if (pageIndex != null && pageSize != null && pageSize != -1)
        {
            pageIndex = (pageIndex - 1) * pageSize;
        }
        List<NominateShopBusiness> nominateShopList = this.nominateShopAdapterMapper.findPlatformNominateShopList(userId, pageIndex, pageSize);
        if (CollectionUtils.isEmpty(nominateShopList))
        {
            return null;
        }
        //2、组装返回数据
        List<RecommendShop> recommendShopList = new ArrayList<RecommendShop>();
        for (NominateShopBusiness nominateShopBusiness : nominateShopList)
        {
            //2.3、获取商家关注人数、会员人数
            String attentionNum = this.memberStatisticQueryService.countAttention(nominateShopBusiness.getShopId(), "A").toString();
            String memberNum = this.memberStatisticQueryService.countMember(nominateShopBusiness.getShopId()).toString();
            //2.4、获取满座率
            String shopPopularity = null;
            if ("1".equals(nominateShopBusiness.getShopTypeRoot()))
            {
                String shopEntityId = this.shopProtectedQueryService.getShopEntity(nominateShopBusiness.getShopId(), null);
                if (StringUtils.isNotBlank(shopEntityId))
                {
                    shopPopularity = this.tableStatisticQueryService.findTableAttendance(shopEntityId);//满座率
                }
            }
            //2.5、组装数据
            RecommendShop recommendShop = new RecommendShop();
            recommendShop.setShopId(nominateShopBusiness.getShopId());
            recommendShop.setShopName(nominateShopBusiness.getShopName());
            recommendShop.setShopLogo(nominateShopBusiness.getLogo1());
            recommendShop.setColor(nominateShopBusiness.getColor());
            if (StringUtils.isNotBlank(attentionNum))
            {
                recommendShop.setAttentionNum(Integer.valueOf(attentionNum));
            }
            if (StringUtils.isNotBlank(memberNum))
            {
                recommendShop.setMemberNum(Integer.valueOf(memberNum));
            }
            recommendShop.setFullRate(shopPopularity);
            //2.6、获取关注、基础、已发布的商家卡
            List<String> cardLvlList = new ArrayList<String>();
            cardLvlList.add("0");
            cardLvlList.add("1");
            MemberCardExample queryCondition2 = new MemberCardExample();
            queryCondition2.createCriteria().andShopIdEqualTo(nominateShopBusiness.getShopId()).andCardLvlIn(cardLvlList).andPublishStatusEqualTo("P").andIsDelEqualTo("N");
            List<MemberCard> memberCardList = this.memberCardGeneratorQueryService.selectByExample(queryCondition2);
            if (!CollectionUtils.isEmpty(memberCardList))
            {
                for (MemberCard memberCard : memberCardList)
                {
                    if ("0".equals(memberCard.getCardLvl()))
                    {
                        recommendShop.setAttentionCardName(memberCard.getCardName());
                        recommendShop.setAttentionCardUrl(memberCard.getCardUrl());
                    }
                    else if ("1".equals(memberCard.getCardLvl()))
                    {
                        recommendShop.setMemberCardName(memberCard.getCardName());
                        recommendShop.setMemberCardUrl(memberCard.getCardUrl());
                    }
                }
            }
            recommendShopList.add(recommendShop);
        }

        return recommendShopList;
    }
}
