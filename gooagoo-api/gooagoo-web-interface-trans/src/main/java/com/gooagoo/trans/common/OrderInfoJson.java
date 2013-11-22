package com.gooagoo.trans.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderInfoJson implements Serializable
{

    /**
     * 商家订单\账单数据上传json串实体对象
     */
    private static final long serialVersionUID = 1L;

    public String shopId = "";//商家编号

    public String shopEntityId = "";//商家编号

    public String lid = "";//商家lid

    public String request_start_time = "";//开台时间

    public String request_end_time = "";//开台结束时间

    public String personNum = "";//消费人数

    public String billType = "";//账单类型,meal-订单 bill-账单

    public String billNo = "";//POS软件的账单编号

    public Integer totalNum = 0;//商品总数

    public String scardno = "";//会员卡号

    public Double originalPrice = 0.0;//原价格

    public Double discountRate = 0.0;//打折率

    public Double payPrice = 0.0;//实际支付价格

    public String billImg = "";//账单图片存储路径

    public String deskNo = "";//桌号

    public String coupon = "";//优惠券号

    List<OrderGoodsInfo> list = new ArrayList<OrderGoodsInfo>();//账单/订单明细中商品信息

    /**
     * 商家编号
     * @return
     */
    public String getShopId()
    {
        return this.shopId;
    }

    /**
     * 商家编号
     * @param shopId
     */
    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    /**
     * 商家lid
     * @return
     */
    public String getLid()
    {
        return this.lid;
    }

    /**
     * 商家lid
     * @return
     */
    public void setLid(String lid)
    {
        this.lid = lid;
    }

    /**
     * 开台时间
     * @return
     */
    public String getRequest_start_time()
    {
        return this.request_start_time;
    }

    /**
     * 开台时间
     * @return
     */
    public void setRequest_start_time(String request_start_time)
    {
        this.request_start_time = request_start_time;
    }

    /**
     * 开台结束时间
     * @return
     */
    public String getRequest_end_time()
    {
        return this.request_end_time;
    }

    /**
     * 开台结束时间
     * @return
     */
    public void setRequest_end_time(String request_end_time)
    {
        this.request_end_time = request_end_time;
    }

    /**
     * 人数
     * @return
     */
    public String getPersonNum()
    {
        return this.personNum;
    }

    /**
     * 人数
     * @return
     */
    public void setPersonNum(String personNum)
    {
        this.personNum = personNum;
    }

    /**
     * 账单类型,meal-订单 bill-账单
     * @return
     */
    public String getBillType()
    {
        return this.billType;
    }

    /**
     * 账单类型,meal-订单 bill-账单
     * @return
     */
    public void setBillType(String billType)
    {
        this.billType = billType;
    }

    /**
     * POS软件的账单编号
     * @return
     */
    public String getBillNo()
    {
        return this.billNo;
    }

    /**
     * POS软件的账单编号
     * @return
     */
    public void setBillNo(String billNo)
    {
        this.billNo = billNo;
    }

    /**
     * 商品总数
     * @return
     */
    public Integer getTotalNum()
    {
        return this.totalNum;
    }

    /**
     * 商品总数
     * @return
     */
    public void setTotalNum(Integer totalNum)
    {
        this.totalNum = totalNum;
    }

    /**
     * 会员卡号
     * @return
     */
    public String getScardno()
    {
        return this.scardno;
    }

    /**
     * 会员卡号
     * @return
     */
    public void setScardno(String scardno)
    {
        this.scardno = scardno;
    }

    /**
     * 原始价格
     * @return
     */
    public Double getOriginalPrice()
    {
        return this.originalPrice;
    }

    /**
     * 原始价格
     * @return
     */
    public void setOriginalPrice(Double originalPrice)
    {
        this.originalPrice = originalPrice;
    }

    /**
     * 打折率
     * @return
     */
    public Double getDiscountRate()
    {
        return this.discountRate;
    }

    /**
     * 打折率
     * @return
     */
    public void setDiscountRate(Double discountRate)
    {
        this.discountRate = discountRate;
    }

    /**
     * 实际支付价格
     * @return
     */
    public Double getPayPrice()
    {
        return this.payPrice;
    }

    /**
     * 实际支付价格
     * @return
     */
    public void setPayPrice(Double payPrice)
    {
        this.payPrice = payPrice;
    }

    /**
     * 账单图片存储路径
     * @return
     */
    public String getBillImg()
    {
        return this.billImg;
    }

    /**
     * 账单图片存储路径
     * @return
     */
    public void setBillImg(String billImg)
    {
        this.billImg = billImg;
    }

    /**
     * 桌号
     * @return
     */
    public String getDeskNo()
    {
        return this.deskNo;
    }

    /**
     * 桌号
     * @return
     */
    public void setDeskNo(String deskNo)
    {
        this.deskNo = deskNo;
    }

    /**
     * 优惠券号
     * @return
     */
    public String getCoupon()
    {
        return this.coupon;
    }

    /**
     * 优惠券号
     * @return
     */
    public void setCoupon(String coupon)
    {
        this.coupon = coupon;
    }

    /**
     * 账单/订单明细中商品信息
     * @return
     */
    public List<OrderGoodsInfo> getList()
    {
        return this.list;
    }

    /**
     * 账单/订单明细中商品信息
     * @return
     */
    public void setList(List<OrderGoodsInfo> list)
    {
        this.list = list;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    @Override
    public String toString()
    {
        return "OrderInfoJson [shopId=" + this.shopId + ", shopEntityId=" + this.shopEntityId + ", lid=" + this.lid + ", request_start_time=" + this.request_start_time + ", request_end_time=" + this.request_end_time + ", personNum=" + this.personNum + ", billType=" + this.billType + ", billNo=" + this.billNo + ", totalNum=" + this.totalNum + ", scardno=" + this.scardno + ", originalPrice=" + this.originalPrice + ", discountRate=" + this.discountRate + ", payPrice=" + this.payPrice + ", billImg=" + this.billImg + ", deskNo=" + this.deskNo + ", coupon=" + this.coupon + ", list=" + this.list + "]";
    }

}
