package com.gooagoo.query.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.BillPayApplicationGeneratorQueryService;
import com.gooagoo.entity.generator.bill.BillPayApplication;
import com.gooagoo.entity.generator.bill.BillPayApplicationExample;
import com.gooagoo.entity.generator.bill.BillPayApplicationKey;
import com.gooagoo.dao.generator.bill.BillPayApplicationMapper;

@Service
public class BillPayApplicationGeneratorQueryServiceImpl implements BillPayApplicationGeneratorQueryService
{

    @Autowired
    private BillPayApplicationMapper billPayApplicationMapper;

    @Override
    public Integer countByExample(BillPayApplicationExample billPayApplicationExample) 
    {
        return this.billPayApplicationMapper.countByExample(billPayApplicationExample);
    }

    @Override
    public List<BillPayApplication> selectByExample(BillPayApplicationExample billPayApplicationExample) 
    {
        return this.billPayApplicationMapper.selectByExample(billPayApplicationExample);
    }

    @Override
    public BillPayApplication selectUnDelByPrimaryKey(String primaryKey) 
    {
        BillPayApplicationKey billPayApplicationKey = new BillPayApplicationKey();
        billPayApplicationKey.setIsDel("N");
        billPayApplicationKey.setOrderId(primaryKey);
        return this.billPayApplicationMapper.selectByPrimaryKey(billPayApplicationKey);
    }

    @Override
    public BillPayApplication selectByPrimaryKey(String primaryKey) 
    {
        BillPayApplicationKey billPayApplicationKey = new BillPayApplicationKey();
        billPayApplicationKey.setOrderId(primaryKey);
        return this.billPayApplicationMapper.selectByPrimaryKey(billPayApplicationKey);
    }

}
