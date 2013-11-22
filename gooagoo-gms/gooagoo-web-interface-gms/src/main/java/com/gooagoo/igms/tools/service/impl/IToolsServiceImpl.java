package com.gooagoo.igms.tools.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.shoptool.ServiceToolSortCoreService;
import com.gooagoo.api.business.core.shop.shoptool.ShopToolCoreService;
import com.gooagoo.api.business.query.shop.tool.ToolQueryService;
import com.gooagoo.api.generator.query.base.ShopToolInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopToolListGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.entity.business.shop.tool.ShopToolListBusiness;
import com.gooagoo.entity.generator.base.ShopToolInfo;
import com.gooagoo.entity.generator.base.ShopToolInfoExample;
import com.gooagoo.entity.generator.shop.ServiceToolSort;
import com.gooagoo.entity.generator.shop.ShopToolList;
import com.gooagoo.entity.generator.shop.ShopToolListExample;
import com.gooagoo.entity.generator.shop.ShopToolListExample.Criteria;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.tools.service.IToolsService;
import com.gooagoo.view.gms.tools.FShopTool;
import com.gooagoo.view.gms.tools.FToolInfo;

@Service(value = "toolsService")
public class IToolsServiceImpl implements IToolsService
{
    @Autowired
    private ShopToolListGeneratorQueryService toolListQueryService;
    @Autowired
    private ShopToolInfoGeneratorQueryService shopToolQueryService;
    @Autowired
    private ShopToolCoreService manageShopToolCoreService;
    @Autowired
    private ToolQueryService toolQueryService;
    @Autowired
    private ServiceToolSortCoreService toolSortCoreService;

