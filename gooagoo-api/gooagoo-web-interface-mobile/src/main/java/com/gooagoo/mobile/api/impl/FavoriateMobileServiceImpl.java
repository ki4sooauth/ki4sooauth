package com.gooagoo.mobile.api.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.member.usermember.AttentionCoreService;
import com.gooagoo.api.business.core.user.favorite.FavoriteCoreService;
import com.gooagoo.api.business.query.goods.query.GoodsQueryService;
import com.gooagoo.api.business.query.marketing.qualitygoods.QualityGoodsQueryService;
import com.gooagoo.api.business.query.marketing.recommend.RecommendQueryService;
import com.gooagoo.api.business.query.shop.cache.ShopCacheQueryService;
import com.gooagoo.api.business.query.user.comment.CommentQueryService;
import com.gooagoo.api.business.query.user.favorite.FavoritePlaceQueryService;
import com.gooagoo.api.business.query.user.favorite.FavoriteQueryService;
import com.gooagoo.api.generator.query.behave.UserCommentGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.goods.CrossGoods;
import com.gooagoo.entity.business.goods.ShopGoodsDetailInfo;
import com.gooagoo.entity.business.marketing.FirstMenu;
import com.gooagoo.entity.business.marketing.QualityGoodsBusiness;
import com.gooagoo.entity.business.marketing.QualityGoodsForPlace;
import com.gooagoo.entity.business.marketing.SecondMenu;
import com.gooagoo.entity.business.marketing.recommend.RecommendBusiness;
import com.gooagoo.entity.business.user.FavoriteInfoBusiness;
import com.gooagoo.entity.business.user.FavoriteInfoDetail;
import com.gooagoo.entity.business.user.FavoriteLinkInfoBusiness;
import com.gooagoo.entity.business.user.FavoritePlace;
import com.gooagoo.entity.business.user.UserCommentDetail;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.behave.UserCommentExample;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.CommonMobileService;
import com.gooagoo.mobile.api.FavoriateMobileService;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobb01.transform.FavoriteListgRoot;
import com.gooagoo.mobile.entity.mobb01.transform.Favoritelistg;
import com.gooagoo.mobile.entity.mobb01.transform.Isdeleted;
import com.gooagoo.mobile.entity.mobb03.transform.VoucherDetailRoot;
import com.gooagoo.mobile.entity.mobb03.transform.Voucherdetail;
import com.gooagoo.mobile.entity.mobb04.transform.Bought;
import com.gooagoo.mobile.entity.mobb04.transform.GoodsDetailRoot;
import com.gooagoo.mobile.entity.mobb04.transform.Goodsdetail;
import com.gooagoo.mobile.entity.mobb05.transform.UserCommentRoot;
import com.gooagoo.mobile.entity.mobb05.transform.Usercomment;
import com.gooagoo.mobile.entity.mobb06.transform.FavoritePlazaMenuRoot;
import com.gooagoo.mobile.entity.mobb06.transform.Firstmenu;
import com.gooagoo.mobile.entity.mobb06.transform.Secondmenu;
import com.gooagoo.mobile.entity.mobb07.transform.FavoritePlazaRoot;
import com.gooagoo.mobile.entity.mobb07.transform.Favoriteplaza;
import com.gooagoo.mobile.entity.mobb08.transform.ChoiceListRoot;
import com.gooagoo.mobile.entity.mobb08.transform.Objinfo;
import com.gooagoo.mobile.entity.mobb08.transform.Shopinfo;
import com.gooagoo.mobile.entity.mobb10.transform.FavoriteRecommendRoot;
import com.gooagoo.mobile.entity.mobb10.transform.Favoriterecommend;
import com.google.gson.Gson;

