package server;

import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.Map;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinaShortConnServerHandler extends IoHandlerAdapter
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sessionOpened(IoSession session)
    {
        InetSocketAddress remoteAddress = (InetSocketAddress) session.getRemoteAddress();
        this.logger.info(remoteAddress.getAddress().getHostAddress());
        this.logger.info(String.valueOf(session.getId()));
    }

    @Override
    public void messageReceived(IoSession session, Object message)
    {
        this.logger.info("Message received in the short connect server...");
        String expression = message.toString();
        Initialization init = Initialization.getInstance();
        Map<String, IoSession> clientMap = init.getClientMap();
        if (clientMap == null || clientMap.size() == 0)
        {
            session.write("error");
        }
        else
        {
            IoSession longConnSession = null;
            Iterator<String> iterator = clientMap.keySet().iterator();
            String key = "";
            while (iterator.hasNext())
            {
                key = iterator.next();
                longConnSession = clientMap.get(key);
            }
            this.logger.info("Short Connect Server Session ID :" + String.valueOf(session.getId()));
            this.logger.info("Long Connect Server Session ID :" + String.valueOf(longConnSession.getId()));
            longConnSession.setAttribute("shortConnSession", session);
            longConnSession.write(expression);
        }
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
