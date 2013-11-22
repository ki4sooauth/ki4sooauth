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
import com.gooagoo.view.mis.dictionaryManage.MInterfaceBaseInfo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/interBase")
public class InterfaceBaseDictionaryAction extends BaseAction
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
        return "/sysmanage/dictionary/create/interfaceBase_add";
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
        request.setAttribute("moduleId", "10411");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_ADD_INTERBASE, request, response);
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
        request.setAttribute("moduleId", "10411");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_DEL_INTERBASE, request, response);
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
        TransData<MInterfaceBaseInfo> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_INTERBASE_DETAIL, request, MInterfaceBaseInfo.class);
        MInterfaceBaseInfo interBase = respObj.getData();
        request.setAttribute("interBase", interBase);
        return "/sysmanage/dictionary/update/interfaceBase_update";
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
        request.setAttribute("moduleId", "1041102");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_EDIT_INTERBASE, request, response);
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
        return "/sysmanage/dictionary/search/interfaceBase_index";
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
        request.setAttribute("parentId2", "10411");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "10411");//权限Id
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_INTERBASEINFO, request, PageModel.class);
        PageModel<MInterfaceBaseInfo> pm = respObj.getData();
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
        return "/sysmanage/dictionary/search/interfaceBase_content";
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
            request.setAttribute("moduleId", "1041104");//权限Id
            String[] attributeName = { "iCode", "iName", "iType", "iFunction", "iUrl", "behaveType", "canAllocate", "dataXml", "dataJson", "note", "isDel", "createTime", "cTimeStamp" };
            List<Map<String, String>> excelInfo = MisReportOperateUtils.reportImport(request, "filename", attributeName);
            List<MInterfaceBaseInfo> sysList = new ArrayList<MInterfaceBaseInfo>();
            for (Map<String, String> map : excelInfo)
            {
                MInterfaceBaseInfo sys = (MInterfaceBaseInfo) MisUtils.converObject(map, new MInterfaceBaseInfo());
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
            MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_IMPORT_INERBASE, request, response);
        }
        catch (Exception e)
        {
            new GooagooException("接口基础信息表导入Excel失败");
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
            request.setAttribute("moduleId", "1041105");//权限Id
            TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_INTERBASEINFO, request, PageModel.class);
            PageModel<MInterfaceBaseInfo> pm = respObj.getData();
            List<MInterfaceBaseInfo> sysList = pm.getResult();
            String[] head = { "接口编码", "接口名称", "接口类型", "功能分类", "接口地址", "行为类型", "是否可分配", "报文示例（XMl）URL", "报文示例（JSON）URL", "业务逻辑说明URL", "是否删除", "创建时间", "修改时间" };
            MisReportOperateUtils.reportExport(request, response, sysList, head, "接口基础信息表", "interface_base_info");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            new GooagooException("接口基础信息表导出Excel失败");
        }
    }
}
