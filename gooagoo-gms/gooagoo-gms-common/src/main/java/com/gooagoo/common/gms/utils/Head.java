package com.gooagoo.common.gms.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.gooagoo.cache.GmsConfigCache;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.TemplateConstant;
import com.gooagoo.common.gms.freemarker.FreemarkerUtil;
import com.gooagoo.common.gms.freemarker.GMSFtlUtil;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.view.gms.common.FNode;
import com.gooagoo.view.gms.shopinfo.FShopAuthority;
import com.gooagoo.view.gms.shopinfo.GmsLoginInfo;

public class Head
{

    /**
     * 分页内容
     * @param request
     * @param response
     * @return
     */
    public static String getPageContent(HttpServletRequest request, HttpServletResponse response)
    {
        Integer page_cur = (Integer) request.getAttribute("page_cur");
        Integer page_start = (Integer) request.getAttribute("page_start");
        Integer page_end = (Integer) request.getAttribute("page_end");
        if (page_cur == null)
        {
            page_cur = 1;
        }
        if (page_start == null)
        {
            page_start = 1;
        }
        if (page_end == null)
        {
            page_end = 1;
        }

        Map<String, Object> root = new HashMap<String, Object>();
        root.put("page_cur", page_cur);
        root.put("page_start", page_start);
        root.put("page_end", page_end);

        return FreemarkerUtil.getContent(TemplateConstant.FTL_FILE_COMMON_PAGE, root);
    }

    /**
     * 加载左部信息(营销状态)
     * @return
     * @throws IOException 
     */
    public static String getLeftContent2(HttpServletRequest request)
    {
        GmsLoginInfo shopInfo = GMSUtil.getGmsLoginInfoByWeb(request);
        String menuCode = (String) request.getAttribute("leftMenuCode");

        String leftCont = getLeftMenuContent(menuCode, shopInfo);
        return leftCont;
    }

    /**
    * 加载商家营销头部信息
    * @return
     * @throws IOException 
    */
    public static String getSHeadContent(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String headContent = getHeadContent(request, "1");
        return headContent;
    }

    /**
     * 加载CRM头部信息
     * @return
     * @throws IOException 
     */
    public static String getCHeadContent(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String headContent = getHeadContent(request, "2");
        return headContent;
    }

    /**
     * 加载商家营销左部信息
     * @return
     * @throws IOException 
     */
    public static String getSLeftContent(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String leftCont = getLeftContent(request, "1");
        return leftCont;
    }

    /**
     * 加载CRM左部信息
     * @return
     * @throws IOException 
     */
    public static String getCLeftContent(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String leftCont = getLeftContent(request, "2");
        return leftCont;
    }

    /**
     * 加载头部信息
     * @param type(1-商家营销,2-CRM)
     * @return
     */
    private static String getHeadContent(HttpServletRequest request, String type)
    {
        ShopLoginInfo shopInfo = GMSUtil.getShopLoginInfoByWeb(request);
        String menuCode = (String) request.getAttribute("topMenuCode");
        String menu2Code = (String) request.getAttribute("top2MenuCode");

        Map<String, Object> root = getHeadHtmlPara(type, menuCode, menu2Code, shopInfo);
        GMSFtlUtil.putDefaultRequestParasToMap(request, root);

        String content = FreemarkerUtil.getContent(TemplateConstant.FTL_FILE_COMMON_HEAD, root);

        return content;
    }

    /**
     * 加载左部信息
     * @param type(1-商家营销,2-CRM)
     * @return
     * @throws IOException 
     */
    private static String getLeftContent(HttpServletRequest request, String type)
    {
        ShopLoginInfo shopInfo = GMSUtil.getShopLoginInfoByWeb(request);
        String menuCode = (String) request.getAttribute("leftMenuCode");
        long[] statusData = GMSServiceUtil.getLeftStatusData(request);

        Map<String, Object> root = getLeftHtmlParas(type, menuCode, shopInfo, statusData);
        GMSFtlUtil.putDefaultRequestParasToMap(request, root);

        String content = FreemarkerUtil.getContent(TemplateConstant.FTL_FILE_COMMON_LEFT, root);

        return content;
    }

