package com.gooagoo.entity.business.transaction;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 结账申请（只针对餐饮）
 * @author YL
 *
 */
public class BillPayApplicationBusiness implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String orderId;//订单编号，UUID

    private String scardno;//会员卡编号，如果没有则填写 ""

    private String applytime;//申请时间

    private String tableName;//桌号

    private String roomName;//房间名称 

    private String thirdOrderId;//第三方订单编号

    private String originalPrice;//商家处理时间

    private List<Map<String, String>> couponList;//优惠凭证{[favoriteid:"",couponcontent:""]}

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public String getScardno()
    {
        return this.scardno;
    }

    public void setScardno(String scardno)
    {
        this.scardno = scardno;
    }

    public String getApplytime()
    {
        return this.applytime;
    }

    public void setApplytime(String applytime)
    {
        this.applytime = applytime;
    }

    public String getTableName()
    {
        return this.tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getRoomName()
    {
        return this.roomName;
    }

    public void setRoomName(String roomName)
    {
        this.roomName = roomName;
    }

    public String getThirdOrderId()
    {
        return this.thirdOrderId;
    }

    public void setThirdOrderId(String thirdOrderId)
    {
        this.thirdOrderId = thirdOrderId;
    }

    public String getOriginalPrice()
    {
        return this.originalPrice;
    }

    public void setOriginalPrice(String originalPrice)
    {
        this.originalPrice = originalPrice;
    }

    public List<Map<String, String>> getCouponList()
    {
        return this.couponList;
    }

    public void setCouponList(List<Map<String, String>> couponList)
    {
        this.couponList = couponList;
    }

    @Override
    public String toString()
    {
        return "BillPayApplicationBusiness [orderId=" + this.orderId + ", scardno=" + this.scardno + ", applytime=" + this.applytime + ", tableName=" + this.tableName + ", roomName=" + this.roomName + ", thirdOrderId=" + this.thirdOrderId + ", originalPrice=" + this.originalPrice + ", couponList=" + this.couponList + "]";
    }

}
