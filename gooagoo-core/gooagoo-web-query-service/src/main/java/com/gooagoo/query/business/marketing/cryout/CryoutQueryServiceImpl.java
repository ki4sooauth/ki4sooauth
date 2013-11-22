package com.gooagoo.query.business.marketing.cryout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.marketing.cryout.CryoutQueryService;
import com.gooagoo.api.business.query.shop.cache.ShopCacheQueryService;
import com.gooagoo.api.generator.query.goods.GoodsMarketingInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.CouponGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.CryoutInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingActivityGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingItemLinkGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingUserLinkGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.protecteds.query.shop.ShopProtectedQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.dao.business.marketing.cryout.CryoutInfoAdapterMapper;
import com.gooagoo.entity.business.marketing.IsdeletedInfo;
import com.gooagoo.entity.business.marketing.cryout.CryoutInfoAdapter;
import com.gooagoo.entity.business.marketing.cryout.ShopCryoutInfo;
import com.gooagoo.entity.business.marketing.cryout.ShopCryoutInfoBusiness;
import com.gooagoo.entity.business.shop.ShopEntityInfoBusiness;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.CryoutInfo;
import com.gooagoo.entity.generator.marketing.CryoutInfoExample;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.marketing.MarketingActivityExample;
import com.gooagoo.entity.generator.marketing.MarketingItemLink;
import com.gooagoo.entity.generator.marketing.MarketingItemLinkExample;
import com.gooagoo.entity.generator.marketing.MarketingUserLink;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkExample;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkExample.Criteria;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.utils.RandomUtil;

@Service
public class CryoutQueryServiceImpl implements CryoutQueryService
{

    @Autowired
    private CryoutInfoAdapterMapper cryoutInfoAdapterMapper;
    @Autowired
    private MarketingActivityGeneratorQueryService marketingActivityGeneratorQueryService;
    @Autowired
    private CryoutInfoGeneratorQueryService cryoutInfoGeneratorQueryService;
    @Autowired
    private MarketingUserLinkGeneratorQueryService marketingUserLinkGeneratorQueryService;
    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;
    @Autowired
    private MemberOfCardGeneratorQueryService memberOfCardGeneratorQueryService;
    @Autowired
    private MarketingItemLinkGeneratorQueryService marketingItemLinkGeneratorQueryService;
    @Autowired
    private GoodsMarketingInfoGeneratorQueryService goodsMarketingInfoGeneratorQueryService;
    @Autowired
    private CouponGeneratorQueryService couponGeneratorQueryService;
    @Autowired
    private MemberCardGeneratorQueryService memberCardGeneratorQueryService;
    @Autowired
    private ShopCacheQueryService shopCacheQueryService;
    @Autowired
    private ShopProtectedQueryService shopProtectedQueryService;

