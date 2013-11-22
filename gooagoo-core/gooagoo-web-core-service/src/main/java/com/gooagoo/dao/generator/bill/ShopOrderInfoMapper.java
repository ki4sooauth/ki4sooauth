package com.gooagoo.dao.generator.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.bill.ShopOrderInfo;
import com.gooagoo.entity.generator.bill.ShopOrderInfoExample;
import com.gooagoo.entity.generator.bill.ShopOrderInfoKey;

public interface ShopOrderInfoMapper
{

    public Integer countByExample(ShopOrderInfoExample shopOrderInfoExample);

    public List<ShopOrderInfo> selectByExample(ShopOrderInfoExample shopOrderInfoExample);

    public ShopOrderInfo selectByPrimaryKey(ShopOrderInfoKey shopOrderInfoKey);

    public Integer deleteByExample(ShopOrderInfoExample shopOrderInfoExample);

    public Integer deleteByPrimaryKey(ShopOrderInfoKey shopOrderInfoKey);

    public Integer insertSelective(ShopOrderInfo shopOrderInfo);

    public Integer updateAllByExample(@Param("record") ShopOrderInfo shopOrderInfo, @Param("example") ShopOrderInfoExample shopOrderInfoExample);

    public Integer updateByExampleSelective(@Param("record") ShopOrderInfo shopOrderInfo, @Param("example") ShopOrderInfoExample shopOrderInfoExample);

    public Integer updateByPrimaryKeySelective(ShopOrderInfo shopOrderInfo);

}
