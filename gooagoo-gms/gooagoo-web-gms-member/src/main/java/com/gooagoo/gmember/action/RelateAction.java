package com.gooagoo.gmember.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.common.ZTreeNode;
import com.gooagoo.view.gms.good.FGoods;
import com.gooagoo.view.gms.marketing.FActivity;
import com.gooagoo.view.gms.marketing.FCoupon;
import com.gooagoo.view.gms.marketing.FEvent;
import com.gooagoo.view.gms.member.FMemberCard;
import com.google.gson.Gson;

/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/relate")
public class RelateAction
{
    @RequestMapping(params = "method=relateList2")
    public String relateList2(HttpServletRequest request, HttpServletResponse response)
    {
        String type = ServletRequestUtils.getStringParameter(request, "type", "");
        String datatype = ServletRequestUtils.getStringParameter(request, "datatype", "");
        String relateType = ServletRequestUtils.getStringParameter(request, "relateType", "");
        request.setAttribute("type", type);//multTab-多标签，oneTab-单标签
        request.setAttribute("datatype", datatype);//A-活动关联数据
        request.setAttribute("relateType", relateType);//goods-商品，coupon-优惠凭证

        if ("multTab".equals(type))
        {
            return "relate/relate_tab_mult";
        }
        else if ("oneTab".equals(type))
        {
            return "relate/relate_tab_one";
        }
        return null;
    }

