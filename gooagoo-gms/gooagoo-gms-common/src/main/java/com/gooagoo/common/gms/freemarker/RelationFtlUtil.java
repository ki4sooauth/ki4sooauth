package com.gooagoo.common.gms.freemarker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.constants.RelationConstaints;
import com.gooagoo.common.gms.constants.TemplateConstant;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.view.gms.common.FNode;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.gooagoo.view.gms.shopinfo.GmsLoginInfo;

public class RelationFtlUtil
{
    /**
     * 获取关联tree页传入参数名集合
     * 
     * @return
     */
    public static List<String> getRelationTreeParaNames()
    {
        List<String> paras = new ArrayList<String>();
        paras.add("relateType");
        paras.add("selectType");
        paras.add("ids");
        paras.add("callback");
        paras.add("dataType");
        paras.add("rootId");
        return paras;
    }

    /**
     * 获取关联tab头页传入参数名集合
     * 
     * @return
     */
    public static List<String> getRelationTabParaNames()
    {
        List<String> paras = new ArrayList<String>();
        paras.add("marketingId");
        paras.add("relateType");
        paras.add("tabType");
        paras.add("selectType");
        paras.add("dataType");
        paras.add("activityId");
        paras.add("entityId");
        paras.add("channelCode");
        paras.add("callback");
        return paras;
    }

    /**
     * 获取关联tab数据列表页传入参数名集合
     * 
     * @return
     */
    public static List<String> getRelationTabDataParaNames()
    {
        List<String> paras = new ArrayList<String>();
        paras.add("relateType");
        paras.add("selectType");
        paras.add("marketingId");
        paras.add("contentType");
        paras.add("cmsContentType");
        paras.add("channelType");
        paras.add("fname");
        paras.add("ftime");
        paras.add("fbrandName");
        paras.add("fcategoryLeafName");
        paras.add("fbrandId");
        paras.add("fcategoryLeafId");
        paras.add("ftype");
        paras.add("entityId");
        paras.add("shopEntityId");
        return paras;
    }

    /**
     * 根据关联类型向map中放入其所需相关参数(Tab页)
     * 
     * @param relateType
     * @param root
     */
    public static void putRelationTabDataParas(HttpServletRequest request, String relateType, Map<String, Object> root)
    {
        // 获取关联的活动内容页面所需的参数
        if (RelationConstaints.RELATION_ACTIVITY_CONTENT.equals(relateType))
        {
            putChannelDataParas(request, root);
        }
        // 获取关联的商品、品牌页面所需的参数
        else if (RelationConstaints.RELATION_GOODS.equals(relateType) || RelationConstaints.RELATION_BRAND.equals(relateType))
        {
            putShopEntityDataParas(request, root);
        }
    }

