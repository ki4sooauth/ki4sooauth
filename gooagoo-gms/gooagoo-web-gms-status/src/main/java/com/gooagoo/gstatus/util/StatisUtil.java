package com.gooagoo.gstatus.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.gooagoo.cache.GmsConfigCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSServiceUtil;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.gooagoo.view.gms.statistic.StatisticParameters;

public class StatisUtil
{

    private static String baseUrl = null;
    static
    {
        baseUrl = GmsConfigCache.get("statistics_file_url_head");
        if (StringUtils.isBlank(baseUrl))
        {
            GooagooLog.warn("===========从缓存中获取统计数据文件访问头部地址为空");
        }
    }

    @SuppressWarnings("unchecked")
    public static void getEntityInfo(HttpServletRequest request)
    {
        ShopLoginInfo shopInfo = GMSUtil.getShopLoginInfoByWeb(request);
        String entityId = "" ;
        if ("Y".equals(shopInfo.getShopAndUserInfo().getUserIsShopAccount()))
        {
            request.setAttribute("relateType", "E");
            request.setAttribute("dataType", "MS");
            @SuppressWarnings("rawtypes")
            TransData<PageModel> erespObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_RELATION_PAGE, request, PageModel.class);
            PageModel<FShopEntityInfo> entityInfoList = erespObj.getData();
            List<FShopEntityInfo> result = entityInfoList.getResult();
            if(CollectionUtils.isNotEmpty(result)){
            	entityId = result.get(0).getShopEntityId();
            }
            request.setAttribute("isEntity", false);
            request.setAttribute("entityList", result);
        }else{
        	entityId= shopInfo.getShopAndUserInfo().getUserShopEntityId();
        	request.setAttribute("isEntity", true);
        	request.setAttribute("entityId", entityId);
        }
        request.setAttribute("serverTime",GMSServiceUtil.getDBTimeByWeb(request).getTime());
        request.setAttribute("shopId", shopInfo.getShopAndUserInfo().getShopId());
    }

    // 获取拉取文件路径
    public static String getFileUrl(HttpServletRequest request)
    {    
    	String separator = "/";
        String fileUrl = baseUrl+separator;
        try
        {
            StatisticParameters sp = ServletUtils.objectMethod(StatisticParameters.class, request);
            if ("activity".equals(sp.getName()))
            {
                fileUrl += getFolderName(sp.getName()) + separator + sp.getId() + "_" + sp.getUserType() + "_" + sp.getChannel() + "_" + sp.getSource()+ "_"+ sp.getTimeVal();
            }
            else if ("goods".equals(sp.getName()))
            {
                fileUrl += getFolderName(sp.getName()) + separator + sp.getShopIdOrEntityId() + "_" + sp.getId() + "_" + sp.getUserType() + "_" + sp.getChannel() + "_" + sp.getSource()  + "_" + sp.getTimeVal();
            }
            else if ("brand".equals(sp.getName()))
            {
            	  fileUrl += getFolderName(sp.getName()) + separator + sp.getShopIdOrEntityId() + "_" + sp.getId() + "_" + sp.getUserType() + "_" + sp.getChannel() + "_" + sp.getSource()  + "_" + sp.getTimeVal();
            }
            else if ("category".equals(sp.getName()))
            {
            	  fileUrl += getFolderName(sp.getName()) + separator + sp.getShopIdOrEntityId() + "_" + sp.getId() + "_" + sp.getUserType() + "_" + sp.getChannel() + "_" + sp.getSource()  + "_" + sp.getTimeVal();
            }
            else if ("coupon".equals(sp.getName()))
            {
                fileUrl += getFolderName(sp.getName()) + separator + sp.getId() + "_" +sp.getUserType()  + "_" + sp.getChannel() + "_" + sp.getSource()+ "_" + sp.getTimeVal();
            }
            else if ("tool".equals(sp.getName()))
            {
                fileUrl += getFolderName(sp.getName()) + separator + sp.getId() +"_" + sp.getUserType()+ "_" + sp.getTimeVal();
            }
            else if ("cryout".equals(sp.getName()))
            {
                fileUrl += getFolderName(sp.getName()) + separator + sp.getId() + "_" + sp.getUserType() + "_" +sp.getSource() + "_" + sp.getTimeVal();
            }
            else if ("notice".equals(sp.getName()))
            {
                fileUrl += getFolderName(sp.getName()) + separator + sp.getId() + "_" + sp.getUserType() + "_" + sp.getSource() + "_" + sp.getTimeVal();
            }else if("ps".equals(sp.getName())){
            	 fileUrl += getFolderName(sp.getName()) + separator + sp.getId() + "_" + sp.getUserType() + "_" + sp.getTimeVal();
            }else if("pac".equals(sp.getName())){
            	 fileUrl += getFolderName(sp.getName()) + separator + sp.getId() + "_" + sp.getUserType() + "_" + sp.getTimeVal();
            }
            
            fileUrl = fileUrl.replaceAll("\\*", "()").replaceAll("null", "");
            GooagooLog.info("生成的文件路径为："+fileUrl);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取统计文件路径错误", e);
        }
        return fileUrl;
    }
    
    /**
     * 获取文件夹名称
     * @param name
     * @return
     */
    private static String getFolderName(String name){
       String folderName = name; 	
       if("ps".equals(name)){
    	   folderName = "phonetool"; 
       }else if("pac".equals(name)){
    	   folderName = "inquisitive";  
       }else if("tool".equals(name)){
    	   folderName = "tools";  
       }
       return folderName;
    }
    

}
