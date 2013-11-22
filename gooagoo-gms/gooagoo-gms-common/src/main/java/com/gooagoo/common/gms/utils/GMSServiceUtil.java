package com.gooagoo.common.gms.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.cache.GmsConfigCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.view.gms.common.FFullCalendar;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.common.ZTreeNode;
import com.gooagoo.view.gms.good.FGoods;
import com.gooagoo.view.gms.good.FGoodsBrand;
import com.gooagoo.view.gms.marketing.FActivity;
import com.gooagoo.view.gms.member.FMemberFeature;
import com.gooagoo.view.gms.rule.FActionAttribute;
import com.gooagoo.view.gms.rule.FHistoryCondition;
import com.gooagoo.view.gms.rule.FNaturalAttribute;
import com.gooagoo.view.gms.rule.FRuleCondition;
import com.gooagoo.view.gms.shopinfo.FShopAuthority;
import com.gooagoo.view.gms.shopinfo.GmsLoginInfo;
import com.google.gson.Gson;

public class GMSServiceUtil
{
    /**
     * 无权限时系统默认跳转页
     * @param request
     * @return
     */
    public static String getDefaultDirectUrlByNoAuth()
    {
        String url = GmsConfigCache.get("no_auth_redirect_url");
        if (!StringUtils.hasText(url))
        {
            url = null;
        }
        return url;
    }

    /**
     * 获取初始化的日历对象
     * 
     * @param request
     * @return
     */
    public static FFullCalendar getFFullCalendar(HttpServletRequest request)
    {
        FFullCalendar fc = new FFullCalendar();
        fc.getDayNames().add("周日");
        fc.getDayNames().add("周一");
        fc.getDayNames().add("周二");
        fc.getDayNames().add("周三");
        fc.getDayNames().add("周四");
        fc.getDayNames().add("周五");
        fc.getDayNames().add("周六");
        fc.getDayNamesShort().add("周日");
        fc.getDayNamesShort().add("周一");
        fc.getDayNamesShort().add("周二");
        fc.getDayNamesShort().add("周三");
        fc.getDayNamesShort().add("周四");
        fc.getDayNamesShort().add("周五");
        fc.getDayNamesShort().add("周六");
        fc.getButtonText().put("today", "今天");
        fc.getTitleFormat().put("month", "yyyy年M月");
        return fc;
    }

    /**
     * 获取活动日历的活动数据
     * 
     * @param activeList
     * @return
     */
    public static List<Map<String, String>> getCalendarData(List<FActivity> activeList)
    {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        if (activeList == null)
        {
            return list;
        }
        for (Iterator<FActivity> iterator = activeList.iterator(); iterator.hasNext();)
        {
            FActivity fActivity = iterator.next();
            Map<String, String> m = new HashMap<String, String>();
            m.put("name", fActivity.getActivityName());
            m.put("start", TimeUtils.convertDateToString(fActivity.getStartTime(), "yyyy-MM-dd"));
            m.put("end", TimeUtils.convertDateToString(fActivity.getEndTime(), "yyyy-MM-dd"));
            list.add(m);
        }
        return list;
    }

    /**
     * 获取对象访问地址
     * 
     * @param type
     *            [A-活动，E-事件，C-优惠凭证，G-商品]
     * @param id
     *            对象id
     * @param source
     *            [M-手机端，W-网站端] 见GMSConstant.INFO_SOURCE_WEB
     * @return
     * @throws Exception
     */
    public static String getVisitUrl(String type, String id, String marketingId) throws Exception
    {
        String url = "";
        if ("A".equals(type))
        {
            url = UrlUtils.getActiveUrl(id, marketingId);
        }
        else if ("E".equals(type))
        {
            url = UrlUtils.getEventUrl(id);
        }
        else if ("C".equals(type))
        {
            url = UrlUtils.getCouponUrl(id, marketingId);
        }
        else if ("G".equals(type))
        {
            url = UrlUtils.getGoodsUrl(id, marketingId);
        }
        return url;
    }

