package com.gooagoo.gtools.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSServiceUtil;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.gms.utils.ShopUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.common.ZTreeNode;
import com.gooagoo.view.gms.member.FMemberCard;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.gooagoo.view.gms.tools.FShopTool;
import com.gooagoo.view.gms.tools.FToolAuth;
import com.google.gson.Gson;

/**
 * 商家服务工具信息管理
 * 
 */
@Controller
@RequestMapping("/tools")
public class ToolsAction extends BaseAction
{
    /**
     * 商家服务工具主页面
     * @param request 
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String num = ServletRequestUtils.getStringParameter(request, "num", "0");
        request.setAttribute("num", num);

        this.getToolsList(request, response);
        return "tools/index";
    }

    /**
     * 获得服务工具权限内容
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=getAuth")
    public void getAuth(HttpServletRequest request, HttpServletResponse response) throws IOException
    {

        @SuppressWarnings("rawtypes")
        TransData<List> cardTransData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMEBER_PAGE, request, List.class);
        @SuppressWarnings("unchecked")
        List<FMemberCard> cardTypes = cardTransData.getData();

        TransData<FShopTool> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_TOOLS_GETSHOPTOOL, request, FShopTool.class);
        FShopTool shopTool = respObj.getData();

        List<FToolAuth> toolAuths = new ArrayList<FToolAuth>();
        FToolAuth allToolAuth = new FToolAuth();
        allToolAuth.setCardId("0");
        allToolAuth.setCardName("全选");
        allToolAuth.setFlag(false);
        toolAuths.add(allToolAuth);
        // 权限值为空，表示所有的会员卡都拥有使用该服务工具的权限
        if (shopTool.getAuthority() == null || shopTool.getAuthority().isEmpty())
        {
            allToolAuth.setFlag(false);

            FToolAuth toolAuth = null;
            for (FMemberCard cardLvl : cardTypes)
            {
                toolAuth = new FToolAuth(cardLvl, false);
                toolAuths.add(toolAuth);

            }
        }
        else
        {
            // 获得拥有使用该服务工具权限的会员卡编号
            List<String> cardIdList = Arrays.asList(shopTool.getAuthority().split(","));

            boolean flag = true; // 标记所有级别的会员都用户使用该服务的权限
            FToolAuth toolAuth = null;
            for (FMemberCard cardLvl : cardTypes)
            {
                toolAuth = new FToolAuth(cardLvl);
                if (cardIdList.contains(cardLvl.getCardId()))
                {
                    toolAuth.setFlag(true);
                }
                else
                {
                    toolAuth.setFlag(false);
                    flag = false;
                }
                toolAuths.add(toolAuth);
            }
            if (flag)
            {
                allToolAuth.setFlag(true);
            }
        }
        String content = new Gson().toJson(toolAuths);
        ServletUtils.writeHtml(content, response);
    }

    /**
     * 保存商家服务工具的权限配置
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=saveAuth")
    public void saveAuth(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_TOOLS_UPDATEAUTH, request, response);
    }

    /**
     * 添加商家服务工具内容页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addTools")
    public String addTools(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        this.getToolsList(request, response);
        ShopUtil.transferShopInfo(request);

        return "/tools/add";
    }

    /**
     * 获取商家服务工具内容信息列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=getToolContent")
    public void getToolContent(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        @SuppressWarnings("rawtypes")
        TransData<Map> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_TOOLS_GETTOOLS, request, Map.class);
        @SuppressWarnings("unchecked")
        Map<String, List<Object>> map = respObj.getData();

        String result = new Gson().toJson(map);

        ServletUtils.writeHtml(result, response);
    }

    /**
     * 获取商家服务工具内容信息列表(排序)
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=getToolSortContent")
    public void getToolSortContent(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        @SuppressWarnings("rawtypes")
        TransData<Map> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_TOOLS_GETSORTTOOLS, request, Map.class);
        @SuppressWarnings("unchecked")
        Map<String, List<Object>> map = respObj.getData();

        String result = new Gson().toJson(map);

        ServletUtils.writeHtml(result, response);
    }

    /**
     * 添加商家服务工具信息操作
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addToolDo")
    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_TOOLS_ADD, request, response);
    }

    /**
     * 删除商家服务工具信息操作
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=delToolDo")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_TOOLS_DELETE, request, response);
    }

    /**
     * 获得一个商家服务工具
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=getShopTool")
    public String getShopTool(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        this.getToolsList(request, response);

        TransData<FShopTool> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_TOOLS_GETSHOPTOOL, request, FShopTool.class);
        FShopTool shopTool = respObj.getData();
        request.setAttribute("shopTool", shopTool);
        return "/tools/editCostom";
    }

    /**
     * 商家服务工具排序页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=getToolSortData")
    public String getToolSortData(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        this.getToolsList(request, response);
        ShopUtil.transferShopInfo(request);

        return "/tools/toolSort";
    }

    /**
     * 修改商家服务工具排序
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=updateShopToolSort")
    public void updateShopToolSort(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_TOOLS_UPDATE_TOOL_SORT, request, response);
    }

    /**
     * 获取右侧服务工具列表
     * @param request
     * @param response
     */
    private void getToolsList(HttpServletRequest request, HttpServletResponse response)
    {
        @SuppressWarnings("rawtypes")
        TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_TOOLS_GETSHOPTOOLS, request, List.class);
        @SuppressWarnings("unchecked")
        List<FShopTool> toolList = respObj.getData();
        request.setAttribute("toolList", toolList);
        request.setAttribute("shopId", GMSUtil.getShopIdByWeb(request));
    }

    /**
     * 服务工具状态
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=statusIndex")
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
        this.getEntityInfo(request);
        GMSUtil.getWebUrlByAuthorityId(request, "12");
        request.setAttribute("pageFlag", "tool");
        return "tools/toolStatus";
    }

    @SuppressWarnings("unchecked")
    public static void getEntityInfo(HttpServletRequest request)
    {
        ShopLoginInfo shopInfo = GMSUtil.getShopLoginInfoByWeb(request);
        String entityId = "";
        if ("Y".equals(shopInfo.getShopAndUserInfo().getUserIsShopAccount()))
        {
            request.setAttribute("relateType", "E");
            request.setAttribute("dataType", "MS");
            @SuppressWarnings("rawtypes")
            TransData<PageModel> erespObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_RELATION_PAGE, request, PageModel.class);
            PageModel<FShopEntityInfo> entityInfoList = erespObj.getData();
            List<FShopEntityInfo> result = entityInfoList.getResult();
            if (CollectionUtils.isNotEmpty(result))
            {
                entityId = result.get(0).getShopEntityId();
            }
            request.setAttribute("isEntity", false);
            request.setAttribute("entityList", result);
        }
        else
        {
            entityId = shopInfo.getShopAndUserInfo().getUserShopEntityId();
            request.setAttribute("isEntity", true);
            request.setAttribute("entityId", entityId);
        }
        request.setAttribute("serverTime", GMSServiceUtil.getDBTimeByWeb(request).getTime());
        request.setAttribute("shopId", shopInfo.getShopAndUserInfo().getShopId());
    }
}