    /**
     * 根据关联类型向map中放入其所需相关参数(Tab页)
     * 
     * @param relateType
     * @param root
     */
    public static void putChannelDataParas(HttpServletRequest request, Map<String, Object> root)
    {
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");
        String contentType = ServletRequestUtils.getStringParameter(request, "contentType", "");

        TransData<List> respObj1 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_ACTIVITYCONTENT_FORM, request, List.class);
        List<FNode> channels = respObj1.getData();
        if (channels != null && channels.size() > 0)
        {
            root.put("channels", channels);
            if (StringUtils.hasText(channelCode))
            {
                if (!StringUtils.hasText(contentType))
                {
                    contentType = channelCode;
                }
            }
        }
        root.put("channelCode", channelCode);
        root.put("contentType", contentType);
        request.setAttribute("channelCode", channelCode);
        request.setAttribute("contentType", contentType);
    }

    /**
     * 根据关联类型向map中放入其所需相关参数(Tab页)
     * 
     * @param relateType
     * @param root
     */
    public static void putShopEntityDataParas(HttpServletRequest request, Map<String, Object> root)
    {
        String entityId = ServletRequestUtils.getStringParameter(request, "entityId", "");
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        PageModel<FShopEntityInfo> pModel = respObj.getData();
        if (pModel != null && pModel.getCount() > 0)
        {
            root.put("shopEntityList", pModel.getResult());
            //            if (StringUtils.hasText(entityId))
            //            {
            //                if (!StringUtils.hasText(shopEntityId))
            //                {
            //                    shopEntityId = entityId;
            //                }
            //            }
            //            else
            //            {
            //            if (!StringUtils.hasText(shopEntityId))
            //            {
            //                shopEntityId = pModel.getResult().get(0).getShopEntityId();
            //            }
            //            }
        }
        if (StringUtils.hasText(shopEntityId))
        {
            entityId = shopEntityId;
        }
        root.put("entityId", entityId);
        root.put("shopEntityId", shopEntityId);
        request.setAttribute("entityId", entityId);
        request.setAttribute("shopEntityId", shopEntityId);
    }

    /**
     * 根据关联类型向map中放入其所需相关参数(Tab页)
     * 
     * @param relateType
     * @param root
     */
    public static void putRelationTreeDataParas(HttpServletRequest request, String relateType, Map<String, Object> root)
    {

        if (RelationConstaints.RELATION_POSITION.equals(relateType) || RelationConstaints.RELATION_CATEGORY.equals(relateType))
        {
            putShopEntityDataParas(request, root);
        }
    }

    /**
     * 获取标签头模板所需要的参数
     * 
     * @param request
     * @return
     */
    public static Map<String, Object> getRelationTabParaMap(HttpServletRequest request)
    {
        Map<String, Object> root = new HashMap<String, Object>();
        // 获取模板默认参数
        GMSFtlUtil.putDefaultRequestParasToMap(request, root);
        // 获取指定的从页面传过来的参数
        putRequestParas(request, getRelationTabParaNames(), root);

        String relateType = ServletRequestUtils.getStringParameter(request, "relateType", "");
        Map<String, String> tabList = RelationFtlUtil.getTabNameList(relateType, request);
        if (tabList == null)
        {
            tabList = new TreeMap<String, String>();
        }
        root.put("tabMap", tabList);

        return root;
    }

    /**
     * 获取标签数据模板所需要的参数
     * 
     * @param request
     * @return
     */
    public static Map<String, Object> getRelationTabDataParaMap(HttpServletRequest request)
    {
        Map<String, Object> root = new HashMap<String, Object>();

        // 获取模板默认参数
        GMSFtlUtil.putDefaultRequestParasToMap(request, root);
        // 获取指定的从页面传过来的参数
        putRequestParas(request, getRelationTabDataParaNames(), root);

        String relateType = ServletRequestUtils.getStringParameter(request, "relateType", "");
        // 获取关联类型页面各自所需的参数
        RelationFtlUtil.putRelationTabDataParas(request, relateType, root);

        return root;
    }

    /**
     * 将request中的指定参数值放入map中（callback默认值dealRelations，selectType默认值S）
     * 
     * @param request
     * @param paraNameList
     *            指定参数名称集合
     * @param root
     *            map
     */
    public static void putRequestParas(HttpServletRequest request, List<String> paraNameList, Map<String, Object> root)
    {
        if (paraNameList == null)
        {
            return;
        }
        for (Iterator<String> iterator = paraNameList.iterator(); iterator.hasNext();)
        {
            String defaultValue = "";
            String para = iterator.next();
            if ("callback".equals(para))
            {
                defaultValue = "dealRelations";
            }
            else if ("selectType".equals(para))
            {
                defaultValue = "S";
            }
            Object value = request.getAttribute(para);
            if (value == null)
            {
                value = ServletRequestUtils.getStringParameter(request, para, defaultValue);
            }
            root.put(para, value);
        }
    }

    /**
     * 获取关联标签数据模板文件名
     * 
     * @param relateType
     * @return
     */
    public static String getRelationTabDataFtlName(String relateType)
    {
        if (!StringUtils.hasText(relateType))
        {
            return null;
        }
        return TemplateConstant.FTL_FILE_RELATION_TAB_DATA_PREFIX + relateType + TemplateConstant.FTL_FILE_SUFFIX;
    }

    /**
     * 获取标签名称集合
     * 
     * @param relateType
     * @param request
     * @return
     */
    public static Map<String, String> getTabNameList(String relateType, HttpServletRequest request)
    {
        Map<String, String> map = new TreeMap<String, String>();
        char[] types = relateType.toCharArray();
        if (types == null || types.length < 1)
        {
            return map;
        }
        for (int i = 0; i < types.length; i++)
        {
            map.put(String.valueOf(types[i]), getRelateTypeName(String.valueOf(types[i]), request));
        }
        return map;
    }

    /**
     * 
     * @param type
     *            A-活动,B-品牌,C-优惠凭证,D-会员等级,E-实体店,F-服务工具,G-商品,H-事件,I-区域,J-品类,K-
     *            活动内容,L-服务转发器,O-CMS栏目与文章
     * @return
     */
    public static String getRelateTypeName(String type, HttpServletRequest request)
    {
        String name = type;
        if (RelationConstaints.RELATION_ACTIVITY.equals(type))
        {
            name = "活动";
        }
        else if (RelationConstaints.RELATION_BRAND.equals(type))
        {
            name = "品牌";
        }
        else if (RelationConstaints.RELATION_COUPON.equals(type))
        {
            name = "优惠凭证";
        }
        else if (RelationConstaints.RELATION_CARD.equals(type))
        {
            name = "会员等级";
        }
        else if (RelationConstaints.RELATION_ENTITY.equals(type))
        {
            name = "实体店";
        }
        else if (RelationConstaints.RELATION_TOOL.equals(type))
        {
            name = "服务工具";
        }
        else if (RelationConstaints.RELATION_GOODS.equals(type))
        {
            // 获取名称（商品/菜品）
            GmsLoginInfo info = GMSUtil.getGmsLoginInfoByWeb(request);
            String menuName = info.getWordNames().get("gmse001");
            if (StringUtils.hasText(menuName))
            {
                name = menuName;
            }
            else
            {
                name = "商品";
            }

        }
        else if (RelationConstaints.RELATION_EVENT.equals(type))
        {
            name = "事件";
        }
        else if (RelationConstaints.RELATION_POSITION.equals(type))
        {
            name = "区域";
        }
        else if (RelationConstaints.RELATION_CATEGORY.equals(type))
        {
            name = "品类";
        }
        else if (RelationConstaints.RELATION_ACTIVITY_CONTENT.equals(type))
        {
            name = "活动内容";
        }
        else if (RelationConstaints.RELATION_TRANSPC_INFO.equals(type))
        {
            name = "服务转发器";
        }
        else if (RelationConstaints.RELATION_CRYOUT.equals(type))
        {
            name = "吆喝";
        }
        else if (RelationConstaints.RELATION_NOTICE.equals(type))
        {
            name = "通知";
        }
        else if (RelationConstaints.RELATION_CMS_CHANNELANDARTICEL.equals(type))
        {
            name = "CMS栏目与文章";
        }
        return name;
    }
}
