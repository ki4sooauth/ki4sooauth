package com.gooagoo.core.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.bill.UserOrderInfoGeneratorCoreService;
import com.gooagoo.entity.generator.bill.UserOrderInfo;
import com.gooagoo.entity.generator.bill.UserOrderInfoExample;
import com.gooagoo.entity.generator.bill.UserOrderInfoKey;
import com.gooagoo.dao.generator.bill.UserOrderInfoMapper;

@Service
public class UserOrderInfoGeneratorCoreServiceImpl implements UserOrderInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(UserOrderInfoExample userOrderInfoExample) 
    {
        return this.userOrderInfoMapper.deleteByExample(userOrderInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        UserOrderInfoKey userOrderInfoKey = new UserOrderInfoKey();
        userOrderInfoKey.setUserOrderId(primaryKey);
        return this.userOrderInfoMapper.deleteByPrimaryKey(userOrderInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(UserOrderInfo userOrderInfo) 
    {
        return this.userOrderInfoMapper.insertSelective(userOrderInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(UserOrderInfo userOrderInfo,UserOrderInfoExample userOrderInfoExample) 
    {
        return this.userOrderInfoMapper.updateByExampleSelective(userOrderInfo,userOrderInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserOrderInfo userOrderInfo) 
    {
        return this.userOrderInfoMapper.updateByPrimaryKeySelective(userOrderInfo) > 0 ? true : false;
    }

}
