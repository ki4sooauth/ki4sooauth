package com.gooagoo.gmarketing.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.freemarker.UserSearchFtlUtil;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.view.gms.account.UserView;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.member.FMemberCard;
import com.gooagoo.view.gms.rule.FActionAttribute;
import com.gooagoo.view.gms.rule.FRule;
import com.gooagoo.view.gms.rule.FRuleCondition;
import com.gooagoo.view.gms.rule.FRuleConfig;
import com.gooagoo.view.gms.rule.FRuleInfo;
import com.google.gson.Gson;

/**
 * 营销规则管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/rule")
public class RuleAction extends BaseAction
{

    /**
     * 查看详细
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=detail")
    public String detail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String activityName = ServletRequestUtils.getStringParameter(request, "activityName", "");
        FRule rule = new FRule();
        FRuleCondition condition = new FRuleCondition();

        TransData<FRule> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_RULE_DETAIL, request, FRule.class);
        rule = respObj.getData();
        condition = new Gson().fromJson(rule.getRuleInfo().getRuleContent(), FRuleCondition.class);

        this.getSysdictionary(request);
        request.setAttribute("activityName", activityName);
        request.setAttribute("rule", rule);
        request.setAttribute("condition", condition);
        request.setAttribute("detailType", "release");
        return "/rule/rule_detail";
    }

    /**
     * 查询规则配置信息
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=ruleConfig")
    public void ruleConfig(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Gson gson = new Gson();
        String json = null;
        TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_RULE_CONFIG, request, List.class);
        List<FRuleConfig> ruleConfigList = respObj.getData();
        if (ruleConfigList != null)
        {
            json = gson.toJson(ruleConfigList);
        }
        ServletUtils.writeHtml(json, response);
    }

    /**
     * 根据行为查询商家规则配置信息
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=getRuleConfig")
    public void getRuleConfig(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String conditionType = ServletRequestUtils.getStringParameter(request, "conditionType", "");
        String behaveType = ServletRequestUtils.getStringParameter(request, "behaveType", "");

        FActionAttribute action = new FActionAttribute();
        action.setActionType(behaveType);
        List<FActionAttribute> behaveList = new ArrayList<FActionAttribute>();
        behaveList.add(action);

        String content = UserSearchFtlUtil.getBehaveConditionContent(request, conditionType, behaveList);

        ServletUtils.writeHtml(content, response);
    }

    /**
     * 卡列表
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=getCard")
    public void getCard(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMEBER_PAGE, request, List.class);
        List<FMemberCard> cardList = respObj.getData();
        String result = new Gson().toJson(cardList);
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 根据历史条件查用户账户总数
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(params = "method=userAccountCount")
    public void userAccountCount(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Gson gson = new Gson();
        String json = null;
        TransData<Integer> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_USERRECORD_GET_GET_USERACCOUNT_COUNT, request, Integer.class);
        Integer count = respObj.getData();
        json = gson.toJson(count);
        ServletUtils.writeHtml(json, response);
    }

    /**
     * 根据历史条件查用户账户列表信息首页
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(params = "method=userAccountIndex")
    public String userAccountIndex(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        return "/rule/userAccount_index";
    }

    /**
     * 根据历史条件查用户账户列表信息首页 
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(params = "method=pageUserAccount")
    public String pageUserAccount(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<PageModel> userRecorddTransData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_USERRECORD_SIFT, request, PageModel.class);
        PageModel<UserView> pm = userRecorddTransData.getData();
        GooagooLog.debug("根据历史条件查用户账户信息列表 pm：" + pm);

        if (pm != null)
        {
            Map<String, String> map = SysdictionaryCache.get("user_type");
            request.setAttribute("userTypes", map);
            request.setAttribute("pageModel", pm);
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }

        return "/rule/userAccount_list";
    }

    /**
     * 规则列表（弹出层）
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=ruleList")
    public String ruleList(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String ruleName = ServletRequestUtils.getStringParameter(request, "ruleName", "");
        String contentId = ServletRequestUtils.getStringParameter(request, "contentId", "");
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");
        request.setAttribute("ruleName", ruleName);
        request.setAttribute("contentId", contentId);
        request.setAttribute("channelCode", channelCode);

        this.getSysdictionary(request);

        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_RULE_PAGE, request, PageModel.class);
        PageModel<FRuleInfo> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }

        return "/rule/rule_List_Pupop";
    }

    /**
     * 拷贝已有规则信息修改
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=copyGroup")
    public void copyGroup(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String ruleId = ServletRequestUtils.getStringParameter(request, "ruleId", "");

        FRule rule = new FRule();
        FRuleCondition condition = new FRuleCondition();
        if (StringUtils.hasText(ruleId))
        {
            TransData<FRule> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_RULE_DETAIL, request, FRule.class);
            rule = respObj.getData();
            condition = new Gson().fromJson(rule.getRuleInfo().getRuleContent(), FRuleCondition.class);
        }
        String ruleCondition = UserSearchFtlUtil.getRuleConditionContent(request, condition, rule.getRuleInfo());
        if (ruleCondition == null)
        {
            GooagooLog.warn("发布条件通过模板生成文件失败:rule=" + new Gson().toJson(rule));
            throw new GooagooException("系统异常");
        }
        ServletUtils.writeHtml(ruleCondition, response);
    }

    /**
     * 获取字典表数据
     * @param request
     */
    public void getSysdictionary(HttpServletRequest request)
    {
        String[] arr = { "publish_status", "user_type", "sex", "idtype", "behave_type", "rule_type", "rule_result_type", "rule_active_type", "info_source", "week_type", "relation_type" };
        for (int i = 0; i < arr.length; i++)
        {
            Map<String, String> map = new TreeMap<String, String>();
            map.putAll(SysdictionaryCache.get(arr[i]));
            request.setAttribute(arr[i], map);
        }
    }
}