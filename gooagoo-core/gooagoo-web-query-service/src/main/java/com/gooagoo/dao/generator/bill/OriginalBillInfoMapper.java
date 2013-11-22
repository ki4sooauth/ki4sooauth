package com.gooagoo.dao.generator.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.OriginalBillInfo;
import com.gooagoo.entity.generator.bill.OriginalBillInfoExample;
import com.gooagoo.entity.generator.bill.OriginalBillInfoKey;

public interface OriginalBillInfoMapper
{

    public Integer countByExample(OriginalBillInfoExample originalBillInfoExample);

    public List<OriginalBillInfo> selectByExample(OriginalBillInfoExample originalBillInfoExample);

    public OriginalBillInfo selectByPrimaryKey(OriginalBillInfoKey originalBillInfoKey);

}
