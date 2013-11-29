package com.gooagoo.dao.generator.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.OrderCouponInfoExample;
import com.gooagoo.entity.generator.bill.OrderCouponInfoKey;

public interface OrderCouponInfoMapper
{

    public Integer countByExample(OrderCouponInfoExample orderCouponInfoExample);

    public List<OrderCouponInfo> selectByExample(OrderCouponInfoExample orderCouponInfoExample);

    public OrderCouponInfo selectByPrimaryKey(OrderCouponInfoKey orderCouponInfoKey);

    public Integer deleteByExample(OrderCouponInfoExample orderCouponInfoExample);

    public Integer deleteByPrimaryKey(OrderCouponInfoKey orderCouponInfoKey);

    public Integer insertSelective(OrderCouponInfo orderCouponInfo);

    public Integer updateAllByExample(@Param("record") OrderCouponInfo orderCouponInfo, @Param("example") OrderCouponInfoExample orderCouponInfoExample);

    public Integer updateByExampleSelective(@Param("record") OrderCouponInfo orderCouponInfo, @Param("example") OrderCouponInfoExample orderCouponInfoExample);

    public Integer updateByPrimaryKeySelective(OrderCouponInfo orderCouponInfo);

}
