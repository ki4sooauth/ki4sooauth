package com.gooagoo.query.business.log;

import java.util.List;

import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.business.log.BehaveLogExample;
import com.gooagoo.entity.business.log.ShopLog;
import com.gooagoo.entity.business.log.ShopLogExample;
import com.gooagoo.entity.business.log.SysLog;
import com.gooagoo.entity.business.log.SysLogExample;
import com.gooagoo.entity.common.PageModel;

public class LogQueryServiceImplTest
{
    LogQueryServiceImpl service = new LogQueryServiceImpl();

    public static void main(String[] args)
    {
        LogQueryServiceImplTest logTest = new LogQueryServiceImplTest();
        logTest.testSelectBehaveLog();

        logTest.testSelectShopLog();

        logTest.testSelectSysLog();

    }

    public void testSelectBehaveLog()
    {
        BehaveLogExample example = new BehaveLogExample();
        List<BehaveLog> list = this.service.selectBehaveLog(example, 1, 21);
        System.out.println("log size:" + list.size());
        for (BehaveLog log : list)
        {
            System.out.println(log.getBehaveId());
        }
    }

    public void testSelectShopLog()
    {
        ShopLogExample example = new ShopLogExample();
        PageModel<ShopLog> list = this.service.selectShopLog(example, 1, 50);
        System.out.println("shoplog size:" + list.getResult().size());
        for (ShopLog log : list.getResult())
        {
            System.out.println(log.getShopId());
        }
    }

    public void testSelectSysLog()
    {
        SysLogExample example = new SysLogExample();
        List<SysLog> list = this.service.selectSysLog(example, 1, 50);
        System.out.println("system log size:" + list.size());
        for (SysLog log : list)
        {
            System.out.println(log.getOperateIp());
        }
    }

    /*public void testSelectMessageLog()
    {
        MessageLogExample example = new MessageLogExample();
        //example.setUuid("185C3S895JM8AH00A1BAQJMFFHBELQIL");
        //example.setServer("13");
        example.setSource("1");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 25);
        System.out.println(cal.getTime());
        example.setSendtime_after(cal.getTime());
        List<MessageLog> list = this.service.selectMessageLog(example);
        System.out.println("message log size:" + list.size());
        for (MessageLog log : list)
        {
            System.out.println(log.getUuid() + "," + log.getServer() + "," + log.getRecetime() + "," + log.getSendtime() + "," + log.getPuuid());
        }
    }*/
}
