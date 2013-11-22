package com.gooagoo.position.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import com.gooagoo.position.business.Accept;
import com.gooagoo.position.log.PositionEngineLog;

public class Server extends Thread
{
    Socket socket = null;

    public Server(Socket socket)
    {
        PositionEngineLog.debug("accept from " + socket.getRemoteSocketAddress());
        this.socket = socket;
    }

    @Override
    public void run()
    {
        PositionEngineLog.debug("Server start........");
        InputStream socketIn = null;
        try
        {
            socketIn = this.socket.getInputStream();
            StringBuilder stringBuilder = new StringBuilder();
            int buffSize = 30;
            byte[] buff = new byte[buffSize];
            int len = -1;
            while ((len = socketIn.read(buff)) != -1)
            {
                if (len == buffSize)
                {
                    stringBuilder.append(new String(buff, "ISO-8859-1"));
                }
                else
                {
                    byte[] newbuff = new byte[len];
                    System.arraycopy(buff, 0, newbuff, 0, len);
                    stringBuilder.append(new String(newbuff, "ISO-8859-1"));
                }
            }
            Accept.acceptFromStream(stringBuilder.toString());
        }
        catch (IOException e)
        {
            PositionEngineLog.error("Server", e);
        }
        finally
        {
            try
            {
                if (this.socket != null)
                {
                    this.socket.close();
                }
                if (socketIn != null)
                {
                    socketIn.close();
                }
            }
            catch (IOException e)
            {
                PositionEngineLog.error("Server", e);
            }
        }
    }
}
