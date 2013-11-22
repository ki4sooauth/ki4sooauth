package com.gooagoo.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 字符处理工具类
 * @author frenn
 *
 */
public class StringUtils
{
    public static String getUUID()
    {
        return UUID.getUUID();
    }

    /**
     * 格式化mac地址：去掉冒号，全部大写
     * @param mac
     * @return
     */
    public static String formatMac(String mac)
    {
        return mac.replaceAll(":", "").toUpperCase();
    }

    /**
     * 首字母大写化
     * @param src   字符串
     * @return      首字母大写后的字符串
     */
    public static String upperFirstLetter(String src)
    {
        return src.substring(0, 1).toUpperCase() + src.substring(1);
    }

    /**
     * 首字母小写
     * @param src   字符串
     * @return      首字母小写后的字符串
     */
    public static String lowerFirstLetter(String src)
    {
        return src.substring(0, 1).toLowerCase() + src.substring(1);
    }

    /**
     * 将字符串分割成字符串List
     * @param source 源字符串
     * @param splitTag 分割字符
     * @return List<String> 字符串List
     * @author zsl
     */
    public static List<String> split2List(String source, String splitTag)
    {
        List<String> StrList = new ArrayList<String>();
        List<String> specTaglist = new ArrayList<String>();
        String[] specTag = { "|", "+", "*", "/", ".", "^" };
        for (int j = 0; j < specTag.length; j++)
        {
            specTaglist.add(specTag[j]);
        }
        if (specTaglist.contains(splitTag))
        {
            splitTag = "\\" + splitTag;
        }
        String[] strArray = source.split(splitTag);
        for (int i = 0; i < strArray.length; i++)
        {
            StrList.add(strArray[i]);
        }
        return StrList;
    }

    /**
     * 取出数组或List中最大或者最小值(支持日期型、整型、字符串、字符型的基本排序)
     * @param sortMode 0-由小到大 1-由大到小
     * @param arrayData 数组数据 不存在值传null
     * @param listData list数据 不存在值传null
     * @return 最大值or最小值
     * @author zsl
     */
    @SuppressWarnings("unchecked")
    public static <T> T sortData(String sortMode, T[] arrayData, List<T> listData)
    {
        T obj = null;
        T[] arrayData1 = null;
        if ("0".equals(sortMode))
        {
            if (arrayData != null)
            {
                Arrays.sort(arrayData);
                obj = arrayData[0];
            }
            else
            {
                arrayData1 = (T[]) listData.toArray();
                Arrays.sort(arrayData1);
                obj = arrayData1[0];
            }

        }
        else
        {
            if (arrayData != null)
            {
                Arrays.sort(arrayData, Collections.reverseOrder());
                obj = arrayData[0];
            }
            else
            {
                arrayData1 = (T[]) listData.toArray();
                Arrays.sort(arrayData1, Collections.reverseOrder());
                obj = arrayData1[0];
            }
        }
        return obj;
    }

    /**
     * 字符串是否含有全角字符
     * @param src   字符串
     * @return      true-有，false-没有
     */
    public static boolean hasSBC(String src)
    {
        char[] c = src.toCharArray();
        for (int i = 0; i < c.length; i++)
        {
            if (c[i] < 32 || c[i] > 126)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 字符串是否含有半角字符
     * @param src   角字符
     * @return      true-有，false-没有
     */
    public static boolean hasDBC(String src)
    {
        char[] c = src.toCharArray();
        for (int i = 0; i < c.length; i++)
        {
            if (c[i] >= 32 && c[i] <= 126)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 字符串是否包含中文
     * @param src   字符串
     * @return      true-包含，false-不包含
     */
    public static boolean hasChinese(String src)
    {
        char[] c = src.toCharArray();
        for (int i = 0; i < c.length; i++)
        {
            if (c[i] >= 0x4E00 && c[i] <= 0x9FA5)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 字符串是否包含阿拉伯数字
     * 包括全角和半角
     * @param src   字符串
     * @return      true-包含，false-不包含
     */
    public static boolean hasNumber(String src)
    {
        char[] c = src.toCharArray();
        for (int i = 0; i < c.length; i++)
        {
            if (c[i] >= 0x0030 && c[i] <= 0x0039)
            {//半角
                return true;
            }
            else if (c[i] >= 0xFF10 && c[i] <= 0xFF19)
            {//全角
                return true;
            }
        }
        return false;
    }

    /**
     * 字符串是否包含英文字母
     * 包括全角和半角
     * 包括大小写
     * @param src   字符串
     * @return      true-包含，false-不包含
     */
    public static boolean hasLetter(String src)
    {
        char[] c = src.toCharArray();
        for (int i = 0; i < c.length; i++)
        {
            if (c[i] >= 0x0041 && c[i] <= 0x005A)
            {//半角大写
                return true;
            }
            else if (c[i] >= 0x0061 && c[i] <= 0x007A)
            {//半角小写
                return true;
            }
            else if (c[i] >= 0xFF21 && c[i] <= 0xFF3A)
            {//全角大写
                return true;
            }
            else if (c[i] >= 0xFF41 && c[i] <= 0xFF5A)
            {//全角小写
                return true;
            }
        }
        return false;
    }

    /**
     * 半角转全角
     * 半角空格为32，全角空格为12288
     * 其他字符半角(33-126)与全角(65281-65374)的对应关系为：相差65248
     * @param src   待转换的字符串
     * @return      转换后的全角字符串
     */
    public static String toSBC(String src)
    {
        char[] c = src.toCharArray();
        for (int i = 0; i < c.length; i++)
        {
            if (c[i] == 32)
            {
                c[i] = 12288;
            }
            else if (c[i] >= 33 && c[i] <= 126)
            {
                c[i] += 65248;
            }
        }
        return new String(c);
    }

    /**
     * 全角转半角
     * 半角空格为32，全角空格为12288
     * 其他字符半角(33-126)与全角(65281-65374)的对应关系为：相差65248
     * @param src   待转换的字符串
     * @return      转换后的半角字符串
     */
    public static String toDBC(String src)
    {
        char[] c = src.toCharArray();
        for (int i = 0; i < c.length; i++)
        {
            if (c[i] == 12288)
            {
                c[i] = 32;
            }
            else if (c[i] >= 65281 && c[i] <= 65374)
            {
                c[i] -= 65248;
            }
        }
        return new String(c);
    }
}
