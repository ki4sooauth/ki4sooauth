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
import com.gooagoo.view.mis.dictionaryManage.MMarketingChannel;
import com.google.gson.Gson;

@Controller
@RequestMapping("/market")
public class MarketingDictionaryAction extends BaseAction
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
        return "/sysmanage/dictionary/create/marketing_add";
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
        request.setAttribute("moduleId", "10406");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_ADD_MARK, request, response);
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
        request.setAttribute("moduleId", "10406");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_DEL_MARK, request, response);
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
        request.setAttribute("moduleId", "1040602");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_EDIT_MARK, request, response);
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
        TransData<MMarketingChannel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_MARKETING_DETAIL, request, MMarketingChannel.class);
        MMarketingChannel marketing = respObj.getData();
        request.setAttribute("marketing", marketing);
        return "/sysmanage/dictionary/update/marketing_update";
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
        return "/sysmanage/dictionary/search/marketing_index";
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
        request.setAttribute("parentId2", "10406");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "10406");//权限Id
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_MARKETINGINFO, request, PageModel.class);
        PageModel<MMarketingChannel> pm = respObj.getData();

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
        return "/sysmanage/dictionary/search/marketing_content";
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
            request.setAttribute("moduleId", "1040604");//权限Id
            String[] attributeName = { "channelCode", "channelName", "parentChannelCode", "sortOrder", "isDel", "createTime", "cTimeStamp" };
            List<Map<String, String>> excelInfo = MisReportOperateUtils.reportImport(request, "filename", attributeName);
            List<MMarketingChannel> sysList = new ArrayList<MMarketingChannel>();
            for (Map<String, String> map : excelInfo)
            {
                MMarketingChannel sys = (MMarketingChannel) MisUtils.converObject(map, new MMarketingChannel());
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
            MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_IMPORT_MARK, request, response);
        }
        catch (Exception e)
        {
            new GooagooException("营销渠道字典表导入Excel失败");
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
            request.setAttribute("moduleId", "1040605");//权限Id
            TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_MARKETINGINFO, request, PageModel.class);
            PageModel<MMarketingChannel> pm = respObj.getData();
            List<MMarketingChannel> sysList = pm.getResult();
            String[] head = { "营销渠道编码", "营销渠道名称", "父级编码", "排序号", "是否删除", "创建时间", "修改时间" };
            MisReportOperateUtils.reportExport(request, response, sysList, head, "营销渠道字典表", "marketing_channel");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            new GooagooException("营销渠道字典表导出Excel失败");
        }
    }
}
