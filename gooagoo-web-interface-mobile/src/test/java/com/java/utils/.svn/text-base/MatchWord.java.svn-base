package com.java.utils;

public class MatchWord
{
    // 文件名的通配符匹配，如果匹配成功则返回true，否则返回false
    public static boolean matchWord(final String pattern, final String str)
    {
        int patternLength = pattern.length();
        int strLength = str.length();
        int strIndex = 0;
        char ch;
        for (int patternIndex = 0; patternIndex < patternLength; patternIndex++)
        {
            ch = pattern.charAt(patternIndex);
            if (ch == '*')
            {
                // 通配符星号*表示可以匹配任意多个字符
                while (strIndex < strLength)
                {
                    if (matchWord(pattern.substring(patternIndex + 1), str.substring(strIndex)))
                    {
                        return true;
                    }
                    strIndex++;
                }
            }
            else if (ch == '?')
            {
                // 通配符问号?表示匹配任意一个字符
                strIndex++;
                if (strIndex > strLength)
                {
                    // 表示str中已经没有字符匹配?了。
                    return false;
                }
            }
            else
            {
                if ((strIndex >= strLength) || (ch != str.charAt(strIndex)))
                {
                    return false;
                }
                strIndex++;
            }
        }
        return (strIndex == strLength);
    }
}
