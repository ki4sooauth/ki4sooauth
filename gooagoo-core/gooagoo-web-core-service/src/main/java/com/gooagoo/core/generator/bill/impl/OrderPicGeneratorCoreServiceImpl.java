package com.gooagoo.core.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.bill.OrderPicGeneratorCoreService;
import com.gooagoo.entity.generator.bill.OrderPic;
import com.gooagoo.entity.generator.bill.OrderPicExample;
import com.gooagoo.entity.generator.bill.OrderPicKey;
import com.gooagoo.dao.generator.bill.OrderPicMapper;

@Service
public class OrderPicGeneratorCoreServiceImpl implements OrderPicGeneratorCoreService
{

    @Autowired
    private OrderPicMapper orderPicMapper;

    @Override
    public Integer countByExample(OrderPicExample orderPicExample) 
    {
        return this.orderPicMapper.countByExample(orderPicExample);
    }

    @Override
    public List<OrderPic> selectByExample(OrderPicExample orderPicExample) 
    {
        return this.orderPicMapper.selectByExample(orderPicExample);
    }

    @Override
    public OrderPic selectUnDelByPrimaryKey(String primaryKey) 
    {
        OrderPicKey orderPicKey = new OrderPicKey();
        orderPicKey.setIsDel("N");
        orderPicKey.setOrderDetailId(primaryKey);
        return this.orderPicMapper.selectByPrimaryKey(orderPicKey);
    }

    @Override
    public OrderPic selectByPrimaryKey(String primaryKey) 
    {
        OrderPicKey orderPicKey = new OrderPicKey();
        orderPicKey.setOrderDetailId(primaryKey);
        return this.orderPicMapper.selectByPrimaryKey(orderPicKey);
    }

    @Override
    public boolean physicalDeleteByExample(OrderPicExample orderPicExample) 
    {
        return this.orderPicMapper.deleteByExample(orderPicExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        OrderPicKey orderPicKey = new OrderPicKey();
        orderPicKey.setOrderDetailId(primaryKey);
        return this.orderPicMapper.deleteByPrimaryKey(orderPicKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(OrderPicExample orderPicExample) 
    {
        OrderPic orderPic = new OrderPic();
        orderPic.setIsDel("Y");
        return this.orderPicMapper.updateByExampleSelective(orderPic,orderPicExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        OrderPic orderPic = new OrderPic();
        orderPic.setOrderDetailId(primaryKey);
        orderPic.setIsDel("Y");
        return this.orderPicMapper.updateByPrimaryKeySelective(orderPic) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(OrderPic orderPic) 
    {
        return this.orderPicMapper.insertSelective(orderPic) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(OrderPic orderPic,OrderPicExample orderPicExample) 
    {
        return this.orderPicMapper.updateByExampleSelective(orderPic,orderPicExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(OrderPic orderPic) 
    {
        return this.orderPicMapper.updateByPrimaryKeySelective(orderPic) > 0 ? true : false;
    }

}
