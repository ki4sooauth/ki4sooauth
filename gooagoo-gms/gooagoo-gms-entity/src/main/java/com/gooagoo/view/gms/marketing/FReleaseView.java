package com.gooagoo.view.gms.marketing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gooagoo.view.gms.member.FCardLvl;

/**
 * 营销事件相关内容信息
 */
public class FReleaseView implements Serializable
{
    private static final long serialVersionUID = 1L;
    private List<FCardLvl> cardList = new ArrayList<FCardLvl>();
    private List<FCoupon> couponList = new ArrayList<FCoupon>();

    public List<FCardLvl> getCardList()
    {
        return this.cardList;
    }

    public void setCardList(List<FCardLvl> cardList)
    {
        this.cardList = cardList;
    }

    public List<FCoupon> getCouponList()
    {
        return this.couponList;
    }

    public void setCouponList(List<FCoupon> couponList)
    {
        this.couponList = couponList;
    }

}
