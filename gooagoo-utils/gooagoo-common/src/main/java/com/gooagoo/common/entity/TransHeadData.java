package com.gooagoo.common.entity;

import java.io.Serializable;

public class TransHeadData implements Serializable
{
    private static final long serialVersionUID = 1L;

    private boolean success;//处理结果 true-成功，false-失败
    private String serialNo;//流水号
    private String tradeCode;//接口编码
    private String tradeTime;//交易时间
    private String resultCode;//处理结果编码

    public TransHeadData()
    {
        super();
    }

    public TransHeadData(boolean success, String resultCode)
    {
        super();
        this.success = success;
        this.resultCode = resultCode;
    }

    public void setHeadData(boolean success, String resultCode)
    {
        this.success = success;
        this.resultCode = resultCode;
    }

    public boolean isSuccess()
    {
        return this.success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    public String getSerialNo()
    {
        return this.serialNo;
    }

    public void setSerialNo(String serialNo)
    {
        this.serialNo = serialNo;
    }

    public String getTradeCode()
    {
        return this.tradeCode;
    }

    public void setTradeCode(String tradeCode)
    {
        this.tradeCode = tradeCode;
    }

    public String getTradeTime()
    {
        return this.tradeTime;
    }

    public void setTradeTime(String tradeTime)
    {
        this.tradeTime = tradeTime;
    }

    public String getResultCode()
    {
        return this.resultCode;
    }

    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }

}
