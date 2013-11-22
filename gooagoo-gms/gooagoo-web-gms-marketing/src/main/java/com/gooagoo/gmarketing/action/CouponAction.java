package com.gooagoo.gmarketing.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.marketing.MarketingReportOperateUtil;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FCoupon;
import com.gooagoo.view.gms.marketing.FCouponGrantInfo;

/**
* 优惠凭证
* @author Administrator
*
*/
@Controller
@RequestMapping("/coupon")
public class CouponAction extends BaseAction
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
        return "coupon/index";
    }

    /**
     * 列表
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=list")
    public String list(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_COUPON_PGAE, request, PageModel.class);
        PageModel<FCoupon> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));

        }

        return "coupon/coupon_list";
    }

    /**
     * 添加内容页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addform")
    public String addform(HttpServletRequest request, HttpServletResponse response)
    {
        getformDetail(request, response);
        return "coupon/coupon_edit";
    }

    /**
     * 修改内容页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=updateform")
    public String updateform(HttpServletRequest request, HttpServletResponse response)
    {
        getformDetail(request, response);
        return "coupon/coupon_edit";
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
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_COUPON_ADD, request, response);
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

        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_COUPON_UPDATE, request, response);
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
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        if (StringUtils.hasText(id))
        {
            GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_COUPON_DELETE, request, response);
        }

    }

    /**
     * 审核内容页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=formCheck")
    public String formCheck(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<FCoupon> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_COUPON_DETAIL, request, FCoupon.class);
        FCoupon coupon = respObj.getData();
        request.setAttribute("coupon", coupon);
        return "coupon/coupon_check_form";
    }

    /**
     * 审核
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=check")
    public void check(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_COUPON_CHECK, request, response);
    }

    /**
     * 发布
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=release")
    public void release(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_COUPON_RELEASE, request, response);
    }

    /**
     * 详细
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=detail")
    public String detail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        getformDetail(request, response);
        return "coupon/coupon_detail";
    }

    /**
     * 预览
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=getPreviewUrl")
    public String getPreviewUrl(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        String url = UrlUtils.getCouponUrl(id);
        return "redirect:" + url;
    }

    public void getformDetail(HttpServletRequest request, HttpServletResponse response)
    {

        String couponId = ServletRequestUtils.getStringParameter(request, "id", "");
        FCoupon coupon = null;
        if (StringUtils.hasText(couponId))
        {
            TransData<FCoupon> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_COUPON_DETAIL, request, FCoupon.class);
            coupon = respObj.getData();
        }
        request.setAttribute("coupon", coupon);
        if (coupon != null)
        {
            request.setAttribute("couponId", coupon.getCouponId());
        }
        request.setAttribute("date", TimeUtils.getCurrentDate());
    }

    /**
     * 导入Excel
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=importExcel")
    public void importExcel(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        String[] attributeName = { "couponno" };
        List<Map<String, String>> excelInfo = MarketingReportOperateUtil.reportImport(request, "filename", attributeName);
        List<String> list = new ArrayList<String>();
        for (Map<String, String> map : excelInfo)
        {
            if (map.get("couponno") != null)
            {
                list.add(map.get("couponno"));
            }

        }
        if (list == null || list.size() <= 0)
        {
            GooagooLog.warn("上传文件内容为空");
        }
        request.setAttribute("cnl", JsonUtils.toJson(list));
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_COUPON_UPDATE, request, response);
    }

    /**
     * 优惠凭证号段号码列表
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=grantInfoList")
    public String grantInfoList(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_COUPON_GRANTINFO_PAGE, request, PageModel.class);
        PageModel<FCouponGrantInfo> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));

        }

        return "coupon/grantInfo_list";
    }
}
