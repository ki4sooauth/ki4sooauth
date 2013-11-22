package com.gooagoo.igms.common.thread;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.igms.common.utils.GMSLogUtil;

public class GmsLogThread implements Runnable
{
    private HttpServletRequest request;
    private TransData<Object> transData;

    public GmsLogThread(HttpServletRequest request, TransData<Object> transData)
    {
        this.request = request;
        this.transData = transData;
    }

    public HttpServletRequest getRequest()
    {
        return this.request;
    }

    public void setRequest(HttpServletRequest request)
    {
        this.request = request;
    }

    public TransData<Object> getTransData()
    {
        return this.transData;
    }

    public void setTransData(TransData<Object> transData)
    {
        this.transData = transData;
    }

    @Override
    public void run()
    {
        GMSLogUtil.sendGMSLog(this.request, this.transData);
    }

}
