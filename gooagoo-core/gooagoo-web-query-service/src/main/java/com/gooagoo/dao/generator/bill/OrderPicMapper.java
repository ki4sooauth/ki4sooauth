package com.gooagoo.dao.generator.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.OrderPic;
import com.gooagoo.entity.generator.bill.OrderPicExample;
import com.gooagoo.entity.generator.bill.OrderPicKey;

public interface OrderPicMapper
{

    public Integer countByExample(OrderPicExample orderPicExample);

    public List<OrderPic> selectByExample(OrderPicExample orderPicExample);

    public OrderPic selectByPrimaryKey(OrderPicKey orderPicKey);

}