    @Override
    public ShopCryoutInfoBusiness findCryoutList(String source, String userId, String shopId, String shopType, String cryoutType, String pageId, String pageType, Integer pageSize, String cTimeStamp) throws Exception
    {
        IsdeletedInfo isdeletedInfo = new IsdeletedInfo();//记录删除数据信息
        //1.封装查询商家吆喝的条件
        List<String> shopIdList = null;

        //定位商家范围
        if (StringUtils.hasText(shopId))
        {
            shopIdList = new ArrayList<String>();
            shopIdList.add(shopId);
        }
        else
        {//shopId为null,shopType不为null时，根据shopType查询出其下属商家
            shopIdList = this.getShopIdList(userId, shopType, null, null);
        }
        if (CollectionUtils.isEmpty(shopIdList))
        {
            shopIdList = null;
        }
        if (!StringUtils.hasText(cryoutType))
        {
            cryoutType = null;
        }
        if (!StringUtils.hasText(pageId))
        {
            pageId = null;
        }
        //2.查询商家吆喝信息
        List<CryoutInfoAdapter> cryoutInfoAdapterList = null;
        if ("W".equalsIgnoreCase(source))
        {

            cryoutInfoAdapterList = this.cryoutInfoAdapterMapper.pageShopCryoutInfo(userId, shopIdList, cryoutType, pageId, pageType, pageSize);
        }
        else if ("M".equalsIgnoreCase(source))
        {
            cryoutInfoAdapterList = this.cryoutInfoAdapterMapper.pageShopCryoutInfoM(userId, shopIdList, cryoutType, pageId, pageType, pageSize);

        }
        //封装返回对象
        List<ShopCryoutInfo> shopCryoutInfoList = null;
        if (CollectionUtils.isNotEmpty(cryoutInfoAdapterList))
        {
            shopCryoutInfoList = new ArrayList<ShopCryoutInfo>();
            if ("P".equals(pageType))
            {//新吆喝
             //返回吆喝信息的总条数是否大于每页信息显示条数，若大于flag=Y，反之Flag=N 
                Integer totalSum = this.cryoutInfoAdapterMapper.countPageShopCryoutInfoForMobile(userId, shopIdList, cryoutType, pageId, pageType);
                isdeletedInfo.setFlag(totalSum > pageSize ? "Y" : "N");
            }
            else
            {
                isdeletedInfo.setFlag("N");
            }
            isdeletedInfo.setCtimestamp(TimeUtils.convertDateToString(cryoutInfoAdapterList.get(0).getMarketingUserLink().getCTimeStamp(), TimeUtils.FORMAT1));

            for (CryoutInfoAdapter cryoutInfoAdapter : cryoutInfoAdapterList)
            {
                ShopCryoutInfo shopCryoutInfo = new ShopCryoutInfo();
                MarketingUserLink marketingUserLink = cryoutInfoAdapter.getMarketingUserLink();
                CryoutInfo cryoutInfo = cryoutInfoAdapter.getCryoutInfo();
                shopCryoutInfo.setPageId(cryoutInfoAdapter.getPageId());
                shopCryoutInfo.setCryoutid(cryoutInfo.getCryoutInfoId());
                shopCryoutInfo.setCryoutUserId(marketingUserLink.getId());
                shopCryoutInfo.setUserid(marketingUserLink.getAccount());
                shopCryoutInfo.setShopid(marketingUserLink.getShopId());
                Map<String, String> shopInfoCache = this.shopCacheQueryService.findShopInfo(marketingUserLink.getShopId());
                if (shopInfoCache != null && shopInfoCache.size() > 0)
                {
                    shopCryoutInfo.setShopname(shopInfoCache.get("shopName"));
                    shopCryoutInfo.setLogo(shopInfoCache.get("logo1"));
                }
                //商家地址对应商家总店的地址信息
                if (StringUtils.hasText(shopId))
                {
                    ShopEntityInfoBusiness shopEntityInfoBusiness = this.shopProtectedQueryService.getTheMainShopInfo(shopId);
                    shopCryoutInfo.setAddress(shopEntityInfoBusiness != null && shopEntityInfoBusiness.getShopEntityLink() != null ? shopEntityInfoBusiness.getShopEntityLink().getAddress() : "");
                }
                shopCryoutInfo.setCryouttextmobile(cryoutInfo.getCryoutTextMobile());
                shopCryoutInfo.setMarketinglinktype(cryoutInfo.getMarketingLinkType());
                shopCryoutInfo.setMarketinglinkid(cryoutInfo.getMarketingLinkId());
                shopCryoutInfo.setCryouttitle(cryoutInfo.getCryoutTitle());
                shopCryoutInfo.setCryouttextweb(cryoutInfo.getCryoutTextWeb());
                shopCryoutInfo.setThumbnailpic(UrlUtils.getAttachUrlByImg("s", cryoutInfo.getImg()));
                shopCryoutInfo.setBmiddlepic(UrlUtils.getAttachUrlByImg("b", cryoutInfo.getImg()));
                shopCryoutInfo.setOriginalpic(cryoutInfo.getImg());
                shopCryoutInfo.setSource(cryoutInfo.getCryoutType());
                shopCryoutInfo.setPushTime(marketingUserLink.getPushTime() != null ? TimeUtils.convertDateToString(marketingUserLink.getPushTime(), TimeUtils.FORMAT1) : null);
                MemberCardExample memberCardExample = new MemberCardExample();
                memberCardExample.createCriteria().andShopIdEqualTo(marketingUserLink.getShopId()).andCardType2EqualTo("0").andIsDelEqualTo("N");
                List<MemberCard> memberCard = this.memberCardGeneratorQueryService.selectByExample(memberCardExample);
                if (memberCard != null)
                {
                    shopCryoutInfo.setAllowat("Y");
                }
                else
                {
                    shopCryoutInfo.setAllowat("N");
                }
                MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
                memberOfCardExample.createCriteria().andShopIdEqualTo(marketingUserLink.getShopId()).andUserIdEqualTo(marketingUserLink.getAccount()).andIsDelEqualTo("N");
                List<MemberOfCard> memberOfCardList = this.memberOfCardGeneratorQueryService.selectByExample(memberOfCardExample);
                //是否已经关注或者是会员：0-关注卡，1-电子卡，2-实体卡，N-未关注或非会员
                shopCryoutInfo.setRelation(CollectionUtils.isNotEmpty(memberOfCardList) ? memberOfCardList.get(0).getCardType2() : "N");
                shopCryoutInfoList.add(shopCryoutInfo);
            }
        }
        //        else
        //        {
        //            cryoutInfoAdapterList = null;
        //            isdeletedInfo = null;
        //        }
        //2.查询已删除吆喝信息
        if ("P".equals(pageType) && StringUtils.hasText(cTimeStamp))
        {//当时间戳不为空，且为查询上一页数据时查询删除数据
            this.getDelShopCryOutInfo(TimeUtils.convertStringToDate(cTimeStamp), isdeletedInfo);
        }

        //3.封装返回数据
        ShopCryoutInfoBusiness shopCryoutInfoBusiness = new ShopCryoutInfoBusiness();
        shopCryoutInfoBusiness.setIsdeletedInfo(isdeletedInfo);
        shopCryoutInfoBusiness.setShopCryoutInfoList(shopCryoutInfoList);
        return shopCryoutInfoBusiness;
    }

