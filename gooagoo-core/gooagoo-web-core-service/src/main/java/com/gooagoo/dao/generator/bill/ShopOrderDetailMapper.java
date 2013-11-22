package com.gooagoo.dao.generator.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.bill.ShopOrderDetail;
import com.gooagoo.entity.generator.bill.ShopOrderDetailExample;
import com.gooagoo.entity.generator.bill.ShopOrderDetailKey;

public interface ShopOrderDetailMapper
{

    public Integer countByExample(ShopOrderDetailExample shopOrderDetailExample);

    public List<ShopOrderDetail> selectByExample(ShopOrderDetailExample shopOrderDetailExample);

    public ShopOrderDetail selectByPrimaryKey(ShopOrderDetailKey shopOrderDetailKey);

    public Integer deleteByExample(ShopOrderDetailExample shopOrderDetailExample);

    public Integer deleteByPrimaryKey(ShopOrderDetailKey shopOrderDetailKey);

    public Integer insertSelective(ShopOrderDetail shopOrderDetail);

    public Integer updateAllByExample(@Param("record") ShopOrderDetail shopOrderDetail, @Param("example") ShopOrderDetailExample shopOrderDetailExample);

    public Integer updateByExampleSelective(@Param("record") ShopOrderDetail shopOrderDetail, @Param("example") ShopOrderDetailExample shopOrderDetailExample);

    public Integer updateByPrimaryKeySelective(ShopOrderDetail shopOrderDetail);

}
