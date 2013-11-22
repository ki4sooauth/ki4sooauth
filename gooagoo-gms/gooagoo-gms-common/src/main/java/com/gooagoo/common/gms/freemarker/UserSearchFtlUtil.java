package com.gooagoo.common.gms.freemarker;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.constants.TemplateConstant;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.view.gms.crm.CrowdInfoVo;
import com.gooagoo.view.gms.member.FMemberFeature;
import com.gooagoo.view.gms.rule.FActionAttribute;
import com.gooagoo.view.gms.rule.FHistoryCondition;
import com.gooagoo.view.gms.rule.FNaturalAttribute;
import com.gooagoo.view.gms.rule.FRuleCondition;
import com.gooagoo.view.gms.rule.FRuleConfig;
import com.gooagoo.view.gms.rule.FRuleInfo;
import com.google.gson.Gson;

public class UserSearchFtlUtil
{

    /**
     * 获取用户历史属性内容（自然属性+行为属性）
     * @param request
     * @param realBehave
     * @return
     * @throws Exception
     */
    public static String getUserPropertyContentOnHistory(HttpServletRequest request, FHistoryCondition historyCondition) throws Exception
    {
        Map<String, Object> root = new HashMap<String, Object>();
        //用户自然属性参数
        putUserNatureParas(request, historyCondition.getNaturalAttribute(), root);
        //用户历史行为属性参数
        putUserBehaveParas(request, GMSConstant.USER_SEARCH_CONDITION_TYPE_HISTORY, historyCondition.getList(), root);
        //字典表参数
        putDictionaryParas(root);
        //页面公用参数
        GMSFtlUtil.putDefaultRequestParasToMap(request, root);

        return FreemarkerUtil.getContent(TemplateConstant.FTL_FILE_USER_PROPERTY_HISTORY, root);
    }

    /**
     * 获取规则条件内容（历史人群细分、实时人群细分、发布计划）
     * @param request
     * @param condition
     * @param ruleInfo
     * @return
     * @throws Exception
     */
    public static String getRuleConditionContent(HttpServletRequest request, FRuleCondition condition, FRuleInfo ruleInfo) throws Exception
    {
        Map<String, Object> root = new HashMap<String, Object>();
        if (condition == null)
        {
            condition = new FRuleCondition();
        }
        freashRuleConditionValue(condition);
        //字典表参数
        putDictionaryParas(root);
        //页面公用参数
        GMSFtlUtil.putDefaultRequestParasToMap(request, root);
        //发布规则编辑页面公用参数
        putRuleCommonParas(request, root);
        //获取已细分人群数据
        putAlreadySaveUserParas(request, condition.getHistoryCondition().getCrowdId(), condition.getHistoryCondition().getCrowdName(), root);
        //用户自然属性参数
        putUserNatureParas(request, condition.getHistoryCondition().getNaturalAttribute(), root);
        //用户历史行为属性参数
        putUserBehaveParas(request, GMSConstant.USER_SEARCH_CONDITION_TYPE_HISTORY, condition.getHistoryCondition().getList(), root);
        //用户实时细分人群参数
        String ruleGroupContentOnReal = getRuleGroupContentOnReal(request, condition.getActionAttribute());
        if (ruleGroupContentOnReal == null)
        {
            return null;
        }
        root.put("ruleGroupReal", ruleGroupContentOnReal);
        //发布计划参数
        putRuleSettingParas(request, ruleInfo, root);

        return FreemarkerUtil.getContent("rule_condition.ftl", root);
    }

    /**
     * 获取用户行为属性查询条件内容
     * @param request
     * @param conditionType
     * @param behaveList
     * @return
     * @throws Exception
     */
    public static String getBehaveConditionContent(HttpServletRequest request, String conditionType, List<FActionAttribute> behaveList) throws Exception
    {
        Map<String, Object> root = new HashMap<String, Object>();
        //用户行为属性参数
        putUserBehaveParas(request, conditionType, behaveList, root);
        //字典表参数
        putDictionaryParas(root);
        //页面公用参数
        GMSFtlUtil.putDefaultRequestParasToMap(request, root);

        return FreemarkerUtil.getContent(TemplateConstant.FTL_FILE_USER_BEHAVE_ATTRIBUTE, root);
    }

    /**
     * 获取实时细分人群内容
     * @param request
     * @param realBehave
     * @return
     * @throws Exception
     */
    protected static String getRuleGroupContentOnReal(HttpServletRequest request, FActionAttribute realBehave) throws Exception
    {
        Map<String, Object> root = new HashMap<String, Object>();

        List<FActionAttribute> behaveList = new ArrayList<FActionAttribute>();
        if (realBehave != null)
        {
            behaveList.add(realBehave);
        }
        //用户实时行为属性参数
        putUserBehaveParas(request, GMSConstant.USER_SEARCH_CONDITION_TYPE_REAL, behaveList, root);
        //字典表参数
        putDictionaryParas(root);
        //页面公用参数
        GMSFtlUtil.putDefaultRequestParasToMap(request, root);

        return FreemarkerUtil.getContent(TemplateConstant.FTL_FILE_RULE_GROUP_REAL, root);
    }

    /**
     * 初始化FRuleCondition对象
     * @param condition
     */
    protected static void freashRuleConditionValue(FRuleCondition condition)
    {
        if (condition.getHistoryCondition() == null)
        {
            FHistoryCondition historyCondition = new FHistoryCondition();
            condition.setHistoryCondition(historyCondition);
        }
    }

    /**
     * 获取发布规则编辑页面公用数据
     * @param request
     */
    protected static void putRuleCommonParas(HttpServletRequest request, Map<String, Object> root) throws Exception
    {
        String activityId = ServletRequestUtils.getStringParameter(request, "activityId", "");
        root.put("activityId", activityId);
    }

