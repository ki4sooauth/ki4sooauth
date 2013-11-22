package com.gooagoo.dao.generator.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.BillManual;
import com.gooagoo.entity.generator.bill.BillManualExample;
import com.gooagoo.entity.generator.bill.BillManualKey;

public interface BillManualMapper
{

    public Integer countByExample(BillManualExample billManualExample);

    public List<BillManual> selectByExample(BillManualExample billManualExample);

    public BillManual selectByPrimaryKey(BillManualKey billManualKey);

}
