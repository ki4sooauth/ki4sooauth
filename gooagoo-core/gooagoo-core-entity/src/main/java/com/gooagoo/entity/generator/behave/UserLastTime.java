package com.gooagoo.entity.generator.behave;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户最后一次足迹以及购物时间
 */

public class UserLastTime implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String userId;//用户id

    private String shopId;//商家id

    private String shopName;//商家名称

    private Integer shopTypeRoot;//商家类型

    private String cardId;//会员卡id

    private String cardType2;//会员卡类型2，0-关注卡，1-电子卡，2-实体卡

    private String scardno;//会员卡音频编码

    private Date shoppingTime;//最后一次购物时间

    private Date strollTime;//最后一次到店时间

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public Integer getShopTypeRoot()
    {
        return this.shopTypeRoot;
    }

    public void setShopTypeRoot(Integer shopTypeRoot)
    {
        this.shopTypeRoot = shopTypeRoot;
    }

    public String getCardId()
    {
        return this.cardId;
    }

    public void setCardId(String cardId)
    {
        this.cardId = cardId;
    }

    public String getCardType2()
    {
        return this.cardType2;
    }

    public void setCardType2(String cardType2)
    {
        this.cardType2 = cardType2;
    }

    public String getScardno()
    {
        return this.scardno;
    }

    public void setScardno(String scardno)
    {
        this.scardno = scardno;
    }

    public Date getShoppingTime()
    {
        return this.shoppingTime;
    }

    public void setShoppingTime(Date shoppingTime)
    {
        this.shoppingTime = shoppingTime;
    }

    public Date getStrollTime()
    {
        return this.strollTime;
    }

    public void setStrollTime(Date strollTime)
    {
        this.strollTime = strollTime;
    }

    @Override
    public String toString()
    {
        return this.id + "^" + this.userId + "^" + this.shopId + "^" + this.shopName + "^" + this.shopTypeRoot + "^" + this.cardId + "^" + this.cardType2 + "^" + this.scardno + "^" + this.shoppingTime + "^" + this.strollTime;
    }
}
