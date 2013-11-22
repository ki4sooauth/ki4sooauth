package com.gooagoo.common.entity;

import java.io.Serializable;

public class TransData<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    private TransHeadData head = new TransHeadData();//交易头部信息
    private T data;//交易内容信息
    private String operateId;//扩展，操作对象ID

    public TransData()
    {
        super();
    }

    public TransData(TransHeadData head)
    {
        super();
        this.head = head;
    }

    public TransData(Boolean success, String resultCode, T data)
    {
        super();
        this.data = data;
        this.head.setHeadData(success, resultCode);
    }

    public TransData(Boolean success, String resultCode, T data, String operateId)
    {
        this.data = data;
        this.operateId = operateId;
        this.head.setHeadData(success, resultCode);
    }

    public TransHeadData getHead()
    {
        return this.head;
    }

    public void setHead(TransHeadData head)
    {
        this.head = head;
    }

    public T getData()
    {
        return this.data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public String getOperateId()
    {
        return this.operateId;
    }

    public void setOperateId(String operateId)
    {
        this.operateId = operateId;
    }

}
