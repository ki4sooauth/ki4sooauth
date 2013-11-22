package com.gooagoo.position.business;

import java.io.UnsupportedEncodingException;

import com.gooagoo.position.entity.MacPosition;
import com.gooagoo.position.log.PositionEngineLog;
import com.google.gson.Gson;

public class Accept
{

    public static void acceptFromStream(String input) throws UnsupportedEncodingException
    {
        byte[] stream = input.getBytes("ISO-8859-1");
        PositionEngineLog.debug("input byte size:" + stream.length);
        int point = 0;
        int record = 1;
        while (point < stream.length)
        {
            //PositionEngineLog.debug("current point value:" + point + ",current record:" + record++);
            MacPosition macPosition = new MacPosition();

            byte[] mac = new byte[6];
            System.arraycopy(stream, point, mac, 0, 6);
            macPosition.setMac(bytesToMac(mac));
            point += 6;

            byte[] x = new byte[4];
            System.arraycopy(stream, point, x, 0, 4);
            macPosition.setX(bytesToInt(x));
            point += 4;

            byte[] y = new byte[4];
            System.arraycopy(stream, point, y, 0, 4);
            //设备坐标系与SVG坐标系Y轴相反
            macPosition.setY(-bytesToInt(y));
            //macPosition.setY(bytesToInt(y));//原来的
            point += 4;

            int intBehaviour = stream[point];
            point++;
            if (intBehaviour == 0)//声波设备
            {
                byte[] btLid = new byte[6];
                System.arraycopy(stream, point, btLid, 0, 6);
                point += 6;
                macPosition.setType('0');
                macPosition.setDevice(bytesToLid(btLid));
            }
            else
            {
                byte[] btWifi = new byte[6];//WiFi设备
                System.arraycopy(stream, point, btWifi, 0, 6);
                point += 6;
                macPosition.setType('1');
                macPosition.setDevice(bytesToMac(btWifi));
            }
            PositionEngineLog.debug("[Accept]MacPosition:" + new Gson().toJson(macPosition));
            Buffer.put(macPosition.getMac(), macPosition);
        }
    }

    private static String bytesToLid(byte[] bytes)
    {
        StringBuffer buffer = new StringBuffer();
        for (int j = 0; j < 6; j++)
        {
            Integer ten = bytes[j] & 255;//和255作与运算是因为将8位的数据赋值给32位的int 高3位会补1
            buffer.append(String.format("%02x", ten));
        }
        return buffer.toString();
    }

    private static String bytesToMac(byte[] mac)
    {
        StringBuffer buffer = new StringBuffer();
        for (int j = 0; j < 6; j++)
        {
            Integer ten = mac[j] & 255;//和255作与运算是因为将8位的数据赋值给32位的int 高3位会补1
            buffer.append(String.format("%02x", ten));
            buffer.append(":");
        }
        buffer.delete(17, 18);
        return buffer.toString();
    }

    private static int bytesToInt(byte[] bytes)
    {
        int coordinate = 0;
        coordinate += bytes[0] << 24;
        coordinate += bytes[1] << 16 & 16711680;
        coordinate += bytes[2] << 8 & 65280;
        coordinate += bytes[3] & 255;
        return coordinate;
    }
}
