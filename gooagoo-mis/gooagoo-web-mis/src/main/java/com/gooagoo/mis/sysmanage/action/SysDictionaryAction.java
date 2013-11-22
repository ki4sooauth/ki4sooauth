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
import com.gooagoo.view.mis.dictionaryManage.MSysDictionary;
import com.google.gson.Gson;

@Controller
@RequestMapping("/sysdict")
public class SysDictionaryAction extends BaseAction
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
        return "/sysmanage/dictionary/create/sysDict_add";
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
        request.setAttribute("moduleId", "10401");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_ADD, request, response);
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
        request.setAttribute("moduleId", "10401");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_DEL, request, response);
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
        request.setAttribute("moduleId", "1040201");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_EDIT, request, response);
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
        TransData<MSysDictionary> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_DETAIL, request, MSysDictionary.class);
        MSysDictionary sysDictionary = respObj.getData();
        request.setAttribute("dic", sysDictionary);
        return "/sysmanage/dictionary/update/sysDict_update";
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
        return "/sysmanage/dictionary/search/sysDict_index";
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
        request.setAttribute("parentId2", "10401");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "10401");//权限Id
        List<String> strList = new ArrayList<String>();
        strList.add("23");
        request.setAttribute("list", new Gson().toJson(strList));
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_ALLINFO, request, PageModel.class);
        PageModel<MSysDictionary> pm = respObj.getData();
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
        return "/sysmanage/dictionary/search/sysDict_content";
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
            request.setAttribute("moduleId", "1040104");//权限Id
            String[] attributeName = { "sysDictionaryId", "dictionaryType", "dictionaryName", "englishName", "chineseName", "note", "isDel", "createTime", "cTimeStamp" };
            List<Map<String, String>> excelInfo = MisReportOperateUtils.reportImport(request, "filename", attributeName);
            List<MSysDictionary> sysList = new ArrayList<MSysDictionary>();
            for (Map<String, String> map : excelInfo)
            {
                MSysDictionary sys = (MSysDictionary) MisUtils.converObject(map, new MSysDictionary());
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
            MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_IMPORT, request, response);
        }
        catch (Exception e)
        {
            new GooagooException("通用字典表导入Excel失败");
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
            request.setAttribute("moduleId", "1040105");//权限Id
            TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_ALLINFO, request, PageModel.class);
            PageModel<MSysDictionary> pm = respObj.getData();
            List<MSysDictionary> sysList = pm.getResult();
            String[] head = { "编号", "字典类型编码", "字典类型名称", "英文名称", "中文名称", "备注", "是否删除", "创建时间", "修改时间" };
            MisReportOperateUtils.reportExport(request, response, sysList, head, "通用字典表", "sys_dictionary");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            new GooagooException("通用字典表导出Excel失败");
        }
    }

}
