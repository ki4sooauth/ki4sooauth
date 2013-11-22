package com.gooagoo.core.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.user.ConsigneeInfoGeneratorCoreService;
import com.gooagoo.entity.generator.user.ConsigneeInfo;
import com.gooagoo.entity.generator.user.ConsigneeInfoExample;
import com.gooagoo.entity.generator.user.ConsigneeInfoKey;
import com.gooagoo.dao.generator.user.ConsigneeInfoMapper;

@Service
public class ConsigneeInfoGeneratorCoreServiceImpl implements ConsigneeInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ConsigneeInfoExample consigneeInfoExample) 
    {
        return this.consigneeInfoMapper.deleteByExample(consigneeInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ConsigneeInfoKey consigneeInfoKey = new ConsigneeInfoKey();
        consigneeInfoKey.setConsigneeId(primaryKey);
        return this.consigneeInfoMapper.deleteByPrimaryKey(consigneeInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ConsigneeInfoExample consigneeInfoExample) 
    {
        ConsigneeInfo consigneeInfo = new ConsigneeInfo();
        consigneeInfo.setIsDel("Y");
        return this.consigneeInfoMapper.updateByExampleSelective(consigneeInfo,consigneeInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ConsigneeInfo consigneeInfo = new ConsigneeInfo();
        consigneeInfo.setConsigneeId(primaryKey);
        consigneeInfo.setIsDel("Y");
        return this.consigneeInfoMapper.updateByPrimaryKeySelective(consigneeInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ConsigneeInfo consigneeInfo) 
    {
        return this.consigneeInfoMapper.insertSelective(consigneeInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ConsigneeInfo consigneeInfo,ConsigneeInfoExample consigneeInfoExample) 
    {
        return this.consigneeInfoMapper.updateByExampleSelective(consigneeInfo,consigneeInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ConsigneeInfo consigneeInfo) 
    {
        return this.consigneeInfoMapper.updateByPrimaryKeySelective(consigneeInfo) > 0 ? true : false;
    }

}
