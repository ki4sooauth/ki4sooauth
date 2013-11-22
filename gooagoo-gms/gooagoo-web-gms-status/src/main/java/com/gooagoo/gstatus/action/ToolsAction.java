package com.gooagoo.gstatus.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.gstatus.util.StatisUtil;
import com.gooagoo.view.gms.common.ZTreeNode;

@Controller
@RequestMapping("/tools")
public class ToolsAction
{
    /**
     * 服务工具状态
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=index")
    public String toolIndex(HttpServletRequest request, HttpServletResponse response) throws IOException
    {

        request.setAttribute("relateType", "F");
        request.setAttribute("dataType", "TD");

        TransData<List> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_RELATION_TREE, request, List.class);
        List<ZTreeNode> nodeList = respObj.getData();

        if (null != nodeList && !nodeList.isEmpty())
        {
            request.setAttribute("parentId", nodeList.get(0).getId());
            request.setAttribute("parentName", nodeList.get(0).getName());
        }
        StatisUtil.getEntityInfo(request);
        GMSUtil.getWebUrlByAuthorityId(request,"12");
        request.setAttribute("pageFlag", "tool");
        return "status/tool/toolStatus";
    }
}
