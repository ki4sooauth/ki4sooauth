package com.gooagoo.intelligence.transferBox;

import java.util.ResourceBundle;

public class TransferConfig
{
    public static int pool;
    public static String basepackage;
    static
    {
        ResourceBundle resb = ResourceBundle.getBundle("transfer");
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
