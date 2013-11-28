package com.gooagoo.mobile.api.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.user.shoppingplan.ShoppingPlanSynCoreService;
import com.gooagoo.api.business.query.marketing.activity.ActivityQueryService;
import com.gooagoo.api.business.query.user.shoppingmatch.ShoppingMatchQueryService;
import com.gooagoo.api.business.query.user.shoppingplan.ShoppingPlanQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.goods.ShopGoodsDetailInfo;
import com.gooagoo.entity.business.marketing.activity.ActivityBusiness;
import com.gooagoo.entity.business.marketing.activity.ActivitylistBusiness;
import com.gooagoo.entity.business.user.ShoppingPlanDetailStepA;
import com.gooagoo.entity.business.user.ShoppingPlanDetailStepB;
import com.gooagoo.entity.business.user.shoppingmatch.MatchInfoList;
import com.gooagoo.entity.business.user.shoppingmatch.PositionInfo;
import com.gooagoo.entity.business.user.shoppingplan.ShoppingplanBusiness;
import com.gooagoo.entity.business.user.shoppingplan.ShoppingplanGoodsBusiness;
import com.gooagoo.entity.business.user.shoppingplan.ShoppingplanInfoBusiness;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoods;
import com.gooagoo.entity.generator.behave.UserShoppingPlan;
import com.gooagoo.mobile.api.CommonMobileService;
import com.gooagoo.mobile.api.ShoppingPlanMobileService;
import com.gooagoo.mobile.common.entity.ShoppingPlanDetailStepBEntity;
import com.gooagoo.mobile.common.entity.ShoppingPlanGoodsEntity;
import com.gooagoo.mobile.common.entity.UsershoppingPlanEntity;
import com.gooagoo.mobile.entity.mobd01.transform.Shoppingplangoodssinglemob;
import com.gooagoo.mobile.entity.mobd01.transform.UserShoppingPlanSRoot;
import com.gooagoo.mobile.entity.mobd01.transform.Usershoppingplansinglemob;
import com.gooagoo.mobile.entity.mobd02.transform.Matchgoodslist;
import com.gooagoo.mobile.entity.mobd02.transform.ShoppingMatchDetileRoot;
import com.gooagoo.mobile.entity.mobd03.transform.Marketingactivity;
import com.gooagoo.mobile.entity.mobd03.transform.MarketingactivityRoot;
import com.gooagoo.mobile.entity.mobd04.transform.Activity;
import com.gooagoo.mobile.entity.mobd04.transform.Activitylist;
import com.gooagoo.mobile.entity.mobd04.transform.ActivitylistRoot;
import com.gooagoo.mobile.entity.mobd06.transform.Shoppingplangoodsmob;
import com.gooagoo.mobile.entity.mobd06.transform.UserShoppingPlanBTARoot;
import com.gooagoo.mobile.entity.mobd06.transform.Usershoppingplanmob;
import com.gooagoo.mobile.entity.mobd07.transform.UserShoppingPlanBTBRoot;
import com.gooagoo.mobile.entity.mobd07.transform.Usershoppingplanbtb;
import com.gooagoo.mobile.entity.mobd08.transform.Matchlist;
import com.gooagoo.mobile.entity.mobd08.transform.Position;
import com.gooagoo.mobile.entity.mobd08.transform.ShoppingMatchActiveRoot;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class ShoppingPlanMobileServiceImpl implements ShoppingPlanMobileService
{
    @Autowired
    private ShoppingPlanQueryService shoppingPlanQueryService;
    @Autowired
    private ShoppingPlanSynCoreService shoppingPlanSynCoreService;
    @Autowired
    private ShoppingMatchQueryService shoppingMatchQueryService;
    @Autowired
    private ActivityQueryService activityQueryService;
    @Autowired
    private CommonMobileService commonMobileService;

    @Override
    public UserShoppingPlanSRoot getUserShoppingPlan(String userId, String sessionId, String userShoppingPlan) throws Exception
    {
        GooagooLog.info("getUserShoppingPlan-->入参:userId=" + userId + ",sessionId=" + sessionId + ",userShoppingPlan=" + userShoppingPlan);
        //1.校验用户是否登录
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.计划列表与服务器同步（单条）
        ShoppingplanInfoBusiness shoppingplanInfoBusiness = this.shoppingPlanSynCoreService.getSingleUserShoppingplan(userId, userShoppingPlan);

        GooagooLog.debug("计划列表与服务器同步（单条）的信息为： " + new Gson().toJson(shoppingplanInfoBusiness));
        Usershoppingplansinglemob usershoppingplansinglemob = null;
        List<Shoppingplangoodssinglemob> shoppingplangoodssinglemobList = null;
        if (null != shoppingplanInfoBusiness && shoppingplanInfoBusiness.getShoppingplanBusiness() != null)
        {

            //购物计划信息
            ShoppingplanBusiness singleUserShoppingplan = shoppingplanInfoBusiness.getShoppingplanBusiness();
            usershoppingplansinglemob = new Usershoppingplansinglemob();
            usershoppingplansinglemob.setShoppinglistid(singleUserShoppingplan.getShoppinglistid());
            usershoppingplansinglemob.setTitle(singleUserShoppingplan.getTitle());
            usershoppingplansinglemob.setPreshoppingtime(singleUserShoppingplan.getPreshoppingtime());
            usershoppingplansinglemob.setInfosource(singleUserShoppingplan.getInfosource());
            usershoppingplansinglemob.setIsdel(singleUserShoppingplan.getIsdel());
            usershoppingplansinglemob.setCreatetime(singleUserShoppingplan.getCreatetime());
            usershoppingplansinglemob.setCtimestamp(singleUserShoppingplan.getCtimestamp());

            //购物计划中的商品列表

            if (CollectionUtils.isNotEmpty(singleUserShoppingplan.getShoppingplanGoodsBusinessList()))
            {
                shoppingplangoodssinglemobList = new ArrayList<Shoppingplangoodssinglemob>();
                for (ShoppingplanGoodsBusiness t : singleUserShoppingplan.getShoppingplanGoodsBusinessList())
                {
                    Shoppingplangoodssinglemob shoppingplangoodssinglemob = new Shoppingplangoodssinglemob();
                    shoppingplangoodssinglemob.setShoppinggoodsid(t.getShoppinggoodsid());
                    shoppingplangoodssinglemob.setGoodsid(t.getGoodsid());
                    shoppingplangoodssinglemob.setGoodsname(t.getGoodsid());
                    shoppingplangoodssinglemob.setGoodstypeid(t.getGoodstypeid());
                    shoppingplangoodssinglemob.setShopid(t.getShopid());
                    shoppingplangoodssinglemob.setShopname(t.getShopname());
                    shoppingplangoodssinglemob.setIsdel(t.getIsdel());
                    shoppingplangoodssinglemob.setCreatetime(t.getCreatetime());
                    shoppingplangoodssinglemob.setCtimestamp(t.getCtimestamp());
                    shoppingplangoodssinglemobList.add(shoppingplangoodssinglemob);
                }
            }

        }

        //4.组装返回数据
        UserShoppingPlanSRoot root = new UserShoppingPlanSRoot();
        if (shoppingplanInfoBusiness != null)
        {
            root.setFlag(shoppingplanInfoBusiness.getFlag());
            root.setNewshoppinglistid(shoppingplanInfoBusiness.getNewshoppinglistid());
        }
        if (usershoppingplansinglemob != null)
        {
            usershoppingplansinglemob.setShoppingplangoodssinglemob(shoppingplangoodssinglemobList);
        }

        root.setUsershoppingplansinglemob(usershoppingplansinglemob);
        return root;
    }

    @Override
    public ShoppingMatchDetileRoot getShoppingMatchInfo(String userId, String sessionId, String goodsId) throws Exception
    {
        GooagooLog.info("getShoppingMatchInfo-->入参:userId=" + userId + ",sessionId=" + sessionId + ",goodsId=" + goodsId);
        //1.查询用户“购物清单”在当前区域内匹配的商品信息列表
        List<ShopGoodsDetailInfo> matchgoodslistInfo = this.shoppingMatchQueryService.getMatchgoodslistInfo(goodsId);

        GooagooLog.debug("查询用户“购物清单”中匹配商品的信息 为 ：" + new Gson().toJson(matchgoodslistInfo));
        List<Matchgoodslist> matchgoodslist = null;
        if (CollectionUtils.isNotEmpty(matchgoodslistInfo))
        {
            //2.封装查询到的用户“购物清单”中匹配商品的信息
            matchgoodslist = new ArrayList<Matchgoodslist>();
            for (ShopGoodsDetailInfo temp : matchgoodslistInfo)
            {
                Matchgoodslist matchgoods = new Matchgoodslist();
                matchgoods.setGoodsid(temp.getGoodsBaseInfo().getGoodsId());
                matchgoods.setGoodsname(temp.getGoodsBaseInfo().getGoodsName());
                matchgoods.setPrice(temp.getGoodsBaseInfo().getPrice().toString());
                matchgoods.setGoodsimg(temp.getGoodsMarketingInfo().getGoodsImg());
                matchgoods.setShopid(temp.getGoodsMarketingInfo().getShopId());
                matchgoods.setShopentityid(temp.getGoodsMarketingInfo().getShopEntityId());
                matchgoods.setPositionname(temp.getPositionName());
                matchgoods.setGoodscontent(temp.getGoodsMarketingInfo().getGoodsContent());
                matchgoods.setShopname(temp.getShopName());
                matchgoods.setIntroduceurl(UrlUtils.getGoodsMobileUrl(temp.getGoodsBaseInfo().getGoodsId()));
                matchgoodslist.add(matchgoods);
            }
        }

        //3.组装返回数据
        ShoppingMatchDetileRoot root = new ShoppingMatchDetileRoot();
        root.setMatchgoodslist(matchgoodslist);
        return root;
    }

    @Override
    public MarketingactivityRoot getMarketingactivity(String type, String date) throws Exception
    {
        GooagooLog.info("getMarketingactivity-->入参:type=" + type + ",date=" + date);

        //1.根据时间查询是否有活动  type 查询类型（Y-年，M-月）date 查询时间（年-YYYY，月-YYYY-MM

        List<Map<String, String>> marketingActivityInfo = this.activityQueryService.getMarketingActivityInfo(type, date);

        GooagooLog.debug("根据时间查询到的活动信息为:  " + new Gson().toJson(marketingActivityInfo));
        List<Marketingactivity> marketingactivity = null;
        if (CollectionUtils.isNotEmpty(marketingActivityInfo))
        {
            //2.组装查询到的活动信息
            marketingactivity = new ArrayList<Marketingactivity>();
            for (Map<String, String> temp : marketingActivityInfo)
            {
                Marketingactivity tMarketingactivity = new Marketingactivity();
                tMarketingactivity.setDate(temp.get("date"));
                tMarketingactivity.setType(temp.get("type"));
                marketingactivity.add(tMarketingactivity);
            }

        }

        //3.组装返回数据
        MarketingactivityRoot root = new MarketingactivityRoot();
        root.setMarketingactivity(marketingactivity);
        return root;
    }

    @Override
    public ActivitylistRoot getActivityList(String startDate, String endDate, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("getActivityList-->入参:startDate=" + startDate + ",endDate=" + endDate + " ,pageIndex=" + pageIndex + " ,pageSize=" + pageSize);
        //1.查询活动列表信息
        List<ActivitylistBusiness> activitylistBusinessList = this.activityQueryService.getActivitylistInfo(TimeUtils.convertStringToDate(startDate), TimeUtils.convertStringToDate(endDate), pageIndex, pageSize);
        GooagooLog.debug("查询到的活动列表信息为： " + new Gson().toJson(activitylistBusinessList));
        List<Activitylist> activitylists = null;
        if (CollectionUtils.isNotEmpty(activitylistBusinessList))
        { //2.封装查询到的活动列表信息
            activitylists = new ArrayList<Activitylist>();
            for (ActivitylistBusiness temp : activitylistBusinessList)
            {
                Activitylist activitylist = new Activitylist();
                activitylist.setActivitytypename(temp.getActivitytypename());
                List<Activity> activityList = null;
                if (CollectionUtils.isNotEmpty(temp.getActivityBusinessList()))
                {
                    activityList = new ArrayList<Activity>();
                    //活动列表
                    for (ActivityBusiness t : temp.getActivityBusinessList())
                    {
                        Activity activity = new Activity();
                        activity.setActivityid(t.getActivityid());
                        activity.setActivityshoptype(t.getActivityshoptype());
                        activity.setShopid(t.getShopid());
                        activity.setShopname(t.getShopname());
                        activity.setActivityname(t.getActivityname());
                        activity.setTitle(t.getTitle());
                        activity.setStarttime(t.getStarttime());
                        activity.setEndtime(t.getEndtime());
                        activity.setImgurl(t.getImgurl());
                        activity.setActivityurl(t.getActivityurl());
                        activity.setContent(t.getContent());
                        activity.setPurpose(t.getPurpose());
                        activity.setDescription(t.getDescription());
                        activityList.add(activity);
                    }
                }
                activitylist.setActivity(activityList);
                activitylists.add(activitylist);
            }

        }

        //3.组装返回数据
        ActivitylistRoot root = new ActivitylistRoot();
        root.setActivitylist(activitylists);
        return root;
    }

    @Override
    public UserShoppingPlanBTARoot shoppingPlanSynStepA(String userId, String sessionId, String userShoppingPlan) throws Exception
    {
        GooagooLog.info("shoppingPlanSynStepA-->入参:userId=" + userId + ",sessionId=" + sessionId + ",userShoppingPlan=" + userShoppingPlan);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);

        //2.购物清单批量同步第一步
        List<Map<String, String>> usershoppingplan = new Gson().fromJson(userShoppingPlan, new TypeToken<List<Map<String, String>>>()
        {
        }.getType());

        ShoppingPlanDetailStepA shoppingPlanSynStepA = this.shoppingPlanQueryService.shoppingPlanSynStepA(userId, usershoppingplan);

        GooagooLog.debug("购物清单批量同步第一步" + new Gson().toJson(shoppingPlanSynStepA));
        //3.封装查询到购物清单信息
        List<Usershoppingplanmob> usershoppingplanmobList = null;
        if (shoppingPlanSynStepA != null && CollectionUtils.isNotEmpty(shoppingPlanSynStepA.getShoppingPlanDetailStepBList()))
        {
            //购物计划
            usershoppingplanmobList = new ArrayList<Usershoppingplanmob>();
            for (ShoppingPlanDetailStepB temp : shoppingPlanSynStepA.getShoppingPlanDetailStepBList())
            {
                Usershoppingplanmob usershoppingplanmob = new Usershoppingplanmob();
                usershoppingplanmob.setShoppinglistid(temp.getUserShoppingPlan().getShoppingListId());
                usershoppingplanmob.setTitle(temp.getUserShoppingPlan().getTitle());
                usershoppingplanmob.setPreshoppingtime(TimeUtils.convertDateToString(temp.getUserShoppingPlan().getPreShoppingTime(), TimeUtils.FORMAT1));
                usershoppingplanmob.setInfosource(temp.getUserShoppingPlan().getInfoSource());
                usershoppingplanmob.setIsdel(temp.getUserShoppingPlan().getIsDel());
                usershoppingplanmob.setCreatetime(TimeUtils.convertDateToString(temp.getUserShoppingPlan().getPreShoppingTime(), TimeUtils.FORMAT1));
                usershoppingplanmob.setCtimestamp(TimeUtils.convertDateToString(temp.getUserShoppingPlan().getCTimeStamp(), TimeUtils.FORMAT1));
                //购物计划中的商品列表
                List<Shoppingplangoodsmob> shoppingplangoodsmobList = null;
                if (CollectionUtils.isNotEmpty(temp.getShoppingPlanGoodsList()))
                {
                    shoppingplangoodsmobList = new ArrayList<Shoppingplangoodsmob>();
                    for (ShoppingPlanGoods shoppingPlanGoods : temp.getShoppingPlanGoodsList())
                    {
                        Shoppingplangoodsmob shoppingplangoodsmob = new Shoppingplangoodsmob();
                        shoppingplangoodsmob.setShoppinggoodsid(shoppingPlanGoods.getShoppingGoodsId());
                        shoppingplangoodsmob.setGoodsid(shoppingPlanGoods.getGoodsId());
                        shoppingplangoodsmob.setGoodsname(shoppingPlanGoods.getGoodsName());
                        shoppingplangoodsmob.setGoodstypeid(shoppingPlanGoods.getGoodsTypeId() != null ? shoppingPlanGoods.getGoodsTypeId().toString() : "");
                        shoppingplangoodsmob.setGoodstypename(shoppingPlanGoods.getGoodsTypeName());
                        shoppingplangoodsmob.setShopid(shoppingPlanGoods.getShopId());
                        shoppingplangoodsmob.setShopname(shoppingPlanGoods.getShopName());
                        shoppingplangoodsmob.setIsdel(shoppingPlanGoods.getIsDel());
                        shoppingplangoodsmob.setCreatetime(TimeUtils.convertDateToString(shoppingPlanGoods.getCreateTime(), TimeUtils.FORMAT1));
                        shoppingplangoodsmob.setCtimestamp(TimeUtils.convertDateToString(shoppingPlanGoods.getCTimeStamp(), TimeUtils.FORMAT1));
                        shoppingplangoodsmobList.add(shoppingplangoodsmob);
                    }
                }
                usershoppingplanmob.setShoppingplangoodsmob(shoppingplangoodsmobList);
                usershoppingplanmobList.add(usershoppingplanmob);
            }
        }

        //4.组装返回数据
        UserShoppingPlanBTARoot root = new UserShoppingPlanBTARoot();
        root.setUsershoppingplanmob(usershoppingplanmobList);
        root.setMobilechange(shoppingPlanSynStepA != null ? shoppingPlanSynStepA.getMobilechange() : null);
        return root;
    }

    @Override
    public UserShoppingPlanBTBRoot shoppingPlanSynStepB(String userId, String sessionId, String userShoppingPlan) throws Exception
    {
        GooagooLog.info("shoppingPlanSynStepB-->入参:userId=" + userId + ",sessionId=" + sessionId + ",userShoppingPlan=" + userShoppingPlan);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //获取购物清单详细信息
        List<ShoppingPlanDetailStepB> shoppingPlanDetailList = this.putShoppingPlanDetailInfo(userId, userShoppingPlan);

        List<Map<String, String>> shoppingPlanSynStepB = this.shoppingPlanSynCoreService.shoppingPlanSynStepB(shoppingPlanDetailList);
        GooagooLog.debug("购物清单批量同步第二步" + new Gson().toJson(shoppingPlanSynStepB));

        List<Usershoppingplanbtb> usershoppingplanbtbList = null;
        if (CollectionUtils.isNotEmpty(shoppingPlanSynStepB))
        {
            usershoppingplanbtbList = new ArrayList<Usershoppingplanbtb>();
            for (Map<String, String> temp : shoppingPlanSynStepB)
            {
                Usershoppingplanbtb usershoppingplanbtb = new Usershoppingplanbtb();
                usershoppingplanbtb.setShoppinglistid(temp.get("shoppinglistid"));
                usershoppingplanbtb.setShoppinglistidm(temp.get("shoppinglistidm"));
                usershoppingplanbtbList.add(usershoppingplanbtb);
            }
        }

        //组装返回参数
        UserShoppingPlanBTBRoot root = new UserShoppingPlanBTBRoot();
        root.setUsershoppingplanbtb(usershoppingplanbtbList);
        return root;
    }

    private List<ShoppingPlanDetailStepB> putShoppingPlanDetailInfo(String userId, String userShoppingPlanJson) throws Exception
    {
        ShoppingPlanDetailStepBEntity shoppingPlanDetailStepBEntity = new Gson().fromJson(userShoppingPlanJson, ShoppingPlanDetailStepBEntity.class);
        List<ShoppingPlanDetailStepB> shoppingPlanDetailList = null;
        if (shoppingPlanDetailStepBEntity != null && CollectionUtils.isNotEmpty(shoppingPlanDetailStepBEntity.getUsershoppingplanS()))
        {
            shoppingPlanDetailList = new ArrayList<ShoppingPlanDetailStepB>();
            for (UsershoppingPlanEntity usershoppingplanS : shoppingPlanDetailStepBEntity.getUsershoppingplanS())
            {
                //购物计划基本信息
                UserShoppingPlan userShoppingPlan = new UserShoppingPlan();
                userShoppingPlan.setShoppingListId(usershoppingplanS.getShoppinglistid());
                userShoppingPlan.setUserId(userId);
                userShoppingPlan.setTitle(usershoppingplanS.getTitle());
                userShoppingPlan.setInfoSource("M");//信息来源，M-手机端,W-网站端
                userShoppingPlan.setIsDel(usershoppingplanS.getIsdel());
                userShoppingPlan.setPreShoppingTime(TimeUtils.convertStringToDate(usershoppingplanS.getPreshoppingtime()));
                userShoppingPlan.setCreateTime(TimeUtils.convertStringToDate(usershoppingplanS.getCreatetime()));
                userShoppingPlan.setCTimeStamp(TimeUtils.convertStringToDate(usershoppingplanS.getCtimestamp()));
                List<ShoppingPlanGoods> shoppingPlanGoodsList = null;
                if (CollectionUtils.isNotEmpty(usershoppingplanS.getShoppinggoodslistS()))
                {
                    shoppingPlanGoodsList = new ArrayList<ShoppingPlanGoods>();
                    for (ShoppingPlanGoodsEntity shoppinggoodslist : usershoppingplanS.getShoppinggoodslistS())
                    {
                        ShoppingPlanGoods shoppingPlanGoods = new ShoppingPlanGoods();
                        shoppingPlanGoods.setShoppingGoodsId(shoppinggoodslist.getShoppinggoodsid());
                        shoppingPlanGoods.setGoodsId(shoppinggoodslist.getGoodsid());
                        shoppingPlanGoods.setGoodsName(shoppinggoodslist.getGoodsname());
                        shoppingPlanGoods.setGoodsTypeId(StringUtils.hasText(shoppinggoodslist.getGoodstypeid()) ? Integer.valueOf(shoppinggoodslist.getGoodstypeid().trim()) : null);
                        shoppingPlanGoods.setGoodsTypeName(shoppinggoodslist.getGoodstypename());
                        shoppingPlanGoods.setShopId(shoppinggoodslist.getShopid());
                        shoppingPlanGoods.setShopName(shoppinggoodslist.getShopname());
                        shoppingPlanGoods.setIsDel(shoppinggoodslist.getIsdel());
                        shoppingPlanGoods.setCreateTime(TimeUtils.convertStringToDate(shoppinggoodslist.getCreatetime()));
                        shoppingPlanGoods.setCTimeStamp(TimeUtils.convertStringToDate(shoppinggoodslist.getCtimestamp()));
                        shoppingPlanGoodsList.add(shoppingPlanGoods);
                    }
                }

                ShoppingPlanDetailStepB shoppingPlanDetailStepB = new ShoppingPlanDetailStepB();
                shoppingPlanDetailStepB.setShoppingPlanGoodsList(shoppingPlanGoodsList);
                shoppingPlanDetailStepB.setUserShoppingPlan(userShoppingPlan);
                shoppingPlanDetailList.add(shoppingPlanDetailStepB);
            }
        }
        return shoppingPlanDetailList;
    }

    @Override
    public ShoppingMatchActiveRoot shoppingMatch(String mac, String userId, String sessionId, String keyWord) throws Exception
    {
        GooagooLog.info("shoppingMatch-->入参:userId=" + userId + ",sessionId=" + sessionId + ",keyWord=" + keyWord);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);

        //2.购物匹配（主动）
        List<PositionInfo> shoppingMatch = this.shoppingMatchQueryService.shoppingMatch(userId, null, keyWord);

        GooagooLog.debug("购物匹配（主动)" + new Gson().toJson(shoppingMatch));
        List<Position> positionList = null;
        if (CollectionUtils.isNotEmpty(shoppingMatch))
        {
            //3.封装匹配的信息
            positionList = new ArrayList<Position>();
            for (PositionInfo temp : shoppingMatch)
            {
                Position position = new Position();
                position.setPositionid(temp.getPositionid());
                position.setPositionname(temp.getPositionname());
                List<Matchlist> matchlists = null;
                //购物匹配列表
                if (CollectionUtils.isNotEmpty(temp.getMatchlist()))
                {
                    matchlists = new ArrayList<Matchlist>();
                    for (MatchInfoList t : temp.getMatchlist())
                    {
                        Matchlist matchlist = new Matchlist();
                        matchlist.setGoodsid(t.getGoodsid());
                        matchlist.setGoodsname(t.getGoodsname());
                        matchlist.setKeyword(t.getKeyword());
                        matchlists.add(matchlist);
                    }
                }
                position.setMatchlist(matchlists);
                positionList.add(position);
            }

        }

        ShoppingMatchActiveRoot root = new ShoppingMatchActiveRoot();
        root.setPosition(positionList);
        return root;
    }

}
