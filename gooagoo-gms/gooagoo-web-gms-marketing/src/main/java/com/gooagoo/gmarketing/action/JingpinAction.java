package com.gooagoo.gmarketing.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.good.FGoodsMarketing;
import com.gooagoo.view.gms.marketing.FJingpin;
import com.gooagoo.view.gms.marketing.FJingpinType;

/**
 * 精品
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/jingpin")
public class JingpinAction extends BaseAction
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
        return "jingpin/index";
    }

    /**
     * 列表
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=list")
    public String list(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_JINGPIN_PAGE, request, PageModel.class);
        PageModel<FJingpin> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));

        }
        return "jingpin/jingpin_list";
    }

    /**
     * 添加页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=addform")
    public String addform(HttpServletRequest request, HttpServletResponse response)
    {
        getFormDetail(request, response);
        return "jingpin/jingpin_edit";
    }

    /**
     * 修改页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=updateform")
    public String updateform(HttpServletRequest request, HttpServletResponse response)
    {
        getFormDetail(request, response);
        return "jingpin/jingpin_edit";
    }

    /**
     * 创建
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=create")
    public void create(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_JINGPIN_ADD, request, response);
    }

    /**
     * 修改
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=update")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_JINGPIN_UPDATE, request, response);
    }

    /**
     * 删除
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_JINGPIN_DELETE, request, response);
    }

    public void getFormDetail(HttpServletRequest request, HttpServletResponse response)
    {
        String jingpinId = ServletRequestUtils.getStringParameter(request, "id", "");
        FJingpin jingpin = null;
        String flag = "create";
        if (StringUtils.hasText(jingpinId))
        {
            TransData<FJingpin> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_JINGPIN_DETAIL, request, FJingpin.class);
            jingpin = respObj.getData();
            flag = "update";
            request.setAttribute("goodsId", jingpin.getGoodsId());
            TransData<FGoodsMarketing> respObj2 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOODMARKETINGINFO_GET, request, FGoodsMarketing.class);
            FGoodsMarketing marketing = respObj2.getData();
            if (marketing != null)
            {
                jingpin.setImgUrl(marketing.getMainImg());
            }

        }
        request.setAttribute("flag", flag);
        request.setAttribute("jingpin", jingpin);

        TransData<List> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_JINGPIN_TYPE_LIST, request, List.class);

        List<FJingpinType> types = respObj.getData();
        request.setAttribute("types", types);

    }
}
