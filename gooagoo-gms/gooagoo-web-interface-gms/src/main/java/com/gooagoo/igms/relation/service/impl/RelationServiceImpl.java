package com.gooagoo.igms.relation.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.goods.category.GoodsCategoryQueryService;
import com.gooagoo.api.business.query.system.channel.MarketingChannelQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBrandGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsCategoryGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsMarketingInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.CouponGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.CryoutInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingActivityGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingEventGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingViewGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.NoticeInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.DeviceTransponderGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopToolListGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.CmsContentGeneratorQueryService;
import com.gooagoo.cache.GmsConfigCache;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.RelationConstaints;
import com.gooagoo.common.gms.utils.GMSServiceUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.base.MarketingChannel;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample;
import com.gooagoo.entity.generator.goods.GoodsBrand;
import com.gooagoo.entity.generator.goods.GoodsBrandExample;
import com.gooagoo.entity.generator.goods.GoodsCategory;
import com.gooagoo.entity.generator.goods.GoodsCategoryExample;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.CouponExample;
import com.gooagoo.entity.generator.marketing.CryoutInfo;
import com.gooagoo.entity.generator.marketing.CryoutInfoExample;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.marketing.MarketingActivityExample;
import com.gooagoo.entity.generator.marketing.MarketingActivityExample.Criteria;
import com.gooagoo.entity.generator.marketing.MarketingEvent;
import com.gooagoo.entity.generator.marketing.MarketingEventExample;
import com.gooagoo.entity.generator.marketing.MarketingView;
import com.gooagoo.entity.generator.marketing.MarketingViewExample;
import com.gooagoo.entity.generator.marketing.NoticeInfo;
import com.gooagoo.entity.generator.marketing.NoticeInfoExample;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.entity.generator.shop.DeviceTransponder;
import com.gooagoo.entity.generator.shop.DeviceTransponderExample;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfoExample;
import com.gooagoo.entity.generator.shop.ShopToolList;
import com.gooagoo.entity.generator.shop.ShopToolListExample;
import com.gooagoo.entity.generator.sys.CmsContent;
import com.gooagoo.entity.generator.sys.CmsContentExample;
import com.gooagoo.igms.common.utils.RelationServiceUtil;
import com.gooagoo.igms.relation.service.RelationService;
import com.gooagoo.igms.shopinfo.service.IShopPositionService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.cmsContent.FCmsContent;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.common.RelationPara;
import com.gooagoo.view.gms.common.ZTreeNode;
import com.gooagoo.view.gms.cryout.FCryout;
import com.gooagoo.view.gms.good.FGoods;
import com.gooagoo.view.gms.good.FGoodsBrand;
import com.gooagoo.view.gms.good.FGoodsCategory;
import com.gooagoo.view.gms.marketing.FActivity;
import com.gooagoo.view.gms.marketing.FActivityContent;
import com.gooagoo.view.gms.marketing.FCoupon;
import com.gooagoo.view.gms.marketing.FCouponJson;
import com.gooagoo.view.gms.marketing.FEvent;
import com.gooagoo.view.gms.member.FMemberCard;
import com.gooagoo.view.gms.notice.FNotice;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.gooagoo.view.gms.shopinfo.FTranspcInfo;
import com.google.gson.Gson;

@Service(value = "relationService")
public class RelationServiceImpl implements RelationService
{
    @Autowired
    private MarketingActivityGeneratorQueryService activityQueryService;
    @Autowired
    private GoodsBaseInfoGeneratorQueryService goodsBaseInfoGeneratorQueryService;
    @Autowired
    private CouponGeneratorQueryService couponQueryService;
    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityInfoGeneratorQueryService;
    @Autowired
    private GoodsCategoryGeneratorQueryService queryCategoryService;
    @Autowired
    private GoodsBrandGeneratorQueryService brandQueryService;
    @Autowired
    private MemberCardGeneratorQueryService memberCardGeneratorQueryService;
    @Autowired
    private MarketingEventGeneratorQueryService marketingEventGeneratorQueryService;
    @Autowired
    private MarketingChannelQueryService marketingChannelQueryService;
    @Autowired
    private DeviceTransponderGeneratorQueryService deviceTransponderGeneratorQueryService;
    @Autowired
    private MarketingViewGeneratorQueryService marketingViewGeneratorQueryService;
    @Autowired
    private ShopLoginService shopLoginService;
    @Autowired
    private IShopPositionService positionService;
    @Autowired
    private GoodsCategoryGeneratorQueryService categoryQueryService;
    @Autowired
    private GoodsCategoryQueryService goodsCategoryQueryService;
    @Autowired
    private GoodsMarketingInfoGeneratorQueryService goodsMarketingInfoGeneratorQueryService;
    @Autowired
    private CryoutInfoGeneratorQueryService cryoutQueryService;
    @Autowired
    private NoticeInfoGeneratorQueryService noticeQueryService;
    @Autowired
    private ShopToolListGeneratorQueryService shopToolListGeneratorQueryService;
    @Autowired
    private CmsContentGeneratorQueryService cmsContentGeneratorQueryService;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public TransData<PageModel<Object>> pageRelation(HttpServletRequest request) throws Exception
    {
        String relateType = ServletRequestUtils.getStringParameter(request, "relateType", "");
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);

        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        RelationPara relationPara = ServletUtils.objectMethod(RelationPara.class, request);

