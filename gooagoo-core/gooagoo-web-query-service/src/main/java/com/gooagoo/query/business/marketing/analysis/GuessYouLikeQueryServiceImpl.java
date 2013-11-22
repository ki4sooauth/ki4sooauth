package com.gooagoo.query.business.marketing.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.api.business.query.marketing.analysis.GuessYouLikeQueryService;
import com.gooagoo.api.business.query.marketing.cache.CouponCacheQueryService;
import com.gooagoo.api.generator.query.marketing.CouponGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingActivityGeneratorQueryService;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.entity.business.marketing.analysis.GuessYouLikeActivity;
import com.gooagoo.entity.business.marketing.analysis.GuessYouLikeCoupon;
import com.gooagoo.entity.business.marketing.analysis.GuessYouLikeGoods;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.gmongo.MongoDao;
import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

@Service
public class GuessYouLikeQueryServiceImpl implements GuessYouLikeQueryService
{
    @Autowired
    private GoodsCacheQueryService goodsCacheQueryService;

    @Autowired
    private CouponCacheQueryService couponCacheQueryService;

    @Autowired
    private CouponGeneratorQueryService couponGeneratorQueryService;

    @Autowired
    private MarketingActivityGeneratorQueryService marketingActivityGeneratorQueryService;

    @SuppressWarnings("rawtypes")
    @Override
    public List<GuessYouLikeActivity> guessYouLikeActivity(String userId, Integer pageIndex, Integer pageSize) throws Exception
    {
        List<GuessYouLikeActivity> result = new ArrayList<GuessYouLikeActivity>();
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_RECOMMEND);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        map.put("field", "activityId");
        List<DBObject> list = dao.findByMap(map);
        List subList = null;
        if (list.size() > 0)
        {
            DBObject db = list.get(0);
            ArrayList array = (BasicDBList) db.get("activityId");
            if (array.size() - 1 < pageIndex + pageSize)
            {
                subList = array;
            }
            else
            {
                subList = array.subList(pageIndex, pageIndex + pageSize);
            }
        }
        else
        {
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("userId", "gooagoo");
            map2.put("field", "activityId");
            List<DBObject> list2 = dao.findByMap(map2);
            if (list2.size() > 0)
            {
                DBObject db = list2.get(0);
                ArrayList array = (BasicDBList) db.get("activityId");
                if (array.size() - 1 < pageIndex + pageSize)
                {
                    subList = array;
                }
                else
                {
                    subList = array.subList(pageIndex, pageIndex + pageSize);
                }
            }
        }
        if (subList != null)
        {
            for (int i = 0; i < subList.size(); i++)
            {
                GuessYouLikeActivity like = new GuessYouLikeActivity();
                if (subList.get(i) != null)
                {
                    MarketingActivity activity = this.marketingActivityGeneratorQueryService.selectUnDelByPrimaryKey(subList.get(i).toString());
                    if (activity != null)
                    {
                        if (activity.getActivityId() != null)
                        {
                            like.setActivityId(activity.getActivityId());
                        }
                        if (activity.getActivityName() != null)
                        {
                            like.setActivityName(activity.getActivityName());
                        }
                        if (activity.getImgUrl() != null)
                        {
                            like.setActivityImageUrl(activity.getImgUrl());
                        }
                        if (activity.getShopId() != null)
                        {
                            like.setShopId(activity.getShopId());
                        }
                        result.add(like);
                    }

                }
            }
        }
        return result;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Map<String, List<GuessYouLikeCoupon>> guessYouLikeCoupon(String userId, Integer pageIndex, Integer pageSize) throws Exception
    {
        Map<String, List<GuessYouLikeCoupon>> result = new HashMap<String, List<GuessYouLikeCoupon>>();

        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_RECOMMEND);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        map.put("field", "couponId");
        List<DBObject> list = dao.findByMap(map);
        List subList = null;
        if (list.size() > 0)
        {
            DBObject db = list.get(0);
            ArrayList array = (BasicDBList) db.get("couponId");
            if (array.size() - 1 <= pageSize)
            {
                subList = array;
            }
            else
            {
                subList = array.subList((pageIndex - 1) * pageSize, pageIndex * pageSize);
            }
        }
        else
        {
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("userId", "gooagoo");
            map2.put("field", "couponId");
            List<DBObject> list2 = dao.findByMap(map2);
            if (list2.size() > 0)
            {
                DBObject db = list2.get(0);
                ArrayList array = (BasicDBList) db.get("couponId");
                if (array.size() - 1 < pageSize)
                {
                    subList = array;
                }
                else
                {
                    subList = array.subList((pageIndex - 1) * pageSize, pageIndex * pageSize);
                }
            }
        }
        if (subList != null)
        {
            for (int i = 0; i < subList.size(); i++)
            {
                GuessYouLikeCoupon like = new GuessYouLikeCoupon();
                if (subList.get(i) != null)
                {
                    like.setCouponId(subList.get(i).toString());
                    Map<String, String> coupon = this.couponCacheQueryService.findCoupon(subList.get(i).toString());
                    if (coupon != null)
                    {
                        String couponName = coupon.get("couponName");
                        if (couponName != null)
                        {
                            like.setCouponName(couponName);
                        }
                        String couponImg = coupon.get("couponUrl");
                        if (couponImg != null)
                        {
                            like.setCouponImageUrl(couponImg);
                        }
                        String shopId = coupon.get("shopId");
                        if (shopId != null)
                        {
                            like.setShopId(coupon.get("shopId"));
                        }
                        String shopName = coupon.get("shopName");
                        if (shopName != null)
                        {
                            like.setShopName(coupon.get("shopName"));
                        }
                    }
                }

                //查询优惠凭证渠道
                Coupon coupon2 = this.couponGeneratorQueryService.selectByPrimaryKey(subList.get(i).toString());
                String channle = coupon2.getCouponChannle();
                if (result.get(channle) == null)//如果
                {
                    List<GuessYouLikeCoupon> list4Coupon = new ArrayList<GuessYouLikeCoupon>();
                    list4Coupon.add(like);
                    result.put(channle, list4Coupon);
                }
                else
                {
                    List<GuessYouLikeCoupon> list2 = result.get(channle);
                    list2.add(like);
                    result.put(channle, list2);
                }
            }
        }

