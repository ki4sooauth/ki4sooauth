package com.gooagoo.mis.rsrcmanage.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.marketing.rule.RuleConfigCoreService;
import com.gooagoo.api.generator.query.marketing.RuleConfigGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.marketing.RuleConfig;
import com.gooagoo.entity.generator.marketing.RuleConfigExample;
import com.gooagoo.entity.generator.marketing.RuleConfigExample.Criteria;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.rsrcmanage.service.RuleConfigService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.enterprise.MRuleConfig;

@Service(value = "ruleConfigService")
public class RuleConfigServiceImpl implements RuleConfigService
{
    @Autowired
    private RuleConfigGeneratorQueryService ruleConfigGeneratorQueryService;
    @Autowired
    private RuleConfigCoreService RuleConfigCoreService;
    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    /**
     * 新增规则配置
     */
    @Override
    public TransData<Object> addRuleConfig(HttpServletRequest request) throws Exception
    {

        MRuleConfig mrule = ServletUtils.objectMethod(MRuleConfig.class, request);
        mrule = this.initRuleConfig(mrule, request);
        RuleConfigExample example = new RuleConfigExample();
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo("N");
        //商家编号
        if (StringUtils.hasText(mrule.getShopId()))
        {
            criteria.andShopIdEqualTo(mrule.getShopId());
        }
        //行为类型
        if (StringUtils.hasText(mrule.getBehaveType()))
        {
            criteria.andBehaveTypeEqualTo(mrule.getBehaveType());
        }
        List<RuleConfig> ruleList = this.ruleConfigGeneratorQueryService.selectByExample(example);
        if (ruleList.size() > 0)
        {
            return new TransData<Object>(false, MisMessageConst.MIS_RESOURCE_RULECONFIG_CHECK_FAIL, null);
        }
        RuleConfig rule = new RuleConfig();
        EntityTools.copyValue(mrule, rule);
        boolean flag = this.RuleConfigCoreService.addRuleConfig(rule);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_RESOURCE_RULECONFIG_ADD_SUCCESS, MisMessageConst.MIS_RESOURCE_RULECONFIG_ADD_FAIL, rule.getId());
    }

    /**
     * 修改规则配置
     */
    @Override
    public TransData<Object> updateRuleConfig(HttpServletRequest request) throws Exception
    {
        MRuleConfig mrule = ServletUtils.objectMethod(MRuleConfig.class, request);
        mrule = this.initRuleConfig(mrule, request);
        RuleConfigExample example = new RuleConfigExample();
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo("N");
        criteria.andShopIdEqualTo(mrule.getShopId()).andIdNotEqualTo(mrule.getId());
        //行为类型
        criteria.andBehaveTypeEqualTo(mrule.getBehaveType() == null ? "" : mrule.getBehaveType());
        if (StringUtils.hasText(mrule.getBehaveType()))
        {
            criteria.andBehaveTypeEqualTo(mrule.getBehaveType());
        }
        List<RuleConfig> ruleList = this.ruleConfigGeneratorQueryService.selectByExample(example);
        if (ruleList.size() > 0)
        {
            return new TransData<Object>(false, MisMessageConst.MIS_RESOURCE_RULECONFIG_CHECK_FAIL, null);
        }
        RuleConfig rule = new RuleConfig();
        EntityTools.copyValue(mrule, rule);
        boolean flag = this.RuleConfigCoreService.updateRuleConfig(rule);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_RESOURCE_RULECONFIG_UPDATE_SUCCESS, MisMessageConst.MIS_RESOURCE_RULECONFIG_UPDATE_FAIL, rule.getId());
    }

    /**
     * 删除规则配置
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> deleteRuleConfig(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        boolean flag = this.RuleConfigCoreService.deleteRuleConfig(ids);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_RESOURCE_RULECONFIG_DELETE_SUCCESS, MisMessageConst.MIS_RESOURCE_RULECONFIG_DELETE_FAIL);
    }

    /**
     * 查询所有规则配置
     */
    @Override
    public TransData<PageModel<MRuleConfig>> queryAllRuleConfig(HttpServletRequest request) throws Exception
    {
        MRuleConfig mrule = ServletUtils.objectMethod(MRuleConfig.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        RuleConfigExample example = new RuleConfigExample();
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo("N");
        if (StringUtils.hasText(mrule.getShopId()))
        {
            criteria.andShopIdLike(mrule.getShopId());
        }
        if (StringUtils.hasText(mrule.getBehaveType()))
        {
            criteria.andBehaveTypeEqualTo(mrule.getBehaveType());
        }
        PageModel<MRuleConfig> pm = new PageModel<MRuleConfig>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageCondition.getPageSize() <= 0 ? 10 : pageCondition.getPageSize());
        }
        Integer count = this.ruleConfigGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            example.setPage(pm.getPageIndex(), pm.getPageSize());
            List<RuleConfig> rule = this.ruleConfigGeneratorQueryService.selectByExample(example);
            for (RuleConfig rul : rule)
            {
                MRuleConfig mrul = new MRuleConfig();
                EntityTools.copyValue(rul, mrul);
                if (StringUtils.hasText(mrul.getShopId()))
                {
                    ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectUnDelByPrimaryKey(mrul.getShopId());
                    if (shopInfo != null)
                    {
                        mrul.setShopName(shopInfo.getShopName());
                    }
                }
                pm.getResult().add(mrul);
            }
        }
        return new TransData<PageModel<MRuleConfig>>(true, null, pm);
    }

    /**
     * 查询规则配置详细
     */
    @Override
    public TransData<MRuleConfig> queryRuleConfig(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        RuleConfig rule = this.ruleConfigGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[0]);
        if (rule != null)
        {
            MRuleConfig mrule = new MRuleConfig();
            EntityTools.copyValue(rule, mrule);
            if (StringUtils.hasText(mrule.getShopId()))
            {
                ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectUnDelByPrimaryKey(mrule.getShopId());
                if (shopInfo != null)
                {
                    mrule.setShopName(shopInfo.getShopName());
                }
            }
            return new TransData<MRuleConfig>(true, null, mrule);
        }
        else
        {
            return new TransData<MRuleConfig>(false, MisMessageConst.MIS_RESOURCE_RULECONFIG_QUERY_FAIL, null);
        }
    }

    /**
     * 初始化实体类
     * @return
     * @throws Exception
     */
    private MRuleConfig initRuleConfig(MRuleConfig rule, HttpServletRequest request) throws Exception
    {
        MRuleConfig mrule = new MRuleConfig();
        if (rule != null)
        {
            EntityTools.copyValue(rule, mrule);
            mrule.setIsShowDateScope("Y");
            mrule.setIsShowWeekScope("Y");
            if (StringUtils.hasText(ServletRequestUtils.getStringParameter(request, "0", "")))
            {
                mrule.setIsShowTimeScope(ServletRequestUtils.getStringParameter(request, "0", "Y"));
            }
            else
            {
                mrule.setIsShowTimeScope("N");
            }
            if (StringUtils.hasText(ServletRequestUtils.getStringParameter(request, "1", "")))
            {
                mrule.setIsShowVipGrade(ServletRequestUtils.getStringParameter(request, "1", "Y"));
            }
            else
            {
                mrule.setIsShowVipGrade("N");
            }
            if (StringUtils.hasText(ServletRequestUtils.getStringParameter(request, "2", "")))
            {
                mrule.setIsShowActionSource(ServletRequestUtils.getStringParameter(request, "2", "Y"));
            }
            else
            {
                mrule.setIsShowActionSource("N");
            }
            if (StringUtils.hasText(ServletRequestUtils.getStringParameter(request, "3", "")))
            {
                mrule.setIsShowTime(ServletRequestUtils.getStringParameter(request, "3", "Y"));
            }
            else
            {
                mrule.setIsShowTime("N");
            }
            if (StringUtils.hasText(ServletRequestUtils.getStringParameter(request, "4", "")))
            {
                mrule.setIsShowTotalTime(ServletRequestUtils.getStringParameter(request, "4", "Y"));
            }
            else
            {
                mrule.setIsShowTotalTime("N");
            }
            if (StringUtils.hasText(ServletRequestUtils.getStringParameter(request, "5", "")))
            {
                mrule.setIsShowMarketingGoodsCategory(ServletRequestUtils.getStringParameter(request, "5", "Y"));
            }
            else
            {
                mrule.setIsShowMarketingGoodsCategory("N");
            }
            if (StringUtils.hasText(ServletRequestUtils.getStringParameter(request, "6", "")))
            {
                mrule.setIsShowMarketingGoodsBrand(ServletRequestUtils.getStringParameter(request, "6", "Y"));
            }
            else
            {
                mrule.setIsShowMarketingGoodsBrand("N");
            }
            if (StringUtils.hasText(ServletRequestUtils.getStringParameter(request, "7", "")))
            {
                mrule.setIsShowMarketingGoods(ServletRequestUtils.getStringParameter(request, "7", "Y"));
            }
            else
            {
                mrule.setIsShowMarketingGoods("N");
            }
            if (StringUtils.hasText(ServletRequestUtils.getStringParameter(request, "C", "")))
            {
                mrule.setIsShowMarketingAction(ServletRequestUtils.getStringParameter(request, "C", "Y"));
            }
            else
            {
                mrule.setIsShowMarketingAction("N");
            }
            if (StringUtils.hasText(ServletRequestUtils.getStringParameter(request, "E", "")))
            {
                mrule.setIsShowMarketingCoupon(ServletRequestUtils.getStringParameter(request, "E", "Y"));
            }
            else
            {
                mrule.setIsShowMarketingCoupon("N");
            }
            if (StringUtils.hasText(ServletRequestUtils.getStringParameter(request, "D", "")))
            {
                mrule.setIsShowMarketingEvent(ServletRequestUtils.getStringParameter(request, "D", "Y"));
            }
            else
            {
                mrule.setIsShowMarketingEvent("N");
            }
            if (StringUtils.hasText(ServletRequestUtils.getStringParameter(request, "B", "")))
            {
                mrule.setIsShowServerTools(ServletRequestUtils.getStringParameter(request, "B", "Y"));
            }
            else
            {
                mrule.setIsShowServerTools("N");
            }
            if (StringUtils.hasText(ServletRequestUtils.getStringParameter(request, "9", "")))
            {
                mrule.setIsShowPosition(ServletRequestUtils.getStringParameter(request, "9", "Y"));
            }
            else
            {
                mrule.setIsShowPosition("N");
            }
            if (StringUtils.hasText(ServletRequestUtils.getStringParameter(request, "A", "")))
            {
                mrule.setIsShowDuration(ServletRequestUtils.getStringParameter(request, "A", "Y"));
            }
            else
            {
                mrule.setIsShowDuration("N");
            }
            if (StringUtils.hasText(ServletRequestUtils.getStringParameter(request, "8", "")))
            {
                mrule.setIsShowConsumeMoney(ServletRequestUtils.getStringParameter(request, "8", "Y"));
            }
            else
            {
                mrule.setIsShowConsumeMoney("N");
            }
            if (StringUtils.hasText(ServletRequestUtils.getStringParameter(request, "F", "")))
            {
                mrule.setIsShowVb(ServletRequestUtils.getStringParameter(request, "F", "Y"));
            }
            else
            {
                mrule.setIsShowVb("N");
            }
        }
        return mrule;
    }
}
