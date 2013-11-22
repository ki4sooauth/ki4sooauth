package com.gooagoo.query.business.user.favorite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.api.business.query.marketing.cache.CouponCacheQueryService;
import com.gooagoo.api.business.query.shop.cache.ShopEntityCacheQueryService;
import com.gooagoo.api.business.query.user.favorite.FavoriteQueryService;
import com.gooagoo.api.generator.query.behave.FavoriteInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsMarketingInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.CouponGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingActivityGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.marketing.IsdeletedInfo;
import com.gooagoo.entity.business.user.FavoriteInfoBusiness;
import com.gooagoo.entity.business.user.FavoriteInfoDetail;
import com.gooagoo.entity.business.user.FavoriteLinkInfoBusiness;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample.Criteria;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfoExample;
import com.gooagoo.entity.generator.shop.ShopInfo;

@Service
public class FavoriteQueryServiceImpl implements FavoriteQueryService
{

    @Autowired
    private FavoriteInfoGeneratorQueryService favoriteInfoGeneratorQueryService;

    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    @Autowired
    private GoodsBaseInfoGeneratorQueryService goodsBaseInfoGeneratorQueryService;

    @Autowired
    private GoodsMarketingInfoGeneratorQueryService goodsMarketingInfoGeneratorQueryService;

    @Autowired
    private CouponGeneratorQueryService couponGeneratorQueryService;

    @Autowired
    private MarketingActivityGeneratorQueryService marketingActivityGeneratorQueryService;

    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityInfoGeneratorQueryService;

    @Autowired
    private CouponCacheQueryService couponCacheQueryService;

    @Autowired
    private GoodsCacheQueryService goodsCacheQueryService;

    @Autowired
    private ShopEntityCacheQueryService shopEntityCacheQueryService;

