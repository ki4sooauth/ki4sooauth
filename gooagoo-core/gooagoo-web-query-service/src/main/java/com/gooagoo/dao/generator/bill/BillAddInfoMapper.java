package com.gooagoo.dao.generator.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.BillAddInfo;
import com.gooagoo.entity.generator.bill.BillAddInfoExample;
import com.gooagoo.entity.generator.bill.BillAddInfoKey;

public interface BillAddInfoMapper
{

    public Integer countByExample(BillAddInfoExample billAddInfoExample);

    public List<BillAddInfo> selectByExample(BillAddInfoExample billAddInfoExample);

    public BillAddInfo selectByPrimaryKey(BillAddInfoKey billAddInfoKey);

}
