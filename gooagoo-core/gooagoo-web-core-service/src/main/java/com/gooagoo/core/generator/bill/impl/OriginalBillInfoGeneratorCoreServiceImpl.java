package com.gooagoo.core.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.bill.OriginalBillInfoGeneratorCoreService;
import com.gooagoo.entity.generator.bill.OriginalBillInfo;
import com.gooagoo.entity.generator.bill.OriginalBillInfoExample;
import com.gooagoo.entity.generator.bill.OriginalBillInfoKey;
import com.gooagoo.dao.generator.bill.OriginalBillInfoMapper;

@Service
public class OriginalBillInfoGeneratorCoreServiceImpl implements OriginalBillInfoGeneratorCoreService
{

    @Autowired
    private OriginalBillInfoMapper originalBillInfoMapper;

    @Override
    public Integer countByExample(OriginalBillInfoExample originalBillInfoExample) 
    {
        return this.originalBillInfoMapper.countByExample(originalBillInfoExample);
    }

    @Override
    public List<OriginalBillInfo> selectByExample(OriginalBillInfoExample originalBillInfoExample) 
    {
        return this.originalBillInfoMapper.selectByExample(originalBillInfoExample);
    }

    @Override
    public OriginalBillInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        OriginalBillInfoKey originalBillInfoKey = new OriginalBillInfoKey();
        originalBillInfoKey.setIsDel("N");
        originalBillInfoKey.setBillId(primaryKey);
        return this.originalBillInfoMapper.selectByPrimaryKey(originalBillInfoKey);
    }

    @Override
    public OriginalBillInfo selectByPrimaryKey(String primaryKey) 
    {
        OriginalBillInfoKey originalBillInfoKey = new OriginalBillInfoKey();
        originalBillInfoKey.setBillId(primaryKey);
        return this.originalBillInfoMapper.selectByPrimaryKey(originalBillInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(OriginalBillInfoExample originalBillInfoExample) 
    {
        return this.originalBillInfoMapper.deleteByExample(originalBillInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        OriginalBillInfoKey originalBillInfoKey = new OriginalBillInfoKey();
        originalBillInfoKey.setBillId(primaryKey);
        return this.originalBillInfoMapper.deleteByPrimaryKey(originalBillInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(OriginalBillInfoExample originalBillInfoExample) 
    {
        OriginalBillInfo originalBillInfo = new OriginalBillInfo();
        originalBillInfo.setIsDel("Y");
        return this.originalBillInfoMapper.updateByExampleSelective(originalBillInfo,originalBillInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        OriginalBillInfo originalBillInfo = new OriginalBillInfo();
        originalBillInfo.setBillId(primaryKey);
        originalBillInfo.setIsDel("Y");
        return this.originalBillInfoMapper.updateByPrimaryKeySelective(originalBillInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(OriginalBillInfo originalBillInfo) 
    {
        return this.originalBillInfoMapper.insertSelective(originalBillInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(OriginalBillInfo originalBillInfo,OriginalBillInfoExample originalBillInfoExample) 
    {
        return this.originalBillInfoMapper.updateByExampleSelective(originalBillInfo,originalBillInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(OriginalBillInfo originalBillInfo) 
    {
        return this.originalBillInfoMapper.updateByPrimaryKeySelective(originalBillInfo) > 0 ? true : false;
    }

}
