package com.gooagoo.query.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.OrderPicGeneratorQueryService;
import com.gooagoo.entity.generator.bill.OrderPic;
import com.gooagoo.entity.generator.bill.OrderPicExample;
import com.gooagoo.entity.generator.bill.OrderPicKey;
import com.gooagoo.dao.generator.bill.OrderPicMapper;

@Service
public class OrderPicGeneratorQueryServiceImpl implements OrderPicGeneratorQueryService
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

}
