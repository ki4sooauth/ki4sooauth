package com.java.utils.password;

import java.security.MessageDigest;

/**
 * 32位16进制加密算法
 * MD5加密，常用于加密用户名密码，当用户验证时
 */
public class Md5Encrypt
{
    private final static String[] hexArray = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" }; // 存储十六进制值的数组

    public static String createEncrypPassword(String string)
    {
        return encrypByMD5(string);
    }

    public static boolean verificationPassword(String password, String string)
    {
        if (password.equals(encrypByMD5(string)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 加密
     * @param originString 明文
     * @return
     */
    private static String encrypByMD5(String originString)
    {
        if (originString != null)
        {
            try
            {
                // 创建具有MD5算法的信息摘要
                MessageDigest md = MessageDigest.getInstance("MD5");
                // 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
                byte[] results = md.digest(originString.getBytes());
                // 将得到的字节数组变成字符串返回
                String resultString = byteArrayToHex(results);
                return resultString.toUpperCase();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return null;
    }

    private static String byteArrayToHex(byte[] b)
    {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
        {
            resultSb.append(byteToHex(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHex(byte b)
    {
        int n = b;
        if (n < 0)
        {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexArray[d1] + hexArray[d2];
    }

    public static void main(String[] args)
    {
        String password = Md5Encrypt.createEncrypPassword("hahaxiao1984");
        System.out.println("对password=hahaxiao1984使用MD5算法加密后的字符串如下：\n  " + password);
        String string = "hahaxiao1999";
        System.out.println("hahaxiao1999是正确的密码吗？" + Md5Encrypt.verificationPassword(password, string));
        string = "hahaxiao1984";
        System.out.println("hahaxiao1984是正确的密码吗？" + Md5Encrypt.verificationPassword(password, string));
    }

}
