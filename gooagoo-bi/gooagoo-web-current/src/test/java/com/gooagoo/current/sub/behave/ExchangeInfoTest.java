package com.gooagoo.current.sub.behave;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.message.GooagooMessage;

public class ExchangeInfoTest
{
    ExchangeInfo exchangeInfo = new ExchangeInfo();

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void test()
    {
        GooagooMessage<BehaveLog> message = new GooagooMessage<BehaveLog>();

        BehaveLog behaveLog = new BehaveLog();
        behaveLog.setShopId("185EVK63KPRTKH00A1BAQJMCA2H349CC");
        behaveLog.setObjectValue("187UPKP2M52BAN00A1BAQJME7CHS6E7Q"); //这个就随便生成了一个
        behaveLog.setUserId("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        behaveLog.setSource("1");
        //behaveLog.setObjectSource("0182UOJNLFC4UVH0N5GGV0EIISWR219J");
        //behaveLog.setRemoteCode("gusm04");

        message.setContent(behaveLog);//消息内容
        exchangeInfo.message(behaveLog);
    }

}