    /**
     * 过滤html中的标签<..>(不包括a标签)
     * 
     * @param html
     * @return
     */
    public static String trimHtmlTag(String html)
    {
        String content = html;
        String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
                                                                                                 // }
        String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
                                                                                              // }
        String regEx_html = "<[B-Zb-z]+[^>]*>|</[B-Zb-z]+[^>]*>|<[B-Zb-z]+[^>]*/>"; // 定义HTML标签的正则表达式

        java.util.regex.Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        java.util.regex.Matcher m_script = p_script.matcher(content);
        content = m_script.replaceAll(""); // 过滤script标签

        java.util.regex.Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        java.util.regex.Matcher m_style = p_style.matcher(content);
        content = m_style.replaceAll(""); // 过滤style标签

        java.util.regex.Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        java.util.regex.Matcher m_html = p_html.matcher(content);
        content = m_html.replaceAll(""); // 过滤html标签

        return content;
    }

    /**
     * 清空ZTreeNode中的click事件
     * 
     * @param treeList
     */
    public static void clearZtreeNodeClick(List<ZTreeNode> treeList)
    {
        if (treeList == null || treeList.size() < 1)
        {
            return;
        }
        for (Iterator<ZTreeNode> iterator = treeList.iterator(); iterator.hasNext();)
        {
            ZTreeNode zTreeNode = iterator.next();
            zTreeNode.setClick(null);
        }
    }

    /**
     * 更新指定pId的ZTreeNode中的pId
     * 
     * @param treeList
     */
    public static void updateZtreeNodePId(List<ZTreeNode> treeList, String oldPId, String newPId)
    {
        if (treeList == null || treeList.size() < 1)
        {
            return;
        }
        if (oldPId == null)
        {
            oldPId = "";
        }
        for (Iterator<ZTreeNode> iterator = treeList.iterator(); iterator.hasNext();)
        {
            ZTreeNode zTreeNode = iterator.next();
            if (oldPId.equals(zTreeNode.getpId()))
            {
                zTreeNode.setpId(newPId);
            }
        }
    }

    /**
     * 移除树中ID重复的节点
     * 
     * @param treeList
     * @return
     */
    public static List<ZTreeNode> removeTreeDuplicateId(List<ZTreeNode> treeList)
    {
        if (treeList == null || treeList.size() < 1)
        {
            return treeList;
        }
        List<ZTreeNode> etreeNode = new ArrayList<ZTreeNode>();
        Map<String, ZTreeNode> treeMap = new HashMap<String, ZTreeNode>();
        for (Iterator<ZTreeNode> iterator = treeList.iterator(); iterator.hasNext();)
        {
            ZTreeNode zTreeNode = iterator.next();
            if (!treeMap.containsKey(zTreeNode.getId()))
            {
                etreeNode.add(zTreeNode);
            }

            treeMap.put(zTreeNode.getId(), zTreeNode);

        }
        return etreeNode;
    }

    /**
     * 移除品牌中brand_id 重复的数据
     * 
     * @param pm
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static PageModel removeGoodsBrandDuplicate(PageModel<FGoodsBrand> pm)
    {
        if (pm.getResult() == null && pm.getResult().size() < 1)
        {
            return pm;
        }
        PageModel pml = new PageModel();
        List<FGoodsBrand> fGoodsBrands = new ArrayList<FGoodsBrand>();
        Map<String, FGoodsBrand> map = new HashMap<String, FGoodsBrand>();
        for (Iterator<FGoodsBrand> iterator = pm.getResult().iterator(); iterator.hasNext();)
        {
            FGoodsBrand type = iterator.next();
            if (!map.containsKey(type.getBrandId()))
            {
                fGoodsBrands.add(type);
            }
            map.put(type.getBrandId(), type);
        }
        pml.setCount(pm.getCount());
        pml.setPageIndex(pm.getPageIndex());
        pml.setPageSize(pm.getPageSize());
        pml.setResult(fGoodsBrands);
        return pml;
    }

    /**
     * 移除商品中单品序列号重复的数据
     * 
     * @param pm
     * @return
     */
    public static PageModel<FGoods> removeGoodsDuplicate(PageModel<FGoods> pm)
    {
        if (pm.getResult() == null && pm.getResult().size() < 1)
        {
            return pm;
        }
        PageModel<FGoods> pml = new PageModel<FGoods>();
        List<FGoods> fGoods = new ArrayList<FGoods>();
        Map<String, FGoods> map = new HashMap<String, FGoods>();
        for (Iterator<FGoods> iterator = pm.getResult().iterator(); iterator.hasNext();)
        {
            FGoods type = iterator.next();
            if (!map.containsKey(type.getItemSerial()))
            {
                fGoods.add(type);
            }
            map.put(type.getItemSerial(), type);
        }
        pml.setCount(pm.getCount());
        pml.setPageIndex(pm.getPageIndex());
        pml.setPageSize(pm.getPageSize());
        pml.setResult(fGoods);
        return pml;
    }

