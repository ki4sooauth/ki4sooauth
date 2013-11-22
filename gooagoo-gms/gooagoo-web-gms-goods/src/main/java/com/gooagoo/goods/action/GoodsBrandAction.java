package com.gooagoo.goods.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.gms.utils.ShopUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.good.FBrandZtreeNode;
import com.gooagoo.view.gms.good.FGoodsBrand;
import com.google.gson.Gson;

/**
 * 品牌信息管理  
 *
 */
@Controller
@RequestMapping("/goodsBrand")
public class GoodsBrandAction extends BaseAction
{
    /** 
     * 品牌列表主页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String getBrands(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ShopUtil.transferShopInfo(request);
        GooagooLog.debug("进入品牌列表页面…… 跳转到  brand/brand_list");
        return "brand/brand_list";
    }

    /**
     * 获取单个的品牌信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=getBrand")
    public void getBrand(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        TransData<FGoodsBrand> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_GOODBRAND_GET, request, FGoodsBrand.class);
        String result = new Gson().toJson(respObj.getData());
        GooagooLog.debug("获得单个品牌数据，传入参数品牌Id为：" + request.getParameter("id"));
        GooagooLog.debug("获得单个品牌数据，返回参数为：" + result);
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 添加品牌信息操作
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addDo")
    public void addDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOODBRAND_ADD, request, response);
    }

    /**
     * 删除品牌信息操作
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=delDo")
    public void delDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOODBRAND_DELETE, request, response);
    }

    /**
     * 修改品牌信息操作
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=updateDo")
    public void updateDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOODBRAND_UPDATE, request, response);
    }

    /**
     * 获取品牌列表
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=list")
    public void list(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_GOODBRAND_GETLIST, request, List.class);
        List<FGoodsBrand> list = respObj.getData();
        GooagooLog.debug("获取品牌列表，返回值FGoodsBrand为：" + new Gson().toJson(list));
        List<FBrandZtreeNode> reList = this.convertToFZtreeNodes(list);
        String result = new Gson().toJson(reList);
        GooagooLog.debug("获取品牌列表，返回值FBrandZtreeNode为：" + result);
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 验证品牌编号的唯一性
     * @param request
     * @param response
     * @throws IOException 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=checkBrandId")
    public void checkBrandId(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_GOODBRAND_GETLIST, request, List.class);
        List<FGoodsBrand> list = respObj.getData();
        String brandId = request.getParameter("brandId");
        String id = request.getParameter("id");
        boolean flag = true;
        for (FGoodsBrand e : list)
        {
            if (e.getBrandId().equals(brandId))
            {
                if (id != null)
                {
                    if (!e.getId().equals(id))
                    {
                        flag = false;
                    }
                }
                else
                {
                    flag = false;
                }
            }
        }
        ServletUtils.writeHtml(String.valueOf(flag), response);
    }

    /**
     * 品牌列表转为  ztreeNode 列
     * @param list
     * @return
     */
    private List<FBrandZtreeNode> convertToFZtreeNodes(List<FGoodsBrand> list)
    {
        List<FBrandZtreeNode> reList = new ArrayList<FBrandZtreeNode>();
        for (FGoodsBrand e : list)
        {
            FBrandZtreeNode z = new FBrandZtreeNode();
            z.setId(e.getBrandId());
            z.setName(e.getBrandName());
            z.setI(e.getId());
            reList.add(z);
        }
        return reList;
    }
}
