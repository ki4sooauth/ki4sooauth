package com.gooagoo.query.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.OrderCouponInfoGeneratorQueryService;
import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.OrderCouponInfoExample;
import com.gooagoo.entity.generator.bill.OrderCouponInfoKey;
import com.gooagoo.dao.generator.bill.OrderCouponInfoMapper;

@Service
public class OrderCouponInfoGeneratorQueryServiceImpl implements OrderCouponInfoGeneratorQueryService
{

    @Autowired
    private OrderCouponInfoMapper orderCouponInfoMapper;

    @Override
    public Integer countByExample(OrderCouponInfoExample orderCouponInfoExample) 
    {
        return this.orderCouponInfoMapper.countByExample(orderCouponInfoExample);
    }

    @Override
    public List<OrderCouponInfo> selectByExample(OrderCouponInfoExample orderCouponInfoExample) 
    {
        return this.orderCouponInfoMapper.selectByExample(orderCouponInfoExample);
    }

    @Override
    public OrderCouponInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        OrderCouponInfoKey orderCouponInfoKey = new OrderCouponInfoKey();
        orderCouponInfoKey.setIsDel("N");
        orderCouponInfoKey.setOrderDetailId(primaryKey);
        return this.orderCouponInfoMapper.selectByPrimaryKey(orderCouponInfoKey);
    }

    @Override
    public OrderCouponInfo selectByPrimaryKey(String primaryKey) 
    {
        OrderCouponInfoKey orderCouponInfoKey = new OrderCouponInfoKey();
        orderCouponInfoKey.setOrderDetailId(primaryKey);
        return this.orderCouponInfoMapper.selectByPrimaryKey(orderCouponInfoKey);
    }

}
