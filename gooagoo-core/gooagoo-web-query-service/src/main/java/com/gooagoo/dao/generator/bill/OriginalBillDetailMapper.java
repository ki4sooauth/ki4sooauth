package com.gooagoo.dao.generator.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.OriginalBillDetail;
import com.gooagoo.entity.generator.bill.OriginalBillDetailExample;
import com.gooagoo.entity.generator.bill.OriginalBillDetailKey;

public interface OriginalBillDetailMapper
{

    public Integer countByExample(OriginalBillDetailExample originalBillDetailExample);

    public List<OriginalBillDetail> selectByExample(OriginalBillDetailExample originalBillDetailExample);

    public OriginalBillDetail selectByPrimaryKey(OriginalBillDetailKey originalBillDetailKey);

}
