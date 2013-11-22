package com.gooagoo.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.good.FGoodsFeature;

@Controller
@RequestMapping("/feature")
public class GoodsFeatureAction
{
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        return "feature/index";
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=list")
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<PageModel> td = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_GOODFEATURE_GETLIST, request, PageModel.class);
        PageModel<FGoodsFeature> pm = td.getData();
        if (pm != null)
        {
            request.setAttribute("pm", pm);
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
            request.setAttribute("list", pm.getResult());
        }
        else
        {
            GooagooLog.debug("获取商品特征项列表信息失败");
        }

        return "feature/list";
    }

    @RequestMapping(params = "method=add")
    public String add(HttpServletRequest request, HttpServletResponse response)
    {
        return "feature/add";
    }

    @RequestMapping(params = "method=addDo")
    public void addDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOODFEATURE_ADD, request, response);
    }

    @RequestMapping(params = "method=update")
    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<FGoodsFeature> td = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_GOODFEATURE_GET, request, FGoodsFeature.class);
        FGoodsFeature feature = td.getData();

        request.setAttribute("feature", feature);

        return "feature/update";
    }

    @RequestMapping(params = "method=updateDo")
    public void updateDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOODFEATURE_UPDATE, request, response);
    }

    @RequestMapping(params = "method=delDo")
    public void delDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOODFEATURE_DELETE, request, response);
    }
}