    /**
     * 设置ZTreeNode中的click事件 selectNode(type,id,name);
     * 
     * @param treeList
     * @param type
     */
    public static void setZtreeNodeClick(String type, List<ZTreeNode> treeList)
    {
        if (treeList == null || treeList.size() < 1)
        {
            return;
        }
        if (!StringUtils.hasText(type))
        {
            type = "";
        }
        for (Iterator<ZTreeNode> iterator = treeList.iterator(); iterator.hasNext();)
        {
            ZTreeNode zTreeNode = iterator.next();
            zTreeNode.setClick("selectNode('" + type + "','" + zTreeNode.getId() + "','" + zTreeNode.getName() + "');");
        }
    }

    /**
     * 修改吆喝通知关联的手机端链接地址
     * 
     * @param type
     *            关联类型 （A-活动，G-商品，C-优惠凭证）
     * @param id
     *            关联id
     * @param webHtml
     * @param marketingId
     * @return
     * @throws Exception
     */
    public static String getMobileHtml(String type, String id, String shopId, String webHtml, String marketingId) throws Exception
    {
        if (!StringUtils.hasText(webHtml))
        {
            return webHtml;
        }
        String mobileHtml = webHtml;

        // <a id="marketingLink" href="http://merchant.gooagoo.com/wm/info?para=0dd4..4" class="marketingLink"> 沃尔玛100元代金券</a>
        String webRelationStart = "<a id=\"marketingLink\" href=\"";
        String webRelationEnd = "\" class=\"marketingLink\">";
        int linkIndex = mobileHtml.indexOf(webRelationStart);
        if (linkIndex < 0)
        {
            mobileHtml = trimHtmlTag(mobileHtml);
            return mobileHtml;
        }

        int urlStart = linkIndex + webRelationStart.length();
        int urlEnd = mobileHtml.indexOf(webRelationEnd);
        if (urlEnd < urlStart)
        {
            GooagooLog.warn("吆喝通知关联标签不符合规则,class='marketingLink'在id='marketingLink'之前或者不存在,html=" + mobileHtml);
            mobileHtml = trimHtmlTag(mobileHtml);
            return mobileHtml;
        }

        String href = mobileHtml.substring(urlStart, urlEnd);
        String replaceHtml = webRelationStart + href + webRelationEnd;

        if ("A".equals(type))
        {
            mobileHtml = webHtml.replace(replaceHtml, "<a href='" + UrlUtils.getActiveMobileUrl(id, marketingId) + "'> ");
        }
        else if ("G".equals(type))
        {
            mobileHtml = webHtml.replace(replaceHtml, "<a href='#localcmd:type=goods|id=" + id + "|shopid=" + shopId + "|url=" + UrlUtils.getGoodsMobileUrl(id, marketingId) + "'> ");
        }
        else if ("C".equals(type))
        {
            mobileHtml = webHtml.replace(replaceHtml, "<a href='#localcmd:type=voucher|id=" + id + "|shopid=" + shopId + "|url=" + UrlUtils.getCouponMobileUrl(id, marketingId) + "'> ");
        }
        mobileHtml = trimHtmlTag(mobileHtml);
        return mobileHtml;
    }

