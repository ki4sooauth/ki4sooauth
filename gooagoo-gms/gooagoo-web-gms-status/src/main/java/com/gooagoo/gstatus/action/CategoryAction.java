package com.gooagoo.gstatus.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.gstatus.util.StatisUtil;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.common.ZTreeNode;
import com.gooagoo.view.gms.good.FCategoryZtreeNode;
import com.gooagoo.view.gms.good.FGoodsCategory;

@Controller
@RequestMapping("/category")
public class CategoryAction
{
    /**
     * 品类统计状态信息
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
       
    	StatisUtil.getEntityInfo(request);
    	
        request.setAttribute("relateType", "J");
        request.setAttribute("dataType", "MS");

        TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_RELATION_PAGE, request, PageModel.class);
        PageModel<FGoodsCategory> pm = respObj.getData();

        if (null != pm && pm.getResult()!=null && !pm.getResult().isEmpty())
        {
            request.setAttribute("parentId", pm.getResult().get(0).getCategoryId());
            request.setAttribute("parentName", pm.getResult().get(0).getCategoryName());
        }
        GMSUtil.getWebUrlByAuthorityId(request,"12");
        request.setAttribute("pageFlag", "category");
        return "status/category/cateStatus";
    }
}
