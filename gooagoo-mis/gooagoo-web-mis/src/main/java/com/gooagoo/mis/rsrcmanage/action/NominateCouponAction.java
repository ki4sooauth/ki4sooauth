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
import com.gooagoo.view.mis.recommendManage.MCoupon;
import com.gooagoo.view.mis.recommendManage.MNominateCoupon;

@Controller
@RequestMapping("/nominateC")
public class NominateCouponAction extends BaseAction
{
    /**
     * 推荐优惠凭证查询条件页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=quertConditionPage")
    public String quertConditionPage(HttpServletRequest request, HttpServletResponse response)
    {
        return "/rsrcmanage/nominate/coupon_index";
    }

    /**
     * 推荐优惠凭证列表页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=queryListPage")
    public String quertListPage(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId2", "20404");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "20404");//权限Id
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("misUserId", MMisLoginInfo.getLoginId());
        }
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_NOMINATE_QUERY_COUPONALL, request, PageModel.class);
        PageModel<MNominateCoupon> pm = respObj.getData();
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        return "/rsrcmanage/nominate/coupon_content";
    }

    /**
     * 推荐页面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=nominateCouponPage")
    public String nominateCouponPage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<MCoupon> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_NOMINATE_QUERY_COUPON, request, MCoupon.class);
        MCoupon coupon = respObj.getData();
        request.setAttribute("coupon", coupon);
        return "/rsrcmanage/nominate/coupon_add";
    }

    /**
     * 推荐操作
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=nominateCoupon")
    public void nominateCoupon(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2040401");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_NOMINATE_ADD_NOMINATECOUPON, request, response);
    }

    /**
     * 查询推荐页面-上方查询
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=cancelNominateCouponPageIndex")
    public String cancelNominateCouponPageIndex(HttpServletRequest request, HttpServletResponse response)
    {
        return "/rsrcmanage/nominate/coupon_query_index";
    }

    /**
     * 查询推荐页面-下方列表
     * @param request
     * @param response
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=cancelNominateCouponPage")
    public String cancelNominateCouponPage(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId2", "20404");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "20404");//权限Id
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("misUserId", MMisLoginInfo.getLoginId());
        }
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_NOMINATE_QUERY_NOMINATECOUPONALL, request, PageModel.class);
        PageModel<MNominateCoupon> pm = respObj.getData();
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        return "/rsrcmanage/nominate/coupon_query_content";
    }

    /**
     * 取消推荐操作
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=cancelNominateCoupon")
    public void cancelNominateCoupon(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2040403");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_NOMINATE_UPDATE_NOMINATECOUPON, request, response);
    }

    /**
     * 修改推荐页面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=updateCouponPage")
    public String updateCouponPage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<MNominateCoupon> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_NOMINATE_UPDATE_COUPONPAGE, request, MNominateCoupon.class);
        MNominateCoupon coupon = respObj.getData();
        request.setAttribute("coupon", coupon);
        return "/rsrcmanage/nominate/coupon_update";
    }

    /**
     * 修改推荐操作
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=updateNominateCoupon")
    public void updateNominateCoupon(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2040402");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_NOMINATE_UPDATE_NOMINATECOUPONT, request, response);
    }

    /**
     * 验证活动是否已推荐
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=checkNominateCoupon")
    public void checkNominateCoupon(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        MisUtils.ajaxSubmit(MisInterConstants.MIS_NOMINATE_CHECK_COUPON, request, response);
    }
}