        PageModel pm = new PageModel();
        pm.setPageIndex(pageIndex);
        pm.setPageSize(pageSize);

        if (RelationConstaints.RELATION_ACTIVITY.equals(relateType))
        {
            this.relateTabActivity(request, pm, shopInfo, relationPara);
        }
        else if (RelationConstaints.RELATION_CRYOUT.equals(relateType))
        {
            this.relateTabCryout(request, pm, shopInfo, relationPara);
        }
        else if (RelationConstaints.RELATION_NOTICE.equals(relateType))
        {
            this.relateTabNotice(request, pm, shopInfo, relationPara);
        }
        else if (RelationConstaints.RELATION_GOODS.equals(relateType))
        {
            this.relateTabGoods(request, pm, shopInfo, relationPara);
        }
        else if (RelationConstaints.RELATION_COUPON.equals(relateType))
        {
            this.relateTabCoupon(request, pm, shopInfo, relationPara);
        }
        else if (RelationConstaints.RELATION_ENTITY.equals(relateType))
        {
            this.relateTabEntity(request, pm, shopInfo, relationPara);
        }
        else if (RelationConstaints.RELATION_EVENT.equals(relateType))
        {
            this.relateTabEvent(request, pm, shopInfo, relationPara);
        }
        else if (RelationConstaints.RELATION_CARD.equals(relateType))
        {
            this.relateTabCard(request, pm, shopInfo, relationPara);
        }
        else if (RelationConstaints.RELATION_BRAND.equals(relateType))
        {
            this.relateTabBrand(request, pm, shopInfo, relationPara);
        }
        else if (RelationConstaints.RELATION_CATEGORY.equals(relateType))
        {
            this.relateTabCategory(request, pm, shopInfo, relationPara);
        }
        else if (RelationConstaints.RELATION_ACTIVITY_CONTENT.equals(relateType))
        {
            this.relateTabActivityContent(request, pm, shopInfo, relationPara);
        }
        else if (RelationConstaints.RELATION_TRANSPC_INFO.equals(relateType))
        {
            this.relateTabTranspcInfo(request, pm, shopInfo, relationPara);
        }
        else if (RelationConstaints.RELATION_CMS_CHANNELANDARTICEL.equals(relateType))
        {
            this.relateTabCmsContent(request, pm, shopInfo, relationPara);
        }

