package com.gooagoo.template.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.mis.util.TemplateUtils;
import com.gooagoo.template.constants.InterTplConstants;
import com.gooagoo.template.entity.FTemplateInfo;
import com.gooagoo.template.entity.PageModel;
import com.gooagoo.template.utils.AjaxUtils;

@Controller
@RequestMapping("/login")
public class LoginAction
{
    /**
     * 模版列表查询域
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=login")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TemplateUtils.queryData(request, response);
        request.setAttribute("tem_phone", "501");
        request.setAttribute("tem_web", "502");
        request.setAttribute("tem_list", "506");
        TemplateUtils.queryLoginAuths(request, response);
        return "/index";
    }

    /**
     * 模版列表
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=list")
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<PageModel> respObj = AjaxUtils.httpClientRequest(InterTplConstants.I_TEMPLATE_LIST, request, PageModel.class);
        PageModel<FTemplateInfo> pm = respObj.getData();
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));

        }
        TemplateUtils.queryData(request, response);
        request.setAttribute("tem_quote", "503");
        request.setAttribute("tem_update", "504");
        request.setAttribute("tem_delete", "505");
        TemplateUtils.queryLoginAuths(request, response);
        return "/template_list";
    }

    /**
     * 添加模板
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        AjaxUtils.ajaxSubmit(InterTplConstants.I_TEMPLATE_ADD, request, response);
    }

    /**
     * 修改模板
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=update")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        AjaxUtils.ajaxSubmit(InterTplConstants.I_TEMPLATE_UPDATE, request, response);
    }

    /**
     * 删除模板
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        AjaxUtils.ajaxSubmit(InterTplConstants.I_TEMPLATE_DELETE, request, response);
    }

    /**
     * 进入模板编辑页(获取当前一条模板信息)
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public void init(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String temp_id = ServletRequestUtils.getStringParameter(request, "temp_id", "");
        String template_type = ServletRequestUtils.getStringParameter(request, "template_type", "");
        FTemplateInfo info = null;
        if (StringUtils.hasText(temp_id))
        {
            TransData<FTemplateInfo> respObj = AjaxUtils.httpClientRequest(InterTplConstants.I_GET_TEMPLATE_INFO, request, FTemplateInfo.class);
            info = respObj.getData();
        }
        request.setAttribute("info", info);
        request.setAttribute("temp_id", temp_id);
        request.setAttribute("template_type", template_type);
        TemplateUtils.initForm(info, request);
    }

    /**
     * （新增手机）模板编辑页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=addMForm")
    public String addMForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TemplateUtils.initForm(null, request);
        String template_type = ServletRequestUtils.getStringParameter(request, "template_type", "");
        request.setAttribute("template_type", template_type);
        return "/edit";
    }

    /**
     * （新增网站）模板编辑页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=addWForm")
    public String addWForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TemplateUtils.initForm(null, request);
        String template_type = ServletRequestUtils.getStringParameter(request, "template_type", "");
        request.setAttribute("template_type", template_type);
        return "/edit";
    }

    /**
     * 修改时进入模板编辑页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=editForm")
    public String editForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //操作类型（y:引用、u:修改）
        String type = ServletRequestUtils.getStringParameter(request, "type", "");
        this.init(request, response);
        request.setAttribute("type", type);
        return "/edit";
    }

    /**
     * 引用时进入模板编辑页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=citeForm")
    public String citeForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //操作类型（y:引用、u:修改）
        String type = ServletRequestUtils.getStringParameter(request, "type", "");
        this.init(request, response);
        request.setAttribute("type", type);
        return "/edit";
    }

}
