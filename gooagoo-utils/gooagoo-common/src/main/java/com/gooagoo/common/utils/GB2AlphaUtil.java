package com.gooagoo.common.utils;

/**
 * 取出汉字字符串的拼音首字母
 */
public class GB2AlphaUtil
{

    //字母Z使用了两个标签，这里有27个值
    //i, u, v都不做声母, 跟随前面的字母
    private static char[] chartable = { '\u554a', '芭', '擦', '搭', '蛾', '发', '噶', '哈', '哈', '击', '喀', '垃', '妈', '拿', '哦', '啪', '期', '然', '撒', '塌', '塌', '塌', '挖', '昔', '压', '匝', '座' };

    private static char[] alphatable = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    private static int[] table = new int[27];

    //初始化
    static
    {
        for (int i = 0; i < 27; ++i)
        {
            table[i] = gbValue(chartable[i]);
        }
    }

    private GB2AlphaUtil()
    {
    }

    //主函数,输入字符,得到他的声母,
    //英文字母返回对应的大写字母
    //其他非简体汉字返回 '0'
    public static char char2Alpha(char ch)
    {

        if (ch >= 'a' && ch <= 'z')
        {
            return (char) (ch - 'a' + 'A');
        }
        if (ch >= 'A' && ch <= 'Z')
        {
            return ch;
        }

        int gb = gbValue(ch);
        if (gb < table[0])
        {
            return '0';
        }

        int i;
        for (i = 0; i < 26; ++i)
        {
            if (match(i, gb))
            {
                break;
            }
        }

        if (i >= 26)
        {
            return '0';
        }
        else
        {
            return alphatable[i];
        }
    }

    //匹配字符
    private static boolean match(int i, int gb)
    {
        if (gb < table[i])
        {
            return false;
        }

        int j = i + 1;

        //字母Z使用了两个标签
        while (j < 26 && (table[j] == table[i]))
        {
            ++j;
        }

        if (j == 26)
        {
            return gb <= table[j];
        }
        else
        {
            return gb < table[j];
        }

    }

    //取出汉字的编码
    private static int gbValue(char ch)
    {
        String str = new String();
        str += ch;
        try
        {
            byte[] bytes = str.getBytes("GBK");
            if (bytes.length < 2)
            {
                return 0;
            }
            return (bytes[0] << 8 & 0xff00) + (bytes[1] & 0xff);
        }
        catch (Exception e)
        {
            return 0;
        }

    }

    /**
     * 根据一个包含汉字的字符串返回一个汉字拼音首字母的字符串
     * @param SourceStr
     * @return 汉字字符串每个汉字首字母组成的字符串
     */
    public static String string2Alpha(String SourceStr)
    {
        String Result = "";
        int StrLength = SourceStr.length();
        int i;
        try
        {
            for (i = 0; i < StrLength; i++)
            {
                Result += char2Alpha(SourceStr.charAt(i));
            }
        }
        catch (Exception e)
        {
            Result = "";
        }
        return Result;
    }

    /**
     * 取出汉字字符串的首字母
     * @param SourceStr
     * @return 字符串第一个汉字首字母
     */
    public static String FirstStr2Alpha(String SourceStr)
    {
        return string2Alpha(SourceStr).substring(0, 1);
    }

}
