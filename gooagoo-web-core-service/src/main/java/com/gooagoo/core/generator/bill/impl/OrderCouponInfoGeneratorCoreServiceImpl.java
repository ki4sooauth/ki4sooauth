package com.gooagoo.core.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.bill.OrderCouponInfoGeneratorCoreService;
import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.OrderCouponInfoExample;
import com.gooagoo.entity.generator.bill.OrderCouponInfoKey;
import com.gooagoo.dao.generator.bill.OrderCouponInfoMapper;

@Service
public class OrderCouponInfoGeneratorCoreServiceImpl implements OrderCouponInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(OrderCouponInfoExample orderCouponInfoExample) 
    {
        return this.orderCouponInfoMapper.deleteByExample(orderCouponInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        OrderCouponInfoKey orderCouponInfoKey = new OrderCouponInfoKey();
        orderCouponInfoKey.setOrderDetailId(primaryKey);
        return this.orderCouponInfoMapper.deleteByPrimaryKey(orderCouponInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(OrderCouponInfoExample orderCouponInfoExample) 
    {
        OrderCouponInfo orderCouponInfo = new OrderCouponInfo();
        orderCouponInfo.setIsDel("Y");
        return this.orderCouponInfoMapper.updateByExampleSelective(orderCouponInfo,orderCouponInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        OrderCouponInfo orderCouponInfo = new OrderCouponInfo();
        orderCouponInfo.setOrderDetailId(primaryKey);
        orderCouponInfo.setIsDel("Y");
        return this.orderCouponInfoMapper.updateByPrimaryKeySelective(orderCouponInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(OrderCouponInfo orderCouponInfo) 
    {
        return this.orderCouponInfoMapper.insertSelective(orderCouponInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(OrderCouponInfo orderCouponInfo,OrderCouponInfoExample orderCouponInfoExample) 
    {
        return this.orderCouponInfoMapper.updateByExampleSelective(orderCouponInfo,orderCouponInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(OrderCouponInfo orderCouponInfo) 
    {
        return this.orderCouponInfoMapper.updateByPrimaryKeySelective(orderCouponInfo) > 0 ? true : false;
    }

}
