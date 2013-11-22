package com.gooagoo.entity.position;

/**
 * 区域时长
 * @author 王宇
 *
 */
public class Duration
{
    private String macAddress;//MAC地址
    private String positionId;//位置id
    private Long duration;//时长 秒
    private String shopId; //商家id

    public String getMacAddress()
    {
        return macAddress;
    }

    public void setMacAddress(String macAddress)
    {
        this.macAddress = macAddress;
    }

    public String getPositionId()
    {
        return positionId;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }

    public Long getDuration()
    {
        return duration;
    }

    public void setDuration(Long duration)
    {
        this.duration = duration;
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
