package com.gooagoo.view.gms.apply;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单信息，记录用户订单、商家订单、账单、开发票的全程变化，对外服务的数据全都从这个表中获取。
 */

public class FOrderInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String orderId;//订单编号，UUID

    private String billType;//订单状态，-1-远程提交，0-用户提交，1-商家处理，2-申请结账，3-已结账

    private String billTypeName;//订单状态，-1-远程提交，0-用户提交，1-商家处理，2-申请结账，3-已结账
    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String userId;//用户编号

    private String mac;//商家硬件设备MAC地址

    private Date requestTime;//消费时间

    private String thirdOrderId;//第三方订单编号

    private String scardNo;//会员卡号，16位音频卡号

    private Integer goodsTotalNum;//账单商品总数

    private Double originalPrice;//原价格

    private Double discountRate;//折扣

    private Double payPrice;//实际支付价格

    private String takeMethod;//提货方式，0-直接拿走、1-前台提货、2-送货上门

    private String takeMethodName;//提货方式，0-直接拿走、1-前台提货、2-送货上门
    private String consigneeId;//收货人信息编号，关联收货人信息的主键

    private String deliveryStatus;//取货状态，0-用户未收到货物，1-商家已拣货，2-商家已发货，3-用户已收取货物

    private String deliveryStatusName;//取货状态，0-用户未收到货物，1-商家已拣货，2-商家已发货，3-用户已收取货物

    private String roomName;//房间名称（仅针对餐饮）

    private String deskName;//桌子名称（仅针对餐饮）

    private String isSaCommit;//是否店员助理提交，Y-是，N-否

    private String account;//店员助理登录帐号

    private Date userOrderTime;//用户订单提交时间

    private Date shopOrderTime;//商家订单提交时间（仅针对餐饮）

    private Date paymentApplicationTime;//申请结账时间（仅针对餐饮）

    private Date paymentTime;//结账时间

    private Date invoiceApplicationTime;//申请开发票时间

    private String isInvoice;//是否开具发票，N-未开发票，Y-已开发票

    private Date invoiceTime;//开发票时间

    private Date invoiceLatestTime;//最晚开发票时间，为结账时间+最晚开发票天数

    private String billId;//账单编号

    private String shopOrderId;//商家订单编号

    private String userOrderId;//用户订单编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public String getBillType()
    {
        return this.billType;
    }

    public void setBillType(String billType)
    {
        this.billType = billType;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getMac()
    {
        return this.mac;
    }

    public void setMac(String mac)
    {
        this.mac = mac;
    }

    public Date getRequestTime()
    {
        return this.requestTime;
    }

    public void setRequestTime(Date requestTime)
    {
        this.requestTime = requestTime;
    }

    public String getThirdOrderId()
    {
        return this.thirdOrderId;
    }

    public void setThirdOrderId(String thirdOrderId)
    {
        this.thirdOrderId = thirdOrderId;
    }

    public String getScardNo()
    {
        return this.scardNo;
    }

    public void setScardNo(String scardNo)
    {
        this.scardNo = scardNo;
    }

    public Integer getGoodsTotalNum()
    {
        return this.goodsTotalNum;
    }

    public void setGoodsTotalNum(Integer goodsTotalNum)
    {
        this.goodsTotalNum = goodsTotalNum;
    }

    public Double getOriginalPrice()
    {
        return this.originalPrice;
    }

    public void setOriginalPrice(Double originalPrice)
    {
        this.originalPrice = originalPrice;
    }

    public Double getDiscountRate()
    {
        return this.discountRate;
    }

    public void setDiscountRate(Double discountRate)
    {
        this.discountRate = discountRate;
    }

    public Double getPayPrice()
    {
        return this.payPrice;
    }

    public void setPayPrice(Double payPrice)
    {
        this.payPrice = payPrice;
    }

    public String getTakeMethod()
    {
        return this.takeMethod;
    }

    public void setTakeMethod(String takeMethod)
    {
        this.takeMethod = takeMethod;
    }

    public String getConsigneeId()
    {
        return this.consigneeId;
    }

    public void setConsigneeId(String consigneeId)
    {
        this.consigneeId = consigneeId;
    }

    public String getDeliveryStatus()
    {
        return this.deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus)
    {
        this.deliveryStatus = deliveryStatus;
    }

    public String getRoomName()
    {
        return this.roomName;
    }

    public void setRoomName(String roomName)
    {
        this.roomName = roomName;
    }

    public String getDeskName()
    {
        return this.deskName;
    }

    public void setDeskName(String deskName)
    {
        this.deskName = deskName;
    }

    public String getIsSaCommit()
    {
        return this.isSaCommit;
    }

    public void setIsSaCommit(String isSaCommit)
    {
        this.isSaCommit = isSaCommit;
    }

    public String getAccount()
    {
        return this.account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public Date getUserOrderTime()
    {
        return this.userOrderTime;
    }

    public void setUserOrderTime(Date userOrderTime)
    {
        this.userOrderTime = userOrderTime;
    }

    public Date getShopOrderTime()
    {
        return this.shopOrderTime;
    }

    public void setShopOrderTime(Date shopOrderTime)
    {
        this.shopOrderTime = shopOrderTime;
    }

    public Date getPaymentApplicationTime()
    {
        return this.paymentApplicationTime;
    }

    public void setPaymentApplicationTime(Date paymentApplicationTime)
    {
        this.paymentApplicationTime = paymentApplicationTime;
    }

    public Date getPaymentTime()
    {
        return this.paymentTime;
    }

    public void setPaymentTime(Date paymentTime)
    {
        this.paymentTime = paymentTime;
    }

    public Date getInvoiceApplicationTime()
    {
        return this.invoiceApplicationTime;
    }

    public void setInvoiceApplicationTime(Date invoiceApplicationTime)
    {
        this.invoiceApplicationTime = invoiceApplicationTime;
    }

    public String getIsInvoice()
    {
        return this.isInvoice;
    }

    public void setIsInvoice(String isInvoice)
    {
        this.isInvoice = isInvoice;
    }

    public Date getInvoiceTime()
    {
        return this.invoiceTime;
    }

    public void setInvoiceTime(Date invoiceTime)
    {
        this.invoiceTime = invoiceTime;
    }

    public Date getInvoiceLatestTime()
    {
        return this.invoiceLatestTime;
    }

    public void setInvoiceLatestTime(Date invoiceLatestTime)
    {
        this.invoiceLatestTime = invoiceLatestTime;
    }

    public String getBillId()
    {
        return this.billId;
    }

    public void setBillId(String billId)
    {
        this.billId = billId;
    }

    public String getShopOrderId()
    {
        return this.shopOrderId;
    }

    public void setShopOrderId(String shopOrderId)
    {
        this.shopOrderId = shopOrderId;
    }

    public String getUserOrderId()
    {
        return this.userOrderId;
    }

    public void setUserOrderId(String userOrderId)
    {
        this.userOrderId = userOrderId;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.orderId + "^" + this.billType + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.userId + "^" + this.mac + "^" + this.requestTime + "^" + this.thirdOrderId + "^" + this.scardNo + "^" + this.goodsTotalNum + "^" + this.originalPrice + "^" + this.discountRate + "^" + this.payPrice + "^" + this.takeMethod + "^" + this.consigneeId + "^" + this.deliveryStatus + "^" + this.roomName + "^" + this.deskName + "^" + this.isSaCommit + "^" + this.account + "^" + this.userOrderTime + "^" + this.shopOrderTime + "^" + this.paymentApplicationTime + "^" + this.paymentTime + "^" + this.invoiceApplicationTime + "^" + this.isInvoice + "^" + this.invoiceTime + "^" + this.invoiceLatestTime + "^" + this.billId + "^" + this.shopOrderId + "^" + this.userOrderId + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }

    public String getBillTypeName()
    {
        return this.billTypeName;
    }

    //订单状态，-1-远程提交，0-用户提交，1-商家处理，2-申请结账，3-已结账
    public void setBillTypeName(String billTypeName)
    {
        if (billTypeName.equals("-1"))
        {
            this.billTypeName = "远程提交";
        }
        else if (billTypeName.equals("0"))
        {
            this.billTypeName = "用户提交";
        }
        else if (billTypeName.equals("1"))
        {
            this.billTypeName = "商家处理";
        }
        else if (billTypeName.equals("2"))
        {
            this.billTypeName = "申请结账";
        }
        else if (billTypeName.equals("3"))
        {
            this.billTypeName = "已结账";
        }

    }

    public String getTakeMethodName()
    {
        return this.takeMethodName;
    }

    //提货方式，0-直接拿走、1-前台提货、2-送货上门
    public void setTakeMethodName(String takeMethodName)
    {
        if (takeMethodName.equals("0"))
        {
            this.takeMethodName = "直接拿走";
        }
        else if (takeMethodName.equals("1"))
        {
            this.takeMethodName = "前台提货";
        }
        else if (takeMethodName.equals("1"))
        {
            this.takeMethodName = "送货上门";
        }

    }

    public String getDeliveryStatusName()
    {
        return this.deliveryStatusName;
    }

    //取货状态，0-用户未收到货物，1-商家已拣货，2-商家已发货，3-用户已收取货物
    public void setDeliveryStatusName(String deliveryStatusName)
    {
        if (deliveryStatusName.equals("0"))
        {
            this.deliveryStatusName = "用户未收到货物";
        }
        else if (deliveryStatusName.equals("1"))
        {
            this.deliveryStatusName = "商家已拣货";
        }
        else if (deliveryStatusName.equals("2"))
        {
            this.deliveryStatusName = "商家已发货";
        }
        else if (deliveryStatusName.equals("3"))
        {
            this.deliveryStatusName = "用户已收取货物";
        }
    }
}
