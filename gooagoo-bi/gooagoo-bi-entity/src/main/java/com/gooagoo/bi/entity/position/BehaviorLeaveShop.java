package com.gooagoo.bi.entity.position;

import java.util.ArrayList;
import java.util.List;

public final class BehaviorLeaveShop extends BehaviorGeneral
{
    private long start; //到店时间
    private long end; //离店时间
    private long duration; //在店时长(分钟)
    private List<Leave> lastArea = new ArrayList<Leave>();

    public long getStart()
    {
        return start;
    }

    public void setStart(long start)
    {
        this.start = start;
    }

    public long getEnd()
    {
        return end;
    }

    public void setEnd(long end)
    {
        this.end = end;
    }

    public long getDuration()
    {
        return duration;
    }

    public void setDuration(long duration)
    {
        this.duration = duration;
    }

    public List<Leave> getLastArea()
    {
        return lastArea;
    }

    public void setLastArea(List<Leave> lastArea)
    {
        this.lastArea = lastArea;
    }

    @Override
    public String getMacAddress()
    {
        return macAddress;
    }

    @Override
    public void setMacAddress(String macAddress)
    {
        this.macAddress = macAddress;
    }

    @Override
    public String getUserId()
    {
        return userId;
    }

    @Override
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    @Override
    public boolean isMember()
    {
        return isMember;
    }

    @Override
    public void setMember(boolean isMember)
    {
        this.isMember = isMember;
    }

    @Override
    public String getBehaviour()
    {
        return behaviour;
    }

    @Override
    public void setBehaviour(String behaviour)
    {
        this.behaviour = behaviour;
    }

    @Override
    public String getEntityId()
    {
        return entityId;
    }

    @Override
    public void setEntityId(String entityId)
    {
        this.entityId = entityId;
    }

    @Override
    public String getShopId()
    {
        return shopId;
    }

    @Override
    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }
}
