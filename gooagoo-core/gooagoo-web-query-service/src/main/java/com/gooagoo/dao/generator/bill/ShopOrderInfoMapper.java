package com.gooagoo.dao.generator.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.ShopOrderInfo;
import com.gooagoo.entity.generator.bill.ShopOrderInfoExample;
import com.gooagoo.entity.generator.bill.ShopOrderInfoKey;

public interface ShopOrderInfoMapper
{

    public Integer countByExample(ShopOrderInfoExample shopOrderInfoExample);

    public List<ShopOrderInfo> selectByExample(ShopOrderInfoExample shopOrderInfoExample);

    public ShopOrderInfo selectByPrimaryKey(ShopOrderInfoKey shopOrderInfoKey);

}