        return new TransData<PageModel<Object>>(true, null, pm);
    }

    @Override
    public TransData<List<ZTreeNode>> treeRelation(HttpServletRequest request) throws Exception
    {
        List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>();

        String relateType = ServletRequestUtils.getStringParameter(request, "relateType", "");
        String selectType = ServletRequestUtils.getStringParameter(request, "selectType", "");

        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        RelationPara relationPara = ServletUtils.objectMethod(RelationPara.class, request);

        if (RelationConstaints.RELATION_TOOL.equals(relateType))
        {
            this.relateTreeTool(request, nodeList, shopInfo, relationPara);
        }
        else if (RelationConstaints.RELATION_POSITION.equals(relateType))
        {
            this.relateTreePosition(request, nodeList, shopInfo, relationPara);
        }
        else if (RelationConstaints.RELATION_CATEGORY.equals(relateType))
        {
            this.relateTreeCategory(request, nodeList, shopInfo, relationPara);
        }
        if ("M".equals(selectType))
        {
            GMSServiceUtil.clearZtreeNodeClick(nodeList);
        }
        return new TransData<List<ZTreeNode>>(true, null, nodeList);
    }

    /**
     * 关联活动
     * @param request
     * @param pm
     * @param shopInfo
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void relateTabActivity(HttpServletRequest request, PageModel pm, ShopLoginInfo shopInfo, RelationPara relationPara) throws Exception
    {
        String dataType = relationPara.getDataType();
        String marketingId = relationPara.getMarketingId();
        String fname = relationPara.getFname();
        String shopId = shopInfo.getShopAndUserInfo().getShopId();

        FActivity activity = new FActivity();
        if (RelationConstaints.RELATION_DATATYPE_CURRENT.equals(dataType))
        {
            activity.setEndTime_FE(new Date());
        }

        MarketingActivityExample example = new MarketingActivityExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause(RelationServiceUtil.getOrderByOnDefault(request));
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO).andPublishStatusEqualTo(GMSConstant.AUDIT_STATUS_TYPE_RELEASE);
        criteria.andEndTimeGreaterThanOrEqualTo(new Date());
        criteria.andShopIdEqualTo(shopId);
        if (org.springframework.util.StringUtils.hasText(fname))
        {
            criteria.andActivityNameLike("%" + fname + "%");
        }
        if (org.springframework.util.StringUtils.hasText(activity.getPublishStatus()))
        {
            criteria.andPublishStatusEqualTo(activity.getPublishStatus());
        }

        int count = this.activityQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<MarketingActivity> list = this.activityQueryService.selectByExample(example);
            for (MarketingActivity activityInfo : list)
            {
                pm.getResult().add(this.convertToFActivity(activityInfo, marketingId));
            }
        }
    }

    /**
     * 关联吆喝
     * @param request
     * @param pm
     * @param shopInfo
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void relateTabCryout(HttpServletRequest request, PageModel pm, ShopLoginInfo shopInfo, RelationPara relationPara) throws Exception
    {
        String shopId = shopInfo.getShopAndUserInfo().getShopId();
        String fname = relationPara.getFname();
        String activityId = relationPara.getActivityId();
        CryoutInfoExample example = new CryoutInfoExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause(RelationServiceUtil.getOrderByOnDefault(request));
        com.gooagoo.entity.generator.marketing.CryoutInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO).andPublishStatusEqualTo(GMSConstant.AUDIT_STATUS_TYPE_RELEASE);
        criteria.andShopIdEqualTo(shopId);
        if (StringUtils.hasText(activityId))
        {
            criteria.andActivityIdEqualTo(activityId);
        }
        if (StringUtils.hasText(fname))
        {
            criteria.andCryoutTitleLike("%" + fname + "%");
        }
        int count = this.cryoutQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<CryoutInfo> list = this.cryoutQueryService.selectByExample(example);
            for (CryoutInfo cryoutInfo : list)
            {
                pm.getResult().add(this.convertToFCryout(cryoutInfo));
            }
        }
    }

    /**
     * 关联通知
     * @param request
     * @param pm
     * @param shopInfo
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void relateTabNotice(HttpServletRequest request, PageModel pm, ShopLoginInfo shopInfo, RelationPara relationPara) throws Exception
    {
        String shopId = shopInfo.getShopAndUserInfo().getShopId();
        String fname = relationPara.getFname();
        String activityId = relationPara.getActivityId();
        NoticeInfoExample example = new NoticeInfoExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause(RelationServiceUtil.getOrderByOnDefault(request));
        com.gooagoo.entity.generator.marketing.NoticeInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO).andPublishStatusEqualTo(GMSConstant.AUDIT_STATUS_TYPE_RELEASE);
        criteria.andShopIdEqualTo(shopId);

        if (StringUtils.hasText(activityId))
        {
            criteria.andActivityIdEqualTo(activityId);
        }
        if (StringUtils.hasText(fname))
        {
            criteria.andNoticeTitleLike("%" + fname + "%");
        }
        int count = this.noticeQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<NoticeInfo> list = this.noticeQueryService.selectByExample(example);
            for (NoticeInfo noticeInfo : list)
            {
                pm.getResult().add(this.convertToFNotice(noticeInfo));
            }
        }

    }

    /**
     * 关联商品
     * @param request
     * @param pm
     * @param shopInfo
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void relateTabGoods(HttpServletRequest request, PageModel pm, ShopLoginInfo shopInfo, RelationPara relationPara) throws Exception
    {
        String shopId = shopInfo.getShopAndUserInfo().getShopId();
        String fname = relationPara.getFname();
        String shopEntityId = relationPara.getShopEntityId();
        String marketingId = relationPara.getMarketingId();
        String categoryLeafId = relationPara.getFcategoryLeafId();
        String brandId = relationPara.getFbrandId();

        GoodsBaseInfoExample example = new GoodsBaseInfoExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause(RelationServiceUtil.getOrderByOnDefault(request));
        com.gooagoo.entity.generator.goods.GoodsBaseInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo("N").andPublishStatusEqualTo(GMSConstant.AUDIT_STATUS_TYPE_RELEASE);
        criteria.andShopIdEqualTo(shopId);
        if (StringUtils.hasText(shopEntityId))
        {
            criteria.andShopEntityIdEqualTo(shopEntityId);
        }
        if (StringUtils.hasText(categoryLeafId))
        {
            criteria.andGoodsCategoryLeafEqualTo(categoryLeafId);
        }
        if (StringUtils.hasText(brandId))
        {
            criteria.andGoodsBrandEqualTo(brandId);
        }
        if (StringUtils.hasText(fname))
        {
            criteria.andGoodsNameLike("%" + fname + "%");
        }
        int count = this.goodsBaseInfoGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        List<GoodsBaseInfo> list = this.goodsBaseInfoGeneratorQueryService.selectByExample(example);

        for (GoodsBaseInfo goodsBaseInfo : list)
        {
            pm.getResult().add(this.convertToFGoods(goodsBaseInfo, marketingId));
        }

        pm = GMSServiceUtil.removeGoodsDuplicate(pm);//过滤重复的商品             

    }

    /**
     * 关联优惠凭证
     * @param request
     * @param pm
     * @param shopInfo
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void relateTabCoupon(HttpServletRequest request, PageModel pm, ShopLoginInfo shopInfo, RelationPara relationPara) throws Exception
    {
        String shopId = shopInfo.getShopAndUserInfo().getShopId();

        String marketingId = relationPara.getMarketingId();
        String dataType = relationPara.getDataType();
        String fname = relationPara.getFname();
        String ftype = relationPara.getFtype();
        String ftime = relationPara.getFtime();

        FCoupon coupon = ServletUtils.objectMethod(FCoupon.class, request);
        if (RelationConstaints.RELATION_DATATYPE_CURRENT.equals(dataType))
        {
            coupon.setCouponChannle("2");
        }
        else if (RelationConstaints.RELATION_DATATYPE_CURRENT_JIFEN.equals(dataType))
        {
            coupon.setCouponChannle("0");
        }

        CouponExample example = new CouponExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause(RelationServiceUtil.getOrderByOnDefault(request));

        com.gooagoo.entity.generator.marketing.CouponExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andPublishStatusEqualTo(GMSConstant.AUDIT_STATUS_TYPE_RELEASE);
        criteria.andUseEndTimeGreaterThanOrEqualTo(new Date());//当前有效的
        criteria.andShopIdEqualTo(shopId);
        if (StringUtils.hasText(ftype))//优惠券种类
        {
            criteria.andCouponTypeEqualTo(ftype);
        }
        if (StringUtils.hasText(fname))//优惠凭证名称
        {
            criteria.andCouponNameLike("%" + fname + "%");
        }
        if (StringUtils.hasText(coupon.getCouponSource()))
        {
            criteria.andCouponSourceEqualTo(coupon.getCouponSource());
        }
        if (StringUtils.hasText(coupon.getCouponChannle()))
        {
            criteria.andCouponChannleEqualTo(coupon.getCouponChannle());
        }
        if (StringUtils.hasText(ftime))
        {
            criteria.andUseStartTimeLessThanOrEqualTo(TimeUtils.convertStringToDate(ftime));//>=使用生效日期
            criteria.andUseEndTimeGreaterThanOrEqualTo(TimeUtils.convertStringToDate(ftime));//<=使用截止日期
        }

        int count = this.couponQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<Coupon> list = this.couponQueryService.selectByExample(example);
            for (Coupon c : list)
            {
                pm.getResult().add(this.convertToFCoupon(c, marketingId));
            }
        }

    }

    /**
     * 关联实体店
     * @param request
     * @param pm
     * @param shopInfo
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void relateTabEntity(HttpServletRequest request, PageModel pm, ShopLoginInfo shopInfo, RelationPara relationPara) throws Exception
    {
        String shopId = shopInfo.getShopAndUserInfo().getShopId();

        ShopEntityInfoExample example = new ShopEntityInfoExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause(RelationServiceUtil.getOrderByOnDefault(request));

        com.gooagoo.entity.generator.shop.ShopEntityInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        int count = this.shopEntityInfoGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<ShopEntityInfo> list = this.shopEntityInfoGeneratorQueryService.selectByExample(example);
            for (ShopEntityInfo se : list)
            {
                FShopEntityInfo ms = new FShopEntityInfo();
                EntityTools.copyValue(se, ms);
                pm.getResult().add(ms);
            }
        }

    }

    /**
     * 关联事件
     * @param request
     * @param pm
     * @param shopInfo
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void relateTabEvent(HttpServletRequest request, PageModel pm, ShopLoginInfo shopInfo, RelationPara relationPara) throws Exception
    {
        String shopId = shopInfo.getShopAndUserInfo().getShopId();

        String activityId = relationPara.getActivityId();
        String channelCode = relationPara.getChannelCode();

        MarketingEventExample example = new MarketingEventExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause(RelationServiceUtil.getOrderByOnDefault(request));
        com.gooagoo.entity.generator.marketing.MarketingEventExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO).andPublishStatusEqualTo(GMSConstant.AUDIT_STATUS_TYPE_RELEASE);
        criteria.andShopIdEqualTo(shopId);
        if (StringUtils.hasText(activityId))
        {
            criteria.andActivityIdEqualTo(activityId);
        }
        if (StringUtils.hasText(channelCode))
        {
            criteria.andChannelRootEqualTo(channelCode);
        }

        int count = this.marketingEventGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<MarketingEvent> list = this.marketingEventGeneratorQueryService.selectByExample(example);
            for (MarketingEvent marketingEvent : list)
            {
                pm.getResult().add(this.convertToFEvent(marketingEvent));
            }
        }

    }

    /**
     * 关联会员卡
     * @param request
     * @param pm
     * @param shopInfo
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void relateTabCard(HttpServletRequest request, PageModel pm, ShopLoginInfo shopInfo, RelationPara relationPara) throws Exception
    {
        String shopId = shopInfo.getShopAndUserInfo().getShopId();
        String fname = relationPara.getFname();

        MemberCardExample example = new MemberCardExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause("card_Lvl");
        com.gooagoo.entity.generator.member.MemberCardExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        if (org.springframework.util.StringUtils.hasText(fname))
        {
            criteria.andCardNameLike("%" + fname + "%");
        }
        int count = this.memberCardGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<MemberCard> memberCardList = this.memberCardGeneratorQueryService.selectByExample(example);
            for (MemberCard card : memberCardList)
            {
                pm.getResult().add(this.convertToFMemberCard(card));
            }
        }

    }

    /**
     * 关联品牌
     * @param request
     * @param pm
     * @param shopInfo
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void relateTabBrand(HttpServletRequest request, PageModel pm, ShopLoginInfo shopInfo, RelationPara relationPara) throws Exception
    {
        String shopId = shopInfo.getShopAndUserInfo().getShopId();
        String entityId = RelationServiceUtil.getShopEntityId(request, shopInfo);
        String brandId = relationPara.getFbrandId();
        String brandName = relationPara.getFbrandName();
        GoodsBrandExample example = new GoodsBrandExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause(RelationServiceUtil.getOrderByOnDefault(request));
        com.gooagoo.entity.generator.goods.GoodsBrandExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        if (StringUtils.hasText(entityId))
        {
            criteria.andShopEntityIdEqualTo(entityId);
        }
        if (StringUtils.hasText(brandId))
        {
            criteria.andBrandIdEqualTo(brandId);
        }
        if (StringUtils.hasText(brandName))
        {
            criteria.andBrandNameLike("%" + brandName + "%");
        }
        int count = this.brandQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<GoodsBrand> list = this.brandQueryService.selectByExample(example);

            for (GoodsBrand gb : list)
            {
                pm.getResult().add(this.convertToFGoodsBrand(gb));
            }
            pm = GMSServiceUtil.removeGoodsBrandDuplicate(pm);//过滤重复品牌
        }
    }

    /**
     * 关联品类
     * @param request
     * @param pm
     * @param shopInfo
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void relateTabCategory(HttpServletRequest request, PageModel pm, ShopLoginInfo shopInfo, RelationPara relationPara) throws Exception
    {
        String shopId = shopInfo.getShopAndUserInfo().getShopId();
        String entityId = RelationServiceUtil.getShopEntityId(request, shopInfo);
        String categoryName = relationPara.getFcategoryLeafName();
        String categoryId = relationPara.getFcategoryLeafId();
        if (!StringUtils.hasText(entityId))
        {
            entityId = null;
        }
        int count = this.goodsCategoryQueryService.findDistinctGoodsCategoryCount(shopId, entityId, categoryId, categoryName);
        pm.setCount(count);
        if (count > 0)
        {
            List<GoodsCategory> list = this.goodsCategoryQueryService.findDistinctGoodsCategory(shopId, entityId, categoryId, categoryName, pm.getIndex(), pm.getPageSize());

            for (GoodsCategory gc : list)
            {
                pm.getResult().add(this.convertToFGoodsCategory(gc));
            }
        }
    }

    /**
     * 关联活动内容
     * @param request
     * @param pm
     * @param shopInfo
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void relateTabActivityContent(HttpServletRequest request, PageModel pm, ShopLoginInfo shopInfo, RelationPara relationPara) throws Exception
    {
        String shopId = shopInfo.getShopAndUserInfo().getShopId();

        String fname = relationPara.getFname();
        String activityId = relationPara.getActivityId();
        String contentType = relationPara.getContentType();
        String dataType = relationPara.getDataType();
        List<String> channelList = new ArrayList<String>();
        channelList.add("3");
        channelList.add("4");

        MarketingViewExample example = new MarketingViewExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause(RelationServiceUtil.getOrderByOnDefault(request));
        com.gooagoo.entity.generator.marketing.MarketingViewExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andPublishStatusEqualTo(GMSConstant.AUDIT_STATUS_TYPE_RELEASE);//查询已发布的
        criteria.andShopIdEqualTo(shopId);
        if (StringUtils.hasText(activityId))
        {
            criteria.andActivityIdEqualTo(activityId);
        }
        if (StringUtils.hasText(fname))
        {
            criteria.andTitleLike("%" + fname + "%");
        }
        if (StringUtils.hasText(contentType))
        {
            criteria.andChannelCodeEqualTo(contentType);
        }
        else if (!StringUtils.hasText(dataType))
        {
            criteria.andChannelCodeNotIn(channelList);
        }

        Integer count = this.marketingViewGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<MarketingView> resultList = this.marketingViewGeneratorQueryService.selectByExample(example);
            for (MarketingView marketingView : resultList)
            {
                pm.getResult().add(this.covertToFActivityContent(marketingView));
            }
        }

    }

    /**
     * 关联转发器
     * @param request
     * @param pm
     * @param shopInfo
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void relateTabTranspcInfo(HttpServletRequest request, PageModel pm, ShopLoginInfo shopInfo, RelationPara relationPara) throws Exception
    {
        String shopId = shopInfo.getShopAndUserInfo().getShopId();
        String entityId = RelationServiceUtil.getShopEntityId(request, shopInfo);

        DeviceTransponderExample example = new DeviceTransponderExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause(RelationServiceUtil.getOrderByOnDefault(request));
        com.gooagoo.entity.generator.shop.DeviceTransponderExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);

        if (StringUtils.hasText(entityId))
        {
            criteria.andShopEntityIdEqualTo(entityId);
        }
        criteria.andStatusEqualTo("0");
        Integer count = this.deviceTransponderGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<DeviceTransponder> list = this.deviceTransponderGeneratorQueryService.selectByExample(example);
            for (DeviceTransponder dt : list)
            {
                pm.getResult().add(this.convertToFTranspcInfo(dt));
            }
        }
        for (int i = 0; i < pm.getResult().size(); i++)
        {
            String string = SysdictionaryCache.get("s_device_type", ((FTranspcInfo) pm.getResult().get(i)).getDeviceType());
            ((FTranspcInfo) pm.getResult().get(i)).setTypeNameCh(string);
        }

    }

    /**
     * 关联cms内容
     * @param request
     * @param pm
     * @param shopInfo
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void relateTabCmsContent(HttpServletRequest request, PageModel pm, ShopLoginInfo shopInfo, RelationPara relationPara) throws Exception
    {
        String shopId = shopInfo.getShopAndUserInfo().getShopId();

        String channelType = relationPara.getChannelType();
        String cmsContentType = relationPara.getCmsContentType();
        String fname = relationPara.getFname();

        CmsContentExample example = new CmsContentExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause(RelationServiceUtil.getOrderByOnDefault(request));
        com.gooagoo.entity.generator.sys.CmsContentExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andPublishStatusEqualTo(GMSConstant.AUDIT_STATUS_TYPE_RELEASE);//查询已发布的
        criteria.andShopIdEqualTo(shopId);
        if (StringUtils.hasText(fname))
        {
            criteria.andCmsContentNameLike("%" + fname + "%");
        }
        if (StringUtils.hasText(channelType))
        {
            criteria.andChannelTypeEqualTo(channelType);
        }
        if (StringUtils.hasText(cmsContentType))
        {
            criteria.andCmsContentTypeEqualTo(cmsContentType);
        }

        Integer count = this.cmsContentGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<CmsContent> list = this.cmsContentGeneratorQueryService.selectByExample(example);
            for (CmsContent dt : list)
            {
                pm.getResult().add(this.convertToFCmsContent(dt));
            }
        }

    }

    /**
     * 关联服务工具
     * @param request
     * @param nodeList
     * @param shopInfo
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void relateTreeTool(HttpServletRequest request, List<ZTreeNode> nodeList, ShopLoginInfo shopInfo, RelationPara relationPara) throws Exception
    {
        String shopId = shopInfo.getShopAndUserInfo().getShopId();
        List<MarketingChannel> children = this.marketingChannelQueryService.findMarketingChannelListByParent(GMSConstant.CHANNEL_TOOL_ROOT_CODE);
        children = this.filterChannelByApplyTool(children, shopId);

        List<ZTreeNode> sysNodeList = new ArrayList<ZTreeNode>();
        for (MarketingChannel mc : children)
        {
            sysNodeList.add(this.convertTocZTreenode(mc));
        }
        nodeList.addAll(sysNodeList);
        GMSServiceUtil.setZtreeNodeClick("tool", nodeList);

    }

    /**
     * 关联位置（区域）
     * @param request
     * @param nodeList
     * @param shopInfo
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void relateTreePosition(HttpServletRequest request, List<ZTreeNode> nodeList, ShopLoginInfo shopInfo, RelationPara relationPara) throws Exception
    {
        String shopId = shopInfo.getShopAndUserInfo().getShopId();
        String entityId = RelationServiceUtil.getShopEntityId(request, shopInfo);
        String parentPositionId = ServletRequestUtils.getStringParameter(request, "rootId", "-1");

        List<ZTreeNode> nodes = this.positionService.getShopPositionZtree0(shopId, entityId, parentPositionId);
        nodeList.addAll(nodes);

        GMSServiceUtil.setZtreeNodeClick("position", nodeList);
    }

    /**
     * 关联品类
     * @param request
     * @param nodeList
     * @param shopInfo
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void relateTreeCategory(HttpServletRequest request, List<ZTreeNode> nodeList, ShopLoginInfo shopInfo, RelationPara relationPara) throws Exception
    {
        String shopId = shopInfo.getShopAndUserInfo().getShopId();
        String entityId = RelationServiceUtil.getShopEntityId(request, shopInfo);

        GoodsCategoryExample example = new GoodsCategoryExample();
        com.gooagoo.entity.generator.goods.GoodsCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        criteria.andShopEntityIdEqualTo(entityId);
        List<GoodsCategory> list = this.queryCategoryService.selectByExample(example);
        for (GoodsCategory gc : list)
        {
            ZTreeNode zn = new ZTreeNode();
            zn.setId(gc.getCategoryId());
            zn.setName(gc.getCategoryName());
            zn.setpId(gc.getParentCategoryId());
            nodeList.add(zn);
        }

        nodeList = GMSServiceUtil.removeTreeDuplicateId(nodeList);

        GMSServiceUtil.setZtreeNodeClick("category", nodeList);
    }

    /**
     * 过滤未申请服务工具的手机服务渠道编码
     * @param channelList
     * @param shopId
     * @return
     */
    private List<MarketingChannel> filterChannelByApplyTool(List<MarketingChannel> channelList, String shopId)
    {
        //获取商家已申请成功的服务工具
        ShopToolListExample shopToolListExample = new ShopToolListExample();
        com.gooagoo.entity.generator.shop.ShopToolListExample.Criteria toolListCriteria = shopToolListExample.createCriteria();
        toolListCriteria.andIsDelEqualTo("N");
        toolListCriteria.andShopIdEqualTo(shopId);
        toolListCriteria.andStatusEqualTo("P");
        List<ShopToolList> toolList = this.shopToolListGeneratorQueryService.selectByExample(shopToolListExample);
        //查询手机服务渠道中需要过滤的配置信息
        String relations = GmsConfigCache.get("mobile_tool_channel_relation");
        Map<String, String> map = null;
        try
        {
            map = new Gson().fromJson(relations, Map.class);
        }
        catch (Exception e)
        {
            GooagooLog.warn("GmsConfigCache[mobile_tool_channel_relation]=" + relations + "转Map<String, String>失败");
            map = new HashMap<String, String>();
        }
        for (Iterator<ShopToolList> iterator = toolList.iterator(); iterator.hasNext();)
        {
            ShopToolList shopToolList = iterator.next();
            String key = shopToolList.getToolId();
            String toolValue = map.get(key);
            if (StringUtils.hasText(toolValue))
            {
                map.remove(key);
            }
        }
        //将需要过滤的渠道编码组装起来
        StringBuffer filterToolIds = new StringBuffer();
        for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext();)
        {
            String key = iterator.next();
            String value = map.get(key);
            if (StringUtils.hasText(value))
            {
                filterToolIds.append("," + value);
            }
        }
        filterToolIds.append(",");
        //过滤渠道
        List<MarketingChannel> newChannelList = new ArrayList<MarketingChannel>();
        for (int i = 0; i < channelList.size(); i++)
        {
            MarketingChannel marketingChannel = channelList.get(i);
            String channelCode = marketingChannel.getChannelCode() + "";
            if (filterToolIds.toString().indexOf("," + channelCode + ",") < 0)
            {
                newChannelList.add(marketingChannel);
            }
        }
        return newChannelList;
    }

    private FActivity convertToFActivity(MarketingActivity activityInfo, String marketingId) throws Exception
    {
        FActivity fActivity = new FActivity();
        if (activityInfo != null)
        {
            EntityTools.copyValue(activityInfo, fActivity);

            String webVisitUrl = UrlUtils.getActiveUrl(activityInfo.getActivityId(), marketingId);
            String mobileVisitUrl = UrlUtils.getActiveMobileUrl(activityInfo.getActivityId(), marketingId);

            fActivity.setWebVisitUrl(webVisitUrl);
            fActivity.setMobileVisitUrl(mobileVisitUrl);
        }
        return fActivity;
    }

    private FCryout convertToFCryout(CryoutInfo cryoutInfo) throws IllegalArgumentException, IllegalAccessException
    {
        FCryout fCryout = new FCryout();
        if (fCryout != null)
        {
            EntityTools.copyValue(cryoutInfo, fCryout);
        }
        return fCryout;
    }

    private FNotice convertToFNotice(NoticeInfo noticeInfo) throws IllegalArgumentException, IllegalAccessException
    {
        FNotice fNotice = new FNotice();
        if (fNotice != null)
        {
            EntityTools.copyValue(noticeInfo, fNotice);
        }
        return fNotice;
    }

    private FCoupon convertToFCoupon(Coupon cp, String marketingId) throws Exception
    {
        FCoupon coupon = null;
        if (cp != null)
        {
            coupon = new FCoupon();
            EntityTools.copyValue(cp, coupon);
            coupon.setStatus(cp.getPublishStatus());
            coupon.setNote(cp.getAuditNote());
            coupon.setfCouponJson(new Gson().fromJson(cp.getCheckJson(), FCouponJson.class));

            String webVisitUrl = UrlUtils.getCouponUrl(cp.getCouponId(), marketingId);
            String mobileVisitUrl = UrlUtils.getCouponMobileUrl(cp.getCouponId(), marketingId);

            coupon.setWebVisitUrl(webVisitUrl);
            coupon.setMobileVisitUrl(mobileVisitUrl);
        }
        return coupon;
    }

    private FEvent convertToFEvent(MarketingEvent event) throws IllegalArgumentException, IllegalAccessException
    {
        FEvent fe = null;
        if (event != null)
        {
            fe = new FEvent();
            EntityTools.copyValue(event, fe);
        }
        return fe;
    }

    private FMemberCard convertToFMemberCard(MemberCard memberCard) throws IllegalArgumentException, IllegalAccessException
    {
        FMemberCard fMemberCard = null;

        if (memberCard != null)
        {
            fMemberCard = new FMemberCard();
            EntityTools.copyValue(memberCard, fMemberCard);
            fMemberCard.setCardHeadUrl(UrlUtils.getAttachUrlByImg("dh_top", memberCard.getCardUrl()));
            fMemberCard.setCardBodyUrl(UrlUtils.getAttachUrlByImg("dh_bottom", memberCard.getCardUrl()));
        }
        return fMemberCard;
    }

    private FGoodsBrand convertToFGoodsBrand(GoodsBrand brand) throws IllegalArgumentException, IllegalAccessException
    {
        FGoodsBrand goodsBrand = null;
        if (brand != null)
        {
            goodsBrand = new FGoodsBrand();
            EntityTools.copyValue(brand, goodsBrand);
        }
        return goodsBrand;
    }

    private FGoodsCategory convertToFGoodsCategory(GoodsCategory category) throws IllegalArgumentException, IllegalAccessException
    {
        FGoodsCategory goodsCategory = null;
        if (category != null)
        {
            goodsCategory = new FGoodsCategory();
            EntityTools.copyValue(category, goodsCategory);
        }
        return goodsCategory;
    }

    private FActivityContent covertToFActivityContent(MarketingView marketingView) throws IllegalArgumentException, IllegalAccessException
    {
        FActivityContent fac = null;
        if (marketingView != null)
        {
            fac = new FActivityContent();
            EntityTools.copyValue(marketingView, fac);
        }
        return fac;
    }

    private FTranspcInfo convertToFTranspcInfo(DeviceTransponder dt) throws IllegalArgumentException, IllegalAccessException
    {
        FTranspcInfo ft = null;
        if (dt != null)
        {
            ft = new FTranspcInfo();
            EntityTools.copyValue(dt, ft);
        }
        return ft;
    }

    private FCmsContent convertToFCmsContent(CmsContent dt) throws IllegalArgumentException, IllegalAccessException
    {
        FCmsContent ft = null;
        if (dt != null)
        {
            ft = new FCmsContent();
            EntityTools.copyValue(dt, ft);
        }
        return ft;
    }

    private ZTreeNode convertTocZTreenode(MarketingChannel mc)
    {
        ZTreeNode zn = new ZTreeNode();
        zn.setId(mc.getChannelCode().toString());
        zn.setName(mc.getChannelName());
        zn.setpId(mc.getParentChannelCode().toString());
        return zn;
    }

    private FGoods convertToFGoods(GoodsBaseInfo info, String marketingId)
    {
        FGoods goods = null;
        if (info != null)
        {
            goods = new FGoods();
            goods.setGoodsId(info.getGoodsId());
            goods.setGoodsName(info.getGoodsName());
            goods.setShopId(info.getShopId());
            goods.setEntityId(info.getShopEntityId());
            goods.setBrandId(info.getGoodsBrand());
            goods.setCategoryLeafId(info.getGoodsCategoryLeaf());
            goods.setCategoryRootId(info.getGoodsCategoryRoot());
            goods.setGoodsSerial(info.getGoodsSerial());
            goods.setItemSerial(info.getItemSerial());
            goods.setPrice(String.valueOf(info.getPrice()));

            if (StringUtils.hasText(info.getGoodsId()))
            {
                //有些地方需要用图片URL
                GoodsMarketingInfo gm = this.goodsMarketingInfoGeneratorQueryService.selectByPrimaryKey(info.getGoodsId());
                if (gm != null && org.springframework.util.StringUtils.hasText(gm.getGoodsImg()))
                {
                    List list = this.jsonToString(gm.getGoodsImg());
                    if (list.size() > 0)
                    {
                        goods.setGoodsImg(String.valueOf(list.get(0)));
                    }
                }
            }
            try
            {
                goods.setMobileVisitUrl(UrlUtils.getGoodsUrl(info.getGoodsId(), marketingId));
                goods.setWebVisitUrl(UrlUtils.getGoodsUrl(info.getGoodsId(), marketingId));
            }
            catch (Exception e)
            {
                GooagooLog.error("获取商品移动地址或者web地址出现异常", e);
                e.printStackTrace();
            }

            GoodsBrandExample brandExample = new GoodsBrandExample();
            com.gooagoo.entity.generator.goods.GoodsBrandExample.Criteria criteria = brandExample.createCriteria();
            criteria.andShopIdEqualTo(info.getShopId());
            criteria.andShopEntityIdEqualTo(info.getShopEntityId());
            criteria.andBrandIdEqualTo(info.getGoodsBrand());

            List<GoodsBrand> brands = this.brandQueryService.selectByExample(brandExample);
            if (brands != null && brands.size() > 0)
            {
                goods.setBrandName(brands.get(0).getBrandName());
            }

            GoodsCategoryExample categoryExample = new GoodsCategoryExample();
            com.gooagoo.entity.generator.goods.GoodsCategoryExample.Criteria c = categoryExample.createCriteria();
            c.andShopIdEqualTo(info.getShopId());
            c.andShopEntityIdEqualTo(info.getShopEntityId());
            c.andCategoryIdEqualTo(info.getGoodsCategoryLeaf());
            List<GoodsCategory> categories = this.categoryQueryService.selectByExample(categoryExample);
            if (categories != null)
            {
                if (categories.size() > 0)
                {
                    goods.setCategoryLeafName(categories.get(0).getCategoryName());
                }
            }
        }
        return goods;
    }

    private List jsonToString(String str)
    {
        if (!org.springframework.util.StringUtils.hasText(str))
        {
            return null;
        }
        Gson gson = new Gson();
        List<String> list = gson.fromJson(str, List.class);

        return list;
    }
}
