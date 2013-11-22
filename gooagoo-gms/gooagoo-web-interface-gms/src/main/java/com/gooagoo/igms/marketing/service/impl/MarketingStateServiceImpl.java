package com.gooagoo.igms.marketing.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.statistics.BrowseStatisticQueryService;
import com.gooagoo.api.business.query.statistics.BuyStatisticQueryService;
import com.gooagoo.api.business.query.statistics.CollectStatisticQueryService;
import com.gooagoo.api.business.query.statistics.CommentsStatisticQueryService;
import com.gooagoo.api.business.query.statistics.CrowdOperationQueryService;
import com.gooagoo.api.business.query.statistics.ExchangeStatisticQueryService;
import com.gooagoo.api.business.query.statistics.ShareStatisticQueryService;
import com.gooagoo.api.business.query.statistics.UseStatisticQueryService;
import com.gooagoo.api.business.query.user.cache.UserCacheQueryService;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.business.user.account.property.PropertyRecord;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.marketing.service.MarketingStateService;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.hightChartVo.chartVo.ColumnChartsVo;
import com.gooagoo.view.gms.member.UserStatusView;
import com.gooagoo.view.gms.statistic.StatisticParameters;
import com.google.gson.Gson;

@Service(value = "marketingStateService")
public class MarketingStateServiceImpl implements MarketingStateService
{

    @Autowired
    private UseStatisticQueryService useStatisticService;
    @Autowired
    private CollectStatisticQueryService collectStatisticService;
    @Autowired
    private BrowseStatisticQueryService browseStatisticService;
    @Autowired
    private CommentsStatisticQueryService commentsStatisticService;
    @Autowired
    private ShareStatisticQueryService shareStatisticService;
    @Autowired
    private ExchangeStatisticQueryService exchangeStatisticService;
    @Autowired
    private BuyStatisticQueryService buyStatisticService;

    @Autowired
    private UserCacheQueryService userCacheQueryService;
    @Autowired
    private CrowdOperationQueryService crowdOperationQueryService;

    @Override
    public TransData<PageModel<UserStatusView>> findUserList(HttpServletRequest request) throws Exception
    {

        StatisticParameters sp = ServletUtils.objectMethod(StatisticParameters.class, request);

        PageModel<UserStatusView> pm = new PageModel<UserStatusView>();

        if ("tool".equals(sp.getName()))
        {
            pm = this.tool(request, sp);
        }
        else if ("coupon".equals(sp.getName()))
        {
            pm = this.coupon(request, sp);
        }
        else if ("brand".equals(sp.getName()))
        {
            pm = this.brand(request, sp);
        }
        else if ("category".equals(sp.getName()))
        {
            pm = this.category(request, sp);
        }
        else if ("goods".equals(sp.getName()))
        {
            pm = this.goods(request, sp);
        }
        else if ("activity".equals(sp.getName()))
        {
            pm = this.activity(request, sp);
        }
        else if ("cryout".equals(sp.getName()))
        {
            pm = this.cryoutBrowse(request, sp);
        }
        else if ("notice".equals(sp.getName()))
        {
            pm = this.noticeBrowse(request, sp);
        }
        else if ("ps".equals(sp.getName()))
        { //手机服务
            pm = this.phoneServer(request, sp);
        }
        else if ("pac".equals(sp.getName()))
        { //购好奇
            pm = this.purchaseAndCurious(request, sp);
        }
        return new TransData<PageModel<UserStatusView>>(true, null, pm);
    }

    private PageModel<UserStatusView> purchaseAndCurious(HttpServletRequest request, StatisticParameters sp) throws Exception
    {
        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getTimeVal());
        String dateType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        List<String> userIds = this.browseStatisticService.purchaseAndcuriosityBrowsPeople(sp.getId(), dateType, sp.getUserType(), dateTime);
        PageModel<UserStatusView> pm = this.convertToPageModel(sp.getShopIdOrEntityId(), request, userIds);

        this.printMessage("browseStatisticService.purchaseAndcuriosityBrowsPeople(sp.getId(), sp.getTimeTypeVal(), sp.getUserType(), dateTime)", sp.getId() + "," + sp.getTimeTypeVal() + "," + sp.getUserType() + "," + sp.getSource() + "," + dateTime, userIds);

