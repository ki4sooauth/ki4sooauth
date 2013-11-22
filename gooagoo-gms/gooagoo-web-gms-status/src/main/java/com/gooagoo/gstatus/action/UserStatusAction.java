package com.gooagoo.gstatus.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.gstatus.service.UserStatusService;
import com.gooagoo.view.gms.common.GAjax;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.crm.FUserDetail;
import com.gooagoo.view.gms.crm.FhighChartVo;
import com.gooagoo.view.gms.member.FMemberBaseInfo;
import com.gooagoo.view.gms.member.UserStatusView;
import com.gooagoo.view.gms.shopinfo.GmsLoginInfo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/userState")
public class UserStatusAction extends BaseAction
{
    @Autowired
    private UserStatusService userStatusService;

    /**
     * 跟据用户类型查询实时数据
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(params = "method=drawing")
    public void userStateForChart(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String statisticType = ServletRequestUtils.getStringParameter(request, "statisticType", "");
        String tableName = ServletRequestUtils.getStringParameter(request, "tableName", "");
        String serName = ServletRequestUtils.getStringParameter(request, "serName", "");
        String shopId = GMSUtil.getShopIdByWeb(request);
        FhighChartVo userCurrStatus = null;
        String data = null;
        if ("1".equals(statisticType))
        {
            userCurrStatus = this.userStatusService.unMemberStatus(statisticType, tableName, shopId, serName);
            data = new Gson().toJson(userCurrStatus);
        }
        else if ("18".equals(statisticType))
        {
            userCurrStatus = this.userStatusService.memberStatus(statisticType, tableName, shopId, serName);
            data = new Gson().toJson(userCurrStatus);
        }
        else
        {
            userCurrStatus = this.userStatusService.memberStatus(statisticType, tableName, shopId, serName);
            data = new Gson().toJson(userCurrStatus);
        }
        ServletUtils.writeHtml(data, response);
    }

    /**
     * 用户分类分析
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=userAnalysis")
    public void userAnalysis(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String statisticType = ServletRequestUtils.getStringParameter(request, "statisticType", "");
        String shopId = GMSUtil.getShopIdByWeb(request);
        List<Long[]> userHistory = null;
        if ("9".equals(statisticType))
        {
            userHistory = this.userStatusService.unMemberHistory(statisticType, shopId);
        }
        else if ("26".equals(statisticType))
        {
            userHistory = this.userStatusService.memberHistory(statisticType, shopId);
        }
        else
        {
            userHistory = this.userStatusService.memberHistory(statisticType, shopId);
        }
        ServletUtils.writeHtml(new Gson().toJson(userHistory), response);
    }

    /**
     * 用户历史实时状态详细信息
     * @param request
     * @param response
     * @throws IOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=findUserStatusList")
    public String findUserStatusList(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<PageModel> tpm = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_CRM_GET_FUSERS_STATUS_LIST, request, PageModel.class);
        PageModel<UserStatusView> pm = tpm.getData();
        request.setAttribute("pageModel", pm);
        request.setAttribute("page_cur", pm.getPageIndex());
        request.setAttribute("page_start", pm.getPageStart(5));
        request.setAttribute("page_end", pm.getPageEnd(5));
        return "status/user/userList";
    }

    /**
     * 跳转用户列表信息首页
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=userListIndex")
    public String userListIndex(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        return "status/user/userListIndex";
    }

    /**
     * 保存用户状态细分人群信息
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=saveCrowd")
    public void saveCrowd(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String time = ServletRequestUtils.getStringParameter(request, "time", "");
        String crowdName = ServletRequestUtils.getStringParameter(request, "crowdName", "");
        String crowdDesc = ServletRequestUtils.getStringParameter(request, "crowdDesc", "");
        //        String token = (String) request.getAttribute(Constants.CAS_FILTER_SHOP);
        //        if (token == null)
        //        {
        //            token = request.getParameter(Constants.CAS_FILTER_SHOP);
        //        }
        //        this.userStatusService.save(token, time, crowdName, crowdDesc);
        GAjax rv = new GAjax(true, "保存成功");
        ServletUtils.writeHtml(new Gson().toJson(rv), response);
    }

    /**
     * 获取用户统计详细信息
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=toEditName")
    public String toEditName(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        return "status/editName";
    }

    /**
    * 查询新增会员信息
    * @param request
    * @param response
    * @throws IOException
    */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=searchNewMember")
    public String searchNewMember(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("createTime_FE", TimeUtils.getCurrentDate() + " 00:00:00");
        request.setAttribute("createTime_TE", TimeUtils.getCurrentDate() + " 23:59:59");
        request.setAttribute("orderBy", "create_time");
        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBEROFCARD_MEMSPECIALPAGE, request, PageModel.class);
        PageModel<FMemberBaseInfo> pm = respObj.getData();
        request.setAttribute("pageModel", pm);
        request.setAttribute("page_cur", pm.getPageIndex());
        request.setAttribute("page_start", pm.getPageStart(5));
        request.setAttribute("page_end", pm.getPageEnd(5));

        return "status/newMemberTable";
    }

    /**
     * 保存新增会员信息
     * @param request
     * @param response
     * @throws IOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=saveNewMember")
    public void saveNewMember(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("createTime_FE", TimeUtils.getCurrentDate() + " 00:00:00");
        request.setAttribute("createTime_TE", TimeUtils.getCurrentDate() + " 23:59:59");
        request.setAttribute("pageIndex", 1);
        request.setAttribute("pageSize", "20000");
        request.setAttribute("orderBy", "create_time");
        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBEROFCARD_MEMSPECIALPAGE, request, PageModel.class);
        PageModel<FMemberBaseInfo> pm = respObj.getData();
        if (pm != null)
        {
            GmsLoginInfo gmsLoginInfo = GMSUtil.getGmsLoginInfoByWeb(request);
            List<FUserDetail> detailList = gmsLoginInfo.getDetailList();
            String uuid = UUID.getUUID();
            String crowdName = ServletRequestUtils.getStringParameter(request, "crowdName", "");
            String crowdDesc = ServletRequestUtils.getStringParameter(request, "crowdDesc", "");
            //RedisSetDao redisSetDao = new RedisSetDao(RedisServerConstants.statistics_relevantUser);
            FUserDetail fUserDetail = new FUserDetail();
            fUserDetail.setId(uuid);
            fUserDetail.setName(crowdName);
            fUserDetail.setDesc(crowdDesc);
            if (detailList == null)
            {
                detailList = new ArrayList<FUserDetail>();
            }
            for (FMemberBaseInfo baseInfo : pm.getResult())
            {
                //redisSetDao.put(uuid, "0_" + baseInfo.getUserId());
            }
            detailList.add(fUserDetail);
            gmsLoginInfo.setDetailList(detailList);

        }
        GAjax rv = new GAjax(true, "保存成功");
        ServletUtils.writeHtml(new Gson().toJson(rv), response);
    }

}
