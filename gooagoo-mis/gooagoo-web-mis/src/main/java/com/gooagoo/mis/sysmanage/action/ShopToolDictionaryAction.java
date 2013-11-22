package com.gooagoo.mis.sysmanage.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.mis.constants.MisInterConstants;
import com.gooagoo.mis.httputil.HttpUtilsMis;
import com.gooagoo.mis.util.MisReportOperateUtils;
import com.gooagoo.mis.util.MisUtils;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MShopToolInfo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/shopTool")
public class ShopToolDictionaryAction extends BaseAction
{
    /**
     * 显示字典添加页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showDicAdd")
    public String showDicAdd(HttpServletRequest request, HttpServletResponse response)
    {
        return "/sysmanage/dictionary/create/shopTool_add";
    }

    /**
     * 新增字典信息
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=addDict")
    public void addDict(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "10405");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_ADD_SHOPTO, request, response);
    }

    /**
     * 删除字典信息
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=delDict")
    public void delDict(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "10405");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_DEL_SHOPTO, request, response);
    }

    /**
     * 编辑字典信息
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=editDict")
    public void editDict(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "1040502");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_EDIT_SHOPTO, request, response);
    }

    /**
     * 显示字典编辑页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showDicEdit")
    public String showDicEdit(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<MShopToolInfo> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_SHOPTOOL_DETAIL, request, MShopToolInfo.class);
        MShopToolInfo shopTool = respObj.getData();
        request.setAttribute("shopTool", shopTool);
        return "/sysmanage/dictionary/update/shopTool_update";
    }

    /**
     * 显示字典列表-上方查询页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showDicList")
    public String showDicList(HttpServletRequest request, HttpServletResponse response)
    {
        MisUtils.queryData(new String[]{"tool_type"}, request, response);
        return "/sysmanage/dictionary/search/shopTool_index";
    }

    /**
     * 字典列表内容-下方列表页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=showDictListContent")
    public String showDictListContent(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId2", "10405");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "10405");//权限Id
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_SHOPTOOLINFO, request, PageModel.class);
        PageModel<MShopToolInfo> pm = respObj.getData();
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("misUserId", MMisLoginInfo.getLoginId());
        }
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        MisUtils.queryData(new String[]{"tool_type"}, request, response);
        return "/sysmanage/dictionary/search/shopTool_content";
    }

    /**
     * 导入Excel
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=importExcel")
    public void importExcel(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            request.setAttribute("moduleId", "1040504");//权限Id
            String[] attributeName = { "toolId", "toolName", "toolUrl", "toolIcoFocus", "toolIcoUnfocus", "toolType", "localCmd", "ver", "remark", "isDel", "createTime", "cTimeStamp" };
            List<Map<String, String>> excelInfo = MisReportOperateUtils.reportImport(request, "filename", attributeName);
            List<MShopToolInfo> sysList = new ArrayList<MShopToolInfo>();
            for (Map<String, String> map : excelInfo)
            {
                MShopToolInfo sys = (MShopToolInfo) MisUtils.converObject(map, new MShopToolInfo());
                if (sys != null)
                {
                    sysList.add(sys);
                }
            }
            if (sysList == null || sysList.size() <= 0)
            {
                GooagooLog.warn("上传文件内容为空");
            }
            String dictList = new Gson().toJson(sysList);
            request.setAttribute("dictList", dictList);
            MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_IMPORT_SHOPTO, request, response);
        }
        catch (Exception e)
        {
            new GooagooException("商家服务工具字典表导入Excel失败");
        }
    }

    /**
     * 导出Excel
     * @param request
     * @param response
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=exportExcel")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            request.setAttribute("moduleId", "1040505");//权限Id
            TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_SHOPTOOLINFO, request, PageModel.class);
            PageModel<MShopToolInfo> pm = respObj.getData();
            List<MShopToolInfo> sysList = pm.getResult();
            String[] head = { "服务工具编号", "服务工具名称", "工具介绍URL", "工具图标（选中）", "工具图标（非选中状态）", "服务工具类型", "手机本地命令", "版本", "备注", "是否删除", "创建时间", "修改时间" };
            MisReportOperateUtils.reportExport(request, response, sysList, head, "商家服务工具字典表", "shop_tool_info");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            new GooagooException("商家服务工具字典表导出Excel失败");
        }
    }
}
