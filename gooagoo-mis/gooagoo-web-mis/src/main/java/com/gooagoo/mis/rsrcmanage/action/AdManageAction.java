package com.gooagoo.mis.rsrcmanage.action;

import java.util.Date;

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
import com.gooagoo.view.mis.recommendManage.MAdsManage;
import com.gooagoo.view.mis.recommendManage.MBidDetailInfo;
import com.gooagoo.view.mis.recommendManage.MShopAd;

@Controller
@RequestMapping("/adManage")
public class AdManageAction extends BaseAction
{

    /**
     * 广告位管理-上方查询
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=adManageShowIndex")
    public String adManageShowIndex(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("curreDate", new Date());
        return "/rsrcmanage/admanage/admanage_index";
    }

    /**
     * 广告位管理-下方列表
     * @param requst
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=queryAllAdManage")
    public String queryAllAdManage(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId2", "20602");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "20602");//权限Id
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_AD_ADSMANAGE_QUERYALL, request, PageModel.class);
        PageModel<MBidDetailInfo> pm = respObj.getData();
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
        return "/rsrcmanage/admanage/admanage_content";
    }

    /**
     * 新增广告位竞拍页面
     * @param request
     * @param response
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=addAdManagePage")
    public String addAdManagePage(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_AD_SHOPAD_QUERYALL, request, PageModel.class);
        PageModel<MShopAd> pm = respObj.getData();
        request.setAttribute("pm", pm);
        return "/rsrcmanage/admanage/admanage_add";
    }

    /**
     * 新增广告位竞拍
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=addAdManage")
    public void addAdManage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2060201");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_AD_ADSMANAGE_ADD, request, response);
    }

    /**
     * 编辑广告位管理页面
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=queryAdManage")
    public String queryAdManage(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<MAdsManage> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_AD_ADSMANAGE_QUERY, request, MAdsManage.class);
        MAdsManage adsManage = respObj.getData();
        request.setAttribute("adsManage", adsManage);
        return "/rsrcmanage/admanage/admanage_update";
    }

    /**
     * 编辑广告位管理
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=updateAdManage")
    public void updateAdManage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2060202");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_AD_ADSMANAGE_UPDATE, request, response);
    }

    /**
     * 删除广告位管理
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=deleteAdManage")
    public void deleteAdManage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2060203");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_AD_ADSMANAGE_DELETE, request, response);
    }

    /**
     * 发布广告位竞拍
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=releaseAdManage")
    public void releaseAdManage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2060204");
        request.setAttribute("state", "1");// 状态：发布
        MisUtils.ajaxSubmit(MisInterConstants.MIS_AD_ADSMANAGE_UPDATESTATE, request, response);
    }

    /**
     * 提交资料页面
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=submitDatasPage")
    public String submitDatasPage(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<MAdsManage> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_AD_ADSMANAGE_QUERYSUBMIT, request, MAdsManage.class);
        MAdsManage adsManage = respObj.getData();
        request.setAttribute("adsManage", adsManage);
        return "/rsrcmanage/admanage/admanage_data";
    }

    /**
     * 提交资料
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=submitDatas")
    public void submitDatas(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2060205");
        request.setAttribute("state", "3");// 状态：已提交资料
        MisUtils.ajaxSubmit(MisInterConstants.MIS_AD_ADSMANAGE_SUBMIT, request, response);
    }

    /**
     * 审核
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=checkedAdManage")
    public void checkedAdManage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2060206");
        request.setAttribute("state", "4");// 状态：审核
        MisUtils.ajaxSubmit(MisInterConstants.MIS_AD_ADSMANAGE_CHECKED, request, response);
    }

    /**
     * 收款
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=moneyReceiptAdManage")
    public void moneyReceiptAdManage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2060207");
        request.setAttribute("state", "5");// 状态：收款
        MisUtils.ajaxSubmit(MisInterConstants.MIS_AD_ADSMANAGE_MONEY, request, response);
    }

    /**
     * 卖出
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=bearPositionAdManage")
    public void bearPositionAdManage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2060208");
        request.setAttribute("state", "6");// 状态：已卖出
        MisUtils.ajaxSubmit(MisInterConstants.MIS_AD_ADSMANAGE_BEAR, request, response);
    }
}
