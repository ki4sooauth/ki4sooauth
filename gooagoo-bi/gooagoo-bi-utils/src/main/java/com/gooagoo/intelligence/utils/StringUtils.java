package com.gooagoo.intelligence.utils;

public class StringUtils
{
    public static String filterNull(String str)
    {
        if (str == null)
        {
            return "";
        }
        else
        {
            return str;
        }
    }

    /**
     * 判断传入的str是否全都有值，即都不为空
     * @param str 待判断的值，可变参数
     * @return
     */
    public static boolean hasText(String... str)
    {
        boolean value = true;
        if (str != null)
        {
            for (String string : str)
            {
                if (string == null || "".equals(string))
                {
                    value = false;
                }
            }
        }
        else
        {
            value = false;
        }
        return value;
    }
}
