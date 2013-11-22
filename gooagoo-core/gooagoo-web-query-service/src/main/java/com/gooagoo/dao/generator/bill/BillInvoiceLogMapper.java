package com.gooagoo.dao.generator.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.BillInvoiceLog;
import com.gooagoo.entity.generator.bill.BillInvoiceLogExample;
import com.gooagoo.entity.generator.bill.BillInvoiceLogKey;

public interface BillInvoiceLogMapper
{

    public Integer countByExample(BillInvoiceLogExample billInvoiceLogExample);

    public List<BillInvoiceLog> selectByExample(BillInvoiceLogExample billInvoiceLogExample);

    public BillInvoiceLog selectByPrimaryKey(BillInvoiceLogKey billInvoiceLogKey);

}