@Service
public class FavoriateMobileServiceImpl implements FavoriateMobileService
{
    @Autowired
    private FavoriteQueryService favoriteQueryService;
    @Autowired
    private CommonMobileService commonMobileService;
    @Autowired
    private FavoriteCoreService favoriteCoreService;
    @Autowired
    private CommentQueryService commentQueryService;
    @Autowired
    private FavoritePlaceQueryService favoritePlaceQueryService;
    @Autowired
    private QualityGoodsQueryService qualityGoodsQueryService;
    @Autowired
    private AttentionCoreService attentionCoreService;
    @Autowired
    private RecommendQueryService recommendQueryService;
    @Autowired
    private GoodsQueryService goodsQueryService;
    @Autowired
    private ShopCacheQueryService shopCacheQueryService;
    @Autowired
    private UserCommentGeneratorQueryService userCommentGeneratorQueryService;

    @Override
    public FavoriteListgRoot getFavoritesOfGooagoo(String userId, String sessionId, String shopId, String shopEnityId, String cTimeStamp, String favoriateId, String type, String pageType, String pageSize) throws Exception
    {
        GooagooLog.info("getFavoritesOfGooagoo-->入参:userId=" + userId + ",sessionId=" + sessionId + ",favoriateId=" + favoriateId + " ,type=" + type + " ,pageType" + pageType + " ,pageSize" + pageSize);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.查询用户收藏信息(在query层按最大时间戳和用户id查询)
        FavoriteLinkInfoBusiness favoriteLinkInfoBusiness = this.favoriteQueryService.findMemberFavorite(userId, shopId, shopEnityId, cTimeStamp, type, favoriateId, pageType, null, Integer.valueOf(pageSize));

        GooagooLog.debug("查询到的商家用户收藏信息为：" + new Gson().toJson(favoriteLinkInfoBusiness));
        List<Favoritelistg> favglist = null;
        Isdeleted isdeleted = null;
        if (null != favoriteLinkInfoBusiness)
        {
            //3.封装查询到的用户收藏信息
            if (CollectionUtils.isNotEmpty(favoriteLinkInfoBusiness.getFavoriteInfoBusinessList()))
            {
                favglist = new ArrayList<Favoritelistg>();
                for (FavoriteInfoBusiness favoriteInfo : favoriteLinkInfoBusiness.getFavoriteInfoBusinessList())
                {
                    Favoritelistg favoritelistg = new Favoritelistg();
                    favoritelistg.setFavoriteid(favoriteInfo.getFavoriteid());
                    favoritelistg.setShopid(favoriteInfo.getShopid());
                    //查询商家基本信息
                    Map<String, String> shopInfoMap = this.shopCacheQueryService.findShopInfo(favoriteInfo.getShopid());
                    favoritelistg.setLogo2(shopInfoMap.get("logo2"));
                    favoritelistg.setShopname(shopInfoMap.get("shopName"));

                    favoritelistg.setShopentityid(favoriteInfo.getShopentityid());
                    favoritelistg.setObjectid(favoriteInfo.getObjectid());
                    favoritelistg.setInfourl(favoriteInfo.getInfourl());
                    favoritelistg.setInfotype(favoriteInfo.getInfotype());
                    favoritelistg.setInfotitle(favoriteInfo.getInfotitle());
                    favoritelistg.setInfobegindate(favoriteInfo.getInfobegindate());
                    favoritelistg.setInfoenddate(favoriteInfo.getInfoenddate());
                    favoritelistg.setPrice(favoriteInfo.getPrice());
                    favoritelistg.setIsused(favoriteInfo.getIsused());
                    favoritelistg.setIsoverdate(favoriteInfo.getIsoverdate());
                    favoritelistg.setInfopic(favoriteInfo.getInfopic());
                    favglist.add(favoritelistg);
                }
            }

            if (favoriteLinkInfoBusiness.getIsdeletedInfo() != null)
            {
                isdeleted = new Isdeleted();
                isdeleted.setCtimestamp(favoriteLinkInfoBusiness.getIsdeletedInfo().getCtimestamp());
                isdeleted.setFavoriteidstr(favoriteLinkInfoBusiness.getIsdeletedInfo().getIdstr());
                isdeleted.setFlag(favoriteLinkInfoBusiness.getIsdeletedInfo().getFlag());
            }
        }

        FavoriteListgRoot favoriteListgRoot = new FavoriteListgRoot();
        favoriteListgRoot.setFavoritelistg(favglist);
        favoriteListgRoot.setIsdeleted(isdeleted);

        return favoriteListgRoot;
    }

