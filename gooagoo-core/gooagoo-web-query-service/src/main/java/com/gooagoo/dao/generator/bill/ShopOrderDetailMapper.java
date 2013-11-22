package com.gooagoo.dao.generator.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.ShopOrderDetail;
import com.gooagoo.entity.generator.bill.ShopOrderDetailExample;
import com.gooagoo.entity.generator.bill.ShopOrderDetailKey;

public interface ShopOrderDetailMapper
{

    public Integer countByExample(ShopOrderDetailExample shopOrderDetailExample);

    public List<ShopOrderDetail> selectByExample(ShopOrderDetailExample shopOrderDetailExample);

    public ShopOrderDetail selectByPrimaryKey(ShopOrderDetailKey shopOrderDetailKey);

}
