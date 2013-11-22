package com.gooagoo.view.gus.common;

import java.io.Serializable;

/**
 * 虚拟商家URL数据信息
 * @author GUS
 *
 */
public class UrlInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String action;

    private String typeId;

    private String marketingId;

    private String rnd;

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public String getTypeId()
    {
        return typeId;
    }

    public void setTypeId(String typeId)
    {
        this.typeId = typeId;
    }

    public String getMarketingId()
    {
        return marketingId;
    }

    public void setMarketingId(String marketingId)
    {
        this.marketingId = marketingId;
    }

    public String getRnd()
    {
        return rnd;
    }

    public void setRnd(String rnd)
    {
        this.rnd = rnd;
    }

}
