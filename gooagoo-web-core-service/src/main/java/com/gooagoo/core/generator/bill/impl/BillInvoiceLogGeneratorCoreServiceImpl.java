package com.gooagoo.core.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.bill.BillInvoiceLogGeneratorCoreService;
import com.gooagoo.entity.generator.bill.BillInvoiceLog;
import com.gooagoo.entity.generator.bill.BillInvoiceLogExample;
import com.gooagoo.entity.generator.bill.BillInvoiceLogKey;
import com.gooagoo.dao.generator.bill.BillInvoiceLogMapper;

@Service
public class BillInvoiceLogGeneratorCoreServiceImpl implements BillInvoiceLogGeneratorCoreService
{

    @Autowired
    private BillInvoiceLogMapper billInvoiceLogMapper;

    @Override
    public Integer countByExample(BillInvoiceLogExample billInvoiceLogExample) 
    {
        return this.billInvoiceLogMapper.countByExample(billInvoiceLogExample);
    }

    @Override
    public List<BillInvoiceLog> selectByExample(BillInvoiceLogExample billInvoiceLogExample) 
    {
        return this.billInvoiceLogMapper.selectByExample(billInvoiceLogExample);
    }

    @Override
    public BillInvoiceLog selectUnDelByPrimaryKey(String primaryKey) 
    {
        BillInvoiceLogKey billInvoiceLogKey = new BillInvoiceLogKey();
        billInvoiceLogKey.setIsDel("N");
        billInvoiceLogKey.setOrderId(primaryKey);
        return this.billInvoiceLogMapper.selectByPrimaryKey(billInvoiceLogKey);
    }

    @Override
    public BillInvoiceLog selectByPrimaryKey(String primaryKey) 
    {
        BillInvoiceLogKey billInvoiceLogKey = new BillInvoiceLogKey();
        billInvoiceLogKey.setOrderId(primaryKey);
        return this.billInvoiceLogMapper.selectByPrimaryKey(billInvoiceLogKey);
    }

    @Override
    public boolean physicalDeleteByExample(BillInvoiceLogExample billInvoiceLogExample) 
    {
        return this.billInvoiceLogMapper.deleteByExample(billInvoiceLogExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        BillInvoiceLogKey billInvoiceLogKey = new BillInvoiceLogKey();
        billInvoiceLogKey.setOrderId(primaryKey);
        return this.billInvoiceLogMapper.deleteByPrimaryKey(billInvoiceLogKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(BillInvoiceLogExample billInvoiceLogExample) 
    {
        BillInvoiceLog billInvoiceLog = new BillInvoiceLog();
        billInvoiceLog.setIsDel("Y");
        return this.billInvoiceLogMapper.updateByExampleSelective(billInvoiceLog,billInvoiceLogExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        BillInvoiceLog billInvoiceLog = new BillInvoiceLog();
        billInvoiceLog.setOrderId(primaryKey);
        billInvoiceLog.setIsDel("Y");
        return this.billInvoiceLogMapper.updateByPrimaryKeySelective(billInvoiceLog) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(BillInvoiceLog billInvoiceLog) 
    {
        return this.billInvoiceLogMapper.insertSelective(billInvoiceLog) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(BillInvoiceLog billInvoiceLog,BillInvoiceLogExample billInvoiceLogExample) 
    {
        return this.billInvoiceLogMapper.updateByExampleSelective(billInvoiceLog,billInvoiceLogExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(BillInvoiceLog billInvoiceLog) 
    {
        return this.billInvoiceLogMapper.updateByPrimaryKeySelective(billInvoiceLog) > 0 ? true : false;
    }

}