    /**
     * 获取头部页面html
     * @param type
     * @param menuCode
     * @param menu2Code
     * @param shopLoginInfo
     * @return
     */
    private static Map<String, Object> getHeadHtmlPara(String type, String menuCode, String menu2Code, ShopLoginInfo shopLoginInfo)
    {
        Map<String, Object> root = new HashMap<String, Object>();
        GmsLoginInfo shopInfo = GMSServiceUtil.convertCasObjToGmsLoginInfo(shopLoginInfo);
        root.put("headType", type);
        //头部链接
        Map<String, String> authMap = GMSAuthUtil.getAuthUrlMap(true, shopLoginInfo.getShopAuthList());//
        root.put("authMap", authMap);
        String marketingUrl = "";
        if ("2".equals(type))
        {
            marketingUrl = GMSAuthUtil.getFirstUserAuthUrlByParentCode(GMSConstant.AUTH_CODE_MARKETING_ROOT, shopLoginInfo);
        }
        root.put("marketingUrl", marketingUrl);
        //退出
        String shopLogout = GmsConfigCache.get(GMSConstant.PASSPORT_SHOP_LOGOUT_KEY);
        root.put("shopLogout", shopLogout);
        //商家可使用的一级菜单
        List<FShopAuthority> authList = shopInfo.getAuthList();
        List<FNode> menus1 = GMSAuthUtil.getMenuListByParentCode(type, authList);

        freashMenuName(menus1, shopInfo.getWordNames());

        root.put("menuCode1", menuCode);
        root.put("menus1", menus1);
        //商家可使用的二级菜单
        root.put("menuCode2", menu2Code);
        if (StringUtils.hasText(menu2Code))
        {
            List<FNode> menus2 = GMSAuthUtil.getBrotherMenuList(menu2Code, authList);
            freashMenuName(menus2, shopInfo.getWordNames());
            root.put("menus2", menus2);
        }

        return root;
    }

    /**
     * 获取左菜单html
     * @param type
     * @param menuCode
     * @param shopLoginInfo
     * @param statusData
     * @return
     */
    private static Map<String, Object> getLeftHtmlParas(String type, String menuCode, ShopLoginInfo shopLoginInfo, long[] statusData)
    {
        Map<String, Object> root = new HashMap<String, Object>();
        GmsLoginInfo shopInfo = GMSServiceUtil.convertCasObjToGmsLoginInfo(shopLoginInfo);

        String statusName = "";
        String fastName = "";
        String fastUrl1 = "#";
        String fastName1 = "";
        String fastUrl2 = "#";
        String fastName2 = "";
        Map<String, String> authMap = GMSAuthUtil.getAuthUrlMap(true, shopLoginInfo.getShopAuthList());
        Map<String, String> statusNames = new HashMap<String, String>();
        Map<String, String> statusDatas = new HashMap<String, String>();
        if ("1".equals(type))
        {
            //统计内容
            statusName = shopInfo.getWordName("gmsd001");//统计内容
            statusNames.put("TOTALSTATUSNAME0", shopInfo.getWordName("gmsd002"));
            statusNames.put("TOTALSTATUSNAME1", shopInfo.getWordName("gmsd003"));
            statusNames.put("TOTALSTATUSNAME2", shopInfo.getWordName("gmsd004"));
            statusNames.put("TOTALSTATUSNAME3", shopInfo.getWordName("gmsd005"));
            //快速通道
            fastName = shopInfo.getWordName("gmsd007");//快捷通道
            fastUrl1 = authMap.get("11");
            fastName1 = shopInfo.getWordName("gmsd008");//营销状态
            fastUrl2 = authMap.get("13");
            fastName2 = shopInfo.getWordName("gmsd009");//活动管理
        }
        else if ("2".equals(type))
        {
            //统计内容
            statusName = shopInfo.getWordName("cpmb002");//统计内容

            statusNames.put("TOTALSTATUSNAME0", shopInfo.getWordName("cpmb003"));
            statusNames.put("TOTALSTATUSNAME1", shopInfo.getWordName("cpmb004"));
            statusNames.put("TOTALSTATUSNAME2", shopInfo.getWordName("cpmb005"));
            statusNames.put("TOTALSTATUSNAME3", shopInfo.getWordName("cpmb006"));
            //快速通道
            fastName = shopInfo.getWordName("cpmb008");//快捷通道
            fastUrl1 = authMap.get("2402");
            fastName1 = shopInfo.getWordName("cpmb009");//审批管理
            fastUrl2 = authMap.get("23");
            fastName2 = shopInfo.getWordName("cpmb010");//会员激励
        }
        statusDatas.put("TOTALSTATUS0", statusData[0] + "");
        statusDatas.put("TOTALSTATUS1", statusData[1] + "");
        statusDatas.put("TOTALSTATUS2", statusData[2] + "");
        statusDatas.put("TOTALSTATUS3", statusData[3] + "");

        //统计内容
        root.put("STATUSNAME", statusName);
        root.put("statusNames", statusNames);
        root.put("statusDatas", statusDatas);

        //快速通道
        root.put("FASTNAME", fastName);
        root.put("FASTCHANNELURL1", fastUrl1);
        root.put("FASTCHANNELNAME1", fastName1);
        root.put("FASTCHANNELURL2", fastUrl2);
        root.put("FASTCHANNELNAME2", fastName2);

        //商家可使用的左菜单
        List<FNode> menus = GMSAuthUtil.getBrotherMenuList(menuCode, shopInfo.getAuthList());
        freashMenuName(menus, shopInfo.getWordNames());
        root.put("menuCode", menuCode);
        root.put("menus", menus);

        return root;
    }

