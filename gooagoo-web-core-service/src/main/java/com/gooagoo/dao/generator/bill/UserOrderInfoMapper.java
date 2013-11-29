package com.gooagoo.dao.generator.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.bill.UserOrderInfo;
import com.gooagoo.entity.generator.bill.UserOrderInfoExample;
import com.gooagoo.entity.generator.bill.UserOrderInfoKey;

public interface UserOrderInfoMapper
{

    public Integer countByExample(UserOrderInfoExample userOrderInfoExample);

    public List<UserOrderInfo> selectByExample(UserOrderInfoExample userOrderInfoExample);

    public UserOrderInfo selectByPrimaryKey(UserOrderInfoKey userOrderInfoKey);

    public Integer deleteByExample(UserOrderInfoExample userOrderInfoExample);

    public Integer deleteByPrimaryKey(UserOrderInfoKey userOrderInfoKey);

    public Integer insertSelective(UserOrderInfo userOrderInfo);

    public Integer updateAllByExample(@Param("record") UserOrderInfo userOrderInfo, @Param("example") UserOrderInfoExample userOrderInfoExample);

    public Integer updateByExampleSelective(@Param("record") UserOrderInfo userOrderInfo, @Param("example") UserOrderInfoExample userOrderInfoExample);

    public Integer updateByPrimaryKeySelective(UserOrderInfo userOrderInfo);

}
