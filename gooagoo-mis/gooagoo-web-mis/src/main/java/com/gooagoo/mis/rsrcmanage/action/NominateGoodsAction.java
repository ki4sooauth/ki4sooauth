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
import com.gooagoo.view.mis.recommendManage.MGoodsMarketingInfo;
import com.gooagoo.view.mis.recommendManage.MNominateGoods;
import com.gooagoo.view.mis.recommendManage.MNominateGoodsBusiness;

@Controller
@RequestMapping("/nominateG")
public class NominateGoodsAction extends BaseAction
{
    /**
     * 推荐商品查询条件页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=quertConditionPage")
    public String quertConditionPage(HttpServletRequest request, HttpServletResponse response)
    {
        return "/rsrcmanage/nominate/goods_index";
    }

    /**
     * 推荐商品列表页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=queryListPage")
    public String quertListPage(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId2", "20402");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "20402");//权限Id
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("misUserId", MMisLoginInfo.getLoginId());
        }
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_NOMINATE_QUERY_GOODSALL, request, PageModel.class);
        PageModel<MNominateGoodsBusiness> pm = respObj.getData();
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        return "/rsrcmanage/nominate/goods_content";
    }

    /**
     * 推荐页面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=nominateGoodsPage")
    public String nominateGoodsPage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<MGoodsMarketingInfo> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_NOMINATE_QUERY_GOODS, request, MGoodsMarketingInfo.class);
        MGoodsMarketingInfo goods = respObj.getData();
        request.setAttribute("goods", goods);
        return "/rsrcmanage/nominate/goods_add";
    }

    /**
     * 推荐操作
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=nominateGoods")
    public void nominateGoods(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2040201");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_NOMINATE_ADD_NOMINATEGOODS, request, response);
    }

    /**
     * 查询推荐页面-上方查询
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=cancelNominateGoodsPageIndex")
    public String cancelNominateGoodsPageIndex(HttpServletRequest request, HttpServletResponse response)
    {
        return "/rsrcmanage/nominate/goods_query_index";
    }

    /**
     * 查询推荐页面-下方列表
     * @param request
     * @param response
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=cancelNominateGoodsPage")
    public String cancelNominateGoodsPage(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId2", "20402");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "20402");//权限Id
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("misUserId", MMisLoginInfo.getLoginId());
        }
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_NOMINATE_QUERY_NOMINATEGOODSALL, request, PageModel.class);
        PageModel<MNominateGoodsBusiness> pm = respObj.getData();
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        return "/rsrcmanage/nominate/goods_query_content";
    }

    /**
     * 取消推荐操作
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=cancelNominateGoods")
    public void cancelNominateGoods(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2040203");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_NOMINATE_UPDATE_NOMINATEGOODS, request, response);
    }

    /**
     * 修改推荐页面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=updateGoodsPage")
    public String updateGoodsPage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<MNominateGoods> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_NOMINATE_UPDATE_GOODSPAGE, request, MNominateGoods.class);
        MNominateGoods goods = respObj.getData();
        request.setAttribute("goods", goods);
        return "/rsrcmanage/nominate/goods_update";
    }

    /**
     * 修改推荐操作
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=updateNominateGoods")
    public void updateNominateGoods(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2040202");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_NOMINATE_UPDATE_NOMINATEGOODST, request, response);
    }

    /**
     * 验证商品是否已推荐
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=checkNominateGoods")
    public void checkNominateGoods(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        MisUtils.ajaxSubmit(MisInterConstants.MIS_NOMINATE_CHECK_GOODS, request, response);
    }
}
