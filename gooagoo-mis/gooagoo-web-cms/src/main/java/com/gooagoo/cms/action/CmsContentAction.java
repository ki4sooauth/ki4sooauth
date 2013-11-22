package com.gooagoo.cms.action;

import java.io.IOException;
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
import com.gooagoo.cms.utils.CMSHttpUtils;
import com.gooagoo.cms.utils.CMSUtil;
import com.gooagoo.cms.utils.InterCmsConstants;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooaoo.view.cms.MCmsContent;
import com.gooaoo.view.common.PageModel;
import com.gooaoo.view.common.ZTreeNode;
import com.google.gson.Gson;

@Controller
@RequestMapping("/cmsContent")
public class CmsContentAction extends BaseAction
{
    /**
     * 主页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        String initCode = ServletRequestUtils.getStringParameter(request, "initCode", "");
        request.setAttribute("initCode", initCode);

        String gotoUrl = "";
        // 判断是否需要初始化根结点
        TransData<Boolean> respObj = CMSHttpUtils.transfer(InterCmsConstants.I_CMS_CONTENT_ISINITCHANNEL, request, Boolean.class);
        boolean result = respObj.getData();
        if (respObj.getHead().isSuccess() && result)
        {
            gotoUrl = "/channel/channel_init";
        }
        else
        {
            gotoUrl = "/channel/index";
        }

        return gotoUrl;
    }

    /**
     * 文章列表首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=articleIndex")
    public String articleIndex(HttpServletRequest request, HttpServletResponse response)
    {

        String parentCmsContentId = ServletRequestUtils.getStringParameter(request, "parentCmsContentId", "");
        String cmsContentId = ServletRequestUtils.getStringParameter(request, "cmsContentId", "");
        String channelType = ServletRequestUtils.getStringParameter(request, "channelType", "");

        request.setAttribute("parentCmsContentId", parentCmsContentId);
        request.setAttribute("cmsContentId", cmsContentId);
        request.setAttribute("channelType", channelType);

        this.getDictionary(request);

        return "/article/index";
    }

    /**
     * 初始化根节点
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=initRoot")
    public void initRoot(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        CMSUtil.ajaxSubmit(InterCmsConstants.I_CMS_CONTENT_INITROOT, request, response);
    }

    /**
     * 添加cms内容信息页面（栏目）
     * @param request
     * @param rewResponse
     * @return
     */
    @RequestMapping(params = "method=formA")
    public String formA(HttpServletRequest request, HttpServletResponse rewResponse)
    {
        String cmsContentType = ServletRequestUtils.getStringParameter(request, "cmsContentType", "");
        String parentCmsContentId = ServletRequestUtils.getStringParameter(request, "parentCmsContentId", "");

        String gotoUrl = "";

        request.setAttribute("parentCmsContentId", parentCmsContentId);

        if ("C".equals(cmsContentType))
        {
            gotoUrl = "channel/channel_edit";
            GooagooLog.debug("添加栏目信息，跳转至channel/channel_edit");
        }
        else
        {
            gotoUrl = "article/article_edit";
            GooagooLog.debug("添加文章信息，跳转至article/article_edit");
        }

        return gotoUrl;
    }

    /**
     * 添加cms内容信息
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        CMSUtil.ajaxSubmit(InterCmsConstants.I_CMS_CONTENT_ADD, request, response);
    }

    /**
     * 删除cms内容信息
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        CMSUtil.ajaxSubmit(InterCmsConstants.I_CMS_CONTENT_DELETE, request, response);
    }

    /**
     * 修改cms内容信息页面（栏目）
     * @param request
     * @param rewResponse
     * @return
     */
    @RequestMapping(params = "method=formU")
    public String formU(HttpServletRequest request, HttpServletResponse rewResponse)
    {
        String cmsContentId = ServletRequestUtils.getStringParameter(request, "cmsContentId", "");
        String parentCmsContentId = ServletRequestUtils.getStringParameter(request, "parentCmsContentId", "");
        String cmsContentType = ServletRequestUtils.getStringParameter(request, "cmsContentType", "");

        MCmsContent cmsContent = null;
        String gotoUrl = "";

        if (StringUtils.hasText(cmsContentId))
        {
            TransData<MCmsContent> respObj = CMSHttpUtils.transfer(InterCmsConstants.I_CMS_CONTENT_DETAIL, request, MCmsContent.class);
            cmsContent = respObj.getData();
        }

        if ("C".equals(cmsContentType))
        {
            gotoUrl = "channel/channel_edit";
            GooagooLog.debug("修改栏目信息，跳转至channel/channel_edit");
        }
        else
        {
            gotoUrl = "article/article_edit";
            GooagooLog.debug("修改文章信息，跳转至article/article_edit");
        }

        request.setAttribute("cmsContent", cmsContent);
        request.setAttribute("parentCmsContentId", parentCmsContentId);

        return gotoUrl;
    }