    @Override
    public FavoriteLinkInfoBusiness findMemberFavorite(String userId, String shopId, String shopEntityId, String cTimeStamp, String favoriteType, String pageId, String pageType, Integer pageIndex, Integer pageSize) throws Exception
    {

        IsdeletedInfo isdeletedInfo = null;//记录被删除的收藏信息，如收藏编号

        //1.封装查询收藏信息的查询条件
        FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
        Criteria criteria = favoriteInfoExample.createCriteria();
        if (StringUtils.hasText(userId))
        {
            criteria.andUserIdEqualTo(userId);
        }

        //当shopId或者shopEntityId有值时查询本店（本商家）收藏
        if (StringUtils.hasText(shopId))
        {
            criteria.andShopIdEqualTo(shopId);
        }
        else if (StringUtils.hasText(shopEntityId))
        {//从实体店信息中取出商家编号
            Map<String, String> shopEntityInfoMap = this.shopEntityCacheQueryService.findShopEntityInfo(shopEntityId);
            if (shopEntityInfoMap == null || shopEntityInfoMap.size() < 0)
            {
                GooagooLog.warn("传入的实体店编号信息有误【shopEntityId=" + shopEntityId + "实体店信息不存在】");
                return null;
            }
            criteria.andShopIdEqualTo(shopEntityInfoMap.get("shopId"));
        }

        if (StringUtils.hasText(favoriteType) && "GAC".contains(favoriteType))
        {
            if ("GAC".contains(favoriteType))
            {
                criteria.andInfoTypeEqualTo(favoriteType);
            }
            else
            {
                GooagooLog.warn("收藏类型信息不正确,类型应该为：A-活动、G-商品、C-优惠凭证【favoriteType=" + favoriteType + "】");
                return null;
            }
        }

        criteria.andIsDelEqualTo("N");
        favoriteInfoExample.setOrderByClause("favorite_id DESC");

        if (pageIndex != null)
        {
            if (StringUtils.hasText(cTimeStamp))
            {
                criteria.andCTimeStampGreaterThan(TimeUtils.convertStringToDate(cTimeStamp));
            }
            favoriteInfoExample.setPage(pageIndex, pageSize);
        }
        else
        {//接口mobb01
            if (StringUtils.hasText(pageId))
            {
                isdeletedInfo = new IsdeletedInfo();
                if ("P".equalsIgnoreCase(pageType))//上一页
                {//新收藏

                    criteria.andFavoriteIdGreaterThan(pageId);
                    //待查询新数据总条数
                    Integer laterInfoNums = this.favoriteInfoGeneratorQueryService.countByExample(favoriteInfoExample);
                    if (laterInfoNums > pageSize)
                    {
                        isdeletedInfo.setFlag("Y");
                    }
                    else
                    {
                        isdeletedInfo.setFlag("N");
                    }
                }
                else if ("N".equalsIgnoreCase(pageType))//下一页
                {//旧收藏
                    criteria.andFavoriteIdLessThan(pageId);
                    isdeletedInfo.setFlag("N");
                }
            }
            if (pageSize != null)
            {
                favoriteInfoExample.setPage(1, pageSize);
            }
        }
        //2.查询收藏信息
        List<FavoriteInfo> favoriteInfoList = this.favoriteInfoGeneratorQueryService.selectByExample(favoriteInfoExample);
        List<FavoriteInfoBusiness> favoriteInfoBusinessList = null;
        if (CollectionUtils.isNotEmpty(favoriteInfoList))
        {
            favoriteInfoBusinessList = new ArrayList<FavoriteInfoBusiness>();
            for (FavoriteInfo favoriteInfo : favoriteInfoList)
            {
                FavoriteInfoBusiness favoriteInfoBusiness = new FavoriteInfoBusiness();
                favoriteInfoBusiness.setFavoriteid(favoriteInfo.getFavoriteId());
                favoriteInfoBusiness.setShopid(favoriteInfo.getShopId());
                favoriteInfoBusiness.setObjectid(favoriteInfo.getObjectId());
                favoriteInfoBusiness.setInfourl(favoriteInfo.getInfoUrl());
                favoriteInfoBusiness.setInfotype(favoriteInfo.getInfoType());
                favoriteInfoBusiness.setInfotitle(favoriteInfo.getInfoTitle());
                favoriteInfoBusiness.setIsdel(favoriteInfo.getIsDel());
                favoriteInfoBusiness.setCtimestamp(TimeUtils.convertDateToString(favoriteInfo.getCTimeStamp(), TimeUtils.FORMAT1));
                //活动
                if (favoriteInfo.getInfoType().equalsIgnoreCase("A"))
                {
                    MarketingActivity marketingActivity = this.marketingActivityGeneratorQueryService.selectUnDelByPrimaryKey(favoriteInfo.getObjectId());
                    if (marketingActivity != null)
                    {
                        favoriteInfoBusiness.setInfobegindate(TimeUtils.convertDateToString(marketingActivity.getStartTime(), TimeUtils.FORMAT1));
                        favoriteInfoBusiness.setInfoenddate(TimeUtils.convertDateToString(marketingActivity.getEndTime(), TimeUtils.FORMAT1));
                        //获取活动小图片
                        favoriteInfoBusiness.setInfopic(UrlUtils.getAttachUrlByImg("s", marketingActivity.getImgUrl()));
                        //是否已过期
                        Date currentTime = new Date();
                        if (currentTime.after(marketingActivity.getEndTime()))
                        {//当前时间在活动结束时间之后，该活动过期
                            favoriteInfoBusiness.setIsoverdate("Y");
                        }
                        else
                        {
                            favoriteInfoBusiness.setIsoverdate("N");
                        }
                    }
                }
                //商品
                else if (favoriteInfo.getInfoType().equalsIgnoreCase("G"))
                {
                    ShopEntityInfoExample shopEntityInfoExample = new ShopEntityInfoExample();
                    shopEntityInfoExample.createCriteria().andShopIdEqualTo(favoriteInfo.getShopId()).andIsGeneralEqualTo("Y").andIsDelEqualTo("N");
                    List<ShopEntityInfo> shopEntityInfoList = this.shopEntityInfoGeneratorQueryService.selectByExample(shopEntityInfoExample);
                    if (CollectionUtils.isNotEmpty(shopEntityInfoList))
                    {
                        ShopEntityInfo shopEntityInfo = shopEntityInfoList.get(0);
                        favoriteInfoBusiness.setShopentityid(shopEntityInfo.getShopEntityId());
                    }

                    Map<String, String> goodsInfoMap = this.goodsCacheQueryService.findGoodsInfo(favoriteInfo.getObjectId());
                    if (goodsInfoMap != null)
                    {
                        //获取商品主图，并生成小图片
                        favoriteInfoBusiness.setPrice(goodsInfoMap.get("price"));
                        if (StringUtils.hasText(goodsInfoMap.get("goodsImg")))
                        {
                            favoriteInfoBusiness.setInfopic(UrlUtils.getAttachUrlByImg("s", JsonUtils.json2List(goodsInfoMap.get("goodsImg")).get(0)));
                        }
                        else
                        {
                            favoriteInfoBusiness.setInfopic("");
                        }

                    }
                }
                //优惠券
                else if (favoriteInfo.getInfoType().equalsIgnoreCase("C"))
                {
                    Map<String, String> couponMap = this.couponCacheQueryService.findCoupon(favoriteInfo.getObjectId());
                    if (couponMap != null && couponMap.size() != 0)
                    {
                        favoriteInfoBusiness.setInfobegindate(couponMap.get("useStartTime"));
                        favoriteInfoBusiness.setInfoenddate(couponMap.get("useEndTime"));
                        //获取优惠凭证小图片
                        favoriteInfoBusiness.setInfopic(UrlUtils.getAttachUrlByImg("s", couponMap.get("couponUrl")));
                        if (favoriteInfo.getUseTime() == null)
                        {
                            favoriteInfoBusiness.setIsused("N");
                        }
                        else
                        {
                            favoriteInfoBusiness.setIsused("Y");
                        }
                        //是否已过期
                        Date currentTime = new Date();
                        couponMap.get("useEndTime");
                        if (StringUtils.hasText(couponMap.get("useStartTime")) && StringUtils.hasText(couponMap.get("useEndTime")))
                        {
                            if (currentTime.after(TimeUtils.convertStringToDate(couponMap.get("useEndTime"))))
                            {
                                favoriteInfoBusiness.setIsoverdate("Y");
                            }
                            else
                            {
                                favoriteInfoBusiness.setIsoverdate("N");
                            }
                        }
                    }
                }
                //设置删除数据的最大时间戳
                if (StringUtils.hasText(pageId) && pageIndex == null)
                {//对应接口mobb01
                    isdeletedInfo.setCtimestamp(TimeUtils.convertDateToString(favoriteInfoList.get(0).getCTimeStamp(), TimeUtils.FORMAT1));
                }
                favoriteInfoBusinessList.add(favoriteInfoBusiness);
            }
        }

        //3.查询删除的收藏信息，如收藏编号
        if (pageIndex == null && StringUtils.hasText(cTimeStamp) && "P".equals(pageType))
        {//有时间戳且未查询新数据时查询已删除的信息
            this.getDelFavoriateInfo(userId, shopId, TimeUtils.convertStringToDate(cTimeStamp), favoriteType, isdeletedInfo);
        }

        //4.封装查询数据
        FavoriteLinkInfoBusiness favoriteLinkInfoBusiness = new FavoriteLinkInfoBusiness();
        favoriteLinkInfoBusiness.setFavoriteInfoBusinessList(favoriteInfoBusinessList);
        favoriteLinkInfoBusiness.setIsdeletedInfo(isdeletedInfo);
        return favoriteLinkInfoBusiness;
    }

