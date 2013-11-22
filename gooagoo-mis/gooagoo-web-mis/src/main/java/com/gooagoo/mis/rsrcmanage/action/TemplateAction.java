package com.gooagoo.mis.rsrcmanage.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;
import com.gooagoo.mis.constants.MisInterConstants;
import com.gooagoo.mis.httputil.HttpUtilsMis;
import com.gooagoo.mis.util.MisUtils;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.MTemplate;
import com.gooagoo.view.mis.channelManage.MChannel;

@Controller
@RequestMapping("/template")
public class TemplateAction extends BaseAction
{
    /**
     * 主页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showmain")
    public String showmain(HttpServletRequest request, HttpServletResponse response)
    {
        return "/rsrcmanage/main";
    }

    /**
     * 左侧面板页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=leftPanel")
    public String leftPanel(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId", "2");//菜单权限
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("mis_login_id", MMisLoginInfo.getLoginId());
        }
        return "/rsrcmanage/leftPanel";
    }

    /**
     * 展示模板首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showIndex")
    public String showIndex(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        session.setAttribute("parentId2", "20102");//菜单权限

        request.setAttribute("pageCIndex", request.getParameter("pageCIndex"));

        return "/rsrcmanage/template/search/index";
    }

    /**
     * 查询模板列表(分页)
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=searchTemplate")
    public String searchTemplate(HttpServletRequest request, HttpServletResponse response)
    {
        //记录日志
        request.setAttribute("parentId2", "20102");
        request.setAttribute("moduleId", "20102");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("misUserId", MMisLoginInfo.getLoginId());
        }
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_TEMPLATE_PAGE, request, PageModel.class);
        PageModel<MTemplate> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }

        TransData<List> respObj2 = HttpUtilsMis.transferMis(MisInterConstants.MIS_CHANNEL_SEARCHALL_TOP, request, List.class);
        List<MChannel> channelList = respObj2.getData();

        request.setAttribute("channelList", channelList);

        return "/rsrcmanage/template/search/content";
    }

    /**
     * 商家接口信息编辑页
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=formEdit")
    public String formEdit(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<MTemplate> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_TEMPLATE_DETAIL, request, MTemplate.class);
        MTemplate vo = respObj.getData();

        request.setAttribute("vo", vo);
        HttpSession session = request.getSession();
        session.setAttribute("templateContOutput", vo.getTemplateContOutput());

        TransData<List> respObj2 = HttpUtilsMis.transferMis(MisInterConstants.MIS_CHANNEL_SEARCHALL_TOP, request, List.class);
        List<MChannel> channelList = respObj2.getData();

        request.setAttribute("channelList", channelList);

        return "/rsrcmanage/template/update/formEdit";
    }

    /**
     * 修改
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=updateTemplate")
    public void updateTemplate(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //记录日志
        request.setAttribute("moduleId", "2010201");//权限Id
        request.setAttribute("moduleType", "mis");//模块

        /*
        System.out.println(request.getParameter("templateId"));
        HttpSession session = request.getSession();
        request.setAttribute("templateContInput", session.getAttribute("templateContInput"));
        request.setAttribute("templateContOutput", session.getAttribute("templateContOutput"));
        */
        MisUtils.ajaxSubmit(MisInterConstants.MIS_TEMPLATE_UPD, request, response);
    }

    /**
     * 删除
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=delTemplete")
    public void delTemplete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //记录日志
        request.setAttribute("moduleId", "2010202");//权限Id
        request.setAttribute("moduleType", "mis");//模块

        MisUtils.ajaxSubmit(MisInterConstants.MIS_TEMPLATE_DEL, request, response);
    }

    /**
     * 预览模板
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException 
     */
    @RequestMapping(params = "method=previewTemplate")
    public String previewTemplate(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
    {
        String type = request.getParameter("type") == null ? "" : request.getParameter("type");

        if (type.equals("1"))
        {
            TransData<MTemplate> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_TEMPLATE_DETAIL, request, MTemplate.class);
            MTemplate vo = respObj.getData();
            request.setAttribute("initData", vo.getInitData());
            request.setAttribute("templateContOutput", vo.getTemplateContOutput());
        }
        else
        {
            request.setAttribute("initData", URLDecoder.decode(request.getParameter("initData"), "UTF-8"));
        }

        return "/rsrcmanage/template/search/templateView";
    }

    /**
     * 新增模板--第1页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addTemplateIndex")
    public String addTemplateIndex(HttpServletRequest request, HttpServletResponse response)
    {
        return "/rsrcmanage/template/add/index";
    }

    /**
     * 新增模板--第2页
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(params = "method=uploadTemplateFile")
    public String uploadTemplateFile(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        HttpSession session = request.getSession();
        InputStreamReader isr = null;
        BufferedReader br = null;
        String line = null;
        StringBuffer strBuffer = null;
        try
        {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            multipartRequest.setCharacterEncoding("UTF-8");
            Iterator<String> fileNames = multipartRequest.getFileNames();
            while (fileNames.hasNext())
            {
                String fileName = fileNames.next();
                List<MultipartFile> files = multipartRequest.getFiles(fileName);
                for (MultipartFile file : files)
                {
                    isr = new InputStreamReader(file.getInputStream(), "UTF-8");
                    br = new BufferedReader(isr);
                    strBuffer = new StringBuffer();
                    while ((line = br.readLine()) != null)
                    {
                        strBuffer.append(line);
                    }
                }
                if (fileName.equals("templateContInput"))
                {
                    session.setAttribute("templateContInput", strBuffer.toString());
                }
                else if (fileName.equals("templateContOutput"))
                {
                    session.setAttribute("templateContOutput", strBuffer.toString());
                }
            }

            TransData<List> respObj2 = HttpUtilsMis.transferMis(MisInterConstants.MIS_CHANNEL_SEARCHALL_TOP, request, List.class);
            List<MChannel> channelList = respObj2.getData();

            request.setAttribute("channelList", channelList);
        }
        catch (Exception e)
        {
            throw new Exception(e);
        }
        finally
        {
            strBuffer = null;
            line = null;
            br = null;
            isr = null;
        }

        return "/rsrcmanage/template/add/customTemplate";
    }

    /**
     * 新增模板--完成页
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=addTemplate")
    public void addTemplate(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //记录日志
        request.setAttribute("moduleId", "20101");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        HttpSession session = request.getSession();
        request.setAttribute("templateContInput", session.getAttribute("templateContInput"));
        request.setAttribute("templateContOutput", session.getAttribute("templateContOutput"));

        MisUtils.ajaxSubmit(MisInterConstants.MIS_TEMPLATE_ADD, request, response);

    }

}
