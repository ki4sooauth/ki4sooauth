package com.gooagoo.dao.generator.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfoKey;

public interface OrderInfoMapper
{

    public Integer countByExample(OrderInfoExample orderInfoExample);

    public List<OrderInfo> selectByExample(OrderInfoExample orderInfoExample);

    public OrderInfo selectByPrimaryKey(OrderInfoKey orderInfoKey);

    public Integer deleteByExample(OrderInfoExample orderInfoExample);

    public Integer deleteByPrimaryKey(OrderInfoKey orderInfoKey);

    public Integer insertSelective(OrderInfo orderInfo);

    public Integer updateAllByExample(@Param("record") OrderInfo orderInfo, @Param("example") OrderInfoExample orderInfoExample);

    public Integer updateByExampleSelective(@Param("record") OrderInfo orderInfo, @Param("example") OrderInfoExample orderInfoExample);

    public Integer updateByPrimaryKeySelective(OrderInfo orderInfo);

}
