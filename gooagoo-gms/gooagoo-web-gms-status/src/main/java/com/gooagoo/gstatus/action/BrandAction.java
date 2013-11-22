package com.gooagoo.gstatus.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.gms.utils.ShopUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.gstatus.util.StatisUtil;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.common.ZTreeNode;
import com.gooagoo.view.gms.good.FGoodsBrand;
import com.google.gson.Gson;

@Controller
@RequestMapping("/brand")
public class BrandAction
{
    /**
     * 品牌状态首页
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=index")
    public String brandIndex(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        
    	StatisUtil.getEntityInfo(request);
        request.setAttribute("relateType", "B");
        request.setAttribute("dataType", "MS");
        TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_RELATION_PAGE, request, PageModel.class);
        PageModel<FGoodsBrand> pm = respObj.getData();

        if (pm != null && pm.getResult() != null && !pm.getResult().isEmpty())
        {
            request.setAttribute("parentId", pm.getResult().get(0).getBrandId());
            request.setAttribute("parentName", pm.getResult().get(0).getBrandName());
        }
        GMSUtil.getWebUrlByAuthorityId(request, "12");
        request.setAttribute("pageFlag", "brand");
        return "status/brand/brandStatus";
    }

    /**
     * 品牌列表信息
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=brandListIndex")
    public String brandListIndex(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        return "status/brandsZTree";
    }

    /**
     * 品牌列表信息
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=brandList")
    public void brandList(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        ShopUtil.transferShopInfo(request);
        TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_GOODBRAND_GETLIST, request, List.class);
        List<FGoodsBrand> list = respObj.getData();
        List<ZTreeNode> reList = this.convertToFZtreeNodes2(list);
        String result = new Gson().toJson(reList);
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 品牌列表转为  ztreeNode 列
     * @param list
     * @return
     */
    private List<ZTreeNode> convertToFZtreeNodes2(List<FGoodsBrand> list)
    {
        List<ZTreeNode> reList = new ArrayList<ZTreeNode>();
        for (FGoodsBrand e : list)
        {
            ZTreeNode z = new ZTreeNode();
            z.setId(e.getId());
            z.setName(e.getBrandName());
            reList.add(z);
        }
        return reList;
    }
}
