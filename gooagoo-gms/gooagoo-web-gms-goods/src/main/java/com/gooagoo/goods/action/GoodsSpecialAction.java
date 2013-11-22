package com.gooagoo.goods.action;

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
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.good.FGoodsFeature;
import com.gooagoo.view.gms.good.FGoodsSpecial;
import com.google.gson.Gson;

/**
 * 商品特征信息管理
 * 
 */
@Controller
@RequestMapping("/goodsSpecial")
public class GoodsSpecialAction extends BaseAction
{

    /**
     * 添加商品特征信息
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=addSpecial")
    public String addSpecial(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // 获取全部的特征字典
        request.setAttribute("pageSize", "1000");
        TransData<PageModel> td = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_GOODFEATURE_GETLIST, request, PageModel.class);
        List<FGoodsFeature> list = td.getData().getResult();

        // 获取已经添加的特征信息
        TransData<List> respObj2 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOODSPECIAL_GETLIST, request, List.class);
        List<FGoodsSpecial> specials = respObj2.getData();
        // 去掉添加的
        Map<String, FGoodsSpecial> map = new HashMap<String, FGoodsSpecial>();
        for (FGoodsSpecial s : specials)
        {
            map.put(s.getFeatureCode(), s);
        }

        List<FGoodsFeature> features = new ArrayList<FGoodsFeature>();
        for (FGoodsFeature f : list)
        {
            FGoodsSpecial special = map.get(f.getCode());
            if (special == null)
            {
                features.add(f);
            }
        }
        request.setAttribute("features", features);

        return "goods/update/add_special";
    }

    /**
     * 修改商品特征信息页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=updateSpecial")
    public String updateSpecial(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // 取得特征商品数据
        TransData<FGoodsSpecial> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_GOODSPECIAL_GET, request, FGoodsSpecial.class);
        FGoodsSpecial special = respObj.getData();
        request.setAttribute("special", special);
        // 取出特征字典数据
        TransData<PageModel> td = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_GOODFEATURE_GETLIST, request, PageModel.class);
        List<FGoodsFeature> list = td.getData().getResult();
        FGoodsFeature feature = null;
        for (FGoodsFeature f : list)
        {
            if (f.getCode().equals(special.getFeatureCode()))
            {
                feature = f;
            }
        }
        request.setAttribute("feature", feature);

        return "goods/update/update_special";
    }

    /**
     * 添加商品特征信息操作
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addSpecialDo")
    public void addSpecialDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOODSPECIAL_ADD, request, response);
    }

    /**
     * 删除商品特征信息操作
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=delSpecialDo")
    public void delSpecialDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOODSPECIAL_DELETE, request, response);
    }

    /**
     * 获得一个商品特征信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=getSpecial")
    public void getSpecial(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<FGoodsSpecial> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_GOODSPECIAL_GET, request, FGoodsSpecial.class);

        String result = new Gson().toJson(respObj.getData());
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 修改商品特征信息操作
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=updateSpecialDo")
    public void updateSpecialDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOODSPECIAL_UPDATE, request, response);
    }
}