        return pm;
    }

    private PageModel<UserStatusView> phoneServer(HttpServletRequest request, StatisticParameters sp) throws Exception
    {
        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getTimeVal());
        String dateType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        List<String> userIds = this.browseStatisticService.toolsBrowsPeople(sp.getShopIdOrEntityId(), sp.getId(), sp.getUserType(), dateType, dateTime);
        PageModel<UserStatusView> pm = this.convertToPageModel(sp.getShopIdOrEntityId(), request, userIds);

        this.printMessage("browseStatisticService.toolsBrowsPeople(sp.getId(), sp.getUserType(), sp.getTimeTypeVal(), dateTime)", sp.getId() + "," + sp.getUserType() + "," + sp.getTimeTypeVal() + "," + dateTime, userIds);

        return pm;
    }

    /**
     * 服务工具 统计用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> tool(HttpServletRequest request, StatisticParameters sp) throws Exception
    {
        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getTimeVal());
        String dateType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        return this.toolUse(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime);
    }

    /**
     * 服务工具使用 用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> toolUse(HttpServletRequest request, String shopId, String toolId, String dateType, String userType, Date dateTime) throws Exception
    {
        List<String> userIds = this.useStatisticService.toolUsePoeple(shopId, toolId, dateType, userType, dateTime);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("this.useStatisticService.toolUseTimes(shopId, toolId, dateType, userType, dateTime)", shopId + "," + toolId + "," + userType + "," + dateType + "," + dateTime, userIds);

        return pm;
    }

    /**
     * 优惠劵 统计用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> coupon(HttpServletRequest request, StatisticParameters sp) throws Exception
    {
        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getTimeVal());
        String dateType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        if ("collect".equals(sp.getBehType()))
        {
            return this.couponCollect(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime, sp.getChannel(), sp.getSource());
        }
        else if ("browse".equals(sp.getBehType()))
        {
            return this.couponBrowse(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime, sp.getChannel(), sp.getSource());
        }
        else if ("use".equals(sp.getBehType()))
        {
            return this.couponUse(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime);
        }
        else if ("share".equals(sp.getBehType()))
        {
            return this.couponShare(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime);
        }
        else if ("exchange".equals(sp.getBehType()))
        {
            return this.couponExchange(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime);
        }
        return null;
    }

    /**
     * 优惠卷 收藏用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> couponCollect(HttpServletRequest request, String shopId, String couponId, String dateType, String userType, Date dateTime, String channel, String source) throws Exception
    {
        List<String> userIds = this.collectStatisticService.couponCollectPeople(couponId, userType, dateType, dateTime, channel, source);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("collectStatisticService.couponCollectTimes(couponId, userType, dateType, dateTime, channel, source)", couponId + "," + userType + "," + dateType + "," + dateTime + "," + channel + "," + source, userIds);

        return pm;
    }

    /**
     * 优惠卷 浏览用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> couponBrowse(HttpServletRequest request, String shopId, String couponId, String dateType, String userType, Date dateTime, String channel, String source) throws Exception
    {
        List<String> userIds = this.browseStatisticService.couponBrowsPeople(couponId, userType, dateType, dateTime, channel, source);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("browseStatisticService.couponBrowsTimes(couponId, userType, dateType, dateTime, channel, source)", couponId + "," + userType + "," + dateType + "," + dateTime + "," + channel + "," + source, userIds);

        return pm;
    }

    /**
     * 优惠凭证 使用用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> couponUse(HttpServletRequest request, String shopId, String couponId, String dateType, String userType, Date dateTime) throws Exception
    {
        List<String> userIds = this.useStatisticService.couponUsePeople(couponId, userType, dateType, dateTime);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("useStatisticService.couponUseTimes(couponId, userType, dateType, dateTime)", couponId + "," + userType + "," + dateType + "," + dateTime, userIds);

        return pm;
    }

    /**
     * 优惠凭证 分享用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> couponShare(HttpServletRequest request, String shopId, String couponId, String dateType, String userType, Date dateTime) throws Exception
    {
        List<String> userIds = this.shareStatisticService.couponSharePeople(couponId, userType, dateType, dateTime);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("shareStatisticService.couponShareTimes(couponId, userType, dateType, dateTime)", couponId + "," + userType + "," + dateType + "," + dateTime, userIds);

        return pm;
    }

    /**
     * 优惠凭证 兑换用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> couponExchange(HttpServletRequest request, String shopId, String couponId, String dateType, String userType, Date dateTime) throws Exception
    {
        List<String> userIds = this.exchangeStatisticService.couponExchangePeople(couponId, userType, dateType, dateTime);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("exchangeStatisticService.couponExchangeTimes(couponId, userType, dateType, dateTime)", couponId + "," + userType + "," + dateType + "," + dateTime, userIds);

        return pm;
    }

    /**
     * 品牌 统计用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> brand(HttpServletRequest request, StatisticParameters sp) throws Exception
    {
        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getTimeVal());
        String dateType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        if ("comments".equals(sp.getBehType()))
        {
            return this.brandComments(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime, sp.getSource());
        }
        else if ("collect".equals(sp.getBehType()))
        {
            return this.brandCollect(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime, sp.getSource(), sp.getChannel());
        }
        else if ("buy".equals(sp.getBehType()))
        {
            return this.brandBuy(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime);
        }
        else if ("browse".equals(sp.getBehType()))
        {
            return this.brandBrowse(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime, sp.getSource(), sp.getChannel());
        }
        return null;
    }

    /**
     * 品牌 评论用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> brandComments(HttpServletRequest request, String shopId, String brandId, String dateType, String userType, Date dateTime, String source) throws Exception
    {
        List<String> userIds = this.commentsStatisticService.brandCommentPeople(shopId, brandId, dateType, userType, dateTime, source);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("commentsStatisticService.brandCommentTimes(shopId, brandId, dateType, userType, dateTime, source)", shopId + "," + brandId + "," + dateType + "," + userType + "," + dateTime + "," + source, userIds);

        return pm;
    }

    /**
     * 品牌 收藏用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> brandCollect(HttpServletRequest request, String shopId, String brandId, String dateType, String userType, Date dateTime, String source, String channel) throws Exception
    {
        List<String> userIds = this.collectStatisticService.brandCollectPoeple(shopId, brandId, dateType, userType, channel, source, dateTime);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("collectStatisticService.brandCollectTimes(shopId, brandId, dateType, userType, dateTime, source, dateTime)", shopId + "," + brandId + "," + dateType + "," + userType + "," + dateTime + "," + source + "," + dateTime, userIds);

        return pm;
    }

    /**
     * 品牌 购买用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> brandBuy(HttpServletRequest request, String shopId, String brandId, String dateType, String userType, Date dateTime) throws Exception
    {
        List<String> userIds = this.buyStatisticService.brandBuyPeople(shopId, brandId, dateType, userType, dateTime);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("buyStatisticService.brandBuyTimes(shopId, brandId, dateType, userType, dateTime)", shopId + "," + brandId + "," + dateType + "," + userType + "," + dateTime + "," + dateTime, userIds);

        return pm;
    }

    /**
     * 品牌 浏览用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> brandBrowse(HttpServletRequest request, String shopId, String brandId, String dateType, String userType, Date dateTime, String source, String channel) throws Exception
    {
        List<String> userIds = this.browseStatisticService.brandBrowsPoeple(shopId, brandId, dateType, userType, channel, dateTime, source);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("browseStatisticService.brandBrowsTimes(shopId, brandId, dateType, userType, channel, dateTime, source)", shopId + "," + brandId + "," + dateType + "," + userType + "," + channel + "," + dateTime + "," + source, userIds);

        return pm;
    }

    /**
     * 品类 统计用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> category(HttpServletRequest request, StatisticParameters sp) throws Exception
    {

        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getColumn());
        String dateType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        if ("comments".equals(sp.getBehType()))
        {
            return this.categoryComments(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime, sp.getSource());
        }
        else if ("collect".equals(sp.getBehType()))
        {
            return this.categoryCollect(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime, sp.getSource(), sp.getChannel());
        }
        else if ("buy".equals(sp.getBehType()))
        {
            return this.categoryBuy(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime);
        }
        else if ("browse".equals(sp.getBehType()))
        {
            return this.categoryBrowse(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime, sp.getSource(), sp.getChannel());
        }
        return null;
    }

    /**
     * 品类 评论用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> categoryComments(HttpServletRequest request, String shopId, String categoryId, String dateType, String userType, Date dateTime, String source) throws Exception
    {
        List<String> userIds = this.commentsStatisticService.categoryCommentPeople(shopId, categoryId, dateType, userType, dateTime, source);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("commentsStatisticService.categoryCommentTimes(shopId, categoryId, dateType, userType, dateTime, source)", shopId + "," + categoryId + "," + dateType + "," + userType + "," + dateTime + "," + source, userIds);

        return pm;
    }

    /**
     * 品类 收藏用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> categoryCollect(HttpServletRequest request, String shopId, String categoryId, String dateType, String userType, Date dateTime, String source, String channel) throws Exception
    {
        List<String> userIds = this.collectStatisticService.categoryCollectPoeple(shopId, categoryId, dateType, userType, channel, source, dateTime);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("collectStatisticService.categoryCollectTimes(shopId, categoryId, dateType, userType, channel, source, dateTime)", shopId + "," + categoryId + "," + dateType + "," + userType + "," + channel + "," + source + "," + dateTime, userIds);

        return pm;
    }

    /**
     * 品类 购买用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> categoryBuy(HttpServletRequest request, String shopId, String categoryId, String dateType, String userType, Date dateTime) throws Exception
    {
        List<String> userIds = this.buyStatisticService.categoryBuyPeople(shopId, categoryId, dateType, userType, dateTime);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("buyStatisticService.categoryBuyTimes(shopId, categoryId, dateType, userType, dateTime)", shopId + "," + categoryId + "," + dateType + "," + userType + "," + "," + dateTime, userIds);

        return pm;
    }

    /**
     * 品类 浏览用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> categoryBrowse(HttpServletRequest request, String shopId, String categoryId, String dateType, String userType, Date dateTime, String source, String channel) throws Exception
    {
        List<String> userIds = this.browseStatisticService.categoryBrowsPoeple(shopId, categoryId, dateType, userType, channel, dateTime, source);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("browseStatisticService.categoryBrowsTimes(shopId, categoryId, dateType, userType, channel, dateTime, source)", shopId + "," + categoryId + "," + dateType + "," + userType + "," + channel + "," + dateTime + "," + source, userIds);

        return pm;
    }

    private PageModel<UserStatusView> goods(HttpServletRequest request, StatisticParameters sp) throws Exception
    {

        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getColumn());
        String dateType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        if ("comments".equals(sp.getBehType()))
        {
            return this.goodsComments(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime, sp.getSource());
        }
        else if ("collect".equals(sp.getBehType()))
        {
            return this.goodsCollect(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime, sp.getSource(), sp.getChannel());
        }
        else if ("buy".equals(sp.getBehType()))
        {
            return this.goodsBuy(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime);
        }
        else if ("browse".equals(sp.getBehType()))
        {
            return this.goodsBrowse(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime, sp.getSource(), sp.getChannel());
        }
        return null;
    }

    /**
     * 商品 评论用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> goodsComments(HttpServletRequest request, String shopId, String goodsId, String dateType, String userType, Date dateTime, String source) throws Exception
    {
        List<String> userIds = this.commentsStatisticService.goodsCommentPeople(shopId, goodsId, dateType, userType, dateTime, source);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("this.commentsStatisticService.goodsCommentTimes(shopId, goodsId, dateType, userType, dateTime, source)", shopId + "," + goodsId + "," + dateType + "," + userType + "," + dateTime + "," + source, userIds);

        return pm;
    }

    /**
     * 商品 收藏用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> goodsCollect(HttpServletRequest request, String shopId, String goodsId, String dateType, String userType, Date dateTime, String source, String channel) throws Exception
    {
        List<String> userIds = this.collectStatisticService.goodsCollectPoeple(shopId, goodsId, dateType, userType, channel, source, dateTime);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("this.collectStatisticService.goodsCollectTimes(shopId, goodsId, dateType, userType, channel, source, dateTime)", shopId + "," + goodsId + "," + dateType + "," + userType + "," + channel + "," + source + "," + dateTime, userIds);

        return pm;
    }

    /**
     * 商品 购买用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> goodsBuy(HttpServletRequest request, String shopId, String goodsId, String dateType, String userType, Date dateTime) throws Exception
    {
        List<String> userIds = this.buyStatisticService.goodsBuyPeople(shopId, goodsId, dateType, userType, dateTime);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("buyStatisticService.goodsBuyTimes(shopId, goodsId, dateType, userType, dateTime)", shopId + "," + goodsId + "," + dateType + "," + userType + "," + dateTime, userIds);

        return pm;
    }

    /**
     * 商品 浏览用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> goodsBrowse(HttpServletRequest request, String shopId, String goodsId, String dateType, String userType, Date dateTime, String source, String channel) throws Exception
    {
        List<String> userIds = this.browseStatisticService.goodsBrowsPoeple(shopId, goodsId, dateType, userType, channel, dateTime, source);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("browseStatisticService.goodsBrowsTimes(shopId, goodsId, dateType, userType, channel, dateTime, source)", shopId + "," + goodsId + "," + dateType + "," + userType + "," + channel + "," + dateTime + "," + source, userIds);

        return pm;
    }

    private PageModel<UserStatusView> activity(HttpServletRequest request, StatisticParameters sp) throws Exception
    {

        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getTimeVal());
        String dateType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        if ("collect".equals(sp.getBehType()))
        {
            return this.activityCollect(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime, sp.getSource(), sp.getChannel());
        }
        else if ("browse".equals(sp.getBehType()))
        {
            return this.activityBrowse(request, sp.getShopIdOrEntityId(), sp.getId(), dateType, sp.getUserType(), dateTime, sp.getSource(), sp.getChannel());
        }
        return null;
    }

    /**
     * 活动 浏览用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> activityBrowse(HttpServletRequest request, String shopId, String activityId, String dateType, String userType, Date dateTime, String source, String channel) throws Exception
    {
        List<String> userIds = this.browseStatisticService.activityBrowsPoeple(activityId, userType, dateType, dateTime, channel, source);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("browseStatisticService.activityBrowsTimes(activityId, userType, dateType, dateTime, channel, source)", activityId + "," + userType + "," + dateType + "," + dateTime + "," + channel + "," + source, userIds);

        return pm;
    }

    /**
     * 活动 收藏用户信息列
     * 
     * @param request
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> activityCollect(HttpServletRequest request, String shopId, String activityId, String dateType, String userType, Date dateTime, String source, String channel) throws Exception
    {
        List<String> userIds = this.collectStatisticService.activityCollectPoeple(activityId, userType, dateType, dateTime, channel, source);
        PageModel<UserStatusView> pm = this.convertToPageModel(shopId, request, userIds);

        this.printMessage("collectStatisticService.activityCollectTimes(activityId, userType, dateType, dateTime, channel, source)", activityId + "," + userType + "," + dateType + "," + dateTime + "," + channel + "," + source, userIds);

        return pm;
    }

    /**
     * 吆喝 浏览用户信息列
     * 
     * @param request
     * @param sp
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> cryoutBrowse(HttpServletRequest request, StatisticParameters sp) throws Exception
    {
        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getTimeVal());
        String dateType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        List<String> userIds = this.browseStatisticService.cryoutBrowsPeople(sp.getId(), dateType, sp.getUserType(), sp.getSource(), dateTime);
        PageModel<UserStatusView> pm = this.convertToPageModel(sp.getShopIdOrEntityId(), request, userIds);

        this.printMessage("browseStatisticService.cryoutBrowsTimes(sp.getId(), sp.getTimeTypeVal(), sp.getUserType(), sp.getSource(), dateTime)", sp.getId() + "," + sp.getTimeTypeVal() + "," + sp.getUserType() + "," + sp.getSource() + "," + dateTime, userIds);

        return pm;
    }

    /**
     * 通知 浏览用户信息列
     * 
     * @param request
     * @param sp
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> noticeBrowse(HttpServletRequest request, StatisticParameters sp) throws Exception
    {

        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getTimeVal());
        String timeType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        List<String> userIds = this.browseStatisticService.noticeBrowsPeople(sp.getId(), timeType, sp.getUserType(), sp.getSource(), dateTime);
        PageModel<UserStatusView> pm = this.convertToPageModel(sp.getShopIdOrEntityId(), request, userIds);

        this.printMessage("browseStatisticService.noticeBrowsTimes(sp.getId(), sp.getTimeTypeVal(), sp.getUserType(), sp.getSource(), dateTime)", sp.getId() + "," + sp.getTimeTypeVal() + "," + sp.getUserType() + "," + sp.getSource() + "," + dateTime, userIds);

        return pm;
    }

    /**
     * 组装用户列表
     * 
     * @param shopId
     * @param count
     * @param pageIndex
     * @param pageSize
     * @param userIds
     * @return
     * @throws Exception
     */
    private PageModel<UserStatusView> convertToPageModel(String shopId, HttpServletRequest request, List<String> userIds) throws Exception
    {
        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);

        PageModel<UserStatusView> pm = new PageModel<UserStatusView>();

        int count = 0;
        if (!CollectionUtils.isEmpty(userIds))
        {
            count = userIds.size();
        }
        pm.setCount(count);
        pm.setPageIndex(pageIndex);
        pm.setPageSize(pageSize);
        List<UserStatusView> result = new ArrayList<UserStatusView>();
        for (String e : userIds)
        {
            String t[] = e.split("_");
            if (t.length == 2)
            {
                UserStatusView usv = new UserStatusView();
                try
                {
                    PropertyRecord pr = this.userCacheQueryService.getUserPropertyRecord(shopId, t[0], t[1]);
                    usv = this.convertToUserStatusView(pr);
                }
                catch (Exception e1)
                {
                    GooagooLog.error("营销状态获取为群列表跟据帐号帐号类型或取用户详细信息时错误！", e1);
                }
                String accountType = SysdictionaryCache.get("user_type", t[0]);
                usv.setAccount(t[1]);
                usv.setAccountType(accountType);
                result.add(usv);
            }
        }
        pm.setResult(result);
        return pm;
    }

    private UserStatusView convertToUserStatusView(PropertyRecord pr)
    {
        UserStatusView usv = null;
        if (pr != null)
        {
            usv = new UserStatusView();
            usv.setUserId(pr.getAccountTypeInfo().getUserId());
            usv.setAccount(pr.getAccountTypeInfo().getUserId());
            usv.setGooagooId(pr.getAccountTypeInfo().getGooagooId());
            usv.setName(pr.getAccountBaseInfo().getName());
            usv.setSex(pr.getAccountBaseInfo().getSex());
            usv.setBirthday(pr.getAccountBaseInfo().getBirthday());
            usv.setPhone(pr.getAccountBaseInfo().getTelephone());
            usv.setMac(pr.getAccountTypeInfo().getMac());
        }
        return usv;
    }

    @Override
    public TransData<Object> saveCowds(HttpServletRequest request) throws Exception
    {

        String crowdName = ServletRequestUtils.getStringParameter(request, "crowdName", "");
        String crowdDesc = ServletRequestUtils.getStringParameter(request, "crowdDesc", "");
        StatisticParameters sp = ServletUtils.objectMethod(StatisticParameters.class, request);
        List<Account> accounts = null;
        if ("tool".equals(sp.getName()))
        {
            accounts = this.toolAccounts(request, sp);
        }
        else if ("coupon".equals(sp.getName()))
        {
            accounts = this.couponAccounts(request, sp);
        }
        else if ("brand".equals(sp.getName()))
        {
            accounts = this.brandAccounts(request, sp);
        }
        else if ("category".equals(sp.getName()))
        {
            accounts = this.categoryAccounts(request, sp);
        }
        else if ("goods".equals(sp.getName()))
        {
            accounts = this.goodsAccounts(request, sp);
        }
        else if ("activity".equals(sp.getName()))
        {
            accounts = this.activityAccounts(request, sp);
        }
        else if ("cryout".equals(sp.getName()))
        {
            accounts = this.cryoutAccounts(request, sp);
        }
        else if ("notice".equals(sp.getName()))
        {
            accounts = this.noticeAccounts(request, sp);
        }
        else if ("ps".equals(sp.getName()))
        {
            accounts = this.phoneServerAccounts(request, sp);
        }
        else if ("pac".equals(sp.getName()))
        {
            accounts = this.purchaseAndcuriosityAccounts(request, sp);
        }
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        boolean saveCrowd = this.crowdOperationQueryService.saveCrowd(shopId, crowdName, crowdDesc, accounts);

        return GMSUtil.getBooleanResult(saveCrowd, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
    }

    private List<Account> purchaseAndcuriosityAccounts(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getTimeVal());
        String dateType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        List<String> userIds = this.browseStatisticService.purchaseAndcuriosityBrowsPeople(sp.getId(), dateType, sp.getUserType(), dateTime);
        List<Account> accounts = this.convertToAccount(userIds);
        return accounts;
    }

    private List<Account> phoneServerAccounts(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getTimeVal());
        String dateType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        List<String> userIds = this.browseStatisticService.toolsBrowsPeople(sp.getShopIdOrEntityId(), sp.getId(), sp.getUserType(), dateType, dateTime);
        List<Account> accounts = this.convertToAccount(userIds);
        return accounts;
    }

    private List<Account> noticeAccounts(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getTimeVal());
        String dateType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        List<String> userIds = this.browseStatisticService.noticeBrowsPeople(sp.getId(), dateType, sp.getUserType(), sp.getSource(), dateTime);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("browseStatisticService.noticeBrowsPeople(sp.getId(), sp.getTimeTypeVal(), sp.getUserType(), sp.getSource(), dateTime)", sp.getId() + "," + sp.getTimeTypeVal() + "," + sp.getUserType() + "," + sp.getSource() + "," + dateTime, userIds);

        return accounts;
    }

    private List<Account> convertToAccount(List<String> userIds)
    {

        List<Account> accounts = new ArrayList<Account>(0);
        if (!CollectionUtils.isEmpty(userIds))
        {
            Account account = null;
            for (String str : userIds)
            {
                account = new Account();
                String[] split = str.split("_");
                if ("0".equals(split[0]))
                {
                    account.setUserId(split[1]);
                }
                else if ("2".equals(split[0]))
                {
                    account.setIp(split[1]);
                }
                else if ("3".equals(split[0]))
                {
                    account.setMac(split[1]);
                }
                else if ("7".equals(split[0]))
                {
                    account.setPhyCardNo(split[1]);
                }
                accounts.add(account);
            }
        }

        return accounts;
    }

    private List<Account> cryoutAccounts(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getTimeVal());
        String dateType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        List<String> userIds = this.browseStatisticService.cryoutBrowsPeople(sp.getId(), dateType, sp.getUserType(), sp.getSource(), dateTime);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("browseStatisticService.cryoutBrowsPeople(sp.getId(), sp.getTimeTypeVal(), sp.getUserType(), sp.getSource(), dateTime)", sp.getId() + "," + sp.getTimeTypeVal() + "," + sp.getUserType() + "," + sp.getSource() + "," + dateTime, userIds);

        return accounts;
    }

    private List<Account> activityAccounts(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getTimeVal());
        String timeType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        if ("collect".equals(sp.getBehType()))
        {
            return this.activityCollectAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime, sp.getSource(), sp.getChannel());
        }
        else if ("browse".equals(sp.getBehType()))
        {
            return this.activityBrowseAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime, sp.getSource(), sp.getChannel());
        }
        return null;
    }

    private List<Account> activityBrowseAccounts(HttpServletRequest request, String shopId, String activityId, String dateType, String userType, Date dateTime, String source, String channel)
    {
        List<String> userIds = this.browseStatisticService.activityBrowsPoeple(activityId, userType, dateType, dateTime, channel, source);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("browseStatisticService.activityBrowsPoeple(activityId, userType, dateType, dateTime, channel, source)", activityId + "," + userType + "," + dateType + "," + dateTime + "," + channel + "," + source, userIds);

        return accounts;
    }

    private List<Account> activityCollectAccounts(HttpServletRequest request, String shopId, String activityId, String dateType, String userType, Date dateTime, String source, String channel)
    {
        List<String> userIds = this.collectStatisticService.activityCollectPoeple(activityId, userType, dateType, dateTime, channel, source);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("collectStatisticService.activityCollectPoeple(activityId, userType, dateType, dateTime, channel, source)", activityId + "," + userType + "," + dateType + "," + dateTime + "," + channel + "," + source, userIds);

        return accounts;
    }

    private List<Account> goodsAccounts(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getTimeVal());
        String timeType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        if ("comments".equals(sp.getBehType()))
        {
            return this.goodsCommentsAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime, sp.getSource());
        }
        else if ("collect".equals(sp.getBehType()))
        {
            return this.goodsCollectAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime, sp.getSource(), sp.getChannel());
        }
        else if ("buy".equals(sp.getBehType()))
        {
            return this.goodsBuyAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime);
        }
        else if ("browse".equals(sp.getBehType()))
        {
            return this.goodsBrowseAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime, sp.getSource(), sp.getChannel());
        }
        return null;
    }

    private List<Account> goodsBrowseAccounts(HttpServletRequest request, String shopId, String goodsId, String dateType, String userType, Date dateTime, String source, String channel)
    {
        List<String> userIds = this.browseStatisticService.goodsBrowsPoeple(shopId, goodsId, dateType, userType, channel, dateTime, source);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("browseStatisticService.browseStatisticService(shopId, goodsId, dateType, userType, dateTime, source)", shopId + "," + goodsId + "," + dateType + "," + userType + "," + dateTime + "," + source, userIds);

        return accounts;
    }

    private List<Account> goodsBuyAccounts(HttpServletRequest request, String shopId, String goodsId, String dateType, String userType, Date dateTime)
    {
        List<String> userIds = this.buyStatisticService.goodsBuyPeople(shopId, goodsId, dateType, userType, dateTime);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("buyStatisticService.goodsBuyPeople(shopId, goodsId, dateType, userType, dateTime)", shopId + "," + goodsId + "," + dateType + "," + userType + "," + dateTime, userIds);

        return accounts;
    }

    private List<Account> goodsCollectAccounts(HttpServletRequest request, String shopId, String goodsId, String dateType, String userType, Date dateTime, String source, String channel)
    {
        List<String> userIds = this.collectStatisticService.goodsCollectPoeple(shopId, goodsId, dateType, userType, channel, source, dateTime);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("collectStatisticService.goodsCollectPoeple(shopId, goodsId, dateType, userType, channel, source, dateTime)", shopId + "," + goodsId + "," + dateType + "," + userType + "," + channel + "," + source + "," + "," + dateTime, userIds);

        return accounts;
    }

    private List<Account> goodsCommentsAccounts(HttpServletRequest request, String shopId, String goodsId, String dateType, String userType, Date dateTime, String source)
    {
        List<String> userIds = this.commentsStatisticService.goodsCommentPeople(shopId, goodsId, dateType, userType, dateTime, source);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("commentsStatisticService.goodsCommentPeople(shopId, goodsId, dateType, userType, dateTime, source)", shopId + "," + goodsId + "," + dateType + "," + userType + "," + dateTime + "," + source, userIds);

        return accounts;
    }

    private List<Account> categoryAccounts(HttpServletRequest request, StatisticParameters sp)
    {

        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getTimeVal());
        String timeType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        if ("comments".equals(sp.getBehType()))
        {
            return this.categoryCommentsAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime, sp.getSource());
        }
        else if ("collect".equals(sp.getBehType()))
        {
            return this.categoryCollectAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime, sp.getSource(), sp.getChannel());
        }
        else if ("buy".equals(sp.getBehType()))
        {
            return this.categoryBuyAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime);
        }
        else if ("browse".equals(sp.getBehType()))
        {
            return this.categoryBrowseAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime, sp.getSource(), sp.getChannel());
        }
        return null;
    }

    private List<Account> categoryBrowseAccounts(HttpServletRequest request, String shopId, String categoryId, String dateType, String userType, Date dateTime, String source, String channel)
    {
        List<String> userIds = this.browseStatisticService.categoryBrowsPoeple(shopId, categoryId, dateType, userType, channel, dateTime, source);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("browseStatisticService.categoryBrowsPoeple(shopId, categoryId, dateType, userType, channel, dateTime, source)", shopId + "," + categoryId + "," + dateType + "," + userType + "," + channel + "," + dateTime + "," + source, userIds);

        return accounts;
    }

    private List<Account> categoryBuyAccounts(HttpServletRequest request, String shopId, String categoryId, String dateType, String userType, Date dateTime)
    {
        List<String> userIds = this.buyStatisticService.categoryBuyPeople(shopId, categoryId, dateType, userType, dateTime);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("buyStatisticService.categoryBuyPeople(shopId, categoryId, dateType, userType, dateTime)", shopId + "," + categoryId + "," + dateType + "," + userType + "," + dateTime, userIds);

        return accounts;
    }

    private List<Account> categoryCollectAccounts(HttpServletRequest request, String shopId, String categoryId, String dateType, String userType, Date dateTime, String source, String channel)
    {
        List<String> userIds = this.collectStatisticService.categoryCollectPoeple(shopId, categoryId, dateType, userType, channel, source, dateTime);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("collectStatisticService.categoryCollectPoeple(shopId, categoryId, dateType, userType, channel, source, dateTime)", shopId + "," + categoryId + "," + dateType + "," + userType + "," + channel + "," + source + "," + dateTime, userIds);

        return accounts;
    }

    private List<Account> categoryCommentsAccounts(HttpServletRequest request, String shopId, String categoryId, String dateType, String userType, Date dateTime, String source)
    {
        List<String> userIds = this.commentsStatisticService.categoryCommentPeople(shopId, categoryId, dateType, userType, dateTime, source);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("commentsStatisticService.categoryCommentPeople(shopId, categoryId, dateType, userType, dateTime, source)", shopId + "," + categoryId + "," + dateType + "," + userType + "," + dateTime + "," + source, userIds);

        return accounts;
    }

    private List<Account> brandAccounts(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getTimeVal());
        String timeType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        if ("comments".equals(sp.getBehType()))
        {
            return this.brandCommentsAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime, sp.getSource());
        }
        else if ("collect".equals(sp.getBehType()))
        {
            return this.brandCollectAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime, sp.getSource(), sp.getChannel());
        }
        else if ("buy".equals(sp.getBehType()))
        {
            return this.brandBuyAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime);
        }
        else if ("browse".equals(sp.getBehType()))
        {
            return this.brandBrowseAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime, sp.getSource(), sp.getChannel());
        }
        return null;
    }

    private List<Account> brandBrowseAccounts(HttpServletRequest request, String shopId, String brandId, String dateType, String userType, Date dateTime, String source, String channel)
    {
        List<String> userIds = this.browseStatisticService.brandBrowsPoeple(shopId, brandId, dateType, userType, channel, dateTime, source);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("browseStatisticService.brandBrowsPoeple(shopId, brandId, dateType, userType, channel, dateTime, source)", shopId + "," + brandId + "," + dateType + "," + userType + "," + channel + "," + dateTime + "," + source, userIds);

        return accounts;
    }

    private List<Account> brandBuyAccounts(HttpServletRequest request, String shopId, String brandId, String dateType, String userType, Date dateTime)
    {
        List<String> userIds = this.buyStatisticService.brandBuyPeople(shopId, brandId, dateType, userType, dateTime);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("buyStatisticService.brandBuyPeople(shopId, brandId, dateType, userType, dateTime)", shopId + "," + brandId + "," + dateType + "," + userType + "," + dateTime, userIds);

        return accounts;
    }

    private List<Account> brandCollectAccounts(HttpServletRequest request, String shopId, String brandId, String dateType, String userType, Date dateTime, String source, String channel)
    {
        List<String> userIds = this.collectStatisticService.brandCollectPoeple(shopId, brandId, dateType, userType, channel, source, dateTime);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("collectStatisticService.brandCollectPoeple(shopId, brandId, dateType, userType, channel, source, dateTime)", shopId + "," + brandId + "," + dateType + "," + userType + "," + channel + "," + source + "," + "," + dateTime, userIds);

        return accounts;
    }

    private List<Account> brandCommentsAccounts(HttpServletRequest request, String shopId, String brandId, String dateType, String userType, Date dateTime, String source)
    {
        List<String> userIds = this.commentsStatisticService.brandCommentPeople(shopId, brandId, dateType, userType, dateTime, source);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("commentsStatisticService.brandCommentPeople(shopId, brandId, dateType, userType, dateTime, source)", shopId + "," + brandId + "," + dateType + "," + userType + "," + dateTime + "," + source, userIds);

        return accounts;
    }

    private List<Account> couponAccounts(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getTimeVal());
        String timeType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        if ("collect".equals(sp.getBehType()))
        {
            return this.couponCollectAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime, sp.getChannel(), sp.getSource());
        }
        else if ("browse".equals(sp.getBehType()))
        {
            return this.couponBrowseAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime, sp.getChannel(), sp.getSource());
        }
        else if ("use".equals(sp.getBehType()))
        {
            return this.couponUseAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime);
        }
        else if ("share".equals(sp.getBehType()))
        {
            return this.couponShareAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime);
        }
        else if ("exchange".equals(sp.getBehType()))
        {
            return this.couponExchangeAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime);
        }
        return null;
    }

    private List<Account> couponExchangeAccounts(HttpServletRequest request, String shopId, String couponId, String dateType, String userType, Date dateTime)
    {
        List<String> userIds = this.exchangeStatisticService.couponExchangePeople(couponId, userType, dateType, dateTime);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("exchangeStatisticService.couponExchangePeople(couponId, userType, dateType, dateTime)", couponId + "," + userType + "," + dateType + "," + dateTime, userIds);

        return accounts;
    }

    private List<Account> couponShareAccounts(HttpServletRequest request, String shopId, String couponId, String dateType, String userType, Date dateTime)
    {
        List<String> userIds = this.shareStatisticService.couponSharePeople(couponId, userType, dateType, dateTime);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("shareStatisticService.couponSharePeople(couponId, userType, dateType, dateTime)", couponId + "," + userType + "," + dateType + "," + dateTime, userIds);

        return accounts;
    }

    private List<Account> couponUseAccounts(HttpServletRequest request, String shopId, String couponId, String dateType, String userType, Date dateTime)
    {
        List<String> userIds = this.useStatisticService.couponUsePeople(couponId, userType, dateType, dateTime);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("useStatisticService.couponUsePeople(couponId, userType, dateType, dateTime)", couponId + "," + userType + "," + dateType + "," + dateTime, userIds);

        return accounts;
    }

    private List<Account> couponBrowseAccounts(HttpServletRequest request, String shopId, String couponId, String dateType, String userType, Date dateTime, String channel, String source)
    {
        List<String> userIds = this.browseStatisticService.couponBrowsPeople(couponId, userType, dateType, dateTime, channel, source);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("browseStatisticService.couponBrowsPeople(couponId, userType, dateType, dateTime, channel, source)", couponId + "," + userType + "," + dateType + "," + dateTime + "," + channel + "," + source, userIds);

        return accounts;
    }

    private List<Account> couponCollectAccounts(HttpServletRequest request, String shopId, String couponId, String dateType, String userType, Date dateTime, String channel, String source)
    {
        List<String> userIds = this.collectStatisticService.couponCollectPeople(couponId, userType, dateType, dateTime, channel, source);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("collectStatisticService.couponCollectPeople(couponId, userType, dateType, dateTime, channel, source)", couponId + "," + userType + "," + dateType + "," + dateTime + "," + channel + "," + source, userIds);

        return accounts;
    }

    private List<Account> toolAccounts(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = getQueryDate(sp.getHisOrCurr(), sp.getColumn(), sp.getTimeTypeVal(), sp.getTimeVal());
        String timeType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
        return this.toolUseAccounts(request, sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), dateTime);
    }

    private List<Account> toolUseAccounts(HttpServletRequest request, String shopId, String toolId, String dateType, String userType, Date dateTime)
    {
        List<String> userIds = this.useStatisticService.toolUsePoeple(shopId, toolId, dateType, userType, dateTime);
        List<Account> accounts = this.convertToAccount(userIds);

        this.printMessage("useStatisticService.toolUsePoeple(shopId, toolId, dateType, userType, dateTime)", shopId + "," + toolId + "," + dateType + "," + userType + "," + dateTime, userIds);

        return accounts;
    }

    @Override
    public TransData<String> findCurrentStatus(HttpServletRequest request) throws Exception
    {
        StatisticParameters sp = ServletUtils.objectMethod(StatisticParameters.class, request);
        String result = "";
        if ("tool".equals(sp.getName()))
        {
            result = this.toolStatus(request, sp);
        }
        else if ("coupon".equals(sp.getName()))
        {
            result = this.couponStatus(request, sp);
        }
        else if ("brand".equals(sp.getName()))
        {
            result = this.brandStatus(request, sp);
        }
        else if ("category".equals(sp.getName()))
        {
            result = this.categoryStatus(request, sp);
        }
        else if ("goods".equals(sp.getName()))
        {
            result = this.goodsStatus(request, sp);
        }
        else if ("activity".equals(sp.getName()))
        {
            result = this.activityStatus(request, sp);
        }
        else if ("cryout".equals(sp.getName()))
        {
            result = this.cryoutStatus(request, sp);
        }
        else if ("notice".equals(sp.getName()))
        {
            result = this.noticeStatus(request, sp);
        }
        else if ("ps".equals(sp.getName()))
        { //手机服务
            result = this.phoneServerStatus(request, sp);
        }
        else if ("pac".equals(sp.getName()))
        { //购好奇
            result = this.purchaseAndCuriousStatus(request, sp);
        }

        this.printMessage("findCurrentStatus:", "paras:" + new Gson().toJson(sp), result);

        return new TransData<String>(true, null, result);
    }

    private String purchaseAndCuriousStatus(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = new Date();
        int brows1 = this.browseStatisticService.purchaseAndcuriosityBrowsTimes(sp.getId(), sp.getTimeTypeVal(), sp.getUserType(), dateTime);
        int brows2 = this.browseStatisticService.toolBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), "N", sp.getTimeTypeVal(), dateTime);
        String title = sp.getChartName();
        String xName = "";
        String yName = "";
        String unit = "次";
        List<String> xData = new ArrayList<String>();
        xData.add("浏览数");
        Map<String, List<?>> dataMap = new HashMap<String, List<?>>();

        List<Integer> sList = new ArrayList<Integer>();
        sList.add(brows1);
        dataMap.put("会员", sList);

        sList = new ArrayList<Integer>();
        sList.add(brows2);
        dataMap.put("潜在会员", sList);

        String r = new ColumnChartsVo().create(title, xName, yName, unit, xData, dataMap, true);
        return r;
    }

    private String phoneServerStatus(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = new Date();
        int brows1 = this.browseStatisticService.toolBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), "M", sp.getTimeTypeVal(), dateTime);
        int brows2 = this.browseStatisticService.toolBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), "N", sp.getTimeTypeVal(), dateTime);
        String title = sp.getChartName();
        String xName = "";
        String yName = "";
        String unit = "次";
        List<String> xData = new ArrayList<String>();
        xData.add("浏览数");
        Map<String, List<?>> dataMap = new HashMap<String, List<?>>();

        List<Integer> sList = new ArrayList<Integer>();
        sList.add(brows1);
        dataMap.put("会员", sList);

        sList = new ArrayList<Integer>();
        sList.add(brows2);
        dataMap.put("潜在会员", sList);

        String r = new ColumnChartsVo().create(title, xName, yName, unit, xData, dataMap, true);
        return r;
    }

    private String toolStatus(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = new Date();

        // 会员
        int use1 = this.useStatisticService.toolUseTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", dateTime);

        // 潜在会员
        int use2 = this.useStatisticService.toolUseTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", dateTime);

        String title = sp.getChartName();
        String xName = "";
        String yName = "";
        String unit = "次";
        List<String> xData = new ArrayList<String>();
        xData.add("使用数");
        Map<String, List<?>> dataMap = new HashMap<String, List<?>>();

        List<Integer> sList = new ArrayList<Integer>();
        sList.add(use1);
        dataMap.put("会员", sList);

        sList = new ArrayList<Integer>();
        sList.add(use2);
        dataMap.put("潜在会员", sList);

        String r = new ColumnChartsVo().create(title, xName, yName, unit, xData, dataMap, true);
        return r;
    }

    private String couponStatus(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = new Date();
        // 会员
        int browse1 = this.browseStatisticService.couponBrowsTimes(sp.getId(), "M", sp.getTimeTypeVal(), dateTime, sp.getChannel(), sp.getSource());
        int collect1 = this.collectStatisticService.couponCollectTimes(sp.getId(), "M", sp.getTimeTypeVal(), dateTime, sp.getChannel(), sp.getSource());
        int exchange1 = this.exchangeStatisticService.couponExchangeTimes(sp.getId(), "M", sp.getTimeTypeVal(), dateTime);
        //int share1 = this.shareStatisticService.couponShareTimes(sp.getId(), "M", sp.getTimeTypeVal(), dateTime);
        int use1 = this.useStatisticService.couponUseTimes(sp.getId(), "M", sp.getTimeTypeVal(), dateTime);
        // 前缀会员
        int browse2 = this.browseStatisticService.couponBrowsTimes(sp.getId(), "N", sp.getTimeTypeVal(), dateTime, sp.getChannel(), sp.getSource());
        int collect2 = this.collectStatisticService.couponCollectTimes(sp.getId(), "N", sp.getTimeTypeVal(), dateTime, sp.getChannel(), sp.getSource());
        int exchange2 = this.exchangeStatisticService.couponExchangeTimes(sp.getId(), "N", sp.getTimeTypeVal(), dateTime);
        //int share2 = this.shareStatisticService.couponShareTimes(sp.getId(), "N", sp.getTimeTypeVal(), dateTime);
        int use2 = this.useStatisticService.couponUseTimes(sp.getId(), "N", sp.getTimeTypeVal(), dateTime);

        String title = sp.getChartName();
        String xName = "";
        String yName = "";
        String unit = "次";
        List<String> xData = new ArrayList<String>();
        xData.add("浏览数");
        xData.add("收藏数");
        xData.add("兑换数");
        //xData.add("分享数");
        xData.add("使用数");

        Map<String, List<?>> dataMap = new HashMap<String, List<?>>();

        List<Integer> sList = new ArrayList<Integer>();
        sList.add(browse1);
        sList.add(collect1);
        sList.add(exchange1);
        //sList.add(share1);
        sList.add(use1);
        dataMap.put("会员", sList);

        sList = new ArrayList<Integer>();
        sList.add(browse2);
        sList.add(collect2);
        sList.add(exchange2);
        //sList.add(share2);
        sList.add(use2);
        dataMap.put("潜在会员", sList);

        String r = new ColumnChartsVo().create(title, xName, yName, unit, xData, dataMap, true);
        return r;
    }

    private String brandStatus(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = new Date();
        // 会员
        int browse1 = this.browseStatisticService.brandBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", sp.getChannel(), dateTime, sp.getSource());
        int collect1 = this.collectStatisticService.brandCollectTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", sp.getChannel(), sp.getSource(), dateTime);
        int buy1 = this.buyStatisticService.brandBuyTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", dateTime);
        int comment1 = this.commentsStatisticService.brandCommentTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", dateTime, sp.getSource());
        // 前缀会员
        int browse2 = this.browseStatisticService.brandBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", sp.getChannel(), dateTime, sp.getSource());
        int collect2 = this.collectStatisticService.brandCollectTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", sp.getChannel(), sp.getSource(), dateTime);
        int buy2 = this.buyStatisticService.brandBuyTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", dateTime);
        int comment2 = this.commentsStatisticService.brandCommentTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", dateTime, sp.getSource());

        String title = sp.getChartName();
        String xName = "";
        String yName = "";
        String unit = "次";
        List<String> xData = new ArrayList<String>();
        xData.add("浏览数");
        xData.add("收藏数");
        xData.add("购买数");
        xData.add("评论数");

        Map<String, List<?>> dataMap = new HashMap<String, List<?>>();

        List<Integer> sList = new ArrayList<Integer>();
        sList.add(browse1);
        sList.add(collect1);
        sList.add(buy1);
        sList.add(comment1);
        dataMap.put("会员", sList);

        sList = new ArrayList<Integer>();
        sList.add(browse2);
        sList.add(collect2);
        sList.add(buy2);
        sList.add(comment2);
        dataMap.put("潜在会员", sList);

        String r = new ColumnChartsVo().create(title, xName, yName, unit, xData, dataMap, true);
        return r;
    }

    private String categoryStatus(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = new Date();
        // 会员
        int browse1 = this.browseStatisticService.categoryBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", sp.getChannel(), dateTime, sp.getSource());
        int collect1 = this.collectStatisticService.categoryCollectTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", sp.getChannel(), sp.getSource(), dateTime);
        int buy1 = this.buyStatisticService.categoryBuyTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", dateTime);
        int comment1 = this.commentsStatisticService.categoryCommentTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", dateTime, sp.getSource());
        // 前缀会员
        int browse2 = this.browseStatisticService.categoryBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", sp.getChannel(), dateTime, sp.getSource());
        int collect2 = this.collectStatisticService.categoryCollectTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", sp.getChannel(), sp.getSource(), dateTime);
        int buy2 = this.buyStatisticService.categoryBuyTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", dateTime);
        int comment2 = this.commentsStatisticService.categoryCommentTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", dateTime, sp.getSource());

        String title = sp.getChartName();
        String xName = "";
        String yName = "";
        String unit = "次";
        List<String> xData = new ArrayList<String>();
        xData.add("浏览数");
        xData.add("收藏数");
        xData.add("购买数");
        xData.add("评论数");

        Map<String, List<?>> dataMap = new HashMap<String, List<?>>();

        List<Integer> list = new ArrayList<Integer>();
        list.add(browse1);
        list.add(collect1);
        list.add(buy1);
        list.add(comment1);
        dataMap.put("会员", list);

        list = new ArrayList<Integer>();
        list.add(browse2);
        list.add(collect2);
        list.add(buy2);
        list.add(comment2);
        dataMap.put("潜在会员", list);

        String r = new ColumnChartsVo().create(title, xName, yName, unit, xData, dataMap, true);
        return r;
    }

    private String goodsStatus(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = new Date();
        // 会员
        int browse1 = this.browseStatisticService.goodsBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", sp.getChannel(), dateTime, sp.getSource());
        int collect1 = this.collectStatisticService.goodsCollectTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", sp.getChannel(), sp.getSource(), dateTime);
        int buy1 = this.buyStatisticService.goodsBuyTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", dateTime);
        int comment1 = this.commentsStatisticService.goodsCommentTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", dateTime, sp.getSource());
        // 前缀会员
        int browse2 = this.browseStatisticService.goodsBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", sp.getChannel(), dateTime, sp.getSource());
        int collect2 = this.collectStatisticService.goodsCollectTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", sp.getChannel(), sp.getSource(), dateTime);
        int buy2 = this.buyStatisticService.goodsBuyTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", dateTime);
        int comment2 = this.commentsStatisticService.goodsCommentTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", dateTime, sp.getSource());

        String title = sp.getChartName();
        String xName = "";
        String yName = "";
        String unit = "次";
        List<String> xData = new ArrayList<String>();
        xData.add("浏览数");
        xData.add("收藏数");
        xData.add("购买数");
        xData.add("评论数");

        Map<String, List<?>> dataMap = new HashMap<String, List<?>>();

        List<Integer> list = new ArrayList<Integer>();
        list.add(browse1);
        list.add(collect1);
        list.add(buy1);
        list.add(comment1);
        dataMap.put("会员", list);
        list = new ArrayList<Integer>();
        list.add(browse2);
        list.add(collect2);
        list.add(buy2);
        list.add(comment2);
        dataMap.put("潜在会员", list);

        String r = new ColumnChartsVo().create(title, xName, yName, unit, xData, dataMap, true);
        return r;
    }

    private String activityStatus(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = new Date();
        // 会员
        int browse1 = this.browseStatisticService.activityBrowsTimes(sp.getId(), "M", sp.getTimeTypeVal(), dateTime, sp.getChannel(), sp.getSource());
        int collect1 = this.collectStatisticService.activityCollectTimes(sp.getId(), "M", sp.getTimeTypeVal(), dateTime, sp.getChannel(), sp.getSource());
        // 前缀会员
        int browse2 = this.browseStatisticService.activityBrowsTimes(sp.getId(), "N", sp.getTimeTypeVal(), dateTime, sp.getChannel(), sp.getSource());
        int collect2 = this.collectStatisticService.activityCollectTimes(sp.getId(), "N", sp.getTimeTypeVal(), dateTime, sp.getChannel(), sp.getSource());

        String title = sp.getChartName();
        String xName = "";
        String yName = "";
        String unit = "次";
        List<String> xData = new ArrayList<String>();
        xData.add("浏览数");
        xData.add("收藏数");

        Map<String, List<?>> dataMap = new HashMap<String, List<?>>();

        List<Integer> browseList = new ArrayList<Integer>();
        browseList.add(browse1);
        browseList.add(collect1);
        dataMap.put("会员", browseList);

        List<Integer> collectList = new ArrayList<Integer>();
        collectList.add(browse2);
        collectList.add(collect2);
        dataMap.put("潜在会员", collectList);

        String r = new ColumnChartsVo().create(title, xName, yName, unit, xData, dataMap, true);
        return r;
    }

    private String cryoutStatus(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = new Date();
        // 会员
        int browse1 = this.browseStatisticService.cryoutBrowsTimes(sp.getId(), sp.getTimeTypeVal(), "M", sp.getSource(), dateTime);
        // 前缀会员
        int browse2 = this.browseStatisticService.cryoutBrowsTimes(sp.getId(), sp.getTimeTypeVal(), "N", sp.getSource(), dateTime);

        String title = sp.getChartName();
        String xName = "";
        String yName = "";
        String unit = "次";
        List<String> xData = new ArrayList<String>();
        xData.add("浏览数");

        Map<String, List<?>> dataMap = new HashMap<String, List<?>>();

        List<Integer> browseList = new ArrayList<Integer>();
        browseList.add(browse1);
        dataMap.put("会员", browseList);
        browseList = new ArrayList<Integer>();
        browseList.add(browse2);
        dataMap.put("潜在会员", browseList);

        String r = new ColumnChartsVo().create(title, xName, yName, unit, xData, dataMap, true);
        return r;
    }

    private String noticeStatus(HttpServletRequest request, StatisticParameters sp)
    {
        Date dateTime = new Date();
        int browse1 = this.browseStatisticService.noticeBrowsTimes(sp.getId(), sp.getTimeTypeVal(), "M", sp.getSource(), dateTime);
        // 前缀会员
        int browse2 = this.browseStatisticService.noticeBrowsTimes(sp.getId(), sp.getTimeTypeVal(), "N", sp.getSource(), dateTime);

        String title = sp.getChartName();
        String xName = "";
        String yName = "";
        String unit = "次";
        List<String> xData = new ArrayList<String>();
        xData.add("浏览数");

        Map<String, List<?>> dataMap = new HashMap<String, List<?>>();

        List<Integer> browseList = new ArrayList<Integer>();
        browseList.add(browse1);
        dataMap.put("会员", browseList);

        browseList = new ArrayList<Integer>();
        browseList.add(browse2);
        dataMap.put("潜在会员", browseList);
        String r = new ColumnChartsVo().create(title, xName, yName, unit, xData, dataMap, true);
        return r;
    }

    private static Date getQueryDate(String currOrHis, String column, String timeType, String queryDate)
    {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        try
        {
            if ("H".equals(currOrHis))
            {
                if ("D".equals(timeType))
                {
                    calendar.setTime(TimeUtils.convertStringToDate(queryDate));
                    calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(column));
                }
                else if ("W".equals(timeType))
                {
                    calendar.setTime(TimeUtils.convertStringToDate(queryDate));
                }
                else if ("M".equals(timeType))
                {
                    calendar.setTime(TimeUtils.convertStringToDate(queryDate + "-01"));
                    calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(column));
                }
                else if ("Y".equals(timeType))
                {
                    calendar.setTime(TimeUtils.convertStringToDate(queryDate + "-01-01"));
                    calendar.set(Calendar.MONTH, (Integer.parseInt(column) - 1));
                }
                else
                {
                    calendar.set(Calendar.YEAR, Integer.parseInt(column));
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("营销状态获取统计时间错误", e);
        }
        return calendar.getTime();
    }

    @Override
    public TransData<List<List<Integer>>> getDynamicPointData(HttpServletRequest request) throws Exception
    {
        StatisticParameters sp = ServletUtils.objectMethod(StatisticParameters.class, request);
        List<List<Integer>> result = null;
        if ("tool".equals(sp.getName()))
        {
            result = this.toolStatusPoints(request, sp);
        }
        else if ("coupon".equals(sp.getName()))
        {
            result = this.couponStatusPoints(request, sp);
        }
        else if ("brand".equals(sp.getName()))
        {
            result = this.brandStatusPoints(request, sp);
        }
        else if ("category".equals(sp.getName()))
        {
            result = this.categoryStatusPoints(request, sp);
        }
        else if ("goods".equals(sp.getName()))
        {
            result = this.goodsStatusPoints(request, sp);
        }
        else if ("activity".equals(sp.getName()))
        {
            result = this.activityStatusPoints(request, sp);
        }
        else if ("cryout".equals(sp.getName()))
        {
            result = this.cryoutStatusPoints(request, sp);
        }
        else if ("notice".equals(sp.getName()))
        {
            result = this.noticeStatusPoints(request, sp);
        }
        else if ("ps".equals(sp.getName()))
        { //手机服务
            result = this.phoneServerPoints(request, sp);
        }
        else if ("pac".equals(sp.getName()))
        { //购好奇
            result = this.purchaseAndCuriousPoints(request, sp);
        }

        return GMSUtil.toTransData(true, null, result);
    }

    private List<List<Integer>> purchaseAndCuriousPoints(HttpServletRequest request, StatisticParameters sp)
    {
        List<List<Integer>> dataList = new ArrayList<List<Integer>>(0);
        if ("H".equals(sp.getHisOrCurr()))
        {
            List<Date> calQueryTime = calQueryTime(sp);
            String timeType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
            List<Integer> sl = null;
            for (Date date : calQueryTime)
            {
                sl = new ArrayList<Integer>();
                int browse1 = this.browseStatisticService.purchaseAndcuriosityBrowsTimes(sp.getId(), timeType, sp.getUserType(), date);
                sl.add(browse1);
                dataList.add(sl);
            }
        }
        else
        {
            Date date = new Date();
            int browse1 = this.browseStatisticService.purchaseAndcuriosityBrowsTimes(sp.getId(), sp.getTimeTypeVal(), sp.getUserType(), date);
            int browse2 = this.browseStatisticService.purchaseAndcuriosityBrowsTimes(sp.getId(), sp.getTimeTypeVal(), sp.getUserType(), date);
            List<Integer> aList = new ArrayList<Integer>();
            aList.add(browse1);
            aList.add(browse2);
            dataList.add(aList);
        }
        return dataList;
    }

    private List<List<Integer>> phoneServerPoints(HttpServletRequest request, StatisticParameters sp)
    {
        List<List<Integer>> dataList = new ArrayList<List<Integer>>(0);
        if ("H".equals(sp.getHisOrCurr()))
        {
            List<Date> calQueryTime = calQueryTime(sp);
            String timeType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
            List<Integer> sl = null;
            for (Date date : calQueryTime)
            {
                sl = new ArrayList<Integer>();
                int browse1 = this.browseStatisticService.toolBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getUserType(), timeType, date);
                sl.add(browse1);
                dataList.add(sl);
            }
        }
        else
        {
            Date date = new Date();
            int browse1 = this.browseStatisticService.toolBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), "N", sp.getTimeTypeVal(), date);
            int browse2 = this.browseStatisticService.toolBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), "M", sp.getTimeTypeVal(), date);
            List<Integer> aList = new ArrayList<Integer>();
            aList.add(browse1);
            aList.add(browse2);
            dataList.add(aList);
        }
        return dataList;
    }

    private List<List<Integer>> activityStatusPoints(HttpServletRequest request, StatisticParameters sp)
    {
        List<List<Integer>> dataList = new ArrayList<List<Integer>>(0);
        if ("H".equals(sp.getHisOrCurr()))
        {
            List<Date> calQueryTime = calQueryTime(sp);
            String timeType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
            List<Integer> sl = null;
            for (Date date : calQueryTime)
            {
                sl = new ArrayList<Integer>();
                int browse1 = this.browseStatisticService.activityBrowsTimes(sp.getId(), sp.getUserType(), timeType, date, sp.getChannel(), sp.getSource());
                int collect1 = this.collectStatisticService.activityCollectTimes(sp.getId(), sp.getUserType(), timeType, date, sp.getChannel(), sp.getSource());
                sl.add(browse1);
                sl.add(collect1);
                dataList.add(sl);
            }
        }
        else
        {
            Date date = new Date();
            List<Integer> aList = new ArrayList<Integer>(0);
            int browse1 = this.browseStatisticService.activityBrowsTimes(sp.getId(), "M", sp.getTimeTypeVal(), date, sp.getChannel(), sp.getSource());
            int collect1 = this.collectStatisticService.activityCollectTimes(sp.getId(), "M", sp.getTimeTypeVal(), date, sp.getChannel(), sp.getSource());

            int browse2 = this.browseStatisticService.activityBrowsTimes(sp.getId(), "N", sp.getTimeTypeVal(), date, sp.getChannel(), sp.getSource());
            int collect2 = this.collectStatisticService.activityCollectTimes(sp.getId(), "N", sp.getTimeTypeVal(), date, sp.getChannel(), sp.getSource());

            aList.add(browse2);
            aList.add(browse1);
            dataList.add(aList);

            aList = new ArrayList<Integer>(0);
            aList.add(collect2);
            aList.add(collect1);
            dataList.add(aList);

        }

        return dataList;
    }

    private List<List<Integer>> noticeStatusPoints(HttpServletRequest request, StatisticParameters sp)
    {
        List<List<Integer>> dataList = new ArrayList<List<Integer>>(0);
        if ("H".equals(sp.getHisOrCurr()))
        {
            List<Date> calQueryTime = calQueryTime(sp);
            String timeType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
            List<Integer> sl = null;
            for (Date date : calQueryTime)
            {
                sl = new ArrayList<Integer>();
                int browse1 = this.browseStatisticService.noticeBrowsTimes(sp.getId(), timeType, sp.getUserType(), sp.getSource(), date);
                sl.add(browse1);
                dataList.add(sl);
            }
        }
        else
        {
            Date date = new Date();
            int browse1 = this.browseStatisticService.noticeBrowsTimes(sp.getId(), sp.getTimeTypeVal(), "N", sp.getSource(), date);
            int browse2 = this.browseStatisticService.noticeBrowsTimes(sp.getId(), sp.getTimeTypeVal(), "M", sp.getSource(), date);
            List<Integer> aList = new ArrayList<Integer>();
            aList.add(browse1);
            aList.add(browse2);
            dataList.add(aList);
        }
        return dataList;
    }

    private List<List<Integer>> cryoutStatusPoints(HttpServletRequest request, StatisticParameters sp)
    {
        List<List<Integer>> dataList = new ArrayList<List<Integer>>(0);
        if ("H".equals(sp.getHisOrCurr()))
        {
            List<Date> calQueryTime = calQueryTime(sp);
            String timeType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
            List<Integer> sl = null;
            for (Date date : calQueryTime)
            {
                sl = new ArrayList<Integer>();
                int browse1 = this.browseStatisticService.cryoutBrowsTimes(sp.getId(), timeType, sp.getUserType(), sp.getSource(), date);
                sl.add(browse1);
                dataList.add(sl);
            }
        }
        else
        {
            Date date = new Date();
            int browse1 = this.browseStatisticService.cryoutBrowsTimes(sp.getId(), sp.getTimeTypeVal(), "N", sp.getSource(), date);
            int browse2 = this.browseStatisticService.cryoutBrowsTimes(sp.getId(), sp.getTimeTypeVal(), "M", sp.getSource(), date);
            List<Integer> aList = new ArrayList<Integer>(0);
            aList.add(browse1);
            aList.add(browse2);
            dataList.add(aList);
        }
        return dataList;
    }

    private List<List<Integer>> goodsStatusPoints(HttpServletRequest request, StatisticParameters sp)
    {
        List<List<Integer>> dataList = new ArrayList<List<Integer>>(0);
        if ("H".equals(sp.getHisOrCurr()))
        {
            List<Date> calQueryTime = calQueryTime(sp);
            String timeType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
            List<Integer> sl = null;
            for (Date date : calQueryTime)
            {
                sl = new ArrayList<Integer>();
                int browse1 = this.browseStatisticService.goodsBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), sp.getChannel(), date, sp.getSource());
                int collect1 = this.collectStatisticService.goodsCollectTimes(sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), sp.getChannel(), sp.getSource(), date);
                int buy1 = this.buyStatisticService.goodsBuyTimes(sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), date);
                int comment1 = this.commentsStatisticService.goodsCommentTimes(sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), date, sp.getSource());
                sl.add(browse1);
                sl.add(collect1);
                sl.add(buy1);
                sl.add(comment1);
                dataList.add(sl);
            }
        }
        else
        {

            Date date = new Date();
            int browse1 = this.browseStatisticService.goodsBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", sp.getChannel(), date, sp.getSource());
            int collect1 = this.collectStatisticService.goodsCollectTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", sp.getChannel(), sp.getSource(), date);
            int buy1 = this.buyStatisticService.goodsBuyTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", date);
            int comment1 = this.commentsStatisticService.goodsCommentTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", date, sp.getSource());

            int browse2 = this.browseStatisticService.goodsBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", sp.getChannel(), date, sp.getSource());
            int collect2 = this.collectStatisticService.goodsCollectTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", sp.getChannel(), sp.getSource(), date);
            int buy2 = this.buyStatisticService.goodsBuyTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", date);
            int comment2 = this.commentsStatisticService.goodsCommentTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", date, sp.getSource());

            List<Integer> aList = new ArrayList<Integer>();
            aList.add(browse1);
            aList.add(browse2);
            dataList.add(aList);

            aList = new ArrayList<Integer>();
            aList.add(collect1);
            aList.add(collect2);
            dataList.add(aList);

            aList = new ArrayList<Integer>();
            aList.add(buy1);
            aList.add(buy2);
            dataList.add(aList);

            aList = new ArrayList<Integer>();
            aList.add(comment1);
            aList.add(comment2);
            dataList.add(aList);

        }
        return dataList;
    }

    private List<List<Integer>> categoryStatusPoints(HttpServletRequest request, StatisticParameters sp)
    {
        List<List<Integer>> dataList = new ArrayList<List<Integer>>(0);
        if ("H".equals(sp.getHisOrCurr()))
        {
            List<Date> calQueryTime = calQueryTime(sp);
            String timeType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
            List<Integer> sl = null;
            for (Date date : calQueryTime)
            {
                sl = new ArrayList<Integer>();
                int browse1 = this.browseStatisticService.categoryBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), sp.getChannel(), date, sp.getSource());
                int collect1 = this.collectStatisticService.categoryCollectTimes(sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), sp.getChannel(), sp.getSource(), date);
                int buy1 = this.buyStatisticService.categoryBuyTimes(sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), date);
                int comment1 = this.commentsStatisticService.categoryCommentTimes(sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), date, sp.getSource());
                sl.add(browse1);
                sl.add(collect1);
                sl.add(buy1);
                sl.add(comment1);
                dataList.add(sl);
            }
        }
        else
        {
            Date date = new Date();
            int browse1 = this.browseStatisticService.categoryBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", sp.getChannel(), date, sp.getSource());
            int collect1 = this.collectStatisticService.categoryCollectTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", sp.getChannel(), sp.getSource(), date);
            int buy1 = this.buyStatisticService.categoryBuyTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", date);
            int comment1 = this.commentsStatisticService.categoryCommentTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", date, sp.getSource());

            int browse2 = this.browseStatisticService.categoryBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", sp.getChannel(), date, sp.getSource());
            int collect2 = this.collectStatisticService.categoryCollectTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", sp.getChannel(), sp.getSource(), date);
            int buy2 = this.buyStatisticService.categoryBuyTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", date);
            int comment2 = this.commentsStatisticService.categoryCommentTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", date, sp.getSource());

            List<Integer> aList = new ArrayList<Integer>();
            aList.add(browse1);
            aList.add(browse2);
            dataList.add(aList);

            aList = new ArrayList<Integer>();
            aList.add(collect1);
            aList.add(collect2);
            dataList.add(aList);

            aList = new ArrayList<Integer>();
            aList.add(buy1);
            aList.add(buy2);
            dataList.add(aList);

            aList = new ArrayList<Integer>();
            aList.add(comment1);
            aList.add(comment2);
            dataList.add(aList);
        }
        return dataList;
    }

    private List<List<Integer>> brandStatusPoints(HttpServletRequest request, StatisticParameters sp)
    {
        List<List<Integer>> dataList = new ArrayList<List<Integer>>(0);
        if ("H".equals(sp.getHisOrCurr()))
        {
            List<Date> calQueryTime = calQueryTime(sp);
            String timeType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
            List<Integer> sl = null;
            for (Date date : calQueryTime)
            {
                sl = new ArrayList<Integer>();
                int browse1 = this.browseStatisticService.brandBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), sp.getChannel(), date, sp.getSource());
                int collect1 = this.collectStatisticService.brandCollectTimes(sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), sp.getChannel(), sp.getSource(), date);
                int buy1 = this.buyStatisticService.brandBuyTimes(sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), date);
                int comment1 = this.commentsStatisticService.brandCommentTimes(sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), date, sp.getSource());
                sl.add(browse1);
                sl.add(collect1);
                sl.add(buy1);
                sl.add(comment1);
                dataList.add(sl);
            }
        }
        else
        {

            Date date = new Date();
            int browse1 = this.browseStatisticService.brandBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", sp.getChannel(), date, sp.getSource());
            int collect1 = this.collectStatisticService.brandCollectTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", sp.getChannel(), sp.getSource(), date);
            int buy1 = this.buyStatisticService.brandBuyTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", date);
            int comment1 = this.commentsStatisticService.brandCommentTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", date, sp.getSource());

            int browse2 = this.browseStatisticService.brandBrowsTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", sp.getChannel(), date, sp.getSource());
            int collect2 = this.collectStatisticService.brandCollectTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", sp.getChannel(), sp.getSource(), date);
            int buy2 = this.buyStatisticService.brandBuyTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", date);
            int comment2 = this.commentsStatisticService.brandCommentTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", date, sp.getSource());

            List<Integer> aList = new ArrayList<Integer>();
            aList.add(browse1);
            aList.add(browse2);
            dataList.add(aList);

            aList = new ArrayList<Integer>();
            aList.add(collect1);
            aList.add(collect2);
            dataList.add(aList);

            aList = new ArrayList<Integer>();
            aList.add(buy1);
            aList.add(buy2);
            dataList.add(aList);

            aList = new ArrayList<Integer>();
            aList.add(comment1);
            aList.add(comment2);
            dataList.add(aList);

        }
        return dataList;
    }

    private List<List<Integer>> couponStatusPoints(HttpServletRequest request, StatisticParameters sp)
    {
        List<List<Integer>> dataList = new ArrayList<List<Integer>>(0);
        if ("H".equals(sp.getHisOrCurr()))
        {
            List<Date> calQueryTime = calQueryTime(sp);
            String timeType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
            List<Integer> sl = null;
            for (Date date : calQueryTime)
            {
                sl = new ArrayList<Integer>();
                int browse1 = this.browseStatisticService.couponBrowsTimes(sp.getId(), sp.getUserType(), timeType, date, sp.getChannel(), sp.getSource());
                int collect1 = this.collectStatisticService.couponCollectTimes(sp.getId(), sp.getUserType(), timeType, date, sp.getChannel(), sp.getSource());
                int exchange1 = this.exchangeStatisticService.couponExchangeTimes(sp.getId(), sp.getUserType(), timeType, date);
                //int share1 = this.shareStatisticService.couponShareTimes(sp.getId(), sp.getUserType(), timeType, date);
                int use1 = this.useStatisticService.couponUseTimes(sp.getId(), sp.getUserType(), timeType, date);
                sl.add(browse1);
                sl.add(collect1);
                sl.add(exchange1);
                //sl.add(share1);
                sl.add(use1);
                dataList.add(sl);
            }
        }
        else
        {

            Date date = new Date();
            int browse1 = this.browseStatisticService.couponBrowsTimes(sp.getId(), "N", sp.getTimeTypeVal(), date, sp.getChannel(), sp.getSource());
            int collect1 = this.collectStatisticService.couponCollectTimes(sp.getId(), "N", sp.getTimeTypeVal(), date, sp.getChannel(), sp.getSource());
            int exchange1 = this.exchangeStatisticService.couponExchangeTimes(sp.getId(), "N", sp.getTimeTypeVal(), date);
            //int share1 = this.shareStatisticService.couponShareTimes(sp.getId(), "N", sp.getTimeTypeVal(), date);
            int use1 = this.useStatisticService.couponUseTimes(sp.getId(), "N", sp.getTimeTypeVal(), date);

            int browse2 = this.browseStatisticService.couponBrowsTimes(sp.getId(), "M", sp.getTimeTypeVal(), date, sp.getChannel(), sp.getSource());
            int collect2 = this.collectStatisticService.couponCollectTimes(sp.getId(), "M", sp.getTimeTypeVal(), date, sp.getChannel(), sp.getSource());
            int exchange2 = this.exchangeStatisticService.couponExchangeTimes(sp.getId(), "M", sp.getTimeTypeVal(), date);
            //int share2 = this.shareStatisticService.couponShareTimes(sp.getId(), "M", sp.getTimeTypeVal(), date);
            int use2 = this.useStatisticService.couponUseTimes(sp.getId(), "M", sp.getTimeTypeVal(), date);

            List<Integer> aList = new ArrayList<Integer>();
            aList.add(browse1);
            aList.add(browse2);
            dataList.add(aList);

            aList = new ArrayList<Integer>();
            aList.add(collect1);
            aList.add(collect2);
            dataList.add(aList);

            aList = new ArrayList<Integer>();
            aList.add(exchange1);
            aList.add(exchange2);
            dataList.add(aList);

            //aList = new ArrayList<Integer>();
            //aList.add(share1);
            //aList.add(share2);
            //dataList.add(aList);

            aList = new ArrayList<Integer>();
            aList.add(use1);
            aList.add(use2);
            dataList.add(aList);
        }
        return dataList;
    }

    private List<List<Integer>> toolStatusPoints(HttpServletRequest request, StatisticParameters sp)
    {
        List<List<Integer>> dataList = new ArrayList<List<Integer>>(0);
        if ("H".equals(sp.getHisOrCurr()))
        {
            List<Date> calQueryTime = calQueryTime(sp);
            String timeType = this.getDateType(sp.getHisOrCurr(), sp.getTimeTypeVal());
            List<Integer> sl = null;
            for (Date date : calQueryTime)
            {
                sl = new ArrayList<Integer>();
                int use1 = this.useStatisticService.toolUseTimes(sp.getShopIdOrEntityId(), sp.getId(), timeType, sp.getUserType(), date);
                sl.add(use1);
                dataList.add(sl);
            }
        }
        else
        {
            Date date = new Date();
            int use1 = this.useStatisticService.toolUseTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "N", date);
            int use2 = this.useStatisticService.toolUseTimes(sp.getShopIdOrEntityId(), sp.getId(), sp.getTimeTypeVal(), "M", date);

            List<Integer> aList = new ArrayList<Integer>();
            aList.add(use1);
            aList.add(use2);
            dataList.add(aList);

        }
        return dataList;
    }

    /**
     * 营销状态（按指定日期查询），获取最后一个点数据查询时间
     * 
     * @param parameters
     * @return
     */
    private static List<Date> calQueryTime(StatisticParameters parameters)
    {
        String column = parameters.getColumn();
        List<Date> dateList = null;
        try
        {
            String timeTypeVal = parameters.getTimeTypeVal();
            dateList = new ArrayList<Date>();
            Calendar calendar = Calendar.getInstance(Locale.getDefault());
            if ("D".equals(timeTypeVal))
            {
                if (calendar.get(Calendar.HOUR_OF_DAY) == Integer.parseInt(column))
                {
                    dateList.add(calendar.getTime());
                }
                else
                {
                    calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(column) + 1);
                    while (calendar.getTime().compareTo(new Date()) <= 0)
                    {
                        dateList.add(calendar.getTime());
                        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + 1);
                    }
                }
            }
            else if ("M".equals(timeTypeVal))
            {
                Calendar cal = Calendar.getInstance(Locale.getDefault());
                calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(column));
                if (cal.get(Calendar.DAY_OF_YEAR) == cal.get(Calendar.DAY_OF_YEAR))
                {
                    dateList.add(calendar.getTime());
                }
                else
                {
                    calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
                    while (calendar.getTime().compareTo(new Date()) <= 0)
                    {
                        dateList.add(calendar.getTime());
                        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
                    }
                }

            }
            else if ("Y".equals(timeTypeVal))
            {
                Calendar cal = Calendar.getInstance(Locale.getDefault());
                calendar.set(Calendar.MONTH, (Integer.parseInt(column) - 1));
                if (cal.get(Calendar.MONTH) == calendar.get(Calendar.MONTH))
                {
                    dateList.add(calendar.getTime());
                }
                else
                {
                    calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
                    while (calendar.getTime().compareTo(new Date()) <= 0)
                    {
                        dateList.add(calendar.getTime());
                        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
                    }
                }
            }
            else
            {
                dateList.add(null);
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("营销状态（按指定日期查询），获取最后一个点数据查询时间错误", e);
        }
        return dateList;
    }

    private void printMessage(String serviceName, String parameters, Object result)
    {
        GooagooLog.info("serviceName:" + serviceName + ",parameters:" + parameters + ",result:" + result);
    }

    /**
     * 获取查询用户列表时的时间类型
     * @param sp
     * @return
     */
    private String getDateType(String hisOrCurr, String timeType)
    {
        String dateType = timeType;
        if ("H".equals(hisOrCurr))
        {
            if ("D".equals(timeType))
            {
                dateType = "H";
            }
            else if ("M".equals(timeType))
            {
                dateType = "D";
            }
            else if ("Y".equals(timeType))
            {
                dateType = "M";
            }
            else if ("A".equals(timeType))
            {
                dateType = "Y";
            }
        }
        return dateType;
    }

}
