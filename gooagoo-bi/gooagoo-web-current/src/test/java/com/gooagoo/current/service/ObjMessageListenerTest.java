package com.gooagoo.current.service;

import com.gooagoo.current.utils.SendMessageUtil;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.message.GooagooMessage;

public class ObjMessageListenerTest
{
    public static void main(String[] args)
    {
        SendMessageUtil sendMessageUtil = new SendMessageUtil();
        GooagooMessage<BehaveLog> message = new GooagooMessage<BehaveLog>();
        message.setSource("3");//消息来源
        message.setBehaveCode("gusm02");//调用的接口编码（位置引擎中表示定位（001）与行为（002）的识别标志）
        message.setBehaveType("9");//行为类型（特指用户行为类型，商家及管理员暂无）
        message.setFlag(true);//操作结果，true-成功，false-失败

        BehaveLog behaveLog = new BehaveLog();
        behaveLog.setShopId("01822IE57DH111M085QBPFEIISWR0JGT");
        behaveLog.setObjectValue("183JO6FN69TLH32G8PELDKNPHI5CSCUF"); //这个就随便生成了一个
        behaveLog.setUserId("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        behaveLog.setSource("W");
        behaveLog.setObjectSource("018237FSEHNVTOI005B2D4J4VOR9U6KK");
        behaveLog.setOperateResult("Y");
        message.setContent(behaveLog);//消息内容

        sendMessageUtil.sendObjectMessage(message);
        sendMessageUtil.close();
    }
}
