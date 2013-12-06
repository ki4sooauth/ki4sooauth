package com.gooagoo.open.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.gooagoo.mobile.entity.mobe01.transform.Billlistg;
import com.gooagoo.mobile.entity.mobe01.transform.Isdeleted;
import com.gooagoo.open.entity.ErrorMessage;
import com.gooagoo.open.entity.mobile.BillListgs;

public class DataFormatUtilTest
{

    @Test
    public void testListXml()
    {
        List<ErrorMessage> list = new ArrayList<ErrorMessage>();
        for (int i = 0; i < 10; i++)
        {
            ErrorMessage msg = new ErrorMessage();
            msg.setErrCode("323" + i);
            msg.setErrMessage("hello world" + i);
            list.add(msg);
        }

        System.out.println(DataFormatUtil.toXml(list));
    }

    @Test
    public void testToXml()
    {
        BillListgs billListgsRoot = new BillListgs();
        Billlistg billlistg = new Billlistg();
        billlistg.setBillid("dfd");
        billlistg.setBillimg("11111");
        List<Billlistg> billlistgList = new ArrayList<Billlistg>();
        billlistgList.add(billlistg);
        Isdeleted isdeleted = new Isdeleted();
        isdeleted.setCtimestamp("dfdf");
        isdeleted.setFlag("sdfsadfas");
        billListgsRoot.setBilllistg(billlistgList);
        billListgsRoot.setIsdeleted(isdeleted);

        System.out.println(DataFormatUtil.toXml(billListgsRoot));
    }

    @Test
    public void testToJson()
    {
        List<ErrorMessage> list = new ArrayList<ErrorMessage>();
        for (int i = 0; i < 10; i++)
        {
            ErrorMessage msg = new ErrorMessage();
            msg.setErrCode("323" + i);
            msg.setErrMessage("hello world" + i);
            list.add(msg);
        }

        System.out.println(DataFormatUtil.toJson(new Date()));
    }
}
