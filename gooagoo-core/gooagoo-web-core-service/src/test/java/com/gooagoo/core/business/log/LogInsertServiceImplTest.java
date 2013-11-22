package com.gooagoo.core.business.log;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.log.MessageLog;

public class LogInsertServiceImplTest
{
    @Test
    public void testInsertMessageLog()
    {
        LogInsertServiceImpl service = new LogInsertServiceImpl();
        String uuid = UUID.getUUID();
        for (int i = 0; i < 10; i++)
        {
            MessageLog log = new MessageLog();
            log.setUuid(uuid);
            log.setServer("Server" + Math.round(Math.random()));
            log.setRecetime(Calendar.getInstance().getTime());
            log.setSendtime(Calendar.getInstance().getTime());
            log.setPuuid(UUID.getUUID());
            service.insertMessageLog(log);
        }
    }

    @Test
    public void testqueryMessageLogById()
    {
        LogInsertServiceImpl service = new LogInsertServiceImpl();
        List<MessageLog> list = null;
        //                service.queryMessageLogById("1851MF773DTA4G0SHUR8OFGCRQ27O80I");
        for (MessageLog log : list)
        {
            System.out.println(log.getUuid());
            System.out.println(log.getPuuid());
            System.out.println(log.getServer());
            System.out.println(log.getSendtime());
            System.out.println("*********************");
        }
    }
}