    /**
     * 查询删除的收藏信息
     */
    private void getDelFavoriateInfo(String userId, String shopId, Date cTimeStamp, String favoriteType, IsdeletedInfo isdeletedInfo)
    {
        FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
        Criteria criteria = favoriteInfoExample.createCriteria();
        if (StringUtils.hasText(userId))
        {
            criteria.andUserIdEqualTo(userId);
        }
        if (StringUtils.hasText(shopId))
        {
            criteria.andShopIdEqualTo(shopId);
        }
        if (StringUtils.hasText(favoriteType))
        {
            criteria.andInfoTypeEqualTo(favoriteType);
        }
        criteria.andCTimeStampGreaterThan(cTimeStamp);
        criteria.andIsDelEqualTo("Y");
        favoriteInfoExample.setOrderByClause("c_time_stamp DESC");
        List<FavoriteInfo> favoriteInfoList = this.favoriteInfoGeneratorQueryService.selectByExample(favoriteInfoExample);
        if (CollectionUtils.isNotEmpty(favoriteInfoList))
        {
            if (isdeletedInfo == null)
            {
                isdeletedInfo = new IsdeletedInfo();
            }
            String delStr = "";
            for (FavoriteInfo favoriteInfo : favoriteInfoList)
            {
                if ("".equals(delStr))
                {
                    delStr = favoriteInfo.getFavoriteId();
                }
                else
                {
                    delStr = delStr + "," + favoriteInfo.getFavoriteId();
                }
            }
            isdeletedInfo = new IsdeletedInfo();
            isdeletedInfo.setIdstr(delStr);
            isdeletedInfo.setCtimestamp(TimeUtils.convertDateToString(favoriteInfoList.get(0).getCTimeStamp(), TimeUtils.FORMAT1));
        }
    }

