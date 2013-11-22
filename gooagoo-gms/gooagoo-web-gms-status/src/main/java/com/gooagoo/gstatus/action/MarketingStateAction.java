package com.gooagoo.gstatus.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.gms.utils.ShopUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.good.FGoods;
import com.gooagoo.view.gms.marketing.FActivity;
import com.gooagoo.view.gms.marketing.FActivityContent;
import com.google.gson.Gson;

/**
 * 营销状态信息
 *
 */
@Controller
@RequestMapping("/marketingState")
public class MarketingStateAction extends BaseAction
{

    /**
     * 获取营销状态信息
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=sum")
    public void sumMarketingState(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<List> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_MARKETING_STATE_SUM_MARKETING_STATE, request, List.class);
        String result = new Gson().toJson(transData.getData());
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 营销商品统计
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    //    @RequestMapping(params = "method=sumMarketingGoods")
    @Deprecated
    public void sumMarketingGoods(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<List> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_MARKETING_STATE_SUM_MARKETING_GOODS, request, List.class);
        String result = new Gson().toJson(transData.getData());
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 营销品类统计
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    //    @RequestMapping(params = "method=sumMarketingCategory")
    @Deprecated
    public void sumMarketingCategory(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<List> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_MARKETING_STATE_SUM_MARKETING_CATEGORY, request, List.class);
        String result = new Gson().toJson(transData.getData());
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 营销品牌统计
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    //    @RequestMapping(params = "method=sumMarketingBrand")
    @Deprecated
    public void sumMarketingBrand(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<List> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_MARKETING_STATE_SUM_MARKETING_BRAND, request, List.class);
        String result = new Gson().toJson(transData.getData());
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 营销优惠凭证统计
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    //    @RequestMapping(params = "method=sumMarketingCoupon")
    @Deprecated
    public void sumMarketingCoupon(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<List> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_MARKETING_STATE_SUM_MARKETING_COUPON, request, List.class);
        String result = new Gson().toJson(transData.getData());
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 事件统计
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    //    @RequestMapping(params = "method=sumMarketingEvent")
    @Deprecated
    public void sumMarketingEvent(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<List> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_MARKETING_STATE_SUM_MARKETING_EVENT, request, List.class);
        String result = new Gson().toJson(transData.getData());
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 吆喝统计
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    //    @RequestMapping(params = "method=sumMarketingCryout")
    @Deprecated
    public void sumMarketingCryout(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<List> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_MARKETING_STATE_SUM_MARKETING_CRYOUT, request, List.class);
        String result = new Gson().toJson(transData.getData());
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 通知统计
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    //    @RequestMapping(params = "method=sumMarketingNotice")
    @Deprecated
    public void sumMarketingNotice(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<List> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_MARKETING_STATE_SUM_MARKETING_NOTICE, request, List.class);
        String result = new Gson().toJson(transData.getData());
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 短信统计
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    //    @RequestMapping(params = "method=sumMarketingMessage")
    @Deprecated
    public void sumMarketingMessage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<List> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_MARKETING_STATE_SUM_MARKETING_MESSAGE, request, List.class);
        String result = new Gson().toJson(transData.getData());
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 营销虚拟商家统计
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    //    @RequestMapping(params = "method=sumMarketingVb")
    @Deprecated
    public void sumMarketingVb(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<List> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_MARKETING_STATE_SUM_MARKETING_VB, request, List.class);
        String result = new Gson().toJson(transData.getData());
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 跟据用户类型查询实时数据
     * 
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=drawing")
    public void userStateForChart(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String userType = ServletRequestUtils.getStringParameter(request, "userType", "");

        String num = "0";
        String shopEntityId = ShopUtil.getShopEntityId(request);
        String shopId = ShopUtil.getShopId(request);

        //店内用户
        if ("1".equals(userType))
        {
            // RedisSortedSetDao redisScortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_areaUserInf);
            double lon = 0;//redisScortedSetDao.getScore(shopEntityId, shopEntityId);
            //            double lon = GMSUtil.getRedisScoreValue(shopEntityId, shopEntityId, RedisServerConstants.statistics_areaUserInf);
            num = String.valueOf(lon);
        }
        //店内会员
        //        else if ("2".equals(userType))
        //        {
        //            num = this.getStateNum(shopEntityId, RedisServerConstants.statistics_areaMember);
        //        }
        //        else if ("8".equals(userType))
        //        {
        //            //手机潜在会员
        //            num = this.getStateNum("000002^" + shopId, RedisServerConstants.statistics_realTime);
        //        }
        //        else if ("7".equals(userType))
        //        {
        //            //web潜在会员
        //            num = this.getStateNum("000004^" + shopId, RedisServerConstants.statistics_realTime);
        //        }
        //        else if ("5".equals(userType))
        //        {
        //            //新增会员信息
        //            String token = ShopUtil.getShopId(request);
        //            num = this.getStateNum(token, RedisServerConstants.statistics_newMemberInf);
        //        }
        //        else if ("6".equals(userType))
        //        {
        //            //店内潜在会员数
        //            num = this.getStateNum(shopId, RedisServerConstants.statistics_potentialInfo);
        //        }
        //        else if ("4".equals(userType))
        //        {
        //            //web互动会员
        //            num = this.getStateNum("000003^" + shopId, RedisServerConstants.statistics_realTime);
        //        }
        //        else if ("3".equals(userType))
        //        {
        //            //手机互动会员
        //            num = this.getStateNum("000001^" + shopId, RedisServerConstants.statistics_realTime);
        //        }
        String data = new Gson().toJson(Integer.parseInt(num));
        ServletUtils.writeHtml(data, response);
    }

    private String getStateNum(String token, String type)
    {
        //RedisSortedSetDao dao = new RedisSortedSetDao(type);
        long zcard = 0;//dao.zcard(token);
        return String.valueOf(zcard);
    }

    /**
     * 查询活动列表
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    //    @RequestMapping(params = "method=getActivityList")
    public String getActivityList(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_ACTIVITY_PAGE, request, PageModel.class);
        PageModel<FActivity> model = transData.getData();
        request.setAttribute("pm", model);
        request.setAttribute("page_cur", model.getPageIndex());
        request.setAttribute("page_start", model.getPageStart(5));
        request.setAttribute("page_end", model.getPageEnd(5));
        return "status/activityList";
    }

    /**
     * 去活动列表首页
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    //    @RequestMapping(params = "method=pageActivityIndex")
    @Deprecated
    public String pageActivityIndex(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_ACTIVITY_PAGE, request, PageModel.class);
        PageModel<FActivity> model = transData.getData();
        request.setAttribute("pm", model);
        request.setAttribute("page_cur", model.getPageIndex());
        request.setAttribute("page_start", model.getPageStart(5));
        request.setAttribute("page_end", model.getPageEnd(5));
        return "status/activityListIndex";
    }

    /**
     * 查询活动内容列表
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    //    @RequestMapping(params = "method=activityContent")
    @Deprecated
    public String activityContent(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<List> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_ACTIVITYCONTENT_LIST, request, List.class);
        List<FActivityContent> flist = respObj.getData();
        request.setAttribute("flist", flist);
        return "status/activityContent";
    }

    /**
     * 商品列表首页
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    //    @RequestMapping(params = "method=goodsListIndex")
    @Deprecated
    public String goodsListIndex(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        return "status/goodsListIndex";
    }

    /**
     * 查询活动内容列表
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    //@RequestMapping(params = "method=goodsList")
    @Deprecated
    public String goodsList(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        ShopUtil.transferShopInfo(request);
        TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOOD_PAGE, request, PageModel.class);
        PageModel<FGoods> pm = respObj.getData();
        request.setAttribute("pm", pm);
        request.setAttribute("page_cur", pm.getPageIndex());
        request.setAttribute("page_start", pm.getPageStart(5));
        request.setAttribute("page_end", pm.getPageEnd(5));
        return "status/goodsInfoList";
    }

    /**
     * 虚拟商家状态首页
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    //@RequestMapping(params = "method=vIndex")
    @Deprecated
    public String vIndex(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        //        GmsLoginInfo gmsLoginInfo = GMSUtil.getShopInfo(request);
        //        request.setAttribute("gmsLoginInfo", gmsLoginInfo);
        ShopUtil.transferShopInfo(request);
        return "status/virtualStoreStatus";
    }

    /**
     * 所有有效活动列信息列表,页面左侧日历使用
     * @param request
     * @param response
     * @throws IOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=getAllActivityList")
    public void getAllActivityList(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<List> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_ACTIVITY_LIST, request, List.class);
        List<FActivity> activeList = respObj.getData();
        String json = "";
        if (activeList != null)
        {
            for (FActivity a : activeList)
            {
                String startTime = TimeUtils.convertDateToString(a.getStartTime(), TimeUtils.FORMAT1);
                a.setStartTimeStr(startTime);
                String endTime = TimeUtils.convertDateToString(a.getEndTime(), TimeUtils.FORMAT1);
                a.setEndTimeStr(endTime);
            }
            json = new Gson().toJson(activeList);
        }
        ServletUtils.writeHtml(json, response);
    }
}
