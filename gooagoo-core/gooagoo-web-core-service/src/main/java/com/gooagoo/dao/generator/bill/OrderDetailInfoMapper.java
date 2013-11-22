package com.gooagoo.dao.generator.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;
import com.gooagoo.entity.generator.bill.OrderDetailInfoKey;

public interface OrderDetailInfoMapper
{

    public Integer countByExample(OrderDetailInfoExample orderDetailInfoExample);

    public List<OrderDetailInfo> selectByExample(OrderDetailInfoExample orderDetailInfoExample);

    public OrderDetailInfo selectByPrimaryKey(OrderDetailInfoKey orderDetailInfoKey);

    public Integer deleteByExample(OrderDetailInfoExample orderDetailInfoExample);

    public Integer deleteByPrimaryKey(OrderDetailInfoKey orderDetailInfoKey);

    public Integer insertSelective(OrderDetailInfo orderDetailInfo);

    public Integer updateAllByExample(@Param("record") OrderDetailInfo orderDetailInfo, @Param("example") OrderDetailInfoExample orderDetailInfoExample);

    public Integer updateByExampleSelective(@Param("record") OrderDetailInfo orderDetailInfo, @Param("example") OrderDetailInfoExample orderDetailInfoExample);

    public Integer updateByPrimaryKeySelective(OrderDetailInfo orderDetailInfo);

}
