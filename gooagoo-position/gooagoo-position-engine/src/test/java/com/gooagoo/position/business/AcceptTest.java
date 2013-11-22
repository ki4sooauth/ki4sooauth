package com.gooagoo.position.business;

import junit.framework.TestCase;

public class AcceptTest extends TestCase
{
    public void testAcceptFromStream()
    {
        try
        {
            StringBuffer input = new StringBuffer();
            for (int i = 0; i < 10000; i++)
            {
                input.append(new String(this.generateRecord(), "ISO-8859-1"));
            }
            System.out.println("input:" + input.toString());
            Accept.acceptFromStream(input.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static byte[] generateRecord()
    {
        int size = 19;
        byte type = 0;
        if (Math.random() > 0.5)
        {
            size = 21;
            type = 1;
        }
        byte[] record = new byte[size];//19or21
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
                record[i] = type;
            }
            else
            {
                Integer m = (int) (255 * Math.random());
                record[i] = m.byteValue();
            }
        }
        return record;
    }
}
