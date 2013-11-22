package com.gooagoo.common.gus.utils;

import org.apache.commons.lang.StringUtils;

import com.gooagoo.common.cipher.DesUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.view.gus.common.UrlInfo;

/**
 * URL地址解密工具类
 * <br>
 * 适用于虚拟商家网站版、手机版访问地址解密
 * @author GUS
 *
 */
public class UrlDecode
{

    public static UrlInfo decodeInfo(String src)
    {
        try
        {
            UrlInfo info = new UrlInfo();
            GooagooLog.debug("解密前：" + src);
            src = new DesUtils("fetchurl").decrypt(src);
            GooagooLog.debug("解密后：" + src);
            String[] temp = src.split("\\^");
            info.setAction(temp[0]);
            info.setTypeId(("null".equals(temp[1]) || StringUtils.isBlank(temp[1])) ? null : temp[1]);
            if (temp.length == 3)
            {
                info.setRnd(temp[2]);
            }
            else if (temp.length == 4)
            {
                info.setMarketingId(("null".equals(temp[2]) || StringUtils.isBlank(temp[2])) ? null : temp[2]);
                info.setRnd(temp[3]);
            }

            return info;
        }
        catch (Exception e)
        {
            GooagooLog.error("解密异常", e);
            return null;
        }
    }

}
