package com.gooagoo.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gooagoo.common.log.GooagooLog;

/**
 * 生成有序UUID 如果每台机器每个进程每纳秒产生33519618个值 至3084年12月12日前不重复(其实这个时间过后也不会重复，只是会数据溢出超出可控范围)
 * PC机实测效率每秒可生成180万个UUID
 * @author 王宇
 *
 */
public class UUID
{
    private final static String mac = NUM32(Long.valueOf(GetMacs(), 16), 10);
    private final static String pid = NUM32(PID(), 3); //linux默认pid最大32767
    private static int point1 = new Random(new Object().hashCode()).nextInt(1023);
    private static int point2 = new Random(new Object().hashCode()).nextInt(32766);

    public static String getUUID()
    {
        String millis = NUM32(System.currentTimeMillis(), 9);
        String nanoTime = NUM32(System.nanoTime(), 5);
        String srtPoint1 = NUM32(getPoint1(), 2);
        String srtPoint2 = NUM32(getPoint2(), 3);
        return millis + nanoTime + mac + srtPoint1 + pid + srtPoint2;
    }

    public static String NUM32(long l, int wide)
    {
        String or = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] cs = new char[wide];

        while (wide > 0)
        {
            int surplus = (int) (l & 31);
            cs[wide - 1] = or.charAt(surplus);
            l = l >> 5;
            wide--;
        }
        return new String(cs);
    }

    private static synchronized int getPoint1()
    {
        if (point1 > 1023)
        {
            point1 = 0;
        }
        point1++;
        return point1;
    }

    private static synchronized int getPoint2()
    {
        if (point2 > 32766)
        {
            point2 = 0;
        }
        point2++;
        return point2;
    }

    private static String getMACAddress(String commond, String regular) throws Exception
    {
        Pattern pattern = Pattern.compile(regular); //windows "..-..-..-..-..-.."
        String mac = null;
        BufferedReader bufferedReader = null;
        Process process = null;
        try
        {
            process = Runtime.getRuntime().exec(commond); //windows getmac
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = bufferedReader.readLine()) != null)
            {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find())
                {
                    mac = matcher.group().replaceAll("\\W", "");
                    break;
                }
            }
        }
        catch (IOException e)
        {
            GooagooLog.error("获取mac地址异常", e);
        }
        finally
        {
            try
            {
                if (bufferedReader != null)
                {
                    bufferedReader.close();
                }
            }
            catch (IOException e1)
            {
                GooagooLog.error("获取mac地址异常", e1);

            }
            finally
            {
                bufferedReader = null;
                process = null;
            }
        }
        if (mac == null || mac.isEmpty())
        {
            throw new Exception("cat get the mac");
        }
        return mac;
    }

    private static long PID()
    {
        long pid = 0;
        try
        {
            String runtime = ManagementFactory.getRuntimeMXBean().getName();
            String strPid = runtime.split("@")[0];
            pid = Long.parseLong(strPid);
        }
        catch (Exception e)
        {
            pid = new Random().nextInt(new Object().hashCode());
        }
        return pid;
    }

    private static String GetMacs()
    {
        String mac = null;
        try
        {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.startsWith("windows"))
            {
                mac = getMACAddress("getmac", "..-..-..-..-..-..");
            }
            else
            {
                mac = getMACAddress("ifconfig", "..:..:..:..:..:..");
            }
        }
        catch (Exception e)
        {
            InetAddress addr;
            try
            {
                addr = InetAddress.getLocalHost();
                mac = addr.getHostAddress().replaceAll("\\W", "");
            }
            catch (UnknownHostException u)
            {
                GooagooLog.error("获取mac地址异常", u);
            }
        }
        return mac;
    }
}