package com.gooagoo.goods.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.gms.utils.ShopUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.good.FGoods;
import com.gooagoo.view.gms.good.FGoodsBrand;
import com.gooagoo.view.gms.good.FGoodsMarketing;
import com.gooagoo.view.gms.good.FGoodsSpecial;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.google.gson.Gson;

/**
 * 商品信息管理
 * 
 */
@Controller
@RequestMapping("/goods")
public class GoodsAction extends BaseAction
{
    /**
     * 商品列表主页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        ShopUtil.transferShopInfo(request);
        GooagooLog.debug("进入商品列表方法………………，跳转至 goods/goods_index ");
        return "goods/goods_index";
    }

    /**
     * 商品列表分页展示
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=page")
    public String page(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        this.pageAcquire(request);
        ShopUtil.transferShopInfo(request);
        GooagooLog.debug("获得商品列表信息方法………………，跳转至 goods/goods_list ");
        return "goods/goods_list";
    }

    /**
     * 添加商品信息页面
     * @param request
     * @param response
     * @return 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=form")
    public String addGoods(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ShopUtil.transferShopInfo(request);

        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        PageModel<FShopEntityInfo> pModel = respObj.getData();
        if (pModel != null)
        {
            List<FShopEntityInfo> list = pModel.getResult();

            String entityId = ShopUtil.getShopEntityId(request);
            if (entityId != null)
            {
                List<FShopEntityInfo> reList = new ArrayList<FShopEntityInfo>();
                for (FShopEntityInfo e : list)
                {
                    if (e.getShopEntityId().equals(entityId))
                    {
                        reList.add(e);
                    }
                }
                if (!reList.isEmpty())
                {
                    list = reList;
                }
            }

            request.setAttribute("shopEntityList", list);
        }
        else
        {
            GooagooLog.debug("获得实体店信息类别失败");
        }
        GooagooLog.debug("添加商品信息方法页面………………");

        return "goods/add/goods_add";
    }

    /**
     * 添加商品信息操作
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addGoodsDo")
    public void addGoodsDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ShopUtil.transferShopInfo(request);
        GooagooLog.debug("添加商品信息操作方法……");
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOOD_ADD, request, response);
    }

    /**
     * 修改商品信息页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=updateGoods")
    public String updateGoods(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ShopUtil.transferShopInfo(request);

        TransData<FGoods> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOOD_GET, request, FGoods.class);
        FGoods goodsInfo = respObj.getData();

        TransData<List> respObj2 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOODSPECIAL_GETLIST, request, List.class);
        List<FGoodsSpecial> specials = respObj2.getData();

        TransData<FGoodsMarketing> respObj3 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOODMARKETINGINFO_GET, request, FGoodsMarketing.class);
        FGoodsMarketing marketing = respObj3.getData();

        // 商品的品牌信息
        TransData<List> brandTransData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOODBRAND_GETLIST, request, List.class);
        List<FGoodsBrand> brands = brandTransData.getData();

        // 商品的品类信息
        request.setAttribute("categoryId", goodsInfo.getCategoryLeafId());

        request.setAttribute("goodsInfo", goodsInfo);
        request.setAttribute("specials", specials);
        request.setAttribute("brands", brands);

        request.setAttribute("marketing", marketing);

        TransData<PageModel> shopEntityListData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        List<FShopEntityInfo> list = shopEntityListData.getData().getResult();

        // 实体店登录
        String entityId = ShopUtil.getShopEntityId(request);
        if (entityId != null)
        {
            List<FShopEntityInfo> reList = new ArrayList<FShopEntityInfo>();
            for (FShopEntityInfo e : list)
            {
                if (e.getShopEntityId().equals(entityId))
                {
                    reList.add(e);
                }
            }
            if (!reList.isEmpty())
            {
                list = reList;
            }
        }

        String shopEntityId = "";
        String shopEntityName = "";
        for (FShopEntityInfo e : list)
        {
            if (goodsInfo.getEntityId().equals(e.getShopEntityId()))
            {
                shopEntityId = e.getShopEntityId();
                shopEntityName = e.getShopEntityName();
            }
        }
        request.setAttribute("shopEntityList", list);
        request.setAttribute("shopEntityId", shopEntityId);
        request.setAttribute("shopEntityName", shopEntityName);

        return "goods/update/goods_update";
    }

    /**
     * 预览商品信息页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=viewGoods")
    public String viewGoods(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ShopUtil.transferShopInfo(request);

        TransData<FGoods> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOOD_GET, request, FGoods.class);
        FGoods goodsInfo = respObj.getData();

        TransData<List> respObj2 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOODSPECIAL_GETLIST, request, List.class);
        List<FGoodsSpecial> specials = respObj2.getData();

        TransData<FGoodsMarketing> respObj3 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOODMARKETINGINFO_GET, request, FGoodsMarketing.class);
        FGoodsMarketing marketing = respObj3.getData();

        // 商品的品牌信息
        TransData<List> brandTransData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOODBRAND_GETLIST, request, List.class);
        List<FGoodsBrand> brands = brandTransData.getData();

        // 商品的品类信息
        request.setAttribute("categoryId", goodsInfo.getCategoryLeafId());

        request.setAttribute("goodsInfo", goodsInfo);
        request.setAttribute("specials", specials);
        request.setAttribute("brands", brands);
        if (marketing != null)
        {
            String use_Type = SysdictionaryCache.get("use_Type", marketing.getUseType());
            String life_Idea = SysdictionaryCache.get("life_Idea", marketing.getLifeIdea());
            marketing.setUseType(use_Type);
            marketing.setLifeIdea(life_Idea);
            request.setAttribute("marketing", marketing);

        }

        TransData<PageModel> shopEntityListData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        List<FShopEntityInfo> list = shopEntityListData.getData().getResult();

        // 实体店登录
        String entityId = ShopUtil.getShopEntityId(request);
        if (entityId != null)
        {
            List<FShopEntityInfo> reList = new ArrayList<FShopEntityInfo>();
            for (FShopEntityInfo e : list)
            {
                if (e.getShopEntityId().equals(entityId))
                {
                    reList.add(e);
                }
            }
            if (!reList.isEmpty())
            {
                list = reList;
            }
        }

        String shopEntityId = "";
        String shopEntityName = "";
        for (FShopEntityInfo e : list)
        {
            if (goodsInfo.getEntityId().equals(e.getShopEntityId()))
            {
                shopEntityId = e.getShopEntityId();
                shopEntityName = e.getShopEntityName();
            }
        }
        request.setAttribute("shopEntityList", list);
        request.setAttribute("shopEntityId", shopEntityId);
        request.setAttribute("shopEntityName", shopEntityName);

        return "goods/view/goods_view";
    }

    /**
     * 审核商品信息页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=reviewedGoods")
    public String reviewedGoods(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ShopUtil.transferShopInfo(request);

        TransData<FGoods> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOOD_GET, request, FGoods.class);
        FGoods goodsInfo = respObj.getData();

        TransData<List> respObj2 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOODSPECIAL_GETLIST, request, List.class);
        List<FGoodsSpecial> specials = respObj2.getData();

        TransData<FGoodsMarketing> respObj3 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOODMARKETINGINFO_GET, request, FGoodsMarketing.class);
        FGoodsMarketing marketing = respObj3.getData();

        // 商品的品牌信息
        TransData<List> brandTransData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOODBRAND_GETLIST, request, List.class);
        List<FGoodsBrand> brands = brandTransData.getData();

        // 商品的品类信息
        request.setAttribute("categoryId", goodsInfo.getCategoryLeafId());

        request.setAttribute("goodsInfo", goodsInfo);
        request.setAttribute("specials", specials);
        request.setAttribute("brands", brands);

        request.setAttribute("marketing", marketing);

        TransData<PageModel> shopEntityListData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        List<FShopEntityInfo> list = shopEntityListData.getData().getResult();

        // 实体店登录
        String entityId = ShopUtil.getShopEntityId(request);
        if (entityId != null)
        {
            List<FShopEntityInfo> reList = new ArrayList<FShopEntityInfo>();
            for (FShopEntityInfo e : list)
            {
                if (e.getShopEntityId().equals(entityId))
                {
                    reList.add(e);
                }
            }
            if (!reList.isEmpty())
            {
                list = reList;
            }
        }

        String shopEntityId = "";
        String shopEntityName = "";
        for (FShopEntityInfo e : list)
        {
            if (goodsInfo.getEntityId().equals(e.getShopEntityId()))
            {
                shopEntityId = e.getShopEntityId();
                shopEntityName = e.getShopEntityName();
            }
        }
        request.setAttribute("shopEntityList", list);
        request.setAttribute("shopEntityId", shopEntityId);
        request.setAttribute("shopEntityName", shopEntityName);

        return "goods/view/goods_reviewed";
    }

    /**
     * 修改商品信息操作
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=updateGoodsDo")
    public void updateGoodsDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ShopUtil.transferShopInfo(request);
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOOD_UPDATE, request, response);
    }

    /**
     * 删除商品操作
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=delGoodsDo")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOOD_DELETE, request, response);
    }

    /**
     * 获取商品详细信息
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=detail")
    public String detail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<FGoods> respObj1 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOOD_GET, request, FGoods.class);
        FGoods goodsInfo = respObj1.getData();
        request.setAttribute("goodsInfo", goodsInfo);

        TransData<FGoodsMarketing> respObj2 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOODMARKETINGINFO_GET, request, FGoodsMarketing.class);
        FGoodsMarketing goodsMarketing = respObj2.getData();
        request.setAttribute("goodsMarketing", goodsMarketing);

        if (goodsMarketing != null)
        {
            // 交叉营销商品
            request.setAttribute("goodsIdStr", goodsMarketing.getCrossGoods());
            TransData<List> respObj3 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOOD_GET_LIST, request, List.class);
            List<FGoods> crossGoods = respObj3.getData();
            request.setAttribute("crossGoods", crossGoods);
            // 可替换商品
            request.setAttribute("goodsIdStr", goodsMarketing.getReplaceGoods());
            respObj3 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOOD_GET_LIST, request, List.class);
            List<FGoods> replaceGoods = respObj3.getData();
            request.setAttribute("replaceGoods", replaceGoods);
            //关联销售商品
            request.setAttribute("goodsIdStr", goodsMarketing.getRelationGoods());
            respObj3 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOOD_GET_LIST, request, List.class);
            List<FGoods> relationGoods = respObj3.getData();
            request.setAttribute("relationGoods", relationGoods);
        }

        return "goods/goods_detail";
    }

    /**
     * 验证一维码是否已经存在
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=oneCodeIsExist")
    public void oneCodeIsExist(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        this.stringIsExist(InterGmsConstants.I_GMS_GOOD_ONECODE_IS_EXIST, request, response);
    }

    /**
     * 验证二维码是否已经存在
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=twoCodeIsExist")
    public void twoCodeIsExist(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        this.stringIsExist(InterGmsConstants.I_GMS_GOOD_TWOCODE_IS_EXIST, request, response);
    }

    /**
     * 验证商品序列号是否已经存在
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=goodsSerialIsExist")
    public void goodsSerailIsExist(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        this.stringIsExist(InterGmsConstants.I_GMS_GOOD_GOODSSERIAL_IS_EXIST, request, response);
    }

    /**
     * 验证商品单品序列号是否已经存在
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=itemSerialIsExist")
    public void itemSerialIsExist(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        this.stringIsExist(InterGmsConstants.I_GMS_GOOD_ITEMSERIAL_IS_EXIST, request, response);
    }

    /**
     * 获取单个商品信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=goods_single")
    public String goodsSingle(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<FGoods> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOOD_GET, request, FGoods.class);
        FGoods goodsInfo = respObj.getData();
        request.setAttribute("goodsInfo", goodsInfo);

        return "goods/goods_single";
    }

    /**
     * 获得实体店列表
     * @param request
     * @param response
     * @throws IOException 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=getEntityList")
    public void getEntityList(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        List<FShopEntityInfo> list = respObj.getData().getResult();

        String entityId = ShopUtil.getShopEntityId(request);
        if (entityId != null)
        {
            List<FShopEntityInfo> reList = new ArrayList<FShopEntityInfo>();
            for (FShopEntityInfo e : list)
            {
                if (e.getShopEntityId().equals(entityId))
                {
                    reList.add(e);
                }
            }
            if (!reList.isEmpty())
            {
                list = reList;
            }
        }
        String content = new Gson().toJson(list);
        ServletUtils.writeHtml(content, response);
    }

    /**
     * 审核商品
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=reviewed")
    public void reviewedGoodsDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOOD_REVIEWED, request, response);
    }

    /**
     * 发布商品
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=publish")
    public void publishGoods(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOOD_PUBLISH, request, response);
    }

    private void stringIsExist(String url, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId", "");
        @SuppressWarnings("rawtypes")
        TransData<List> result = GMSUtil.httpClientRequest(url, request, List.class);
        @SuppressWarnings("unchecked")
        List<FGoods> list = result.getData();
        boolean flag = false;
        if (list != null)
        {
            if (list.size() == 0)
            {
                flag = true;
            }
            else if (list.size() == 1)
            {
                if (list.get(0).getGoodsId().equals(goodsId))
                {
                    flag = true;
                }
            }
        }
        ServletUtils.writeHtml(String.valueOf(flag), response);
    }

    /**
     * 分页获取商品信息
     * @param request
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void pageAcquire(HttpServletRequest request)
    {
        TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOOD_PAGE, request, PageModel.class);
        PageModel<FGoods> pm = respObj.getData();
        if (pm != null)
        {
            request.setAttribute("pm", pm);
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
            request.setAttribute("goodsList", pm.getResult());
        }
        else
        {
            GooagooLog.debug("获取商品列表信息失败");
        }
    }
}
