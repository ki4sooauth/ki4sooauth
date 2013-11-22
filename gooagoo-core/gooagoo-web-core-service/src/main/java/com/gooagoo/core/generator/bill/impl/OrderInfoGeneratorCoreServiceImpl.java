package com.gooagoo.core.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.bill.OrderInfoGeneratorCoreService;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfoKey;
import com.gooagoo.dao.generator.bill.OrderInfoMapper;

@Service
public class OrderInfoGeneratorCoreServiceImpl implements OrderInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(OrderInfoExample orderInfoExample) 
    {
        return this.orderInfoMapper.deleteByExample(orderInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        OrderInfoKey orderInfoKey = new OrderInfoKey();
        orderInfoKey.setOrderId(primaryKey);
        return this.orderInfoMapper.deleteByPrimaryKey(orderInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(OrderInfoExample orderInfoExample) 
    {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setIsDel("Y");
        return this.orderInfoMapper.updateByExampleSelective(orderInfo,orderInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(primaryKey);
        orderInfo.setIsDel("Y");
        return this.orderInfoMapper.updateByPrimaryKeySelective(orderInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(OrderInfo orderInfo) 
    {
        return this.orderInfoMapper.insertSelective(orderInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(OrderInfo orderInfo,OrderInfoExample orderInfoExample) 
    {
        return this.orderInfoMapper.updateByExampleSelective(orderInfo,orderInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(OrderInfo orderInfo) 
    {
        return this.orderInfoMapper.updateByPrimaryKeySelective(orderInfo) > 0 ? true : false;
    }

}
