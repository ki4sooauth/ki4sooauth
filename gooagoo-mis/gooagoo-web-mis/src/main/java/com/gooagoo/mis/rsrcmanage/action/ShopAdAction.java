package com.gooagoo.mis.rsrcmanage.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;
import com.gooagoo.mis.constants.MisInterConstants;
import com.gooagoo.mis.httputil.HttpUtilsMis;
import com.gooagoo.mis.util.MisUtils;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.recommendManage.MShopAd;

@Controller
@RequestMapping("/shopAd")
public class ShopAdAction extends BaseAction
{
    /**
     * 广告位查询-上方查询
     * @param requst
     * @param response
     * @return
     */
    @RequestMapping(params = "method=adQueryShowIndex")
    public String adQueryShowIndex(HttpServletRequest request, HttpServletResponse response)
    {
        this.queryData(request, response);
        return "/rsrcmanage/ad/adquery_index";
    }

    /**
     * 广告位查询-下方列表
     * @param requst
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=queryAllAdQuery")
    public String queryAllAdQuery(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId2", "20601");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "20601");//权限Id
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_AD_SHOPAD_QUERYALL, request, PageModel.class);
        PageModel<MShopAd> pm = respObj.getData();
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
        this.queryData(request, response);
        return "/rsrcmanage/ad/adquery_content";
    }

    /**
     * 新增广告位信息页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addAdQueryPage")
    public String addAdQueryPage(HttpServletRequest request, HttpServletResponse response)
    {
        this.queryData(request, response);
        return "/rsrcmanage/ad/adquery_add";
    }

    /**
     * 新增广告位信息
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=addAdQuery")
    public void addAdQuery(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2060101");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_AD_SHOPAD_ADD, request, response);
    }

    /**
     * 编辑广告位信息页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=queryAdQueryPage")
    public String queryAdQueryPage(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<MShopAd> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_AD_SHOPAD_QUERY, request, MShopAd.class);
        MShopAd ad = respObj.getData();
        request.setAttribute("ad", ad);
        this.queryData(request, response);
        return "/rsrcmanage/ad/adquery_update";
    }

    /**
     * 编辑广告位信息
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=updateAdQuery")
    public void updateAdQuery(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2060102");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_AD_SHOPAD_UPDATE, request, response);
    }

    /**
     * 删除广告位信息
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=deleteAdQuery")
    public void deleteAdQuery(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2060103");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_AD_SHOPAD_DELETE, request, response);
    }

    /**
     * 查询通用字典表信息
     * @param request
     * @param response
     * @return
     */
    private void queryData(HttpServletRequest request, HttpServletResponse response)
    {
        MisUtils.queryData(new String[]{"ad_type"}, request, response);
    }
}
