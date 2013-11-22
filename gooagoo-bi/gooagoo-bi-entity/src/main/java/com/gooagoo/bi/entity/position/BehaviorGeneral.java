package com.gooagoo.bi.entity.position;

public class BehaviorGeneral
{
    protected String macAddress;//MAC地址
    protected String userId; //用户id
    protected boolean isMember;//是否为商家会员
    protected String behaviour;//行为
    protected String entityId; //实体店编号
    protected String shopId; //商家id

    public String getMacAddress()
    {
        return macAddress;
    }

    public void setMacAddress(String macAddress)
    {
        this.macAddress = macAddress;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public boolean isMember()
    {
        return isMember;
    }

    public void setMember(boolean isMember)
    {
        this.isMember = isMember;
    }

    public String getBehaviour()
    {
        return behaviour;
    }

    public void setBehaviour(String behaviour)
    {
        this.behaviour = behaviour;
    }

    public String getEntityId()
    {
        return entityId;
    }

    public void setEntityId(String entityId)
    {
        this.entityId = entityId;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }
}
