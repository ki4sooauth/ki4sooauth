package com.gooagoo.query.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.BillManualGeneratorQueryService;
import com.gooagoo.entity.generator.bill.BillManual;
import com.gooagoo.entity.generator.bill.BillManualExample;
import com.gooagoo.entity.generator.bill.BillManualKey;
import com.gooagoo.dao.generator.bill.BillManualMapper;

@Service
public class BillManualGeneratorQueryServiceImpl implements BillManualGeneratorQueryService
{

    @Autowired
    private BillManualMapper billManualMapper;

    @Override
    public Integer countByExample(BillManualExample billManualExample) 
    {
        return this.billManualMapper.countByExample(billManualExample);
    }

    @Override
    public List<BillManual> selectByExample(BillManualExample billManualExample) 
    {
        return this.billManualMapper.selectByExample(billManualExample);
    }

    @Override
    public BillManual selectUnDelByPrimaryKey(String primaryKey) 
    {
        BillManualKey billManualKey = new BillManualKey();
        billManualKey.setIsDel("N");
        billManualKey.setBillId(primaryKey);
        return this.billManualMapper.selectByPrimaryKey(billManualKey);
    }

    @Override
    public BillManual selectByPrimaryKey(String primaryKey) 
    {
        BillManualKey billManualKey = new BillManualKey();
        billManualKey.setBillId(primaryKey);
        return this.billManualMapper.selectByPrimaryKey(billManualKey);
    }

}
