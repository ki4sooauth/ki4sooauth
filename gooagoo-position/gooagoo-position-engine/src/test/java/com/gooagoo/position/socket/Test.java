package com.gooagoo.position.socket;

public class Test
{
    public static void main(String[] args) throws Exception
    {

        System.out.println(Integer.MIN_VALUE >> 31);
        byte[] mac = generateMac();
        String macStr = bytesToMac(mac);
        //System.out.println(macStr);
        byte[] ib = intToByte(Integer.MAX_VALUE);
        System.out.println(bytesToInt(ib));
    }

    private static String bytesToMac(byte[] mac)
    {
        StringBuffer buffer = new StringBuffer();
        for (int j = 0; j < 6; j++)
        {
            Integer ten = mac[j] & 255;//和255作与运算是因为将8位的数据赋值给32位的int 高3位会补1
            System.out.println(ten);
            buffer.append(String.format("%02x", ten));
            buffer.append(":");
        }
        buffer.delete(17, 18);
        return buffer.toString();
    }

    private static byte[] generateMac()
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
    }

    private static byte[] generateXY(int a)
    {
        byte[] xy = new byte[8];
        for (int i = 0; i < 4; i++)
        {
            xy[i] = (byte) (a >> 8 * (3 - i) & 0xFF);
        }
        return xy;
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