    @Override
    public boolean addFavorites(String userId, String sessionId, String adtype, String shopadid, String adurl) throws Exception
    {
        GooagooLog.info("addFavorites-->入参:userId=" + userId + ",sessionId=" + sessionId + ",adtype=" + adtype + ",shopadid=" + shopadid + ",adurl" + adurl);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.封装业务要添加的入参收藏信息
        FavoriteInfo favoriteInfo = new FavoriteInfo();
        favoriteInfo.setUserId(userId);
        favoriteInfo.setObjectId(shopadid);//收藏信息编号
        favoriteInfo.setInfoType(adtype);//收藏信息类型
        favoriteInfo.setSource("M");//收藏来源
        favoriteInfo.setInfoUrl(adurl);

        //3.添加收藏，收藏信息入库
        boolean bool = this.favoriteCoreService.addFavorite(favoriteInfo);
        if (!bool)
        {

            GooagooLog.warn("添加收藏信息FavoriteInfo：" + favoriteInfo.toString() + "失败");
            throw new MessageException(MessageConst.MOBILE_FAVORIATE_STORE_FAIL);
        }
        return true;
    }

    @Override
    public VoucherDetailRoot getCouponInfo(String userId, String sessionId, String favoriateId) throws Exception
    {
        GooagooLog.info("getCouponInfo-->入参:userId=" + userId + ",sessionId=" + sessionId + ",favoriateId" + favoriateId);
        //1.用户登录状态校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);

        //2.封装优惠编号信息
        String favoriateIds[] = favoriateId.split(",");
        List<String> favoriateIdList = new ArrayList<String>();
        for (int i = 0; i < favoriateIds.length; i++)
        {
            favoriateIdList.add(favoriateIds[i]);
        }
        //3.封装优惠券入参信息
        FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
        favoriteInfoExample.createCriteria().andUserIdEqualTo(userId).andFavoriteIdIn(favoriateIdList).andInfoTypeEqualTo("C").andIsDelEqualTo("N");

        //4.查询优惠券信息
        List<FavoriteInfoDetail> listfInfoDetail = this.favoriteQueryService.findFavoriteList(favoriteInfoExample);

        GooagooLog.debug("查询到的用户收藏详细信息为：" + new Gson().toJson(listfInfoDetail));
        List<Voucherdetail> voucherdetailList = null;
        if (CollectionUtils.isNotEmpty(listfInfoDetail))
        {
            //5.封装查询到的优惠券信息
            voucherdetailList = new ArrayList<Voucherdetail>();
            for (FavoriteInfoDetail tempFavoriteInfoDetail : listfInfoDetail)
            {
                //优惠凭证
                Coupon coupon = tempFavoriteInfoDetail.getCoupon();
                if (coupon == null)
                {
                    continue;
                }
                Voucherdetail voucherdetail = new Voucherdetail();
                voucherdetail.setCouponcontent(coupon.getCouponContent());
                voucherdetail.setCouponname(coupon.getCouponName());
                voucherdetail.setCoupontype(coupon.getCouponType());
                voucherdetail.setCouponurl(coupon.getCouponUrl());
                voucherdetail.setCouponuserid(tempFavoriteInfoDetail.getFavoriteInfo().getFavoriteId());
                voucherdetail.setCouponvalue(coupon.getCouponValue().toString());
                voucherdetail.setPublishstarttime(TimeUtils.convertDateToString(coupon.getUseStartTime(), TimeUtils.FORMAT1));
                voucherdetail.setPublishendtime(TimeUtils.convertDateToString(coupon.getPublishEndTime(), TimeUtils.FORMAT1));
                voucherdetail.setShopid(coupon.getShopId());
                voucherdetailList.add(voucherdetail);
            }
        }

        VoucherDetailRoot voucherDetailRoot = new VoucherDetailRoot();
        voucherDetailRoot.setVoucherdetail(voucherdetailList);
        return voucherDetailRoot;
    }