    private void getDelShopCryOutInfo(Date cTimeStamp, IsdeletedInfo isdeletedInfo)
    {
        MarketingUserLinkExample marketingUserLinkExample = new MarketingUserLinkExample();
        marketingUserLinkExample.createCriteria().andIsDelEqualTo("Y").andMarketingTypeEqualTo("1").andCTimeStampGreaterThan(cTimeStamp);
        marketingUserLinkExample.setOrderByClause("c_time_stamp DESC");
        List<MarketingUserLink> marketingUserLinkList = this.marketingUserLinkGeneratorQueryService.selectByExample(marketingUserLinkExample);
        if (CollectionUtils.isNotEmpty(marketingUserLinkList))
        {
            if (isdeletedInfo == null)
            {
                isdeletedInfo = new IsdeletedInfo();
            }
            String delStr = "";
            for (MarketingUserLink marketingUserLink : marketingUserLinkList)
            {
                if ("".equals(delStr))
                {
                    delStr = marketingUserLink.getMarketingId();
                }
                else
                {
                    delStr = delStr + "," + marketingUserLink.getMarketingId();
                }
            }
            isdeletedInfo = new IsdeletedInfo();
            isdeletedInfo.setCtimestamp(TimeUtils.convertDateToString(marketingUserLinkList.get(0).getCTimeStamp(), TimeUtils.FORMAT1));
        }
    }

