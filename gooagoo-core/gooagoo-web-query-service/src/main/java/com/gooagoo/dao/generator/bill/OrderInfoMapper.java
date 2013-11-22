package com.gooagoo.dao.generator.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfoKey;

public interface OrderInfoMapper
{

    public Integer countByExample(OrderInfoExample orderInfoExample);

    public List<OrderInfo> selectByExample(OrderInfoExample orderInfoExample);

    public OrderInfo selectByPrimaryKey(OrderInfoKey orderInfoKey);

}