    @Override
    public GoodsDetailRoot getGoodsDetailInfo(String userId, String sessionId, String goodsId, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("getGoodsDetailInfo-->入参:,goodsId=" + goodsId + ",pageIndex=" + pageIndex + ",pageSize=" + pageSize);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);

        //2.取出商品编号

        List<String> gooodsIdStrs = Arrays.asList(goodsId.split(","));
        List<Map<String, String>> goodsInfoList = new ArrayList<Map<String, String>>();
        for (String goodsIdStr : gooodsIdStrs)
        {
            Map<String, String> map = new HashMap<String, String>();
            map.put("goodsid", goodsIdStr);
            goodsInfoList.add(map);
        }

        //3.查询到的商品详细信息及评论信息
        List<ShopGoodsDetailInfo> findGoodsAndComment = this.goodsQueryService.findGoodsAndComment(goodsInfoList);

        GooagooLog.debug("查询到的商品详细信息及评论信息为：" + new Gson().toJson(findGoodsAndComment));
        List<Goodsdetail> goodsdetaillist = null;
        if (CollectionUtils.isNotEmpty(findGoodsAndComment))
        {
            //校验是否查询到数据
            goodsdetaillist = new ArrayList<Goodsdetail>();
            for (ShopGoodsDetailInfo tempShopGoodsDetailInfo : findGoodsAndComment)
            {
                //封装商品信息
                Goodsdetail goodsdetail = new Goodsdetail();

                goodsdetail.setGoodsid(tempShopGoodsDetailInfo.getGoodsBaseInfo().getGoodsId());
                goodsdetail.setGoodsname(tempShopGoodsDetailInfo.getGoodsBaseInfo().getGoodsName());
                goodsdetail.setPrice(tempShopGoodsDetailInfo.getGoodsBaseInfo().getPrice().toString());
                goodsdetail.setDiscountprice(tempShopGoodsDetailInfo.getDiscountprice());//促销价格
                goodsdetail.setGoodsimg(StringUtils.hasText(tempShopGoodsDetailInfo.getGoodsMarketingInfo().getGoodsImg()) ? JsonUtils.json2List(tempShopGoodsDetailInfo.getGoodsMarketingInfo().getGoodsImg()).get(0) : null);
                goodsdetail.setGoodscontent(tempShopGoodsDetailInfo.getGoodsMarketingInfo().getGoodsContent());

                goodsdetail.setGoodsscore(tempShopGoodsDetailInfo.getGoodsscore());//商品评分
                goodsdetail.setShopentityid(tempShopGoodsDetailInfo.getGoodsBaseInfo().getShopEntityId());
                goodsdetail.setShopid(tempShopGoodsDetailInfo.getGoodsBaseInfo().getShopId());
                goodsdetail.setLinkurl(UrlUtils.getGoodsMobileUrl(tempShopGoodsDetailInfo.getGoodsBaseInfo().getGoodsId()));

                //封装买过此商品的还购买过哪些商品信息
                List<Bought> boughtList = null;
                if (CollectionUtils.isNotEmpty(tempShopGoodsDetailInfo.getCrossGoodsList()))
                {
                    boughtList = new java.util.ArrayList<Bought>();
                    //tempCrossGoods 交叉商品信息
                    for (CrossGoods tempCrossGoods : tempShopGoodsDetailInfo.getCrossGoodsList())
                    {
                        Bought tempBought = new Bought();
                        tempBought.setGoodsid(tempCrossGoods.getGoodsId());
                        tempBought.setGoodsimg(StringUtils.hasText(tempCrossGoods.getGoodsImg()) ? JsonUtils.json2List(tempCrossGoods.getGoodsImg()).get(0) : null);
                        tempBought.setGoodsname(tempCrossGoods.getGoodsName());
                        tempBought.setPrice(tempCrossGoods.getPrice().toString());
                        tempBought.setSalenums(tempCrossGoods.getSaleNums());
                        tempBought.setShopid(tempCrossGoods.getShopId());

                        boughtList.add(tempBought);
                    }
                }

                goodsdetail.setBought(boughtList);
                goodsdetaillist.add(goodsdetail);
            }
        }

