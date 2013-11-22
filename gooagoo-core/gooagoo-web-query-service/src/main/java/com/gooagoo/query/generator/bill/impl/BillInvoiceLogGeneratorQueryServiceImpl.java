package com.gooagoo.query.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.BillInvoiceLogGeneratorQueryService;
import com.gooagoo.entity.generator.bill.BillInvoiceLog;
import com.gooagoo.entity.generator.bill.BillInvoiceLogExample;
import com.gooagoo.entity.generator.bill.BillInvoiceLogKey;
import com.gooagoo.dao.generator.bill.BillInvoiceLogMapper;

@Service
public class BillInvoiceLogGeneratorQueryServiceImpl implements BillInvoiceLogGeneratorQueryService
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

}
