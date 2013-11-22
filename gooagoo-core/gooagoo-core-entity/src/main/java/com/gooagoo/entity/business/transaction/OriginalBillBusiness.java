package com.gooagoo.entity.business.transaction;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.entity.generator.bill.OriginalBillDetail;
import com.gooagoo.entity.generator.bill.OriginalBillInfo;
import com.gooagoo.entity.generator.bill.OriginalBillPic;

/**
 * 原始账单信息
 * @author YL
 *
 */
public class OriginalBillBusiness implements Serializable
{
    private static final long serialVersionUID = 1L;

    private OriginalBillInfo originalBillInfo;//用户订单原始信息
    private List<OriginalBillDetail> originalBillDetailList;//用户订单原始信息商品详情
    private OriginalBillPic originalBillPic;//用户订单原始信息优惠凭证详情

    public OriginalBillInfo getOriginalBillInfo()
    {
        return this.originalBillInfo;
    }

    public void setOriginalBillInfo(OriginalBillInfo originalBillInfo)
    {
        this.originalBillInfo = originalBillInfo;
    }

    public List<OriginalBillDetail> getOriginalBillDetailList()
    {
        return this.originalBillDetailList;
    }

    public void setOriginalBillDetailList(List<OriginalBillDetail> originalBillDetailList)
    {
        this.originalBillDetailList = originalBillDetailList;
    }

    public OriginalBillPic getOriginalBillPic()
    {
        return this.originalBillPic;
    }

    public void setOriginalBillPic(OriginalBillPic originalBillPic)
    {
        this.originalBillPic = originalBillPic;
    }

}