        //商品详细信息及评论
        GoodsDetailRoot goodsDetailRoot = new GoodsDetailRoot();
        goodsDetailRoot.setGoodsdetail(goodsdetaillist);

        return goodsDetailRoot;
    }

    @Override
    public UserCommentRoot getUserComments(String goodsId, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("getUserComments-->入参:goodsId=" + goodsId + ",pageIndex=" + pageIndex + ",pageSize=" + pageSize);
        //1.封装查询商品所有评论的入参信息
        UserCommentExample userCommentExample = new UserCommentExample();
        userCommentExample.createCriteria().andGoodsIdEqualTo(goodsId).andIsDelEqualTo("N");
        //2.查询评论总条数
        Integer totalCommentNum = this.userCommentGeneratorQueryService.countByExample(userCommentExample);
        //分页
        userCommentExample.setPage(Integer.parseInt(pageIndex), Integer.parseInt(pageSize));

        //3.查询商品所有评论
        List<UserCommentDetail> userCommentDetailList = this.commentQueryService.findUserCommentList(userCommentExample);
        GooagooLog.debug("查询到的商品评论列表为：" + new Gson().toJson(userCommentDetailList));
        List<Usercomment> listucomment = null;
        if (CollectionUtils.isNotEmpty(userCommentDetailList))
        {
            //4.封装查询到的商品评论
            listucomment = new ArrayList<Usercomment>();
            for (UserCommentDetail userCommentDetail : userCommentDetailList)
            {
                Usercomment usercomment = new Usercomment();
                usercomment.setCommentid(userCommentDetail.getCommentId());
                usercomment.setCommentlevel(userCommentDetail.getCommentLevel().toString());
                usercomment.setContent(userCommentDetail.getContent());
                usercomment.setCreatetime(userCommentDetail.getCommentTime().toString());
                usercomment.setDescription(userCommentDetail.getContent());
                usercomment.setNickname(userCommentDetail.getUserAccount());
                usercomment.setSource(userCommentDetail.getSource());
                listucomment.add(usercomment);
            }
        }

        UserCommentRoot userCommentRoot = new UserCommentRoot();
        userCommentRoot.setTotalrec(totalCommentNum.toString());//评论总条数
        userCommentRoot.setUsercomment(listucomment);
        return userCommentRoot;
    }

    @Override
    public FavoritePlazaRoot getFavoritePlazaListInfo(String userId, String keyWord, String type, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("getFavoritePlazaListInfo-->入参:userId=" + userId + ",keyWord=" + keyWord + ",type=" + type + ",pageIndex=" + pageIndex + ",pageSize=" + pageSize);

        //1.收藏广场列表信息查询
        List<FavoritePlace> favoritePlaceList = this.favoritePlaceQueryService.findFavoritePlace(userId, null, null, keyWord, type, Integer.parseInt(pageIndex), Integer.parseInt(pageSize));
        GooagooLog.debug("查询到的收藏广场列表信息为：" + new Gson().toJson(favoritePlaceList));
        List<Favoriteplaza> fplazalist = null;
        if (CollectionUtils.isNotEmpty(favoritePlaceList))
        {

            //2.封装查询到的收藏广场列表信息
            fplazalist = new ArrayList<Favoriteplaza>();
            for (FavoritePlace favoritePlace : favoritePlaceList)
            {
                Favoriteplaza favoriteplaza = new Favoriteplaza();
                favoriteplaza.setCommentnums(favoritePlace.getCommentNums());
                favoriteplaza.setFavnums(favoritePlace.getFavNums());
                favoriteplaza.setIsfav(favoritePlace.getIsFav());
                favoriteplaza.setLinkurl(favoritePlace.getLinkUrl());
                favoriteplaza.setObjid(favoritePlace.getObjId());
                favoriteplaza.setObjimg(favoritePlace.getObjImg());
                favoriteplaza.setObjname(favoritePlace.getObjName());
                favoriteplaza.setObjtype(favoritePlace.getObjType());
                favoriteplaza.setShopid(favoritePlace.getShopId());
                favoriteplaza.setShopname(favoritePlace.getShopName());
                fplazalist.add(favoriteplaza);
            }
        }

        //3.组装返回数据
        FavoritePlazaRoot favoritePlazaRoot = new FavoritePlazaRoot();
        favoritePlazaRoot.setFavoriteplaza(fplazalist);
        return favoritePlazaRoot;
    }

    @Override
    public ChoiceListRoot getChoiceList(String userId, String shopId, String type, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("getChoiceList-->入参:userId=" + userId + ",shopId=" + shopId + ",type=" + type + ",pageIndex" + pageIndex + ",pageSize" + pageSize);
        //1.根据参数，查询精品推荐
        QualityGoodsForPlace qualityGoodsForPlace = this.qualityGoodsQueryService.findQualityGoodsForPlace(userId, shopId, null, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));
        GooagooLog.debug("查询到的精品推荐为：" + new Gson().toJson(qualityGoodsForPlace));
        Shopinfo shopinfo = null;
        List<Objinfo> objinfoList = null;
        if (qualityGoodsForPlace != null)
        {
            //2.封装精品推荐信息

            //封装精品推荐信息中的商家信息 qualityGoodsForPlace 继承ShopDetailForPlace
            shopinfo = new Shopinfo();
            shopinfo.setShopid(shopId);
            shopinfo.setLogo1(qualityGoodsForPlace.getLogo1());
            shopinfo.setAttentionnums(qualityGoodsForPlace.getAttentionnum());
            shopinfo.setCardheadurl(qualityGoodsForPlace.getCardheaderurl());
            shopinfo.setMembernums(qualityGoodsForPlace.getMembernum());
            shopinfo.setNumbers(qualityGoodsForPlace.getNum());

            //封装精品推荐信息中的精品信息
            List<QualityGoodsBusiness> qualityGoodsBusinessList = qualityGoodsForPlace.getQualityGoodsBusinessList();
            if (CollectionUtils.isNotEmpty(qualityGoodsBusinessList))
            {
                objinfoList = new ArrayList<Objinfo>();
                for (QualityGoodsBusiness qualityGoodsBusiness : qualityGoodsBusinessList)
                {
                    Objinfo Objinfo = new Objinfo();
                    Objinfo.setFavnums(qualityGoodsBusiness.getFavnums());
                    Objinfo.setIsfav(qualityGoodsBusiness.getIsfav());
                    Objinfo.setObjid(qualityGoodsBusiness.getGoodsId());
                    Objinfo.setObjname(qualityGoodsBusiness.getGoodsName());
                    Objinfo.setObjpicurl(qualityGoodsBusiness.getGoodsImg());
                    Objinfo.setIntroduceurl(UrlUtils.getGoodsMobileUrl(qualityGoodsBusiness.getGoodsId()));
                    objinfoList.add(Objinfo);
                }
            }
        }

        //3.组装返回数据
        ChoiceListRoot choiceListRoot = new ChoiceListRoot();
        choiceListRoot.setShopinfo(shopinfo);
        choiceListRoot.setObjinfo(objinfoList);
        return choiceListRoot;
    }

    @Override
    public boolean userAttentionShop(String userId, String sessionId, String shopId) throws Exception
    {
        GooagooLog.info("userAttentionShop-->入参:userId=" + userId + ",sessionId=" + sessionId + ",shopId" + shopId);
        //1.用户登录状态校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);

        //2.用户关注商家
        boolean bool = this.attentionCoreService.addAttention(userId, shopId);
        if (!bool)
        {
            throw new MessageException(MessageConst.MOBILE_FAVORIATE_ATTENTION_SHOP_FAIL);
        }
        return true;
    }

    @Override
    public FavoriteRecommendRoot getFavoriteRecommend(String userId, String type, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("getFavoriteRecommend-->入参:【type=" + type + " ,pageIndex=" + pageIndex + " ,pageSize=" + pageSize + "】");
        List<RecommendBusiness> recommendBusinessList = null;
        Integer tempPageIndex = null;
        Integer tempPageSize = null;
        if (StringUtils.hasText(pageIndex) && StringUtils.hasText(pageSize))
        {
            if (!"1".equals(pageIndex.trim()) && !"-1".equals(pageSize))
            {
                tempPageIndex = Integer.valueOf(pageIndex.trim());
                tempPageSize = Integer.valueOf(pageSize.trim());
            }

        }
        if ("G".equals(type))
        {
            //1.gooagoo平台向客户推荐商品，在我的收藏中展示推荐的商品信息集（分页查推荐有效期内的商品）
            recommendBusinessList = this.recommendQueryService.recommendGoods(userId, tempPageIndex, tempPageSize);
        }
        else if ("C".equals(type))
        {
            //2.gooagoo平台向客户推荐优惠凭证，在我的收藏中展示推荐的优惠凭证信息集（分页）
            recommendBusinessList = this.recommendQueryService.recommendCoupon(userId, tempPageIndex, tempPageSize);
        }
        else if ("A".equals(type))
        {
            //3.gooagoo平台向客户推荐活动，在我的收藏中展示推荐的活动信息集（分页）
            recommendBusinessList = this.recommendQueryService.recommendActivity(userId, tempPageIndex, tempPageSize);
        }

        GooagooLog.debug("查询到类型【 type=" + type + "】推荐收藏信息为：【" + new Gson().toJson(recommendBusinessList) + "】");

        //4.封装推荐收藏信息
        List<Favoriterecommend> favoriterecommendList = null;
        if (CollectionUtils.isNotEmpty(recommendBusinessList))
        {
            favoriterecommendList = new ArrayList<Favoriterecommend>();
            //封装查询到收藏推荐信息
            this.copyRecommendBusinessToFavoriterecommend(recommendBusinessList, favoriterecommendList);

        }
        //5.将业务层收藏信息，组合封装搜索收藏推荐
        FavoriteRecommendRoot favoriteRecommendRoot = new FavoriteRecommendRoot();
        favoriteRecommendRoot.setFavoriterecommend(favoriterecommendList);
        return favoriteRecommendRoot;

    }

    public void copyRecommendBusinessToFavoriterecommend(List<RecommendBusiness> recommendBusinessList, List<Favoriterecommend> favoriterecommendList) throws Exception
    {

        for (RecommendBusiness recommendBusiness : recommendBusinessList)
        {
            Favoriterecommend favoriterecommend = new Favoriterecommend();
            favoriterecommend.setCtimestamp(recommendBusiness.getCtimestamp());
            favoriterecommend.setInfobegindate(recommendBusiness.getInfobegindate());
            favoriterecommend.setInfoenddate(recommendBusiness.getInfoenddate());
            favoriterecommend.setInfopic(recommendBusiness.getInfopic());
            favoriterecommend.setInfotitle(recommendBusiness.getInfotitle());
            favoriterecommend.setInfotype(recommendBusiness.getInfotype());
            if ("G".equals(recommendBusiness.getInfotype()))
            {
                favoriterecommend.setInfourl(UrlUtils.getGoodsMobileUrl(recommendBusiness.getInfoId()));
            }
            else if ("A".equals(recommendBusiness.getInfotype()))
            {
                favoriterecommend.setInfourl(UrlUtils.getActiveMobileUrl(recommendBusiness.getInfoId()));
            }
            else if ("C".equals(recommendBusiness.getInfotype()))
            {
                favoriterecommend.setInfourl(UrlUtils.getCouponMobileUrl(recommendBusiness.getInfoId()));
            }
            favoriterecommend.setIsdel(recommendBusiness.getIsdel());
            favoriterecommend.setIsused(recommendBusiness.getIsused());
            favoriterecommend.setLogo(recommendBusiness.getLogo());
            favoriterecommend.setPrice(recommendBusiness.getPrice());
            favoriterecommend.setRemark(recommendBusiness.getRemark());
            favoriterecommend.setShopid(recommendBusiness.getShopid());
            favoriterecommend.setShopname(recommendBusiness.getShopname());
            favoriterecommendList.add(favoriterecommend);
        }
    }

    @Override
    public FavoritePlazaMenuRoot getFavoritePlazaMenu() throws Exception
    {

        List<Firstmenu> firstmenu = new ArrayList<Firstmenu>();
        //1，查询一级菜单
        List<FirstMenu> firstMenuList = this.favoritePlaceQueryService.findFavoritePlaceLeftMenu();

        GooagooLog.debug("查询到的菜单栏信息为：" + new Gson().toJson(firstMenuList));

        if (CollectionUtils.isNotEmpty(firstMenuList))
        {
            //校验是否查询到数据
            for (FirstMenu firstMenu : firstMenuList)
            { //一级菜单
                Firstmenu tempFirstmenu = new Firstmenu();
                tempFirstmenu.setFirstmenucode(firstMenu.getFirstmenucode());
                tempFirstmenu.setFirstmenuname(firstMenu.getFirstmenuname());
                //二级菜单
                List<Secondmenu> secondmenuList = null;
                if (CollectionUtils.isNotEmpty(firstMenu.getSecondmenu()))
                {
                    secondmenuList = new ArrayList<Secondmenu>();
                    for (SecondMenu tempScondMenu : firstMenu.getSecondmenu())
                    {
                        Secondmenu tempSecondmenu = new Secondmenu();
                        tempSecondmenu.setSecondmenucode(tempScondMenu.getSecondmenucode());
                        tempSecondmenu.setSecondmenuname(tempScondMenu.getSecondmenuname());
                        secondmenuList.add(tempSecondmenu);
                    }
                }
                tempFirstmenu.setSecondmenu(secondmenuList);
                firstmenu.add(tempFirstmenu);
            }
        }
        //2，封装一级菜单
        FavoritePlazaMenuRoot favoritePlazaMenuRoot = new FavoritePlazaMenuRoot();
        favoritePlazaMenuRoot.setFirstmenu(firstmenu);
        return favoritePlazaMenuRoot;
    }

    @Override
    public void DelUserFavoriate(String userId, String sessionId, String favoriteId) throws Exception
    {
        GooagooLog.info("DelUseMemberCard-->入参:userId=" + userId + ",sessionId=" + sessionId + ",favoriteId=" + favoriteId);

        //1.判断用户是否登录
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.删除用户收藏
        if (!this.favoriteCoreService.deleteFavorite(favoriteId))
        {
            throw new MessageException(MessageConst.MOBILE_CARDTOP_DEL_FAVORIATE_FAIL);
        }

    }

    @Override
    public Integer GetUserUserableCouponNums(String userId, String sessionId, String shopId) throws Exception
    {
        GooagooLog.info("GetUserUserableCouponNums-->入参:userId=" + userId + ",sessionId=" + sessionId + ",shopId=" + shopId);

        //1.判断用户是否登录
        this.commonMobileService.checkLoginStatus(userId, sessionId);

        //2.查询用户可用优惠券数量
        return this.favoriteQueryService.GetUserUserableCouponNums(userId, shopId);
    }

}
