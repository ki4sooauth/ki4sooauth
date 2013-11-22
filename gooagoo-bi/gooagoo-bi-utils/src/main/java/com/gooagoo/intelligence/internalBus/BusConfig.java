package com.gooagoo.intelligence.internalBus;

import java.util.ResourceBundle;

public class BusConfig
{
    public static int pool;
    public static String basepackage;
    static
    {
        ResourceBundle resb = ResourceBundle.getBundle("internalBus");
        basepackage = resb.getString("basepackage");
        String strPool = resb.getString("pool");
        if (strPool != null && !"".equals(strPool))
        {
            pool = Integer.valueOf(strPool);
        }
        else
        {
            pool = 20;
        }
    }
}
