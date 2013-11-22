package com.gooagoo.gstatus.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.member.UserStatusView;

/**
 * 获得用户人群信息列
 *
 */
@Controller
@RequestMapping("userList")
public class UserListAction extends BaseAction
{    
	
	
	/**
     * 获得用户人群数据列
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=tableIndex")
    public String tableIndex(HttpServletRequest request, HttpServletResponse response)
    {
         return "status/user/userListIndex";
    }
	
	
	
    /**
     * 获得用户人群数据列
     * @param request
     * @param response
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=getUserList")
    public String getUserList(HttpServletRequest request, HttpServletResponse response)
    {

        TransData<PageModel> data = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_CRM_GET_FUSERS_STATUS_LIST, request, PageModel.class);
        PageModel<UserStatusView> pm = data.getData();
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        request.setAttribute("pageModel", pm);
        return "status/user/userList";
    }
    
    
    
    /**
     * 跳转保存用户群页
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=toSavePeople")
    public String toEditName(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        return "status/savePeople";
    }
    
    
    /**
     * 保存用户群
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=saveCrowd")
    public void saveCrowd(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_MARKETING_STATE_SAVE_CROWD, request, response);
    }
    
    
}
