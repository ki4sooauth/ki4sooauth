package com.gooagoo.core.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.bill.UserOrderDetailGeneratorCoreService;
import com.gooagoo.entity.generator.bill.UserOrderDetail;
import com.gooagoo.entity.generator.bill.UserOrderDetailExample;
import com.gooagoo.entity.generator.bill.UserOrderDetailKey;
import com.gooagoo.dao.generator.bill.UserOrderDetailMapper;

@Service
public class UserOrderDetailGeneratorCoreServiceImpl implements UserOrderDetailGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(UserOrderDetailExample userOrderDetailExample) 
    {
        return this.userOrderDetailMapper.deleteByExample(userOrderDetailExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        UserOrderDetailKey userOrderDetailKey = new UserOrderDetailKey();
        userOrderDetailKey.setUserOrderDetailId(primaryKey);
        return this.userOrderDetailMapper.deleteByPrimaryKey(userOrderDetailKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(UserOrderDetail userOrderDetail) 
    {
        return this.userOrderDetailMapper.insertSelective(userOrderDetail) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(UserOrderDetail userOrderDetail,UserOrderDetailExample userOrderDetailExample) 
    {
        return this.userOrderDetailMapper.updateByExampleSelective(userOrderDetail,userOrderDetailExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserOrderDetail userOrderDetail) 
    {
        return this.userOrderDetailMapper.updateByPrimaryKeySelective(userOrderDetail) > 0 ? true : false;
    }

}
