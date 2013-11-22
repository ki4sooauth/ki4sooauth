package com.gooagoo.gshopinfo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.gms.utils.ShopUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.gshopinfo.util.ExcelOperateUtil;
import com.gooagoo.view.gms.common.GAjax;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.common.ZTreeNode;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.gooagoo.view.gms.shopinfo.FShopPosition;
import com.gooagoo.view.gms.shopinfo.GmsLoginInfo;
import com.gooagoo.view.gms.shopinfo.PositionInfo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/position")
public class ShopPositionAction extends BaseAction
{

    /**
     * 跳转位置管理首页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ShopUtil.transferShopInfo(request);
        GmsLoginInfo gmsLoginInfoByWeb = GMSUtil.getGmsLoginInfoByWeb(request);
        request.setAttribute("gmsLoginInfo", gmsLoginInfoByWeb);
        return "position/position_list";
    }

    /**
     * 跳转编辑页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=form")
    public String form(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String positionId = ServletRequestUtils.getStringParameter(request, "positionId", "");
        String parentPositionId = ServletRequestUtils.getStringParameter(request, "parentPositionId", "");
        String parentPositionName = ServletRequestUtils.getStringParameter(request, "parentPositionName", "");
        parentPositionName = new String(parentPositionName.getBytes("ISO-8859-1"), "UTF-8");
        FShopPosition position = new FShopPosition();
        position.setParentPositionId(parentPositionId);
        position.setParentPositionName(parentPositionName);
        if (StringUtils.hasText(positionId))
        {
            TransData<FShopPosition> transData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SHOP_GET_POSITION, request, FShopPosition.class);
            position = transData.getData();
        }
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData2 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FShopEntityInfo> pageModel = transData2.getData();
        ShopUtil.transferShopInfo(request);
        request.setAttribute("entityList", pageModel.getResult());
        request.setAttribute("position", position);
        return "position/position_list";
    }

    /**
     * 获取位置和实体店
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=detail")
    public void detail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String positionId = ServletRequestUtils.getStringParameter(request, "positionId", "");
        String parentPositionId = ServletRequestUtils.getStringParameter(request, "parentPositionId", "");
        String parentPositionName = ServletRequestUtils.getStringParameter(request, "parentPositionName", "");
        parentPositionName = new String(parentPositionName.getBytes("ISO-8859-1"), "UTF-8");
        FShopPosition position = new FShopPosition();
        position.setParentPositionId(parentPositionId);
        position.setParentPositionName(parentPositionName);
        if (StringUtils.hasText(positionId))
        {
            TransData<FShopPosition> transData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SHOP_GET_POSITION, request, FShopPosition.class);
            position = transData.getData();
        }
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData2 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FShopEntityInfo> pageModel = transData2.getData();
        ShopUtil.transferShopInfo(request);
        GmsLoginInfo gmsLoginInfo = GMSUtil.getGmsLoginInfoByWeb(request);
        request.setAttribute("gmsLoginInfo", gmsLoginInfo);
        PositionInfo positionInfo = new PositionInfo();
        positionInfo.setfShopPosition(position);
        //TODO 需要修改
        try
        {
            positionInfo.setPageFShopEntityInfo(pageModel);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        String result = new Gson().toJson(positionInfo);
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 询位置信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=getPositionZtree")
    public void getPositionZtree(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<List> transData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SHOP_POSITION_ZTREE, request, List.class);
        @SuppressWarnings("unchecked")
        List<ZTreeNode> nodes = transData.getData();
        ServletUtils.writeHtml(new Gson().toJson(nodes), response);
    }

    /**
     * 分页查询位置信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=saveOrUpdate")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String positionId = ServletRequestUtils.getStringParameter(request, "positionId", "");
        if (StringUtils.hasText(positionId))
        {
            GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_UPDATE_POSITION, request, response);
        }
        else
        {
            GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_ADD_POSITION, request, response);
        }

    }

    /**
     * 分页查询位置信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_DELETE_POSITION, request, response);
    }
    
    
    /**
     * 跳转位置批量导入页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=toImportPosition")
    public String toImportPosition(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	return "position/import_position";
    }
    
    
    /**
     * 跳转位置批量导入页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=importPosition")
    public void importPosition(HttpServletRequest request, HttpServletResponse response) throws Exception
    {   
    	List<FShopPosition> fShopPositions = null;
    	String msg = "";
		try {
			fShopPositions = ExcelOperateUtil.reportImport(request, "filename");
		} catch (Exception e) {
			msg= e.getMessage();
		}
		if(CollectionUtils.isEmpty(fShopPositions)){
			GAjax rv = new GAjax(false, msg);
			ServletUtils.writeHtml(new Gson().toJson(rv), response);
			return;
		}
    	String json = new Gson().toJson(fShopPositions);
    	request.setAttribute("fShopPositions", json);
    	request.setAttribute(GMSConstant.ESCAPE_STRING_TYPE_KEY, "N");
    	GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_IMPORTP_POSITIONS, request, response);
    }

}
