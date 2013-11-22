package com.gooagoo.position.business;

import java.util.List;

import junit.framework.TestCase;

import com.gooagoo.common.utils.UUID;
import com.gooagoo.position.entity.MacPosition;

public class BufferTest extends TestCase
{
    public void testCount()
    {
        System.out.println("Count:" + Buffer.count());
    }

    public void testPut()
    {
        System.out.println("before size:" + Buffer.count());
        for (int i = 0; i < 10; i++)
        {
            MacPosition mac = new MacPosition();
            mac.setMac(UUID.getUUID());
            Buffer.put(mac.getMac(), mac);
        }
        System.out.println("after size:" + Buffer.count());
    }

    public void testGet()
    {
        List<MacPosition> list = Buffer.get();
        for (MacPosition obj : list)
        {
            System.out.println(obj.getMac());
        }
    }
}
