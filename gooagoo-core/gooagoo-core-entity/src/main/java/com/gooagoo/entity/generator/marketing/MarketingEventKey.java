package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;

/**
 * 营销事件
 */

public class MarketingEventKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String eventId;//事件编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getEventId()
    {
        return eventId;
    }

    public void setEventId(String eventId)
    {
        this.eventId = eventId;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

}
