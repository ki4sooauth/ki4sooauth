package com.gooagoo.dao.generator.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.ShopOrderPic;
import com.gooagoo.entity.generator.bill.ShopOrderPicExample;
import com.gooagoo.entity.generator.bill.ShopOrderPicKey;

public interface ShopOrderPicMapper
{

    public Integer countByExample(ShopOrderPicExample shopOrderPicExample);

    public List<ShopOrderPic> selectByExample(ShopOrderPicExample shopOrderPicExample);

    public ShopOrderPic selectByPrimaryKey(ShopOrderPicKey shopOrderPicKey);

}