    @Override
    public TransData<String> add(HttpServletRequest request) throws Exception
    {
        String toolId = ServletRequestUtils.getStringParameter(request, "toolId", "");
        String shopToolListId = StringUtils.getUUID();
        boolean flag = false;
        if (toolId.length() > 0)
        {
            flag = this.manageShopToolCoreService.addSysTool(GmsInterfaceUtil.getShopIdByInterface(request), toolId, shopToolListId);
        }
        return GMSUtil.getBooleanAndExtendResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, shopToolListId, shopToolListId);
    }

    @Override
    public TransData<Object> delete(HttpServletRequest request) throws Exception
    {
        String shopToolId = ServletRequestUtils.getStringParameter(request, "shopToolId", "");
        boolean flag = false;
        if (shopToolId.length() == 32)
        {
            flag = this.manageShopToolCoreService.deleteShopTool(shopToolId);
        }
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, shopToolId);
    }

    @Override
    public TransData<FShopTool> getShopTool(HttpServletRequest request) throws Exception
    {
        String shopToolId = ServletRequestUtils.getStringParameter(request, "id", "");
        boolean flag = false;
        ShopToolList shopToolList = null;
        if (shopToolId.length() == 32)
        {
            shopToolList = this.toolListQueryService.selectByPrimaryKey(shopToolId);
            if (shopToolList != null)
            {
                flag = true;
            }
        }
        if (flag)
        {
            FShopTool shopTool = this.convertToFShopTool(shopToolList);
            return new TransData<FShopTool>(true, MessageConst.GMS_OPERATE_SUCCESS, shopTool, shopToolId);
        }
        else
        {
            return new TransData<FShopTool>(false, MessageConst.GMS_OPERATE_FAIL, null);
        }
    }

    @Override
    public TransData<Object> updateAuth(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        String authority = ServletRequestUtils.getStringParameter(request, "authority", "0");

        boolean flag = false;
        if (id.length() == 32)
        {
            flag = this.manageShopToolCoreService.updateShopToolAuthority(id, authority);
        }
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, id);
    }

    @Override
    public TransData<List<FShopTool>> getShopTools(HttpServletRequest request) throws Exception
    {
        ShopToolListExample example = new ShopToolListExample();
        Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(GmsInterfaceUtil.getShopIdByInterface(request));
        criteria.andIsDelEqualTo(GMSConstant.NO);

        List<ShopToolList> list = this.toolListQueryService.selectByExample(example);

        if (list == null)
        {
            return new TransData<List<FShopTool>>(true, MessageConst.GMS_OPERATE_FAIL, null);
        }
        else
        {
            List<FShopTool> tools = new ArrayList<FShopTool>();
            for (int i = 0; i < list.size(); i++)
            {
                FShopTool tool = this.convertToFShopTool(list.get(i));
                tools.add(tool);
            }
            tools = this.getShopToolsSort(tools);
            return new TransData<List<FShopTool>>(true, MessageConst.GMS_OPERATE_SUCCESS, tools);
        }
    }

    @Override
    public TransData<Map<String, Object>> getTools(HttpServletRequest request) throws Exception
    {
        ShopToolListExample example = new ShopToolListExample();
        Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(GmsInterfaceUtil.getShopIdByInterface(request));
        criteria.andIsDelEqualTo(GMSConstant.NO);

        List<ShopToolList> toolList = this.toolListQueryService.selectByExample(example);

        ShopToolInfoExample shopToolInfoExample = new ShopToolInfoExample();
        com.gooagoo.entity.generator.base.ShopToolInfoExample.Criteria cri = shopToolInfoExample.createCriteria();
        cri.andIsDelEqualTo(GMSConstant.NO);
        List<ShopToolInfo> shopToolInfos = this.shopToolQueryService.selectByExample(shopToolInfoExample);

        if (toolList == null)
        {
            return new TransData<Map<String, Object>>(false, MessageConst.GMS_OPERATE_FAIL, null);
        }
        if (shopToolInfos == null)
        {
            return new TransData<Map<String, Object>>(false, MessageConst.GMS_OPERATE_FAIL, null);
        }

        List<FShopTool> shopTools = new ArrayList<FShopTool>();
        for (int i = 0; i < toolList.size(); i++)
        {
            FShopTool tool = this.convertToFShopTool(toolList.get(i));
            shopTools.add(tool);
        }
        List<FToolInfo> toolInfos = new ArrayList<FToolInfo>();
        for (int i = 0; i < shopToolInfos.size(); i++)
        {
            FToolInfo info = this.convertToolInfo(shopToolInfos.get(i));
            toolInfos.add(info);
        }
        // 去掉已经添加到商家的服务工具
        Map<String, FToolInfo> toolInfoMap = new HashMap<String, FToolInfo>();
        for (FToolInfo toolInfo : toolInfos)
        {
            toolInfoMap.put(toolInfo.getToolId(), toolInfo);
        }
        shopTools = this.getShopToolsSort(shopTools);
        for (FShopTool e : shopTools)
        {
            toolInfoMap.remove(e.getToolId());
        }
        List<FToolInfo> toadd = new ArrayList<FToolInfo>(toolInfoMap.values());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("added", shopTools);
        map.put("toadd", toadd);

        return new TransData<Map<String, Object>>(true, MessageConst.GMS_OPERATE_SUCCESS, map);
    }

    @Override
    @Deprecated
    public TransData<Object> addShopTool(HttpServletRequest request) throws Exception
    {
        String id = StringUtils.getUUID();
        ShopToolList toolList = ServletUtils.objectMethod(ShopToolList.class, request);
        toolList.setShopId(GmsInterfaceUtil.getShopIdByInterface(request));
        toolList.setId(id);
        toolList.setToolId(toolList.getId());
        toolList.setStatus("W");
        toolList.setToolUrl("");
        toolList.setLocalCmd("");
        toolList.setAuthority("");
        // 排序号，需要获取，从库中，这给默认为0
        toolList.setOrderNo(0);
        toolList.setIsDel("N");
        toolList.setCreateTime(new Date());

        boolean flag = this.checkShopToolListOnInsert(toolList);
        if (flag)
        {
            flag = this.manageShopToolCoreService.addCustomTool(toolList);
        }
        TransData<Object> result = GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
        result.setData(id);
        return result;
    }

    @Override
    @Deprecated
    public TransData<Object> delShopTool(HttpServletRequest request) throws Exception
    {
        return this.delete(request);
    }

    @Override
    @Deprecated
    public TransData<Object> updateShopTool(HttpServletRequest request) throws Exception
    {
        ShopToolList shopToolList = ServletUtils.objectMethod(ShopToolList.class, request);
        boolean flag = this.checkShopToolListOnUpdate(shopToolList);
        if (flag)
        {
            flag = this.manageShopToolCoreService.updateCustomTool(shopToolList);
        }
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
    }

    @Override
    @Deprecated
    public TransData<Object> getShopToolsOfShop(HttpServletRequest request) throws Exception
    {
        ShopToolListExample example = new ShopToolListExample();
        Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(GmsInterfaceUtil.getShopIdByInterface(request));
        List<String> values = new ArrayList<String>();
        values.add("D");
        values.add("C");
        criteria.andToolTypeIn(values);

        List<ShopToolList> list = this.toolListQueryService.selectByExample(example);

        if (list == null)
        {
            return new TransData<Object>(false, MessageConst.GMS_OPERATE_FAIL, null);
        }
        else
        {
            List<FShopTool> tools = new ArrayList<FShopTool>();
            for (int i = 0; i < list.size(); i++)
            {
                FShopTool tool = this.convertToFShopTool(list.get(i));
                tools.add(tool);
            }
            tools = this.getShopToolsSort(tools);
            return new TransData<Object>(true, MessageConst.GMS_OPERATE_SUCCESS, tools);
        }
    }

    @Override
    public TransData<Object> updateToolsSort(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        String toolIds = request.getParameter("toolIds");
        String toolTypes = request.getParameter("toolTypes");
        String str[] = toolIds.split(",");
        String type[] = toolTypes.split(",");

        List<ServiceToolSort> list = new ArrayList<ServiceToolSort>();
        for (int i = 0; i < str.length; i++)
        {
            ServiceToolSort shopTool = new ServiceToolSort();
            shopTool.setToolId(str[i]);
            if (type[i].equals("C"))
            {
                shopTool.setToolType("1");
            }
            else
            {
                shopTool.setToolType("0");
            }
            shopTool.setOrderNo(i + 1);
            shopTool.setShopId(shopId);
            shopTool.setCreateTime(new Date());
            list.add(shopTool);
        }

        boolean result = this.toolSortCoreService.addServiceToolSortList(shopId, list);
        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
    }

    /**
     * 排序  先发布，在部署，在等待审核
     * 
     * @param shopTools
     * @return
     */
    private List<FShopTool> getShopToolsSort(List<FShopTool> shopTools)
    {
        List<FShopTool> tempF = new ArrayList<FShopTool>();
        List<FShopTool> tempP = new ArrayList<FShopTool>();
        List<FShopTool> tempS = new ArrayList<FShopTool>();
        for (int i = 0; i < shopTools.size(); i++)
        {
            FShopTool e = shopTools.get(i);
            if (e.getStatus().equals("P"))
            {
                e.setStatus("已发布");
                tempF.add(e);
            }
            else if (e.getStatus().equals("A"))
            {
                e.setStatus("已审核");
                tempP.add(e);
            }
            else if (e.getStatus().equals("W"))
            {
                e.setStatus("待审核");
                tempS.add(e);
            }
        }

        Collections.sort(tempF);
        Collections.sort(tempP);
        Collections.sort(tempS);

        tempF.addAll(tempP);
        tempF.addAll(tempS);

        return tempF;
    }

    private FShopTool convertToFShopTool(ShopToolList shopToolList)
    {
        FShopTool tool = null;
        if (shopToolList != null)
        {
            tool = new FShopTool();
            tool.setShopToolId(shopToolList.getId());
            tool.setShopId(shopToolList.getShopId());
            tool.setToolId(shopToolList.getToolId());
            tool.setToolName(shopToolList.getToolName());
            tool.setToolUrl(shopToolList.getToolUrl());
            tool.setToolIcoFocus(shopToolList.getToolIcoFocus());
            tool.setToolIcoUnfocus(shopToolList.getToolIcoUnfocus());
            tool.setToolType(shopToolList.getToolType());
            tool.setLocalCmd(shopToolList.getLocalCmd());
            tool.setRemark(shopToolList.getRemark());
            tool.setVer(shopToolList.getVer());
            tool.setStatus(shopToolList.getStatus());
            tool.setAuthority(shopToolList.getAuthority());
            tool.setOrderNo(shopToolList.getOrderNo());
        }
        return tool;
    }

    private FToolInfo convertToolInfo(ShopToolInfo info)
    {
        FToolInfo toolInfo = null;
        if (info != null)
        {
            toolInfo = new FToolInfo();
            toolInfo.setToolId(info.getToolId());
            toolInfo.setToolName(info.getToolName());
            toolInfo.setToolUrl(info.getToolUrl());
            toolInfo.setToolIcoFocus(info.getToolIcoFocus());
            toolInfo.setToolIcoUnfocus(info.getToolIcoUnfocus());
            toolInfo.setToolType(info.getToolType());
            toolInfo.setLocalCmd(info.getLocalCmd());
            toolInfo.setVer(info.getVer());
            toolInfo.setRemark(info.getRemark());
        }
        return toolInfo;
    }

    private boolean checkShopToolListOnInsert(ShopToolList tool)
    {
        if (tool == null)
        {
            return false;
        }
        if (tool.getToolName() == null || tool.getToolName().isEmpty() || tool.getToolName().length() > 32)
        {
            return false;
        }
        if (tool.getToolType() == null || (!tool.getToolType().equals("C") && !tool.getToolType().equals("D")))
        {
            return false;
        }
        if (tool.getRemark() == null)
        {
            tool.setRemark("");
        }
        if (tool.getRemark().length() > 255)
        {
            return false;
        }
        if (tool.getVer() == null || tool.getVer().isEmpty() || tool.getVer().length() > 10)
        {
            return false;
        }
        if (tool.getToolIcoFocus() == null || tool.getToolIcoFocus().isEmpty() || tool.getToolIcoFocus().length() > 255)
        {
            return false;
        }
        if (tool.getToolIcoUnfocus() == null || tool.getToolIcoUnfocus().isEmpty() || tool.getToolIcoUnfocus().length() > 255)
        {
            return false;
        }
        return true;
    }

    private boolean checkShopToolListOnUpdate(ShopToolList tool)
    {
        if (tool == null)
        {
            return false;
        }
        if (tool.getId() == null || tool.getId().length() != 32)
        {
            return false;
        }
        if (tool.getToolName() == null || tool.getToolName().isEmpty() || tool.getToolName().length() > 32)
        {
            return false;
        }
        if (tool.getRemark() != null && tool.getRemark().length() > 255)
        {
            return false;
        }
        if (tool.getToolType() == null || (!tool.getToolType().equals("C") && !tool.getToolType().equals("D")))
        {
            return false;
        }
        if (tool.getVer() == null || tool.getVer().isEmpty() || tool.getVer().length() > 10)
        {
            return false;
        }
        if (tool.getToolIcoFocus() == null || tool.getToolIcoFocus().isEmpty() || tool.getToolIcoFocus().length() > 255)
        {
            return false;
        }
        if (tool.getToolIcoUnfocus() == null || tool.getToolIcoUnfocus().isEmpty() || tool.getToolIcoUnfocus().length() > 255)
        {
            return false;
        }
        return true;
    }

    @Override
    public TransData<Map<String, Object>> getSortServiceTool(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        List<ShopToolListBusiness> shopToolList = this.toolQueryService.findSortServiceTool(shopId, null, "N");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("added", shopToolList);
        return new TransData<Map<String, Object>>(true, MessageConst.GMS_OPERATE_SUCCESS, map);
    }
}
