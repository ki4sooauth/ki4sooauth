package com.gooagoo.query.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.OriginalBillInfoGeneratorQueryService;
import com.gooagoo.entity.generator.bill.OriginalBillInfo;
import com.gooagoo.entity.generator.bill.OriginalBillInfoExample;
import com.gooagoo.entity.generator.bill.OriginalBillInfoKey;
import com.gooagoo.dao.generator.bill.OriginalBillInfoMapper;

@Service
public class OriginalBillInfoGeneratorQueryServiceImpl implements OriginalBillInfoGeneratorQueryService
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

}
