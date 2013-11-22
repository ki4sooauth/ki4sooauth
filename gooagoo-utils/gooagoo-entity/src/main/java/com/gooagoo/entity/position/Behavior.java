package com.gooagoo.entity.position;

public class Behavior
{
    private String macAddress;//MAC地址
    private String behaviour;//行为
    private String positionId;//位置编号
    private String shopId;//商家id
    private String entityId; //实体店编号

    public Behavior()
    {

    }

    public String getMacAddress()
    {
        return macAddress;
    }

    public void setMacAddress(String macAddress)
    {
        this.macAddress = macAddress;
    }

    public String getBehaviour()
    {
        return behaviour;
    }

    public void setBehaviour(String behaviour)
    {
        this.behaviour = behaviour;
    }

    public String getPositionId()
    {
        return positionId;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getEntityId()
    {
        return entityId;
    }

    public void setEntityId(String entityId)
    {
        this.entityId = entityId;
    }
}