    /**
     * 获取已细分人群数据
     * @param request
     */
    protected static void putAlreadySaveUserParas(HttpServletRequest request, String crowdId, String crowdName, Map<String, Object> root) throws Exception
    {
        //查询已有人群
        TransData<List> transfer = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_FIND_CROWDINFO, request, List.class);
        List<CrowdInfoVo> crowdList = transfer.getData();

        root.put("crowdList", crowdList);
        root.put("crowdId", crowdId);
        root.put("crowdName", crowdName);
    }

    /**
     * 获取用户自然属性数据
     * @param request
     */
    protected static void putUserNatureParas(HttpServletRequest request, FNaturalAttribute naturalAttribute, Map<String, Object> root) throws Exception
    {
        if (naturalAttribute == null)
        {
            naturalAttribute = new FNaturalAttribute();
        }

        // 获取会员特征
        TransData<List> fmemberFeaturesTransData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBEROFCARD_GET_SPECIALS, request, List.class);
        List<FMemberFeature> fmemberFeatures = fmemberFeaturesTransData.getData();
        if (CollectionUtils.isNotEmpty(fmemberFeatures))
        {
            for (FMemberFeature fMemberFeature : fmemberFeatures)
            {
                String enumValue = fMemberFeature.getEnumValue();
                fMemberFeature.setValuelist(new Gson().fromJson(enumValue, List.class));
            }
        }

        root.put("natural", naturalAttribute);
        root.put("fmemberFeatures", fmemberFeatures);
    }

    /**
     * 获取用户行为属性数据
     * @param request
     */
    protected static void putUserBehaveParas(HttpServletRequest request, String conditionType, List<FActionAttribute> behaveList, Map<String, Object> root) throws Exception
    {
        if (behaveList == null || behaveList.size() == 0)
        {
            GooagooLog.debug("behaveList为空");
            return;
        }
        List<FRuleConfig> configList = getRuleConfigList(request, behaveList);
        if (configList == null || behaveList.size() != configList.size())
        {
            GooagooLog.warn("用户行为条件和行为配置项数量不匹配：behaveList=" + behaveList.size() + ",configList=" + configList == null ? "null" : configList.size());
            throw new GooagooException("用户行为条件和行为配置项数量不匹配");
        }
        String actionTypes = "";
        for (int j = 0; j < behaveList.size(); j++)
        {
            String behaveType = behaveList.get(j).getActionType();

            actionTypes = actionTypes + behaveType + ",";
        }
        if (StringUtils.hasText(actionTypes))
        {
            actionTypes = actionTypes.substring(0, actionTypes.length() - 1);
        }
        root.put("actionTypes", actionTypes);
        root.put("conditionType", conditionType);
        root.put("behaveList", behaveList);
        root.put("configList", configList);
    }

    /**
     * 获取规则发布计划数据
     * @param request
     */
    protected static void putRuleSettingParas(HttpServletRequest request, FRuleInfo ruleInfo, Map<String, Object> root) throws Exception
    {
        if (ruleInfo == null)
        {
            ruleInfo = GMSUtil.getBlankObject(FRuleInfo.class);
        }

        Date day = new Date();
        String activeStartTime = ServletRequestUtils.getStringParameter(request, "activeStartTime", "");
        String activeEndTime = ServletRequestUtils.getStringParameter(request, "activeEndTime", "");
        String wpMinDate = "";
        if (!StringUtils.hasText(activeStartTime) || day.after(TimeUtils.convertStringToDate(activeStartTime)))
        {
            wpMinDate = TimeUtils.convertDateToString(day, "yyyy-MM-dd");
        }
        else
        {
            wpMinDate = activeStartTime;
        }
        String startTime = ruleInfo.getStartTime() != null ? TimeUtils.convertDateToString(ruleInfo.getStartTime(), "yyyy-MM-dd") : wpMinDate;
        String endTime = ruleInfo.getEndTime() != null ? TimeUtils.convertDateToString(ruleInfo.getEndTime(), "yyyy-MM-dd") : activeEndTime;

        root.put("wpMinDate", wpMinDate);
        root.put("startTime", startTime);
        root.put("endTime", endTime);
        root.put("sTime", activeStartTime);
        root.put("eTime", activeEndTime);
        root.put("info", ruleInfo);
    }

    /**
     * 根据用户行为查询行为属性配置项
     * @param request
     * @param behaveList
     * @return
     */
    protected static List<FRuleConfig> getRuleConfigList(HttpServletRequest request, List<FActionAttribute> behaveList)
    {
        if (behaveList == null)
        {
            return null;
        }
        List<FRuleConfig> configList = new ArrayList<FRuleConfig>();
        for (int i = 0; i < behaveList.size(); i++)
        {
            String behaveType = behaveList.get(i).getActionType();
            request.setAttribute("behaveType", behaveType);

            TransData<FRuleConfig> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_RULE_CONFIG, request, FRuleConfig.class);
            FRuleConfig ruleConfig = respObj.getData();
            configList.add(ruleConfig);
        }
        return configList;
    }

    /**
    * 获取字典表数据
    * @param request
    */
    public static void putDictionaryParas(Map<String, Object> root)
    {
        String[] arr = { "publish_status", "user_type", "sex", "idtype", "behave_type", "rule_type", "rule_result_type", "rule_active_type", "info_source", "week_type", "relation_type" };
        for (int i = 0; i < arr.length; i++)
        {
            root.put(arr[i], SysdictionaryCache.get(arr[i]));
        }
    }

}
