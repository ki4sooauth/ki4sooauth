package com.gooagoo.position.entity;

import java.io.Serializable;

public class MacPosition implements Serializable
{

    private static final long serialVersionUID = -1593407718689922087L;
    private String mac; //mac地址 格式:十六进制、全小写、冒号分隔
    private int x;//x位置坐标
    private int y;//y位置坐标
    private char type;//设备类型
    private String device; //设备地址

    public String getMac()
    {
        return mac;
    }

    public void setMac(String mac)
    {
        this.mac = mac;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public char getType()
    {
        return type;
    }

    public void setType(char type)
    {
        this.type = type;
    }

    public String getDevice()
    {
        return device;
    }

    public void setDevice(String device)
    {
        this.device = device;
    }
}
