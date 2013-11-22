package com.gooagoo.dao.generator.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.OrderCouponInfoExample;
import com.gooagoo.entity.generator.bill.OrderCouponInfoKey;

public interface OrderCouponInfoMapper
{

    public Integer countByExample(OrderCouponInfoExample orderCouponInfoExample);

    public List<OrderCouponInfo> selectByExample(OrderCouponInfoExample orderCouponInfoExample);

    public OrderCouponInfo selectByPrimaryKey(OrderCouponInfoKey orderCouponInfoKey);

}
