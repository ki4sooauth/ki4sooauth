package com.gooagoo.socket.ioHandler;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.springframework.stereotype.Service;

import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.socket.cache.IoSessionCache;

@Service
public class GooagooLConnServerHandler extends IoHandlerAdapter
{
    private final ConcurrentMap<Long, IoSession> iosessionMap = new ConcurrentHashMap<Long, IoSession>();
    private final IoSessionCache ioSessionCache = IoSessionCache.getInstance();

    @Override
    public void messageSent(IoSession ioSession, Object message) throws Exception
    {
        System.out.println(message + "语音信息已经发送到服务器!");
    }

    /**
     * IoSession出现异常时触发
     */
    @Override
    public void exceptionCaught(IoSession ioSession, Throwable except) throws GooagooException
    {
        except.printStackTrace();
        GooagooLog.error(("SOCKET【" + ioSession.getId() + "】长连接出现异常，IoSession关闭!"), except);
        ioSession.close(true);
    }

    /**
     * IoSession空闲时触发
     */
    @Override
    public void sessionIdle(IoSession ioSession, IdleStatus idleStatus) throws GooagooException
    {
        GooagooLog.debug("SOCKET【" + ioSession.getId() + "】网络空闲超时，关闭IoSession连接！");
        ioSession.close(true);
    }

    /**
     * IoSession接收消息时触发
     */
    @Override
    public void messageReceived(IoSession ioSession, Object message) throws GooagooException
    {
        System.out.println("receive-->" + message);
        ioSession.write("收到了");
        System.out.println("88888");
    }

    /**
     * IoSession关闭时触发
     */
    @SuppressWarnings("rawtypes")
    @Override
    public void sessionClosed(IoSession ioSession) throws GooagooException
    {
        GooagooLog.debug("SOCKET【" + ioSession.getId() + "】，关闭IoSession连接！");
    }
}