    /**
     * 获取条件json字符串
     * 
     * @param request
     * @return
     * @throws Exception
     */
    public static FRuleCondition getFRuleCondition(HttpServletRequest request) throws Exception
    {
        FRuleCondition condition = new FRuleCondition();

        String actionTypes = ServletRequestUtils.getStringParameter(request, "actionTypes", null);
        String actionType = ServletRequestUtils.getStringParameter(request, "actionType", null);
        String crowdId = ServletRequestUtils.getStringParameter(request, "crowdId", null);
        String crowdName = ServletRequestUtils.getStringParameter(request, "crowdName", null);
        String[] features = request.getParameterValues("feature");
        List<FActionAttribute> list = null;
        FActionAttribute actionAttribute = null;
        FNaturalAttribute naturalAttribute = null;
        if (actionTypes != "" && actionTypes != null)
        {
            list = new ArrayList<FActionAttribute>();
            String[] actions = actionTypes.split(",");
            FActionAttribute temp = new FActionAttribute();
            for (int i = 0; i < actions.length; i++)
            {
                temp = RULEServletUtils.objectMethod(FActionAttribute.class, "H", actions[i], request);
                if (temp != null)
                {
                    temp.setActionType(actions[i]);
                    list.add(temp);
                }
            }
        }
        if (actionType != null)
        {
            actionAttribute = RULEServletUtils.objectMethod(FActionAttribute.class, "C", actionType, request);
            actionAttribute.setActionType(actionType);
        }
        naturalAttribute = ServletUtils.objectMethod(FNaturalAttribute.class, request);

        String jsonStr = new Gson().toJson(naturalAttribute);

        if (!org.apache.commons.lang.StringUtils.isBlank(crowdId) || jsonStr.contains(":") || list != null)
        {
            if (actionAttribute == null)
            {
                condition.setConditionType("0");
            }
            else
            {
                condition.setConditionType("2");
            }
        }
        else
        {
            if (actionAttribute != null)
            {
                condition.setConditionType("1");
            }
            else
            {
                condition.setConditionType("0");
            }
        }
        //获取会员特征
        List<FMemberFeature> memberFeatureList = new ArrayList<FMemberFeature>();
        List<String> featureList = new ArrayList<String>(CollectionUtils.arrayToList(features));
        for (int i = 0; i < featureList.size(); i++)
        {
            if (!StringUtils.hasText(featureList.get(i)))
            {
                featureList.remove(i);
                i--;
            }
            else
            {
                FMemberFeature fMemberFeature = new FMemberFeature();
                String[] obj = featureList.get(i).split("_");
                fMemberFeature.setTypeCode(obj[0]);
                fMemberFeature.setEnumValue(obj[1]);
                memberFeatureList.add(fMemberFeature);
            }
        }
        naturalAttribute.setMemberFeatureList(memberFeatureList);

        FHistoryCondition historyCondition = new FHistoryCondition();
        historyCondition.setNaturalAttribute(naturalAttribute);
        historyCondition.setList(list);
        historyCondition.setCrowdId(crowdId);
        historyCondition.setCrowdName(crowdName);

        condition.setHistoryCondition(historyCondition);
        condition.setActionAttribute(actionAttribute);

        return condition;
    }