        return result;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List<GuessYouLikeGoods> guessYouLikeGoods(String userId, Integer pageIndex, Integer pageSize) throws Exception
    {
        List<GuessYouLikeGoods> result = new ArrayList<GuessYouLikeGoods>();
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_RECOMMEND);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        map.put("field", "goodsId");
        List<DBObject> list = dao.findByMap(map);
        List subList = null;
        if (list.size() > 0)
        {
            DBObject db = list.get(0);
            ArrayList array = (BasicDBList) db.get("goodsId");
            if (array.size() - 1 < pageIndex + pageSize)
            {
                subList = array;
            }
            else
            {
                subList = array.subList(pageIndex, pageIndex + pageSize);
            }
        }
        else
        {
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("userId", "gooagoo");
            map2.put("field", "goodsId");
            List<DBObject> list2 = dao.findByMap(map2);
            if (list2.size() > 0)
            {
                DBObject db = list2.get(0);
                ArrayList array = (BasicDBList) db.get("goodsId");
                if (array.size() - 1 < pageIndex + pageSize)
                {
                    subList = array;
                }
                else
                {
                    subList = array.subList(pageIndex, pageIndex + pageSize);
                }
            }
        }
        if (subList != null)
        {
            for (int i = 0; i < subList.size(); i++)
            {
                GuessYouLikeGoods like = new GuessYouLikeGoods();
                if (subList.get(i) != null)
                {
                    like.setGoodsId(subList.get(i).toString());
                    Map<String, String> goodsInfo = this.goodsCacheQueryService.findGoodsInfo(subList.get(i).toString());
                    if (goodsInfo != null)
                    {
                        String goodsName = goodsInfo.get("goodsName");
                        if (goodsName != null)
                        {
                            like.setGoodsName(goodsName);
                        }
                        String goodsImg = goodsInfo.get("goodsImg");
                        if (goodsImg != null)
                        {
                            like.setGoodsImageUrl(goodsImg);
                        }
                        String shopId = goodsInfo.get("shopId");
                        if (shopId != null)
                        {
                            like.setShopId(shopId);
                        }
                        String shopName = goodsInfo.get("shopName");
                        if (shopName != null)
                        {
                            like.setShopName(shopName);
                        }
                    }
                    result.add(like);
                }
            }
        }

        return result;
    }
}
