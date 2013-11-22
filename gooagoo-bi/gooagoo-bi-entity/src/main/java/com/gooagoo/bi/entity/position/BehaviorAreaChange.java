package com.gooagoo.bi.entity.position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class BehaviorAreaChange extends BehaviorGeneral
{
    private List<Leave> oldArea = new ArrayList<Leave>();
    private Set<String> newArea = new HashSet<String>();

    public List<Leave> getOldArea()
    {
        return oldArea;
    }

    public void setOldArea(List<Leave> oldArea)
    {
        this.oldArea = oldArea;
    }

    public Set<String> getNewArea()
    {
        return newArea;
    }

    public void setNewArea(Set<String> newArea)
    {
        this.newArea = newArea;
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
