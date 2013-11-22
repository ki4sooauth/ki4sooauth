package com.gooagoo.dao.generator.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.UserOrderInfo;
import com.gooagoo.entity.generator.bill.UserOrderInfoExample;
import com.gooagoo.entity.generator.bill.UserOrderInfoKey;

public interface UserOrderInfoMapper
{

    public Integer countByExample(UserOrderInfoExample userOrderInfoExample);

    public List<UserOrderInfo> selectByExample(UserOrderInfoExample userOrderInfoExample);

    public UserOrderInfo selectByPrimaryKey(UserOrderInfoKey userOrderInfoKey);

}
