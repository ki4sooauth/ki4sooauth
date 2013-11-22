package com.gooagoo.query.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.UserOrderDetailGeneratorQueryService;
import com.gooagoo.entity.generator.bill.UserOrderDetail;
import com.gooagoo.entity.generator.bill.UserOrderDetailExample;
import com.gooagoo.entity.generator.bill.UserOrderDetailKey;
import com.gooagoo.dao.generator.bill.UserOrderDetailMapper;

@Service
public class UserOrderDetailGeneratorQueryServiceImpl implements UserOrderDetailGeneratorQueryService
{

    @Autowired
    private UserOrderDetailMapper userOrderDetailMapper;

    @Override
    public Integer countByExample(UserOrderDetailExample userOrderDetailExample) 
    {
        return this.userOrderDetailMapper.countByExample(userOrderDetailExample);
    }

    @Override
    public List<UserOrderDetail> selectByExample(UserOrderDetailExample userOrderDetailExample) 
    {
        return this.userOrderDetailMapper.selectByExample(userOrderDetailExample);
    }

    @Override
    public UserOrderDetail selectByPrimaryKey(String primaryKey) 
    {
        UserOrderDetailKey userOrderDetailKey = new UserOrderDetailKey();
        userOrderDetailKey.setUserOrderDetailId(primaryKey);
        return this.userOrderDetailMapper.selectByPrimaryKey(userOrderDetailKey);
    }

}
