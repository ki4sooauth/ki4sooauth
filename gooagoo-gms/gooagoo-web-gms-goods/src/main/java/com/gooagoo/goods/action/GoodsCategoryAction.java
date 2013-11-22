package com.gooagoo.goods.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.gooagoo.view.gms.good.FCategoryZtreeNode;
import com.gooagoo.view.gms.good.FGoodsCategory;
import com.google.gson.Gson;

/**
 * 品类信息管理  
 *
 */
@Controller
@RequestMapping("/goodsCategory")
public class GoodsCategoryAction extends BaseAction
{

    /**
     * 品类列表信息页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ShopUtil.transferShopInfo(request);
        GooagooLog.debug("进入品类列表页面，跳转到category/category_list");
        return "category/category_list";
    }

    /**
     * 添加品类信息操作
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addCateDo")
    public void addCateDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOODCATEGORY_ADD, request, response);
    }

    /**
     * 删除品类信息操作
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=delCateDo")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOODCATEGORY_DELETE, request, response);
    }

    /**
     * 修改品类信息操作
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=updateCateDo")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOODCATEGORY_UPDATE, request, response);
    }

    /**
     * 获取品类信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=detail")
    public void detail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<FGoodsCategory> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_GOODCATEGORY_GET, request, FGoodsCategory.class);
        FGoodsCategory category = respObj.getData();
        String result = new Gson().toJson(category);
        GooagooLog.debug("获得单个品类信息，返回值为：" + result);
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 获取品类信息 树形列
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=page")
    public void page(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_GOODCATEGORY_GETLIST, request, List.class);
        List<FGoodsCategory> list = respObj.getData();
        GooagooLog.debug("1获得品类列表数据信息，返回值FGoodsCategory：" + new Gson().toJson(list));
        List<FCategoryZtreeNode> reList = this.convertToFZtreeNodes(list);
        String result = new Gson().toJson(reList);
        GooagooLog.debug("2获得品类列表数据信息，返回值FCategoryZtreeNode：" + result);
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 验证品类编号的唯一性
     * @param request
     * @param response
     * @throws IOException 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=checkCategoryId")
    public void checkCategoryId(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_GOODCATEGORY_GETLIST, request, List.class);
        List<FGoodsCategory> list = respObj.getData();
        String categoryId = request.getParameter("categoryId");
        String id = request.getParameter("id");
        boolean flag = true;
        for (FGoodsCategory e : list)
        {
            if (e.getCategoryId().equals(categoryId))
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
     * 品类列表转为  ztreeNode 列
     * @param list
     * @return
     */
    private List<FCategoryZtreeNode> convertToFZtreeNodes(List<FGoodsCategory> list)
    {
        List<FCategoryZtreeNode> reList = new ArrayList<FCategoryZtreeNode>();
        Map<String, FGoodsCategory> map = new HashMap<String, FGoodsCategory>();
        for (FGoodsCategory e : list)
        {
            map.put(e.getCategoryId(), e);
        }
        for (FGoodsCategory e : list)
        {
            FCategoryZtreeNode z = new FCategoryZtreeNode();
            z.setI(e.getId());
            z.setId(e.getCategoryId());
            z.setName(e.getCategoryName());
            z.setOpen(true);
            z.setpId(e.getParentCategoryId());
            if (e.getParentCategoryId().equals("-1"))
            {
                z.setrId("-1");
            }
            else
            {
                z.setrId(this.getRootId(map, e.getParentCategoryId()));
            }

            reList.add(z);
        }
        return reList;
    }

    private String getRootId(Map<String, FGoodsCategory> map, String id)
    {
        String rootId = id;
        do
        {
            FGoodsCategory category = map.get(rootId);
            id = rootId;
            rootId = category.getParentCategoryId();
        }
        while (!rootId.equals("-1"));

        return id;
    }
}
