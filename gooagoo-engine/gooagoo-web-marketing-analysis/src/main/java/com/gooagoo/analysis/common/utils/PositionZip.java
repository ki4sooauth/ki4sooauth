package com.gooagoo.analysis.common.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gooagoo.common.utils.ZipUtil;
import com.gooagoo.entity.position.Behavior;
import com.gooagoo.entity.position.Position;

public class PositionZip
{
    /**
     * 检测字符串是否为 List<Behavior>压缩数据
     * @param zipStr
     * @return
     */
    public static boolean isTypeBehavior(String zipStr)
    {
        if (zipStr == null || zipStr.length() == 0)
        {
            return false;
        }
        if ('B' == zipStr.charAt(0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 检测字符串是否为 List<Position>压缩数据
     * @param zipStr
     * @return
     */
    public static boolean isTypePosition(String zipStr)
    {
        if (zipStr == null || zipStr.length() == 0)
        {
            return false;
        }
        if ('P' == zipStr.charAt(0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 将行为数组压缩成字符串
     * @param behaviors
     * @return
     * @throws IOException
     */
    public static String fromBehavior(List<Behavior> behaviors) throws IOException
    {
        byte[] bytes = new byte[behaviors.size() * 103];
        for (int i = 0; i < behaviors.size(); i++)
        {
            byte[] single = new byte[103];
            Behavior behavior = behaviors.get(i);
            String[] macps = behavior.getMacAddress().split(":");
            for (int j = 0; j < 6; j++)
            {
                single[j] = (byte) Integer.parseInt(macps[j], 16);
            }
            System.arraycopy(behavior.getBehaviour().getBytes(), 0, single, 6, 1);//1字节行为类型 总计7字节
            System.arraycopy(behavior.getPositionId().getBytes(), 0, single, 7, 32);//32字节区域id 总计39字节
            System.arraycopy(behavior.getShopId().getBytes(), 0, single, 39, 32);//32字节商家id 总计71字节
            System.arraycopy(behavior.getEntityId().getBytes(), 0, single, 71, 32);//32字节实体店id 总计71字节
            System.arraycopy(single, 0, bytes, i * 103, 103);
        }
        return 'B' + ZipUtil.compress(new String(bytes, "ISO-8859-1"));
    }

    /**
     * 将字符串压缩成行为对象数组
     * @param input
     * @return
     * @throws IOException
     */
    public static List<Behavior> toBehavior(String input) throws IOException
    {
        byte[] bytes = ZipUtil.uncompress(input.substring(1)).getBytes("ISO-8859-1");
        List<Behavior> behaviors = new ArrayList<Behavior>((bytes.length) / 71);
        for (int i = 0; i < (bytes.length) / 103; i++)
        {
            Behavior behavior = new Behavior();
            byte[] single = new byte[103];
            System.arraycopy(bytes, i * 103, single, 0, 103);

            behavior.setMacAddress(byteToMac(single, 0)); //mac
            behavior.setBehaviour(new String(single, 6, 1)); //行为
            behavior.setPositionId(new String(single, 7, 32));//区域id
            behavior.setShopId(new String(single, 39, 32));//区域id
            behavior.setEntityId(new String(single, 71, 32));//区域id
            behaviors.add(behavior);
        }
        return behaviors;
    }

    /**
     * 将定位数组转换成压缩字符串
     * @param positions
     * @return
     * @throws IOException
     */
    public static String fromPosition(List<Position> positions) throws IOException
    {
        byte[] bs = new byte[positions.size() * 54];
        for (int i = 0; i < positions.size(); i++)
        {
            byte[] single = new byte[54];
            Position position = positions.get(i);
            String[] macps = position.getMacAddress().split(":");
            for (int j = 0; j < 6; j++)
            {
                single[j] = (byte) Integer.parseInt(macps[j], 16);
            }
            //前6个字节 mac 总计6字节
            System.arraycopy(doubleToBytes(position.getX()), 0, single, 6, 8); //8字节x座标 总计14字节
            System.arraycopy(doubleToBytes(position.getY()), 0, single, 14, 8);//8字节y座标 总计22字节
            System.arraycopy(position.getMapId().getBytes(), 0, single, 22, 32);//32字节地图id 总计54字节
            System.arraycopy(single, 0, bs, i * 54, 54);
        }
        return 'P' + ZipUtil.compress(new String(bs, "ISO-8859-1"));
    }

    /**
     * 将压缩字符串转换成定位对象数组
     * @param input
     * @return
     * @throws IOException
     */
    public static List<Position> toPosition(String input) throws IOException
    {
        byte[] bytes = ZipUtil.uncompress(input.substring(1)).getBytes("ISO-8859-1");
        List<Position> positions = new ArrayList<Position>((bytes.length) / 54);
        for (int i = 0; i < (bytes.length) / 54; i++)
        {
            Position position = new Position();
            byte[] single = new byte[54];
            System.arraycopy(bytes, i * 54, single, 0, 54);

            position.setMacAddress(byteToMac(single, 0));
            position.setX(String.valueOf(bytesToDouble(single, 6)));//x位置坐标
            position.setY(String.valueOf(bytesToDouble(single, 14)));//y位置坐标
            position.setMapId(new String(single, 22, 32)); //位置id

            positions.add(position);
        }
        return positions;
    }

    private static byte[] doubleToBytes(String strCoordinate)
    {
        byte[] bytes = new byte[8];
        long intCoordinate = Double.doubleToLongBits(Double.parseDouble(strCoordinate));

        bytes[0] = (byte) (intCoordinate >> 56);
        bytes[1] = (byte) (intCoordinate >> 48);
        bytes[2] = (byte) (intCoordinate >> 40);
        bytes[3] = (byte) (intCoordinate >> 32);
        bytes[4] = (byte) (intCoordinate >> 24);
        bytes[5] = (byte) (intCoordinate >> 16);
        bytes[6] = (byte) (intCoordinate >> 8);
        bytes[7] = (byte) (intCoordinate);
        return bytes;
    }

    private static double bytesToDouble(byte[] bytes, int start)
    {
        byte[] byteDouble = new byte[8];
        System.arraycopy(bytes, start, byteDouble, 0, 8);
        long coordinate = 0;
        coordinate += ((long) byteDouble[0] & 255) << 56;
        coordinate += ((long) byteDouble[1] & 255) << 48;
        coordinate += ((long) byteDouble[2] & 255) << 40;
        coordinate += ((long) byteDouble[3] & 255) << 32;
        coordinate += ((long) byteDouble[4] & 255) << 24;
        coordinate += ((long) byteDouble[5] & 255) << 16;
        coordinate += ((long) byteDouble[6] & 255) << 8;
        coordinate += ((long) byteDouble[7] & 255);
        return Double.longBitsToDouble(coordinate);
    }

    private static String byteToMac(byte[] bytes, int start)
    {
        StringBuffer macAddress = new StringBuffer();//MAC地址
        for (int i = 0; i < 6; i++)
        {
            Integer ten = bytes[start + i] & 255;//和255作与运算是因为将8位的数据赋值给32位的int 高3位会补1
            macAddress.append(String.format("%02x", ten));
            macAddress.append(":");
        }
        macAddress.delete(17, 18);
        return macAddress.toString();
    }

}
