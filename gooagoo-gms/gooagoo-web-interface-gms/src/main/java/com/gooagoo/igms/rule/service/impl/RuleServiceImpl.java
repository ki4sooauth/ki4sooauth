package com.gooagoo.igms.rule.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.marketing.rule.RuleResultCoreService;
import com.gooagoo.api.generator.query.base.MarketingChannelGeneratorQueryService;
import com.gooagoo.api.generator.query.base.SysDictionaryGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBrandGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsCategoryGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.CouponGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingActivityGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingEventGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.RuleConfigGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.RuleInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.RuleResultGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopPositionGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopToolListGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.CmsContentGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.marketing.rule.ActionAttribute;
import com.gooagoo.entity.business.marketing.rule.RuleCondition;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.base.MarketingChannel;
import com.gooagoo.entity.generator.base.SysDictionary;
import com.gooagoo.entity.generator.base.SysDictionaryExample;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample;
import com.gooagoo.entity.generator.goods.GoodsBrand;
import com.gooagoo.entity.generator.goods.GoodsBrandExample;
import com.gooagoo.entity.generator.goods.GoodsCategory;
import com.gooagoo.entity.generator.goods.GoodsCategoryExample;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.marketing.MarketingEvent;
import com.gooagoo.entity.generator.marketing.RuleConfig;
import com.gooagoo.entity.generator.marketing.RuleConfigExample;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.RuleInfoExample;
import com.gooagoo.entity.generator.marketing.RuleInfoExample.Criteria;
import com.gooagoo.entity.generator.marketing.RuleResult;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.entity.generator.shop.ShopToolList;
import com.gooagoo.entity.generator.sys.CmsContent;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.common.utils.ReleaseUtil;
import com.gooagoo.igms.rule.service.RuleService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.igms.userAccount.service.UserAccountService;
import com.gooagoo.view.gms.common.PageCondition;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.rule.FActionAttribute;
import com.gooagoo.view.gms.rule.FHistoryCondition;
import com.gooagoo.view.gms.rule.FNaturalAttribute;
import com.gooagoo.view.gms.rule.FRule;
import com.gooagoo.view.gms.rule.FRuleCondition;
import com.gooagoo.view.gms.rule.FRuleConfig;
import com.gooagoo.view.gms.rule.FRuleInfo;
import com.gooagoo.view.gms.rule.FRuleResult;
import com.google.gson.Gson;

@Service(value = "ruleService")
public class RuleServiceImpl implements RuleService
{
    @Autowired
    private RuleInfoGeneratorQueryService ruleInfoGeneratorQueryService;
    @Autowired
    private RuleResultGeneratorQueryService ruleResultGeneratorQueryService;
    @Autowired
    private RuleResultCoreService ruleResultCoreService;
    @Autowired
    private RuleConfigGeneratorQueryService ruleConfigGeneratorQueryService;
    @Autowired
    private MemberCardGeneratorQueryService memberCardGeneratorQueryService;
    @Autowired
    private ShopPositionGeneratorQueryService shopPositionGeneratorQueryService;
    @Autowired
    private GoodsBrandGeneratorQueryService goodsBrandGeneratorQueryService;
    @Autowired
    private GoodsCategoryGeneratorQueryService goodsCategoryGeneratorQueryService;
    @Autowired
    private GoodsBaseInfoGeneratorQueryService goodsBaseInfoGeneratorQueryService;
    @Autowired
    private MarketingActivityGeneratorQueryService marketingActivityGeneratorQueryService;
    @Autowired
    private CouponGeneratorQueryService couponGeneratorQueryService;
    @Autowired
    private MarketingEventGeneratorQueryService marketingEventGeneratorQueryService;
    @Autowired
    private ShopToolListGeneratorQueryService shopToolListGeneratorQueryService;
    @Autowired
    private MarketingChannelGeneratorQueryService marketingChannelGeneratorQueryService;
    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private ShopLoginService shopLoginService;
    @Autowired
    private SysDictionaryGeneratorQueryService sysDictionaryGeneratorQueryService;
    @Autowired
    private CmsContentGeneratorQueryService cmsContentGeneratorQueryService;