    @Override
    public List<FavoriteInfoDetail> findFavoriteList(FavoriteInfoExample favoriteInfoExample) throws Exception
    {
        //1、获取收藏信息
        List<FavoriteInfo> favoriteInfoList = this.favoriteInfoGeneratorQueryService.selectByExample(favoriteInfoExample);
        if (CollectionUtils.isEmpty(favoriteInfoList))
        {
            return null;
        }
        //2、组装返回数据
        List<FavoriteInfoDetail> favoriteInfoDetailList = new ArrayList<FavoriteInfoDetail>();
        for (FavoriteInfo favoriteInfo : favoriteInfoList)
        {
            FavoriteInfoDetail favoriteInfoDetail = new FavoriteInfoDetail();
            favoriteInfoDetail.setFavoriteInfo(favoriteInfo);
            if ("G".equals(favoriteInfo.getInfoType()))
            {
                GoodsBaseInfo goodsBaseInfo = this.goodsBaseInfoGeneratorQueryService.selectByPrimaryKey(favoriteInfo.getObjectId());
                GoodsMarketingInfo goodsMarketingInfo = this.goodsMarketingInfoGeneratorQueryService.selectByPrimaryKey(favoriteInfo.getObjectId());
                favoriteInfoDetail.setGoodsBaseInfo(goodsBaseInfo);
                favoriteInfoDetail.setGoodsMarketingInfo(goodsMarketingInfo);
            }
            else if ("A".equals(favoriteInfo.getInfoType()))
            {
                MarketingActivity marketingActivity = this.marketingActivityGeneratorQueryService.selectByPrimaryKey(favoriteInfo.getObjectId());
                favoriteInfoDetail.setMarketingActivity(marketingActivity);
            }
            else if ("C".equals(favoriteInfo.getInfoType()))
            {
                Coupon coupon = this.couponGeneratorQueryService.selectByPrimaryKey(favoriteInfo.getObjectId());
                favoriteInfoDetail.setCoupon(coupon);
            }
            else
            {
                continue;
            }
            ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectByPrimaryKey(favoriteInfo.getShopId());
            favoriteInfoDetail.setShopInfo(shopInfo);
            favoriteInfoDetailList.add(favoriteInfoDetail);
        }

        return favoriteInfoDetailList;
    }

    @Override
    public int findFavoriteListCount(FavoriteInfoExample favoriteInfoExample) throws Exception
    {
        return this.favoriteInfoGeneratorQueryService.countByExample(favoriteInfoExample);
    }

    @Override
    public boolean isFavorite(String userId, String objectId) throws Exception
    {
        FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
        favoriteInfoExample.createCriteria().andUserIdEqualTo(userId).andObjectIdEqualTo(objectId).andIsDelEqualTo("N");
        return this.favoriteInfoGeneratorQueryService.countByExample(favoriteInfoExample) > 0 ? true : false;
    }

    @Override
    public Integer GetUserUserableCouponNums(String userId, String shopId) throws Exception
    {
        FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
        Criteria criteria = favoriteInfoExample.createCriteria();
        criteria.andUserIdEqualTo(userId).andIsDelEqualTo("N").andCouponStatusEqualTo("0");
        if (StringUtils.hasText(shopId))
        {
            criteria.andShopIdEqualTo(shopId);
        }
        return this.favoriteInfoGeneratorQueryService.countByExample(favoriteInfoExample);
    }

}
