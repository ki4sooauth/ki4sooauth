package com.gooagoo.current.tools;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.query.marketing.MarketingViewGeneratorQueryService;
import com.gooagoo.entity.generator.marketing.MarketingView;
import com.gooagoo.intelligence.utils.SpringBeanUtils;

public class Marketing
{
    public static Map<String, String> behaveMap = new HashMap<String, String>();
    static
    {
        ResourceBundle bundle = ResourceBundle.getBundle("behaveConfig");
        Enumeration<String> keys = bundle.getKeys();
        while (keys.hasMoreElements())
        {
            String key = keys.nextElement();
            String value = bundle.getString(key);
            behaveMap.put(key, value);
        }
    }

    /**
     * 浏览的类型(服务工具 T,商品 G,优惠凭证 C,活动 A,吆喝 R,通知 N,购好奇 I,事件E,广告D)
     * 
     * @param id
     *            接口地址
     * @return
     */
    public static String getBrowseType(String id)
    {
        //接口编码转换
        return behaveMap.get(id);
    }

    /*public static boolean isTypeTools(String id)
    {
        if ("T".equals(getBrowseType(id)))
        {
            return true;
        }
        return false;
    }

    public static boolean isTypeGoods(String id)
    {
        if ("G".equals(getBrowseType(id)))
        {
            return true;
        }
        return false;
    }

    public static boolean isTypeActive(String id)
    {
        if ("A".equals(getBrowseType(id)))
        {
            return true;
        }
        return false;
    }

    public static boolean isTypeCryout(String id)
    {
        if ("R".equals(getBrowseType(id)))
        {
            return true;
        }
        return false;
    }

    public static boolean isTypeCoupon(String id)
    {
        if ("C".equals(getBrowseType(id)))
        {
            return true;
        }
        return false;
    }

    public static boolean isTypeNotice(String id)
    {
        if ("N".equals(getBrowseType(id)))
        {
            return true;
        }
        return false;
    }

    public static boolean isTypeInquisitive(String id)
    {
        if ("I".equals(getBrowseType(id)))
        {
            return true;
        }
        return false;
    }

    public static boolean isTypeEvent(String id)
    {
        if ("E".equals(getBrowseType(id)))
        {
            return true;
        }
        return false;
    }

    public static boolean isTypeAD(String id)
    {
        if ("D".equals(getBrowseType(id)))
        {
            return true;
        }
        return false;
    }*/

    MarketingViewGeneratorQueryService marketingViewService = SpringBeanUtils.getBean(MarketingViewGeneratorQueryService.class);

    /***************************************************************/
    /**
     * 浏览信息的渠道(0:所有,1:吆喝,2:通知,3:短信,4:邮件,5:购好奇,6:手机服务)
     * 
     * @param id
     * @return
     */
    public String getChannel(String id)
    {
        if (!StringUtils.hasText(id))
        {
            return null;
        }
        MarketingView marketingView = marketingViewService.selectUnDelByPrimaryKey(id);
        if (marketingView != null)
        {
            String channelCode = marketingView.getChannelCode();
            return channelCode;
        }
        return null;
    }
}