    @Override
    public List<ShopCryoutInfo> findCryoutOther(String userId) throws Exception
    {
        List<CryoutInfo> cryList = this.findRecommendCryOut(userId);
        List<ShopCryoutInfo> result = new ArrayList<ShopCryoutInfo>();
        ShopCryoutInfo tarObj = null;
        for (CryoutInfo cryoutInfo : cryList)
        {
            tarObj = new ShopCryoutInfo();
            tarObj.setCryoutid(cryoutInfo.getCryoutInfoId());
            tarObj.setCryoutUserId(cryoutInfo.getCryoutInfoId());
            if (StringUtils.hasText(userId))
            {
                tarObj.setUserid(userId);
            }
            tarObj.setShopid(cryoutInfo.getShopId());

            ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectByPrimaryKey(cryoutInfo.getShopId());
            tarObj.setShopname(shopInfo.getShopName());
            tarObj.setLogo(shopInfo.getLogo1());
            tarObj.setCryouttextweb(cryoutInfo.getCryoutTextWeb());
            tarObj.setCryouttextmobile(cryoutInfo.getCryoutTextMobile());
            tarObj.setSource(cryoutInfo.getCryoutType());
            tarObj.setPushTime(TimeUtils.convertDateToString(cryoutInfo.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));

            /***商家地址信息不要了***/
            //tarObj.setAddress(cryoutInfo.getCryoutInfoId());

            /*G   商品
            A   活动
            C   优惠凭证*/
            if (!StringUtils.hasText(cryoutInfo.getMarketingLinkType()))
            {
                continue;
            }
            MarketingItemLinkExample marketingItemLinkExample = new MarketingItemLinkExample();
            marketingItemLinkExample.createCriteria().andActivityIdEqualTo(cryoutInfo.getActivityId()).andShopIdEqualTo(cryoutInfo.getShopId()).andIsDelEqualTo("N").andMarketingLinkTypeEqualTo(cryoutInfo.getMarketingLinkType());
            List<MarketingItemLink> mkiList = this.marketingItemLinkGeneratorQueryService.selectByExample(marketingItemLinkExample);
            if (mkiList != null && mkiList.size() > 0)
            {
                String link_id = mkiList.get(0).getMarketingLinkId();
                String imgUrl = "";
                if ("G" == cryoutInfo.getMarketingLinkType() || "G".equals(cryoutInfo.getMarketingLinkType()))
                {
                    GoodsMarketingInfo obj = this.goodsMarketingInfoGeneratorQueryService.selectUnDelByPrimaryKey(link_id);
                    imgUrl = obj != null ? obj.getGoodsImg() : null;
                }
                else if ("C" == cryoutInfo.getMarketingLinkType() || "C".equals(cryoutInfo.getMarketingLinkType()))
                {
                    Coupon obj = this.couponGeneratorQueryService.selectUnDelByPrimaryKey(link_id);
                    imgUrl = obj != null ? obj.getCouponUrl() : null;
                }
                else if ("C" == cryoutInfo.getMarketingLinkType() || "C".equals(cryoutInfo.getMarketingLinkType()))
                {
                    MarketingActivity obj = this.marketingActivityGeneratorQueryService.selectUnDelByPrimaryKey(link_id);
                    imgUrl = obj != null ? obj.getImgUrl() : null;
                }

                tarObj.setThumbnailpic(StringUtils.hasText(imgUrl) ? UrlUtils.getAttachUrlByImg("s", JsonUtils.json2List(imgUrl).get(0)) : "");
                tarObj.setBmiddlepic(StringUtils.hasText(imgUrl) ? UrlUtils.getAttachUrlByImg("m", imgUrl) : "");
                tarObj.setOriginalpic(StringUtils.hasText(imgUrl) ? UrlUtils.getAttachUrlByImg("b", imgUrl) : "");
            }

            tarObj.setAllowat("N");
            MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
            com.gooagoo.entity.generator.member.MemberOfCardExample.Criteria mocCriteria = memberOfCardExample.createCriteria();
            if (StringUtils.hasText(userId))
            {
                mocCriteria.andUserIdEqualTo(userId);
            }
            mocCriteria.andShopIdEqualTo(cryoutInfo.getShopId()).andIsDelEqualTo("N");
            List<MemberOfCard> mocList = this.memberOfCardGeneratorQueryService.selectByExample(memberOfCardExample);
            if (mocList != null)
            {
                for (MemberOfCard obj : mocList)
                {
                    tarObj.setRelation(obj.getCardType2());
                    if ("0" == obj.getCardType2() || "0".equals(obj.getCardType2()))
                    {
                        tarObj.setAllowat("Y");
                        break;
                    }
                }
            }

            result.add(tarObj);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    private List<CryoutInfo> findRecommendCryOut(String userId)
    {
        //正常活动
        MarketingActivityExample marketingActivityExample = new MarketingActivityExample();
        marketingActivityExample.createCriteria().andStartTimeLessThanOrEqualTo(new Date()).andEndTimeGreaterThan(new Date());
        List<MarketingActivity> mktActivity = this.marketingActivityGeneratorQueryService.selectByExample(marketingActivityExample);
        List<String> activityIdList = new ArrayList<String>();
        for (MarketingActivity obj : mktActivity)
        {
            activityIdList.add(obj.getActivityId());
        }

        //已被吆喝过的吆喝
        MarketingUserLinkExample marketingUserLinkExample = new MarketingUserLinkExample();
        Criteria criteria = marketingUserLinkExample.createCriteria();
        if (StringUtils.hasText(userId))
        {
            criteria.andAccountEqualTo(userId);
        }
        criteria.andMarketingTypeEqualTo("1");
        List<MarketingUserLink> mktUserList = this.marketingUserLinkGeneratorQueryService.selectByExample(marketingUserLinkExample);
        List<String> mktIdList = new ArrayList<String>();
        for (MarketingUserLink obj : mktUserList)
        {
            mktIdList.add(obj.getMarketingId());
        }

        //获取未被吆喝过的吆喝列表
        CryoutInfoExample example = new CryoutInfoExample();

        if (mktIdList != null && mktIdList.size() > 0)
        {
            example.createCriteria().andActivityIdIn(activityIdList).andCryoutInfoIdNotIn(mktIdList);
        }
        else
        {
            example.createCriteria().andActivityIdIn(activityIdList);
        }
        List<CryoutInfo> cryInfoList = this.cryoutInfoGeneratorQueryService.selectByExample(example);
        return RandomUtil.randomList(cryInfoList, 5);
    }

    /**
     * 获取商家编号集合
     * @param userId 用户编号
     * @param shopType 商家类型(A-全部商家;B-会员商家;C-关注商家;D-周边商家;E-系统吆喝)
     * @param gpsx 纬度
     * @param gpsy 经度
     * @return
     */
    private List<String> getShopIdList(String userId, String shopType, String gpsx, String gpsy) throws Exception
    {
        List<String> shopIdList = new ArrayList<String>();
        if ("A".equals(shopType))//所有商家
        {
            return null;
        }
        else if ("B".equals(shopType))//会员商家
        {
            MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
            memberOfCardExample.createCriteria().andUserIdEqualTo(userId).andCardType2NotEqualTo("0").andIsDelEqualTo("N");
            List<MemberOfCard> memberOfCardList = this.memberOfCardGeneratorQueryService.selectByExample(memberOfCardExample);
            if (CollectionUtils.isEmpty(memberOfCardList))
            {
                GooagooLog.info("获取会员商家为空[userId=" + userId + "]");
                throw new NullException("获取会员商家为空[userId=" + userId + "]");
            }
            for (MemberOfCard memberOfCard : memberOfCardList)
            {
                shopIdList.add(memberOfCard.getShopId());
            }
        }
        else if ("C".equals(shopType))//关注商家
        {
            MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
            memberOfCardExample.createCriteria().andUserIdEqualTo(userId).andCardType2EqualTo("0").andIsDelEqualTo("N");
            List<MemberOfCard> memberOfCardList = this.memberOfCardGeneratorQueryService.selectByExample(memberOfCardExample);
            if (CollectionUtils.isEmpty(memberOfCardList))
            {
                GooagooLog.info("获取会员商家为空[userId=" + userId + "]");
                throw new NullException("获取会员商家为空[userId=" + userId + "]");
            }
            for (MemberOfCard memberOfCard : memberOfCardList)
            {
                shopIdList.add(memberOfCard.getShopId());
            }
        }
        else if ("D".equals(shopType))//周边商家
        {
            GooagooLog.info("周边商家暂不提供");
            throw new NullException("周边商家暂不提供");
        }
        else if ("E".equals(shopType))//系统商家
        {
            GooagooLog.info("系统商家暂不提供");
            throw new NullException("系统商家暂不提供");
        }
        return shopIdList;
    }
}
