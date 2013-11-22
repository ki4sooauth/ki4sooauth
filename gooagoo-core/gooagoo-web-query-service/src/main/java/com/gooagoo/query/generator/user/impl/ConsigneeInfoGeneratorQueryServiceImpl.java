package com.gooagoo.query.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.user.ConsigneeInfoGeneratorQueryService;
import com.gooagoo.entity.generator.user.ConsigneeInfo;
import com.gooagoo.entity.generator.user.ConsigneeInfoExample;
import com.gooagoo.entity.generator.user.ConsigneeInfoKey;
import com.gooagoo.dao.generator.user.ConsigneeInfoMapper;

@Service
public class ConsigneeInfoGeneratorQueryServiceImpl implements ConsigneeInfoGeneratorQueryService
{

    @Autowired
    private ConsigneeInfoMapper consigneeInfoMapper;

    @Override
    public Integer countByExample(ConsigneeInfoExample consigneeInfoExample) 
    {
        return this.consigneeInfoMapper.countByExample(consigneeInfoExample);
    }

    @Override
    public List<ConsigneeInfo> selectByExample(ConsigneeInfoExample consigneeInfoExample) 
    {
        return this.consigneeInfoMapper.selectByExample(consigneeInfoExample);
    }

    @Override
    public ConsigneeInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        ConsigneeInfoKey consigneeInfoKey = new ConsigneeInfoKey();
        consigneeInfoKey.setIsDel("N");
        consigneeInfoKey.setConsigneeId(primaryKey);
        return this.consigneeInfoMapper.selectByPrimaryKey(consigneeInfoKey);
    }

    @Override
    public ConsigneeInfo selectByPrimaryKey(String primaryKey) 
    {
        ConsigneeInfoKey consigneeInfoKey = new ConsigneeInfoKey();
        consigneeInfoKey.setConsigneeId(primaryKey);
        return this.consigneeInfoMapper.selectByPrimaryKey(consigneeInfoKey);
    }

}
