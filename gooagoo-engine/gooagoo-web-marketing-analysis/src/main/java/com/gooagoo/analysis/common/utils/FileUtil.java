package com.gooagoo.analysis.common.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil
{

    /*
     * 换行符
     */
    public static final String tail = "\r\n";

    /*
     * 邮件模板的存储位置 
     */
    public static final String emailFilePath = "/mnt/mfs/event/email/";

    public static final String emailFileTail = ".html";

    public static final String defaultCharset = "utf-8";

    /**
     * 读取HTML文件内容
     * @param filepathAndName 文件路径以及名字
     * @param charset 编码格式
     * @return String内容
     * @throws IOException
     */
    public static String readHtml(String filepathAndName, String charset) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filepathAndName), charset));
        StringBuffer str = new StringBuffer();

        String r = br.readLine();
        while (r != null)
        {
            str.append(r + tail);
            r = br.readLine();
        }

        br.close();
        return str.toString();
    }

    /**
     * 读取邮件文件的内容
     * @param filename 为发邮件哪里写的方法 只要写文件名即可 不要后缀
     * @param charset  编码
     * @return String
     * @throws IOException
     */
    public static String readEmailHtml(String filename, String charset) throws IOException
    {
        return readHtml(emailFilePath + filename + emailFileTail, charset);
    }

}
