package com.gooagoo.query.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.OrderDetailInfoGeneratorQueryService;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;
import com.gooagoo.entity.generator.bill.OrderDetailInfoKey;
import com.gooagoo.dao.generator.bill.OrderDetailInfoMapper;

@Service
public class OrderDetailInfoGeneratorQueryServiceImpl implements OrderDetailInfoGeneratorQueryService
{

    @Autowired
    private OrderDetailInfoMapper orderDetailInfoMapper;

    @Override
    public Integer countByExample(OrderDetailInfoExample orderDetailInfoExample) 
    {
        return this.orderDetailInfoMapper.countByExample(orderDetailInfoExample);
    }

    @Override
    public List<OrderDetailInfo> selectByExample(OrderDetailInfoExample orderDetailInfoExample) 
    {
        return this.orderDetailInfoMapper.selectByExample(orderDetailInfoExample);
    }

    @Override
    public OrderDetailInfo selectByPrimaryKey(String primaryKey) 
    {
        OrderDetailInfoKey orderDetailInfoKey = new OrderDetailInfoKey();
        orderDetailInfoKey.setOrderDetailId(primaryKey);
        return this.orderDetailInfoMapper.selectByPrimaryKey(orderDetailInfoKey);
    }

}
