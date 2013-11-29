package com.gooagoo.core.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.bill.OrderDetailInfoGeneratorCoreService;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;
import com.gooagoo.entity.generator.bill.OrderDetailInfoKey;
import com.gooagoo.dao.generator.bill.OrderDetailInfoMapper;

@Service
public class OrderDetailInfoGeneratorCoreServiceImpl implements OrderDetailInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(OrderDetailInfoExample orderDetailInfoExample) 
    {
        return this.orderDetailInfoMapper.deleteByExample(orderDetailInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        OrderDetailInfoKey orderDetailInfoKey = new OrderDetailInfoKey();
        orderDetailInfoKey.setOrderDetailId(primaryKey);
        return this.orderDetailInfoMapper.deleteByPrimaryKey(orderDetailInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(OrderDetailInfo orderDetailInfo) 
    {
        return this.orderDetailInfoMapper.insertSelective(orderDetailInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(OrderDetailInfo orderDetailInfo,OrderDetailInfoExample orderDetailInfoExample) 
    {
        return this.orderDetailInfoMapper.updateByExampleSelective(orderDetailInfo,orderDetailInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(OrderDetailInfo orderDetailInfo) 
    {
        return this.orderDetailInfoMapper.updateByPrimaryKeySelective(orderDetailInfo) > 0 ? true : false;
    }

}