    /**
     * 获取消费会员等统计数据
     * 
     * @param request
     * @return 0-总消费人数,1-总会员人数,2-总非会员消费次数,3-总会员消费次数,4-总潜在会员人数
     */
    @SuppressWarnings("unchecked")
    public static long[] getLeftStatusData(HttpServletRequest request)
    {
        String shopInfo = GMSUtil.getShopIdByWeb(request);
        request.setAttribute("shopId", shopInfo);
        @SuppressWarnings("rawtypes")
        TransData<List> transfer = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_GET_LEFT_DATA, request, List.class);
        List<Long> listData = transfer.getData();
        long sum1 = 0;// 总消费人数
        long sum2 = 0;// 总会员人数
        long sum3 = 0;// 总非会员消费次数
        long sum4 = 0;// 总会员消费次数
        if (!CollectionUtils.isEmpty(listData))
        {
            sum1 = listData.get(0);// 总消费人数
            sum2 = listData.get(1);// 总会员人数
            sum3 = listData.get(3);// 总非会员消费次数
            sum4 = listData.get(2);// 总会员消费次数
        }
        else
        {
            GooagooLog.warn("gms获取右则菜单统计数据错误");
        }
        long[] data = { sum1, sum2, sum3, sum4 };
        return data;
    }

    public static GmsLoginInfo convertCasObjToGmsLoginInfo(com.gooagoo.entity.casclient.shop.ShopLoginInfo shopLoginInfo)
    {
        if (shopLoginInfo == null)
        {
            return null;
        }
        GmsLoginInfo gmsLoginInfo = new GmsLoginInfo();
        gmsLoginInfo.setWordNames(shopLoginInfo.getWordNames());
        gmsLoginInfo.setAllAuthList(convertToFShopAuthorityList(shopLoginInfo.getShopAuthList(), false));
        gmsLoginInfo.setAuthList(convertToFShopAuthorityList(shopLoginInfo.getShopAuthList(), true));
        gmsLoginInfo.setEmail(shopLoginInfo.getShopAndUserInfo().getShopEmail());
        gmsLoginInfo.setHeadPic(shopLoginInfo.getShopAndUserInfo().getShopLogo2());
        gmsLoginInfo.setNickName(shopLoginInfo.getShopAndUserInfo().getShopNickName());
        gmsLoginInfo.setShopEntityId(shopLoginInfo.getShopAndUserInfo().getUserShopEntityId());
        gmsLoginInfo.setShopId(shopLoginInfo.getShopAndUserInfo().getShopId());
        gmsLoginInfo.setShopType(shopLoginInfo.getShopAndUserInfo().getShopTypeRoot());
        gmsLoginInfo.setUserId(shopLoginInfo.getShopAndUserInfo().getUserId());
        String userType = "A";
        if ("Y".equals(shopLoginInfo.getShopAndUserInfo().getUserIsShopAccount()))
        {
            userType = "S";
        }
        gmsLoginInfo.setUserType(userType);
        return gmsLoginInfo;
    }

    /**
     * 将ShopUserAuthority转换成FShopAuthority
     * @param shopUserAuthority
     * @param isOnlyUserOwn 是否只获取用户所拥有的权限
     * @return
     */
    public static List<FShopAuthority> convertToFShopAuthorityList(List<com.gooagoo.entity.casclient.shop.ShopAuth> shopUserAuthority, boolean isOnlyUserOwn)
    {
        List<FShopAuthority> authList = new ArrayList<FShopAuthority>();
        for (Iterator<com.gooagoo.entity.casclient.shop.ShopAuth> iterator = shopUserAuthority.iterator(); iterator.hasNext();)
        {
            com.gooagoo.entity.casclient.shop.ShopAuth ua = iterator.next();
            if (isOnlyUserOwn && !ua.isUserOwn())
            {
                continue;
            }
            FShopAuthority sa = new FShopAuthority();
            sa.setAuthorityId(ua.getAuthorityId());
            sa.setAuthorityName(ua.getAuthorityName());
            sa.setLink(ua.getLink());
            sa.setNote(ua.getNote());
            sa.setParentAuthorityId(ua.getParentAuthorityId());
            sa.setUserOwn(ua.isUserOwn());

            authList.add(sa);
        }
        return authList;
    }

    /**
     * 获取单点登录对象Id存值对应的变量名
     * @return
     */
    public static String getCasFitlerUserObjIdConstant()
    {
        return com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJID;
    }

    /**
     * 获取单点登录token存值对应的变量名
     * @return
     */
    public static String getCasFitlerUserTokenConstant()
    {
        return com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_TOKEN;
    }

    /**
     * web端获取uuid
     * @param request
     * @return
     */
    public static String getUUIDByWeb(HttpServletRequest request)
    {
        String id = null;
        TransData<String> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_COMMON_UUID, request, String.class);
        if (respObj != null && respObj.getHead().isSuccess())
        {
            id = respObj.getData();
        }
        return id;
    }

    /**
     * web端获取数据库时间
     * @param request
     * @return
     */
    public static Date getDBTimeByWeb(HttpServletRequest request)
    {
        Date dbTime = null;
        TransData<Date> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_COMMON_DBTIME, request, Date.class);
        if (respObj != null && respObj.getHead().isSuccess())
        {
            dbTime = respObj.getData();
        }
        return dbTime;
    }
}
