package com.gooagoo.dao.generator.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.BillPayApplication;
import com.gooagoo.entity.generator.bill.BillPayApplicationExample;
import com.gooagoo.entity.generator.bill.BillPayApplicationKey;

public interface BillPayApplicationMapper
{

    public Integer countByExample(BillPayApplicationExample billPayApplicationExample);

    public List<BillPayApplication> selectByExample(BillPayApplicationExample billPayApplicationExample);

    public BillPayApplication selectByPrimaryKey(BillPayApplicationKey billPayApplicationKey);

}
