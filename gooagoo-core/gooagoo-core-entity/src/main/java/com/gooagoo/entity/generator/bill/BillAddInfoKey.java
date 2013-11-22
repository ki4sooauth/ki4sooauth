package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 用户提交的加菜减菜申请（仅针对餐饮）
 */

public class BillAddInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String orderDetailId;//订单明细编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getOrderDetailId()
    {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId)
    {
        this.orderDetailId = orderDetailId;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

}
