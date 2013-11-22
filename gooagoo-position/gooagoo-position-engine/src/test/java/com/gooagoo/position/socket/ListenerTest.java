package com.gooagoo.position.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

import com.gooagoo.position.log.PositionEngineLog;

public class ListenerTest extends TimerTask
{
    private int size = 0;
    private int bytesize = 0;

    public static void main(String args[])
    {
        Timer timer = new Timer();
        TimerTask task = new ListenerTest();
        timer.schedule(task, 0, 1000);
    }

    @Override
    public void run()
    {
        Socket client = null;
        OutputStream os = null;
        try
        {
            client = new Socket("127.0.0.1", 4700);
            os = client.getOutputStream();
            int size = (int) (10 * Math.random());
            this.size += size;
            PositionEngineLog.debug("send record total size:" + this.size + ",current send size:" + size);
            for (int i = 0; i < size; i++)
            {
                os.write(this.generateRecord());
            }
            os.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (os != null)
                {
                    os.close();
                }
                if (client != null)
                {
                    client.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }

    private byte[] generateRecord()
    {
        int length = 21;
        if (Math.random() > 0.5 && false)
        {
            length = 19;
        }
        byte[] record = new byte[length];//19or21
        byte[] wifi_mac = this.wifiDevice();
        for (int i = 0; i < record.length; i++)
        {
            if (i < 6)
            {
                Integer m = (int) (255 * Math.random());
                record[i] = m.byteValue();
            }
            else if (i < 10)
            {
                record[i] = (byte) ((int) (10000 * Math.random()) >> 8 * (9 - i) & 0xFF);
            }
            else if (i < 14)
            {
                record[i] = (byte) ((int) (10000 * Math.random()) >> 8 * (13 - i) & 0xFF);
            }
            else if (i == 14)
            {
                if (length == 19)
                {
                    record[i] = 0;
                }
                else
                {
                    record[i] = 1;
                }
            }
            else
            {
                if (length == 21)
                {
                    record[i] = wifi_mac[-15 + i];
                }
                else
                {
                    Integer m = (int) (255 * Math.random());
                    record[i] = m.byteValue();
                }

            }
        }
        this.bytesize += record.length;
        //PositionEngineLog.debug("total byte size:" + this.bytesize + ",current byte size:" + record.length);
        return record;
    }

    private byte[] wifiDevice()
    {
        String device_mac = "64:51:7e:01:09:18";
        byte[] mac = new byte[6];
        mac[0] = new Integer(0x64).byteValue();
        mac[1] = new Integer(0x51).byteValue();
        mac[2] = new Integer(0x7e).byteValue();
        mac[3] = new Integer(0x01).byteValue();
        mac[4] = new Integer(0x09).byteValue();
        mac[5] = new Integer(0x18).byteValue();
        return mac;
    }

    private byte[] nowifiDevice()
    {
        String device_mac = "1000000a";
        byte[] mac = new byte[6];
        mac[0] = new Integer(0x64).byteValue();
        mac[1] = new Integer(0x51).byteValue();
        mac[2] = new Integer(0x7e).byteValue();
        mac[3] = new Integer(0x01).byteValue();
        mac[4] = new Integer(0x09).byteValue();
        mac[5] = new Integer(0x18).byteValue();
        return mac;
    }
    /*    private static byte[] generateMac()
        {
            byte[] mac = new byte[6];
            for (int i = 0; i < 6; i++)
            {
                Integer m = (int) (255 * Math.random());
                mac[i] = m.byteValue();
                //System.out.println(m + ":" + mac[i] + ":" + Integer.toHexString(m));
            }
            return mac;
        }

        private static byte[] intToByte(int a)
        {
            byte[] xy = new byte[4];
            for (int i = 0; i < 4; i++)
            {
                xy[i] = (byte) (a >> 8 * (3 - i) & 0xFF);
            }
            return xy;
        }*/
}
