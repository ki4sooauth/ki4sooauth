package com.gooagoo.query.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.UserOrderInfoGeneratorQueryService;
import com.gooagoo.entity.generator.bill.UserOrderInfo;
import com.gooagoo.entity.generator.bill.UserOrderInfoExample;
import com.gooagoo.entity.generator.bill.UserOrderInfoKey;
import com.gooagoo.dao.generator.bill.UserOrderInfoMapper;

@Service
public class UserOrderInfoGeneratorQueryServiceImpl implements UserOrderInfoGeneratorQueryService
{

    @Autowired
    private UserOrderInfoMapper userOrderInfoMapper;

    @Override
    public Integer countByExample(UserOrderInfoExample userOrderInfoExample) 
    {
        return this.userOrderInfoMapper.countByExample(userOrderInfoExample);
    }

    @Override
    public List<UserOrderInfo> selectByExample(UserOrderInfoExample userOrderInfoExample) 
    {
        return this.userOrderInfoMapper.selectByExample(userOrderInfoExample);
    }

    @Override
    public UserOrderInfo selectByPrimaryKey(String primaryKey) 
    {
        UserOrderInfoKey userOrderInfoKey = new UserOrderInfoKey();
        userOrderInfoKey.setUserOrderId(primaryKey);
        return this.userOrderInfoMapper.selectByPrimaryKey(userOrderInfoKey);
    }

}
