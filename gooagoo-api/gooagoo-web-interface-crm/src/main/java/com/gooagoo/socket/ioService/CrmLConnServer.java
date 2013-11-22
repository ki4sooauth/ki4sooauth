package com.gooagoo.socket.ioService;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.socket.cache.BeanUtil;
import com.gooagoo.socket.ioHandler.CrmLConnServerHandler;

/**
 * 长连接服务器端
 */
@Component
public class CrmLConnServer
{
    /**超时时间 */
    private static final int IDELTIMEOUT = BeanUtil.LSERVER_IDLETIME;

    @Autowired
    private CrmLConnServerHandler crmLConnServerHandler;

    public void start() throws IOException
    {
        IoAcceptor acceptor = new NioSocketAcceptor();

        acceptor.getSessionConfig().setReadBufferSize(2048);
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, IDELTIMEOUT);
        acceptor.getFilterChain().addLast("threadPool", new ExecutorFilter(Executors.newCachedThreadPool()));
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());

        acceptor.setHandler(this.crmLConnServerHandler);
        acceptor.bind(new InetSocketAddress(BeanUtil.CRM_LSERVER_PORT));

        GooagooLog.debug("Long Server Listening on port " + BeanUtil.CRM_LSERVER_PORT);
    }

    //    public static void main(String[] args) throws IOException
    //    {
    //        IoAcceptor acceptor = new NioSocketAcceptor();
    //
    //        acceptor.getSessionConfig().setReadBufferSize(2048);
    //        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, IDELTIMEOUT);
    //        acceptor.getFilterChain().addLast("threadPool", new ExecutorFilter(Executors.newCachedThreadPool()));
    //        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
    //
    //        acceptor.setHandler(new CrmLConnServerHandler());
    //        acceptor.bind(new InetSocketAddress(6789));
    //        System.out.println("qindong...");
    //    }

}
