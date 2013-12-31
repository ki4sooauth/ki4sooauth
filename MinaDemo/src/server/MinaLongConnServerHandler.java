package server;

import java.net.InetSocketAddress;
import java.util.Map;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinaLongConnServerHandler extends IoHandlerAdapter
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sessionOpened(IoSession session)
    {
        InetSocketAddress remoteAddress = (InetSocketAddress) session.getRemoteAddress();
        String clientIp = remoteAddress.getAddress().getHostAddress();
        this.logger.info("Long Connect Server opened Session ID =" + String.valueOf(session.getId()));
        this.logger.info("接收来自客户端 :" + clientIp + "的连接.");
        Initialization init = Initialization.getInstance();
        Map<String, IoSession> clientMap = init.getClientMap();
        clientMap.put(clientIp, session);
    }

    @Override
    public void messageReceived(IoSession session, Object message)
    {
        this.logger.info("Message received in the long connect server..");
        String expression = message.toString();
        this.logger.info("Message is: " + expression);
        IoSession shortConnSession = (IoSession) session.getAttribute("shortConnSession");
        this.logger.info("Short Connect Server Session ID =" + String.valueOf(shortConnSession.getId()));
        shortConnSession.write(expression);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status)
    {
        this.logger.info("Disconnecting the idle.");
        // disconnect an idle client
        session.close(true);
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause)
    {
        // close the connection on exceptional situation
        this.logger.warn(cause.getMessage(), cause);
        session.close(true);
    }
}
