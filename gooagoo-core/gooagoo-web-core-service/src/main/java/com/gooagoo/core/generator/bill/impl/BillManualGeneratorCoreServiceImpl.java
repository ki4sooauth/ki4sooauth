package com.gooagoo.core.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.bill.BillManualGeneratorCoreService;
import com.gooagoo.entity.generator.bill.BillManual;
import com.gooagoo.entity.generator.bill.BillManualExample;
import com.gooagoo.entity.generator.bill.BillManualKey;
import com.gooagoo.dao.generator.bill.BillManualMapper;

@Service
public class BillManualGeneratorCoreServiceImpl implements BillManualGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(BillManualExample billManualExample) 
    {
        return this.billManualMapper.deleteByExample(billManualExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        BillManualKey billManualKey = new BillManualKey();
        billManualKey.setBillId(primaryKey);
        return this.billManualMapper.deleteByPrimaryKey(billManualKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(BillManualExample billManualExample) 
    {
        BillManual billManual = new BillManual();
        billManual.setIsDel("Y");
        return this.billManualMapper.updateByExampleSelective(billManual,billManualExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        BillManual billManual = new BillManual();
        billManual.setBillId(primaryKey);
        billManual.setIsDel("Y");
        return this.billManualMapper.updateByPrimaryKeySelective(billManual) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(BillManual billManual) 
    {
        return this.billManualMapper.insertSelective(billManual) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(BillManual billManual,BillManualExample billManualExample) 
    {
        return this.billManualMapper.updateByExampleSelective(billManual,billManualExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(BillManual billManual) 
    {
        return this.billManualMapper.updateByPrimaryKeySelective(billManual) > 0 ? true : false;
    }

}
