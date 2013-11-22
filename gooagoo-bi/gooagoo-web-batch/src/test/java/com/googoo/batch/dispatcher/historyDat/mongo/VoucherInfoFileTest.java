package com.googoo.batch.dispatcher.historyDat.mongo;

import org.junit.Test;

public class VoucherInfoFileTest
{

    @Test
    public void test()
    {
        VoucherInfoFile voucher = new VoucherInfoFile();
        voucher.run();
    }

    @Test
    public void test2()
    {
        boolean flag = false;
        String value = "0182A30R0LHP8DK02VLL3UEIISWR2TKG_B_M_*_*_Y2013W43";
        int lastIndexOf = value.lastIndexOf("_");
        String id = value.substring(0, lastIndexOf);
        String date = value.substring(lastIndexOf + 1, value.length());

        StringBuffer _id = new StringBuffer();
        String[] ids = id.split("_");

        _id.append(ids[0]).append("_" + ids[2]);
        if (ids.length == 3 && date.startsWith("Y"))
        {
            _id.append("_" + "*").append("_" + "*");
            flag = true;
        }
        else if (ids.length == 4 && date.startsWith("Y"))
        {
            _id.append("_" + ids[4]).append("_" + "*");
        }
        else if (ids.length == 5 && date.startsWith("Y"))
        {
            _id.append("_" + ids[3]).append("_" + ids[4]);
            flag = true;
        }

        if (flag)
        {
            System.out.println(_id.toString());
        }
        else
        {
            System.out.println(flag);
        }
    }
}
