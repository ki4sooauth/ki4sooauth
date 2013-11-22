package com.gooagoo.socket.ioService;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.socket.cache.BeanUtil;
import com.gooagoo.socket.ioHandler.GooagooLConnServerHandler;

/**
 * 长连接服务器端
 */
@Component
public class GooagooLConnServer
{
    /**超时时间 */
    private static final int IDELTIMEOUT = BeanUtil.LSERVER_IDLETIME;

    @Autowired
    private GooagooLConnServerHandler gooagooLConnServerHandler;

    public void start() throws IOException
    {
        IoAcceptor acceptor = new NioSocketAcceptor();

        acceptor.getSessionConfig().setReadBufferSize(2048);
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, IDELTIMEOUT);
        acceptor.getFilterChain().addLast("codecTexts", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
        acceptor.getFilterChain().addLast("threadPool", new ExecutorFilter(Executors.newCachedThreadPool()));
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());

        acceptor.setHandler(this.gooagooLConnServerHandler);
        acceptor.bind(new InetSocketAddress(BeanUtil.GOOAGOO_LSERVER_PORT));

        GooagooLog.debug("Long Server Listening on port " + BeanUtil.GOOAGOO_LSERVER_PORT);
    }
}
