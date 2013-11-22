package com.gooagoo.view.gms.cardtop;

import java.io.Serializable;
import java.util.Date;

/**
 * 卡包营销与用户关联信息
 */
public class FCardTopAssoUser implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String cardTopInfoId;//卡包营销编号
    private String cardId;//会员卡编号
    private String shopId;//商家编号
    private String userId;//用户编号
    private String cardUserId;//会员卡用户编号
    private String scardNo;//电子卡号
    private Date createTime;//创建时间
    private Date lastModifyTime;//最后修改时间

    public String getCardTopInfoId()
    {
        return this.cardTopInfoId;
    }

    public void setCardTopInfoId(String cardTopInfoId)
    {
        this.cardTopInfoId = cardTopInfoId;
    }

    public String getCardId()
    {
        return this.cardId;
    }

    public void setCardId(String cardId)
    {
        this.cardId = cardId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getCardUserId()
    {
        return this.cardUserId;
    }

    public void setCardUserId(String cardUserId)
    {
        this.cardUserId = cardUserId;
    }

    public String getScardNo()
    {
        return this.scardNo;
    }

    public void setScardNo(String scardNo)
    {
        this.scardNo = scardNo;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getLastModifyTime()
    {
        return this.lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime)
    {
        this.lastModifyTime = lastModifyTime;
    }

}