    /**
     * 获取左菜单li内容
     * @param menuCode
     * @param shopInfo
     * @return
     */
    private static String getLeftMenuContent(String menuCode, GmsLoginInfo shopInfo)
    {
        List<FNode> menus = GMSAuthUtil.getBrotherMenuList(menuCode, shopInfo.getAuthList());
        String liDivs = getLiDivs(menuCode, menus, shopInfo.getWordNames());

        return liDivs;
    }

    /**
     * 获取菜单li列表
     * 《li>《a href='#' class='selected'》li1《/a》《/li》
     * @param menuCode
     * @param menus
     * @param wordNames
     * @return
     */
    private static String getLiDivs(String menuCode, List<FNode> menus, Map<String, String> wordNames)
    {
        StringBuffer str = new StringBuffer();
        if (menus == null || menus.size() < 1)
        {
            return str.toString();
        }
        for (FNode node : menus)
        {
            String css = "";
            if (menuCode != null && menuCode.equals(node.getCode()))
            {
                css = " class='selected' ";
            }
            String name = getVersionMenuName(node.getCode(), wordNames);
            if (!StringUtils.hasText(name))
            {
                name = node.getName();
            }
            str.append("<li><a href='" + node.getIcon() + "' " + css + ">" + name + "</a></li>" + "\n");
        }
        return str.toString();
    }

    /**
     * 更新菜单名称
     * @param menus
     * @param wordNames
     * @return
     */
    private static void freashMenuName(List<FNode> menus, Map<String, String> wordNames)
    {
        for (FNode node : menus)
        {
            String name = getVersionMenuName(node.getCode(), wordNames);
            if (StringUtils.hasText(name))
            {
                node.setName(name);
            }
        }
    }

    /**
     * 获取菜单界面名称
     * @param code
     * @param wordNames
     * @return
     */
    public static String getVersionMenuName(String code, Map<String, String> wordNames)
    {
        String name = null;
        String versionCode = SysdictionaryCache.get(GMSConstant.INTERFACE_AUTH_NAME, code);
        if (StringUtils.hasText(versionCode) && wordNames != null)
        {
            name = wordNames.get(versionCode);
        }
        return name;
    }

}