    @RequestMapping(params = "method=pageRelateTab")
    public String pageRelateTab(HttpServletRequest request, HttpServletResponse response)
    {
        String result = null;

        String callback = ServletRequestUtils.getStringParameter(request, "callback", "addRelating");
        String type = ServletRequestUtils.getStringParameter(request, "type", "");
        PageModel pm = null;
        if ("goods".equals(type))
        {
            TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_GOOD_PAGE, request, PageModel.class);
            pm = respObj.getData();
            result = "relate/relate_one_goods";
        }
        else if ("coupon".equals(type))
        {
            request.setAttribute("relaCoupon", "active");
            TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_COUPON_PGAE, request, PageModel.class);
            pm = respObj.getData();
            result = "relate/relate_one_coupon";
        }
        String json = "";
        if (pm != null && pm.getResult() != null)
        {
            Gson gson = new Gson();
            json = gson.toJson(pm.getResult());
            request.setAttribute("json", json);
            request.setAttribute("callback", callback);
            request.setAttribute("pm", pm);
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }

        return result;
    }

    /**
     * 活动列表主页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=getActivity")
    public String getActivity(HttpServletRequest request, HttpServletResponse response)
    {
        return "/relate/activityIndex";
    }

    /**
     * 查询活动列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=pageActivity")
    public String pageActivity(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_ACTIVITY_PAGE, request, PageModel.class);
        PageModel<FActivity> pm = respObj.getData();

        request.setAttribute("list", pm.getResult());
        request.setAttribute("page_cur", pm.getPageIndex());
        request.setAttribute("page_start", pm.getPageStart(5));
        request.setAttribute("page_end", pm.getPageEnd(5));

        return "/relate/activityList";
    }

    /**
     * 商品列表主页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=getGoodsInfo")
    public String getGoodsInfo(HttpServletRequest request, HttpServletResponse response)
    {
        return "/relate/goodsInfoIndex";
    }

    /**
     * 查询商品列表 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=pageGoodsInfo")
    public String pageGoodsInfo(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_GOOD_PAGE, request, PageModel.class);
        PageModel<FGoods> pm = respObj.getData();

        request.setAttribute("list", pm.getResult());
        request.setAttribute("page_cur", pm.getPageIndex());
        request.setAttribute("page_start", pm.getPageStart(5));
        request.setAttribute("page_end", pm.getPageEnd(5));

        return "/relate/goodsInfoList";
    }

    /**
     * 优惠凭证列表主页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=getCoupon")
    public String getCoupon(HttpServletRequest request, HttpServletResponse response)
    {
        return "/relate/couponIndex";
    }

    /**
     * 查询优惠凭证列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=pageCoupon")
    public String pageCoupon(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_COUPON_PGAE, request, PageModel.class);
        PageModel<FCoupon> pm = respObj.getData();

        request.setAttribute("list", pm.getResult());
        request.setAttribute("page_cur", pm.getPageIndex());
        request.setAttribute("page_start", pm.getPageStart(5));
        request.setAttribute("page_end", pm.getPageEnd(5));

        return "/relate/couponList";
    }

    /**
     * 获取卡类型
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=getCardlist")
    public void getCards(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMEBER_LIST, request, List.class);
        List<FMemberCard> cardList = respObj.getData();
        String result = new Gson().toJson(cardList);

        ServletUtils.writeHtml(result, response);
    }

    /**
     * 关联信息列表首页
     * @param request
     * @param response
     * @return
     * @throws ServletRequestBindingException
     */
    @RequestMapping(params = "method=getRelaList")
    public String getRelaList(HttpServletRequest request, HttpServletResponse response)
    {
        String relaType = ServletRequestUtils.getStringParameter(request, "relaType", "");
        request.setAttribute("relaType", relaType);
        return "/relate/relaList";
    }

    /**
     * 关联信息列表首页iframe
     * @param request
     * @param response
     * @return
     * @throws ServletRequestBindingException
     */
    @RequestMapping(params = "method=getRelaTab")
    public String getRelaTab(HttpServletRequest request, HttpServletResponse response)
    {
        String relateType = ServletRequestUtils.getStringParameter(request, "relateType", "");
        request.setAttribute("relateType", relateType);
        return "/relate/relate_tab";
    }

    /**
     * 获取关联信息列表（Goods－商品,　Action－活动, Coupon－优惠凭证, Event－事件,　ResultGoods－优惠商品）
     * @param request
     * @param response
     * @return
     * @throws ServletRequestBindingException
     */
    @RequestMapping(params = "method=relaList")
    public String relaList(HttpServletRequest request, HttpServletResponse response)
    {
        String relaType = ServletRequestUtils.getStringParameter(request, "relaType", "");
        String result = "";
        PageModel pm = null;
        if ("Activity".equals(relaType))
        {
            TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_ACTIVITY_PAGE, request, PageModel.class);
            pm = new PageModel<FActivity>();
            pm = respObj.getData();

            result = "/relate/activityList";
        }
        else if ("Goods".equals(relaType) || "ruleResultValue".equals(relaType))
        {
            TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_GOOD_PAGE, request, PageModel.class);
            pm = new PageModel<FGoods>();
            pm = respObj.getData();

            result = "/relate/goodsInfoList";
        }
        else if ("Coupon".equals(relaType))
        {
            request.setAttribute("relaCoupon", "active");
            TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_COUPON_PGAE, request, PageModel.class);
            pm = new PageModel<FCoupon>();
            pm = respObj.getData();

            result = "/relate/couponList";
        }
        else if ("Event".equals(relaType))
        {
            TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_EVENT_PAGE, request, PageModel.class);
            pm = new PageModel<FEvent>();
            pm = respObj.getData();

            result = "/relate/eventList";
        }
        request.setAttribute("pm", pm);
        request.setAttribute("page_cur", pm.getPageIndex());
        request.setAttribute("page_start", pm.getPageStart(5));
        request.setAttribute("page_end", pm.getPageEnd(5));
        return result;
    }

    /**
     * 获取关联信息列表（Goods－商品,　Action－活动, Coupon－优惠凭证, Event－事件,　ResultGoods－优惠商品）
     * @param request
     * @param response
     * @return
     * @throws ServletRequestBindingException
     */
    @RequestMapping(params = "method=relateList")
    public String relateList(HttpServletRequest request, HttpServletResponse response)
    {
        String relateType = ServletRequestUtils.getStringParameter(request, "relateType", "");
        String result = "";
        PageModel pm = null;
        if ("Activity".equals(relateType))
        {
            TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_ACTIVITY_PAGE, request, PageModel.class);
            pm = new PageModel<FActivity>();
            pm = respObj.getData();

            result = "/relate/relate_activity";
        }
        else if ("Goods".equals(relateType) || "ruleResultValue".equals(relateType))
        {
            TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_GOOD_PAGE, request, PageModel.class);
            pm = new PageModel<FGoods>();
            pm = respObj.getData();

            result = "/relate/relate_goods";
        }
        else if ("Coupon".equals(relateType))
        {
            request.setAttribute("relaCoupon", "active");
            TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_COUPON_PGAE, request, PageModel.class);
            pm = new PageModel<FCoupon>();
            pm = respObj.getData();

            result = "/relate/relate_coupon";
        }
        else if ("Event".equals(relateType))
        {
            TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_EVENT_PAGE, request, PageModel.class);
            pm = new PageModel<FEvent>();
            pm = respObj.getData();

            result = "/relate/relate_event";
        }
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        return result;
    }

    /**
     * 关联信息zTree首页
     * @param request
     * @param response
     * @return
     * @throws ServletRequestBindingException
     */
    @RequestMapping(params = "method=getRelaZTree")
    public String getRelaZTree(HttpServletRequest request, HttpServletResponse response)
    {
        String parentCode = ServletRequestUtils.getStringParameter(request, "parentCode", "");
        String nodeType = ServletRequestUtils.getStringParameter(request, "nodeType", "");
        request.setAttribute("parentCode", parentCode);
        request.setAttribute("nodeType", nodeType);
        return "/relate/relaZTree";
    }

    /**
     * 获取关联信息列表（marketingGoodsCategory－品类,　marketingGoodsBrand－品牌, position－区域, serverTools－服务工具）
     * @param request
     * @param response
     * @return
     * @throws IOException 
     * @throws ServletRequestBindingException
     */
    @RequestMapping(params = "method=relaZTree")
    public void relaZTree(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String nodeType = ServletRequestUtils.getStringParameter(request, "nodeType", "");
        Gson gson = new Gson();
        String json = null;
        if ("marketingGoodsCategory".equals(nodeType))
        {
            TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_RELAZTREE_LISTCATEGORY, request, List.class);
            List<ZTreeNode> categoryList = respObj.getData();

            json = gson.toJson(categoryList);
        }
        else if ("marketingGoodsBrand".equals(nodeType))
        {
            TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_RELAZTREE_LISTBRAND, request, List.class);
            List<ZTreeNode> brandList = respObj.getData();

            json = gson.toJson(brandList);
        }
        else if ("position".equals(nodeType))
        {
            TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_RELAZTREE_LISTPOSITION, request, List.class);
            List<ZTreeNode> positionList = respObj.getData();

            json = gson.toJson(positionList);
        }
        else if ("serverTools".equals(nodeType))
        {
            TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_RELAZTREE_LISTSERVERTOOLS, request, List.class);
            List<ZTreeNode> serverToolsList = respObj.getData();

            json = gson.toJson(serverToolsList);
        }

        ServletUtils.writeHtml(json, response);
    }

    /**
     * 卡列表
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=getCard")
    public void getCard(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<List> respObj;
        respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMEBER_LIST, request, List.class);
        List<FMemberCard> cardList = respObj.getData();
        String result = new Gson().toJson(cardList);
        ServletUtils.writeHtml(result, response);
    }
}
