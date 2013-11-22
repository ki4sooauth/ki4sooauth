package com.gooagoo.current.tools;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.gooagoo.intelligence.common.log.GooagooLog;

public class MobileMac
{
    private static Map<String, String> macs = new HashMap<String, String>();
    static
    {

        InputStream is = MobileMac.class.getResourceAsStream("/mobileMac");
        InputStreamReader read = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(read);
        try
        {
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null)
            {
                lineTxt = lineTxt.trim();
                if (lineTxt != null && !"".equals(lineTxt) && '#' != lineTxt.charAt(0))
                {
                    String[] parts = lineTxt.split("\\s");
                    macs.put(parts[0], parts[1]);
                }
            }
            read.close();
        }
        catch (Exception e)
        {
            GooagooLog.error("读取mac配置文件", e);
        }
    }

    public static String getBrand(String mac)
    {
        String fac1 = mac.toUpperCase().substring(0, 13);
        String fac2 = mac.toUpperCase().substring(0, 8);
        String brand = null;
        if ((brand = macs.get(fac1)) != null)
        {
            return brand;
        }
        else if ((brand = macs.get(fac2)) != null)
        {
            return brand;
        }
        return null;
    }

    public static void main(String[] args)
    {

        System.out.println(MobileMac.getBrand("8c:7b:9d:68:c2:4e"));
    }
}
