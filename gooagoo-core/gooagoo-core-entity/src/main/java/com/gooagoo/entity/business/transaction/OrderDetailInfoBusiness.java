package com.gooagoo.entity.business.transaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gooagoo.entity.generator.bill.OrderDetailInfo;

public class OrderDetailInfoBusiness implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 账单id  */
    private String orderid = "";

    /** 订单状态（订单状态，0-用户提交，1-商家处理，2-申请结账，3-已结账）  */
    private String billtype = "";

    /** 第三方订单编号  */
    private String thirdorderid = "";

    /** 店铺id  */
    private String shopid = "";

    /** 实体店编号  */
    private String shopentityid = "";
    /** 桌号  */
    private String tableNo = "";
    /** 用户id  */
    private String userid = "";

    /** 取货状态:Y-已取货、N-未取货 */
    private String deliveryStatus = "";

    /** 是否提交开发票申请:（Y，N）  */
    private String invoiceApplication = "";

    /** 账单得到时间（手机端用以表示消费时间）  */
    private String requesttime = "";

    /** 用户卡id  */
    private String scardno = "";

    /** 打折率  */
    private String discountrate = "";

    /** 商品累计数，当前订单商品总数  */
    private String goodstotalnum = "";

    /** 原始总价  */
    private String originalprice = "";

    /** 实收总价  */
    private String payprice = "";

    /** 本次积分  */
    private String integralnumber = "";

    /** 是否开过发票（0，否，1，申请中，2，已开）  */
    private String isinvoice = "";

    /** 开票时间  */
    private String invoicetime = "";

    /** 是否删除  */
    private String isdel = "";

    /** 申请时间  */
    private String createtime = "";

    /** 时间戳  */
    private String ctimestamp = "";

    /** 账单图片，如有多个，以json保存，如["year","month"]  */
    private String billimg = "";

    /** 最晚开发票时间  */
    private String invoicelatesttime = "";

    /** 账单中的取货凭证二维码  */
    private String proofcode = "";

    /** 账单商品列表  */
    private List<OrderDetailInfo> orderDetailInfoList = new ArrayList<OrderDetailInfo>();

    public String getOrderid()
    {
        return this.orderid;
    }

    public void setOrderid(String orderid)
    {
        this.orderid = orderid;
    }

    public String getBilltype()
    {
        return this.billtype;
    }

    public void setBilltype(String billtype)
    {
        this.billtype = billtype;
    }

    public String getThirdorderid()
    {
        return this.thirdorderid;
    }

    public void setThirdorderid(String thirdorderid)
    {
        this.thirdorderid = thirdorderid;
    }

    public String getShopid()
    {
        return this.shopid;
    }

    public void setShopid(String shopid)
    {
        this.shopid = shopid;
    }

    public String getShopentityid()
    {
        return this.shopentityid;
    }

    public void setShopentityid(String shopentityid)
    {
        this.shopentityid = shopentityid;
    }

    public String getTableNo()
    {
        return this.tableNo;
    }

    public void setTableNo(String tableNo)
    {
        this.tableNo = tableNo;
    }

    public String getUserid()
    {
        return this.userid;
    }

    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public String getDeliveryStatus()
    {
        return this.deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus)
    {
        this.deliveryStatus = deliveryStatus;
    }

    public String getInvoiceApplication()
    {
        return this.invoiceApplication;
    }

    public void setInvoiceApplication(String invoiceApplication)
    {
        this.invoiceApplication = invoiceApplication;
    }

    public String getRequesttime()
    {
        return this.requesttime;
    }

    public void setRequesttime(String requesttime)
    {
        this.requesttime = requesttime;
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

    public String getIntegralnumber()
    {
        return this.integralnumber;
    }

    public void setIntegralnumber(String integralnumber)
    {
        this.integralnumber = integralnumber;
    }

    public String getIsinvoice()
    {
        return this.isinvoice;
    }

    public void setIsinvoice(String isinvoice)
    {
        this.isinvoice = isinvoice;
    }

    public String getInvoicetime()
    {
        return this.invoicetime;
    }

    public void setInvoicetime(String invoicetime)
    {
        this.invoicetime = invoicetime;
    }

    public String getIsdel()
    {
        return this.isdel;
    }

    public void setIsdel(String isdel)
    {
        this.isdel = isdel;
    }

    public String getCreatetime()
    {
        return this.createtime;
    }

    public void setCreatetime(String createtime)
    {
        this.createtime = createtime;
    }

    public String getCtimestamp()
    {
        return this.ctimestamp;
    }

    public void setCtimestamp(String ctimestamp)
    {
        this.ctimestamp = ctimestamp;
    }

    public String getBillimg()
    {
        return this.billimg;
    }

    public void setBillimg(String billimg)
    {
        this.billimg = billimg;
    }

    public String getInvoicelatesttime()
    {
        return this.invoicelatesttime;
    }

    public void setInvoicelatesttime(String invoicelatesttime)
    {
        this.invoicelatesttime = invoicelatesttime;
    }

    public String getProofcode()
    {
        return this.proofcode;
    }

    public void setProofcode(String proofcode)
    {
        this.proofcode = proofcode;
    }

    public List<OrderDetailInfo> getOrderDetailInfoList()
    {
        return this.orderDetailInfoList;
    }

    public void setOrderDetailInfoList(List<OrderDetailInfo> orderDetailInfoList)
    {
        this.orderDetailInfoList = orderDetailInfoList;
    }

}
