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
import com.gooagoo.view.mis.dictionaryManage.MShopInterfaceName;
import com.google.gson.Gson;

@Controller
@RequestMapping("/shopInter")
public class ShopInterfaceDictionaryAction extends BaseAction
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
        return "/sysmanage/dictionary/create/shopInterface_add";
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
        request.setAttribute("moduleId", "10410");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_ADD_SHOPIN, request, response);
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
        request.setAttribute("moduleId", "10410");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_DEL_SHOPIN, request, response);
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
        TransData<MShopInterfaceName> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_SHOPIN_DETAIL, request, MShopInterfaceName.class);
        MShopInterfaceName shopIn = respObj.getData();
        request.setAttribute("shopIn", shopIn);
        return "/sysmanage/dictionary/update/shopInterface_update";
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
        request.setAttribute("moduleId", "1041002");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_EDIT_SHOPIN, request, response);
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
        return "/sysmanage/dictionary/search/shopInterface_index";
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
        request.setAttribute("parentId2", "10410");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "10410");//权限Id
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_SHOPININFO, request, PageModel.class);
        PageModel<MShopInterfaceName> pm = respObj.getData();
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
        return "/sysmanage/dictionary/search/shopInterface_content";
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
            request.setAttribute("moduleId", "1041004");//权限Id
            String[] attributeName = { "id", "nameCode", "nameValue", "sys", "module", "note", "version", "versionNote", "isDel", "createTime", "cTimeStamp" };
            List<Map<String, String>> excelInfo = MisReportOperateUtils.reportImport(request, "filename", attributeName);
            List<MShopInterfaceName> sysList = new ArrayList<MShopInterfaceName>();
            for (Map<String, String> map : excelInfo)
            {
                MShopInterfaceName sys = (MShopInterfaceName) MisUtils.converObject(map, new MShopInterfaceName());
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
            MisUtils.ajaxSubmit(MisInterConstants.MIS_DIC_IMPORT_SHOPIN, request, response);
        }
        catch (Exception e)
        {
            new GooagooException("商家平台界面名称管理表导入Excel失败");
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
            request.setAttribute("moduleId", "1041005");//权限Id
            TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_DIC_SHOPININFO, request, PageModel.class);
            PageModel<MShopInterfaceName> pm = respObj.getData();
            List<MShopInterfaceName> sysList = pm.getResult();
            String[] head = { "编号", "名称编码", "名称值", "所属系统", "所属模块", "备注", "版本号", "版本号说明", "是否删除", "创建时间", "修改时间" };
            MisReportOperateUtils.reportExport(request, response, sysList, head, "商家平台界面名称管理表", "shop_interface_name");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            new GooagooException("商家平台界面名称管理表导出Excel失败");
        }
    }
}
