package com.gooagoo.socket.listener;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.socket.ioService.CrmLConnServer;
import com.gooagoo.socket.ioService.GooagooLConnServer;

/**
 * 手机推送服务端初始化
 */
@Component
public class CrmServerInitializing implements InitializingBean
{
    @Autowired
    private CrmLConnServer crmLConnServer;
    @Autowired
    private GooagooLConnServer gooagooLConnServer;

    @Override
    public void afterPropertiesSet() throws Exception
    {
        //启动手机推送服务器端
        GooagooLog.debug("********crm服务器开始启动*******************");
        long t1 = System.currentTimeMillis();
        this.crmLConnServer.start();
        this.gooagooLConnServer.start();
        long t2 = System.currentTimeMillis();
        GooagooLog.debug("********crm服务器启动完毕，耗时：" + (t2 - t1) + "毫秒********");

    }
}
