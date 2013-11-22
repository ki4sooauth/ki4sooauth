package com.gooagoo.dao.generator.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.UserOrderDetail;
import com.gooagoo.entity.generator.bill.UserOrderDetailExample;
import com.gooagoo.entity.generator.bill.UserOrderDetailKey;

public interface UserOrderDetailMapper
{

    public Integer countByExample(UserOrderDetailExample userOrderDetailExample);

    public List<UserOrderDetail> selectByExample(UserOrderDetailExample userOrderDetailExample);

    public UserOrderDetail selectByPrimaryKey(UserOrderDetailKey userOrderDetailKey);

}
