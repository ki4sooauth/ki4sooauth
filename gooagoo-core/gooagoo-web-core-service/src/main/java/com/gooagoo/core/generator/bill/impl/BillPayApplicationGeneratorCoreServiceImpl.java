package com.gooagoo.core.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.bill.BillPayApplicationGeneratorCoreService;
import com.gooagoo.entity.generator.bill.BillPayApplication;
import com.gooagoo.entity.generator.bill.BillPayApplicationExample;
import com.gooagoo.entity.generator.bill.BillPayApplicationKey;
import com.gooagoo.dao.generator.bill.BillPayApplicationMapper;

@Service
public class BillPayApplicationGeneratorCoreServiceImpl implements BillPayApplicationGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(BillPayApplicationExample billPayApplicationExample) 
    {
        return this.billPayApplicationMapper.deleteByExample(billPayApplicationExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        BillPayApplicationKey billPayApplicationKey = new BillPayApplicationKey();
        billPayApplicationKey.setOrderId(primaryKey);
        return this.billPayApplicationMapper.deleteByPrimaryKey(billPayApplicationKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(BillPayApplicationExample billPayApplicationExample) 
    {
        BillPayApplication billPayApplication = new BillPayApplication();
        billPayApplication.setIsDel("Y");
        return this.billPayApplicationMapper.updateByExampleSelective(billPayApplication,billPayApplicationExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        BillPayApplication billPayApplication = new BillPayApplication();
        billPayApplication.setOrderId(primaryKey);
        billPayApplication.setIsDel("Y");
        return this.billPayApplicationMapper.updateByPrimaryKeySelective(billPayApplication) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(BillPayApplication billPayApplication) 
    {
        return this.billPayApplicationMapper.insertSelective(billPayApplication) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(BillPayApplication billPayApplication,BillPayApplicationExample billPayApplicationExample) 
    {
        return this.billPayApplicationMapper.updateByExampleSelective(billPayApplication,billPayApplicationExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(BillPayApplication billPayApplication) 
    {
        return this.billPayApplicationMapper.updateByPrimaryKeySelective(billPayApplication) > 0 ? true : false;
    }

}
