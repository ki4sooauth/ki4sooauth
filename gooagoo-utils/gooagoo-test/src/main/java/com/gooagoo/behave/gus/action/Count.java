package com.gooagoo.behave.gus.action;

public class Count
{

    private static int count = 0;

    public static synchronized void add()
    {
        count++;
    }

    public static int getCount()
    {
        return count;
    }
}
