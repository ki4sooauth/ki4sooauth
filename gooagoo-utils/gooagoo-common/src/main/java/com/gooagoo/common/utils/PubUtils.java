package com.gooagoo.common.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class PubUtils
{

    /**
     * 读取网页内容
     * @param str   网页地址，例：http://wwww.baidu.com
     * @return      网页内容
     * @throws java.io.IOException
     */
    public static String getHtmlCodeByURL(String str) throws java.io.IOException
    {
        URL url = new URL(str);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream in = urlConnection.getInputStream();
        byte[] data = new byte[in.available()];
        in.read(data);
        return new String(data);
    }

    /**
     * 获取项目物理路径
     * @return              项目路径
     * @throws Exception    未找到路径
     */
    public static String getProjectLocalPath() throws UnsupportedEncodingException
    {
        String path = PubUtils.class.getClassLoader().getResource("").getFile();
        path = URLDecoder.decode(path, "UTF-8");
        return path.substring(0, path.lastIndexOf("/WEB-INF"));
    }

    /**
     * 获取配置文件，该配置文件必须放在“/WEB-INF/classes/”文件夹下或者“/com/sinosoft/transverse/common/”文件夹下
     * @param filename  配置文件名称
     * @return          InputStream
     */
    public static InputStream getConfigFileInputStream(String filename)
    {
        try
        {
            return new FileInputStream(getProjectLocalPath() + "/WEB-INF/classes/" + filename);
        }
        catch (Exception e)
        {
            //解决在CS项目中没有classes文件夹的问题
            return PubUtils.class.getResourceAsStream(filename);
        }
    }

    /**
     * 获取客户端IP
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request)
    {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getRemoteAddr();
        }
        if (ip == null)
        {
            return "";
        }
        String[] str = ip.split(",");
        if (str == null || str.length == 0)
        {
            return "";
        }
        else if (str[0].length() > 15)
        {
            return str[0].substring(0, 15);
        }
        else
        {
            return str[0];
        }
    }

    /**
     * 获取服务器IP
     */
    public static InetAddress getLocalAddress() throws SocketException
    {
        InetAddress inetAddress = null;
        for (Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces(); interfaces.hasMoreElements();)
        {
            NetworkInterface networkInterface = interfaces.nextElement();
            if (networkInterface.isLoopback() || networkInterface.isVirtual() || !networkInterface.isUp())
            {
                continue;
            }
            Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
            while (addresses.hasMoreElements())
            {
                inetAddress = addresses.nextElement();
                if (DataPatternUtils.checkIpAddress(inetAddress.getHostAddress()))
                {
                    return inetAddress;
                }
            }
        }
        return inetAddress;
    }
}
