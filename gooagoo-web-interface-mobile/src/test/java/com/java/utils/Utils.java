package com.java.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Utils
{
    /**
     * 某文件中包含某信息的行
     * @param filePath
     * @param keyWord
     * @throws IOException
     */
    public static void deleteContent(String filePath, String keyWord) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        StringBuffer sb = new StringBuffer(4096);
        String temp = null;
        while ((temp = br.readLine()) != null)
        {
            if (temp.contains(keyWord))
            {
                continue;
            }
            sb.append(temp).append("\n");
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        bw.write(sb.toString());
        bw.close();
    }

    /**
     * 某文件中包含某信息的行
     * @param filePath
     * @param keyWord
     * @throws IOException
     */
    public static void replaceContent(String filePath, String keyWord) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        StringBuffer sb = new StringBuffer(4096);
        String temp = null;
        while ((temp = br.readLine()) != null)
        {
            if (temp.contains(keyWord))
            {
                temp.replace(keyWord, "root.setMsgcode(err)");
            }
            sb.append(temp).append("\n");
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        bw.write(sb.toString());
        bw.close();
    }

    public static void main(String[] args) throws IOException
    {
        SearchFile searchFile = new SearchFile();

        List<String> filePath = searchFile.findFiles("D:\\workspace\\fetchview\\gooagoo-api\\gooagoo-web-interface-mobile\\src\\main\\java\\com\\gooagoo\\mobile\\impl", "*.java", "Impl", "root.setMsgcode(e.getMessage())");
        //        List<String> filePath = searchFile.findFiles("D:\\workspace\\fetchview\\gooagoo-api\\gooagoo-web-interface-gas\\src\\test\\java\\com\\gooagoo\\junittest", "*.java", "Test", "Message");
        //        List<String> filePath = searchFile.findFiles("D:\\workspace\\fetchview\\gooagoo-api\\gooagoo-web-interface-mobile\\src\\test\\java\\com\\gooagoo\\junittest", "*.java", "Test", "Message");

        for (String temp : filePath)
        {
            deleteContent(temp, "返回报文");
        }
    }
}
