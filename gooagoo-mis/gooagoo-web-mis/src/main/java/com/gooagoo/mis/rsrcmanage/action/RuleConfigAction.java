package com.gooagoo.mis.rsrcmanage.action;

import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;
import com.gooagoo.mis.constants.MisInterConstants;
import com.gooagoo.mis.httputil.HttpUtilsMis;
import com.gooagoo.mis.util.MisUtils;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MSysDictionary;
import com.gooagoo.view.mis.enterprise.MRuleConfig;
import com.gooagoo.view.mis.enterprise.MShopInfo;

@Controller
@RequestMapping("/ruleConfig")
public class RuleConfigAction extends BaseAction
{
    /**
     * 商家列表-上方查询
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showIndexShop")
    public String showIndexShop(HttpServletRequest request, HttpServletResponse response)
    {
        this.queryData(request, response);
        return "/rsrcmanage/marketmanage/shop_index";
    }

    /**
     * 商家列表-下方列表
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=queryAllShop")
    public String queryAllShop(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId2", "20501");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "20501");//权限Id
        TransData<PageModel> resObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_PAGE, request, PageModel.class);
        PageModel<MShopInfo> pm = resObj.getData();
        MisLoginInfo info = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (info != null)
        {
            request.setAttribute("mis_login_auths", info.getAuthorities());
            request.setAttribute("misUserId", info.getLoginId());
        }
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        this.queryData(request, response);
        return "/rsrcmanage/marketmanage/shop_content";
    }

    /**
     * 规则配置列表-上方查询
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=showIndex")
    public String showIndex(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        this.queryData(request, response);
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", "").split(",")[0];
        shopId = URLDecoder.decode(shopId, "utf-8");
        request.setAttribute("shopId", shopId.split("\\|")[0]);
        request.setAttribute("shopName", shopId.split("\\|")[1]);
        return "/rsrcmanage/marketmanage/ruleconfig_index";
    }

    /**
     * 规则配置列表-下方列表
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=queryAllConfig")
    public String queryAllConfig(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId2", "2050102");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "2050102");//权限Id
        MisLoginInfo info = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (info != null)
        {
            request.setAttribute("mis_login_auths", info.getAuthorities());
            request.setAttribute("misUserId", info.getLoginId());
        }
        TransData<PageModel> resObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_MARKETING_RULECONFIG_QUERYALL, request, PageModel.class);
        PageModel<MRuleConfig> pm = resObj.getData();
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        this.queryData(request, response);
        return "/rsrcmanage/marketmanage/ruleconfig_content";
    }

    /**
     * 新增规则配置页面
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=addRuleConfigPage")
    public String addRuleConfigPage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        this.queryData(request, response);
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", "").split(",")[0];
        shopId = URLDecoder.decode(shopId, "utf-8");
        request.setAttribute("shopId", shopId.split("\\|")[0]);
        request.setAttribute("shopName", shopId.split("\\|")[1]);
        return "/rsrcmanage/marketmanage/ruleconfig_add";
    }

    /**
     * 新增规则配置
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=addRuleConfig")
    public void addRuleConfig(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2050101");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_MARKETING_RULECONFIG_ADD, request, response);
    }

    /**
     * 查询规则配置详细
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=queryConfig")
    public String queryConfig(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<MRuleConfig> resObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_MARKETING_RULECONFIG_QUERY, request, MRuleConfig.class);
        MRuleConfig rule = resObj.getData();
        request.setAttribute("rule", rule);
        this.queryData(request, response);
        return "/rsrcmanage/marketmanage/ruleconfig_update";
    }

    /**
     * 修改规则配置
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=updateRuleConfig")
    public void updateRuleConfig(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "205010201");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_MARKETING_RULECONFIG_UPDATE, request, response);
    }

    /**
     * 删除规则配置
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=deleteRuleConfig")
    public void deleteRuleConfig(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "205010202");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_MARKETING_RULECONFIG_DELETE, request, response);
    }

    /**
     * 根据规则类型查询所属的规则
     * @param request
     * @param response
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(params = "method=selectBehaveType")
    public void selectBehaveType(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String behaveType = ServletRequestUtils.getStringParameter(request, "behaveType", "");
        MSysDictionary msys = new MSysDictionary();
        msys.setEnglishName(behaveType);
        MisUtils.queryDataCondition(new String[] { "behave_rule" }, msys, MSysDictionary.class, request, response);
        if (request.getAttribute("behave_rule") != null)
        {
            List<MSysDictionary> sysList = (List<MSysDictionary>) request.getAttribute("behave_rule");
            for (MSysDictionary sys : sysList)
            {
                String chinese = sys.getChineseName();
                MSysDictionary msysd = new MSysDictionary();
                msysd.setEnglishName(chinese);
                MisUtils.queryDataAjaxCondition(new String[] { "rule_config_vlaue" }, msysd, MSysDictionary.class, request, response);
            }
        }
    }

    /**
     * 查询通用字典表信息
     * @param request
     * @param response
     * @return
     */
    private void queryData(HttpServletRequest request, HttpServletResponse response)
    {
        MisUtils.queryData(new String[] { "behave_type", "shop_status", "service_style" }, request, response);
    }

}
