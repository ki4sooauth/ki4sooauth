package com.gooagoo.entity.business.transaction;

import java.io.Serializable;

import com.gooagoo.entity.generator.bill.OrderDetailInfo;

/**
 * 订单 
 */
public class OrderDetailInfo4TableBusiness implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 点菜单id  */
    private String orderid = "";

    /** 商家id  */
    private String shopid = "";

    /** 用户id  */
    private String userid = "";

    /** 用户会员卡id  */
    private String scardno = "";

    /** 打折率  */
    private String discountrate = "";

    /** 商品累计数量  */
    private String goodstotalnum = "";

    /** 原始价格总数  */
    private String originalprice = "";

    /** 实收总额  */
    private String payprice = "";

    /** 商家名称  */
    private String shopname = "";

    /** 商家logo  */
    private String logo = "";

    /** 点菜单图片路径  */
    private String billimg = "";

    /** 桌号  */
    private String deskname = "";

    /** 房间号  */
    private String roomname = "";

    /** 商品信息列表  */
    private java.util.List<OrderDetailInfo> orderDetailInfoList = new java.util.ArrayList<OrderDetailInfo>();

    public String getOrderid()
    {
        return this.orderid;
    }

    public void setOrderid(String orderid)
    {
        this.orderid = orderid;
    }

    public String getShopid()
    {
        return this.shopid;
    }

    public void setShopid(String shopid)
    {
        this.shopid = shopid;
    }

    public String getUserid()
    {
        return this.userid;
    }

    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public String getScardno()
    {
        return this.scardno;
    }

    public void setScardno(String scardno)
    {
        this.scardno = scardno;
    }

    public String getDiscountrate()
    {
        return this.discountrate;
    }

    public void setDiscountrate(String discountrate)
    {
        this.discountrate = discountrate;
    }

    public String getGoodstotalnum()
    {
        return this.goodstotalnum;
    }

    public void setGoodstotalnum(String goodstotalnum)
    {
        this.goodstotalnum = goodstotalnum;
    }

    public String getOriginalprice()
    {
        return this.originalprice;
    }

    public void setOriginalprice(String originalprice)
    {
        this.originalprice = originalprice;
    }

    public String getPayprice()
    {
        return this.payprice;
    }

    public void setPayprice(String payprice)
    {
        this.payprice = payprice;
    }

    public String getShopname()
    {
        return this.shopname;
    }

    public void setShopname(String shopname)
    {
        this.shopname = shopname;
    }

    public String getLogo()
    {
        return this.logo;
    }

    public void setLogo(String logo)
    {
        this.logo = logo;
    }

    public String getBillimg()
    {
        return this.billimg;
    }

    public void setBillimg(String billimg)
    {
        this.billimg = billimg;
    }

    public String getDeskname()
    {
        return this.deskname;
    }

    public void setDeskname(String deskname)
    {
        this.deskname = deskname;
    }

    public String getRoomname()
    {
        return this.roomname;
    }

    public void setRoomname(String roomname)
    {
        this.roomname = roomname;
    }

    public java.util.List<OrderDetailInfo> getOrderDetailInfoList()
    {
        return this.orderDetailInfoList;
    }

    public void setOrderDetailInfoList(java.util.List<OrderDetailInfo> orderDetailInfoList)
    {
        this.orderDetailInfoList = orderDetailInfoList;
    }

    @Override
    public String toString()
    {
        return "OrderDetailInfo4TableBusiness [orderid=" + this.orderid + ", shopid=" + this.shopid + ", userid=" + this.userid + ", scardno=" + this.scardno + ", discountrate=" + this.discountrate + ", goodstotalnum=" + this.goodstotalnum + ", originalprice=" + this.originalprice + ", payprice=" + this.payprice + ", shopname=" + this.shopname + ", logo=" + this.logo + ", billimg=" + this.billimg + ", deskname=" + this.deskname + ", roomname=" + this.roomname + ", orderDetailInfoList=" + this.orderDetailInfoList + "]";
    }

}