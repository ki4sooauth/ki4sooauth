package com.gooagoo.dao.generator.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;
import com.gooagoo.entity.generator.bill.OrderDetailInfoKey;

public interface OrderDetailInfoMapper
{

    public Integer countByExample(OrderDetailInfoExample orderDetailInfoExample);

    public List<OrderDetailInfo> selectByExample(OrderDetailInfoExample orderDetailInfoExample);

    public OrderDetailInfo selectByPrimaryKey(OrderDetailInfoKey orderDetailInfoKey);

}
