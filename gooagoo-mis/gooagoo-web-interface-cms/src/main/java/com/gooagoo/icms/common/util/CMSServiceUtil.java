package com.gooagoo.icms.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UrlUtils;
import com.gooaoo.view.common.ZTreeNode;

public class CMSServiceUtil
{
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
            mobileHtml = webHtml.replace(replaceHtml, "<a href='" + UrlUtils.getActiveUrl(id, marketingId) + "'> ");
        }
        else if ("G".equals(type))
        {
            mobileHtml = webHtml.replace(replaceHtml, "<a href='#localcmd:type=goods|id=" + id + "|shopid=" + shopId + "|url=" + UrlUtils.getGoodsUrl(id, marketingId) + "'> ");
        }
        else if ("C".equals(type))
        {
            mobileHtml = webHtml.replace(replaceHtml, "<a href='#localcmd:type=voucher|id=" + id + "|shopid=" + shopId + "|url=" + UrlUtils.getCouponUrl(id, marketingId) + "'> ");
        }
        mobileHtml = trimHtmlTag(mobileHtml);
        return mobileHtml;
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
}
