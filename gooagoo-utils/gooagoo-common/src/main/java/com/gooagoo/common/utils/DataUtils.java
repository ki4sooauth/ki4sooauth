package com.gooagoo.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.Random;

import com.gooagoo.common.log.GooagooLog;

/**
 * 数据处理工具类
 * @author frenn
 *
 */
public class DataUtils
{
    /**
     * 保留两位小数
     * @param number
     * @return
     */
    public static String format2Decimal(Double number)
    {
        DecimalFormat df = new java.text.DecimalFormat("##0.00");
        return df.format(number);
    }

    /**
     * 计算x的y次方
     * @param x
     * @param y
     * @return
     */
    public static String power(int x, int y)
    {
        int[] text = new int[1000];
        text[0] = 1;
        for (int i = 0; i < y; i++)
        {
            /**底数与数组中的每一位整数相乘**/
            for (int j = 0; j < text.length; j++)
            {
                text[j] *= x;
            }
            /**进位**/
            for (int j = 0; j < text.length - 1; j++)
            {
                text[j + 1] += text[j] / 10;
                text[j] = text[j] % 10;
            }
        }
        StringBuffer buffer = new StringBuffer();
        int temp = 0;
        for (int i = text.length - 1; i >= 0; i--)
        {
            if (text[i] != 0)
            {
                temp = i;
                break;
            }
        }
        for (int i = temp; i >= 0; i--)
        {
            buffer.append(text[i]);
        }
        return buffer.toString();
    }

    /**
     * 序列化
     * @param object
     * @return
     */
    public static byte[] serialize(Object object)
    {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try
        {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        }
        catch (Exception e)
        {
            GooagooLog.error("序列化异常", e);
            return null;
        }
        finally
        {
            if (oos != null)
            {
                try
                {
                    oos.close();
                }
                catch (IOException e)
                {
                    GooagooLog.error("序列化关闭oos异常", e);
                }
            }
            if (baos != null)
            {
                try
                {
                    baos.close();
                }
                catch (IOException e)
                {
                    GooagooLog.error("序列化关闭baos异常", e);
                }
            }
        }
    }

    /**
     * 反序列化
     * @param bytes
     * @return
     */
    public static Object unserialize(byte[] bytes)
    {
        ObjectInputStream ois = null;
        ByteArrayInputStream bais = null;
        try
        {
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        }
        catch (Exception e)
        {
            GooagooLog.error("反序列化异常", e);
            return null;
        }
        finally
        {
            if (ois != null)
            {
                try
                {
                    ois.close();
                }
                catch (IOException e)
                {
                    GooagooLog.error("反序列化关闭ois异常", e);
                }
            }
            if (bais != null)
            {
                try
                {
                    bais.close();
                }
                catch (IOException e)
                {
                    GooagooLog.error("反序列化关闭bais异常", e);
                }
            }
        }
    }

    /**
     * 获取随机数
     * @param nums  随机数位数
     * @return
     */
    public static String getRandom(int nums)
    {
        String result = "";
        Random random = new Random();
        for (int i = 0; i < nums; i++)
        {
            result += random.nextInt(10);
        }
        return result;
    }
}
