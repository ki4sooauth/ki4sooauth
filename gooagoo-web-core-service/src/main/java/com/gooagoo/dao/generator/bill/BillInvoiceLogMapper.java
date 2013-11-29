package com.gooagoo.dao.generator.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.bill.BillInvoiceLog;
import com.gooagoo.entity.generator.bill.BillInvoiceLogExample;
import com.gooagoo.entity.generator.bill.BillInvoiceLogKey;

public interface BillInvoiceLogMapper
{

    public Integer countByExample(BillInvoiceLogExample billInvoiceLogExample);

    public List<BillInvoiceLog> selectByExample(BillInvoiceLogExample billInvoiceLogExample);

    public BillInvoiceLog selectByPrimaryKey(BillInvoiceLogKey billInvoiceLogKey);

    public Integer deleteByExample(BillInvoiceLogExample billInvoiceLogExample);

    public Integer deleteByPrimaryKey(BillInvoiceLogKey billInvoiceLogKey);

    public Integer insertSelective(BillInvoiceLog billInvoiceLog);

    public Integer updateAllByExample(@Param("record") BillInvoiceLog billInvoiceLog, @Param("example") BillInvoiceLogExample billInvoiceLogExample);

    public Integer updateByExampleSelective(@Param("record") BillInvoiceLog billInvoiceLog, @Param("example") BillInvoiceLogExample billInvoiceLogExample);

    public Integer updateByPrimaryKeySelective(BillInvoiceLog billInvoiceLog);

}