    /**
     * 添加规则信息
     */
    @Override
    public TransData<Object> add(HttpServletRequest request) throws Exception
    {
        FRuleInfo fRuleInfo = ReleaseUtil.getRuleInfo(request);
        FRuleResult fRuleResult = ServletUtils.objectMethod(FRuleResult.class, request);

        fRuleResult.setRuleResultId(StringUtils.getUUID());
        fRuleResult.setRuleId(fRuleInfo.getRuleId());
        RuleResult ruleResult = this.convertToRuleResult(fRuleResult);

        RuleInfo ruleInfo = this.convertToRuleInfo(fRuleInfo);
        ruleInfo.setObjectId(ruleResult.getRuleResultId());

        boolean result = this.checkRule(ruleInfo, ruleResult);
        if (result)
        {
            result = this.ruleResultCoreService.addRuleResultAndInfo(ruleResult, ruleInfo);
        }
        return GMSUtil.getBooleanAndExtendResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, (Object) ruleInfo.getRuleId(), ruleInfo.getRuleId());
    }

    /**
     * 删除规则信息
     */
    @Override
    public TransData<Object> delete(HttpServletRequest request) throws Exception
    {
        String ruleId = ServletRequestUtils.getStringParameter(request, "ruleId", "");

        boolean result = this.ruleResultCoreService.deleteRuleResultAndInfo(ruleId);

        return new TransData<Object>(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, ruleId);
    }

    /**
     * 修改规则信息
     */
    @Override
    public TransData<Object> update(HttpServletRequest request) throws Exception
    {
        FRuleInfo fRuleInfo = ReleaseUtil.getRuleInfo(request);
        FRuleResult fRuleResult = ServletUtils.objectMethod(FRuleResult.class, request);

        RuleInfo ruleInfo = this.convertToRuleInfo(fRuleInfo);
        RuleResult ruleResult = this.convertToRuleResult(fRuleResult);

        boolean result = this.checkRule(ruleInfo, ruleResult);
        if (result)
        {
            result = this.ruleResultCoreService.updateRuleResultAndInfo(ruleResult, ruleInfo);
        }

        return new TransData<Object>(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, fRuleInfo.getRuleId());
    }

    /**
     * 获取规则列表信息
     */
    @Override
    public TransData<PageModel<FRuleInfo>> pageRule(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FRuleInfo ruleInfo = ServletUtils.objectMethod(FRuleInfo.class, request);
        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);
        String types = request.getParameter("ruleTypes");

        List<String> ruleTypes = new ArrayList<String>();
        if (org.springframework.util.StringUtils.hasText(types))
        {
            String[] type = types.split(",");
            for (int i = 0; i < type.length; i++)
            {
                ruleTypes.add(type[i]);
            }
        }

        PageModel<FRuleInfo> pm = new PageModel<FRuleInfo>();
        pm.setPageIndex(pc.getPageIndex());
        pm.setPageSize(pc.getPageSize());
        if (pc.getPageSize() == 0)
        {
            pm.setPageSize(10);
        }
        RuleInfoExample example = new RuleInfoExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause("c_time_stamp desc");
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        if (org.springframework.util.StringUtils.hasText(ruleInfo.getRuleName()))
        {
            criteria.andRuleNameLike("%" + ruleInfo.getRuleName() + "%");
        }
        if (org.springframework.util.StringUtils.hasText(ruleInfo.getActivityId()))
        {
            criteria.andActivityIdEqualTo(ruleInfo.getActivityId());
        }
        if (org.springframework.util.StringUtils.hasText(ruleInfo.getPublishStatus()))
        {
            criteria.andPublishStatusEqualTo(ruleInfo.getPublishStatus());
        }
        if (org.springframework.util.StringUtils.hasText(types))
        {
            criteria.andRuleTypeIn(ruleTypes);
        }

        Integer count = this.ruleInfoGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<RuleInfo> resultList = this.ruleInfoGeneratorQueryService.selectByExample(example);
            for (RuleInfo info : resultList)
            {
                pm.getResult().add(this.convertToFRuleInfo(info));
            }
        }

        return new TransData<PageModel<FRuleInfo>>(true, null, pm);
    }

    /**
     * 获取规则详细信息
     */
    @Override
    public TransData<FRule> getRuleInfo(HttpServletRequest request) throws Exception
    {
        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        String shopId = shopInfo.getShopAndUserInfo().getShopId();
        String shopEntityId = shopInfo.getShopAndUserInfo().getUserShopEntityId();

        String ruleId = ServletRequestUtils.getStringParameter(request, "ruleId", "");

        FRule frule = new FRule();
        RuleInfo ruleInfo = this.ruleInfoGeneratorQueryService.selectByPrimaryKey(ruleId);
        RuleResult ruleResult = new RuleResult();
        if (ruleInfo != null)
        {
            ruleResult = this.ruleResultGeneratorQueryService.selectByPrimaryKey(ruleInfo.getObjectId());
        }
        FRuleInfo fRuleInfo = this.convertToFRuleInfo(ruleInfo);
        FRuleResult fRuleResult = this.convertToFRuleResult(ruleResult);
        String name = null;
        if ("6".equals(fRuleInfo.getRuleType()) || "7".equals(fRuleInfo.getRuleType()))
        {
            if ("1".equals(fRuleResult.getRuleResultType()))
            {
                name = this.getNames(fRuleResult.getRuleResultValue(), "vipGrade", shopId, shopEntityId);
            }
            else if ("4".equals(fRuleResult.getRuleResultType()))
            {
                name = this.getNames(fRuleResult.getRuleResultValue(), "goods", shopId, shopEntityId);
            }
            else if ("5".equals(fRuleResult.getRuleResultType()))
            {
                name = this.getNames(fRuleResult.getRuleResultValue(), "coupon", shopId, shopEntityId);
            }
        }
        fRuleResult.setRuleResultName(name);

        FRuleCondition condition = this.getAllName(fRuleInfo.getRuleContent(), shopId, shopEntityId);
        String json = new Gson().toJson(condition);
        fRuleInfo.setRuleContent(json);

        frule.setRuleInfo(fRuleInfo);
        frule.setRuleResult(fRuleResult);

        return new TransData<FRule>(true, null, frule, ruleId);
    }

    /**
     * 审核规则信息
     */
    @Override
    public TransData<Object> approval(HttpServletRequest request) throws Exception
    {
        String ruleId = ServletRequestUtils.getStringParameter(request, "ruleId", "");
        String status = ServletRequestUtils.getStringParameter(request, "status", "");
        String note = ServletRequestUtils.getStringParameter(request, "note", "");

        boolean result = this.ruleResultCoreService.reviewedRuleResultAndInfo(ruleId, status, note);

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, ruleId);
    }

    /**
     * 发布规则信息
     */
    @Override
    public TransData<Object> publish(HttpServletRequest request) throws Exception
    {
        String ruleId = ServletRequestUtils.getStringParameter(request, "ruleId", "");

        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        RuleInfo ruleInfo = this.ruleInfoGeneratorQueryService.selectByPrimaryKey(ruleId);
        FRuleInfo fRuleInfo = this.convertToFRuleInfo(ruleInfo);

        List<Account> userList = null;
        if (!"1".equals(ruleInfo.getCrowdType()))
        {
            userList = this.userAccountService.getUserAccountList(fRuleInfo, shopId, "");
        }

        boolean result = this.ruleResultCoreService.publishRuleResultAndInfo(ruleId, userList);

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, ruleId);
    }

    /**
     * 查询规则配置
     */
    @Override
    public TransData<FRuleConfig> getConfig(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        String behaveType = ServletRequestUtils.getStringParameter(request, "behaveType", "");

        RuleConfigExample example = new RuleConfigExample();

        com.gooagoo.entity.generator.marketing.RuleConfigExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo("N");
        criteria.andShopIdEqualTo(shopId);
        criteria.andBehaveTypeEqualTo(behaveType);

        List<RuleConfig> resultList = this.ruleConfigGeneratorQueryService.selectByExample(example);
        RuleConfig config = new RuleConfig();
        if (resultList != null && resultList.size() > 0)
        {
            config = resultList.get(0);
        }
        FRuleConfig ruleConfig = this.convertToFRuleConfig(config);
        return new TransData<FRuleConfig>(true, null, ruleConfig);
    }

    /**
     * 查询商家下行为列表
     */
    @Override
    public TransData<Map<String, String>> getShopBehaveList(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        RuleConfigExample example = new RuleConfigExample();

        com.gooagoo.entity.generator.marketing.RuleConfigExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo("N");
        criteria.andShopIdEqualTo(shopId);

        List<RuleConfig> resultList = this.ruleConfigGeneratorQueryService.selectByExample(example);
        Map<String, String> map = new TreeMap<String, String>();
        for (RuleConfig ruleConfig : resultList)
        {
            if (ruleConfig != null)
            {
                SysDictionaryExample dictionaryExample = new SysDictionaryExample();
                com.gooagoo.entity.generator.base.SysDictionaryExample.Criteria criteria2 = dictionaryExample.createCriteria();

                criteria2.andIsDelEqualTo("N");
                criteria2.andDictionaryTypeEqualTo("behave_type");
                criteria2.andEnglishNameEqualTo(ruleConfig.getBehaveType());
                List<SysDictionary> behaveList = this.sysDictionaryGeneratorQueryService.selectByExample(dictionaryExample);
                if (behaveList != null && behaveList.size() > 0)
                {
                    map.put(ruleConfig.getBehaveType(), behaveList.get(0).getChineseName());
                }
            }
        }
        return new TransData<Map<String, String>>(true, null, map);
    }

    /**
     * 获取名称
     * @param content
     * @param shopId
     * @param shopEntityId
     * @return
     */
    private FRuleCondition getAllName(String content, String shopId, String shopEntityId)
    {
        FRuleCondition condition = new Gson().fromJson(content, FRuleCondition.class);
        FActionAttribute action = condition.getActionAttribute();
        FHistoryCondition history = condition.getHistoryCondition();
        List<FActionAttribute> list = history.getList();
        FNaturalAttribute natural = history.getNaturalAttribute();

        if (natural.getGrade() != null && natural.getGrade() != "")
        {
            String names = this.getNames(natural.getGrade(), "grade", shopId, shopEntityId);
            natural.setGradeName(names);
        }
        if (action != null)
        {
            action = this.perfectInfo(action, shopId, shopEntityId);
        }
        for (FActionAttribute obj : list)
        {
            if (obj != null)
            {
                obj = this.perfectInfo(obj, shopId, shopEntityId);
            }
        }
        return condition;
    }

    private FActionAttribute perfectInfo(FActionAttribute action, String shopId, String shopEntityId)
    {
        String[] ids = null;
        String[] types = new String[] { "vipGrade", "position", "brand", "category", "goods", "activity", "event", "coupon", "tools", "cms" };
        ids = new String[] { action.getVipGrade(), action.getPosition(), action.getMarketingGoodsBrand(), action.getMarketingGoodsCategory(), action.getMarketingGoods(), action.getMarketingActivity(), action.getMarketingEvent(), action.getMarketingCoupon(), action.getServerTools(), action.getCmsContent() };
        for (int i = 0; i < ids.length; i++)
        {
            if (ids[i] != null && ids[i] != "")
            {
                String names = this.getNames(ids[i], types[i], shopId, shopEntityId);
                if ("vipGrade".equals(types[i]))
                {
                    action.setVipGradeName(names);
                    continue;
                }
                if ("position".equals(types[i]))
                {
                    action.setPositionName(names);
                    continue;
                }
                if ("brand".equals(types[i]))
                {
                    action.setMarketingGoodsBrandName(names);
                    continue;
                }
                if ("category".equals(types[i]))
                {
                    action.setMarketingGoodsCategoryName(names);
                    continue;
                }
                if ("goods".equals(types[i]))
                {
                    action.setMarketingGoodsName(names);
                    continue;
                }
                if ("activity".equals(types[i]))
                {
                    action.setMarketingActivityName(names);
                    continue;
                }
                if ("event".equals(types[i]))
                {
                    action.setMarketingEventName(names);
                    continue;
                }
                if ("coupon".equals(types[i]))
                {
                    action.setMarketingCouponName(names);
                    continue;
                }
                if ("tools".equals(types[i]))
                {
                    action.setServerToolsName(names);
                    continue;
                }
                if ("cms".equals(types[i]))
                {
                    action.setCmsContentName(names);
                    continue;
                }
            }
        }
        return action;
    }

    /**
     * 获取名称
     * @param ids
     * @param type
     * @param shopId
     * @param shopEntityId
     * @return
     */
    private String getNames(String ids, String type, String shopId, String shopEntityId)
    {
        StringBuffer names = new StringBuffer();
        String result = "";
        String[] arrayId = ids.split(",");

        if ("vipGrade".equals(type) || "grade".equals(type))
        {
            for (int i = 0; i < arrayId.length; i++)
            {
                MemberCard obj = this.memberCardGeneratorQueryService.selectByPrimaryKey(arrayId[i]);
                if (obj != null)
                {
                    names.append(obj.getCardName() + ",");
                }
                else
                {
                    names.append("无效,");
                }
            }
        }
        else if ("position".equals(type))
        {
            for (int i = 0; i < arrayId.length; i++)
            {
                ShopPosition obj = this.shopPositionGeneratorQueryService.selectByPrimaryKey(arrayId[i]);
                if (obj != null)
                {
                    names.append(obj.getPositionName() + ",");
                }
                else
                {
                    names.append("无效,");
                }
            }
        }
        else if ("brand".equals(type))
        {
            for (int i = 0; i < arrayId.length; i++)
            {
                GoodsBrandExample example = new GoodsBrandExample();
                com.gooagoo.entity.generator.goods.GoodsBrandExample.Criteria criteria = example.createCriteria();
                criteria.andIsDelEqualTo(GMSConstant.NO);
                criteria.andShopIdEqualTo(shopId);
                if (org.springframework.util.StringUtils.hasText(shopEntityId))
                {
                    criteria.andShopEntityIdEqualTo(shopEntityId);
                }
                criteria.andBrandIdEqualTo(arrayId[i]);
                List<GoodsBrand> list = this.goodsBrandGeneratorQueryService.selectByExample(example);
                if (list != null && list.size() > 0)
                {
                    names.append(list.get(0).getBrandName() + ",");
                }
                else
                {
                    names.append("无效,");
                }
            }
        }
        else if ("category".equals(type))
        {
            for (int i = 0; i < arrayId.length; i++)
            {
                GoodsCategoryExample example = new GoodsCategoryExample();
                com.gooagoo.entity.generator.goods.GoodsCategoryExample.Criteria criteria = example.createCriteria();
                criteria.andIsDelEqualTo(GMSConstant.NO);
                criteria.andShopIdEqualTo(shopId);
                if (org.springframework.util.StringUtils.hasText(shopEntityId))
                {
                    criteria.andShopEntityIdEqualTo(shopEntityId);
                }
                criteria.andCategoryIdEqualTo(arrayId[i]);
                List<GoodsCategory> list = this.goodsCategoryGeneratorQueryService.selectByExample(example);
                if (list != null && list.size() > 0)
                {
                    names.append(list.get(0).getCategoryName() + ",");
                }
                else
                {
                    names.append("无效,");
                }
            }
        }
        else if ("goods".equals(type))
        {
            for (int i = 0; i < arrayId.length; i++)
            {
                GoodsBaseInfoExample example = new GoodsBaseInfoExample();
                example.setOrderByClause("shop_entity_id");
                com.gooagoo.entity.generator.goods.GoodsBaseInfoExample.Criteria criteria = example.createCriteria();
                criteria.andIsDelEqualTo(GMSConstant.NO);
                criteria.andShopIdEqualTo(shopId);
                criteria.andItemSerialEqualTo(arrayId[i]);

                List<GoodsBaseInfo> list = this.goodsBaseInfoGeneratorQueryService.selectByExample(example);
                if (list != null && list.size() > 0)
                {
                    names.append(list.get(0).getGoodsName() + ",");
                }
                else
                {
                    names.append("无效,");
                }
            }
        }
        else if ("activity".equals(type))
        {
            for (int i = 0; i < arrayId.length; i++)
            {
                MarketingActivity obj = this.marketingActivityGeneratorQueryService.selectByPrimaryKey(arrayId[i]);
                if (obj != null)
                {
                    names.append(obj.getActivityName() + ",");
                }
                else
                {
                    names.append("无效,");
                }
            }
        }
        else if ("coupon".equals(type))
        {
            for (int i = 0; i < arrayId.length; i++)
            {
                Coupon obj = this.couponGeneratorQueryService.selectByPrimaryKey(arrayId[i]);
                if (obj != null)
                {
                    names.append(obj.getCouponName() + ",");
                }
                else
                {
                    names.append("无效,");
                }
            }
        }
        else if ("event".equals(type))
        {
            for (int i = 0; i < arrayId.length; i++)
            {
                MarketingEvent obj = this.marketingEventGeneratorQueryService.selectByPrimaryKey(arrayId[i]);
                if (obj != null)
                {
                    names.append(obj.getEventName() + ",");
                }
                else
                {
                    names.append("无效,");
                }
            }
        }
        else if ("tools".equals(type))
        {
            for (int i = 0; i < arrayId.length; i++)
            {
                ShopToolList obj1 = null;
                MarketingChannel obj2 = null;
                if (arrayId[i].length() == 32)
                {
                    obj1 = this.shopToolListGeneratorQueryService.selectByPrimaryKey(arrayId[i]);
                }
                else
                {
                    obj2 = this.marketingChannelGeneratorQueryService.selectByPrimaryKey(Integer.parseInt(arrayId[i]));
                }
                if (obj1 != null)
                {
                    names.append(obj1.getToolName() + ",");
                }
                else if (obj2 != null)
                {
                    names.append(obj2.getChannelName() + ",");
                }
                else
                {
                    names.append("无效,");
                }
            }
        }
        else if ("cms".equals(type))
        {
            for (int i = 0; i < arrayId.length; i++)
            {
                CmsContent obj = this.cmsContentGeneratorQueryService.selectByPrimaryKey(arrayId[i]);
                if (obj != null)
                {
                    names.append(obj.getCmsContentName() + ",");
                }
                else
                {
                    names.append("无效,");
                }
            }
        }
        result = names.toString();
        result = result.substring(0, result.length() - 1);
        return result;
    }

    private RuleInfo convertToRuleInfo(FRuleInfo fRuleInfo) throws IllegalArgumentException, IllegalAccessException
    {
        RuleInfo ruleInfo = new RuleInfo();
        if (fRuleInfo != null)
        {
            EntityTools.copyValue(fRuleInfo, ruleInfo);
        }
        return ruleInfo;
    }

    private FRuleInfo convertToFRuleInfo(RuleInfo info) throws IllegalArgumentException, IllegalAccessException
    {
        FRuleInfo fRuleInfo = new FRuleInfo();
        if (info != null)
        {
            EntityTools.copyValue(info, fRuleInfo);
        }
        return fRuleInfo;
    }

    private RuleResult convertToRuleResult(FRuleResult fRuleResult) throws IllegalArgumentException, IllegalAccessException
    {
        RuleResult ruleResult = new RuleResult();
        if (fRuleResult != null)
        {
            EntityTools.copyValue(fRuleResult, ruleResult);
        }
        return ruleResult;
    }

    private FRuleResult convertToFRuleResult(RuleResult ruleResult) throws IllegalArgumentException, IllegalAccessException
    {
        FRuleResult fRuleResult = new FRuleResult();
        if (ruleResult != null)
        {
            EntityTools.copyValue(ruleResult, fRuleResult);
        }
        return fRuleResult;
    }

    private FRuleConfig convertToFRuleConfig(RuleConfig config) throws IllegalArgumentException, IllegalAccessException
    {
        FRuleConfig fRuleConfig = new FRuleConfig();
        if (config != null)
        {
            EntityTools.copyValue(config, fRuleConfig);
        }
        return fRuleConfig;
    }

    /**
     * 添加规则时，检验规则信息
     * @param ruleInfo
     * @param ruleResult
     * @return
     * @throws Exception 
     */
    private boolean checkRule(RuleInfo ruleInfo, RuleResult ruleResult) throws Exception
    {
        // TODO Auto-generated method stub
        //校验ruleInfo
        if (ruleInfo == null)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(ruleInfo.getRuleId()) || ruleInfo.getRuleId().length() != 32)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(ruleInfo.getRuleName()) || ruleInfo.getRuleName().length() > 32)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(ruleInfo.getRuleType()))
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(ruleInfo.getObjectId()))
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(ruleInfo.getCrowdType()))
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(ruleInfo.getIsPublishImmediately()))
        {
            return false;
        }

        //检验规则的有效期在活动有效期内
        if (!org.apache.commons.lang.StringUtils.isBlank(ruleInfo.getActivityId()))
        {
            MarketingActivity activity = this.marketingActivityGeneratorQueryService.selectByPrimaryKey(ruleInfo.getActivityId());
            //1-规则有效时间：在活动有效期内
            if (TimeUtils.dateDiff(3, ruleInfo.getStartTime(), activity.getStartTime()) > 0 || TimeUtils.dateDiff(3, ruleInfo.getStartTime(), activity.getEndTime()) < 0)
            {
                return false;
            }
            if (TimeUtils.dateDiff(3, ruleInfo.getStartTime(), ruleInfo.getEndTime()) < 0)
            {
                return false;
            }
            //2-实时时间段：实时条件中时间段应该在规则有效期内
            RuleCondition condition = new Gson().fromJson(ruleInfo.getRuleContent(), RuleCondition.class);
            if (condition != null)
            {
                ActionAttribute actionAttribute = condition.getActionAttribute();
                if (actionAttribute != null)
                {
                    if (org.apache.commons.lang.StringUtils.isBlank(actionAttribute.getDateStart()))
                    {
                        return false;
                    }
                    if (TimeUtils.dateDiff(3, TimeUtils.convertStringToDate(actionAttribute.getDateStart()), ruleInfo.getStartTime()) > 0)
                    {
                        return false;
                    }
                    if (org.apache.commons.lang.StringUtils.isBlank(actionAttribute.getDateEnd()))
                    {
                        return false;
                    }
                    if (TimeUtils.dateDiff(3, TimeUtils.convertStringToDate(actionAttribute.getDateEnd()), ruleInfo.getEndTime()) < 0)
                    {
                        return false;
                    }
                }
            }
            //3-规则延时发布时间：延时时间应该不大于规则开始时间
            if (GMSConstant.NO.equals(ruleInfo.getIsPublishImmediately()))
            {
                if (org.apache.commons.lang.StringUtils.isBlank(ruleInfo.getExpectPublishTime().toString()) || TimeUtils.dateDiff(3, ruleInfo.getStartTime(), ruleInfo.getExpectPublishTime()) < 0)
                {
                    return false;
                }
            }
        }
        //校验ruleResult
        if (ruleResult == null)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(ruleResult.getRuleResultType()))
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(ruleResult.getRuleResultValue()))
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(ruleResult.getRuleResultValue()))
        {
            return false;
        }
        if ("0".equals(ruleResult.getRuleResultType()))//积分(正整数)
        {
            if (!ruleResult.getRuleResultValue().matches("[0-9]*"))
            {
                return false;
            }
        }
        if ("2".equals(ruleResult.getRuleResultType()))//金额(正浮点数)
        {
            if (!ruleResult.getRuleResultValue().matches("^(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$"))
            {
                return false;
            }
        }
        if ("3".equals(ruleResult.getRuleResultType()))//折扣率(0~1正浮点数)
        {
            if (!ruleResult.getRuleResultValue().matches("^(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$"))
            {
                return false;
            }
            if (Float.parseFloat(ruleResult.getRuleResultType()) >= 1 || Float.parseFloat(ruleResult.getRuleResultType()) <= 0)
            {
                return false;
            }
        }
        if ("4".equals(ruleResult.getRuleResultType()))//商品
        {
            if (!org.apache.commons.lang.StringUtils.isBlank(ruleResult.getAddConsumeMoney().toString()))//追加金额
            {
                if (ruleResult.getRuleResultValue().toString().matches("^(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$"))
                {
                    return false;
                }
            }
        }
        if (!org.apache.commons.lang.StringUtils.isBlank(ruleResult.getRuleDesc()))
        {
            if (ruleResult.getRuleDesc().length() > 500)
            {
                return false;
            }
        }
        return true;
    }
}
