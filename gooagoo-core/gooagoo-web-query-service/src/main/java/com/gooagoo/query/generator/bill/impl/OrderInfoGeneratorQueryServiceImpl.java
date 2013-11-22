package com.gooagoo.query.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.OrderInfoGeneratorQueryService;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfoKey;
import com.gooagoo.dao.generator.bill.OrderInfoMapper;

@Service
public class OrderInfoGeneratorQueryServiceImpl implements OrderInfoGeneratorQueryService
{

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public Integer countByExample(OrderInfoExample orderInfoExample) 
    {
        return this.orderInfoMapper.countByExample(orderInfoExample);
    }

    @Override
    public List<OrderInfo> selectByExample(OrderInfoExample orderInfoExample) 
    {
        return this.orderInfoMapper.selectByExample(orderInfoExample);
    }

    @Override
    public OrderInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        OrderInfoKey orderInfoKey = new OrderInfoKey();
        orderInfoKey.setIsDel("N");
        orderInfoKey.setOrderId(primaryKey);
        return this.orderInfoMapper.selectByPrimaryKey(orderInfoKey);
    }

    @Override
    public OrderInfo selectByPrimaryKey(String primaryKey) 
    {
        OrderInfoKey orderInfoKey = new OrderInfoKey();
        orderInfoKey.setOrderId(primaryKey);
        return this.orderInfoMapper.selectByPrimaryKey(orderInfoKey);
    }

}