    /**
     * 修改cms内容信息
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=update")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        CMSUtil.ajaxSubmit(InterCmsConstants.I_CMS_CONTENT_UPDATE, request, response);
    }

    /**
     * cms内容信息列表（分页）
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=page")
    public String page(HttpServletRequest request, HttpServletResponse response)
    {
        String cmsContentType = ServletRequestUtils.getStringParameter(request, "cmsContentType", "");

        TransData<PageModel> respObj = CMSHttpUtils.transfer(InterCmsConstants.I_CMS_CONTENT_PAGE, request, PageModel.class);
        PageModel<MCmsContent> pm = respObj.getData();

        this.getDictionary(request);

        String gotoUrl = "";

        if ("C".equals(cmsContentType))
        {
            gotoUrl = "channel/channel_list";
            GooagooLog.debug("栏目信息列表，跳转至channel/channel_list");
        }
        else
        {
            gotoUrl = "article/article_list";
            GooagooLog.debug("文章信息列表，跳转至article/article_list");
        }

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }

        return gotoUrl;
    }

    /**
     * cms内容信息列表（不分页）
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=list")
    public void list(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String selectId = ServletRequestUtils.getStringParameter(request, "cmsContentId", "");
        request.setAttribute("selectId", selectId);

        TransData<List> respObj = CMSHttpUtils.transfer(InterCmsConstants.I_CMS_CONTENT_LIST, request, List.class);
        List<ZTreeNode> cmsContentList = respObj.getData();

        String json = new Gson().toJson(cmsContentList);
        ServletUtils.writeHtml(json, response);
    }

    /**
     * cms内容详细信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=getCmsContent")
    public String getCmsContent(HttpServletRequest request, HttpServletResponse response)
    {
        String cmsContentId = ServletRequestUtils.getStringParameter(request, "cmsContentId", "");
        String cmsContentType = ServletRequestUtils.getStringParameter(request, "cmsContentType", "");
        String isAllowDel = ServletRequestUtils.getStringParameter(request, "isAllowDel", "");

        this.getDictionary(request);

        MCmsContent cmsContent = null;
        String gotoUrl = "";

        if (StringUtils.hasText(cmsContentId))
        {
            TransData<MCmsContent> respObj = CMSHttpUtils.transfer(InterCmsConstants.I_CMS_CONTENT_DETAIL, request, MCmsContent.class);
            cmsContent = respObj.getData();
        }

        if ("C".equals(cmsContentType))
        {
            gotoUrl = "channel/channel_detail";
            GooagooLog.debug("栏目详细信息，跳转至channel/channel_detail");
        }
        else
        {
            gotoUrl = "article/article_detail";
            GooagooLog.debug("文章详细信息，跳转至article/article_detail");
        }

        request.setAttribute("isAllowDel", isAllowDel);
        request.setAttribute("cmsContent", cmsContent);
        return gotoUrl;
    }

    /**
     * 审核cms内容信息页面
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=checkForm")
    public String checkForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String cmsContentId = ServletRequestUtils.getStringParameter(request, "cmsContentId", "");
        String cmsContentType = ServletRequestUtils.getStringParameter(request, "cmsContentType", "");

        request.setAttribute("cmsContentId", cmsContentId);
        String gotoUrl = "";
        if ("C".equals(cmsContentType))
        {
            gotoUrl = "channel/channel_check";
            GooagooLog.debug("审核栏目，跳转至channel/channel_check");
        }
        else
        {
            gotoUrl = "article/article_check";
            GooagooLog.debug("审核文章，跳转至article/article_check");
        }

        return gotoUrl;
    }

    /**
    * 审核cms内容信息
    * @param request
    * @param response
    * @throws Exception 
    */
    @RequestMapping(params = "method=check")
    public void check(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        CMSUtil.ajaxSubmit(InterCmsConstants.I_CMS_CONTENT_CHECK, request, response);
    }

    /**
     * 发布cms内容信息
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=relese")
    public void relese(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        CMSUtil.ajaxSubmit(InterCmsConstants.I_CMS_CONTENT_RELESE, request, response);
    }

    /**
     * 发布cms内容信息
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=releseAll")
    public void releseAll(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        CMSUtil.ajaxSubmit(InterCmsConstants.I_CMS_CONTENT_RELESEALL, request, response);
    }

    private void getDictionary(HttpServletRequest request)
    {
        // 取状态值
        Map<String, String> map = new TreeMap<String, String>();
        map.putAll(SysdictionaryCache.get("publish_status"));
        request.setAttribute("publish_status", map);
    }

    /**
     * 栏目排序
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=sort")
    public void sort(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //TODO
    }
}