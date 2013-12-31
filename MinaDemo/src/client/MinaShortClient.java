package client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class MinaShortClient
{
    private static final int PORT = 8001;

    public static void main(String[] args) throws IOException, InterruptedException
    {
        //代表客户端
        IoConnector connector = new NioSocketConnector();
        //获取sessionconfig对象 
        connector.getSessionConfig().setReadBufferSize(2048);
        connector.getFilterChain().addLast("logger", new LoggingFilter());
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
        connector.setHandler(new MinaShortClientHandler());
        for (int i = 1; i <= 10; i++)
        {
            ConnectFuture future = connector.connect(new InetSocketAddress("127.0.0.1", PORT));
            future.awaitUninterruptibly();
            IoSession session = future.getSession();
            session.write(i);
            session.getCloseFuture().awaitUninterruptibly();
            System.out.println("result =" + session.getAttribute("result"));
        }
        connector.dispose();
    }
}
